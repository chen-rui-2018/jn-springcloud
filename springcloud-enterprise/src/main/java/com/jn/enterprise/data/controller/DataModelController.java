package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.data.entity.TbDataReportingGardenLinker;
import com.jn.enterprise.data.model.DataTargetsModelParam;
import com.jn.enterprise.data.model.GroupModel;
import com.jn.enterprise.data.model.InputFormatModel;
import com.jn.enterprise.data.model.TreeData;
import com.jn.enterprise.data.service.DataModelService;
import com.jn.enterprise.data.service.DataTaskTimerService;
import com.jn.enterprise.data.service.impl.DataModelServiceImpl;
import com.jn.enterprise.data.vo.ModelDataVO;
import com.jn.enterprise.data.vo.TargetModelVO;
import com.jn.enterprise.data.vo.TargetVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private DataModelService dataModelService;
    private static Logger logger = LoggerFactory.getLogger(DataModelController.class);

    @Autowired
    private DataTaskTimerService dataTaskTimerService;

    @ControllerLog(doAction = "数据上报-指标管理-树形指标列表获取")
    @ApiOperation(value = "树形指标列表获取",notes = "返回树形指标列表")
    @GetMapping(value = "/target/getTargetTree")
    @RequiresPermissions("/data/target/getTargetTree")
    public Result< List<TargetModelVO>> getTargetTree(){
        List<TargetModelVO> resultList = dataModelService.getTargetTree();
        return new Result(resultList);
    }

    @ControllerLog(doAction = "数据上报-指标管理-获取指标信息")
    @ApiOperation(value = "获取指标信息",notes = "返回指标信息")
    @GetMapping(value = "/target/getTargetInfo")
    @RequiresPermissions("/data/target/getTargetInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name="targetId",value = "指标ID",example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result<TargetVO> getTargetInfo(String targetId){
        TargetVO targetVO = dataModelService.getTargetInfo(targetId);
        return new Result(targetVO);

    }


    @ControllerLog(doAction = "数据上报-指标管理-作废指标")
    @ApiOperation(value = "作废指标",notes = "返回作废指标的结果,正常返回1")
    @GetMapping(value = "/target/invalidTarget")
    @RequiresPermissions("/data/target/invalidTarget")
    @ApiImplicitParams({
            @ApiImplicitParam(name="targetId",value = "指标ID",example = "0001",dataType = "String" ,paramType = "query")
    })
    public Result<Integer> invalidTarget(String targetId){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        Integer result = dataModelService.invalidTarget(targetId,user);
        return new Result(result);
    }

    @ControllerLog(doAction = "数据上报-指标管理-更新指标信息")
    @ApiOperation(value = "更新指标信息",notes = "返回更新指标信息的结果,正常返回1")
    @PostMapping(value = "/target/updateTarget")
    @RequiresPermissions("/data/target/updateTarget")
    public Result<Integer> updateTarget(@RequestBody TargetVO target){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        Integer result = dataModelService.updateTarget(target,user);
        return new Result(result);

    }


    @ControllerLog(doAction = "数据上报-数据模板管理-模板树列表获取")
    @ApiOperation(value = "模板树列表获取",notes = "返回模板树")
    @GetMapping(value = "/dataModel/getModelTree")
    @RequiresPermissions("/data/dataModel/getModelTree")
    public Result<List<TreeData>> getModelTree(){
        List<TreeData> treeData = dataModelService.getModelTree();
        return new Result(treeData);
    }


    @ControllerLog(doAction = "数据上报-数据模板管理-更新模板")
    @ApiOperation(value = "更新模板",notes = "返回更新模板结果,正常返回1")
    @PostMapping(value = "/dataModel/updateModel")
    @RequiresPermissions("/data/dataModel/updateModel")
    public Result<Integer> updateModel( @RequestBody  ModelDataVO param){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        Integer integer = dataModelService.updateModel(param,user);
        return new Result(integer);
    }

    @ControllerLog(doAction = "数据上报-数据模板管理-获取模板信息")
    @ApiOperation(value = "获取模板信息",notes = "返回模板信息")
    @GetMapping(value = "/dataModel/getModel")
    @RequiresPermissions("/data/dataModel/getModel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板id",example = "0",dataType = "String" ,paramType = "query")
    })
    public Result<ModelDataVO> getModel(String modelId){
        ModelDataVO result = dataModelService.getModel(modelId);
        return new Result(result);
    }


    @ControllerLog(doAction = "数据上报-数据模板管理-群组条件获取")
    @ApiOperation(value = "获取群组条件获取",notes = "返回群组条件")
    @GetMapping(value = "/dataModel/getGroupList")
    @RequiresPermissions("/data/dataModel/getGroupList")
    public Result<List<GroupModel>> getGroupList(){
        List<GroupModel> resultList = dataModelService.getGroupList();
        return new Result(resultList);
    }

    @ControllerLog(doAction = "数据上报-数据模板管理-预览")
    @ApiOperation(value = "获取指标集合的填报格式",notes = "返回指标集合的填报格式")
    @PostMapping(value = "/dataModel/getInputFormatByTargetIds")
    @RequiresPermissions("/data/dataModel/getInputFormatByTargetIds")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name="targetIds",allowMultiple=true,value = "模板id",example = "0",dataType = "String" ,paramType = "query")
//    })
    public Result<List<InputFormatModel>> getInputFormatByTargetIds(@RequestBody DataTargetsModelParam targetIds){
        List<InputFormatModel> resultList =dataModelService.getInputFormatByTargetIds(targetIds.getTargetIds());

        return new Result(resultList);
    }

    @ControllerLog(doAction = "数据上报-数据模板管理-获取模板生成的任务全部填完后的提醒人")
    @ApiOperation(value = "获取提醒人",notes = "返回提醒人")
    @GetMapping(value = "/dataModel/getWarner")
    @RequiresPermissions("/data/dataModel/getWarner")
    public Result<List<TbDataReportingGardenLinker>> getWarner(){
        List<TbDataReportingGardenLinker> resultList = dataModelService.getWarner();
        return new Result(resultList);
    }


    @ControllerLog(doAction = "任务创建")
    @ApiOperation(value = "任务创建",notes = "任务创建")
    @RequestMapping(value = "/task/createTask", method = RequestMethod.GET)
    @RequiresPermissions("/data/task/createTask")
    public void createTask(){

        dataTaskTimerService.createTask();
    }

    @ControllerLog(doAction = "更新任务状态")
    @RequestMapping(value = "/task/updateTask", method = RequestMethod.GET)
    @ApiOperation(value = "更新任务状态",notes = "更新任务状态")
    @RequiresPermissions("/data/task/updateTask")
    public void updateTask(){

        dataTaskTimerService.updateTask();
    }
}
