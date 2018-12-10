package com.jn.system.user.dao;

import com.jn.system.dept.entity.TbSysUserDepartmentPost;
import com.jn.system.user.model.SysGroupUser;
import com.jn.system.user.model.SysUser;
import com.jn.system.user.model.SysUserPage;
import com.jn.system.user.model.SysUserRole;
import com.jn.system.user.vo.SysUserDepartmentPostVO;
import com.jn.system.user.vo.SysUserVO;

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
     *
     * @param sysUser
     */
    void addSysUser(SysUser sysUser);

    /**
     * 当查询部门的条件为空时的查询方法
     *
     * @param userSysUserPage
     * @return
     */
    List<SysUserVO> findSysUserByPage(SysUserPage userSysUserPage);

    /**
     * 删除用户
     *
     * @param id
     */
    void deleteSysUser(String id);

    /**
     * 更新用户
     *
     * @param sysUserVO
     */
    void updateSysUser(SysUserVO sysUserVO);

    /**
     * 往用户中添加用户组
     *
     * @param sysGroupUser
     */
    void saveSysGroupToSysUser(SysGroupUser sysGroupUser);

    /**
     * 清除用户组中已经存在的用户组
     *
     * @param userId
     */
    void deleGroupOfUser(String userId);

    /**
     * 清除用户中已经具有的角色
     *
     * @param userId
     */
    void deleRoleOfUser(String userId);

    /**
     * 为用户添加权限
     *
     * @param sysUserRole
     */
    void saveSysRoleToSysUser(SysUserRole sysUserRole);

    /**
     * 清除用户原有部门岗位信息
     *
     * @param sysUserId
     */
    void deleDepartmentandPost(String sysUserId);

    /**
     * 根据用户id返回用户信息
     *
     * @param id
     * @return
     */
    SysUserVO findSysUserById(String id);

    /**
     * 批量删除用户
     *
     * @param ids
     */
    void deleteUserBranch(String[] ids);


    /**
     * 根据用户id查询用户已经具有的部门岗位信息及用户信息
     *
     * @param userId
     * @return
     */
    SysUserDepartmentPostVO findDepartmentAndPostByUserId(String userId);

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    SysUser getUserById(String id);

    /**
     * 用户批量添加部门岗位信息
     *
     * @param list
     */
    void addDepartmentAndPostToUserBatch(List<TbSysUserDepartmentPost> list);
}
