package com.jn.park.activity.dao;


import com.jn.park.activity.model.ActivityApply;
import com.jn.park.activity.model.ActivityDetail;
import com.jn.park.activity.model.Comment;
import feign.Param;
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
    List<ActivityDetail> getActivityDetails(@Param(value = "id") String id);

    /**
     * 获取点评信息
     * @param id 活动id
     * @return
     */
    List<Comment>getCommentInfo(@Param(value = "id") String id);

    /**
     * 获取活动报名信息
     * @param id 活动id
     * @return
     */
    List<ActivityApply>getActivityApplyInfo(@Param(value = "id") String id);
}
