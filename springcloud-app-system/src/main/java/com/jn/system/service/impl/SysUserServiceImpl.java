package com.jn.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jn.common.model.GetEasyUIData;
import com.jn.common.model.Result;
import com.jn.system.dao.SysGroupMapper;
import com.jn.system.dao.SysRoleMapper;
import com.jn.system.dao.SysUserMapper;
import com.jn.system.model.UserQuery;
import com.jn.system.service.SysUserService;
import com.jn.system.vo.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * 用户dao
 *
 * @author： shaobao
 * @date： Created on 2018/10/31 13:07
 * @version： v1.0
 * @modified By:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysGroupMapper sysGroupMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addSysUser(SysUser sysUser) {
        sysUser.setId(UUID.randomUUID().toString());
        //用户添加,默认密码123456
        sysUser.setPassword(DigestUtils.md5Hex("123456"));
        sysUser.setCreateTime(new Date());
        SysUser tbSysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        sysUser.setCreator(tbSysUser.getId());
        sysUserMapper.addSysUser(sysUser);
    }

    /**
     * 分页查询用户,返回用户信息及部门岗位
     * @param userUserQuery
     * @return
     */
    @Override
    public Result findSysUserByPage(UserQuery userUserQuery) {
        //分页查询
        Page<Object> objects = PageHelper.startPage(userUserQuery.getPage(), userUserQuery.getRows());
        GetEasyUIData getEasyUIData = null;
        //判断传过来参数是否有查询条件
        if(StringUtils.isBlank(userUserQuery.getDepartmentId())){
            List<SysUser> sysUserList = sysUserMapper.findSysUserByPage(userUserQuery);
            //遍历用户,获取用户默认部门岗位
            for (SysUser sysUser:sysUserList) {
                UserQuery query = new UserQuery();
                query.setId(sysUser.getId());
                query.setIsDefault("1");
                List<SysUser> sysUserListOne = sysUserMapper.findSysUserByPageAndOption(query);
                if (sysUserListOne.size() == 1){
                    for (SysUser sysUser1:sysUserListOne) {
                        sysUser.setSysDepartmentPostList(sysUser1.getSysDepartmentPostList());
                    }
                }
            }
            getEasyUIData = new GetEasyUIData(sysUserList,objects.getTotal());
        }else{
            getEasyUIData = new GetEasyUIData(sysUserMapper.findSysUserByPageAndOption(userUserQuery),objects.getTotal());
        }

        //参数回显
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", userUserQuery.getName());
        map.put("status", userUserQuery.getStatus());
        map.put("dapartmentId", userUserQuery.getDepartmentId());
        map.put("getEasyUIData",getEasyUIData);
        return new Result(map);
    }

    /**
     * 删除用户
     * @param ids
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteSysUser(String[] ids) {
        for (String id:ids) {
            sysUserMapper.deleteSysUser(id);
        }
    }

    /**
     * 更新用户
     * @param sysUser
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSysUser(SysUser sysUser) {
        sysUser.setCreateTime(new Date());
        if(StringUtils.isNotBlank(sysUser.getPassword())){
            sysUser.setPassword(DigestUtils.md5Hex(sysUser.getPassword()));
        }
        sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 根据用户id获取用户已经存在的用户组及其他用户组
     * @param id
     * @return
     */
    @Override
    public Result findSysGroupByUserId(String id) {
        //根据用户id查询用户组
        List<SysGroup> sysGroupOfUser = sysGroupMapper.findSysGroupByUserId(id);
        //获取所有用户组
        List<SysGroup> sysGroupAll = sysGroupMapper.findSysGroupAll();
        if (sysGroupOfUser != null && sysGroupOfUser.size() > 0){
            for (SysGroup sysGroup: sysGroupOfUser) {
                //排除用户已经具有的用户
                if(sysGroupAll.contains(sysGroup)){
                    sysGroupAll.remove(sysGroup);
                }
            }
        }
        //将用户具有的用户组及其他用户组返回
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sysGroupOfUser",sysGroupOfUser);
        map.put("sysGroupAll",sysGroupAll);
        return new Result(map);
    }

    /**
     * 往用户中添加用户组
     * @param groupIds
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysGroupToSysUser(String[] groupIds, String userId) {
        if(groupIds != null && groupIds.length > 0){
            //清除用户中已经存在的用户组
            sysUserMapper.deleGroupOfUser(userId);
            if (groupIds.length > 0){
                //往用户中添加新的用户组
                for (String groupId: groupIds) {
                    //设置用户用户组实体类
                    SysUserGroup sysUserGroup = new SysUserGroup();
                    sysUserGroup.setCreateTime(new Date());
                    SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
                    sysUserGroup.setCreator(sysUser.getId());
                    sysUserGroup.setGroupId(groupId);
                    sysUserGroup.setUserId(userId);
                    sysUserGroup.setId(UUID.randomUUID().toString());
                    sysUserGroup.setStatus("1");
                    sysUserMapper.saveSysGroupToSysUser(sysUserGroup);
                }
            }
        }
    }

    /**
     * 根据用户id获取用户具有角色及其他角色
     * @param id
     * @return
     */
    @Override
    public Result findSysRoleByUserId(String id) {
        //或取用户已经具有角色
        List<SysRole> sysRoleOfUser = sysRoleMapper.findSysRoleByUserId(id);
        List<SysRole> sysRoleAll = sysRoleMapper.findSysRoleAll();
        if(sysRoleOfUser != null && sysRoleOfUser.size() >0){
            for (SysRole sysRole:sysRoleOfUser) {
                if(sysRoleAll.contains(sysRole)){
                    sysRoleAll.remove(sysRole);
                }
            }
        }
        //将用户具有的角色及其他角色返回
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("sysRoleOfUser",sysRoleOfUser);
        map.put("sysRoleAll",sysRoleAll);
        return new Result(map);
    }

    /**
     * 为用户添加角色权限
     * @param roleIds
     * @param userId
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSysRoleToSysUser(String[] roleIds, String userId) {
        //清除用户中已经存在的角色
        sysUserMapper.deleRoleOfUser(userId);
        if (roleIds != null && roleIds.length > 0){
            //为用户添加新的角色
            for (String roleId:roleIds) {
                SysUserRole sysUserRole = new SysUserRole();
                sysUserRole.setCreateTime(new Date());
                SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
                sysUserRole.setCreator(sysUser.getId());
                sysUserRole.setRoleId(roleId);
                sysUserRole.setUserId(userId);
                sysUserRole.setId(UUID.randomUUID().toString());
                sysUserRole.setStatus("1");
                sysUserMapper.saveSysRoleToSysUser(sysUserRole);
            }
        }
    }

    /**
     * 根据用户id查询用户已经具有的部门岗位信息及用户信息
     * @param userId
     * @return
     */
    @Override
    public Result findDepartmentandPostByUserId(String userId) {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(userId);
        //设置默认查询用户部门岗位为有效状态数据
        userQuery.setUdpStatus("1");
        List<SysUser> sysUserList = sysUserMapper.findSysUserByPageAndOption(userQuery);
        return new Result(sysUserList);
    }

    /**
     * 为用户添加部门岗位
     * @param sysUserId 用户id
     * @param sysUserDepartmentPostlist 岗位,部门列表集合
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveDepartmentandPostOfUser(String sysUserId, List<SysUserDepartmentPost> sysUserDepartmentPostlist) {
        //清除用户已有岗位部门列表
        sysUserMapper.deleDepartmentandPost(sysUserId);
        if (sysUserDepartmentPostlist != null && sysUserDepartmentPostlist.size() > 0){
            //为用户添加新部门岗位信息
            for (SysUserDepartmentPost sysUserDepartmentPost:sysUserDepartmentPostlist) {
                sysUserDepartmentPost.setCreateTime(new Date());
                SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
                sysUserDepartmentPost.setCreator(sysUser.getId());
                sysUserDepartmentPost.setId(UUID.randomUUID().toString());
                sysUserDepartmentPost.setStatus("1");
                sysUserDepartmentPost.setUserId(sysUserId);
                sysUserMapper.saveDepartmentandPostOfUser(sysUserDepartmentPost);
            }
        }

    }

    /**
     * 根据用户id返回用户信息
     * @param id
     * @return
     */
    @Override
    public Result findSysUserById(String id) {
        SysUser sysUser = sysUserMapper.findSysUserById(id);
        return new Result(sysUser);
    }
}
