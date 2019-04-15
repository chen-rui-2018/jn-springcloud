package com.jn.park.activity.dao;

import com.jn.park.activity.model.ActivityApplyDetail;
import org.apache.ibatis.annotations.Param;
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
     * @param applyStatus
     * @return
     */
  List<ActivityApplyDetail> findApplyActivityList(@Param("activityId")String activityId,@Param("applyStatus")String applyStatus);

    /**
     * 活动列表的报名人账号信息
     * @param activityIdList
     * @return
     */
  List<ActivityApplyDetail> findApplyAccountList(List<String> activityIdList);
}
