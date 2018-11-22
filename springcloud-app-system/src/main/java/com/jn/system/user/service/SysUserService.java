package com.jn.system.user.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.*;
import com.jn.system.user.model.*;
import com.jn.system.dept.vo.SysDepartmentPostVO;
import com.jn.system.user.vo.SysUserRoleVO;

import java.util.List;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 13:07
 * @version： v1.0
 * @modified By:
 */
public interface SysUserService {

    /**
     * 添加用户
     *
     * @param sysUser
     */
    void addSysUser(SysUser sysUser, User user);

    /**
     * 查询用户
     *
     * @param userSysUserPage
     * @return
     */
    PaginationData findSysUserByPage(SysUserPage userSysUserPage);

    /**
     * 删除用户
     *
     * @param ids
     */
    void deleteSysUser(String[] ids);

    /**
     * 更新用户信息
     *
     * @param sysUser
     */
    void updateSysUser(SysUser sysUser);

    /**
     * 根据用户id获取用户已经存在的用户组及其他用户组
     *
     * @param sysUserGroupPage
     * @return
     */
    PaginationData findSysGroupByUserId(SysUserGroupPage sysUserGroupPage);

    /**
     * 往用户中添加用户组
     *
     * @param groupIds
     * @param userId
     */
    void saveSysGroupToSysUser(String[] groupIds, String userId,User user);

    /**
     * 根据用户id获取用户具有角色及条件查询用户未拥有的角色
     *
     * @param sysUserRolePage
     * @return
     */
    SysUserRoleVO findSysRoleByUserId(SysUserRolePage sysUserRolePage);

    /**
     * 为用户添加角色权限
     *
     * @param roleIds
     * @param userId
     */
    void saveSysRoleToSysUser(String[] roleIds, String userId,User user);

    /**
     * 根据用户id查询用户已经具有的部门岗位信息及用户信息
     *
     * @param userId
     * @return
     */
    List<SysDepartmentPostVO> findDepartmentandPostByUserId(String userId);

    /**
     * 为用户添加部门岗位
     *
     * @param sysUserDepartmentPostAdd
     * @return
     */
    void saveDepartmentAndPostOfUser(SysUserDepartmentPostAdd sysUserDepartmentPostAdd, User user);

    /**
     * 根据用户id返回用户信息
     *
     * @param id
     * @return
     */
    SysUser findSysUserById(String id);

    /**
     * 校验用户账号是否存在
     * @param account
     * @return
     */
    String checkUserName(String account);

    List<User> findTByT(User user);
}
