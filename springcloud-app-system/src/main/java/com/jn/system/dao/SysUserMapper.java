package com.jn.system.dao;

import com.jn.system.model.*;
import com.jn.system.vo.SysUserVO;

import java.util.List;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 16:27
 * @version： v1.0
 * @modified By:
 */
public interface SysUserMapper {

    /**
     * 添加用户
     * @param sysUser
     */
    void addSysUser(SysUser sysUser);

    /**
     * 当按部门查询用户时
     * @param userSysUserPage
     * @return
     */
    List<SysUserVO> findSysUserByPageAndOption(SysUserPage userSysUserPage);

    /**
     * 当查询部门的条件为空时的查询方法
     * @param userSysUserPage
     * @return
     */
    List<SysUserVO> findSysUserByPage(SysUserPage userSysUserPage);

    /**
     * 删除用户
     * @param id
     */
    void deleteSysUser(String id);

    /**
     * 更新用户
     * @param sysUserVO
     */
    void updateSysUser(SysUserVO sysUserVO);

    /**
     * 往用户中添加用户组
     * @param sysGroupUser
     */
    void saveSysGroupToSysUser(SysGroupUser sysGroupUser);

    /**
     * 清除用户组中已经存在的用户组
     * @param userId
     */
    void deleGroupOfUser(String userId);

    /**
     * 清除用户中已经具有的角色
     * @param userId
     */
    void deleRoleOfUser(String userId);

    /**
     * 为用户添加权限
     * @param sysUserRole
     */
    void saveSysRoleToSysUser(SysUserRole sysUserRole);

    /**
     * 清除用户原有部门岗位信息
     * @param sysUserId
     */
    void deleDepartmentandPost(String sysUserId);

    /**
     * 为用户添加新的部门岗位信息
     * @param sysUserDepartmentPost
     */
    void saveDepartmentandPostOfUser(SysUserDepartmentPost sysUserDepartmentPost);

    /**
     * 根据用户id返回用户信息
     * @param id
     * @return
     */
    SysUserVO findSysUserById(String id);
}
