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
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
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
     * 活动发布
     */
    private static final String ACTIVITY_STATE_PUBLISH = "2";
    /**
     * 日志组件
     */
    private static Logger logger= LoggerFactory.getLogger(ActivityServiceImpl.class);

    @ServiceLog(doAction = "查询活动列表")
    @Override
    public Result selectActivityList(Activity activity){
        Page<Object> objects = PageHelper.startPage(activity.getPage(), activity.getRows() == 0?15:activity.getRows());
        Result result = new Result();
        try {
            List<Activity> activities = activityMapper.selectActivityList(activity);
            PaginationData data = new PaginationData(activities, objects.getTotal());
            result.setData(data);
        }catch (Exception e ){
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getMessage());
            logger.error("查询活动列表失败",e);
        }
        return result;
    }

    @Override
    public Result getActivityDetailsForManage(String activityId){
        Result result = new Result();
        if(StringUtils.isEmpty(activityId)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        try {
            List<ActivityDetail> activityDetails = activityDetailsMapper.getActivityDetails(activityId);
            if(null == activityDetails||activityDetails.size()>0){
                result.setCode(ActivityExceptionEnum.ACTIVITY_RESUT_ERROR.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_RESUT_ERROR.getMessage());
                return result;
            }
            result.setData(activityDetails.get(0));
        }catch (Exception e ){
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getCode());
            result.setCode(ActivityExceptionEnum.NETWORK_ANOMALY.getMessage());
            logger.error("查询活动详情失败",e);
        }
        return result;
    }

    @Override
    public Result updateActivityApply(String activityId, String state){
        Result result = new Result();
        if(StringUtils.isEmpty(activityId)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        if(StringUtils.equals(state,ACTIVITY_STATE_FALSE)|| StringUtils.equals(state,ACTIVITY_STATE_TRUE)){
            TbActivity activity = new TbActivity();
            activity.setId(activityId);
            activity.setIsApply(state);
            int i = tbActivityMapper.updateByPrimaryKeySelective(activity);
            if(i==1){
                Map<String,Object> map = new HashMap<>(4);
                map.put("updateCode",i);
                result.setData(map);
            }else{
                result.setCode(ActivityExceptionEnum.ACTIVITY_UPDATE_ERROR.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_UPDATE_ERROR.getMessage());
            }
        }else{
            result.setCode(ActivityExceptionEnum.ACTIVITY_STATE_ERROR.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_STATE_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result insterOrUpdateActivity(Activity activity){
        Result result = checkActivity(activity);
        if(!StringUtils.equals(GlobalConstants.SUCCESS_CODE,result.getCode())){
            return result;
        }else{
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
                    result.setCode(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getCode());
                    result.setCode(ActivityExceptionEnum.ACTIVITY_NOT_EXIST.getMessage());
                    return result;
                }
                if(StringUtils.equals(tbActivity1.getState(),ACTIVITY_STATE_DRAFT)){
                    result.setCode(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT.getCode());
                    result.setCode(ActivityExceptionEnum.ACTIVITY_STATE_NOT_DRAFT.getMessage());
                    return result;
                }
                num = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
                tbActivityDetail.setActivityId(tbActivity.getId());
                tbActivityDetailMapper.updateByPrimaryKeySelective(tbActivityDetail);
            }
            Map<String,Object> map = new HashMap<>(4);
            map.put("changeNum",num);
            return result;
        }
    }

    /**
     * 保存活动校验方法
     * @param activity
     * @return
     */
    public Result checkActivity(Activity activity){
        Result result = new Result();
        if(StringUtils.isEmpty(activity.getActiName())){
            result.setCode(ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_TITLE_NOT_NULL.getMessage());
            return result;
        }
        if(StringUtils.equals(ACTIVITY_STATE_PUBLISH,activity.getState())){
            //活动发布，校验字段
            if(StringUtils.isEmpty(activity.getActiType())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_TYPE_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_TYPE_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getActiStartTime())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_STATE_TIME_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_STATE_TIME_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getActiEndTime())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_END_TIME_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_END_TIME_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getApplyEndTime())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_APPLY_END_TIME_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_APPLY_END_TIME_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getMesSendTime())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_MES_SEND_TIME_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_MES_SEND_TIME_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getActiAddress())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_ADDRESS_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_ADDRESS_NOT_NULL.getMessage());
                return result;
            }
            if(null == activity.getActiCost()){
                result.setCode(ActivityExceptionEnum.ACTIVITY_COST_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_COST_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getActiOrganizer())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_ORGANIZER_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_ORGANIZER_NOT_NULL.getMessage());
                return result;
            }
            if(null == activity.getActiNumber() || 0 == activity.getActiNumber()){
                result.setCode(ActivityExceptionEnum.ACTIVITY_NUMBER_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_NUMBER_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getActiPosterUrl())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_POSTER_URL_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_POSTER_URL_NOT_NULL.getMessage());
                return result;
            }
            if(StringUtils.isEmpty(activity.getActiDetail())){
                result.setCode(ActivityExceptionEnum.ACTIVITY_DETAIL_NOT_NULL.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_DETAIL_NOT_NULL.getMessage());
                return result;
            }
            if(null == activity.getActiOrder()){
                //如果排序为空，默认值为0.
                activity.setActiOrder(0);
            }
            try{
                Date actiStartDate = DateUtils.parseDate(activity.getActiStartTime(), "yyyy-MM-dd HH:mm:ss");
                Date actiEndDate = DateUtils.parseDate(activity.getActiEndTime(), "yyyy-MM-dd HH:mm:ss");
                Date actiApplyEndDate = DateUtils.parseDate(activity.getApplyEndTime(), "yyyy-MM-dd HH:mm:ss");
                if(actiStartDate.before(actiEndDate)){
                    result.setCode(ActivityExceptionEnum.ACTIVITY_TIME_ERROR.getCode());
                    result.setCode(ActivityExceptionEnum.ACTIVITY_TIME_ERROR.getMessage());
                    return result;
                }
                if(actiApplyEndDate.after(actiStartDate)){
                    result.setCode(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR.getCode());
                    result.setCode(ActivityExceptionEnum.ACTIVITY_APPLY_TIME_ERROR.getMessage());
                    return result;
                }
            }catch (ParseException  e){
                result.setCode(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_TIME_PARSE_ERROR.getMessage());
                return result;
            }

        }
        return result;
    }

    @Override
    public Result deleteDraftActivity(String activityId){
        Result result = new Result();
        if(StringUtils.isEmpty(activityId)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        String[] split = activityId.split(",");
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(split));
        List<TbActivity> tbActivities = tbActivityMapper.selectByExample(tbActivityCriteria);
        for(int a=0;a<tbActivities.size();a++){
            //校验是否有非草稿数据
            if(!StringUtils.equals(tbActivities.get(a).getState(),ACTIVITY_STATE_DRAFT)){
                result.setCode(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR.getCode());
                result.setCode(ActivityExceptionEnum.ACTIVITY_DRAFT_DELETE_ERROR.getMessage());
                return result;
            }
        }
        TbActivity tbActivity1 = new TbActivity();
        tbActivity1.setId(activityId);
        tbActivity1.setUpdateTime(new Date());
        tbActivity1.setState("5");
        int i1 = tbActivityMapper.updateByExample(tbActivity1, tbActivityCriteria);
        if(i1>0){
            Map<String,Object> map = new HashMap<>(4);
            map.put("deleteDraftNum",i1);
            result.setData(map);
        }else{
            result.setCode(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result deleteActivity(String activityId){
        Result result = new Result();
        if(StringUtils.isEmpty(activityId)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        String[] split = activityId.split(",");
        TbActivityCriteria tbActivityCriteria = new TbActivityCriteria();
        tbActivityCriteria.createCriteria().andIdIn(Arrays.asList(split));
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setState("5");
        tbActivity.setUpdateTime(new Date());
        int i1 = tbActivityMapper.updateByExample(tbActivity, tbActivityCriteria);
        if(i1>0){
            Map<String,Object> map = new HashMap<>(4);
            map.put("deleteNum",i1);
            result.setData(map);
        }else{
            result.setCode(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result cancelActivity(String activityId){
        Result result = new Result();
        if(StringUtils.isEmpty(activityId)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        TbActivity tbActivity = new TbActivity();
        tbActivity.setId(activityId);
        tbActivity.setState("4");
        int i = tbActivityMapper.updateByPrimaryKeySelective(tbActivity);
        if(i>0){
            Map<String,Object> map = new HashMap<>(4);
            map.put("cancelNum",i);
            result.setData(map);
        }else{
            result.setCode(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_DELETE_ERROR.getMessage());
        }
        return result;
    }

    @Override
    public Result applyActivityList(String activityId, com.jn.common.model.Page page){
        Result result = new Result();


        return result;
    }
}
