package com.jn.activity.service.impl;

import com.jn.activity.dao.ActivityDetailsMapper;
import com.jn.activity.dao.TbActivityApplyMapper;
import com.jn.activity.dao.TbActivityLikeMapper;
import com.jn.activity.dao.TbActivityMapper;
import com.jn.activity.entity.*;
import com.jn.activity.enums.ActivityExceptionEnum;
import com.jn.activity.model.ActivityApply;
import com.jn.activity.model.ActivityDetail;
import com.jn.activity.model.Comment;
import com.jn.activity.service.ActivityApplyService;
import com.jn.activity.service.ActivityDetailsService;
import com.jn.activity.vo.ActivityDetailVO;
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

    @Autowired
    private TbActivityApplyMapper tbActivityApplyMapper;

    /**
     * 根据活动id获取活动详情
     * @param id       活动id
     * @param account  当前登录用户账号
     * @return
     */
    @ServiceLog(doAction = "获取活动详情")
    @Override
    public ActivityDetailVO findActivityDetails(String id,String account) {
        List<ActivityDetail> list=activityDetailsMapper.getActivityDetails(id);
        if(list.size()>0){
            ActivityDetail activityDetail=list.get(0);
            ActivityDetailVO activityDetailVO=new ActivityDetailVO();
            BeanUtils.copyProperties(activityDetail, activityDetailVO);
            //根据活动id查询点评信息
            List<Comment> commentInfo = getCommentInfo(id);
            if (commentInfo!=null) {
                activityDetailVO.setCommentList(commentInfo);
                activityDetailVO.setCommentNum(commentInfo.size());
            }
            //根据活动id查询点赞信息
            List<TbActivityLike> activityLikeInfo = getActivityLikeInfo(id);
            if (activityLikeInfo!=null) {
                activityDetailVO.setActivityLikeList(activityLikeInfo);
                activityDetailVO.setLikeNum(activityLikeInfo.size());
            }
            //根据活动id查询活动报名信息
            List<ActivityApply> activityApplyInfo = getActivityApplyInfo(id);
            if (activityApplyInfo!=null) {
                activityDetailVO.setActivityApplyList(activityApplyInfo);
                activityDetailVO.setRealapplyNum(activityApplyInfo.size());
            }
            //获取报名截止倒计时信息， 报名截止时间、系统当前时间，是否报名成功标志
            applyCountdown(id, account, activityDetailVO);
            //把活动详情封装到result中返回前端
            return  activityDetailVO;
        }else {
            logger.info("活动详情没有数据");
        }
        return null;
    }

    /**
     * 报名截止倒计时信息
     * @param id
     * @param account
     * @param activityDetailVO
     */
    private void applyCountdown(String id, String account, ActivityDetailVO activityDetailVO) {
        //根据用户账号和活动id查询当前登录用户是否已报名当前活动
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(id).andAccountEqualTo(account);
        List<TbActivityApply> tbActivityApplies = tbActivityApplyMapper.selectByExample(example);
        //若已报名该活动,报名成功标志位true,否则为false
        if(tbActivityApplies.size()==0){
            //没有数据，表示没有报名成功
            activityDetailVO.setApplySuccess(false);
        }
        //获取系统当前时间
        String sysTemTime = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
        activityDetailVO.setSysTemTime(sysTemTime);
    }

    /**
     * 根据活动id获取活动点评信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取活动点评信息")
    @Override
    public List<Comment> getCommentInfo(String id){
        return activityDetailsMapper.getCommentInfo(id);
    }


    /**
     * 根据活动id获取活动点赞信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取活动点赞信息")
    @Override
    public List<TbActivityLike> getActivityLikeInfo(String id){
        TbActivityLikeCriteria example=new TbActivityLikeCriteria();
        //根据活动id获取点赞状态为点赞（"1"）的数据
        example.createCriteria().andActivityIdEqualTo(id).andStateEqualTo("1");
        List<TbActivityLike> tbActivityLikes = tbActivityLikeMapper.selectByExample(example);
        return tbActivityLikes;
    }

    /**
     * 根据活动id查询活动报名信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "活动报名信息")
    @Override
    public List<ActivityApply> getActivityApplyInfo(String id){
        return activityDetailsMapper.getActivityApplyInfo(id);
    }

    /**
     * 根据活动id获取园区活动信息
     * @param id
     * @return
     */
    @ServiceLog(doAction = "获取园区活动信息")
    @Override
    public TbActivity getActivityInfo(String id){
        TbActivityCriteria example=new TbActivityCriteria();
        List<String> stateList=new ArrayList<>(16);
        //草稿
        String draftState="1";
        stateList.add(draftState);
        //已删除活动
        String delState="5";
        stateList.add(delState);
        //草稿、已删除的活动不能被查询出来
        example.createCriteria().andIdEqualTo(id).andStateNotIn(stateList);
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(id);
        return tbActivity;
    }
}
