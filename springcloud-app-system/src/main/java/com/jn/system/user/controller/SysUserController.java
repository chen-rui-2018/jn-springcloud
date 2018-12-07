package com.jn.system.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.*;
import com.jn.system.permission.model.SysRoleUserAdd;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysUserService;
import com.jn.system.dept.vo.SysDepartmentPostVO;
import com.jn.system.user.vo.SysUserRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import com.jn.common.util.Assert;
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
@Api(tags = "用户管理")
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController extends BaseController {
    @Autowired
    private SysUserService sysUserService;

    @ControllerLog(doAction = "添加用户")
    @RequiresPermissions("/system/sysUser/addSysUser")
    @ApiOperation(value = "添加用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addSysUser")
    public Result addSysUser(@Validated @RequestBody SysUserAdd sysUser) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.addSysUser(sysUser,user);
        return new Result();
    }

    @ControllerLog(doAction = "条件分页查询用户")
    @RequiresPermissions("/system/sysUser/findSysUserByPage")
    @ApiOperation(value = "条件分页查询用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysUserByPage")
    public Result findSysUserByPage(@Validated @RequestBody SysUserPage userPage) {
        PaginationData data = sysUserService.findSysUserByPage(userPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "根据用户id返回用户信息")
    @RequiresPermissions("/system/sysUser/findSysUserById")
    @ApiOperation(value = "根据用户id返回用户信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysUserById")
    public Result findSysUserById(String id) {
        SysUser sysUser = sysUserService.findSysUserById(id);
        return new Result(sysUser);
    }

    @ControllerLog(doAction = "逻辑删除用户")
    @RequiresPermissions("/system/sysUser/deleteSysUser")
    @ApiOperation(value = "逻辑删除用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/deleteSysUser")
    public Result deleteSysUser(@Validated @RequestBody SysUserDelete sysUserDelete) {
        sysUserService.deleteSysUser(sysUserDelete.getUserIds());
        return new Result();
    }

    @ControllerLog(doAction = "更新用户")
    @RequiresPermissions("/system/sysUser/updateSysUser")
    @ApiOperation(value = "更新用户", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateSysUser")
    public Result updateSysUser(@Validated @RequestBody SysUser sysUser) {
        Assert.notNull(sysUser.getId(),"用户id不能为空");
        sysUserService.updateSysUser(sysUser);
        return new Result();
    }

    @ControllerLog(doAction = "查询用户已经具有的用户组信息,且条件分页获取用户未拥有的用户组信息")
    @RequiresPermissions("/system/sysUser/findSysGroupByUserId")
    @ApiOperation(value = "查询用户已经具有的用户组信息,且条件分页获取用户未拥有的用户组信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysGroupByUserId")
    public Result findSysGroupByUserId(@Validated @RequestBody SysUserGroupPage sysUserGroupPage) {
        PaginationData data = sysUserService.findSysGroupByUserId(sysUserGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "添加用户组到用户")
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

    @ControllerLog(doAction = "查询用户已经具有的角色信息,且条件分页获取用户未拥有的角色信息")
    @RequiresPermissions("/system/sysUser/findSysRoleByUserId")
    @ApiOperation(value = "查询用户已经具有的角色信息,且条件分页获取用户未拥有的角色信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findSysRoleByUserId")
    public Result findSysRoleByUserId(@Validated @RequestBody SysUserRolePage sysUserRolePage) {
        PaginationData data = sysUserService.findSysRoleByUserId(sysUserRolePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "为用户添加角色权限")
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

    @ControllerLog(doAction = "根据用户id查询用户已经具有的岗位部门信息")
    @RequiresPermissions("/system/sysUser/findDepartmentandPostByUserId")
    @ApiOperation(value = "根据用户id查询用户已经具有的岗位部门信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findDepartmentandPostByUserId")
    public Result findDepartmentandPostByUserId(String userId) {
        List<SysDepartmentPostVO> sysDepartmentPostVOList = sysUserService.findDepartmentandPostByUserId(userId);
        return new Result(sysDepartmentPostVOList);
    }

    @ControllerLog(doAction = "为用户添加部门岗位")
    @RequiresPermissions("/system/sysUser/saveDepartmentandPostOfUser")
    @ApiOperation(value = "为用户添加部门岗位", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveDepartmentandPostOfUser")
    public Result saveDepartmentAndPostOfUser(@Validated @RequestBody SysUserDepartmentPostAdd sysUserDepartmentPostAdd) {
        Assert.notNull(sysUserDepartmentPostAdd.getUserId(), "用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveDepartmentAndPostOfUser(sysUserDepartmentPostAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "校验用户账号是否存在,fail表示账号已存在,success表示可以使用")
    @RequiresPermissions("/system/sysUser/checkUserName")
    @ApiOperation(value = "校验用户账号是否存在,fail表示账号已存在,success表示可以使用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkUserName")
    public Result checkAccount(String account){
        String result = sysUserService.checkUserName(account);
        return new Result(result);
    }

}
