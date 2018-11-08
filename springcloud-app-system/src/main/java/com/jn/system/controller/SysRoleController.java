package com.jn.system.controller;


import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.*;
import com.jn.system.service.SysRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @ApiOperation(value = "查询角色列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    public Result list(@RequestBody SysRolePage role) {
        PaginationData data = tbRoleService.selectRoleListBySearchKey(role);
        return new Result(data);
    }


    @ApiOperation(value = "新增角色", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    public Result add(@Validated @RequestBody SysRole role) {
        tbRoleService.insertTbRole(role);
        return new Result();

    }

    @ApiOperation(value = "删除角色", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "角色ID不能为空");
        tbRoleService.deleteTbRoleById(ids);
        return new Result();
    }

    @ApiOperation(value = "修改角色", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    public Result update(@Validated @RequestBody SysRole role) {
        Assert.notNull(role.getId(), "角色ID不能为空");
        tbRoleService.updateTbRole(role);
        return new Result();
    }

    @ApiOperation(value = "角色授权权限", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/rolePermissionAuthorization")
    public Result rolePermissionAuthorization(@Validated @RequestBody SysRolePermissionAdd sysRolePermissionAdd) {
        Assert.notNull(sysRolePermissionAdd.getRoleId(), "角色ID不能为空");
        tbRoleService.rolePermissionAuthorization(sysRolePermissionAdd);
        return new Result();
    }

    @ApiOperation(value = "角色授权用户组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/userGroupRoleAuthorization")
    public Result userGroupRoleAuthorization(@Validated @RequestBody SysUserGroupRoleAdd sysUserGroupRoleAdd) {
        Assert.notNull(sysUserGroupRoleAdd.getRoleId(), "角色ID不能为空");
        tbRoleService.UserGroupRoleAuthorization(sysUserGroupRoleAdd);
        return new Result();
    }

    @ApiOperation(value = "角色授权用户", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/userRoleAuthorization")
    public Result userRoleAuthorization(@Validated @RequestBody SysUserRoleAdd sysUserRoleAdd) {
        Assert.notNull(sysUserRoleAdd.getRoleId(), "角色ID不能为空");
        tbRoleService.userRoleAuthorization(sysUserRoleAdd);
        return new Result();
    }

    @ApiOperation(value = "用户查询所有角色", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/findSysRoleAll")
    public Result findSysRoleAll() {
        return tbRoleService.findSysRoleAll();
    }

}
