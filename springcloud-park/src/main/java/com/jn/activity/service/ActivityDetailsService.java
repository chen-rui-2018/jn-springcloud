package com.jn.activity.service;

import com.jn.common.model.Result;

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
     * @param id 活动id
     * @return
     */
    Result getActivityDetails(String id);

    /**
     * 根据活动id获取活动点评信息
     * @param id 活动id
     * @return
     */
    Result getCommentInfo(String id);

    /**
     * 根据活动id获取活动点赞信息
     * @param id 活动id
     * @return
     */
    Result getActivityLikeInfo(String id);

    /**
     * 根据活动id查询活动报名信息
     * @param id 活动id
     * @return
     */
    Result getActivityApplyInfo(String id);

    /**
     * 根据活动id获取园区活动信息
     * @param id 活动id
     * @return
     */
    Result getActivityInfo(String id);
}
