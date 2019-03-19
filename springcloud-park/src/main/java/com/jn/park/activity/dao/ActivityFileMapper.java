package com.jn.park.activity.dao;


import java.util.List;
import java.util.Map;

/**
 * 活动类型模板
 * @Author: chenr
 * @Date: 2018/12/05 15:50
 * @Version v1.0
 * @modified By:
 */

public interface ActivityFileMapper {
    /**
     * 新建活动类型模板
     * @param map
     */
   void  insertActivityTypeTemp(Map<String, Object> map);

    /**
     * 删除活动类型时删除对应的模板内容
     * @param activityIdList
     */
   void deleteActivityTypeTemp(List<String> activityIdList);


}
