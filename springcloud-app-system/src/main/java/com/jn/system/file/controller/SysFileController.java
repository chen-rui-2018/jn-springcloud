package com.jn.system.file.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.system.file.model.SysFilePage;
import com.jn.system.file.service.SysFileService;
import com.jn.system.file.vo.SysFileVO;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ApiOperation(value = "查询文件列表", notes = "查询文件列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @RequiresPermissions("/system/sysFile/list")
    public Result<PaginationData<List<SysFileVO>>> list(@Validated @RequestBody SysFilePage sysFilePage) {
        PaginationData<List<SysFileVO>> data = sysFileService.selectSysFileListBySearchKey(sysFilePage);
        return new Result(data);
    }

}
