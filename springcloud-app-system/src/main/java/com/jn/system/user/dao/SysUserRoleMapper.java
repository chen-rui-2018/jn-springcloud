package com.jn.system.user.dao;


import com.jn.system.permission.model.SysRole;
import com.jn.system.permission.model.SysRoleUserPage;
import com.jn.system.user.model.SysTUser;
import com.jn.system.user.model.SysUserRole;
import com.jn.system.user.model.SysUserRolePage;

import java.util.List;
import java.util.Map;

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
     *
     * @param id
     */
    void deleteByIds(String[] id);

    /**
     * 根据角色id删除用户角色
     *
     * @param map
     */
    void deleteByRoleIds(Map<String,Object> map);

    /**
     * 批量插入用户角色
     *
     * @param sysUserRoles
     */
    void insertBatch(List<SysUserRole> sysUserRoles);

    /**
     * 批量删除用户对应的信息
     *
     * @param map
     */
    void deleteUserBranch(Map<String,Object> map);

    /**
     * 根据角色id获取角色对应用户名称
     *
     * @param roleId
     * @return
     */
    List<String> findUserNameByRoleId(String roleId);

    /**
     * 根据角色id获取角色已经拥有的用户信息
     *
     * @param roleId
     * @return
     */
    List<SysTUser> findUserByRoleId(String roleId);

    /**
     * 条件分页获取角色未拥有用户信息
     *
     * @param sysRoleUserPage
     * @return
     */
    List<SysTUser> findOtherUser(SysRoleUserPage sysRoleUserPage);

    /**
     * 条件分页获取用户未拥有的角色信息
     *
     * @param sysUserRolePage
     * @return
     */
    List<SysRole> findRoleByUserPage(SysUserRolePage sysUserRolePage);
}