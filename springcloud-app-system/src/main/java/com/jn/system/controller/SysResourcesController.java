package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.SysResources;
import com.jn.system.model.SysResourcesPage;
import com.jn.system.service.SysResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "查询功能列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysResources/list")
    public Result list(@RequestBody SysResourcesPage sysMenuPage) {
        PaginationData data = sysResourcesService.selectResourcesListBySearchKey(sysMenuPage);
        return new Result(data);
    }

    @ApiOperation(value = "新增功能", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/system/sysResources/add")
    public Result add(@Validated @RequestBody SysResources sysResources) {
        sysResourcesService.insertResources(sysResources);
        return new Result();
    }

    @ApiOperation(value = "修改功能", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysResources/update")
    public Result update(@Validated @RequestBody SysResources sysResources) {
        Assert.notNull(sysResources.getId(), "功能ID不能为空");
        sysResourcesService.updateResourcesById(sysResources);
        return new Result();
    }

    @ApiOperation(value = "批量删除功能", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/system/sysResources/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "功能ID不能为空");
        sysResourcesService.deleteResourcesById(ids);
        return new Result();
    }

    @ApiOperation(value = "根据ID查询功能", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/system/sysResources/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "功能ID不能为空");
        SysResources sysResources = sysResourcesService.selectSysResourcesById(id);
        return new Result(sysResources);
    }

    @ApiOperation(value = "校验页面功能名称是否存在", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/checkResourceName")
    @RequiresPermissions("/system/sysResources/checkResourceName")
    public Result checkResourceName(String resourceName){
        return sysResourcesService.checkResourceName(resourceName);
    }
}
