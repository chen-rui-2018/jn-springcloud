package com.jn.system.service.impl;

import com.jn.system.dao.SysUserGroupRoleMapper;
import com.jn.system.model.SysUserGroupRole;
import com.jn.system.service.SysUserGroupRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户组角色service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/2 14:22
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserGroupRoleServiceImpl implements SysUserGroupRoleService {
    @Resource
    private SysUserGroupRoleMapper sysUserGroupRoleMapper;


    /**
     * 新增用户组角色
     *
     * @param userGroupRole
     */
    @Override
    public void insertTbUserGroupRole(SysUserGroupRole userGroupRole) {
        sysUserGroupRoleMapper.insert(userGroupRole);
    }

    /**
     * 更新用户组角色信息
     *
     * @param userGroupRole
     */
    @Override
    public void updateTbUserGroupRole(SysUserGroupRole userGroupRole) {
        sysUserGroupRoleMapper.updateByPrimaryKey(userGroupRole);
    }

    /**
     * 根据角色id批量删除用户组角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    public void deleteTbUserGroupRoleByRoleIds(String[] roleIds) {
        sysUserGroupRoleMapper.deleteByRoleIds(roleIds);
    }

    /**
     * 批量删除用户组角色（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    public void deleteTbUserGroupRoleById(String[] ids) {
        sysUserGroupRoleMapper.deleteBy(ids);
    }

    /**
     * 批量插入用户组角色
     *
     * @param sysUserGroupRoles
     */
    @Override
    public void insertTbUserGroupRoleBatch(List<SysUserGroupRole> sysUserGroupRoles) {
        sysUserGroupRoleMapper.insertBatch(sysUserGroupRoles);
    }
}
