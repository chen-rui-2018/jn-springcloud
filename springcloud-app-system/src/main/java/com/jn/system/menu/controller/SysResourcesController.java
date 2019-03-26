package com.jn.system.menu.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.menu.entity.TbSysResources;
import com.jn.system.menu.model.SysResourceCheckName;
import com.jn.system.menu.model.SysResources;
import com.jn.system.menu.service.SysResourcesService;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
 * 功能controller
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 11:13
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "功能管理")
@RestController
@RequestMapping("/system/sysResources")
public class SysResourcesController extends BaseController {

    @Autowired
    private SysResourcesService sysResourcesService;

    @ControllerLog(doAction = "新增功能")
    @ApiOperation(value = "新增功能", notes = "新增功能")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysResources/add")
    public Result add(@Validated @RequestBody SysResources sysResources) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为功能其他属性赋值
        sysResources.setResourcesUrl(StringUtils.trim(sysResources.getResourcesUrl()));
        sysResources.setId(UUID.randomUUID().toString());
        sysResources.setCreatorAccount(user.getAccount());
        sysResources.setCreatedTime(new Date());
        TbSysResources tbSysResources = new TbSysResources();
        BeanUtils.copyProperties(sysResources, tbSysResources);
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysResources.setRecordStatus(recordStatus);
        //调用业务层
        sysResourcesService.insertResources(tbSysResources);
        return new Result();
    }

    @ControllerLog(doAction = "修改功能")
    @ApiOperation(value = "修改功能", notes = "修改功能")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysResources/update")
    public Result update(@Validated @RequestBody SysResources sysResources) {
        Assert.notNull(sysResources.getId(), "功能ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysResourcesService.updateResourcesById(sysResources, user);
        return new Result();
    }

    @ControllerLog(doAction = "批量删除功能")
    @ApiOperation(value = "批量删除功能", notes = "批量删除功能")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysResources/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "功能ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysResourcesService.deleteResourcesById(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询功能")
    @ApiOperation(value = "根据ID查询功能", notes = "根据ID查询功能")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysResources/selectById")
    public Result<SysResources> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "功能ID不能为空");
        SysResources sysResources = sysResourcesService.selectSysResourcesById(id);
        return new Result(sysResources);
    }

    @ControllerLog(doAction = "校验功能名称是否存在")
    @ApiOperation(value = "校验功能名称是否存在", notes = "fail表示名称已存在,success表示可以使用")
    @RequestMapping(value = "/checkResourceName", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysResources/checkResourceName")
    public Result<String> checkResourceName(@Validated @RequestBody SysResourceCheckName sysResourceCheckName) {
        String result = sysResourcesService.checkResourceName(sysResourceCheckName);
        return new Result(result);
    }

    @ControllerLog(doAction = "获取页面功能信息")
    @ApiOperation(value = "获取页面功能信息", notes = "根据菜单id获取菜单所有页面功能")
    @RequestMapping(value = "/findResourcesByMenuId", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysResources/findResourcesByMenuId")
    public Result<List<TbSysResources>> findResourcesByMenuId(String menuId) {
        List<TbSysResources> sysResourcesList = sysResourcesService.findResourcesByMenuId(menuId);
        return new Result(sysResourcesList);
    }
}
