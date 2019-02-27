package com.jn.system.user.dao;

import com.jn.system.model.SysRole;
import com.jn.system.permission.model.SysRoleUserGroupPage;
import com.jn.system.user.model.SysGroup;
import com.jn.system.user.model.SysGroupRole;
import com.jn.system.user.model.SysGroupRolePage;

import java.util.List;
import java.util.Map;

/**
 * @author： shaobao
 * @date： Created on 2018/11/5 19:18
 * @version： v1.0
 * @modified By:
 **/
public interface SysGroupRoleMapper {
    /**
     * 根据用户组id获取用户组具有的角色
     *
     * @param id
     * @return
     */
    List<SysRole> findRoleByGroupId(String id);

    /**
     * 根据用户组id获取用户组具有的角色
     *
     * @param id
     * @return
     */
    List<String> findRolesByGroupId(String id);

    /**
     * 为用户组添加角色信息
     *
     * @param sysGroupRoleList
     */
    void insertSysGroupRoleBatch(List<SysGroupRole> sysGroupRoleList);

    /**
     * 根据用户组id批量删除多用信息
     *
     * @param map
     */
    void deleteGroupBranch(Map<String,Object> map);

    /**
     * 获取角色已经拥有的用户组信息
     *
     * @param roleId
     * @return
     */
    List<SysGroup> findUserGroupByRoleId(String roleId);

    /**
     * 条件分页获取角色为拥有的用户组信息
     *
     * @param sysRoleUserGroupPage
     * @return
     */
    List<SysGroup> findOtherUserGroup(SysRoleUserGroupPage sysRoleUserGroupPage);

    /**
     * 条件分页查询用户组为拥有的角色信息
     *
     * @param sysGroupRolePage
     * @return
     */
    List<SysRole> findRoleByGroupPage(SysGroupRolePage sysGroupRolePage);

    /**
     * 根据角色id批量删除角色用户组信息
     * @param map
     */
    void deleteTbSysGroupRoleByRoleIds(Map<String,Object> map);
}
