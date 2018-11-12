package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.model.SysFile;
import com.jn.system.model.SysFileAddFileGroup;
import com.jn.system.model.SysFilePage;
import com.jn.system.service.SysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 文件controller
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:40
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "文件管理")
@RestController
@RequestMapping("/system/sysFile")
public class SysFileController extends BaseController {

    @Autowired
    private SysFileService sysFileService;

    @ApiOperation(value = "查询文件列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysFile/list")
    public Result list(@RequestBody SysFilePage sysFilePage) {
        PaginationData data = sysFileService.selectSysFileListBySearchKey(sysFilePage);
        return new Result(data);
    }

    @ApiOperation(value = "新增文件", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFile/add")
    public Result add(@Validated @RequestBody SysFile sysFile) {
        sysFileService.insertSysFile(sysFile);
        return new Result();
    }

    @ApiOperation(value = "修改文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysFile/update")
    public Result update(@Validated @RequestBody SysFile sysFile) {
        Assert.notNull(sysFile.getId(), "文件ID不能为空");
        sysFileService.updateSysFileById(sysFile);
        return new Result();
    }

    @ApiOperation(value = "批量删除文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/system/sysFile/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "文件ID不能为空");
        sysFileService.deleteSysFileByIds(ids);
        return new Result();
    }

    @ApiOperation(value = "根据ID查询文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/system/sysFile/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "文件ID不能为空");
        SysFile sysFile = sysFileService.selectSysFileByIds(id);
        return new Result(sysFile);
    }

    @ApiOperation(value = "文件添加文件组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/sysFileAddFileGroup")
    @RequiresPermissions("/system/sysFile/sysFileAddFileGroup")
    public Result sysFileAddFileGroup(@RequestBody SysFileAddFileGroup sysFileAddFileGroup) {
        Assert.notNull(sysFileAddFileGroup.getFileId(), "文件ID不能为空");
        sysFileService.sysFileAddFileGroup(sysFileAddFileGroup);
        return new Result();
    }


}
