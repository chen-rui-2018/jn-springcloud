package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.GetEasyUIData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysRoleMapper;
import com.jn.system.model.*;
import com.jn.system.service.SysRolePermissionService;
import com.jn.system.service.SysRoleService;
import com.jn.system.service.SysUserGroupRoleService;
import com.jn.system.service.SysUserRoleService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * 角色service
 * @author： shaobao
 * @date： Created on 2018/11/1 16:23
 * @version： v2.0
 * @modified By:yuanyy
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    private Logger logger = LoggerFactory.getLogger(SysRoleServiceImpl.class);



    @Resource
    private SysRoleMapper sysRoleMapper;




    @Autowired
    private SysUserRoleService userRoleService;

    @Autowired
    private SysRolePermissionService rolePermissionService;

    @Autowired
    private SysUserGroupRoleService sysUserGroupRoleService;
    /**
     * 查询所有角色
     * @return
     */
    @Override
    public Result findSysRoleAll() {
        return new Result(sysRoleMapper.findSysRoleAll());
    }


    /**
     * 新增角色
     *
     * @param role
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertTbRole(SysRole role) {
        role.setId(UUID.randomUUID().toString());
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        role.setCreator(user.getId());
        sysRoleMapper.insert(role);
        logger.info("message{}", "新增角色成功！，roleId=" + role.getId());

    }

    /**
     * 更新角色信息
     *
     * @param role
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTbRole(SysRole role) {
        sysRoleMapper.updateByPrimaryKey(role);

    }

    /**
     * 批量删除角色（逻辑删除）
     *
     * @param roleIds
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTbRoleById(String[] roleIds) {
        sysRoleMapper.deleteBy(roleIds);
        userRoleService.deleteTbUserRoleByRoleIds(roleIds);
        rolePermissionService.deleteTbRolePermissionByRoleIds(roleIds);
        logger.info("message{}", "删除角色成功！，roleIds=" + roleIds.toString());
    }

    /**
     * 分页查询角色授权列表信息
     *
     * @param rolePage
     * @return
     */
    @Override
    public GetEasyUIData selectRoleListBySearchKey(SysRolePage rolePage) {
        Page<Object> objects = PageHelper.startPage(rolePage.getPage(), rolePage.getRows());
        return new GetEasyUIData(sysRoleMapper.findTByPage(rolePage)
                , objects.getTotal());

    }

    /**
     * 添加角色授权（用户）
     *
     * @param sysUserRoleAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void userRoleAuthorization(SysUserRoleAdd sysUserRoleAdd) {
        String[] roleIds = {sysUserRoleAdd.getRoleId()};
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //批量插入用户角色信息
        List<SysUserRole> sysUserRoleList = new ArrayList<>();
        for (int i = 0; i < sysUserRoleAdd.getUserId().length; i++) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setId(UUID.randomUUID().toString());
            sysUserRole.setStatus(sysUserRoleAdd.getStatus());
            sysUserRole.setCreator(user.getId());
            sysUserRole.setUserId(sysUserRoleAdd.getUserId()[i]);
            sysUserRole.setRoleId(sysUserRoleAdd.getRoleId());
            sysUserRoleList.add(sysUserRole);
            logger.info("message={}","添加角色授权用户，roleId="+roleIds.toString()+"userId="+ sysUserRoleAdd.getUserId()[i]);
        }

        //插入前删除该角色的所有用户角色数据
        userRoleService.deleteTbUserRoleByRoleIds(roleIds);
        logger.info("message={}","添加角色授权用户,插入前删除该角色的所有用户角色数据，roleId="+Arrays.toString(roleIds));
        //批量插入用户角色信息
        userRoleService.insertTbUserRoleBatch(sysUserRoleList);

    }

    /**
     * 添加角色授权（权限）
     *
     * @param sysRolePermissionAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void rolePermissionAuthorization(SysRolePermissionAdd sysRolePermissionAdd) {
        String[] roleIds = {sysRolePermissionAdd.getRoleId()};
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //批量插入用户角色信息
        List<SysRolePermission> sysRolePermissionList = new ArrayList<>();
        for (int i = 0; i < sysRolePermissionAdd.getPermissionId().length; i++) {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setId(UUID.randomUUID().toString());
            sysRolePermission.setStatus(sysRolePermissionAdd.getStatus());
            sysRolePermission.setCreator(user.getId());
            sysRolePermission.setPermissionId(sysRolePermissionAdd.getPermissionId()[i]);
            sysRolePermission.setRoleId(sysRolePermissionAdd.getRoleId());
            sysRolePermissionList.add(sysRolePermission);
            logger.info("message={}","添加角色授权权限，roleId="+roleIds.toString()+"userId="+ sysRolePermissionAdd.getPermissionId()[i]);


        }
        //插入前删除该角色的所有角色权限数据
        rolePermissionService.deleteTbRolePermissionByRoleIds(roleIds);
        logger.info("message={}","添加角色授权权限,插入前删除该角色的所有角色权限数据，roleId="+Arrays.toString(roleIds));
        //批量插入角色权限
        rolePermissionService.insertTbRolePermissionBatch(sysRolePermissionList);

    }

    /**
     * 添加角色授权（用户组）
     *
     * @param sysUserGroupRoleAdd
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void UserGroupRoleAuthorization(SysUserGroupRoleAdd sysUserGroupRoleAdd) {
        String[] roleIds = {sysUserGroupRoleAdd.getRoleId()};
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<SysUserGroupRole> sysUserGroupRoleList = new ArrayList<>();
        for (int i = 0; i < sysUserGroupRoleAdd.getUserGroupId().length; i++) {

            SysUserGroupRole sysUserGroupRole = new SysUserGroupRole();
            sysUserGroupRole.setId(UUID.randomUUID().toString());
            sysUserGroupRole.setStatus(sysUserGroupRoleAdd.getStatus());
            sysUserGroupRole.setCreator(user.getId());
            sysUserGroupRole.setUserGroupId(sysUserGroupRoleAdd.getUserGroupId()[i]);
            sysUserGroupRole.setRoleId(sysUserGroupRoleAdd.getRoleId());
            sysUserGroupRoleList.add(sysUserGroupRole);
            logger.info("message={}","添加角色授权用户组，roleId="+roleIds.toString()+"userId="+ sysUserGroupRoleAdd.getUserGroupId()[i]);

        }
        //插入前删除该角色的所有用户组角色数据
        sysUserGroupRoleService.deleteTbUserGroupRoleByRoleIds(roleIds);
        logger.info("message={}","添加角色授权用户组,插入前删除该角色的所有用户组角色数据，roleId="+Arrays.toString(roleIds));
        //批量插入用户组角色
        sysUserGroupRoleService.insertTbUserGroupRoleBatch(sysUserGroupRoleList);
    }

}
