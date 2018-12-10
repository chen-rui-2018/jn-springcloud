package com.jn.activity.service;

/**
 * 活动点赞
 * @Author: yangph
 * @Date: 2018/12/7 9:30
 * @Version v1.0
 * @modified By:
 */
public interface ActivityLikeService {
    /**
     * 活动点赞
     * @param id       活动id
     * @param account  用户账号
     * @return
     */
    void activityLike(String id,String account);

    /**
     * 取消点赞
     * @param id        活动id
     * @param account   用户账号
     * @return
     */
    void cancelLike(String id,String account);
}
