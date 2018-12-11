package com.jn.park.activity.dao;

import com.jn.park.activity.model.ActivityApplyDetail;

import java.util.List;
/**
 * 活动报名信息
 *
 * @Author: chenr
 * @Date: 2018/12/05 15:50
 * @Version v1.0
 * @modified By:
 */
public interface ActivityApplyMapper {
    /**
     *根据活动id 获取活动报名人列表信息
     * @param activityId
     * @return
     */
  List<ActivityApplyDetail> findApplyActivityList(String activityId);
}
