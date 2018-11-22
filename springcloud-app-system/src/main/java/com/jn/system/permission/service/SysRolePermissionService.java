package com.jn.system.permission.service;


import com.jn.system.permission.model.SysRolePermission;
import com.jn.system.model.User;

import java.util.List;

/**
 * 角色权限service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 11:46
 * @version： v1.0
 * @modified By:
 */
public interface SysRolePermissionService {

    /**
     * 新增角色权限
     * @param rolePermission
     */
    void insertTbRolePermission(SysRolePermission rolePermission, User user);

    /**
     * 更新角色权限信息
     * @param rolePermission
     */
    void updateTbRolePermission(SysRolePermission rolePermission);

    /**
     * 根据角色id批量删除角色权限（逻辑删除）
     * @param roleIds
     * @return
     */
    void deleteTbRolePermissionByRoleIds(String[] roleIds);

    /**
     * 批量删除角色权限（逻辑删除）
     * @param ids
     * @return
     */
    void deleteTbRolePermissionByIds(String[] ids);

    /**
     * 批量插入角色权限
     * @param sysRolePermissions
     */
    void insertTbRolePermissionBatch(List<SysRolePermission> sysRolePermissions);

}
