package com.jn.park.comment.service;

import com.jn.park.comment.model.CommentAdd;

/**
 * 评论/点评
 * @Author: yangph
 * @Date: 2018/12/11 10:50
 * @Version v1.0
 * @modified By:
 */
public interface CommentService {
    /**
     * 活动评论/回复
     * @param commentAdd  点评信息   活动id,点评类型、点评内容
     * @param account     用户账号/点评人
     */
    void commentActivity(CommentAdd commentAdd,String account);

    /**
     * 活动评论点赞
     * @param commentAdd 点评信息   活动id,点评类型、
     * @param account    用户账号/点评人
     */
    void commentActivityLike(CommentAdd commentAdd,String account);
}
