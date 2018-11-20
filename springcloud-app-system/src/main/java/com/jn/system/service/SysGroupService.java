package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.entity.TbSysGroup;
import com.jn.system.model.*;

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
     * @return
     */
    Result findSysGroupAll(SysGroupPage groupPage);

    /**
     * 增加用户组
     * @param sysGroup 用户组
     */
    Result addSysGroup(TbSysGroup sysGroup);

    /**
     * 逻辑删除用户组
     * @param groupIds 用户组数组id
     */
    void deleSysGroup(String[] groupIds);

    /**
     * 修改用户组信息
     * @param sysGroup 用户组对象
     * @return
     */
    void updateSysGroup(SysGroupUpdate sysGroup);

    /**
     * 根据用户组id获取用户组信息
     * @param id 用户组id
     * @return
     */
    Result findSysGroupById(String id);

    /**
     * 根据用户组id获取用户组信息及用户组具有的角色信息及条件分页查询用户组为拥有的角色信息
     * @param sysGroupRolePage
     * @return
     */
    Result selectGroupRoleAndOtherRole(SysGroupRolePage sysGroupRolePage);

    /**
     * 为用户组授权角色信息
     * @param sysRoleGroupAdd
     */
    void roleGroupAuthorization(SysRoleGroupAdd sysRoleGroupAdd);

    /**
     * 根据用户组id获取用户组下面所有用户
     * @param groupId 用户组id
     * @return
     */
    Result findUserOfGroup(String groupId);

    /**
     * 分页获取除用户组具有的用户以外的用户
     * @param sysGroupUserPage
     * @return
     */
    Result findOtherUserByPage(SysGroupUserPage sysGroupUserPage);

    /**
     * 用户组授权用户
     * @param sysGroupUserAdd
     */
    void userGroupAuthorization(SysGroupUserAdd sysGroupUserAdd);

    /**
     * 校验用户组名是否可用
     * @param groupName
     * @return
     */
    Result checkGroupName(String groupName);
}
