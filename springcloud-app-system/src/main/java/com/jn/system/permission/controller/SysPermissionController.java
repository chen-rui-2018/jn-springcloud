package com.jn.system.permission.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.permission.entity.TbSysPermission;
import com.jn.system.permission.model.*;
import com.jn.system.permission.service.SysPermissionService;
import com.jn.system.permission.vo.SysMenuResourcesVO;
import com.jn.system.permission.vo.SysPermissionFileGroupVO;
import com.jn.system.permission.vo.SysPermissionRoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @ApiOperation(value = "添加权限", notes = "添加权限")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Result add(@Validated @RequestBody SysPermissionAdd sysPermissionAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //封装权限对象
        TbSysPermission tbSysPermission = new TbSysPermission();
        BeanUtils.copyProperties(sysPermissionAdd, tbSysPermission);
        tbSysPermission.setId(UUID.randomUUID().toString());
        tbSysPermission.setCreatedTime(new Date());
        tbSysPermission.setCreatorAccount(user.getAccount());
        sysPermissionService.addPermission(tbSysPermission);
        return new Result();
    }

    @ControllerLog(doAction = "修改权限")
    @RequiresPermissions("/system/sysPermission/update")
    @ApiOperation(value = "修改权限", notes = "修改权限")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result update(@Validated @RequestBody SysPermission sysPermission) {
        Assert.notNull(sysPermission.getId(), "权限id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.updatePermission(sysPermission, user);
        return new Result();
    }

    @ControllerLog(doAction = "获取权限信息")
    @RequiresPermissions("/system/sysPermission/selectByPrimaryKey")
    @ApiOperation(value = "获取权限信息", notes = "根据主键获取权限信息")
    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.POST)
    public Result<SysPermission> selectByPrimaryKey(String id) {
        SysPermission sysPermission = sysPermissionService.selectByPrimaryKey(id);
        return new Result(sysPermission);
    }

    @ControllerLog(doAction = "条件分页查询")
    @RequiresPermissions("/system/sysPermission/list")
    @ApiOperation(value = "条件分页查询", notes = "条件分页查询")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public Result<PaginationData<List<SysPermission>>> list(@Validated @RequestBody SysPermissionPage sysPermissionPage) {
        PaginationData<List<SysPermission>> data = sysPermissionService.findByPage(sysPermissionPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "批量删除权限")
    @RequiresPermissions("/system/sysPermission/delete")
    @ApiOperation(value = "批量删除权限", notes = "批量删除权限")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(String[] ids) {
        Assert.noNullElements(ids, "权限id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.deletePermissionBranch(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "为权限添加角色")
    @RequiresPermissions("/system/sysPermission/addRoleToPermission")
    @ApiOperation(value = "为权限添加角色", notes = "为权限添加角色")
    @RequestMapping(value = "/addRoleToPermission", method = RequestMethod.POST)
    public Result addRoleToPermission(@Validated @RequestBody SysPermissionRolesAdd sysPermissionRolesAdd) {
        Assert.notNull(sysPermissionRolesAdd.getPermissionId(), "权限id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addRoleToPermission(sysPermissionRolesAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "获取权限的角色信息")
    @RequiresPermissions("/system/sysPermission/findRoleOfPermission")
    @ApiOperation(value = "获取权限的角色信息",
            notes = "获取权限已经具有的角色信息,且条件分页获取权限未拥有的角色信息")
    @RequestMapping(value = "/findRoleOfPermission", method = RequestMethod.POST)
    public Result<PaginationData<SysPermissionRoleVO>> findRoleOfPermission(@Validated @RequestBody SysPermissionRolePage sysPermissionRolePage) {
        PaginationData<SysPermissionRoleVO> data = sysPermissionService.findRoleOfPermission(sysPermissionRolePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "获取除权限的文件组信息")
    @RequiresPermissions("/system/sysPermission/findFileGroupOfPermission")
    @ApiOperation(value = "获取除权限的文件组信息",
            notes = "获取除权限已经具有的文件组信息,且条件分页获取权限未拥有的文件组信息")
    @RequestMapping(value = "/findFileGroupOfPermission", method = RequestMethod.POST)
    public Result<PaginationData<SysPermissionFileGroupVO>> findFileGroupOfPermission(@Validated @RequestBody SysPermissionFileGroupPage sysPermissionFileGroupPage) {
        PaginationData<SysPermissionFileGroupVO> data = sysPermissionService.findFileGroupOfPermission(sysPermissionFileGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "为权限添加文件组")
    @RequiresPermissions("/system/sysPermission/addFileGroupToPermission")
    @ApiOperation(value = "为权限添加文件组", notes = "为权限添加文件组")
    @RequestMapping(value = "/addFileGroupToPermission", method = RequestMethod.POST)
    public Result addFileGroupToPermission(@Validated @RequestBody SysPermissionFileGroupAdd sysPermissionFileGroupAdd) {
        Assert.notNull(sysPermissionFileGroupAdd.getPermissionId(), "权限id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addFileGroupToPermission(sysPermissionFileGroupAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "校验权限名称是否已经存在")
    @ApiOperation(value = "校验权限名称是否已经存在", notes = "fail表示名称已存在,success表示可以使用")
    @RequiresPermissions("/system/sysPermission/checkPermissionName")
    @RequestMapping(value = "/checkPerssionName", method = RequestMethod.POST)
    public Result<String> checkPermissionName(String permissionName) {
        String result = sysPermissionService.checkPermissionName(permissionName);
        return new Result(result);
    }

    @ControllerLog(doAction = "获取菜单及功能信息")
    @RequiresPermissions("/system/sysPermission/getMenuAndResources")
    @ApiOperation(value = "获取菜单及功能信息", notes = "权限授权功能,获取菜单及功能信息")
    @RequestMapping(value = "/getMenuAndResources", method = RequestMethod.POST)
    public Result<SysMenuResourcesVO> getMenuAndResources(String permissionId) {
        SysMenuResourcesVO sysMenuResourcesVO = sysPermissionService.getMenuAndResources(permissionId);
        return new Result(sysMenuResourcesVO);
    }

    @ControllerLog(doAction = "权限授权菜单及功能信息")
    @RequiresPermissions("/system/sysPermission/addMenuAndResources")
    @ApiOperation(value = "权限授权菜单及功能信息", notes = "权限授权菜单及功能信息")
    @RequestMapping(value = "/addMenuAndResourcesToPermission", method = RequestMethod.POST)
    public Result addMenuAndResourcesToPermission(
            @Validated @RequestBody SysPermissionMenuResourcesAdd sysPermissionMenuResourcesAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPermissionService.addMenuAndResourcesToPermission(sysPermissionMenuResourcesAdd, user);
        return new Result();
    }

}
