package com.jn.system.dao;

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
     * @return
     */
    List<SysRolePermission> selectAll();


    /**
     * 批量删除权限
     * @param id
     */
    void deleteBy(String[] id);

    /**
     * 根据角色id删除角色权限
     * @param id
     */
    void deleteByRoleIds(String[] id);

    /**
     * 批量插入角色权限
     * @param sysRolePermissions
     */
    void insertBatch(List<SysRolePermission> sysRolePermissions);


}