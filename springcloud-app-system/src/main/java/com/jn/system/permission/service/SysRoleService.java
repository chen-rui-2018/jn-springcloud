package com.jn.system.permission.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.*;
import com.jn.system.permission.model.*;
import com.jn.system.user.model.SysUserGroupRoleAdd;
import com.jn.system.user.model.SysUserRoleAdd;

import java.util.List;

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
    List<SysRole> findSysRoleAll();

    /**
     * 新增角色
     *
     * @param role
     */
    void insertTbRole(SysRoleAdd role, User user);

    /**
     * 更新角色信息
     *
     * @param role
     */
    void updateTbRole(SysRoleUpdate role);

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
    void userRoleAuthorization(SysUserRoleAdd sysUserRoleAdd, User user);

    /**
     * 添加角色授权（权限）
     *
     * @param sysRolePermissionAdd
     */
    void rolePermissionAuthorization(SysRolePermissionAdd sysRolePermissionAdd, User user);

    /**
     * 添加角色授权（用户组）
     *
     * @param sysUserGroupRoleAdd
     */
    void UserGroupRoleAuthorization(SysUserGroupRoleAdd sysUserGroupRoleAdd, User user);

    /**
     * 校验角色名称是否已经存在
     *
     * @param roleName
     * @return
     */
    String checkRoleName(String roleName);

    /**
     * 查询角色已经具有的用户信息,且条件分页获取为角色未拥有的用户信息
     *
     * @param sysRoleUserPage
     * @return
     */
    PaginationData findUserOfRoleAndOtherUser(SysRoleUserPage sysRoleUserPage);

    /**
     * 查询角色已经具有的用户组信息,且条件分页获取角色未拥有的用户组信息
     *
     * @param sysRoleUserGroupPage
     * @return
     */
    PaginationData findUserGroupOfRoleAndOtherGroup(SysRoleUserGroupPage sysRoleUserGroupPage);

    /**
     * 查询角色已经具有的权限信息,且条件分页获取角色未拥有的权限信息
     *
     * @param sysRolePermissionPage
     * @return
     */
    PaginationData findPermissionOrRoleAndOtherPermission(SysRolePermissionPage sysRolePermissionPage);
}
