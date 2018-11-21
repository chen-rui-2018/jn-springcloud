package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.*;
import com.jn.system.service.SysPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
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


    @RequiresPermissions("/system/sysPermission/add")
    @ApiOperation(value = "添加权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result add(@Validated @RequestBody SysPermissionAdd sysPermissionAdd) {
        sysPermissionService.addPermission(sysPermissionAdd);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/update")
    @ApiOperation(value = "修改权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    public Result update(@Validated @RequestBody SysPermission sysPermission) {
        Assert.notNull(sysPermission.getId(), "权限id不能为空");
        sysPermissionService.updatePermission(sysPermission);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/selectByPrimaryKey")
    @ApiOperation(value = "根据主键获取权限信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectByPrimaryKey")
    private Result selectByPrimaryKey(String id) {
        return sysPermissionService.selectByPrimaryKey(id);
    }


    @RequiresPermissions("/system/sysPermission/list")
    @ApiOperation(value = "条件分页查询", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    public Result list(@Validated @RequestBody SysPermissionPage sysPermissionPage) {
        return sysPermissionService.findByPage(sysPermissionPage);
    }


    @RequiresPermissions("/system/sysPermission/delete")
    @ApiOperation(value = "批量删除权限", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    public Result delete(String[] ids) {
        Assert.noNullElements(ids, "权限id不能为空");
        sysPermissionService.deletePermissionBranch(ids);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/addRoleToPermission")
    @ApiOperation(value = "为权限添加角色", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addRoleToPermission")
    public Result addRoleToPermission(@Validated @RequestBody SysPermissionRolesAdd sysPermissionRolesAdd) {
        Assert.notNull(sysPermissionRolesAdd.getPermissionId(), "权限id不能为空");
        sysPermissionService.addRoleToPermission(sysPermissionRolesAdd);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/findRoleOfPermission")
    @ApiOperation(value = "获取权限已经具有的角色信息及条件分页获取未拥有的角色信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findRoleOfPermission")
    public Result findRoleOfPermission(@Validated @RequestBody SysPermissionRolePage sysPermissionRolePage) {
        return sysPermissionService.findRoleOfPermission(sysPermissionRolePage);
    }


    @RequiresPermissions("/system/sysPermission/findFileGroupOfPermission")
    @ApiOperation(value = "获取除权限已经具有的文件组信息及条件分页获取未拥有的文件组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findFileGroupOfPermission")
    public Result findFileGroupOfPermission(@Validated @RequestBody SysPermissionFileGroupPage sysPermissionFileGroupPage) {
        return sysPermissionService.findFileGroupOfPermission(sysPermissionFileGroupPage);
    }


    @RequiresPermissions("/system/sysPermission/addFileGroupToPermission")
    @ApiOperation(value = "为权限添加文件组", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addFileGroupToPermission")
    public Result addFileGroupToPermission(@Validated @RequestBody SysPermissionFileGroupAdd sysPermissionFileGroupAdd) {
        Assert.notNull(sysPermissionFileGroupAdd.getPermissionId(), "权限id不能为空");
        sysPermissionService.addFileGroupToPermission(sysPermissionFileGroupAdd);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/findMenuOfPermission")
    @ApiOperation(value = "获取权限已经具有的菜单信息及条件分页查询未拥有的菜单信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findMenuOfPermission")
    public Result findMenuOfPermission(@Validated @RequestBody SysPermissionMenuPage sysPermissionMenuPage) {
        return sysPermissionService.findMenuOfPermission(sysPermissionMenuPage);
    }


    @RequiresPermissions("/system/sysPermission/findResourcesOfPermission")
    @ApiOperation(value = "获取权限已经具有的功能信息及条件分页获取未拥有的功能信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findResourcesOfPermission")
    public Result findResourcesOfPermission(@Validated @RequestBody SysPermissionResourcePage sysPermissionResourcePage) {
        return sysPermissionService.findResourcesOfPermission(sysPermissionResourcePage);
    }


    @RequiresPermissions("/system/sysPermission/addMenuToPermission")
    @ApiOperation(value = "为权限添加菜单", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addMenuToPermission")
    public Result addMenuToPermission(@Validated @RequestBody SysPermissionMenuAdd sysPermissionMenuAdd) {
        sysPermissionService.addMenuToPermission(sysPermissionMenuAdd);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/addResounceToPermission")
    @ApiOperation(value = "为权限添加页面功能", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/addResounceToPermission")
    public Result addResounceToPermission(@Validated @RequestBody SysPermissionResourceAdd sysPermissionMenuAdd) {
        sysPermissionService.addResounceToPermission(sysPermissionMenuAdd);
        return new Result();
    }


    @RequiresPermissions("/system/sysPermission/checkPermissionName")
    @ApiOperation(value = "校验权限名称是否已经存在,false权限名称已经存在,success权限名称可以使用",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkPerssionName")
    public Result checkPermissionName(String permissionName) {
        return sysPermissionService.checkPermissionName(permissionName);
    }

}
