package com.jn.park.activity.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.enums.RecordStatusEnum;
import com.jn.park.activity.dao.*;
import com.jn.park.activity.entity.*;
import com.jn.park.activity.model.*;
import com.jn.park.activity.service.ActivityApplyService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.api.MessageClient;
import com.jn.park.enums.ActivityEnum;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.message.model.AddMessageModel;
import com.jn.park.parkcode.service.ParkCodeService;
import com.jn.park.utils.HtmlUtils;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.CompanyParam;
import com.jn.user.model.UserExtensionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.*;

/**
 * @Author: jiangyl
 * @Date: 2018/12/5 17:00
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;
    @Autowired
    private TbActivityMapper tbActivityMapper;
    @Autowired
    private TbActivityDetailMapper tbActivityDetailMapper;
    @Autowired
    private ParkCodeService parkCodeService;
    @Autowired
    private DelaySendMessageClient delaySendMessageClient;
    @Autowired
    private ActivityApplyService activityApplyService;
    @Autowired
    private MessageClient messageClient;

    @Autowired
    private ActivityApplyMapper activityApplyMapper;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private TbActivityApplyMapper tbActivityApplyMapper;

    /**
     * 活动可报名
     */
    private static final String ACTIVITY_STATE_TRUE = "1";
    /**
     * 活动不可报名
     */
    private static final String ACTIVITY_STATE_FALSE = "0";
    /**
     * 活动草稿
     */
    private static final String ACTIVITY_STATE_DRAFT = "1";
    /**
     * 活动发布 - 2报名中 3已结束
     */
    private static final String ACTIVITY_STATE_PUBLISH = "2";
    private static final String ACTIVITY_STATE_FINISH = "3";
    /**
     * 正常数据（1：未删除状态）
     */
    private static final String ACTIVITY_STATE_NOT_DELETE = "1";
    /**
     * 删除数据（0：删除状态）
     */
    private static final String ACTIVITY_STATE_DELETE = "0";

    /**
     * 活动可报名
     */
    private static final String ACTIVITY_STATE_IS_APPLY = "1";

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

    @ServiceLog(doAction = "查询活动列表")
    @Override
    public PaginationData<List<Activity>> selectActivityList(ActivityParment activityParment) {
        Page<Object> objects = PageHelper.startPage(activityParment.getPage(), activityParment.getRows() == 0 ? 15 : activityParment.getRows());
        ActivityContent activity = new ActivityContent();
        BeanUtils.copyProperties(activityParment, activity);
        List<Activity> activities = activityMapper.selectActivityList(activity);
        for (Activity at : activities) {
            String actiStartTime = at.getActiStartTime();
            if(StringUtils.isNotEmpty(actiStartTime)){
                Date date = DateUtils.parseDate(actiStartTime);
                Date nowDate = new Date();
                if (DateUtils.addHours(nowDate, 24).after(date) && nowDate.before(date) && StringUtils.equals(at.getActiStatus(), ACTIVITY_STATE_PUBLISH)) {
                    at.setIsSendMessage("1");
                }
            } else {
                at.setIsSendMessage("0");
            }

        }
        PaginationData<List<Activity>> data = new PaginationData(activities, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询活动详情[后台管理]")
    @Override
    public ActivityDetail getActivityDetailsForManage(String activityId) {
        List<ActivityDetail> activityDetails = activityDetailsMapper.getActivityDetails(activityId);
        if (null == activityDetails || activityDetails.size() == 0) {
            logger.warn("[后台管理-活动详情],查询活动详情失败，activityId: {},查询响应条数{}", activityId, activityDetails == null ? 0 : activityDetails.size());
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_RESULT_ERROR);
        }
        List<ParkCode> parkCodeByType = parkCodeService.getParkCodeByType("parkName");
        ActivityDetail activityDetail = activityDetails.get(0);
        activityDetail.setParkCodes(parkCodeByType);
        return activityDetail;
    }

    @ServiceLog(doAction = "修改活动报名状态")
    @Override
    public int updateActivityApply(ActivityStatus activityStatus) {
        if (StringUtils.equals(activityStatus.getActiStatus(), ACTIVITY_STATE_FALSE) || StringUtils.equals(activityStatus.getActiStatus(), ACTIVITY_STATE_TRUE)) {
            TbActivity activity = new TbActivity();
            activity.setId(activityStatus.getActivityId());
            activity.setIsApply(activityStatus.getActiStatus());
            int i = tbActivityMapper.updateByPrimaryKeySelective(activity);
            if (i == 1) {
                return i;
            } else {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_UPDATE_ERROR);
            }
        } else {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_ERROR);
        }
    }

    @ServiceLog(doAction = "新增/修改活动")
    @Override
    public int insertOrUpdateActivity(ActivityContent activity, String account) {
        if (null == activity.getActiOrder()) {
            //如果排序为空，默认值为0.
            activity.setActiOrder(0);
        }
        TbActivity tbActivity = new TbActivity();
        BeanUtils.copyProperties(activity, tbActivity);
        try {
            Date actiStartDate = null;
            Date actiEndDate = null;
            Date actiApplyEndDate = null;
            if (StringUtils.isNotEmpty(activity.getActiStartTime())) {
                actiStartDate = DateUtils.parseDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setActiStartTime(actiStartDate);
            }
            if (StringUtils.isNotEmpty(activity.getActiEndTime())) {
                actiEndDate = DateUtils.parseDate(activity.getActiEndTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setActiEndTime(actiEndDate);
            }
            if (StringUtils.isNotEmpty(activity.getApplyEndTime())) {
                actiApplyEndDate = DateUtils.parseDate(activity.getApplyEndTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setApplyEndTime(actiApplyEndDate);
            }
            if (actiStartDate != null && actiEndDate != null && actiEndDate.before(actiStartDate)) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_ERROR);
            }
            if (null != actiStartDate && null != actiApplyEndDate && actiApplyEndDate.after(actiStartDate)) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR);
            }
            if (StringUtils.isNotEmpty(activity.getMesSendTime())) {
                tbActivity.setMesSendTime(DateUtils.parseDate(activity.getMesSendTime()));
            }
        } catch (ParseException e) {
            logger.info("新增活动时间转换失败。失败原因{}", e.getMessage(), e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR);
        }
        TbActivityDetail tbActivityDetail = new TbActivityDetail();
        tbActivityDetail.setActiDetail(activity.getActiDetail());
        int num = 0;
        TbActivity tbActivityOld = null;
        Boolean isUpdate = true;
        String activityId = UUID.randomUUID().toString().replaceAll("-", "");
        if (StringUtils.isEmpty(activity.getId())) {
            isUpdate = false;
            activity.setId(activityId);
            //新增
            tbActivity.setActiLike(0);
            tbActivity.setActiViews(0);
            tbActivity.setApplyNum(0);
            tbActivity.setApplyStartTime(new Date());
            tbActivity.setCreatedTime(new Date());
            tbActivity.setId(activityId);
            tbActivity.setCreatorAccount(account);
            tbActivity.setRecordStatus(new Byte(ACTIVITY_STATE_NOT_DELETE));
            if (StringUtils.equals(ACTIVITY_STATE_PUBLISH, tbActivity.getActiStatus())) {
                tbActivity.setIsApply(ACTIVITY_STATE_IS_APPLY);
                tbActivity.setIssueAccount(account);
                tbActivity.setIssueTime(new Date());
            }
            num = tbActivityMapper.insert(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            tbActivityDetailMapper.insert(tbActivityDetail);
        } else {
            //修改
            tbActivity.setModifiedTime(new Date());
            tbActivity.setModifierAccount(account);
            tbActivityOld = tbActivityMapper.selectByPrimaryKey(activity.getId());
            if (null == tbActivityOld) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
            }
            if (!StringUtils.equals(tbActivityOld.getActiStatus(), ACTIVITY_STATE_DRAFT)) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT);
            }
            if (StringUtils.equals(ACTIVITY_STATE_DRAFT, tbActivityOld.getActiStatus()) && StringUtils.equals(ACTIVITY_STATE_PUBLISH, tbActivity.getActiStatus())) {
                tbActivity.setIssueAccount(account);
                tbActivity.setIssueTime(new Date());
            }
            num = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            if (StringUtils.isNotEmpty(tbActivityDetail.getActiDetail())) {
                tbActivityDetailMapper.updateByPrimaryKeySelective(tbActivityDetail);
            }
        }
        // 开始处理活动定时任务
        if (StringUtils.equals(ACTIVITY_STATE_PUBLISH, activity.getActiStatus())) {
            //发布时间
            Delay delay = new Delay();
            delay.setServiceId(applicationName);
            delay.setDateString(activity.getActiStartTime());
            ObjectMapper objectMapper = new ObjectMapper();
            delay.setServiceUrl("/api/activity/activityEndByTimedTask");
            Boolean getDelay = false;
            if (isUpdate) {
                if (tbActivityOld.getActiStartTime()==null || !DateUtils.isSameDay(tbActivityOld.getActiStartTime(), tbActivity.getActiStartTime())) {
                    getDelay = true;
                }
            } else {
                getDelay = true;
            }
            try {
                String s = objectMapper.writeValueAsString(activity);
                logger.info("调用定时器参数：===>{}", s);
                delay.setDataString(s);
            } catch (JsonProcessingException e) {
                logger.error("JsonProcessingException转换异常，停止定时任务调用。", e);
                getDelay = false;
            }
            if (getDelay) {
                //调用定时器处理任务状态。
                delaySendMessageClient.delaySend(delay);
                Date actiStartTime = tbActivity.getActiStartTime();
                Date date = DateUtils.addHours(actiStartTime, -24);
                if (date.after(new Date())) {
                    delay.setDateString(DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss"));
                    delay.setServiceUrl("/api/activity/activitySendMessageByTimedTask");
                    //调用定时器处理消息推送。
                    delaySendMessageClient.delaySend(delay);
                } else {
                    //活动开始不足24小时，直接推送活动开始通知
                    activitySendMessage(tbActivity.getId(), null);
                }
            }
        }
        return num;
    }

    @ServiceLog(doAction = "删除活动草稿")
    @Override
    public int deleteDraftActivity(String[] activityId,String account) {
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(activityId));
        List<TbActivity> tbActivities = tbActivityMapper.selectByExample(tbActivityCriteria);
        if (null == tbActivities || tbActivities.size() == 0) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_IS_NOT_EXIST_ERROR);
        }
        for (TbActivity tbActivity:tbActivities) {
            //校验是否有非草稿数据
            if (!StringUtils.equals(tbActivity.getActiStatus(), ACTIVITY_STATE_DRAFT)) {
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR);
            }
        }
        TbActivity tbActivity1 = new TbActivity();
        tbActivity1.setModifiedTime(new Date());
        tbActivity1.setModifierAccount(account);
        tbActivity1.setRecordStatus(new Byte(ACTIVITY_STATE_DELETE));
        int i1 = tbActivityMapper.updateByExampleSelective(tbActivity1, tbActivityCriteria);
        if (i1 > 0) {
            return i1;
        } else {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "删除活动（管理员权限）")
    @Override
    public int deleteActivity(String[] activityId,String account) {
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(activityId));
        TbActivity tbActivity = new TbActivity();
        tbActivity.setRecordStatus(new Byte(ACTIVITY_STATE_DELETE));
        tbActivity.setModifiedTime(new Date());
        tbActivity.setModifierAccount(account);
        int i1 = tbActivityMapper.updateByExampleSelective(tbActivity, tbActivityCriteria);
        if (i1 > 0) {
            return i1;
        } else {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "取消活动")
    @Override
    public int cancelActivity(String activityId,String account) {
        TbActivity activity = tbActivityMapper.selectByPrimaryKey(activityId);
        if (null == activity) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        if (StringUtils.equals(activity.getActiStatus(), ACTIVITY_STATE_DRAFT)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANCEL_EXPEPTION);
        }
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setActiStatus("4");
        tbActivity.setModifierAccount(account);
        tbActivity.setModifiedTime(new Date());
        int i = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        if (i > 0) {
            return i;
        } else {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANCEL_ERROR);
        }
    }

    @ServiceLog(doAction = "获取前台活动列表")
    @Override
    public PaginationData<List<ActivitySlim>> activityListSlim(ActivitySlimQuery activitySlimQuery ,String account) {

        String typeId = activitySlimQuery.getTypeId();
        String keyWord = activitySlimQuery.getKeyWord();
        String startTime = activitySlimQuery.getStartTime();
        String endTime = activitySlimQuery.getEndTime();
        String orderBy = activitySlimQuery.getOrderBy();
        try {
            if (StringUtils.isNotEmpty(startTime)) {
                DateUtils.parseDate(startTime, "yyyy-MM-dd");
            }
            if (StringUtils.isNotEmpty(endTime)) {
                DateUtils.parseDate(endTime, "yyyy-MM-dd");
            }
        }catch(ParseException e){
            logger.info("活动列表查询失败。失败原因{}", e.getMessage(), e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR2);
        }
        if(StringUtils.isNotEmpty(orderBy)){
            String [] orders = {
                    ActivityEnum.ACTIVITY_ORDER_VIEWS.getCode(),
                    ActivityEnum.ACTIVITY_ORDER_LIKE.getCode(),
                    ActivityEnum.ACTIVITY_ORDER_APPLY.getCode(),
                    ActivityEnum.ACTIVITY_ORDER_PARTIC.getCode(),
                    ActivityEnum.ACTIVITY_ORDER_START_TIME.getCode(),
                    };
            Boolean flag = false;
            for(String order : orders){
                if(orderBy.equals(order)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                orderBy = null;
            }
        }
        int pageSize = activitySlimQuery.getRows() == 0 ? 15 : activitySlimQuery.getRows();
        int pageNumber = activitySlimQuery.getPage();
        List<String> activityIdList = new ArrayList<>();

        //是否展示报名人列表 0 否 1 是
        String invalid = "0";
        Page<Object> objects = PageHelper.startPage(pageNumber, pageSize, true);
        List<ActivitySlim> activitySlimList = activityMapper.activityListSlim(typeId, keyWord, startTime, endTime, orderBy);
        if (activitySlimList != null && activitySlimList.size() > 0) {
            for (ActivitySlim slim : activitySlimList) {
                activityIdList.add(slim.getId());
            }
        }
        //获得活动报名人信息
        List<ActivityApplyDetail> activityApplyList = activityApplyService.findApplyAccountList(activityIdList);
        if (activitySlimList != null && activitySlimList.size() > 0) {
            for (ActivitySlim slim : activitySlimList) {
                //当前登录用户是否已报名此活动 0 否 1 是
                slim.setApplyStatus(ActivityEnum.ACTIVITY_NOT_APPLY.getCode());
                List<String> avatars = new ArrayList<>();
                if (activityApplyList != null && activityApplyList.size() > 0) {
                    for (ActivityApplyDetail detail : activityApplyList) {
                        if (detail.getActivityId().equals(slim.getId())) {
                            //当前活动已报名人的头像列表
                            avatars.add(detail.getAvatar());
                            if(account.equals(detail.getAccount())){
                                slim.setApplyStatus(ActivityEnum.ACTIVITY_IS_APPLY.getCode());
                            }
                        }
                    }
                }
                slim.setAvatarList(avatars);
            }

            //设置是否显示报名人信息
            for (ActivitySlim slim : activitySlimList) {
                if (invalid.equals(slim.getShowApplyNum())) {
                    slim.setAvatar(null);
                }
                if (StringUtils.isNotBlank(slim.getAvatar())) {
                    slim.setAvatarList(Arrays.asList(slim.getAvatar().split(",")));
                }
            }
        }
        activitySlimList =  addActivityBrief(activitySlimList);
        return new PaginationData(activitySlimList, objects.getTotal());
    }

    @ServiceLog(doAction = "推动活动消息")
    @Override
    public int sendMsgForActivate(String activityId) {
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(activityId);
        if (null == tbActivity) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        if (!StringUtils.equals(tbActivity.getActiStatus(), ACTIVITY_STATE_PUBLISH)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_SEND_MSG_EXCEPTION);
        }
        //判断是否为活动开始前24小时之内
        Date actiStartTime = tbActivity.getActiStartTime();
        Date nowDate = new Date();
        Date date = DateUtils.addHours(nowDate, 24);
        if (actiStartTime.after(date) || nowDate.after(actiStartTime)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_SEND_MSG_TIME_EXCEPTION);
        } else {
            return activitySendMessage(activityId, null);
        }
    }

    @ServiceLog(doAction = "活动结束回调方法")
    @Override
    public int activityEndByTimedTask(ActivityContent activity) {
        String id = activity.getId();
        if (StringUtils.isEmpty(id)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY);
        }
        TbActivity activity1 = tbActivityMapper.selectByPrimaryKey(id);
        if (null == activity1) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        String actiStartTime = DateUtils.formatDate(activity1.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
        if (StringUtils.equals(actiStartTime, activity.getActiStartTime())) {
            TbActivity tbActivity = new TbActivity();
            tbActivity.setId(id);
            tbActivity.setActiStatus("3");
            return tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        } else {
            logger.info("活动结束时间不匹配，不做业务处理。");
            return 0;
        }
    }

    @ServiceLog(doAction = "活动消息自动推送回调")
    @Override
    public int activitySendMessageByTimedTask(ActivityContent activity) {
        return activitySendMessage(activity.getId(), activity.getActiStartTime());
    }


    /**
     * 活动消息发送接口
     *
     * @param activityId
     * @param activityTime 定时器调用时需要传入，以校验是否为正确回调数据。其他情况传null
     * @return
     */
    @ServiceLog(doAction = "活动消息发送接口")
    public int activitySendMessage(String activityId, String activityTime) {
        if (StringUtils.isEmpty(activityId)) {
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY);
        }
        TbActivity activity = tbActivityMapper.selectByPrimaryKey(activityId);
        if (null == activity) {
            logger.warn("[活动消息发送接口] 未找到相关活动，activityId：{}", activityId);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        String actiStartTime = DateUtils.formatDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
        if (StringUtils.isEmpty(activityTime) || StringUtils.equals(actiStartTime, activityTime)) {
            // 查询报名人数
            TbActivityApplyCriteria example = new TbActivityApplyCriteria();
            example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                    .andActivityIdEqualTo(activityId).andApplyStatusEqualTo("1");
            List<TbActivityApply> tbActivityApplyList = tbActivityApplyMapper.selectByExample(example);

            // 活动如果有人报名，发送通知
            if (tbActivityApplyList != null && !tbActivityApplyList.isEmpty()) {
                AddMessageModel messageTemplate = new AddMessageModel();
                messageTemplate.setMessageTitle("园区活动提醒");
                messageTemplate.setMessageContent("“" + activity.getActiName()+"” 将于 "+actiStartTime+" 开始，请您准时参加");
                messageTemplate.setMessageSender("system");
                messageTemplate.setMessageOneSort(0);
                messageTemplate.setMessageOneSortName("个人动态");
                messageTemplate.setMessageTowSort(1);
                messageTemplate.setMessageTowSortName("园区通知");
                messageTemplate.setCreatorAccount("system");

                for (TbActivityApply apply : tbActivityApplyList) {
                    AddMessageModel addMessageModel = new AddMessageModel();
                    BeanUtils.copyProperties(messageTemplate, addMessageModel);
                    addMessageModel.setMessageRecipien(apply.getCreatorAccount());
                    Result<String> stringResult = messageClient.addMessage(addMessageModel);
                    logger.info("活动提醒：account：{}，调用消息发送接口,接口返回状态：{}", apply.getCreatorAccount(), stringResult.getCode());
                }
            }
        }
        //查询该活动已报名人员，批量推送。
        //TODO 需调用短信、消息接口主动推送消息。
        return 1;
    }

    /**
     * author chenr
     * @param query
     * @param needPage
     * @return
     */
    @ServiceLog(doAction = "查看用户报名的活动列表")
    @Override
    public PaginationData findActivitySuccessfulRegistration(ActivityApplyListParam query, Boolean needPage) {
        int pageSize = query.getRows() == 0 ? 15 : query.getRows();
        int pageNumber = query.getPage();
        Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(pageNumber,pageSize,true);
        }
        List<ActivityListApply> activityList = activityMapper.findActivitySuccessfulRegistration(query.getAccount(),query.getApplyStatus(),query.getActiName());

        return new PaginationData(activityList,objects==null?0:objects.getTotal());
    }
    @ServiceLog(doAction = "查看机构下的活动列表")
    @Override
    public PaginationData findOrgActivityList(OrgActivityParam query, String activityType,String account, boolean needPage) {
        int pageSize = query.getRows() == 0 ? 15 : query.getRows();
        int pageNumber = query.getPage();
        Page<Object> objects = null;
        if(needPage){
            objects = PageHelper.startPage(pageNumber,pageSize,true);
        }
        List<OrgActivityShow> activityList =  activityMapper.findOrgActivityList(query.getStartTime(),query.getEndTime(),activityType,query.getTimeInterval());
        List<String> activityIdList = new ArrayList<>();
        if (activityList != null && activityList.size() > 0) {
            for (OrgActivityShow slim : activityList) {
                activityIdList.add(slim.getId());
            }
        }
        //获得活动报名人信息
        List<ActivityApplyDetail> activityApplyList = activityApplyService.findApplyAccountList(activityIdList);
        if (activityList != null && activityList.size() > 0) {
            for (OrgActivityShow show : activityList) {
                //当前登录用户是否已报名此活动 0 否 1 是
                show.setApplyStatus(ActivityEnum.ACTIVITY_NOT_APPLY.getCode());
                List<String> avatars = new ArrayList<>();
                if (activityApplyList != null && activityApplyList.size() > 0) {
                    for (ActivityApplyDetail detail : activityApplyList) {
                        if (detail.getActivityId().equals(show.getId())) {
                            //当前活动已报名人的头像列表
                            avatars.add(detail.getAvatar());
                            if (account.equals(detail.getAccount())) {
                                show.setApplyStatus(ActivityEnum.ACTIVITY_IS_APPLY.getCode());
                            }
                        }
                    }
                }
                show.setAvatarList(avatars);
            }
        }
        return new PaginationData(activityList,objects==null?0:objects.getTotal());
    }

    @ServiceLog(doAction = "获取有效活动总数")
    @Override
    public String getActivityNum(){
        TbActivityCriteria activityCriteria = new TbActivityCriteria();
        List<String> sList = new ArrayList<>(16);
        sList.add(ACTIVITY_STATE_PUBLISH);
        sList.add(ACTIVITY_STATE_FINISH);
        activityCriteria.createCriteria().andRecordStatusEqualTo(new Byte(ACTIVITY_STATE_NOT_DELETE)).andActiStatusIn(sList);
        long activityNum = tbActivityMapper.countByExample(activityCriteria);
        return activityNum+"";
    }

    /**
     * 获取企业报报名活动信息
     * @param param
     * @return
     */
    @ServiceLog(doAction = "获取企业报报名活动信息")
    @Override
    public List<CompanyActivityApplyShow> getCompanyActivityApplyInfo(CompanyActivityApplyParam param) {
        //校验开始时间和结束时间
        if(StringUtils.isNotBlank(param.getStartTime()) && StringUtils.isNotBlank(param.getEndTime())){
            int startTime=Integer.parseInt(param.getStartTime().replaceAll("-", ""));
            int endTime= Integer.parseInt(param.getEndTime().replaceAll("-", ""));
            if(startTime>endTime){
                logger.warn("获取企业报报名活动信息异常，开始时间[{}]晚于结束时间[{}]",param.getStartTime(),param.getEndTime());
                throw new JnSpringCloudException(ActivityExceptionEnum.START_TIME_MORE_THAN_END_TIME);
            }
        }
        //查询全部数据
        if(StringUtils.isBlank(param.getCompanyId())){
            return getCompanyActivityApplyShows(param);
        }else{
            //返回指定企业id的数据
            return getPartCompanyActivityApplyShows(param);
        }
    }

    @Override
    @ServiceLog(doAction = "获取累计举办活动总数")
    public Integer getActivityHistoryNum() {
        TbActivityCriteria example = new TbActivityCriteria();
        example.createCriteria().andRecordStatusEqualTo(RecordStatusEnum.EFFECTIVE.getValue())
                .andActiStatusEqualTo(ActivityEnum.ACTIVITY_STATUS_END.getCode());
        Integer activityHistoryNum = (int) tbActivityMapper.countByExample(example);
        return activityHistoryNum;
    }

    /**
     * 查询指定企业编码的数据
     * @param param
     * @return
     */
    @ServiceLog(doAction = "")
    private List<CompanyActivityApplyShow> getPartCompanyActivityApplyShows(CompanyActivityApplyParam param) {
        CompanyParam companyParam=new CompanyParam();
        companyParam.setCompanyCode(param.getCompanyId());
        //不分页
        companyParam.setNeedPage("0");
        Result userInfoList = userExtensionClient.getUserExtensionByCompanyCode(companyParam);
        logger.info("---根据所属企业编码批量获取用户信息成功---");
        if(userInfoList==null || userInfoList.getData()==null){
           return  Collections.emptyList();
        }
        //得到查询出的用户信息
        Map<String,Object> pageData = (Map<String,Object>)userInfoList.getData();
        List<UserExtensionInfo> userExtensionInfoList=new ArrayList<>(16);
        List userList=(List)pageData.get("rows");
        ObjectMapper objectMapper = new ObjectMapper();
        for(int i=0;i<userList.size();i++){
            UserExtensionInfo userExtensionInfo = objectMapper.convertValue(userList.get(i), UserExtensionInfo.class);
            userExtensionInfoList.add(userExtensionInfo);
        }
        //取出查询出的所有账号
        List<String>accountList=new ArrayList<>(16);
        for(UserExtensionInfo userExtensionInfo:userExtensionInfoList){
            accountList.add(userExtensionInfo.getAccount());
        }
        //查询指定企业id的报名信息数据
        List<CompanyActivityApplyShow> applyShowList = activityApplyMapper.getCompanyActivityApplyInfo(param,accountList);
        if(applyShowList.isEmpty()){
            return Collections.emptyList();
        }
        for(UserExtensionInfo userInfo:userExtensionInfoList){
            for(CompanyActivityApplyShow applyShow:applyShowList){
                if(StringUtils.equals(userInfo.getAccount(),applyShow.getApplyAccount())){
                    applyShow.setCompanyId(userInfo.getCompanyCode());
                    applyShow.setCompanyName(userInfo.getCompanyName());
                    applyShow.setApplyName(userInfo.getName());
                }
            }
        }
        return applyShowList;
    }

    /**
     * 查询全部企业报名信息
     * @param param
     * @return
     */
    @ServiceLog(doAction = "查询全部企业报名信息")
    private List<CompanyActivityApplyShow> getCompanyActivityApplyShows(CompanyActivityApplyParam param) {
        List<CompanyActivityApplyShow> applyShowList = activityApplyMapper.getCompanyActivityApplyInfo(param,null);
        if(applyShowList.isEmpty()){
            return Collections.emptyList();
        }
        List<String>accountList=new ArrayList<>(16);
        for(CompanyActivityApplyShow applyShow:applyShowList){
            if(!accountList.contains(applyShow.getApplyAccount())){
                accountList.add(applyShow.getApplyAccount());
            }
        }
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        if(moreUserExtension==null || moreUserExtension.getData()==null){
            return Collections.emptyList();
        }
        List<UserExtensionInfo> userExtensionInfoList = moreUserExtension.getData();
        //返回查询出的全部数据
        for(UserExtensionInfo userInfo:userExtensionInfoList){
            if(StringUtils.isNotBlank(userInfo.getCompanyCode())){
                for(CompanyActivityApplyShow applyShow:applyShowList){
                    if(StringUtils.equals(userInfo.getAccount(),applyShow.getApplyAccount())){
                        applyShow.setCompanyId(userInfo.getCompanyCode());
                        applyShow.setCompanyName(userInfo.getCompanyName());
                        applyShow.setApplyName(userInfo.getName());
                    }
                }
            }
        }
        return applyShowList;
    }

    /**
     * 添加活动详情简介
     * @param activitySlimList
     * @return
     */
    public List<ActivitySlim> addActivityBrief( List<ActivitySlim> activitySlimList){
        for (ActivitySlim show : activitySlimList) {
            String briefContent = show.getActiDetails();
            if(StringUtils.isNotBlank(briefContent)){
                briefContent = HtmlUtils.getBriefIntroduction(briefContent);
                if (StringUtils.isNotBlank(briefContent)) {
                    String briefSummaries = briefContent.substring(0, briefContent.length() > 100 ? 100 : briefContent.length()-1);
                    briefSummaries = briefContent.length() > 100 ? briefSummaries + "......" : briefSummaries;
                    show.setActibrief(briefSummaries);
                }
            }
        }
        return  activitySlimList;
    }
}
