package com.jn.system.dao;

import com.jn.system.entity.TbSysRolePermission;
import com.jn.system.model.SysRole;
import com.jn.system.model.SysRolePermission;

import java.util.List;

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
     * @param id
     */
    void deleteByRoleIds(String[] id);

    /**
     * 批量插入角色权限
     *
     * @param sysRolePermissions
     */
    void insertBatch(List<SysRolePermission> sysRolePermissions);

    /**
     * 根据权限id批量删除对应信息
     *
     * @param ids
     */
    void deletePermissionBranch(String[] ids);

    /**
     * 清除权限已经具有的角色
     *
     * @param permissionId
     */
    void deleteByPermissionId(String permissionId);

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
}