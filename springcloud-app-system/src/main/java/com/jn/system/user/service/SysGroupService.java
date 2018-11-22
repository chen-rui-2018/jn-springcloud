package com.jn.system.user.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.*;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.*;

import java.util.List;

/**
 * 用户组
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 13:07
 * @version： v1.0
 * @modified By:
 */
public interface SysGroupService {

    /**
     * 查询所有用户组信息
     *
     * @return
     */
    PaginationData findSysGroupAll(SysGroupPage groupPage);

    /**
     * 增加用户组
     *
     * @param sysGroup 用户组
     */
    void addSysGroup(TbSysGroup sysGroup, User user);

    /**
     * 逻辑删除用户组
     *
     * @param groupIds 用户组数组id
     */
    void deleSysGroup(String[] groupIds);

    /**
     * 修改用户组信息
     *
     * @param sysGroup 用户组对象
     * @return
     */
    void updateSysGroup(SysGroupUpdate sysGroup);

    /**
     * 根据用户组id获取用户组信息
     *
     * @param id 用户组id
     * @return
     */
    TbSysGroup findSysGroupById(String id);

    /**
     * 根据用户组id获取用户组信息及用户组具有的角色信息及条件分页查询用户组为拥有的角色信息
     *
     * @param sysGroupRolePage
     * @return
     */
    PaginationData selectGroupRoleAndOtherRole(SysGroupRolePage sysGroupRolePage);

    /**
     * 为用户组授权角色信息
     *
     * @param sysRoleGroupAdd
     */
    void roleGroupAuthorization(SysRoleGroupAdd sysRoleGroupAdd, User user);

    /**
     * 根据用户组id获取用户组下面所有用户
     *
     * @param groupId 用户组id
     * @return
     */
    List<SysTUser> findUserOfGroup(String groupId);

    /**
     * 分页获取除用户组具有的用户以外的用户
     *
     * @param sysGroupUserPage
     * @return
     */
    PaginationData findOtherUserByPage(SysGroupUserPage sysGroupUserPage);

    /**
     * 用户组授权用户
     *
     * @param sysGroupUserAdd
     */
    void userGroupAuthorization(SysGroupUserAdd sysGroupUserAdd, User user);

    /**
     * 校验用户组名是否可用
     *
     * @param groupName
     * @return
     */
    String checkGroupName(String groupName);
}
