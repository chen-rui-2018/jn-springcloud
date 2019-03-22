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
import com.jn.system.permission.vo.SysRolePermissionVO;
import com.jn.system.permission.vo.SysRoleUserGroupVO;
import com.jn.system.permission.vo.SysRoleUserVO;
import com.jn.system.permission.vo.SysRoleVO;
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
import java.util.List;
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
    @ApiOperation(value = "查询角色列表", notes = "查询角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/list")
    public Result<PaginationData<List<SysRoleVO>>> list(@RequestBody SysRolePage role) {
        PaginationData<List<SysRoleVO>> data = tbRoleService.selectRoleListBySearchKey(role);
        return new Result(data);
    }

    @ControllerLog(doAction = "新增角色")
    @ApiOperation(value = "新增角色", notes = "新增角色")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/add")
    public Result add(@Validated @RequestBody SysRoleAdd role) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //封装角色对象
        TbSysRole tbSysRole = new TbSysRole();
        BeanUtils.copyProperties(role, tbSysRole);
        tbSysRole.setId(UUID.randomUUID().toString());
        tbSysRole.setCreatorAccount(user.getAccount());
        tbSysRole.setCreatedTime(new Date());
        tbRoleService.insertTbRole(tbSysRole);
        return new Result();

    }

    @ControllerLog(doAction = "删除角色")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.deleteTbRoleById(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "修改角色")
    @ApiOperation(value = "修改角色", notes = "修改角色")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/update")
    public Result update(@Validated @RequestBody SysRoleUpdate role) {
        Assert.notNull(role.getId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.updateTbRole(role, user);
        return new Result();
    }

    @ControllerLog(doAction = "角色授权权限")
    @ApiOperation(value = "角色授权权限", notes = "角色授权权限")
    @RequestMapping(value = "/rolePermissionAuthorization", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/rolePermissionAuthorization")
    public Result rolePermissionAuthorization(@Validated @RequestBody SysRolePermissionAdd sysRolePermissionAdd) {
        Assert.notNull(sysRolePermissionAdd.getRoleId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.rolePermissionAuthorization(sysRolePermissionAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "角色授权用户组")
    @ApiOperation(value = "角色授权用户组", notes = "角色授权用户组")
    @RequestMapping(value = "/userGroupRoleAuthorization", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/userGroupRoleAuthorization")
    public Result userGroupRoleAuthorization(@Validated @RequestBody SysUserGroupRoleAdd sysUserGroupRoleAdd) {
        Assert.notNull(sysUserGroupRoleAdd.getRoleId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.userGroupRoleAuthorization(sysUserGroupRoleAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "角色授权用户")
    @ApiOperation(value = "角色授权用户", notes = "角色授权用户")
    @RequestMapping(value = "/userRoleAuthorization", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/userRoleAuthorization")
    public Result userRoleAuthorization(@Validated @RequestBody SysUserRoleAdd sysUserRoleAdd) {
        Assert.notNull(sysUserRoleAdd.getRoleId(), "角色ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        tbRoleService.userRoleAuthorization(sysUserRoleAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "校验角色名称是否已经存在")
    @ApiOperation(value = "校验角色名称是否已经存在",
            notes = "fail表示名称已存在,success表示可以使用")
    @RequiresPermissions("/system/sysRole/checkRoleName")
    @RequestMapping(value = "/checkRoleName", method = RequestMethod.POST)
    public Result<String> checkRoleName(String roleName) {
        String result = tbRoleService.checkRoleName(roleName);
        return new Result(result);
    }

    @ControllerLog(doAction = "查询角色已经具有的用户信息")
    @ApiOperation(value = "查询角色已经具有的用户信息",
            notes = "查询角色已经具有的用户信息,且条件分页获取为角色未拥有的用户信息")
    @RequestMapping(value = "/findUserOfRoleAndOtherUser", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/findUserOfRoleAndOtherUser")
    public Result<PaginationData<SysRoleUserVO>> findUserOfRoleAndOtherUser(@Validated @RequestBody SysRoleUserPage sysRoleUserPage) {
        PaginationData<SysRoleUserVO> data = tbRoleService.findUserOfRoleAndOtherUser(sysRoleUserPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询角色已经具有的用户组信息")
    @ApiOperation(value = "查询角色已经具有的用户组信息",
            notes = "查询角色已经具有的用户组信息,且条件分页获取角色未拥有的用户组信息")
    @RequestMapping(value = "/findUserGroupOfRoleAndOtherGroup", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/findUserGroupOfRoleAndOtherGroup")
    public Result<PaginationData<SysRoleUserGroupVO>> findUserGroupOfRoleAndOtherGroup(@Validated @RequestBody SysRoleUserGroupPage sysRoleUserGroupPage) {
        PaginationData<SysRoleUserGroupVO> data = tbRoleService.findUserGroupOfRoleAndOtherGroup(sysRoleUserGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "查询角色已经具有的权限信息")
    @ApiOperation(value = "查询角色已经具有的权限信息",
            notes = "查询角色已经具有的权限信息,且条件分页获取角色未拥有的权限信息")
    @RequestMapping(value = "/findPermissionOrRoleAndOtherPermission", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysRole/findPermissionTORole")
    public Result<PaginationData<SysRolePermissionVO>> findPermissionOrRoleAndOtherPermission(@Validated @RequestBody SysRolePermissionPage sysRolePermissionPage) {
        PaginationData<SysRolePermissionVO> data = tbRoleService.findPermissionOrRoleAndOtherPermission(sysRolePermissionPage);
        return new Result(data);
    }

}
