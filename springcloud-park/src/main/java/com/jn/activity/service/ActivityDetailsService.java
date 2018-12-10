package com.jn.activity.service;

import com.jn.activity.entity.TbActivity;
import com.jn.activity.entity.TbActivityLike;
import com.jn.activity.model.ActivityApply;
import com.jn.activity.model.Comment;
import com.jn.activity.vo.ActivityDetailVO;

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
     * @param id       活动id
     * @param account  当前登录用户账号
     * @return
     */
    ActivityDetailVO findActivityDetails(String id , String account);

    /**
     * 根据活动id获取活动点评信息
     * @param id 活动id
     * @return
     */
    List<Comment> getCommentInfo(String id);

    /**
     * 根据活动id获取活动点赞信息
     * @param id 活动id
     * @return
     */
    List<TbActivityLike> getActivityLikeInfo(String id);

    /**
     * 根据活动id查询活动报名信息
     * @param id 活动id
     * @return
     */
    List<ActivityApply> getActivityApplyInfo(String id);

    /**
     * 根据活动id获取园区活动信息
     * @param id 活动id
     * @return
     */
    TbActivity getActivityInfo(String id);
}
