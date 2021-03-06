package com.jn.park.comment.service;

import com.jn.park.activity.model.CommentAddParam;

/**
 * 评论/点评
 * @Author: yangph
 * @Date: 2018/12/11 10:50
 * @Version v1.0
 * @modified By:
 */
public interface CommentService {
    /**
     * 评论/回复
     * @param commentAddParam  点评信息   活动id,点评类型、点评内容
     */
    int commentActivity(CommentAddParam commentAddParam);

    /**
     * 评论点赞
     * @param id        点评ID/活动ID
     * @param account   用户账号/点评人
     */
    void commentActivityLike(String  id,String account);

    /**
     * 评论取消点赞
     * @param id          点评ID/活动ID
     * @param account     用户账号/点评人
     */
    void commentActivityCancelLike(String id,String account);

    /**
     * 更新点赞状态
     * @param likeParentId  点赞父id
     * @param account       用户账号
     * @param state         点赞状态  0：取消点赞   1：点赞
     */
    void updateParkLikeState(String likeParentId, String account, String state);

    /**
     * 新增点赞信息
     * @param activityId 活动id
     * @param account    用户账号
     */
    void addActivityLike(String activityId, String account);
}
