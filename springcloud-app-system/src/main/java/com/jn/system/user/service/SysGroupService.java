package com.jn.system.user.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.User;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.*;
import com.jn.system.user.vo.SysGroupRoleVO;
import com.jn.system.user.vo.SysGroupUserRoleVO;
import com.jn.system.user.vo.SysGroupUserVO;

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
     * 查询用户组信息列表
     *
     * @return
     */
    PaginationData<List<SysGroupUserRoleVO>> findSysGroupAll(SysGroupPage groupPage);

    /**
     * 增加用户组
     *
     * @param tbSysGroup 用户组
     */
    void addSysGroup(TbSysGroup tbSysGroup);

    /**
     * 逻辑删除用户组
     * @param groupIds
     * @param user
     */
    void deleSysGroup(String[] groupIds,User user);

    /**
     * 修改用户组信息
     * @param sysGroup
     * @param user 当时用户信息
     */
    void updateSysGroup(SysGroupUpdate sysGroup,User user);

    /**
     * 根据用户组id获取用户组信息
     *
     * @param id 用户组id
     * @return
     */
    TbSysGroup findSysGroupById(String id);

    /**
     * 查询用户组已经具有的角色信息,且条件分页获取用户组未拥有的角色信息
     *
     * @param sysGroupRolePage
     * @return
     */
    PaginationData<SysGroupRoleVO> selectGroupRoleAndOtherRole(SysGroupRolePage sysGroupRolePage);

    /**
     * 为用户组授权角色信息
     *
     * @param sysRoleGroupAdd
     */
    void roleGroupAuthorization(SysRoleGroupAdd sysRoleGroupAdd, User user);

    /**
     * 查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息
     *
     * @param sysGroupUserPage
     * @return
     */
    PaginationData<SysGroupUserVO> findOtherUserByPage(SysGroupUserPage sysGroupUserPage);

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
