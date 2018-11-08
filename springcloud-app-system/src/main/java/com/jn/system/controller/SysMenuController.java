package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.SysMenu;
import com.jn.system.model.SysMenuPage;
import com.jn.system.model.SysMenuResourcesAdd;
import com.jn.system.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 菜单controller
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 11:13
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "菜单管理")
@RestController
@RequestMapping("/system/sysMenu")
public class SysMenuController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation(value = "查询菜单列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    public Result list(@RequestBody SysMenuPage sysMenuPage) {
        PaginationData data = sysMenuService.selectMenuListBySearchKey(sysMenuPage);
        return new Result(data);
    }

    @ApiOperation(value = "新增菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    public Result add(@Validated @RequestBody SysMenu sysMenu) {
        sysMenuService.insertSysMenu(sysMenu);
        return new Result();
    }

    @ApiOperation(value = "修改菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    public Result update(@Validated @RequestBody SysMenu sysMenu) {
        Assert.notNull(sysMenu.getId(), "菜单ID不能为空");
        sysMenuService.updateSysMenuById(sysMenu);
        return new Result();
    }

    @ApiOperation(value = "批量删除菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "菜单ID不能为空");
        sysMenuService.deleteSysMenuById(ids);
        return new Result();
    }

    @ApiOperation(value = "根据ID查询菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "菜单ID不能为空");
        SysMenu sysMenu = sysMenuService.selectMenuById(id);
        return new Result(sysMenu);
    }

    @ApiOperation(value = "菜单添加功能", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/insertMenuResources")
    public Result insertMenuResources(@RequestBody SysMenuResourcesAdd sysMenuResourcesAdd) {
        Assert.notNull(sysMenuResourcesAdd.getMenuId(), "菜单ID不能为空");
        if (sysMenuResourcesAdd.getResourcesId().length == 0) {
            Assert.notNull(sysMenuResourcesAdd.getResourcesName(), "功能名称不能为空");
            Assert.notNull(sysMenuResourcesAdd.getResourcesUrl(), "功能路径不能为空");
            Assert.notNull(sysMenuResourcesAdd.getStatus(), "功能状态不能为空");
        }
        sysMenuService.insertMenuResources(sysMenuResourcesAdd);
        return new Result();
    }


}
