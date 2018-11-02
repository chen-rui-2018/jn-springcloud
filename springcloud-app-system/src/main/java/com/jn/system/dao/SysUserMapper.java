package com.jn.system.dao;

import com.jn.system.model.QueryVo;
import com.jn.system.vo.TbSysUser;
import com.jn.system.vo.TbSysUserDepartmentPost;
import com.jn.system.vo.TbSysUserGroup;
import com.jn.system.vo.TbSysUserRole;

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
    void addSysUser(TbSysUser sysUser);

    /**
     * 根据查询条件查询用户
     * @param userQueryVo
     * @return
     */
    List<TbSysUser> findSysUserByPageAndOption(QueryVo userQueryVo);

    /**
     * 在没有查询条件是查询用户
     * @return
     */
    List<TbSysUser> findSysUserByPage();

    /**
     * 删除用户
     * @param id
     */
    void deleteSysUser(String id);

    /**
     * 更新用户
     * @param sysUser
     */
    void updateSysUser(TbSysUser sysUser);

    /**
     * 往用户中添加用户组
     * @param sysUserGroup
     */
    void saveSysGroupToSysUser(TbSysUserGroup sysUserGroup);

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
    void saveSysRoleToSysUser(TbSysUserRole sysUserRole);

    /**
     * 清除用户原有部门岗位信息
     * @param sysUserId
     */
    void deleDepartmentandPost(String sysUserId);

    /**
     * 为用户添加新的部门岗位信息
     * @param sysUserDepartmentPost
     */
    void saveDepartmentandPostOfUser(TbSysUserDepartmentPost sysUserDepartmentPost);

    /**
     * 根据用户id返回用户信息
     * @param id
     * @return
     */
    TbSysUser findSysUserById(String id);
}
