package com.jn.park.activity.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.ActivityDetailsMapper;
import com.jn.park.activity.dao.ActivityMapper;
import com.jn.park.activity.dao.TbActivityDetailMapper;
import com.jn.park.activity.dao.TbActivityMapper;
import com.jn.park.activity.entity.TbActivity;
import com.jn.park.activity.entity.TbActivityCriteria;
import com.jn.park.activity.entity.TbActivityDetail;
import com.jn.park.model.*;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.send.api.DelaySendMessageClient;
import com.jn.send.model.Delay;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.jn.park.parkcode.entity.TbParkCode;
import com.jn.park.parkcode.service.ParkCodeService;

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
     * 活动发布 - 报名中
     */
    private static final String ACTIVITY_STATE_PUBLISH = "2";

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(ActivityServiceImpl.class);

    @ServiceLog(doAction = "查询活动列表")
    @Override
    public PaginationData selectActivityList(ActivityParment activityParment){
        Page<Object> objects = PageHelper.startPage(activityParment.getPage(),activityParment.getRows()==0?15:activityParment.getRows());
        ActivityContent activity = new ActivityContent();
        BeanUtils.copyProperties(activityParment,activity);
        List<Activity> activities = activityMapper.selectActivityList(activity);
        for(Activity at :activities){
            String actiStartTime = at.getActiStartTime();
            Date date = DateUtils.parseDate(actiStartTime);
            Date nowDate = new Date();
            if(DateUtils.addHours(nowDate,24).after(date)&&nowDate.before(date)&&StringUtils.equals(at.getStatus(),ACTIVITY_STATE_PUBLISH)){
                at.setIsSendMessage("1");
            }else{
                at.setIsSendMessage("0");
            }
        }
        PaginationData data = new PaginationData(activities, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询活动详情")
    @Override
    public ActivityDetail getActivityDetailsForManage(String activityId){
        List<ActivityDetail> activityDetails = activityDetailsMapper.getActivityDetails(activityId);
        if(null == activityDetails||activityDetails.size()==0){
            logger.warn("[活动详情],查询活动详情失败，activityId: {},查询响应条数{}", activityId,activityDetails==null?0:activityDetails.size());
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_RESULT_ERROR);
        }
        List<TbParkCode> parkCodeByType = parkCodeService.getParkCodeByType("parkName");
        ActivityDetail activityDetail = activityDetails.get(0);
        activityDetail.setParkCodes(parkCodeByType);
        return activityDetail;
    }

    @ServiceLog(doAction = "修改活动报名状态")
    @Override
    public int updateActivityApply( ActivitySataus activitySataus){
        if(StringUtils.equals(activitySataus.getStatus(),ACTIVITY_STATE_FALSE)|| StringUtils.equals(activitySataus.getStatus(),ACTIVITY_STATE_TRUE)){
            TbActivity activity = new TbActivity();
            activity.setId(activitySataus.getActivityId());
            activity.setIsApply(activitySataus.getStatus());
            int i = tbActivityMapper.updateByPrimaryKeySelective(activity);
            if(i==1){
               return i;
            }else{
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_UPDATE_ERROR);
            }
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_ERROR);
        }
    }

    @ServiceLog(doAction = "新增/修改活动")
    @Override
    public int insertOrUpdateActivity(ActivityContent activity, String account){
        if(null == activity.getActiOrder()){
            //如果排序为空，默认值为0.
            activity.setActiOrder(0);
        }
        TbActivity tbActivity = new TbActivity();
        BeanUtils.copyProperties(activity,tbActivity);
        try{
            Date actiStartDate = null ;
            Date actiEndDate = null ;
            Date actiApplyEndDate = null ;
            if(StringUtils.isNotEmpty(activity.getActiStartTime())){
                actiStartDate = DateUtils.parseDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setActiStartTime(actiStartDate);
            }
            if(StringUtils.isNotEmpty(activity.getActiEndTime())){
                actiEndDate = DateUtils.parseDate(activity.getActiEndTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setActiEndTime(actiEndDate);
            }
            if(StringUtils.isNotEmpty(activity.getApplyEndTime())){
                actiApplyEndDate = DateUtils.parseDate(activity.getApplyEndTime(), "yyyy-MM-dd HH:mm:ss");
                tbActivity.setApplyEndTime(actiApplyEndDate);
            }
            if(actiStartDate!=null && actiEndDate!=null && actiEndDate.before(actiStartDate)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_ERROR);
            }
            if(null !=actiStartDate && null!= actiApplyEndDate && actiApplyEndDate.after(actiStartDate)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR);
            }
            if(StringUtils.isNotEmpty(activity.getMesSendTime())){
                tbActivity.setMesSendTime(DateUtils.parseDate(activity.getMesSendTime()));
            }
        }catch (ParseException e){
            logger.info("新增活动时间转换失败。失败原因{}",e.getMessage(),e);
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR);
        }
        TbActivityDetail tbActivityDetail = new TbActivityDetail();
        tbActivityDetail.setActiDetail(activity.getActiDetail());
        int num = 0 ;
        Boolean isUpdate = true;
        if(StringUtils.isEmpty(activity.getId())){
            isUpdate = false;
            //新增
            tbActivity.setCreateTime(new Date());
            tbActivity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tbActivity.setCreateAccount(account);
            num = tbActivityMapper.insert(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            tbActivityDetailMapper.insert(tbActivityDetail);
        }else{
            //修改
            tbActivity.setUpdateTime(new Date());
            tbActivity.setUpdateAccount(account);
            TbActivity tbActivity1 = tbActivityMapper.selectByPrimaryKey(activity.getId());
            if(null == tbActivity1){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
            }
            if(StringUtils.equals(tbActivity1.getStatus(),ACTIVITY_STATE_DRAFT)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT);
            }
            num = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            if(StringUtils.isNotEmpty(tbActivityDetail.getActiDetail())){
                tbActivityDetailMapper.updateByPrimaryKeySelective(tbActivityDetail);
            }
        }
        if(StringUtils.equals(ACTIVITY_STATE_PUBLISH,activity.getStatus())){
            //发布时间
            tbActivity.setIssueTime(new Date());
            tbActivity.setApplyStartTime(new Date());
            Delay delay = new Delay();
            delay.setServiceId(applicationName);
            delay.setDateString(activity.getActiStartTime());
            ObjectMapper objectMapper = new ObjectMapper();
            delay.setServiceUrl("/activity/activityEndByTimedTask");
            Boolean getDelay = false;
            if(isUpdate){
                TbActivity activity1 = tbActivityMapper.selectByPrimaryKey(activity.getId());
                if(!DateUtils.isSameDay(activity1.getApplyStartTime(),tbActivity.getApplyStartTime())){
                    getDelay = true;
                }
            }else{
                getDelay = true;
            }
            try{
                String s = objectMapper.writeValueAsString(activity);
                logger.info("调用定时器参数：===>{}",s);
                delay.setDataString(s);
            }catch (JsonProcessingException e){
                logger.error("JsonProcessingException转换异常，停止定时任务调用。",e);
                getDelay = false;
            }
            if(getDelay){
                //调用定时器处理任务状态。
                delaySendMessageClient.delaySend(delay);
                Date actiStartTime = tbActivity.getActiStartTime();
                Date date = DateUtils.addHours(actiStartTime, -24);
                if(date.after(new Date())){
                    delay.setDateString(DateUtils.formatDate(date,"yyyy-MM-dd HH:mm:ss"));
                    delay.setServiceUrl("/activity/activitySendMessageByTimedTask");
                    //调用定时器处理消息推送。
                    delaySendMessageClient.delaySend(delay);
                }else{
                    //活动开始不足24小时，直接推送活动开始通知
                    activitySendMessage(tbActivity.getId(),null);
                }
            }
        }
        return num;
    }

    @ServiceLog(doAction = "删除活动草稿")
    @Override
    public int deleteDraftActivity(String activityId){
        String[] split = activityId.split(",");
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(split));
        List<TbActivity> tbActivities = tbActivityMapper.selectByExample(tbActivityCriteria);
        if(null == tbActivities || tbActivities.size()==0){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_IS_NOT_EXIST_ERROR);
        }
        for(int a=0;a<tbActivities.size();a++){
            //校验是否有非草稿数据
            if(!StringUtils.equals(tbActivities.get(a).getStatus(),ACTIVITY_STATE_DRAFT)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR);
            }
        }
        TbActivity tbActivity1 = new TbActivity();
        tbActivity1.setUpdateTime(new Date());
        tbActivity1.setStatus("5");
        int i1 = tbActivityMapper.updateByExampleSelective(tbActivity1, tbActivityCriteria);
        if(i1>0){
            return i1;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "删除活动（管理员权限）")
    @Override
    public int deleteActivity(String activityId){
        String[] split = activityId.split(",");
         TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(split));
        TbActivity tbActivity = new TbActivity();
        tbActivity.setStatus("5");
        tbActivity.setUpdateTime(new Date());
        int i1 = tbActivityMapper.updateByExampleSelective(tbActivity, tbActivityCriteria);
        if(i1>0){
           return i1;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "取消活动")
    @Override
    public int cancelActivity(String activityId){
        TbActivity activity = tbActivityMapper.selectByPrimaryKey(activityId);
        if(null == activity){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        if(StringUtils.equals(activity.getStatus(),ACTIVITY_STATE_DRAFT)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANCEL_EXPEPTION);
        }
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setStatus("4");
        int i = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        if(i>0){
            return i;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANCEL_ERROR);
        }
    }
    @ServiceLog(doAction = "前台简单活动列表")
    @Override
    public PaginationData activityListSlim(ActivitySlimQuery activitySlimQuery) {

        String typeId = activitySlimQuery.getTypeId();
        String keyWord = activitySlimQuery.getKeyWord();

        int pageSize = activitySlimQuery.getRows() ==0?15:activitySlimQuery.getRows();
        int pageNumber = activitySlimQuery.getPage();
        //是否展示报名人列表 0 否 1 是
        String invalid = "0";
        Page<Object> objects= PageHelper.startPage(pageNumber, pageSize, true);
        List<ActivitySlim> activitySlimList=activityMapper.activityListSlim(typeId,keyWord);
        for(ActivitySlim slim : activitySlimList){
            if(invalid.equals(slim.getShowApplyNum())){
                slim.setAvatar(null);
            }
            if(StringUtils.isNotBlank(slim.getAvatar())){
                slim.setAvatarList(Arrays.asList(slim.getAvatar().split(",")));
            }
        }
        return new PaginationData(activitySlimList,objects.getTotal());
    }

    @ServiceLog(doAction = "推动活动消息")
    @Override
    public int sendMsgForActivate(String activityId){
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(activityId);
        if(null == tbActivity){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        if(!StringUtils.equals(tbActivity.getStatus(),ACTIVITY_STATE_PUBLISH)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_SEND_MSG_EXCEPTION);
        }
        //判断是否为活动开始前24小时之内
        Date actiStartTime = tbActivity.getActiStartTime();
        Date nowDate = new Date();
        Date date = DateUtils.addHours(nowDate, 24);
        if(actiStartTime.after(date)||nowDate.after(actiStartTime)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_SEND_MSG_TIME_EXCEPTION);
        }else{
            return activitySendMessage(activityId,null);
        }
    }

    @ServiceLog(doAction = "活动结束回调方法")
    @Override
    public int activityEndByTimedTask(ActivityContent activity){
        String id = activity.getId();
        if(StringUtils.isEmpty(id)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY);
        }
        TbActivity activity1 = tbActivityMapper.selectByPrimaryKey(id);
        if(null == activity1){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        String actiStartTime = DateUtils.formatDate(activity1.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
        if(StringUtils.equals(actiStartTime,activity.getActiStartTime())){
            TbActivity tbActivity = new TbActivity();
            tbActivity.setId(id );
            tbActivity.setStatus("3");
            return tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        }else{
            logger.info("活动结束时间不匹配，不做业务处理。");
            return 0;
        }
    }

    @ServiceLog(doAction = "活动消息自动推送回调")
    @Override
    public int activitySendMessageByTimedTask(ActivityContent activity){
        return activitySendMessage(activity.getId(),activity.getActiStartTime());
    }

    /**
     * 活动消息发送接口
     * @param activityId
     * @param activityTime 定时器调用时需要传入，以校验是否为正确回调数据。其他情况传null
     * @return
     */
    @ServiceLog(doAction = "活动消息发送接口")
    public int activitySendMessage(String activityId,String activityTime){
        if(StringUtils.isEmpty(activityId)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY);
        }
        TbActivity activity = tbActivityMapper.selectByPrimaryKey(activityId);
        if(null == activity){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        String actiStartTime = DateUtils.formatDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
        if(StringUtils.isEmpty(activityTime)||StringUtils.equals(actiStartTime,activityTime)){
            //TODO jiangyl 调用消息发送接口
            return 1;
        }
        return 0;
    }

}
