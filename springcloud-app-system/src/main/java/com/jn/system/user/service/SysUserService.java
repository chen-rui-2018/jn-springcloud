package com.jn.system.user.service;

import com.jn.common.model.PaginationData;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import com.jn.system.user.model.*;
import com.jn.system.user.vo.SysUserGroupVO;
import com.jn.system.user.vo.SysUserRoleVO;
import com.jn.system.user.vo.SysUserVO;
import com.jn.system.vo.SysDepartmentPostVO;

import java.util.List;
import java.util.Set;

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
    void addSysUser(SysUserAdd sysUser, User user);

    /**
     * 条件分页查询用户
     *
     * @param userPage
     * @return
     */
    PaginationData<List<SysUserVO>> findSysUserByPage(UserPage userPage);

    /**
     * 逻辑删除用户
     *
     * @param ids
     * @param user 当前用户信息
     */
    void deleteSysUser(String[] ids, User user);

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @param user    当前用户信息
     */
    void updateSysUser(SysUser sysUser, User user);

    /**
     * 查询用户已经具有的用户组信息,且条件分页获取用户未拥有的用户组信息
     *
     * @param sysUserGroupPage
     * @return
     */
    PaginationData<SysUserGroupVO> findSysGroupByUserId(SysUserGroupPage sysUserGroupPage);

    /**
     * 往用户中添加用户组
     *
     * @param groupIds
     * @param userId
     */
    void saveSysGroupToSysUser(String[] groupIds, String userId, User user);

    /**
     * 根据用户id获取用户具有角色及条件查询用户未拥有的角色
     *
     * @param sysUserRolePage
     * @return
     */
    PaginationData<SysUserRoleVO> findSysRoleByUserId(SysUserRolePage sysUserRolePage);

    /**
     * 为用户添加角色权限
     *
     * @param roleIds
     * @param userId
     */
    void saveSysRoleToSysUser(String[] roleIds, String userId, User user);

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
     * 校验用户账号是否存在
     *
     * @param account
     * @return
     */
    String checkUserName(String account);

    List<User> findTByT(User user);

    /**
     * 获取所有有效用户信息
     *
     * @return
     */
    List<User> getUserAll();

    /**
     * 通过用户账号,获取用户信息,多个账号,返回多个用户信息
     *
     * @param accountList 账号集合
     * @return
     */
    List<User> getUserInfoByAccount(List<String> accountList);

    /**
     * 修改用户角色信息
     *
     * @param user        用户对象,传账号id都可以,都传,优先使用id操作
     * @param deleRoleIds 删除的角色id集合,不删除集合传空集合
     * @param addRoleIds  新增的角色id集合,不新增集合传空集合
     * @return
     */
    Boolean updateUserRole(User user, Set<String> deleRoleIds, Set<String> addRoleIds);

    /**
     * 根据用户id，查询用户信息
     *
     * @param ids 用户数组
     * @return
     */
    List<User> selectUserByIds(String[] ids);
}
