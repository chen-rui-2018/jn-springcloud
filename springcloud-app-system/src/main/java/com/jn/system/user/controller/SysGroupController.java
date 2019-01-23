package com.jn.system.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.permission.model.SysRoleGroupAdd;
import com.jn.system.user.entity.TbSysGroup;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

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

    @ControllerLog(doAction = "分页查询用户组信息")
    @ApiOperation(value = "分页查询用户组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    @RequiresPermissions("/system/sysGroup/list")
    public Result list(@Validated @RequestBody SysGroupPage groupPage) {
        PaginationData data = sysGroupService.findSysGroupAll(groupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "用户组添加")
    @ApiOperation(value = "用户组添加", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    @RequiresPermissions("/system/sysGroup/add")
    public Result add(@Validated @RequestBody SysGroupAdd sysGroup) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为用户组其他属性进行复值
        TbSysGroup tbSysGroup = new TbSysGroup();
        BeanUtils.copyProperties(sysGroup, tbSysGroup);
        tbSysGroup.setId(UUID.randomUUID().toString());
        tbSysGroup.setCreatedTime(new Date());
        tbSysGroup.setCreatorAccount(user.getAccount());
        //传参到业务层
        sysGroupService.addSysGroup(tbSysGroup);
        return new Result();
    }

    @ControllerLog(doAction = "逻辑删除用户组")
    @ApiOperation(value = "逻辑删除用户组", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    @RequiresPermissions("/system/sysGroup/delete")
    public Result delete(String[] groupIds) {
        Assert.noNullElements(groupIds, "用户组id数组不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysGroupService.deleSysGroup(groupIds,user);
        return new Result();
    }

    @ControllerLog(doAction = "修改用户组信息")
    @ApiOperation(value = "修改用户组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    @RequiresPermissions("/system/sysGroup/update")
    public Result update(@Validated @RequestBody SysGroupUpdate sysGroup) {
        Assert.notNull(sysGroup.getId(), "用户组id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysGroupService.updateSysGroup(sysGroup,user);
        return new Result();
    }

    @ControllerLog(doAction = "根据用户组id获取用户组信息")
    @ApiOperation(value = "根据用户组id获取用户组信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectByPrimaryKey")
    @RequiresPermissions("/system/sysGroup/selectByPrimaryKey")
    public Result selectByPrimaryKey(String id) {
        TbSysGroup sysGroup = sysGroupService.findSysGroupById(id);
        return new Result(sysGroup);
    }

    @ControllerLog(doAction = "查询用户组已经具有的角色信息,且条件分页获取用户组未拥有的角色信息")
    @ApiOperation(value = "查询用户组已经具有的角色信息,且条件分页获取用户组未拥有的角色信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/selectGroupRoleAndOtherRole")
    @RequiresPermissions("/system/sysGroup/selectGroupRoleAndOtherRole")
    public Result selectGroupRoleAndOtherRole(@Validated @RequestBody SysGroupRolePage sysGroupRolePage) {
        PaginationData data = sysGroupService.selectGroupRoleAndOtherRole(sysGroupRolePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "用户组授权角色")
    @ApiOperation(value = "用户组授权角色", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/roleGroupAuthorization")
    @RequiresPermissions("/system/sysGroup/roleGroupAuthorization")
    public Result roleGroupAuthorization(@Validated @RequestBody SysRoleGroupAdd sysRoleGroupAdd) {
        Assert.notNull(sysRoleGroupAdd.getGroupId(), "用户组id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysGroupService.roleGroupAuthorization(sysRoleGroupAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息")
    @ApiOperation(value = "查询用户组已经具有的用户信息,且条件分页获取用户组未拥有的用户信息",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/findOtherUserByPage")
    @RequiresPermissions("/system/sysGroup/findOtherUserByPage")
    public Result findOtherUserByPage(@Validated @RequestBody SysGroupUserPage sysGroupUserPage) {
        Assert.notNull(sysGroupUserPage.getGroupId(), "用户组id不能为空");
        PaginationData data = sysGroupService.findOtherUserByPage(sysGroupUserPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "用户组授权用户")
    @ApiOperation(value = "用户组授权用户",
            httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/userGroupAuthorization")
    @RequiresPermissions("/system/sysGroup/userGroupAuthorization")
    public Result userGroupAuthorization(@Validated @RequestBody SysGroupUserAdd sysGroupUserAdd) {
        Assert.notNull(sysGroupUserAdd.getGroupId(), "用户组id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysGroupService.userGroupAuthorization(sysGroupUserAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "校验用户组名是否存在,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验用户组名是否存在,fail表示名称已存在,success表示可以使用",
            httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/system/sysGroup/checkGroupName")
    @RequestMapping(value = "/checkGroupName")
    public Result checkGroupName(String groupName) {
        String result = sysGroupService.checkGroupName(groupName);
        return new Result(result);
    }

}
