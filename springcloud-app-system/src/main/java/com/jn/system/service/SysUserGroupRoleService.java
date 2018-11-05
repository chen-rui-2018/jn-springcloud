package com.jn.system.service;


import com.jn.system.model.SysUserGroupRole;

import java.util.List;

/**
 * 用户组角色service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 11:46
 * @version： v1.0
 * @modified By:
 */

public interface SysUserGroupRoleService {

    /**
     * 新增用户组角色
     * @param userGroupRole
     */
    void insertTbUserGroupRole(SysUserGroupRole userGroupRole);

    /**
     * 更新用户组角色信息
     * @param userGroupRole
     */
    void updateTbUserGroupRole(SysUserGroupRole userGroupRole);

    /**
     * 根据角色id批量删除用户组角色（逻辑删除）
     * @param roleIds
     * @return
     */
    void deleteTbUserGroupRoleByRoleIds(String[] roleIds);

    /**
     * 批量删除用户组角色（逻辑删除）
     * @param ids
     * @return
     */
    void deleteTbUserGroupRoleById(String[] ids);

    /**
     * 批量插入用户组角色
     * @param sysUserGroupRoles
     */
    void insertTbUserGroupRoleBatch(List<SysUserGroupRole> sysUserGroupRoles);

}
