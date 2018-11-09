package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.SysFileGroup;
import com.jn.system.model.SysFileGroupFileAdd;
import com.jn.system.model.SysFileGroupPage;
import com.jn.system.service.SysFileGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 文件组controller
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "文件组管理")
@CrossOrigin
@RestController
@RequestMapping("/system/sysFileGroup")
public class SysFileGroupController extends BaseController {

    @Autowired
    private SysFileGroupService sysFileGroupService;

    @ApiOperation(value = "查询文件组列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysFileGroup/list")
    public Result list(@RequestBody SysFileGroupPage sysFileGroupPage) {
        PaginationData data = sysFileGroupService.selectSysFileGroupListBySearchKey(sysFileGroupPage);
        return new Result(data);
    }

    @ApiOperation(value = "新增文件组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/system/sysFileGroup/add")
    public Result add(@Validated @RequestBody SysFileGroup sysFileGroup) {
        sysFileGroupService.insertSysFileGroup(sysFileGroup);
        return new Result();
    }

    @ApiOperation(value = "修改文件组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysFileGroup/update")
    public Result update(@Validated @RequestBody SysFileGroup sysFileGroup) {
        Assert.notNull(sysFileGroup.getId(), "文件组ID不能为空");
        sysFileGroupService.updateSysFileGroupById(sysFileGroup);
        return new Result();
    }

    @ApiOperation(value = "批量删除文件组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/system/sysFileGroup/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "文件组ID不能为空");
        sysFileGroupService.deleteSysFileGroupByIds(ids);
        return new Result();
    }

    @ApiOperation(value = "根据ID查询文件组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/system/sysFileGroup/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "文件组ID不能为空");
        SysFileGroup sysFileGroup = sysFileGroupService.selectSysFileGroupByIds(id);
        return new Result(sysFileGroup);
    }

    @ApiOperation(value = "文件组添加文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/sysFileGroupFileAdd")
    @RequiresPermissions("/system/sysFileGroup/sysFileGroupFileAdd")
    public Result sysFileGroupFileAdd(@RequestBody SysFileGroupFileAdd sysFileGroupFileAdd) {
        Assert.notNull(sysFileGroupFileAdd.getFileGroupId(), "文件组ID不能为空");
        sysFileGroupService.sysFileGroupFileAdd(sysFileGroupFileAdd);
        return new Result();
    }


}
