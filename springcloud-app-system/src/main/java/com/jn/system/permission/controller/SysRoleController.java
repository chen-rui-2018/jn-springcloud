package com.jn.system.permission.controller;


import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.permission.entity.TbSysRole;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysRoleService;
import com.jn.system.user.model.SysUserGroupRoleAdd;
import com.jn.system.user.model.SysUserRoleAdd;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

/**
 * 角色
 *
 * @author： yuanyy
 * @date： Created on 2018/11/01 11:31
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "角色管理")
@RestController
@RequestMapping("/system/sysRole")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService tbRoleService;

    @ControllerLog(doAction = "查询角色列表")
    @ApiOperation(value = "查询角色列表", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysRole/list")
    public Result list(@RequestBody SysRolePage role) {
        PaginationData data = tbRoleService.selectRoleListBySearchKey(role);
        return new Result(data);
    }

    @ControllerLog(doAction = "新增角色")
    @ApiOperation(value = "新增角色", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    @RequiresPermissions("/system/sysRole/add")
    public Result add(@Validated @RequestBody SysRoleAdd role) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //封装角色对象
        TbSysRole tbSysRole = new TbSysRole();
        BeanUtils.copyProperties(role, tbSysRole);
        tbSysRole.setId(UUID.randomUUID().toString());
        tbSysRole.setCreator(user.getId());
        tbSysRole.setCreateTime(new Date());
        tbRoleService.insertTbRole(tbSysRole);
        return new Result();

    }

    @ControllerLog(doAction = "删除角色")
    @ApiOperation(value = "删除角色", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "角色ID不能为空");
        tbRoleService.deleteTbRoleById(ids);
        return new Result();
    }

    @ControllerLog(doAction = "修改角色")
    @ApiOperation(value = "修改角色", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysRole/update")
    public Result update(@Validated @RequestBody SysRoleUpdate role) {
        Assert.notNull(role.getId(), "角色ID不能为空");
        tbRoleService.updateTbRole(role);
        return new Result();
    }

    @ControllerLog(doAction = "角色授权权限")
    @ApiOperation(value = "角色授权权限", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/rolePermissionAuthorization")
    @RequiresPermissions("/system/sysRole/rolePermissionAuthorization")
    public Result rolePermissionAuthorization(@Validated @RequestBody SysRolePermissionAdd sysRolePermissionAdd) {
        Assert.notNull(sysRolePermissionAdd.getRoleId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.rolePermissionAuthorization(sysRolePermissionAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "角色授权用户组")
    @ApiOperation(value = "角色授权用户组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/userGroupRoleAuthorization")
    @RequiresPermissions("/system/sysRole/userGroupRoleAuthorization")
    public Result userGroupRoleAuthorization(@Validated @RequestBody SysUserGroupRoleAdd sysUserGroupRoleAdd) {
        Assert.notNull(sysUserGroupRoleAdd.getRoleId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.userGroupRoleAuthorization(sysUserGroupRoleAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "角色授权用户")
    @ApiOperation(value = "角色授权用户", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/userRoleAuthorization")
    @RequiresPermissions("/system/sysRole/userRoleAuthorization")
    public Result userRoleAuthorization(@Validated @RequestBody SysUserRoleAdd sysUserRoleAdd) {
        Assert.notNull(sysUserRoleAdd.getRoleId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.userRoleAuthorization(sysUserRoleAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "校验角色名称是否已经存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验角色名称是否已经存在,fail表示名称已存在,success表示可以使用",
            httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/system/sysRole/checkRoleName")
    @RequestMapping(value = "/checkRoleName")
    public Result checkRoleName(String roleName) {
        String result = tbRoleService.checkRoleName(roleName);
        return new Result(result);
    }

    @ControllerLog(doAction = "查询角色已经具有的用户信息,且条件分页获取为角色未拥有的用户信息")
    @ApiOperation(value = "查询角色已经具有的用户信息,且条件分页获取为角色未拥有的用户信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findUserOfRoleAndOtherUser")
    @RequiresPermissions("/system/sysRole/findUserOfRoleAndOtherUser")
    public Result findUserOfRoleAndOtherUser(@Validated @RequestBody SysRoleUserPage sysRoleUserPage) {
        PaginationData data = tbRoleService.findUserOfRoleAndOtherUser(sysRoleUserPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询角色已经具有的用户组信息,且条件分页获取角色未拥有的用户组信息")
    @ApiOperation(value = "查询角色已经具有的用户组信息,且条件分页获取角色未拥有的用户组信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findUserGroupOfRoleAndOtherGroup")
    @RequiresPermissions("/system/sysRole/findUserGroupOfRoleAndOtherGroup")
    public Result findUserGroupOfRoleAndOtherGroup(@Validated @RequestBody SysRoleUserGroupPage sysRoleUserGroupPage) {
        PaginationData data = tbRoleService.findUserGroupOfRoleAndOtherGroup(sysRoleUserGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询角色已经具有的权限信息,且条件分页获取角色未拥有的权限信息")
    @ApiOperation(value = "查询角色已经具有的权限信息,且条件分页获取角色未拥有的权限信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findPermissionOrRoleAndOtherPermission")
    @RequiresPermissions("/system/sysRole/findPermissionTORole")
    public Result findPermissionOrRoleAndOtherPermission(@Validated @RequestBody SysRolePermissionPage sysRolePermissionPage) {
        PaginationData data = tbRoleService.findPermissionOrRoleAndOtherPermission(sysRolePermissionPage);
        return new Result(data);
    }

}
