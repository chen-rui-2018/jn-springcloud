package com.jn.system.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.*;

/**
 * @author： shaobao
 * @date： Created on 2018/11/1 16:23
 * @version： v2.0
 * @modified By:yuanyy
 **/
public interface SysRoleService {
    /**
     * 查询所有角色
     *
     * @return
     */
    Result findSysRoleAll();

    /**
     * 新增角色
     *
     * @param role
     */
    void insertTbRole(SysRole role);

    /**
     * 更新角色信息
     *
     * @param role
     */
    void updateTbRole(SysRole role);

    /**
     * 批量删除角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    void deleteTbRoleById(String[] roleIds);

    /**
     * 分页查询角色授权列表信息
     *
     * @param rolePage
     * @return
     */
    PaginationData selectRoleListBySearchKey(SysRolePage rolePage);


    /**
     * 添加角色授权（用户）
     *
     * @param sysUserRoleAdd
     */
    void userRoleAuthorization(SysUserRoleAdd sysUserRoleAdd);

    /**
     * 添加角色授权（权限）
     *
     * @param sysRolePermissionAdd
     */
    void rolePermissionAuthorization(SysRolePermissionAdd sysRolePermissionAdd);

    /**
     * 添加角色授权（用户组）
     *
     * @param sysUserGroupRoleAdd
     */
    void UserGroupRoleAuthorization(SysUserGroupRoleAdd sysUserGroupRoleAdd);
}
