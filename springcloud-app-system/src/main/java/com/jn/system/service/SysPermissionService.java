package com.jn.system.service;

import com.jn.common.model.PaginationData;
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
    void addPermission(SysPermissionAdd sysPermissionAdd,User user);

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
    SysPermission selectByPrimaryKey(String id);

    /**
     * 条件分页查询
     *
     * @param sysPermissionPage
     * @return
     */
    PaginationData findByPage(SysPermissionPage sysPermissionPage);

    /**
     * @param ids
     */
    void deletePermissionBranch(String[] ids);

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd,User user);

    /**
     * 条件分页获取未拥有的角色信息
     *
     * @param sysPermissionRolePage
     * @return
     */
    PaginationData findRoleOfPermission(SysPermissionRolePage sysPermissionRolePage);

    /**
     * 获取除权限已经具有的文件组信息及条件分页获取未拥有的文件组信息
     *
     * @param sysPermissionFileGroupPage
     * @return
     */
    PaginationData findFileGroupOfPermission(SysPermissionFileGroupPage sysPermissionFileGroupPage);

    /**
     * 为权限添加文件组
     *
     * @param sysPermissionFileGroupAdd
     */
    void addFileGroupToPermission(SysPermissionFileGroupAdd sysPermissionFileGroupAdd,User user);

    /**
     * 获取权限已经具有的菜单信息及条件分页查询未拥有的菜单信息
     *
     * @param sysPermissionMenuPage
     * @return
     */
    PaginationData findMenuOfPermission(SysPermissionMenuPage sysPermissionMenuPage);

    /**
     * 获取权限已经具有的功能信息及条件分页获取未拥有的功能信息
     *
     * @param sysPermissionResourcePage
     * @return
     */
    PaginationData findResourcesOfPermission(SysPermissionResourcePage sysPermissionResourcePage);

    /**
     * 校验权限名是否已经存在
     *
     * @param permissionName
     * @return
     */
    String checkPermissionName(String permissionName);

    /**
     * 为权限添加菜单
     *
     * @param sysPermissionMenuAdd
     */
    void addMenuToPermission(SysPermissionMenuAdd sysPermissionMenuAdd,User user);

    /**
     * 为权限添加页面功能
     *
     * @param sysPermissionMenuAdd
     */
    void addResourceToPermission(SysPermissionResourceAdd sysPermissionMenuAdd,User user);
}
