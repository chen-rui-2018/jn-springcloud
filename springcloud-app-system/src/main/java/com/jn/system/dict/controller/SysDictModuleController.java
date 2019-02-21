package com.jn.system.dict.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.common.enums.SysStatusEnums;
import com.jn.system.dict.entity.TbSysDictModule;
import com.jn.system.dict.model.SysDictModule;
import com.jn.system.dict.model.SysDictModuleEdit;
import com.jn.system.dict.model.SysDictModulePage;
import com.jn.system.dict.service.SysDictModuleService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 模块管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 14:32
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "模块管理")
@RestController
@RequestMapping("/system/sysModule")
public class SysDictModuleController extends BaseController {

    @Autowired
    private SysDictModuleService sysDictModuleService;

    @ControllerLog(doAction = "新增模块")
    @ApiOperation(value = "新增模块", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/system/sysModule/add")
    public Result add(@Validated @RequestBody SysDictModuleEdit sysModule) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //设置模块属性值
        TbSysDictModule tbSysModule = new TbSysDictModule();
        BeanUtils.copyProperties(sysModule, tbSysModule);
        tbSysModule.setId(UUID.randomUUID().toString());
        tbSysModule.setCreatedTime(new Date());
        tbSysModule.setCreatorAccount(user.getAccount());
        Byte recordStatus = Byte.parseByte(SysStatusEnums.EFFECTIVE.getCode());
        tbSysModule.setRecordStatus(recordStatus);

        sysDictModuleService.add(tbSysModule);
        return new Result();
    }

    @ControllerLog(doAction = "修改模块")
    @ApiOperation(value = "修改模块", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysModule/update")
    public Result update(@Validated @RequestBody SysDictModuleEdit sysModule) {
        Assert.notNull(sysModule.getId(), "模块id不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //设置最新更新人及更新时间
        TbSysDictModule tbSysModule = new TbSysDictModule();
        BeanUtils.copyProperties(sysModule, tbSysModule);
        tbSysModule.setModifiedTime(new Date());
        tbSysModule.setModifierAccount(user.getAccount());

        sysDictModuleService.update(tbSysModule);
        return new Result();
    }

    @ControllerLog(doAction = "逻辑删除模块")
    @ApiOperation(value = "逻辑删除模块", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/system/sysModule/delete")
    public Result delete(String moduleId) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysDictModuleService.delete(moduleId, user);
        return new Result();
    }

    @ControllerLog(doAction = "模块列表")
    @ApiOperation(value = "模块列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysModule/list")
    public Result list(@Validated @RequestBody SysDictModulePage sysDictModulePage) {
        PaginationData data = sysDictModuleService.getModuleByPage(sysDictModulePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "获取全部模块")
    @ApiOperation(value = "获取全部模块", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/getAll")
    @RequiresPermissions("/system/sysModule/getAll")
    public Result getAll() {
        List<SysDictModule> sysDictModuleList = sysDictModuleService.getAll();
        return new Result(sysDictModuleList);
    }
}
