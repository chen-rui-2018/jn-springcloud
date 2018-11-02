package com.jn.system.dao;

import com.jn.system.vo.TbSysRole;

import java.util.List;

/**
 * 角色dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/30 15:47
 * @version： v1.0
 * @modified By:
 */
public interface SysRoleMapper {

    /**
     * 根据角色id获取对应角色
     * @param roleId
     * @return
     */
    TbSysRole findSysRoleByid(String roleId);

    /**
     * 查询所有角色
     * @return
     */
    List<TbSysRole> findSysRoleAll();

    /**
     * 根据用户id获取用户已经具有的角色
     * @return
     */
    List<TbSysRole> findSysRoleByUserId(String id);
}
