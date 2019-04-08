package com.jn.enterprise.data.modelmanager.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.data.vo.ModelData;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 9:31
 * @version： v1.0
 * @modified By:
 */
@Api(tags="数据上报-数据模板管理")
@RestController
@RequestMapping(value = "/data/dataModel")
public class DataModelController  extends BaseController {
    @ControllerLog(doAction = "数据上报-数据模板管理-模板树列表获取")
    @ApiOperation(value = "模板树列表获取",notes = "返回模板树")
    @GetMapping(value = "/getModelTree")
    @RequiresPermissions("/data/dataModel/getModelTree")
    public Result getModelTree(){
        return new Result();
    }

    /**
     * 返回：模板ID
     * @param modelType
     * @return
     */
    @ControllerLog(doAction = "数据上报-数据模板管理-新增模板")
    @ApiOperation(value = "新增模板",notes = "返回新增模板结果，用于回显")
    @GetMapping(value = "/createModel")
    @RequiresPermissions("/data/dataModel/createModel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelType",value = "填报类型（0：企业，1：园管委会）",example = "0",dataType = "String" ,paramType = "query")
    })
    public Result<ModelData> createModel(String modelType){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-数据模板管理-更新模板")
    @ApiOperation(value = "更新模板",notes = "返回更新模板结果")
    @PostMapping(value = "/updateModel")
    @RequiresPermissions("/data/dataModel/updateModel")
    public Result updateModel( ModelData param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-数据模板管理-获取模板信息")
    @ApiOperation(value = "获取模板信息",notes = "返回模板信息")
    @PostMapping(value = "/getModel")
    @RequiresPermissions("/data/dataModel/getModel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板id",example = "0",dataType = "String" ,paramType = "query")
    })
    public Result<ModelData> getModel(String modelId){
        return new Result();
    }


}
