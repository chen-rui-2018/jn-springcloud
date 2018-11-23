package com.jn.system.file.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.file.model.SysFile;
import com.jn.system.file.model.SysFileAddFileGroup;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.file.service.SysFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
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

    @ControllerLog(doAction = "查询文件列表")
    @ApiOperation(value = "查询文件列表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/list")
    @RequiresPermissions("/system/sysFile/list")
    public Result list(@Validated @RequestBody SysFilePage sysFilePage) {
        PaginationData data = sysFileService.selectSysFileListBySearchKey(sysFilePage);
        return new Result(data);
    }

    @ControllerLog(doAction = "新增文件")
    @ApiOperation(value = "新增文件", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFile/add")
    public Result add(@Validated @RequestBody SysFile sysFile) {
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysFileService.insertSysFile(sysFile,user);
        return new Result();
    }

    @ControllerLog(doAction = "修改文件")
    @ApiOperation(value = "修改文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/update")
    @RequiresPermissions("/system/sysFile/update")
    public Result update(@Validated @RequestBody SysFile sysFile) {
        Assert.notNull(sysFile.getId(), "文件ID不能为空");
        sysFileService.updateSysFileById(sysFile);
        return new Result();
    }

    @ControllerLog(doAction = "批量删除文件")
    @ApiOperation(value = "批量删除文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/delete")
    @RequiresPermissions("/system/sysFile/delete")
    public Result delete(@RequestParam(value = "ids") String[] ids) {
        Assert.noNullElements(ids, "文件ID不能为空");
        sysFileService.deleteSysFileByIds(ids);
        return new Result();
    }

    @ControllerLog(doAction = "根据ID查询文件")
    @ApiOperation(value = "根据ID查询文件", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectById")
    @RequiresPermissions("/system/sysFile/selectById")
    public Result selectById(@RequestParam(value = "id") String id) {
        Assert.notNull(id, "文件ID不能为空");
        SysFile sysFile = sysFileService.selectSysFileByIds(id);
        return new Result(sysFile);
    }

    @ControllerLog(doAction = "文件添加文件组")
    @ApiOperation(value = "文件添加文件组", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/sysFileAddFileGroup")
    @RequiresPermissions("/system/sysFile/sysFileAddFileGroup")
    public Result sysFileAddFileGroup(@RequestBody SysFileAddFileGroup sysFileAddFileGroup) {
        Assert.notNull(sysFileAddFileGroup.getFileId(), "文件ID不能为空");
        //获取当前登录用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        sysFileService.sysFileAddFileGroup(sysFileAddFileGroup,user);
        return new Result();
    }

    @ControllerLog(doAction = "校验文件名称")
    @ApiOperation(value = "校验文件名称", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/checkFileName")
    @RequiresPermissions("/system/sysFile/checkFileName")
    public Result checkFileName(String fileName){
        String result = sysFileService.checkFileName(fileName);
        return new Result(result);
    }


}
