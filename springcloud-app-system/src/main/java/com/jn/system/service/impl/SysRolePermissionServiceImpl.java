package com.jn.system.service.impl;

import com.jn.system.dao.SysRolePermissionMapper;
import com.jn.system.dao.TbSysRolePermissionMapper;
import com.jn.system.entity.TbSysRolePermission;
import com.jn.system.model.SysRolePermission;
import com.jn.system.model.User;
import com.jn.system.service.SysRolePermissionService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

    private Logger logger = LoggerFactory.getLogger(SysRolePermissionServiceImpl.class);

    @Resource
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Resource
    private TbSysRolePermissionMapper tbSysRolePermissionMapper;

    /**
     * 新增角色权限
     *
     * @param rolePermission
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTbRolePermission(SysRolePermission rolePermission) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        rolePermission.setId(UUID.randomUUID().toString());
        rolePermission.setCreator(user.getId());
        TbSysRolePermission tbSysRolePermission =new TbSysRolePermission();
        BeanUtils.copyProperties(rolePermission, tbSysRolePermission);
        tbSysRolePermissionMapper.insert(tbSysRolePermission);
        logger.info("[角色权限] 添加角色权限成功！,rolePermissionId：{}" + rolePermission.getId());

    }

    /**
     * 更新角色权限信息
     *
     * @param rolePermission
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTbRolePermission(SysRolePermission rolePermission) {
        TbSysRolePermission tbSysRolePermission =new TbSysRolePermission();
        BeanUtils.copyProperties(rolePermission, tbSysRolePermission);
        tbSysRolePermissionMapper.updateByPrimaryKey(tbSysRolePermission);
        logger.info("[角色权限] 更新角色权限成功！,rolePermissionId：{}" , rolePermission.getId());
    }

    /**
     * 根据角色id批量删除角色权限（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbRolePermissionByRoleIds(String[] roleIds) {
        sysRolePermissionMapper.deleteByRoleIds(roleIds);
        logger.info("[角色权限] 根据角色id批量删除角色权限限（逻辑删除）成功！,roleIds：{}" , Arrays.toString(roleIds));
    }

    /**
     * 批量删除角色权限（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbRolePermissionByIds(String[] ids) {
        sysRolePermissionMapper.deleteBy(ids);
        logger.info("[角色权限] 批量删除角色权限（逻辑删除）成功！,ids:{}" ,  Arrays.toString(ids));
    }

    /**
     * 批量插入角色权限
     *
     * @param sysRolePermissions
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTbRolePermissionBatch(List<SysRolePermission> sysRolePermissions) {
        sysRolePermissionMapper.insertBatch(sysRolePermissions);
    }
}
