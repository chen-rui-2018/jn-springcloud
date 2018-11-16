package com.jn.system.dao;

import com.jn.system.model.SysGroup;
import com.jn.system.model.SysGroupRole;
import com.jn.system.model.SysRole;
import com.jn.system.model.SysRoleUserGroupPage;

import java.util.List;

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
     * 根据用户组id清除用户组下面的角色信息
     *
     * @param groupId
     */
    void deteSysGroupRoleByGroupId(String groupId);

    /**
     * 为用户组添加角色信息
     *
     * @param sysGroupRoleList
     */
    void insertSysGroupRoleBatch(List<SysGroupRole> sysGroupRoleList);

    /**
     * 根据用户组id批量删除多用信息
     *
     * @param groupIds
     */
    void deleteGroupBranch(String[] groupIds);

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
}
