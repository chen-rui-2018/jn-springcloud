package com.jn.system.dict.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dict.entity.TbSysDict;
import com.jn.system.dict.model.*;
import com.jn.system.dict.service.SysDictService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.SysDictInvoke;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 数据字典控制层
 *
 * @author： shaobao
 * @date： Created on 2019/1/24 16:17
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "数据字典管理")
@RestController
@RequestMapping("/system/sysDict")
public class SysDictController extends BaseController {

    @Autowired
    private SysDictService sysDictService;

    @ControllerLog(doAction = "新增数据字典")
    @ApiOperation(value = "新增数据字典", notes = "新增数据字典")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/add")
    public Result add(@Validated @RequestBody SysDictAdd sysDict) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //设置数据字典属性值
        TbSysDict tbSysDict = new TbSysDict();
        BeanUtils.copyProperties(sysDict, tbSysDict);
        tbSysDict.setId(UUID.randomUUID().toString());
        tbSysDict.setCreatedTime(new Date());
        tbSysDict.setCreatorAccount(user.getAccount());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysDict.setRecordStatus(recordStatus);

        //调用业务层添加数据
        sysDictService.add(tbSysDict);
        return new Result();
    }

    @ControllerLog(doAction = "修改数据字典")
    @ApiOperation(value = "修改数据字典", notes = "修改数据字典")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/update")
    public Result update(@Validated @RequestBody SysDictEdit sysDict) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        TbSysDict tbSysDict = new TbSysDict();
        BeanUtils.copyProperties(sysDict, tbSysDict);

        //设置最新更新人及最新更新时间
        tbSysDict.setModifiedTime(new Date());
        tbSysDict.setModifierAccount(user.getAccount());

        //调用业务层编辑数据
        sysDictService.update(tbSysDict);
        return new Result();
    }

    @ControllerLog(doAction = "逻辑删除数据字典")
    @ApiOperation(value = "逻辑删除数据字典", notes = "逻辑删除数据字典")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/delete")
    public Result delete(String dictId) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysDictService.delete(dictId, user);
        return new Result();
    }

    @ControllerLog(doAction = "数据字典分组排序")
    @ApiOperation(value = "数据字典分组排序", notes = "数据字典分组排序")
    @RequestMapping(value = "/sortByGroup", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/sortByGroup")
    public Result sortByGroup(@Validated @RequestBody List<SysDictEdit> sysDictList) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysDictService.sortByGroup(sysDictList, user);
        return new Result();
    }

    @ControllerLog(doAction = "分组排序搜索功能")
    @ApiOperation(value = "分组排序搜索功能", notes = "分组排序搜索功能")
    @RequestMapping(value = "/sortSearch", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/sortSearch")
    public Result<List<TbSysDict>> sortSearch(@Validated @RequestBody SysDictInvoke sysDictInvoke) {
        List<TbSysDict> dictList = sysDictService.sortSearch(sysDictInvoke);
        return new Result(dictList);
    }

    @ControllerLog(doAction = "数据字典列表")
    @ApiOperation(value = "数据字典列表", notes = "数据字典列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/list")
    public Result<PaginationData<List<SysDict>>> list(@Validated @RequestBody SysDictPage sysDictPage) {
        PaginationData<List<SysDict>> data = sysDictService.getDictByPage(sysDictPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "数据字典调用")
    @ApiOperation(value = "数据字典调用", notes = "数据字典调用")
    @RequestMapping(value = "/getDict", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysDict/getDict")
    public Result<List<SysDictKeyValue>> getDict(@Validated @RequestBody SysDictInvoke sysDictInvoke) {
        List<SysDictKeyValue> dictList = sysDictService.getDict(sysDictInvoke);
        return new Result(dictList);
    }
}
