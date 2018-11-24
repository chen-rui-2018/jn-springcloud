package com.jn.system.permission.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.*;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import com.jn.common.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 权限管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/9 9:16
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "权限管理")
@RestController
@RequestMapping("/system/sysPermission")
public class SysPermissionController extends BaseController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @ControllerLog(doAction = "添加权限")
    @RequiresPermissions("/system/sysPermission/add")
    @ApiOperation(value = "添加权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result add(@Validated @RequestBody SysPermissionAdd sysPermissionAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addPermission(sysPermissionAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "修改权限")
    @RequiresPermissions("/system/sysPermission/update")
    @ApiOperation(value = "修改权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    public Result update(@Validated @RequestBody SysPermission sysPermission) {
        Assert.notNull(sysPermission.getId(), "权限id不能为空");
        sysPermissionService.updatePermission(sysPermission);
        return new Result();
    }

    @ControllerLog(doAction = "根据主键获取权限信息")
    @RequiresPermissions("/system/sysPermission/selectByPrimaryKey")
    @ApiOperation(value = "根据主键获取权限信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        SysPermission sysPermission = sysPermissionService.selectByPrimaryKey(id);
        return new Result(sysPermission);
    }

    @ControllerLog(doAction = "条件分页查询")
    @RequiresPermissions("/system/sysPermission/list")
    @ApiOperation(value = "条件分页查询", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    public Result list(@Validated @RequestBody SysPermissionPage sysPermissionPage) {
        PaginationData data = sysPermissionService.findByPage(sysPermissionPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "批量删除权限")
    @RequiresPermissions("/system/sysPermission/delete")
    @ApiOperation(value = "批量删除权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    public Result delete(String[] ids) {
        Assert.noNullElements(ids, "权限id不能为空");
        sysPermissionService.deletePermissionBranch(ids);
        return new Result();
    }

    @ControllerLog(doAction = "为权限添加角色")
    @RequiresPermissions("/system/sysPermission/addRoleToPermission")
    @ApiOperation(value = "为权限添加角色", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addRoleToPermission")
    public Result addRoleToPermission(@Validated @RequestBody SysPermissionRolesAdd sysPermissionRolesAdd) {
        Assert.notNull(sysPermissionRolesAdd.getPermissionId(), "权限id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addRoleToPermission(sysPermissionRolesAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "获取权限已经具有的角色信息,且条件分页获取权限未拥有的角色信息")
    @RequiresPermissions("/system/sysPermission/findRoleOfPermission")
    @ApiOperation(value = "获取权限已经具有的角色信息,且条件分页获取权限未拥有的角色信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findRoleOfPermission")
    public Result findRoleOfPermission(@Validated @RequestBody SysPermissionRolePage sysPermissionRolePage) {
        PaginationData data = sysPermissionService.findRoleOfPermission(sysPermissionRolePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "获取除权限已经具有的文件组信息,且条件分页获取权限未拥有的文件组信息")
    @RequiresPermissions("/system/sysPermission/findFileGroupOfPermission")
    @ApiOperation(value = "获取除权限已经具有的文件组信息,且条件分页获取权限未拥有的文件组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findFileGroupOfPermission")
    public Result findFileGroupOfPermission(@Validated @RequestBody SysPermissionFileGroupPage sysPermissionFileGroupPage) {
        PaginationData data = sysPermissionService.findFileGroupOfPermission(sysPermissionFileGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "为权限添加文件组")
    @RequiresPermissions("/system/sysPermission/addFileGroupToPermission")
    @ApiOperation(value = "为权限添加文件组", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addFileGroupToPermission")
    public Result addFileGroupToPermission(@Validated @RequestBody SysPermissionFileGroupAdd sysPermissionFileGroupAdd) {
        Assert.notNull(sysPermissionFileGroupAdd.getPermissionId(), "权限id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addFileGroupToPermission(sysPermissionFileGroupAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "获取权限已经具有的菜单信息,且条件分页查询获取权限未拥有的菜单信息")
    @RequiresPermissions("/system/sysPermission/findMenuOfPermission")
    @ApiOperation(value = "获取权限已经具有的菜单信息,且条件分页查询获取权限未拥有的菜单信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findMenuOfPermission")
    public Result findMenuOfPermission(@Validated @RequestBody SysPermissionMenuPage sysPermissionMenuPage) {
        PaginationData data = sysPermissionService.findMenuOfPermission(sysPermissionMenuPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "获取权限已经具有的功能信息,且条件分页获取权限未拥有的功能信息")
    @RequiresPermissions("/system/sysPermission/findResourcesOfPermission")
    @ApiOperation(value = "获取权限已经具有的功能信息,且条件分页获取权限未拥有的功能信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findResourcesOfPermission")
    public Result findResourcesOfPermission(@Validated @RequestBody SysPermissionResourcePage sysPermissionResourcePage) {
        PaginationData data = sysPermissionService.findResourcesOfPermission(sysPermissionResourcePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "为权限添加菜单")
    @RequiresPermissions("/system/sysPermission/addMenuToPermission")
    @ApiOperation(value = "为权限添加菜单", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addMenuToPermission")
    public Result addMenuToPermission(@Validated @RequestBody SysPermissionMenuAdd sysPermissionMenuAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addMenuToPermission(sysPermissionMenuAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "为权限添加页面功能")
    @RequiresPermissions("/system/sysPermission/addResounceToPermission")
    @ApiOperation(value = "为权限添加页面功能", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addResounceToPermission")
    public Result addResounceToPermission(@Validated @RequestBody SysPermissionResourceAdd sysPermissionMenuAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addResourceToPermission(sysPermissionMenuAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "校验权限名称是否已经存在,fail表示名称已存在,success表示可以使用")
    @RequiresPermissions("/system/sysPermission/checkPermissionName")
    @ApiOperation(value = "校验权限名称是否已经存在,fail表示名称已存在,success表示可以使用",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkPerssionName")
    public Result checkPermissionName(String permissionName) {
        String result = sysPermissionService.checkPermissionName(permissionName);
        return new Result(result);
    }

}
