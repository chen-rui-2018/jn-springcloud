package com.jn.system.service.impl;

import com.jn.system.dao.SysRolePermissionMapper;
import com.jn.system.model.SysRolePermission;
import com.jn.system.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户权限ServiceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/2 11:39
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;
    /**
     * 新增角色权限
     *
     * @param rolePermission
     */
    @Override
    public void insertTbRolePermission(SysRolePermission rolePermission) {
        sysRolePermissionMapper.insert(rolePermission);
    }

    /**
     * 更新角色权限信息
     *
     * @param rolePermission
     */
    @Override
    public void updateTbRolePermission(SysRolePermission rolePermission) {
        sysRolePermissionMapper.updateByPrimaryKey(rolePermission);
    }

    /**
     * 根据角色id批量删除角色权限（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    public void deleteTbRolePermissionByRoleIds(String[] roleIds) {
        sysRolePermissionMapper.deleteByRoleIds(roleIds);

    }

    /**
     * 批量删除角色权限（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    public void deleteTbRolePermissionByIds(String[] ids) {
        sysRolePermissionMapper.deleteBy(ids);
    }

    /**
     * 批量插入角色权限
     *
     * @param sysRolePermissions
     */
    @Override
    public void insertTbRolePermissionBatch(List<SysRolePermission> sysRolePermissions) {
        sysRolePermissionMapper.insertBatch(sysRolePermissions);
    }
}
