package com.jn.park.activity.dao;


import com.jn.park.model.ActivityContent;
import com.jn.park.model.ActivityListApplyed;
import com.jn.park.model.ActivitySlim;
import com.jn.park.model.Activity;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @Author: jiangyl
 * @Date: 2018/12/5 21:09
 * @Version v1.0
 * @modified By:
 */
public interface ActivityMapper {

    /**
     * 查询活动列表
     * @param activity
     * @return
     */
    List<Activity> selectActivityList(ActivityContent activity);

    /**
     * 活动类表展示接口
     * @param typeId
     * @param keyWord
     * @param startTime
     * @param endTime
     * @param orderBy
     * @return
     */
   List<ActivitySlim> activityListSlim(@Param("typeId") String typeId, @Param("keyWord") String keyWord,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("orderBy") String orderBy);

    /**
     * author chenr
     * 查询用户已报名的活动列表
     * @param account
     * @param applyStatus
     * @return
     */
    List<ActivityListApplyed> findActivitySuccessfulRegistration(@Param("account") String account , @Param("applyStatus") String applyStatus);
}
