package com.jn.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.activity.dao.ActivityDetailsMapper;
import com.jn.activity.dao.ActivityMapper;
import com.jn.activity.dao.TbActivityDetailMapper;
import com.jn.activity.dao.TbActivityMapper;
import com.jn.activity.entity.TbActivity;
import com.jn.activity.entity.TbActivityCriteria;
import com.jn.activity.entity.TbActivityDetail;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.model.Activity;
import com.jn.activity.model.ActivityDetail;
import com.jn.activity.service.ActivityService;
import com.jn.activity.vo.ActivityDetailVO;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.DateUtils;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;

import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public ActivityDetail getActivityDetailsForManage(String activityId){
        List<ActivityDetail> activityDetails = activityDetailsMapper.getActivityDetails(activityId);
        if(null == activityDetails||activityDetails.size()>0){
            logger.warn("[活动详情],查询活动详情失败，activityId: {},查询响应条数{}", activityId,activityDetails==null?0:activityDetails.size());
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_RESUT_ERROR);
        }
        return activityDetails.get(0);
    }

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

    @Override
    public int insterOrUpdateActivity(Activity activity){

        if(null == activity.getActiOrder()){
            //如果排序为空，默认值为0.
            activity.setActiOrder(0);
        }
        try{
            Date actiStartDate = DateUtils.parseDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
            Date actiEndDate = DateUtils.parseDate(activity.getActiEndTime(), "yyyy-MM-dd HH:mm:ss");
            Date actiApplyEndDate = DateUtils.parseDate(activity.getApplyEndTime(), "yyyy-MM-dd HH:mm:ss");
            if(actiStartDate.before(actiEndDate)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_ERROR);
            }
            if(actiApplyEndDate.after(actiStartDate)){
                throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR);
            }
        }catch (ParseException e){
            throw new JnSpringCloudException(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR);
        }

        //TODO ---调用定时器发送消息
        //TODO ---调用定时器修改活动状态

        TbActivity tbActivity = new TbActivity();
        BeanUtils.copyProperties(activity,tbActivity);
        TbActivityDetail tbActivityDetail = new TbActivityDetail();
        tbActivityDetail.setActiDetail(activity.getActiDetail());
        int num = 0 ;
        if(StringUtils.isEmpty(activity.getId())){
            //新增
            tbActivity.setId(UUID.randomUUID().toString());
            num = tbActivityMapper.insert(tbActivity);
            tbActivityDetail.setActivityId(tbActivity.getId());
            tbActivityDetailMapper.insert(tbActivityDetail);
        }else{
            //修改
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



}
