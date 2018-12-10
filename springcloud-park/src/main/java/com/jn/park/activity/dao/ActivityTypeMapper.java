package com.jn.park.activity.dao;


import com.jn.park.activity.model.ActivityType;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 活动类型管理
 * @Author: chenr
 * @Date: 2018/12/06 15:50
 * @Version v1.0
 * @modified By:
 */
public interface ActivityTypeMapper {
    /**
     * 查询活动类型列表
     * @param state
     * @return
     */
    List<ActivityType> findActivityTypeListByState(@Param("state") String state);

    /**
     * 根据活动类型ID,获取当前活动信息
     * @param typeId
     * @return
     */
    ActivityType  findActivityTypeById(String typeId);

    /**
     * 删除活动类型
     * @param typeId
     */
    void deleteActivityTypeList(List<String> typeId);
}

