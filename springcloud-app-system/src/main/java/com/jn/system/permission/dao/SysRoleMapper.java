package com.jn.system.permission.dao;

import com.jn.system.permission.model.SysRole;
import com.jn.system.permission.model.SysRolePage;
import com.jn.system.permission.vo.SysRoleVO;

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
     * 查询所有角色
     *
     * @return
     */
    List<SysRole> findSysRoleAll();

    /**
     * 根据用户id获取用户已经具有的角色
     *
     * @param id
     * @return
     */
    List<SysRole> findSysRoleByUserId(String id);


    /**
     * 根据主键查询角色、用户角色、角色权限列表
     *
     * @param role
     * @return
     */
    List<SysRoleVO> findTByPage(SysRolePage role);

    /**
     * 批量删除
     *
     * @param id
     */
    void deleteBy(String[] id);

    /**
     * 根据id获取角色信息
     *
     * @param id
     * @return
     */
    SysRole getRoleById(String id);
}
