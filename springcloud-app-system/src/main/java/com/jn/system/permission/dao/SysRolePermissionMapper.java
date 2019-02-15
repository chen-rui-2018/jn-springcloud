package com.jn.system.permission.dao;

import com.jn.system.permission.entity.TbSysRolePermission;
import com.jn.system.permission.model.*;

import java.util.List;
import java.util.Map;

/**
 * 角色权限关系mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysRolePermissionMapper {


    /**
     * 查询所有权限列表
     *
     * @return
     */
    List<SysRolePermission> selectAll();


    /**
     * 批量删除权限
     *
     * @param id
     */
    void deleteBy(String[] id);

    /**
     * 根据角色id删除角色权限
     *
     * @param map
     */
    void deleteByRoleIds(Map<String, Object> map);

    /**
     * 批量插入角色权限
     *
     * @param sysRolePermissions
     */
    void insertBatch(List<SysRolePermission> sysRolePermissions);

    /**
     * 根据权限id批量删除对应信息
     *
     * @param map
     */
    void deletePermissionBranch(Map<String, Object> map);

    /**
     * 批量为权限添加角色信息
     *
     * @param list
     */
    void addRoleToPermissionBranch(List<TbSysRolePermission> list);

    /**
     * 根据权限id获取权限已经具有的角色
     *
     * @param id
     * @return
     */
    List<SysRole> findRoleOfPermission(String id);

    /**
     * 根据角色id获取角色对应的权限信息
     *
     * @param roleId
     * @return
     */
    List<String> findPermissionNameByRoleId(String roleId);

    /**
     * 获取角色已经拥有的权限信息
     *
     * @param roleId
     * @return
     */
    List<SysPermission> findPermissionByRoleId(String roleId);

    /**
     * 条件分页获取角色为拥有的权限信息
     *
     * @param sysRolePermissionPage
     * @return
     */
    List<SysPermission> findOtherUserGroup(SysRolePermissionPage sysRolePermissionPage);

    /**
     * 条件分页获取未拥有的角色信息
     *
     * @param sysPermissionRolePage
     * @return
     */
    List<SysRole> findRoleByPermissionPage(SysPermissionRolePage sysPermissionRolePage);
}