package com.jn.system.permission.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.User;
import com.jn.system.permission.entity.TbSysPermission;
import com.jn.system.permission.model.*;
import com.jn.system.permission.vo.SysMenuResourcesVO;

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
     * @param tbSysPermission
     */
    void addPermission(TbSysPermission tbSysPermission);

    /**
     * 修改权限
     *
     * @param sysPermission
     * @param user
     */
    void updatePermission(SysPermission sysPermission, User user);

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
     * 逻辑删除权限信息
     *
     * @param ids
     * @param user
     */
    void deletePermissionBranch(String[] ids, User user);

    /**
     * 为权限添加角色
     *
     * @param sysPermissionRolesAdd
     */
    void addRoleToPermission(SysPermissionRolesAdd sysPermissionRolesAdd, User user);

    /**
     * 获取权限已经具有的角色信息,且条件分页获取权限未拥有的角色信息
     *
     * @param sysPermissionRolePage
     * @return
     */
    PaginationData findRoleOfPermission(SysPermissionRolePage sysPermissionRolePage);

    /**
     * 获取除权限已经具有的文件组信息,且条件分页获取权限未拥有的文件组信息
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
    void addFileGroupToPermission(SysPermissionFileGroupAdd sysPermissionFileGroupAdd, User user);

    /**
     * 校验权限名是否已经存在
     *
     * @param permissionName
     * @return
     */
    String checkPermissionName(String permissionName);

    /**
     * 权限授权功能,获取菜单及功能信息
     *
     * @param permissionId
     * @return
     */
    SysMenuResourcesVO getMenuAndResources(String permissionId);

    /**
     * 权限授权菜单及功能信息
     *
     * @param sysPermissionMenuResourcesAdd
     * @param user
     */
    void addMenuAndResourcesToPermission(SysPermissionMenuResourcesAdd sysPermissionMenuResourcesAdd, User user);
}
