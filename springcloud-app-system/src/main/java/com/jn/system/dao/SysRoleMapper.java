package com.jn.system.dao;

import com.jn.system.model.SysRole;
import com.jn.system.model.SysRolePage;
import com.jn.system.vo.SysRoleVO;

import java.util.List;

/**
 * 角色dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:47
 * @version： v2.0
 * @modified By:yuanyy
 */
public interface SysRoleMapper {

    /**
     * 根据角色id获取对应角色
     * @param roleId
     * @return
     */
    SysRole findSysRoleByid(String roleId);

    /**
     * 查询所有角色
     * @return
     */
    List<SysRole> findSysRoleAll();

    /**
     * 根据用户id获取用户已经具有的角色
     * @return
     */
    List<SysRole> findSysRoleByUserId(String id);


    /**
     * 根据主键删除角色
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 插入角色
     * @param role
     * @return
     */
    int insert(SysRole role);

    /**
     * 根据主键查询角色
     * @param id
     * @return
     */
    SysRole selectByPrimaryKey(String id);

    /**
     *根据主键更新角色
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysRole record);

    /**
     * 分页查询
     * @param role
     * @return
     */
    List<SysRoleVO> findTByPage(SysRolePage role);

    /**
     * 批量删除
     * @param id
     */
    void deleteBy(String[] id);

    /**
     * 根据主键查询角色、用户角色、角色权限列表
     * @param id
     * @return
     */
    SysRoleVO selectTbRoleVOByPrimaryKey(String id);
}
