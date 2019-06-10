package com.jn.oa.multiDeptOffice.dao;

import com.jn.oa.multiDeptOffice.model.MultiDeptOffice;
import com.jn.system.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 多部门协同dao
 *
 * @author： shaobao
 * @date： Created on 2019/4/13 22:54
 * @version： v1.0
 * @modified By:
 **/
public interface MultiDeptOfficeMapper {
    /**
     * 更新多部门协同状态信息
     */
    void updateMultiDeptOfficeStatus();

    /**
     * @return
     */
    List<MultiDeptOffice> getMultiDeptOfficeByStatus();

    /**
     * 根据用户id获取用户信息
     *
     * @param userIds
     * @return
     */
    List<User> getUser(@Param("userIds") String[] userIds);
}
