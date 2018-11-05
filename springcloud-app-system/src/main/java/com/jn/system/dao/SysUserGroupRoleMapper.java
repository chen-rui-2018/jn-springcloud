package com.jn.system.dao;




import com.jn.system.model.SysUserGroupRole;

import java.util.List;

/**
 * 用户组角色关系mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysUserGroupRoleMapper {
    /**
     * 根据主键删除用户组角色
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增用户组角色
     * @param role
     * @return
     */
    int insert(SysUserGroupRole role);

    /**
     * 查询所有权限列表
     * @return
     */
    List<SysUserGroupRole> selectAll();

    /**
     * 根据主键查询用户组角色
     * @param id
     * @return
     */
    SysUserGroupRole selectByPrimaryKey(String id);

    /**
     * 根据主键更新用户组角色
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUserGroupRole record);

    /**
     * 批量删除权限
     * @param id
     */
    void deleteBy(String[] id);

    /**
     * 根据角色id删除用户组角色
     * @param id
     */
    void deleteByRoleIds(String[] id);

    /**
     * 批量插入用户组角色
     * @param sysUserGroupRoles
     */
    void insertBatch( List<SysUserGroupRole> sysUserGroupRoles);
}