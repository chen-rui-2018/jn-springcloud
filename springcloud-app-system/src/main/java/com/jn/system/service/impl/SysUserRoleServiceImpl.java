package com.jn.system.service.impl;

import com.jn.system.dao.SysUserRoleMapper;
import com.jn.system.model.SysUserRole;
import com.jn.system.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * 用户角色ServiceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/2 11:40
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    /**
     * 新增用户角色
     *
     * @param role
     */
    @Override
    public void insertTbUserRole(SysUserRole role) {
        sysUserRoleMapper.insert(role);
    }

    /**
     * 更新用户角色信息
     *
     * @param role
     */
    @Override
    public void updateTbUserRole(SysUserRole role) {
        sysUserRoleMapper.updateByPrimaryKey(role);

    }

    /**
     * 根据角色id批量删除用户角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    public void deleteTbUserRoleByRoleIds(String[] roleIds) {
        sysUserRoleMapper.deleteByRoleIds(roleIds);
    }

    /**
     * 批量删除用户角色（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    public void deleteTbUserRoleById(String[] ids) {
        sysUserRoleMapper.deleteBy(ids);
    }

    /**
     * 批量插入用户角色
     *
     * @param sysUserRoles
     */
    @Override
    public void insertTbUserRoleBatch(List<SysUserRole> sysUserRoles) {
        sysUserRoleMapper.insertBatch(sysUserRoles);
    }
}
