package com.jn.system.permission.service.impl;

import com.jn.system.log.annotation.ServiceLog;
import com.jn.system.model.User;
import com.jn.system.permission.service.SysUserRoleService;
import com.jn.system.user.dao.SysUserRoleMapper;
import com.jn.system.user.dao.TbSysUserRoleMapper;
import com.jn.system.user.entity.TbSysUserRole;
import com.jn.system.user.model.SysUserRole;
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
 * 用户角色ServiceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/2 11:40
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    private static Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Resource
    private TbSysUserRoleMapper tbSysUserRoleMapper;

    /**
     * 新增用户角色
     *
     * @param role
     */
    @Override
    @ServiceLog(doAction = "新增用户角色")
    @Transactional(rollbackFor = Exception.class)
    public void insertTbUserRole(SysUserRole role, User user) {
        role.setId(UUID.randomUUID().toString());
        role.setCreatorAccount(user.getAccount());
        TbSysUserRole tbSysUserRole = new TbSysUserRole();
        BeanUtils.copyProperties(role, tbSysUserRole);
        tbSysUserRoleMapper.insert(tbSysUserRole);
        logger.info("[用户角色] 新增用户角色成功！,userId: {},roleId: {}", role.getId(), role.getRoleId());

    }

    /**
     * 更新用户角色信息
     *
     * @param role
     */
    @Override
    @ServiceLog(doAction = "更新用户角色信息")
    @Transactional(rollbackFor = Exception.class)
    public void updateTbUserRole(SysUserRole role) {
        TbSysUserRole tbSysUserRole = new TbSysUserRole();
        BeanUtils.copyProperties(role, tbSysUserRole);
        tbSysUserRoleMapper.updateByPrimaryKeySelective(tbSysUserRole);
        logger.info("[用户角色] 更新用户角色成功！,userId: {},roleId: {}", role.getId(), role.getRoleId());

    }

    /**
     * 根据角色id批量删除用户角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    @ServiceLog(doAction = "根据角色id批量删除用户角色（逻辑删除）")
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbUserRoleByRoleIds(String[] roleIds) {
        sysUserRoleMapper.deleteByRoleIds(roleIds);
        logger.info("[用户角色] 根据角色id批量删除用户角色（逻辑删除）成功！,roleIds: {}", Arrays.toString(roleIds));
    }

    /**
     * 批量删除用户角色（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    @ServiceLog(doAction = "批量删除用户角色（逻辑删除）")
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbUserRoleById(String[] ids) {
        sysUserRoleMapper.deleteByIds(ids);
        logger.info("[用户角色] 批量删除用户角色（逻辑删除）成功！,ids: {}", Arrays.toString(ids));
    }

    /**
     * 批量插入用户角色
     *
     * @param sysUserRoles
     */
    @Override
    @ServiceLog(doAction = "批量插入用户角色")
    @Transactional(rollbackFor = Exception.class)
    public void insertTbUserRoleBatch(List<SysUserRole> sysUserRoles) {
        sysUserRoleMapper.insertBatch(sysUserRoles);
    }
}
