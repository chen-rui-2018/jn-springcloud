package com.jn.park.activity.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.dao.ActivityDetailsMapper;
import com.jn.park.activity.dao.TbActivityApplyMapper;
import com.jn.park.activity.dao.TbActivityMapper;
import com.jn.park.activity.dao.TbParkLikeMapper;
import com.jn.park.activity.entity.*;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.vo.ActivityDetailVO;
import com.jn.park.model.ActivityApply;
import com.jn.park.model.ActivityDetail;
import com.jn.park.model.ActivityQueryPaging;
import com.jn.park.model.Comment;
import com.jn.system.log.annotation.ServiceLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
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
    
    @Autowired
    private UserExtensionClient userExtensionClient;

    /**
     * 活动草稿
     */
    private static final String ACTIVITY_STATE_DRAFT = "1";
    /**
     * 活动状态删除
     */
    private static final String ACTIVITY_STATE_DELETE = "0";
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
        if(list.isEmpty()){
            logger.info("活动详情没有数据");
            return  new ActivityDetailVO();
        }
        ActivityDetail activityDetail=list.get(0);
        ActivityDetailVO activityDetailVO=new ActivityDetailVO();
        activityDetailVO.setActivityDetail(activityDetail);
        //根据活动id查询点赞信息
        List<TbParkLike> activityLikeInfo = getActivityLikeInfo(activityId);
        int minLikeNum=0;
        if (activityLikeInfo.isEmpty()) {
            //当前用户没有点赞
            activityDetailVO.setAccountIsLike(false);
        }else{
            activityDetailVO.setActivityLikeList(activityLikeInfo);
            activityDetailVO.setLikeNum(activityLikeInfo.size());
            for(TbParkLike parkLike:activityLikeInfo){
                if(account.equals(parkLike.getCreatorAccount())){
                    //当前用户已点赞
                    activityDetailVO.setAccountIsLike(true);
                    break;
                }
            }
            //点赞列表中没有当前用户信息
            if(activityDetailVO.getAccountIsLike()==null){
                activityDetailVO.setAccountIsLike(false);
            }
        }
        //是否展示报名人(0：否   1：是）若不展示报名人，不查询报名信息
        String showApplyNum="1";
        if(showApplyNum.equals(activityDetail.getShowApplyNum())){
            //根据活动id和account查询活动报名信息
            List<ActivityApply> activityApplyInfo = getActivityApplyInfo(activityId,account);
            int minApplyNum=0;
            if (activityApplyInfo.size()>minApplyNum) {
                activityDetailVO.setActivityApplyList(activityApplyInfo);
                activityDetailVO.setRealApplyNum(activityApplyInfo.size());
            }
        }
        //获取报名截止倒计时信息， 报名截止时间、系统当前时间，是否报名成功标志
        applyCountdown(activityId, account, activityDetailVO);
        //更新园区活动的阅读人数
        updateActivityViews(activityId, activityDetail.getActiViews());
        //把活动详情封装到result中返回前端
        return  activityDetailVO;
    }

    /**
     * 更新园区活动人数
     * @param activityId    活动id
     * @param activityViews  园区活动原有阅读人数
     */
    @ServiceLog(doAction = "更新园区活动人数")
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
    @ServiceLog(doAction = "报名截止倒计时信息")
    private void applyCountdown(String activityId, String account, ActivityDetailVO activityDetailVO) {
        //根据用户账号和活动id查询当前登录用户是否已报名当前活动
        TbActivityApplyCriteria example=new TbActivityApplyCriteria();
        example.createCriteria().andActivityIdEqualTo(activityId).andCreatorAccountEqualTo(account);
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
     * @param activityQueryPaging
     * @param isPage     是否分页  true：分页   false:不分页
     * @param loginAccount  当前登录用户
     * @return
     */
    @ServiceLog(doAction = "获取活动点评信息")
    @Override
    public PaginationData getCommentInfo(ActivityQueryPaging activityQueryPaging,String loginAccount, Boolean isPage){
        Page<Object> objects=null;
        try {
            if(isPage){
                //默认查询前15条
                objects = PageHelper.startPage(activityQueryPaging.getPage(), activityQueryPaging.getRows() == 0 ? 15 :activityQueryPaging.getRows(), true);
            }
            //获取第一层级评论
            List<String>parentIds=new ArrayList<>(16);
            parentIds.add(activityQueryPaging.getActivityId());
            List<Comment>list=activityDetailsMapper.getCommentInfo(activityQueryPaging.getActivityId(),parentIds,loginAccount);
            if(list.isEmpty()){
                return new PaginationData(list,objects==null?0:objects.getTotal());
            }
            //获取评论用户头像信息
            getCommentUserAvatar(list);
            list= getCommentChildComment(list,activityQueryPaging.getActivityId(),loginAccount);
            return new PaginationData(list,objects==null?0:objects.getTotal());
        } finally {
            if(objects!=null){
                objects.close();
            }
        }
    }

    /**
     * 获取评论用户头像信息
     * @param list
     */
    @ServiceLog(doAction = "获取用户头像信息")
    private void getCommentUserAvatar(List<Comment> list) {
        List<String> accountList=new ArrayList<>(16);
        for(Comment comment:list){
            //获取所有用户账号
            accountList.add(comment.getCreatorAccount());
        }
        //批量获取用户扩展信息
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        if(moreUserExtension.getData()==null || moreUserExtension.getData().isEmpty()){
            //ignore
            return ;
        }
        List<UserExtensionInfo> data = moreUserExtension.getData();
        for(Comment  comment:list){
            for(UserExtensionInfo userExtension:data){
                //用户拓展信息
                if(userExtension!=null && userExtension.getAccount().equals(comment.getCreatorAccount())){
                    //设置头像信息
                    comment.setAvatar(userExtension.getAvatar());
                    break;
                }
            }
        }
    }

    /**
     * 获取评论的子评论
     * @param list
     * @return
     */
    @ServiceLog(doAction = "获取评论的子评论")
    private List<Comment> getCommentChildComment(List<Comment> list,String activityId,String loginAccount) {
        //获取第一层评论的id
        List<String>parentIds=new ArrayList<>(16);
        for(Comment cm:list){
            parentIds.add(cm.getId());
        }
        //根据第一层评论id查询下一层的评论信息
        List<Comment> commentInfo = activityDetailsMapper.getCommentInfo(activityId, parentIds,loginAccount);
        //获取评论用户头像信息
        getCommentUserAvatar(commentInfo);
        for(Comment comment:list){
            List<Comment>nextList=new ArrayList<>(16);
            for(Comment nextComment:commentInfo){
                if(StringUtils.equals(comment.getId(), nextComment.getpId())){
                    nextList.add(nextComment);
                }
            }
            comment.setChildList(nextList);
            comment.setChildNum(nextList.size());
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
        String likeStatus="1";
        //是否删除  0:已删除  1：正常
        byte recordStatus=1;
        example.createCriteria().andLikeParentIdEqualTo(activityId).andLikeStatusEqualTo(likeStatus)
                .andRecordStatusEqualTo(recordStatus);
        return tbParkLikeMapper.selectByExample(example);
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
        //根据报名人账号得到报名人头像信息
        getApplyUserAvatar(activityApplyInfo);
        return activityApplyInfo;
    }

    /**
     * 获取报名用户的头像信息
     * @param activityApplyInfo
     */
    @ServiceLog(doAction = "获取报名用户的头像信息")
    private void getApplyUserAvatar(List<ActivityApply> activityApplyInfo) {
        List<String> accountList=new ArrayList<>(32);
        for(ActivityApply apply:activityApplyInfo){
            accountList.add(apply.getAccount());
        }
        //批量获取用户扩展信息
        Result<List<UserExtensionInfo>> moreUserExtension = userExtensionClient.getMoreUserExtension(accountList);
        if(moreUserExtension.getData()!=null && !moreUserExtension.getData().isEmpty()){
            List<UserExtensionInfo> data = moreUserExtension.getData();
            for(ActivityApply apply:activityApplyInfo){
                for(UserExtensionInfo userExtension:data){
                    //用户扩展信息
                    if(userExtension!=null && userExtension.getAccount().equals(apply.getAccount())){
                        apply.setAvatar(userExtension.getAvatar());
                        break;
                    }
                }
            }
        }
    }

    /**
     * 根据活动id获取园区活动信息
     * @param activityId
     * @return
     */
    @ServiceLog(doAction = "获取园区活动信息")
    @Override
    public TbActivity getActivityInfo(String activityId){
        return tbActivityMapper.selectByPrimaryKey(activityId);
    }
}
