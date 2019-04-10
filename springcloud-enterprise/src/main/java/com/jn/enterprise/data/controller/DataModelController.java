package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 9:31
 * @version： v1.0
 * @modified By:
 */
@Api(tags="数据上报-指标/数据模板管理")
@RestController
@RequestMapping(value = "/data")
public class DataModelController  extends BaseController {

    @ControllerLog(doAction = "数据上报-指标管理-树形指标列表获取")
    @ApiOperation(value = "树形指标列表获取",notes = "返回树形指标列表")
    @GetMapping(value = "/target/getTargetTree")
    @RequiresPermissions("/data/target/getTargetTree")
    public Result<List<TreeData>> getTargetTree(){
        List<TreeData> list = new ArrayList<>();
        return new Result(list);
    }

    @ControllerLog(doAction = "数据上报-指标管理-获取指标信息")
    @ApiOperation(value = "获取指标信息",notes = "返回指标信息")
    @GetMapping(value = "/target/getTargetInfo")
    @RequiresPermissions("/data/target/getTargetInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name="targetId",value = "指标ID",example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result<TargetVO> getTargetInfo(String targetId){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-指标管理-作废指标")
    @ApiOperation(value = "作废指标",notes = "返回作废指标的结果")
    @PostMapping(value = "/target/invalidTarget")
    @RequiresPermissions("/data/target/invalidTarget")
    @ApiImplicitParams({
            @ApiImplicitParam(name="targetId",value = "指标ID",example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result invalidTarget(String targetId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-指标管理-更新指标信息")
    @ApiOperation(value = "更新指标信息",notes = "返回更新指标信息的结果")
    @PostMapping(value = "/target/updateTarget")
    @RequiresPermissions("/data/target/updateTarget")
    public Result updateTarget(@ModelAttribute TargetVO target){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-数据模板管理-模板树列表获取")
    @ApiOperation(value = "模板树列表获取",notes = "返回模板树")
    @GetMapping(value = "/dataModel/getModelTree")
    @RequiresPermissions("/data/dataModel/getModelTree")
    public Result<List<TreeData>> getModelTree(){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-数据模板管理-更新模板")
    @ApiOperation(value = "更新模板",notes = "返回更新模板结果")
    @PostMapping(value = "/dataModel/updateModel")
    @RequiresPermissions("/data/dataModel/updateModel")
    public Result updateModel( ModelDataVO param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-数据模板管理-获取模板信息")
    @ApiOperation(value = "获取模板信息",notes = "返回模板信息")
    @PostMapping(value = "/dataModel/getModel")
    @RequiresPermissions("/data/dataModel/getModel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板id",example = "0",dataType = "String" ,paramType = "query")
    })
    public Result<ModelDataVO> getModel(String modelId){
        return new Result();
    }




}
