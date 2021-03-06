package com.jn.system.permission.service;


import com.jn.system.model.User;
import com.jn.system.user.model.SysUserRole;

import java.util.List;
import java.util.Map;

/**
 * 用户角色service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 11:46
 * @version： v1.0
 * @modified By:
 */
public interface SysUserRoleService {

    /**
     * 新增用户角色
     *
     * @param role
     */
    void insertTbUserRole(SysUserRole role, User user);

    /**
     * 更新用户角色信息
     *
     * @param role
     */
    void updateTbUserRole(SysUserRole role);

    /**
     * 根据角色id批量删除用户角色（逻辑删除）
     *
     * @param map
     * @return
     */
    void deleteTbUserRoleByRoleIds(Map<String, Object> map);

    /**
     * 批量删除用户角色（逻辑删除）
     *
     * @param ids
     * @return
     */
    void deleteTbUserRoleById(String[] ids);

    /**
     * 批量插入用户角色
     *
     * @param sysUserRoles
     */
    void insertTbUserRoleBatch(List<SysUserRole> sysUserRoles);


}
