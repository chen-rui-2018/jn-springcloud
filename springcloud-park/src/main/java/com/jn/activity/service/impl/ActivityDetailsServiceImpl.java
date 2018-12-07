package com.jn.activity.service.impl;

import com.jn.activity.dao.ActivityDetailsMapper;
import com.jn.activity.dao.TbActivityLikeMapper;
import com.jn.activity.dao.TbActivityMapper;
import com.jn.activity.entity.*;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.model.ActivityApply;
import com.jn.activity.model.ActivityDetail;
import com.jn.activity.model.Comment;
import com.jn.activity.service.ActivityDetailsService;
import com.jn.activity.vo.ActivityDetailVO;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:16
 * @Version v1.0
 * @modified By:
 */
@Service
public class ActivityDetailsServiceImpl implements ActivityDetailsService {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(ActivityDetailsServiceImpl.class);

    @Autowired
    private ActivityDetailsMapper activityDetailsMapper;

    @Autowired
    private TbActivityLikeMapper tbActivityLikeMapper;

    @Autowired
    private TbActivityMapper tbActivityMapper;

    /**
     * 根据活动id获取活动详情
     * @param id 活动id
     * @return
     */
    @ServiceLog(doAction = "获取活动详情")
    @Override
    public Result getActivityDetails(String id) {
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            logger.info("获取活动详情的活动id为空");
            return result;
        }
        List<ActivityDetail> list=activityDetailsMapper.getActivityDetails(id);
        if(list.size()>0){
            ActivityDetail activityDetail=list.get(0);
            ActivityDetailVO activityDetailVO=new ActivityDetailVO();
            BeanUtils.copyProperties(activityDetail, activityDetailVO);
            //根据活动id查询点评信息
            Result commentInfo = getCommentInfo(id);
            if (GlobalConstants.SUCCESS_CODE.equals(commentInfo.getCode()) && commentInfo.getData()!=null) {
                List<TbComment> commentList = (List<TbComment>)commentInfo.getData();
                activityDetailVO.setCommentList(commentList);
                activityDetailVO.setCommentNum(commentList.size());
            }
            //根据活动id查询点赞信息
            Result activityLikeInfo = getActivityLikeInfo(id);
            if (GlobalConstants.SUCCESS_CODE.equals(activityLikeInfo.getCode()) && activityLikeInfo.getData()!=null) {
                List<TbActivityLike> activityLikeList = (List<TbActivityLike>)activityLikeInfo.getData();
                activityDetailVO.setActivityLikeList(activityLikeList);
                activityDetailVO.setLikeNum(activityLikeList.size());
            }
            //根据活动id查询活动报名信息
            Result activityApplyInfo = getActivityApplyInfo(id);
            if (GlobalConstants.SUCCESS_CODE.equals(activityLikeInfo.getCode())&& activityApplyInfo.getData()!=null) {
                List<TbActivityApply> activityApplyList = (List<TbActivityApply>)activityApplyInfo.getData();
                activityDetailVO.setActivityApplyList(activityApplyList);
                activityDetailVO.setRealapplyNum(activityApplyList.size());
            }
            //把活动详情封装到result中返回前端
            result.setData(activityDetailVO);
        }
        return result;
    }

    /**
     * 根据活动id获取活动点评信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取活动点评信息")
    @Override
    public Result getCommentInfo(String id){
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            logger.info("获取活动点评信息的活动id为空");
            return result;
        }
        List<Comment>commentList=activityDetailsMapper.getCommentInfo(id);
        if(commentList.size()>0){
            result.setData(commentList);
        }
        return result;
    }


    /**
     * 根据活动id获取活动点赞信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取活动点赞信息")
    @Override
    public Result getActivityLikeInfo(String id){
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            return result;
        }
        TbActivityLikeCriteria example=new TbActivityLikeCriteria();
        //根据活动id获取点赞状态为点赞（"1"）的数据
        example.createCriteria().andActivityIdEqualTo(id).andStateEqualTo("1");
        List<TbActivityLike> tbActivityLikes = tbActivityLikeMapper.selectByExample(example);
        if(tbActivityLikes.size()>0){
            result.setData(tbActivityLikes);
        }
        return result;
    }

    /**
     * 根据活动id查询活动报名信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "活动报名信息")
    @Override
    public Result getActivityApplyInfo(String id){
        Result result=new Result();
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            logger.info("获取活动报名信息的活动id为空");
            return result;
        }
        List<ActivityApply>applyList=activityDetailsMapper.getActivityApplyInfo(id);
        if(applyList.size()>0){
            result.setData(applyList);
        }
        return result;
    }

    /**
     * 根据活动id获取园区活动信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取园区活动信息")
    @Override
    public Result getActivityInfo(String id){
        Result result=new Result();
        //非空校验
        if(StringUtils.isBlank(id)){
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getCode());
            result.setCode(ActivityExceptionEnum.ACTIVITY_ID_CANNOT_EMPTY.getMessage());
            logger.info("获取园区活动信息的活动id为空");
            return result;
        }
        TbActivityCriteria example=new TbActivityCriteria();
        List<String> stateList=new ArrayList<>(16);
        //草稿
        stateList.add("1");
        //已删除活动
        stateList.add("5");
        //草稿、已删除的活动不能被查询出来
        example.createCriteria().andIdEqualTo(id).andStateNotIn(stateList);
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(id);
        if(tbActivity!=null){
            result.setData(tbActivity);
        }
        return result;
    }
}
