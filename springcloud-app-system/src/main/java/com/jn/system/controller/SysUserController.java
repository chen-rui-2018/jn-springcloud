package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.SysUser;
import com.jn.system.model.SysUserDepartmentPostAdd;
import com.jn.system.model.SysUserPage;
import com.jn.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "用户管理及用户授权")
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @RequiresPermissions("/system/sysUser/addSysUser")
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addSysUser")
    public Result addSysUser(@Validated @RequestBody SysUser sysUser) {
        sysUserService.addSysUser(sysUser);
        return new Result();
    }

    @CrossOrigin
    @RequiresPermissions("/system/sysUser/findSysUserByPage")
    @ApiOperation(value = "分页条件查询用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysUserByPage")
    public Result findSysUserByPage(@Validated @RequestBody SysUserPage userSysUserPage) {
        return sysUserService.findSysUserByPage(userSysUserPage);
    }

    @RequiresPermissions("/system/sysUser/findSysUserById")
    @ApiOperation(value = "根据用户id返回用户信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysUserById")
    public Result findSysUserById(String id) {
        return sysUserService.findSysUserById(id);
    }

    @RequiresPermissions("/system/sysUser/deleteSysUser")
    @ApiOperation(value = "删除用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteSysUser")
    public Result deleteSysUser(String[] ids) {
        sysUserService.deleteSysUser(ids);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/updateSysUser")
    @ApiOperation(value = "更新用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateSysUser")
    public Result updateSysUser(@Validated @RequestBody SysUser sysUser) {
        sysUserService.updateSysUser(sysUser);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/findSysGroupByUserId")
    @ApiOperation(value = "根据用户id获取用户已经存在的用户组及其他用户组", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysGroupByUserId")
    public Result findSysGroupByUserId(String id) {
        return sysUserService.findSysGroupByUserId(id);
    }

    @RequiresPermissions("/system/sysUser/saveSysGroupToSysUser")
    @ApiOperation(value = "添加用户组到用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveSysGroupToSysUser")
    public Result saveSysGroupToSysUser(String[] groupIds, String userId) {
        sysUserService.saveSysGroupToSysUser(groupIds, userId);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/findSysRoleByUserId")
    @ApiOperation(value = "根据用户id获取用户具有角色及其他角色", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysRoleByUserId")
    public Result findSysRoleByUserId(String id) {
        return sysUserService.findSysRoleByUserId(id);
    }

    @RequiresPermissions("/system/sysUser/saveSysRoleToSysUser")
    @ApiOperation(value = "为用户添加角色权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveSysRoleToSysUser")
    public Result saveSysRoleToSysUser(String[] roleIds, String userId) {
        sysUserService.saveSysRoleToSysUser(roleIds, userId);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/findDepartmentandPostByUserId")
    @ApiOperation(value = "根据用户id查询用户已经具有的岗位及用户信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findDepartmentandPostByUserId")
    public Result findDepartmentandPostByUserId(String userId) {
        return sysUserService.findDepartmentandPostByUserId(userId);
    }

    @RequiresPermissions("/system/sysUser/saveDepartmentandPostOfUser")
    @ApiOperation(value = "为用户添加部门岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveDepartmentandPostOfUser")
    public Result saveDepartmentandPostOfUser(@Validated @RequestBody SysUserDepartmentPostAdd sysUserDepartmentPostAdd) {
        Assert.notNull(sysUserDepartmentPostAdd.getUserId(), "用户id不能为空");
        sysUserService.saveDepartmentandPostOfUser(sysUserDepartmentPostAdd);
        return new Result();
    }

}
