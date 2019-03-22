package com.jn.system.menu.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.menu.model.*;
import com.jn.system.menu.service.SysMenuService;
import com.jn.system.menu.vo.SysMenuTreeVO;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @ControllerLog(doAction = "查询菜单列表")
    @ApiOperation(value = "查询菜单列表", notes = "返回菜单树结构")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/list")
    public Result<List<SysMenuTreeVO>> list() {
        List<SysMenuTreeVO> menuTreeVOList = sysMenuService.selectMenuList(true);
        return new Result(menuTreeVOList);
    }

    @ControllerLog(doAction = "修改菜单")
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/update")
    public Result update(@Validated @RequestBody SysMenu sysMenu) {
        Assert.notNull(sysMenu.getId(), "菜单ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuService.updateSysMenuById(sysMenu, user);
        return new Result();
    }

    @ControllerLog(doAction = "逻辑删除菜单")
    @ApiOperation(value = "逻辑删除菜单", notes = "逻辑删除菜单")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/delete")
    public Result delete(String id) {
        Assert.notNull(id, "菜单id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuService.deleteSysMenuById(id, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询菜单")
    @ApiOperation(value = "根据ID查询菜单", notes = "根据ID查询菜单")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/selectById")
    public Result<SysMenu> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "菜单ID不能为空");
        SysMenu sysMenu = sysMenuService.selectMenuById(id);
        return new Result(sysMenu);
    }

    @ControllerLog(doAction = "菜单添加目录菜单")
    @ApiOperation(value = "菜单添加目录菜单", notes = "菜单添加目录菜单")
    @RequestMapping(value = "/addMenuDir", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/addMenuDir")
    public Result addMenuDir(@Validated @RequestBody SysMenuDirAdd sysMenuAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuAdd.setId(UUID.randomUUID().toString());
        sysMenuService.addMenuDir(sysMenuAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "目录菜单下面添加子菜单")
    @ApiOperation(value = "目录菜单下面添加子菜单", notes = "目录菜单下面添加子菜单")
    @RequestMapping(value = "/addMenu", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/addMenu")
    public Result addMenu(@Validated @RequestBody SysMenuAdd sysMenuAdd) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuAdd.setId(UUID.randomUUID().toString());
        sysMenuService.addMenu(sysMenuAdd, user);
        return new Result();
    }

    @ControllerLog(doAction = "校验菜单名称")
    @ApiOperation(value = "校验菜单名称", notes = "fail表示名称已存在,success表示可以使用")
    @RequiresPermissions("/system/sysMenu/checkMenuName")
    @RequestMapping(value = "/checkMenuName", method = RequestMethod.POST)
    public Result<String> checkMenuName(@Validated @RequestBody SysMenuNameCheck sysMenuNameCheck) {
        String result = sysMenuService.checkMenuName(sysMenuNameCheck);
        return new Result(result);
    }

    @ControllerLog(doAction = "批量更新菜单")
    @ApiOperation(value = "批量更新菜单", notes = "批量更新菜单")
    @RequestMapping(value = "/updateBatch", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/updateBatch")
    public Result updateBatch(@Validated @RequestBody SysMenus sysMenus) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysMenuService.updateBatch(sysMenus, user);
        return new Result();
    }

    @ControllerLog(doAction = "根据父菜单id获取子下一级所有菜单信息")
    @ApiOperation(value = "根据父菜单id获取子下一级所有菜单信息", notes = "根据父菜单id获取子下一级所有菜单信息")
    @RequestMapping(value = "/getChildrenMenuByParentId", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/getChildrenMenuByParentId")
    public Result<List<SysMenuTreeVO>> getChildrenMenuByParentId(String parentId) {
        List<SysMenuTreeVO> list = sysMenuService.getChildrenMenuByParentId(parentId);
        return new Result(list);
    }

    @ControllerLog(doAction = "根据用户权限动态获取菜单信息")
    @ApiOperation(value = "根据用户权限动态获取菜单信息", notes = "根据用户权限动态获取菜单信息")
    @RequestMapping(value = "/getDynamicMenu", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysMenu/getDynamicMenu")
    public Result<List<SysMenuTreeVO>> getDynamicMenu() {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<SysMenuTreeVO> menuTreeVOList = sysMenuService.getDynamicMenu(user.getId());
        return new Result(menuTreeVOList);
    }
}
