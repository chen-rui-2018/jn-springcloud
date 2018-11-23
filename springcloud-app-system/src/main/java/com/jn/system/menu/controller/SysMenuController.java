package com.jn.system.menu.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.menu.model.SysMenu;
import com.jn.system.menu.model.SysMenuAdd;
import com.jn.system.menu.model.SysMenuNameCheck;
import com.jn.system.menu.model.SysMenuResourcesAdd;
import com.jn.system.model.*;
import com.jn.system.menu.service.SysMenuService;
import com.jn.system.menu.vo.SysMenuTreeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ControllerLog(doAction = "查询菜单列表,返回菜单树结构")
    @ApiOperation(value = "查询菜单列表,返回菜单树结构", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysMenu/list")
    public Result list() {
        List<SysMenuTreeVO> menuTreeVOList = sysMenuService.selectMenuListBySearchKey();
        return new Result(menuTreeVOList);
    }

    @ControllerLog(doAction = "修改菜单")
    @ApiOperation(value = "修改菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysMenu/update")
    public Result update(@Validated @RequestBody SysMenu sysMenu) {
        Assert.notNull(sysMenu.getId(), "菜单ID不能为空");
        sysMenuService.updateSysMenuById(sysMenu);
        return new Result();
    }

    @ControllerLog(doAction = "批量删除菜单")
    @ApiOperation(value = "批量删除菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/system/sysMenu/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "菜单ID不能为空");
        sysMenuService.deleteSysMenuById(ids);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询菜单")
    @ApiOperation(value = "根据ID查询菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/system/sysMenu/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "菜单ID不能为空");
        SysMenu sysMenu = sysMenuService.selectMenuById(id);
        return new Result(sysMenu);
    }

    @ControllerLog(doAction = "菜单添加功能")
    @ApiOperation(value = "菜单添加功能", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/insertMenuResources")
    @RequiresPermissions("/system/sysMenu/insertMenuResources")
    public Result insertMenuResources(@Validated @RequestBody SysMenuResourcesAdd sysMenuResourcesAdd) {
        Assert.notNull(sysMenuResourcesAdd.getMenuId(), "菜单ID不能为空");
        if (sysMenuResourcesAdd.getResourcesId().length == 0) {
            Assert.notNull(sysMenuResourcesAdd.getResourcesName(), "功能名称不能为空");
            Assert.notNull(sysMenuResourcesAdd.getResourcesUrl(), "功能路径不能为空");
            Assert.notNull(sysMenuResourcesAdd.getStatus(), "功能状态不能为空");
        }
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuService.insertMenuResources(sysMenuResourcesAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "菜单添加目录或子目录")
    @ApiOperation(value = "菜单添加目录或子目录", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/addMenuDir")
    @RequiresPermissions("/system/sysMenu/addMenuDir")
    public Result addMenuDir(@Validated @RequestBody SysMenuAdd sysMenuAdd){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuService.addMenuDir(sysMenuAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "菜单目录下面添加子菜单")
    @ApiOperation(value = "菜单目录下面添加子菜单", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/addMenu")
    @RequiresPermissions("/system/sysMenu/addMenu")
    public Result addMenu(@Validated @RequestBody SysMenuAdd sysMenuAdd){
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuService.addMenu(sysMenuAdd,user);
        return new Result();
    }

    @ControllerLog(doAction = "校验菜单名称,fail表示名称已存在,success表示可以使用")
    @ApiOperation(value = "校验菜单名称,fail表示名称已存在,success表示可以使用", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/checkMenuName")
    @RequiresPermissions("/system/sysMenu/checkMenuName")
    public Result checkMenuName(@Validated @RequestBody SysMenuNameCheck sysMenuNameCheck){
        String result = sysMenuService.checkMenuName(sysMenuNameCheck);
        return new Result(result);
    }
}
