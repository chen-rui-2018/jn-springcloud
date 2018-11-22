package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.*;
import com.jn.system.service.SysUserService;
import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.system.vo.SysUserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.addSysUser(sysUser,user);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/findSysUserByPage")
    @ApiOperation(value = "分页条件查询用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysUserByPage")
    public Result findSysUserByPage(@Validated @RequestBody SysUserPage userSysUserPage) {
        PaginationData data = sysUserService.findSysUserByPage(userSysUserPage);
        return new Result(data);
    }

    @RequiresPermissions("/system/sysUser/findSysUserById")
    @ApiOperation(value = "根据用户id返回用户信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysUserById")
    public Result findSysUserById(String id) {
        SysUser sysUser = sysUserService.findSysUserById(id);
        return new Result(sysUser);
    }

    @RequiresPermissions("/system/sysUser/deleteSysUser")
    @ApiOperation(value = "删除用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteSysUser")
    public Result deleteSysUser(@Validated @RequestBody SysUserDelete sysUserDelete) {
        sysUserService.deleteSysUser(sysUserDelete.getUserIds());
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
    @ApiOperation(value = "根据用户id获取用户已经存在的用户组及条件分页获取未拥有的用户组",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysGroupByUserId")
    public Result findSysGroupByUserId(@Validated @RequestBody SysUserGroupPage sysUserGroupPage) {
        PaginationData data = sysUserService.findSysGroupByUserId(sysUserGroupPage);
        return new Result(data);
    }

    @RequiresPermissions("/system/sysUser/saveSysGroupToSysUser")
    @ApiOperation(value = "添加用户组到用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveSysGroupToSysUser")
    public Result saveSysGroupToSysUser(@Validated @RequestBody SysUserGroupAdd sysUserGroupAdd) {
        Assert.notNull(sysUserGroupAdd.getUserId(),"用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveSysGroupToSysUser(sysUserGroupAdd.getGroupIds(), sysUserGroupAdd.getUserId(),user);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/findSysRoleByUserId")
    @ApiOperation(value = "根据用户id获取用户具有角色及条件分页获取用户未拥有角色信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysRoleByUserId")
    public Result findSysRoleByUserId(@Validated @RequestBody SysUserRolePage sysUserRolePage) {
        SysUserRoleVO sysUserRoleVO = sysUserService.findSysRoleByUserId(sysUserRolePage);
        return new Result(sysUserRoleVO);
    }

    @RequiresPermissions("/system/sysUser/saveSysRoleToSysUser")
    @ApiOperation(value = "为用户添加角色权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveSysRoleToSysUser")
    public Result saveSysRoleToSysUser(@Validated @RequestBody SysRoleUserAdd sysRoleUserAdd) {
        Assert.notNull(sysRoleUserAdd.getUserId(),"用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveSysRoleToSysUser(sysRoleUserAdd.getRoleIds(), sysRoleUserAdd.getUserId(),user);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/findDepartmentandPostByUserId")
    @ApiOperation(value = "根据用户id查询用户已经具有的岗位部门信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findDepartmentandPostByUserId")
    public Result findDepartmentandPostByUserId(String userId) {
        List<SysDepartmentPostVO> sysDepartmentPostVOList = sysUserService.findDepartmentandPostByUserId(userId);
        return new Result(sysDepartmentPostVOList);
    }

    @RequiresPermissions("/system/sysUser/saveDepartmentandPostOfUser")
    @ApiOperation(value = "为用户添加部门岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveDepartmentandPostOfUser")
    public Result saveDepartmentandPostOfUser(@Validated @RequestBody SysUserDepartmentPostAdd sysUserDepartmentPostAdd) {
        Assert.notNull(sysUserDepartmentPostAdd.getUserId(), "用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveDepartmentandPostOfUser(sysUserDepartmentPostAdd,user);
        return new Result();
    }

    @RequiresPermissions("/system/sysUser/checkUserName")
    @ApiOperation(value = "校验用户账号是否存在,success表示用户名可用,false不可用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkUserName")
    public Result checkAccount(String account){
        String result = sysUserService.checkUserName(account);
        return new Result(result);
    }

}
