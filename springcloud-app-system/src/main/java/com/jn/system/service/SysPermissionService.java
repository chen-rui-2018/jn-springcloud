package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.model.*;

/**
 * @author： shaobao
 * @date： Created on 2018/11/9 9:18
 * @version： v1.0
 * @modified By:
 **/
public interface SysPermissionService {
    /**
     * 添加权限
     *
     * @param sysPermissionAdd
     */
    void addPermission(SysPermissionAdd sysPermissionAdd);

    /**
     * 修改权限
     *
     * @param sysPermission
     */
    void updatePermission(SysPermission sysPermission);

    /**
     * 根据主键获取权限信息
     *
     * @param id
     * @return
     */
    Result selectByPrimaryKey(String id);

    /**
     * 条件分页查询
     *
     * @param sysPermissionPage
     * @return
     */
    Result findByPage(SysPermissionPage sysPermissionPage);

    /**
     * @param ids
     */
    void deletePermissionBranch(String[] ids);

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd);

    /**
     * 根据权限id获取权限已经具有的角色
     *
     * @param id
     * @return
     */
    Result findRoleOfPermission(String id);

    /**
     * 根据权限id获取除权限已经具有的角色之外的角色信息
     *
     * @param id
     * @return
     */
    Result findOtherRoles(String id);

    /**
     * 根据权限id获取除权限已经具有的文件组信息
     *
     * @param id
     * @return
     */
    Result findFileGroupOfPermission(String id);

    /**
     * 根据权限id获取除权限已经具有的文件组之外的文件组信息
     *
     * @param id
     * @return
     */
    Result findOtherFileGroups(String id);

    /**
     * 为权限添加文件组
     *
     * @param sysPermissionFileGroupAdd
     */
    void addFileGroupToPermission(SysPermissionFileGroupAdd sysPermissionFileGroupAdd);

    /**
     * 根据权限id获取权限已经具有的菜单
     *
     * @param id
     * @return
     */
    Result findMenuOfPermission(String id);

    /**
     * 根据权限id获取权限已经具有的菜单之外的菜单
     *
     * @param id
     * @return
     */
    Result findOtherMenu(String id);

    /**
     * 根据权限id获取权限已经具有的功能信息
     *
     * @param id
     * @return
     */
    Result findResourcesOfPermission(String id);

    /**
     * 根据权限id获取权限已经具有的页面功能之外的页面功能
     *
     * @param permissionId
     * @return
     */
    Result findOtherResources(String permissionId);

    /**
     * 为权限添加菜单及页面功能
     * @param sysPermissionMenuRecourcesAdd
     */
    void addMenuAndResourceToPermission(SysPermissionMenuRecourcesAdd sysPermissionMenuRecourcesAdd);
}
