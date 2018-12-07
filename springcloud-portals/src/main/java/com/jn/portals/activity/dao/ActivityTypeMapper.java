package com.jn.portals.activity.dao;

import com.jn.portals.activity.vo.ActivityTypeVO;
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
    List<ActivityTypeVO> findActivityTypeListByState(@Param("state") String state);
}
