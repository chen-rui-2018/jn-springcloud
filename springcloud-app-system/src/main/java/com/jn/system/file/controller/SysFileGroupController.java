package com.jn.system.file.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.system.file.entity.TbSysFileGroup;
import com.jn.system.file.model.SysFileGroup;
import com.jn.system.file.model.SysFileGroupPage;
import com.jn.system.file.service.SysFileGroupService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * 文件组controller
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "文件组管理")
@RestController
@RequestMapping("/system/sysFileGroup")
public class SysFileGroupController extends BaseController {

    @Autowired
    private SysFileGroupService sysFileGroupService;

    @ControllerLog(doAction = "查询文件组列表")
    @ApiOperation(value = "查询文件组列表", notes = "查询文件组列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFileGroup/list")
    public Result<PaginationData<List<SysFileGroup>>> list(@RequestBody SysFileGroupPage sysFileGroupPage) {
        PaginationData<List<SysFileGroup>> data = sysFileGroupService.selectSysFileGroupListBySearchKey(sysFileGroupPage);
        return new Result(data);
    }

    @ControllerLog(doAction = "新增文件组")
    @ApiOperation(value = "新增文件组", notes = "新增文件组")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFileGroup/add")
    public Result add(@Validated @RequestBody SysFileGroup sysFileGroup) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //为文件组其他属性赋值
        sysFileGroup.setId(UUID.randomUUID().toString());
        sysFileGroup.setCreatorAccount(user.getAccount());
        sysFileGroup.setCreatedTime(new Date());
        TbSysFileGroup tbSysFileGroup = new TbSysFileGroup();
        BeanUtils.copyProperties(sysFileGroup, tbSysFileGroup);
        sysFileGroupService.insertSysFileGroup(tbSysFileGroup);
        return new Result();
    }

    @ControllerLog(doAction = "修改文件组")
    @ApiOperation(value = "修改文件组", notes = "修改文件组")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFileGroup/update")
    public Result update(@Validated @RequestBody SysFileGroup sysFileGroup) {
        Assert.notNull(sysFileGroup.getId(), "文件组ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysFileGroupService.updateSysFileGroupById(sysFileGroup, user);
        return new Result();
    }

    @ControllerLog(doAction = "批量删除文件组")
    @ApiOperation(value = "批量删除文件组", notes = "批量删除文件组")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFileGroup/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "文件组ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysFileGroupService.deleteSysFileGroupByIds(ids, user);
        return new Result();
    }

    @ControllerLog(doAction = "查询文件组信息")
    @ApiOperation(value = "查询文件组信息", notes = "根据ID查询文件组")
    @RequestMapping(value = "/selectById", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFileGroup/selectById")
    public Result<SysFileGroup> selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "文件组ID不能为空");
        SysFileGroup sysFileGroup = sysFileGroupService.selectSysFileGroupByIds(id);
        return new Result(sysFileGroup);
    }

    @ControllerLog(doAction = "校验文件组名称是否存在")
    @ApiOperation(value = "校验文件组名称是否存在", notes = "fail表示名称已存在,success表示可以使用")
    @RequestMapping(value = "/checkFileGroupName", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFileGroup/checkFileGroupName")
    public Result<String> checkFileGroupName(String fileGroupName) {
        String result = sysFileGroupService.checkFileGroupName(fileGroupName);
        return new Result(result);
    }

}
