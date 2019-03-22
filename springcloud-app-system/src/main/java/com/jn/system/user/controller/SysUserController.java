package com.jn.system.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.model.UserPage;
import com.jn.system.permission.model.SysRoleUserAdd;
import com.jn.system.user.model.*;
import com.jn.system.user.service.SysUserService;
import com.jn.system.user.vo.SysUserGroupVO;
import com.jn.system.user.vo.SysUserRoleVO;
import com.jn.system.user.vo.SysUserVO;
import com.jn.system.vo.SysDepartmentPostVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

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
    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/addSysUser", method = RequestMethod.POST)
    public Result addSysUser(@Validated @RequestBody SysUserAdd sysUser) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUser.setId(UUID.randomUUID().toString());
        sysUserService.addSysUser(sysUser, user);
        return new Result();
    }

    @ControllerLog(doAction = "条件分页查询用户")
    @RequiresPermissions("/system/sysUser/findSysUserByPage")
    @ApiOperation(value = "条件分页查询用户", notes = "条件分页查询用户")
    @RequestMapping(value = "/findSysUserByPage", method = RequestMethod.POST)
    public Result<PaginationData<List<SysUserVO>>> findSysUserByPage(@Validated @RequestBody UserPage userPage) {
        PaginationData<List<SysUserVO>> data = sysUserService.findSysUserByPage(userPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "逻辑删除用户")
    @RequiresPermissions("/system/sysUser/deleteSysUser")
    @ApiOperation(value = "逻辑删除用户", notes = "逻辑删除用户")
    @RequestMapping(value = "/deleteSysUser", method = RequestMethod.POST)
    public Result deleteSysUser(@Validated @RequestBody SysUserDelete sysUserDelete) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.deleteSysUser(sysUserDelete.getUserIds(), user);
        return new Result();
    }

    @ControllerLog(doAction = "更新用户")
    @RequiresPermissions("/system/sysUser/updateSysUser")
    @ApiOperation(value = "更新用户", notes = "更新用户")
    @RequestMapping(value = "/updateSysUser", method = RequestMethod.POST)
    public Result updateSysUser(@Validated @RequestBody SysUser sysUser) {
        Assert.notNull(sysUser.getId(), "用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.updateSysUser(sysUser, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询用户已经具有的用户组信息")
    @RequiresPermissions("/system/sysUser/findSysGroupByUserId")
    @ApiOperation(value = "查询用户已经具有的用户组信息",
            notes = "查询用户已经具有的用户组信息,且条件分页获取用户未拥有的用户组信息")
    @RequestMapping(value = "/findSysGroupByUserId", method = RequestMethod.POST)
    public Result<PaginationData<SysUserGroupVO>> findSysGroupByUserId(@Validated @RequestBody SysUserGroupPage sysUserGroupPage) {
        PaginationData<SysUserGroupVO> data = sysUserService.findSysGroupByUserId(sysUserGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "添加用户组到用户")
    @RequiresPermissions("/system/sysUser/saveSysGroupToSysUser")
    @ApiOperation(value = "添加用户组到用户", notes = "添加用户组到用户")
    @RequestMapping(value = "/saveSysGroupToSysUser", method = RequestMethod.POST)
    public Result saveSysGroupToSysUser(@Validated @RequestBody SysUserGroupAdd sysUserGroupAdd) {
        Assert.notNull(sysUserGroupAdd.getUserId(), "用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveSysGroupToSysUser(sysUserGroupAdd.getGroupIds(), sysUserGroupAdd.getUserId(), user);
        return new Result();
    }

    @ControllerLog(doAction = "查询用户已经具有的角色信息")
    @RequiresPermissions("/system/sysUser/findSysRoleByUserId")
    @ApiOperation(value = "查询用户已经具有的角色信息",
            notes = "查询用户已经具有的角色信息,且条件分页获取用户未拥有的角色信息")
    @RequestMapping(value = "/findSysRoleByUserId", method = RequestMethod.POST)
    public Result<PaginationData<SysUserRoleVO>> findSysRoleByUserId(@Validated @RequestBody SysUserRolePage sysUserRolePage) {
        PaginationData<SysUserRoleVO> data = sysUserService.findSysRoleByUserId(sysUserRolePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "为用户添加角色权限")
    @RequiresPermissions("/system/sysUser/saveSysRoleToSysUser")
    @ApiOperation(value = "为用户添加角色权限", notes = "为用户添加角色权限")
    @RequestMapping(value = "/saveSysRoleToSysUser", method = RequestMethod.POST)
    public Result saveSysRoleToSysUser(@Validated @RequestBody SysRoleUserAdd sysRoleUserAdd) {
        Assert.notNull(sysRoleUserAdd.getUserId(), "用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveSysRoleToSysUser(sysRoleUserAdd.getRoleIds(), sysRoleUserAdd.getUserId(), user);
        return new Result();
    }

    @ControllerLog(doAction = "根据用户id查询用户已经具有的岗位部门信息")
    @RequiresPermissions("/system/sysUser/findDepartmentandPostByUserId")
    @ApiOperation(value = "根据用户id查询用户已经具有的岗位部门信息", notes = "根据用户id查询用户已经具有的岗位部门信息")
    @RequestMapping(value = "/findDepartmentandPostByUserId", method = RequestMethod.POST)
    public Result<List<SysDepartmentPostVO>> findDepartmentandPostByUserId(String userId) {
        List<SysDepartmentPostVO> sysDepartmentPostVOList = sysUserService.findDepartmentandPostByUserId(userId);
        return new Result(sysDepartmentPostVOList);
    }

    @ControllerLog(doAction = "为用户添加部门岗位")
    @RequiresPermissions("/system/sysUser/saveDepartmentandPostOfUser")
    @ApiOperation(value = "为用户添加部门岗位", notes = "为用户添加部门岗位")
    @RequestMapping(value = "/saveDepartmentandPostOfUser", method = RequestMethod.POST)
    public Result saveDepartmentAndPostOfUser(@Validated @RequestBody SysUserDepartmentPostAdd sysUserDepartmentPostAdd) {
        Assert.notNull(sysUserDepartmentPostAdd.getUserId(), "用户id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysUserService.saveDepartmentAndPostOfUser(sysUserDepartmentPostAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "校验用户账号是否存在")
    @RequiresPermissions("/system/sysUser/checkUserName")
    @ApiOperation(value = "校验用户账号是否存在", notes = "fail表示账号已存在,success表示可以使用")
    @RequestMapping(value = "/checkUserName", method = RequestMethod.POST)
    public Result<String> checkAccount(String account) {
        String result = sysUserService.checkUserName(account);
        return new Result(result);
    }

    @ControllerLog(doAction = "获取登录用户信息")
    @RequiresPermissions("/system/sysUser/getUserInfo")
    @ApiOperation(value = "获取登录用户信息", notes = "获取登录用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public Result<User> getUserInfo() {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        user.setPassword("");
        return new Result(user);
    }

    @ControllerLog(doAction = "导出用户信息")
    @RequiresPermissions("/system/sysUser/exportExcelUserInfo")
    @ApiOperation(value = "导出用户信息", notes = "导出用户信息")
    @RequestMapping(value = "/exportExcelUserInfo", method = RequestMethod.GET)
    public void exportExcelUserInfo(UserPage userPage, HttpServletResponse response) {
        String exportTitle = "帐号,姓名,部门,岗位,岗位类型,邮箱,手机,创建时间";
        String exportColName = "account,name,departmentName,postName,postTypeName,email,phone,createdTime";
        userPage.setPage(1);
        userPage.setRows(200000);
        PaginationData data = sysUserService.findSysUserByPage(userPage);
        List dataRows = (List) data.getRows();
        String fileName = "用户信息";
        String sheetName = "用户信息";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, dataRows);
    }

    @ControllerLog(doAction = "获取全部有效用户信息")
    @RequiresPermissions("/system/sysUser/getUserAll")
    @ApiOperation(value = "获取全部有效用户信息", notes = "获取全部有效用户信息")
    @RequestMapping(value = "/getUserAll", method = RequestMethod.POST)
    public Result<List<User>> getUserAll() {
        List<User> userAll = sysUserService.getUserAll();
        return new Result(userAll);
    }


}
