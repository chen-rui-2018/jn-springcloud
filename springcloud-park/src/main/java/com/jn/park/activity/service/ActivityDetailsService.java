package com.jn.park.activity.service;

import com.jn.common.model.PaginationData;
import com.jn.park.activity.entity.TbActivity;
import com.jn.park.activity.entity.TbParkLike;
import com.jn.park.activity.vo.ActivityDetailVO;
import com.jn.park.activity.model.ActivityApply;
import com.jn.park.activity.model.ActivityPagingParam;
import com.jn.park.activity.model.Comment;

import java.util.List;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 15:16
 * @Version v1.0
 * @modified By:
 */
public interface ActivityDetailsService {
    /**
     * 根据活动id获取活动详情
     * @param activityId 活动id
     * @param account    当前登录用户账号
     * @return
     */
    ActivityDetailVO findActivityDetails(String activityId , String account);



    /**
     * 根据活动id获取活动点评信息
     * @param activityPagingParam
     * @param isPage     是否分页  true：分页   false:不分页
     * @param loginAccount 当前登录用来账号
     * @return
     */
    PaginationData<List<Comment>> getCommentInfo(ActivityPagingParam activityPagingParam, String loginAccount, Boolean isPage);

    /**
     * 根据活动id获取活动点赞信息
     * @param activityId 活动id
     * @return
     */
    List<TbParkLike> getActivityLikeInfo(String activityId);

    /**
     * 根据活动id,account查询活动报名信息
     * @param activityId       活动id
     * @param account  账号
     * @return
     */
    List<ActivityApply> getActivityApplyInfo(String activityId, String account);

    /**
     * 根据活动id获取园区活动信息
     * @param activityId 活动id
     * @return
     */
    TbActivity getActivityInfo(String activityId);
}
