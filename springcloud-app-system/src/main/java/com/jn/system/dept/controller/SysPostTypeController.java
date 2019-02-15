package com.jn.system.dept.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.dept.entity.TbSysPostType;
import com.jn.system.dept.model.SysPostType;
import com.jn.system.dept.model.SysPostTypeAdd;
import com.jn.system.dept.model.SysPostTypePage;
import com.jn.system.dept.service.SysPostTypeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
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
import java.util.List;
import java.util.UUID;

/**
 * 岗位类型管理
 *
 * @author： shaobao
 * @date： Created on 2018/12/10 11:35
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "岗位类型管理")
@RestController
@RequestMapping("/system/sysPostType")
public class SysPostTypeController extends BaseController {

    @Autowired
    private SysPostTypeService sysPostTypeService;

    @ControllerLog(doAction = "校验岗位类型名称是否存在")
    @RequiresPermissions("/system/sysPostType/checkPostTypeName")
    @ApiOperation(value = "校验岗位类型名称是否存在", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkPostTypeName")
    public Result checkPostTypeName(String postTypeName) {
        Assert.notNull(postTypeName, "岗位类型名称不能为空");
        String result = sysPostTypeService.checkPostTypeName(postTypeName);
        return new Result(result);
    }

    @ControllerLog(doAction = "增加岗位类型")
    @RequiresPermissions("/system/sysPostType/add")
    @ApiOperation(value = "增加岗位类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add")
    public Result add(@Validated @RequestBody SysPostTypeAdd postTypeAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //封装岗位类型对象
        TbSysPostType tbSysPostType = new TbSysPostType();
        BeanUtils.copyProperties(postTypeAdd, tbSysPostType);
        tbSysPostType.setId(UUID.randomUUID().toString());
        tbSysPostType.setCreatedTime(new Date());
        tbSysPostType.setCreatorAccount(user.getAccount());
        sysPostTypeService.add(tbSysPostType);
        return new Result();
    }

    @ControllerLog(doAction = "列表查询岗位类型")
    @RequiresPermissions("/system/sysPostType/list")
    @ApiOperation(value = "列表查询岗位类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/list")
    public Result list(@Validated @RequestBody SysPostTypePage postTypePage) {
        PaginationData data = sysPostTypeService.getPostTypeByPage(postTypePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "修改岗位类型")
    @RequiresPermissions("/system/sysPostType/update")
    @ApiOperation(value = "修改岗位类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/update")
    public Result update(@Validated @RequestBody SysPostType postType) {
        Assert.notNull(postType.getId(), "岗位类型id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysPostTypeService.update(postType, user);
        return new Result();
    }

    @ControllerLog(doAction = "逻辑删除岗位类型")
    @RequiresPermissions("/system/sysPostType/delete")
    @ApiOperation(value = "逻辑删除岗位类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/delete")
    public Result delete(String postTypeId) {
        Assert.notNull(postTypeId, "岗位类型id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Result result = sysPostTypeService.delete(postTypeId, user);
        return result;
    }

    @ControllerLog(doAction = "获取所有岗位类型")
    @RequiresPermissions("/system/sysPostType/getPostTypeAll")
    @ApiOperation(value = "获取所有岗位类型", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getPostTypeAll")
    public Result getPostTypeAll() {
        List<TbSysPostType> tbSysPostTypes = sysPostTypeService.getPostTypeAll();
        return new Result(tbSysPostTypes);
    }
}
