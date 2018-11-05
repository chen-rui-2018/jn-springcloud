package com.jn.system.dao;



import com.jn.system.model.SysUserRole;

import java.util.List;

/**
 * 用户角色关系mapper
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 15:31
 * @version： v1.0
 * @modified By:
 */
public interface SysUserRoleMapper {

    /**
     * 根据主键删除用户角色
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 新增用户角色
     * @param role
     * @return
     */
    int insert(SysUserRole role);
    /**
     * 查询所有权限列表
     * @return
     */
    List<SysUserRole> selectAll();
    /**
     * 根据主键查询用户角色
     * @param id
     * @return
     */
    SysUserRole selectByPrimaryKey(String id);
    /**
     * 根据主键更新用户角色
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysUserRole record);
    /**
     * 批量删除权限
     * @param id
     */
    void deleteBy(String[] id);
    /**
     * 根据角色id删除用户角色
     * @param id
     */
    void deleteByRoleIds(String[] id);

    /**
     * 批量插入用户角色
     * @param sysUserRoles
     */
    void insertBatch(List<SysUserRole> sysUserRoles);



}