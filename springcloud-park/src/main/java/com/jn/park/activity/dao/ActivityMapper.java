package com.jn.park.activity.dao;


import com.jn.park.activity.model.Activity;
import com.jn.park.activity.model.ActivitySlim;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: jiangyl
 * @Date: 2018/12/5 21:09
 * @Version v1.0
 * @modified By:
 */
public interface ActivityMapper {

    public List<Activity> selectActivityList(Activity activity);

    /**
     * 活动类表展示接口
     * @param typeId
     * @param keyWord
     * @return
     */
   List<ActivitySlim> activityListSlim(@Param("typeId") String typeId, @Param("keyWord") String keyWord);
}
