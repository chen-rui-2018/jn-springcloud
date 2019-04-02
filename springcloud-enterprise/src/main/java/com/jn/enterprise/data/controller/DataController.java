package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： huangbq
 * @date： Created on 2019/3/24 16:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "数据上报-后台")
@RestController
@RequestMapping("/data")
public class DataController extends BaseController {




    @ControllerLog(doAction = "指标管理-树形列表")
    @ApiOperation(value = "指标管理-树形列表",notes = "返回指标树")
    @GetMapping(value = "/target/treeList")
    @RequiresPermissions("/data/target/treeList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "指标名称",example = "")
    })
    public Result departList(String name){
        return new Result();
    }


}
