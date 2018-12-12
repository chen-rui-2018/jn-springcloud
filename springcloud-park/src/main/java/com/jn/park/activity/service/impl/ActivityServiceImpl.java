package com.jn.park.activity.service.impl;

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
import com.jn.park.model.ActivitySlim;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.enums.ActivityExceptionEnum;
import com.jn.park.model.Activity;
import com.jn.park.model.ActivityDetail;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
     * 活动发布
     */
    private static final String ACTIVITY_STATE_PUBLISH = "2";

    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(ActivityServiceImpl.class);

    @ServiceLog(doAction = "查询活动列表")
    @Override
    public PaginationData selectActivityList(Activity activity){
        Page<Object> objects = PageHelper.startPage(activity.getPage(), activity.getRows() == 0?15:activity.getRows());
            List<Activity> activities = activityMapper.selectActivityList(activity);
            PaginationData data = new PaginationData(activities, objects.getTotal());
        return data;
    }

    @ServiceLog(doAction = "查询活动详情")
    @Override
    public ActivityDetail getActivityDetailsForManage(String activityId){
        List<ActivityDetail> activityDetails = activityDetailsMapper.getActivityDetails(activityId);
        if(null == activityDetails||activityDetails.size()==0){
            logger.warn("[活动详情],查询活动详情失败，activityId: {},查询响应条数{}", activityId,activityDetails==null?0:activityDetails.size());
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_RESUT_ERROR);
        }
        return activityDetails.get(0);
    }

    @ServiceLog(doAction = "修改活动报名状态")
    @Override
    public int updateActivityApply(String activityId, String state){
        if(StringUtils.equals(state,ACTIVITY_STATE_FALSE)|| StringUtils.equals(state,ACTIVITY_STATE_TRUE)){
            TbActivity activity = new TbActivity();
            activity.setId(activityId);
            activity.setIsApply(state);
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
    public int insertOrUpdateActivity(Activity activity,String account){

        if(null == activity.getActiOrder()){
            //如果排序为空，默认值为0.
            activity.setActiOrder(0);
        }
        TbActivity tbActivity = new TbActivity();
        BeanUtils.copyProperties(activity,tbActivity);
        if(StringUtils.equals(ACTIVITY_STATE_PUBLISH,activity.getState())){
            try{
                Date actiStartDate = DateUtils.parseDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
                Date actiEndDate = DateUtils.parseDate(activity.getActiEndTime(), "yyyy-MM-dd HH:mm:ss");
                Date actiApplyEndDate = DateUtils.parseDate(activity.getApplyEndTime(), "yyyy-MM-dd HH:mm:ss");
                if(actiEndDate.before(actiStartDate)){
                    throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_ERROR);
                }
                if(actiApplyEndDate.after(actiStartDate)){
                    throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR);
                }
            }catch (ParseException e){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR);
            }

            //TODO jiangyl 调用定时器发送消息
            //TODO jiangyl 调用定时器修改活动状态

            tbActivity.setApplyStartTime(DateUtils.parseDate(activity.getApplyStartTime()));
            tbActivity.setApplyEndTime(DateUtils.parseDate(activity.getApplyEndTime()));
            tbActivity.setActiStartTime(DateUtils.parseDate(activity.getActiStartTime()));
            tbActivity.setActiEndTime(DateUtils.parseDate(activity.getActiEndTime()));
            tbActivity.setMesSendTime(DateUtils.parseDate(activity.getMesSendTime()));
            tbActivity.setIssueTime(DateUtils.parseDate(activity.getIssueTime()));
        }

        TbActivityDetail tbActivityDetail = new TbActivityDetail();
        tbActivityDetail.setActiDetail(activity.getActiDetail());
        int num = 0 ;
        if(StringUtils.isEmpty(activity.getId())){
            //新增
            tbActivity.setCreateTime(new Date());
            tbActivity.setId(UUID.randomUUID().toString());
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
            if(StringUtils.equals(tbActivity1.getState(),ACTIVITY_STATE_DRAFT)){

                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT);
            }
            num = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            tbActivityDetailMapper.updateByPrimaryKeySelective(tbActivityDetail);
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
        for(int a=0;a<tbActivities.size();a++){
            //校验是否有非草稿数据
            if(!StringUtils.equals(tbActivities.get(a).getState(),ACTIVITY_STATE_DRAFT)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR);
            }
        }
        TbActivity tbActivity1 = new TbActivity();
        tbActivity1.setId(activityId);
        tbActivity1.setUpdateTime(new Date());
        tbActivity1.setState("5");
        int i1 = tbActivityMapper.updateByExample(tbActivity1, tbActivityCriteria);
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
        tbActivity.setId(activityId);
        tbActivity.setState("5");
        tbActivity.setUpdateTime(new Date());
        int i1 = tbActivityMapper.updateByExample(tbActivity, tbActivityCriteria);
        if(i1>0){
           return i1;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR);
        }
    }

    @ServiceLog(doAction = "取消活动")
    @Override
    public int cancelActivity(String activityId){
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setState("4");
        int i = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        if(i>0){
            return i;
        }else{
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_CANCEL_ERROR);
        }
    }
    @ServiceLog(doAction = "前台简单活动列表")
    @Override
    public PaginationData activityListSlim(String typeId, com.jn.common.model.Page page, String keyWord) {
        int pageNumber = page.getPage();
        int pageSize = page.getRows()==0?15:page.getRows();
        Page<Object> objects= PageHelper.startPage(pageNumber, pageSize, true);
        List<ActivitySlim> activitySlimList=activityMapper.activityListSlim(typeId,keyWord);
        return new PaginationData(activitySlimList,objects.getTotal());
    }

    @ServiceLog(doAction = "推动活动消息")
    @Override
    public int sendMsgForActivate(String activityId){
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(activityId);
        if(null == tbActivity){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_NOT_EXIST);
        }
        //判断是否为活动开始前24小时之内
        Date actiStartTime = tbActivity.getActiStartTime();
        Date nowDate = new Date();
        Date date = DateUtils.addHours(nowDate, 24);
        if(actiStartTime.before(date)||nowDate.before(actiStartTime)){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_SEND_MSG_TIME_EXPEPTION);
        }else{
            //TODO jiangyl 调用消息接口推送消息。

        }
        return 0;
    }


}
