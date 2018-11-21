package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.entity.TbSysGroup;
import com.jn.system.model.*;
import com.jn.system.service.SysGroupService;
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
 * 用户组管理
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "用户组管理")
@RestController
@RequestMapping("/system/sysGroup")
public class SysGroupController extends BaseController {

    @Autowired
    private SysGroupService sysGroupService;


    @ApiOperation(value = "分页查询用户组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    @RequiresPermissions("/system/sysGroup/list")
    public Result list(@Validated @RequestBody SysGroupPage groupPage) {
        return sysGroupService.findSysGroupAll(groupPage);
    }

    @ApiOperation(value = "用户组添加", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    @RequiresPermissions("/system/sysGroup/add")
    public Result add(@Validated @RequestBody TbSysGroup sysGroup) {
        sysGroupService.addSysGroup(sysGroup);
        return new Result();
    }

    @ApiOperation(value = "逻辑删除用户组", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    @RequiresPermissions("/system/sysGroup/delete")
    public Result delete(String[] groupIds) {
        Assert.noNullElements(groupIds, "用户组id数组不能为空");
        sysGroupService.deleSysGroup(groupIds);
        return new Result();
    }

    @ApiOperation(value = "修改用户组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    @RequiresPermissions("/system/sysGroup/update")
    public Result update(@Validated @RequestBody SysGroupUpdate sysGroup) {
        Assert.notNull(sysGroup.getId(), "用户组id不能为空");
        sysGroupService.updateSysGroup(sysGroup);
        return new Result();
    }

    @ApiOperation(value = "根据用户组id获取用户组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectByPrimaryKey")
    @RequiresPermissions("/system/sysGroup/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        return sysGroupService.findSysGroupById(id);
    }


    @ApiOperation(value = "根据用户组id获取用户组具有的角色信息及条件分页查询用户组未拥有的角色信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectGroupRoleAndOtherRole")
    @RequiresPermissions("/system/sysGroup/selectGroupRoleAndOtherRole")
    public Result selectGroupRoleAndOtherRole(@Validated @RequestBody SysGroupRolePage sysGroupRolePage) {
        return sysGroupService.selectGroupRoleAndOtherRole(sysGroupRolePage);
    }


    @ApiOperation(value = "用户组授权角色",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/roleGroupAuthorization")
    @RequiresPermissions("/system/sysGroup/roleGroupAuthorization")
    public Result roleGroupAuthorization(@Validated @RequestBody SysRoleGroupAdd sysRoleGroupAdd) {
        Assert.notNull(sysRoleGroupAdd.getGroupId(), "用户组id不能为空");
        sysGroupService.roleGroupAuthorization(sysRoleGroupAdd);
        return new Result();
    }

    @ApiOperation(value = "获取用户组下面所有用户",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findUserOfGroup")
    @RequiresPermissions("/system/sysGroup/findUserOfGroup")
    public Result findUserOfGroup(String groupId) {
        return sysGroupService.findUserOfGroup(groupId);
    }

    @ApiOperation(value = "分页获取除用户组拥有的用户及用户组未拥有用户",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findOtherUserByPage")
    @RequiresPermissions("/system/sysGroup/findOtherUserByPage")
    public Result findOtherUserByPage(@Validated @RequestBody SysGroupUserPage sysGroupUserPage) {
        Assert.notNull(sysGroupUserPage.getGroupId(), "用户组id不能为空");
        return sysGroupService.findOtherUserByPage(sysGroupUserPage);
    }

    @ApiOperation(value = "用户组授权用户",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/userGroupAuthorization")
    @RequiresPermissions("/system/sysGroup/userGroupAuthorization")
    public Result userGroupAuthorization(@Validated @RequestBody SysGroupUserAdd sysGroupUserAdd) {
        Assert.notNull(sysGroupUserAdd.getGroupId(), "用户组id不能为空");
        sysGroupService.userGroupAuthorization(sysGroupUserAdd);
        return new Result();
    }

    @ApiOperation(value = "校验用户组名是否存在,success表示用户组名可以用,false表示用户组名已存在",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkGroupName")
    @RequiresPermissions("/system/sysGroup/checkGroupName")
    public Result checkGroupName(String groupName) {
        return sysGroupService.checkGroupName(groupName);
    }

}
