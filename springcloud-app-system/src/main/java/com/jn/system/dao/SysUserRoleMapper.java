package com.jn.system.dao;



import com.jn.system.model.SysUserRole;

import java.util.List;

/**
 * 用户角色关系mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysUserRoleMapper {


    /**
     * 批量删除权限
     * @param id
     */
    void deleteByIds(String[] id);
    /**
     * 根据角色id删除用户角色
     * @param id
     */
    void deleteByRoleIds(String[] id);

    /**
     * 批量插入用户角色
     * @param sysUserRoles
     */
    void insertBatch(List<SysUserRole> sysUserRoles);

    /**
     * 批量删除用户对应的信息
     * @param ids
     */
    void deleteUserBranch(String[] ids);
}