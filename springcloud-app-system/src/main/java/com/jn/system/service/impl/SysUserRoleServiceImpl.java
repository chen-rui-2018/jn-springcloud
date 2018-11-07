package com.jn.system.service.impl;

import com.jn.system.dao.SysUserRoleMapper;
import com.jn.system.dao.TbSysUserRoleMapper;
import com.jn.system.entity.TbSysUserRole;
import com.jn.system.model.SysUserRole;
import com.jn.system.model.User;
import com.jn.system.service.SysUserRoleService;
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
 * 用户角色ServiceImpl
 *
 * @author： yuanyy
 * @date： Created on 2018/11/2 11:40
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    private Logger logger = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

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
    @Transactional(rollbackFor = Exception.class)
    public void insertTbUserRole(SysUserRole role) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        role.setId(UUID.randomUUID().toString());
        role.setCreator(user.getId());
        TbSysUserRole tbSysUserRole=new TbSysUserRole();
        BeanUtils.copyProperties(role, tbSysUserRole);
        tbSysUserRoleMapper.insert(tbSysUserRole);
        logger.info("message={}", "新增用户角色,userId=" +role.getId()+",roleId="+role.getRoleId());

    }

    /**
     * 更新用户角色信息
     *
     * @param role
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTbUserRole(SysUserRole role) {
        TbSysUserRole tbSysUserRole=new TbSysUserRole();
        BeanUtils.copyProperties(role, tbSysUserRole);
        tbSysUserRoleMapper.updateByPrimaryKeySelective(tbSysUserRole);
        logger.info("message={}", "更新用户角色,userId=" +role.getId()+",roleId="+role.getRoleId());

    }

    /**
     * 根据角色id批量删除用户角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbUserRoleByRoleIds(String[] roleIds) {
        sysUserRoleMapper.deleteByRoleIds(roleIds);
        logger.info("message={}", "根据角色id批量删除用户角色（逻辑删除）,roleIds=" + Arrays.toString(roleIds));
    }

    /**
     * 批量删除用户角色（逻辑删除）
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbUserRoleById(String[] ids) {
        sysUserRoleMapper.deleteByIds(ids);
        logger.info("message={}", "批量删除用户角色（逻辑删除）,ids=" + Arrays.toString(ids));
    }

    /**
     * 批量插入用户角色
     *
     * @param sysUserRoles
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTbUserRoleBatch(List<SysUserRole> sysUserRoles) {
        sysUserRoleMapper.insertBatch(sysUserRoles);
    }
}
