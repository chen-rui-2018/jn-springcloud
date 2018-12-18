package com.jn.park.activity.service.impl;

import com.github.pagehelper.PageHelper;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.*;
import com.jn.park.activity.entity.*;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.vo.ActivityDetailVO;
import com.jn.park.activity.model.ActivityApply;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.model.Comment;
import com.jn.system.log.annotation.ServiceLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private TbParkLikeMapper tbParkLikeMapper;

    @Autowired
    private TbActivityMapper tbActivityMapper;

    @Autowired
    private TbActivityApplyMapper tbActivityApplyMapper;


    /**
     * 根据活动id获取活动详情
     * @param activityId 活动id
     * @param account    当前登录用户账号
     * @return
     */
    @ServiceLog(doAction = "获取活动详情")
    @Override
    public ActivityDetailVO findActivityDetails(String activityId,String account) {
        List<ActivityDetail> list=activityDetailsMapper.getActivityDetails(activityId);
        if(list.size()>0){
            ActivityDetail activityDetail=list.get(0);
            ActivityDetailVO activityDetailVO=new ActivityDetailVO();
            activityDetailVO.setActivityDetail(activityDetail);
            //根据活动id查询点赞信息
            List<TbParkLike> activityLikeInfo = getActivityLikeInfo(activityId);
            int minLikeNum=0;
            if (activityLikeInfo.size()>minLikeNum) {
                activityDetailVO.setActivityLikeList(activityLikeInfo);
                activityDetailVO.setLikeNum(activityLikeInfo.size());
            }
            //是否展示报名人(0：否   1：是）若不展示报名人，不查询报名信息
            String showApplyNum="1";
            if(showApplyNum.equals(activityDetail.getShowApplyNum())){
                //根据活动id和account查询活动报名信息
                List<ActivityApply> activityApplyInfo = getActivityApplyInfo(activityId,account);
                int minApplyNum=0;
                if (activityApplyInfo.size()>minApplyNum) {
                    activityDetailVO.setActivityApplyList(activityApplyInfo);
                    activityDetailVO.setRealapplyNum(activityApplyInfo.size());
                }
            }
            //获取报名截止倒计时信息， 报名截止时间、系统当前时间，是否报名成功标志
            applyCountdown(activityId, account, activityDetailVO);
            //更新园区活动的阅读人数
            updateActivityViews(activityId, activityDetail.getActivityViews());
            //把活动详情封装到result中返回前端
            return  activityDetailVO;
        }else {
            logger.info("活动详情没有数据");
        }
        return null;
    }

    /**
     * 更新园区活动人数
     * @param activityId    活动id
     * @param activityViews  园区活动原有阅读人数
     */
    private void updateActivityViews(String activityId, String activityViews) {
        TbActivityCriteria example=new TbActivityCriteria();
        example.createCriteria().andIdEqualTo(activityId);
        TbActivity tbActivity=new TbActivity();
        //阅读人数加1   若没有人，阅读人数设置为1
        int viewsNum= StringUtils.isNumeric(activityViews)?Integer.parseInt(activityViews)+1:1;
        tbActivity.setActiViews(viewsNum);
        tbActivityMapper.updateByExampleSelective(tbActivity,example );
    }

    /**
     * 报名截止倒计时信息
     * @param activityId
     * @param account
     * @param activityDetailVO
     */
    private void applyCountdown(String activityId, String account, ActivityDetailVO activityDetailVO) {
        //根据用户账号和活动id查询当前登录用户是否已报名当前活动
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(activityId).andAccountEqualTo(account);
        long applyNum = tbActivityApplyMapper.countByExample(example);
        //默认报名成功
        activityDetailVO.setApplySuccess(true);
        //若已报名该活动,报名成功标志位true,否则为false
        //没有报名
        int noApplyNum=0;
        if(applyNum==noApplyNum){
            //没有数据，表示没有报名成功
            activityDetailVO.setApplySuccess(false);
        }
        //获取系统当前时间
        String sysTemTime = DateUtils.getDate("yyyy-MM-dd HH:mm:ss");
        activityDetailVO.setSysTemTime(sysTemTime);
    }

    /**
     * 根据活动id获取活动点评信息
     * @param activityId 活动id
     * @param page       分页信息
     * @param isPage     是否分页  true：分页   false:不分页
     * @return
     */
    @ServiceLog(doAction = "获取活动点评信息")
    @Override
    public PaginationData getCommentInfo(String activityId, Page page,boolean isPage){
        com.github.pagehelper.Page<Object> objects=null;
        if(isPage){
            //默认查询前15条
            objects = PageHelper.startPage(page.getPage(), page.getRows() == 0 ? 15 : page.getRows(), true);
        }
        List<Comment>list=activityDetailsMapper.getCommentInfo(activityId);
        List<Comment> resultList = recursiveGetComments(list);
        return new PaginationData(resultList,objects==null?0:objects.getTotal());
    }

    /**
     * 递归查询活动点评信息
     * @param list
     * @return
     */
    @ServiceLog(doAction = "递归查询活动点评信息")
    private List<Comment> recursiveGetComments(List<Comment> list) {
        for(Comment comment:list){
            //有子节点
             if(comment.getChildNum()>0){
                List<Comment>resultList=activityDetailsMapper.getCommentInfo(comment.getId());
                comment.setChildList(recursiveGetComments(resultList));
            }
        }
        return list;
    }


    /**
     * 根据活动id获取活动点赞信息
     * @param activityId
     * @return
     */
    @ServiceLog(doAction = "获取活动点赞信息")
    @Override
    public List<TbParkLike> getActivityLikeInfo(String activityId){
        TbParkLikeCriteria example=new TbParkLikeCriteria();
        //根据活动id获取点赞状态为点赞（"1"）的数据
        example.createCriteria().andLikeParentIdEqualTo(activityId).andStateEqualTo("1");
        List<TbParkLike> tbActivityLikes = tbParkLikeMapper.selectByExample(example);
        return tbActivityLikes;
    }

    /**
     * 根据活动id,account查询活动报名信息
     * @param activityId 活动id
     * @param account    账号
     * @return
     */
    @ServiceLog(doAction = "活动报名信息")
    @Override
    public List<ActivityApply> getActivityApplyInfo(String activityId,String account){
        List<ActivityApply> activityApplyInfo = activityDetailsMapper.getActivityApplyInfo(activityId, account);
        return activityApplyInfo;
    }

    /**
     * 根据活动id获取园区活动信息
     * @param activityId
     * @return
     */
    @ServiceLog(doAction = "获取园区活动信息")
    @Override
    public TbActivity getActivityInfo(String activityId){
        TbActivityCriteria example=new TbActivityCriteria();
        List<String> stateList=new ArrayList<>(16);
        //草稿
        String draftState="1";
        stateList.add(draftState);
        //已删除活动
        String delState="5";
        stateList.add(delState);
        //草稿、已删除的活动不能被查询出来
        example.createCriteria().andIdEqualTo(activityId).andStateNotIn(stateList);
        TbActivity tbActivity = tbActivityMapper.selectByPrimaryKey(activityId);
        return tbActivity;
    }
}
