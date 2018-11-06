package com.jn.system.dao;

import com.jn.system.model.SysGroupRole;
import com.jn.system.model.SysGroupUser;
import com.jn.system.model.SysRole;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/5 19:18
 * @version： v1.0
 * @modified By:
 **/
public interface SysGroupRoleMapper {
    /**
     * 根据用户组id获取用户组具有的角色
     * @param id
     * @return
     */
    List<SysRole> findRoleByGroupId(String id);

    /**
     * 根据用户组id清除用户组下面的角色信息
     * @param groupId
     */
    void deteSysGroupRoleByGroupId(String groupId);

    /**
     * 为用户组添加角色信息
     * @param sysGroupRoleList
     */
    void insertSysGroupRoleBatch(List<SysGroupRole> sysGroupRoleList);


}
