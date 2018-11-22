package com.jn.system.service.impl;

import com.jn.system.dao.SysUserGroupRoleMapper;
import com.jn.system.dao.TbSysGroupRoleMapper;
import com.jn.system.entity.TbSysGroupRole;
import com.jn.system.model.SysUserGroupRole;
import com.jn.system.model.User;
import com.jn.system.service.SysUserGroupRoleService;
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
 * 用户组角色service
 *
 * @author： yuanyy
 * @date： Created on 2018/11/2 14:22
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserGroupRoleServiceImpl implements SysUserGroupRoleService {
    private Logger logger = LoggerFactory.getLogger(SysUserGroupRoleServiceImpl.class);

    @Resource
    private SysUserGroupRoleMapper sysUserGroupRoleMapper;

    @Resource
    private TbSysGroupRoleMapper tbSysGroupRoleMapper;

    /**
     * 新增用户组角色
     *
     * @param userGroupRole
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTbUserGroupRole(SysUserGroupRole userGroupRole, User user ) {
        userGroupRole.setCreator(user.getId());
        userGroupRole.setId(UUID.randomUUID().toString());
        TbSysGroupRole tbSysGroupRole =new TbSysGroupRole();
        BeanUtils.copyProperties(userGroupRole, tbSysGroupRole);
        tbSysGroupRoleMapper.insert(tbSysGroupRole);

        logger.info("[用户组角色] 添加用户组角色成功！,userGroupRoleId: {},roleId: {}",userGroupRole.getId(),userGroupRole.getRoleId());
    }

    /**
     * 更新用户组角色信息
     *
     * @param userGroupRole
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTbUserGroupRole(SysUserGroupRole userGroupRole) {
        TbSysGroupRole tbSysGroupRole =new TbSysGroupRole();
        BeanUtils.copyProperties(userGroupRole, tbSysGroupRole);
        tbSysGroupRoleMapper.updateByPrimaryKeySelective(tbSysGroupRole);
        logger.info("[用户组角色] 更新用户组角色成功！,userGroupRoleId: {},roleId: {}",userGroupRole.getId(),userGroupRole.getRoleId());

    }

    /**
     * 根据角色id批量删除用户组角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbUserGroupRoleByRoleIds(String[] roleIds) {
        sysUserGroupRoleMapper.deleteByRoleIds(roleIds);
        logger.info("[用户组角色] 根据角色id批量删除用户组角色（逻辑删除）成功！,roleIds: {}" , Arrays.toString(roleIds));

    }

    /**
     * 批量删除用户组角色（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbUserGroupRoleById(String[] ids) {
        sysUserGroupRoleMapper.deleteBy(ids);
        logger.info("[用户组角色] 根据角色id批量删除用户组角色（逻辑删除）成功！,ids: {}" , Arrays.toString(ids));
    }

    /**
     * 批量插入用户组角色
     *
     * @param sysUserGroupRoles
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTbUserGroupRoleBatch(List<SysUserGroupRole> sysUserGroupRoles) {
        sysUserGroupRoleMapper.insertBatch(sysUserGroupRoles);
    }
}
