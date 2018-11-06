package com.jn.system.service;

import com.jn.common.model.Result;
import com.jn.system.model.SysUser;
import com.jn.system.model.SysUserPage;
import com.jn.system.model.SysUserDepartmentPost;

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
     * @param sysUser
     */
    void addSysUser(SysUser sysUser);

    /**
     * 查询用户
     * @param userSysUserPage
     * @return
     */
    Result findSysUserByPage(SysUserPage userSysUserPage);

    /**
     * 删除用户
     * @param ids
     */
    void deleteSysUser(String[] ids);

    /**
     * 更新用户信息
     * @param sysUser
     */
    void updateSysUser(SysUser sysUser);

    /**
     * 根据用户id获取用户已经存在的用户组及其他用户组
     * @param id
     * @return
     */
    Result findSysGroupByUserId(String id);

    /**
     * 往用户中添加用户组
     * @param groupIds
     * @param userId
     */
    void saveSysGroupToSysUser(String[] groupIds, String userId);

    /**
     * 根据用户id获取用户具有角色及其他角色
     * @param id
     * @return
     */
    Result findSysRoleByUserId(String id);

    /**
     * 为用户添加角色权限
     * @param roleIds
     * @param userId
     */
    void saveSysRoleToSysUser(String[] roleIds, String userId);

    /**
     * 根据用户id查询用户已经具有的部门岗位信息及用户信息
     * @param userId
     * @return
     */
    Result findDepartmentandPostByUserId(String userId);

    /**
     * 为用户添加部门岗位
     * @param sysUserId 用户id
     * @param sysUserDepartmentPostlist 岗位,部门列表集合
     * @return
     */
    void saveDepartmentandPostOfUser(String sysUserId, List<SysUserDepartmentPost> sysUserDepartmentPostlist);

    /**
     * 根据用户id返回用户信息
     * @param id
     * @return
     */
    Result findSysUserById(String id);
}
