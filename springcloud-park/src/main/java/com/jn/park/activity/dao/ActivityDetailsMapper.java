package com.jn.park.activity.dao;


import com.jn.park.activity.model.ActivityApply;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 活动详情
 * @Author: yangph
 * @Date: 2018/12/5 17:35
 * @Version v1.0
 * @modified By:
 */
@Repository
public interface ActivityDetailsMapper {
    /**
     * 获取活动详情
     * @param id 活动id
     * @return
     */
    List<ActivityDetail> getActivityDetails(@Param("id") String id);

    /**
     * 获取点评信息
     * @param activityId 活动id
     * @param parentIds  评论id/活动id
     * @param loginAccount 当前登录用户账号
     * @return
     */
    List<Comment>getCommentInfo(@Param("activityId") String activityId,@Param("list") List<String> parentIds,@Param("loginAccount") String loginAccount);

    /**
     * 获取活动报名信息
     * @param id 活动id
     * @param account  账号
     * @return
     */
    List<ActivityApply>getActivityApplyInfo(@Param("activityId") String id, @Param("account") String account);
}
