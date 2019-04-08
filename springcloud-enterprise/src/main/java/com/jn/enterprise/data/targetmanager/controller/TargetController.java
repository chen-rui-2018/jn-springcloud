package com.jn.enterprise.data.targetmanager.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.data.vo.Target;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @author： yangh
 * @date： Created on 2019/4/4 15:24
 * @version： v1.0
 * @modified By:
 */
@Api(tags="数据上报-指标管理")
@RestController
@RequestMapping(value = "/data/target")
public class TargetController  extends BaseController {

    @ControllerLog(doAction = "数据上报-指标管理-树形指标列表获取")
    @ApiOperation(value = "树形指标列表获取",notes = "返回树形指标列表")
    @GetMapping(value = "/getTargetTree")
    @RequiresPermissions("/data/target/getTargetTree")
    public Result getTargetTree(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-指标管理-获取指标信息")
    @ApiOperation(value = "获取指标信息",notes = "返回指标信息")
    @GetMapping(value = "/getTargetInfo")
    @RequiresPermissions("/data/target/getTargetInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name="targetId",value = "指标ID",example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result<Target> getTargetInfo(String targetId){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-指标管理-作废指标")
    @ApiOperation(value = "作废指标",notes = "返回作废指标的结果")
    @PostMapping(value = "/invalidTarget")
    @RequiresPermissions("/data/target/invalidTarget")
    @ApiImplicitParams({
            @ApiImplicitParam(name="targetId",value = "指标ID",example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result invalidTarget(String targetId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-指标管理-更新指标信息")
    @ApiOperation(value = "更新指标信息",notes = "返回更新指标信息的结果")
    @PostMapping(value = "/updateTarget")
    @RequiresPermissions("/data/target/updateTarget")
    public Result updateTarget(@ModelAttribute Target target){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-指标管理-新建指标")
    @ApiOperation(value = "新建指标",notes = "返回新建指标的结果,用于回显")
    @PostMapping(value = "/createTarget")
    @RequiresPermissions("/data/target/createTarget")
    @ApiImplicitParams({
            @ApiImplicitParam(name="parentId",value = "父指标ID,没有父指标传空",defaultValue = "" ,example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result<Target> createTarget(String parentId){
        return new Result();
    }
}
