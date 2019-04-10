package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.vo.*;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author： yangh
 * @date： Created on 2019/4/4 15:48
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "数据上报-企业/园区数据上报")
@RestController
@RequestMapping(path="/data")
public class DataUploadController  extends BaseController {
    /**企业数据上报**/

    @ControllerLog(doAction = "数据上报-企业数据上报-页面广告获取")
    @GetMapping(path = "/company/getPcAd")
    @ApiOperation(value = "页面广告获取",notes = "返回广告图片")
    @RequiresPermissions("/data/company/getPcAd")
    public Result<Map<String,Object>> getPcAd(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业数据上报-获取待填报的表单")
    @GetMapping(path = "/company/getForm")
    @ApiOperation(value = "获取待填报的表单",notes = "返回表单结构信息")
    @RequiresPermissions("/data/company/getForm")
    public Result<PaginationData<List<CompanyDataModel>>> getForm(@ModelAttribute CompanyDataParamModel param){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-企业数据上报-获取待填报的表单结构")
    @GetMapping(path = "/company/getFormStruct")
    @ApiOperation(value = "获取待填报的表单结构",notes = "返回表单的信息结构")
    @RequiresPermissions("/data/company/getFormStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板Id",dataType = "String",paramType = "query",example = "1")
    })
    public Result<ModelDataVO> getFormStruct(String modelId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业数据上报-保存企业数据上报信息")
    @PostMapping(path = "/company/saveCompanyFormData")
    @ApiOperation(value = "保存企业数据上报信息",notes = "返回成功或失败")
    @RequiresPermissions("/data/company/saveCompanyFormData")
    public Result saveCompanyFormData(@ModelAttribute ModelDataVO data){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-企业数据上报-获取企业已经填报的表单")
    @GetMapping(path = "/company/getFormed")
    @ApiOperation(value = "获取企业已经填报的表单",notes = "返回企业已经填报的表单")
    @RequiresPermissions("/data/company/getFormed")
    public Result<CompanyDataModel> getFormed(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业数据上报-获取企业已经填报的表单的结构信息和值")
    @GetMapping(path = "/company/getCompanyFormedStruct")
    @ApiOperation(value = "获取企业已经填报的表单的结构信息和值",notes = "返回企业已经填报的表单的结构信息和值")
    @RequiresPermissions("/data/company/getCompanyFormedStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "填报id",dataType = "String",paramType = "query",example = "1")
    })
    public Result<ModelDataVO> getCompanyFormedStruct(String fileId){
        return new Result();
    }


    /**企业上报数据统计**/
    @ControllerLog(doAction = "数据上报-企业数据上报统计-获取企业已经填报的表单的结构信息和值")
    @GetMapping(path = "/company/getFormView")
    @ApiOperation(value = "获取企业已经填报的表单的结构信息和值",notes = "返回企业已经填报的表单的结构信息和值")
    @RequiresPermissions("/data/company/getFormView")
    public Result<PaginationData<List<CompanyDataStatisticsModel>>> getFormView(@ModelAttribute CompanyDataStatisticsParamModel param){
        //fileType=1:企业 2园区
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业数据上报统计-获取企业数据上报统计详细列表")
    @GetMapping(path = "/company/getFormList")
    @ApiOperation(value = "获取企业数据上报统计详细列表",notes = "返回企业数据上报统计详细列表")
    @RequiresPermissions("/data/company/getFormList")
    public Result<PaginationData<List<CompanyDataModel>>> getFormList(@ModelAttribute CompanyDataParamModel param){
        //fileType=1:企业 2园区
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业数据上报统计-获取企业已经填报的信息")
    @GetMapping(path = "/company/getFormedStruct")
    @ApiOperation(value = "获取企业已经填报的信息",notes = "返回企业已经填报的信息")
    @RequiresPermissions("/data/company/getFormedStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板ID",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="formTime",value = "填报账期",dataType = "String",paramType = "query",example = "填报周期为月时YYYYMM，为年时YYYY"),
            @ApiImplicitParam(name="modelCycle",value = "填报周期",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="companyId",value = "企业ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="groupId",value = "群组ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="fillInFormDeadline",value = "填报截至时间",dataType = "String",paramType = "query",example = "1")
    })
    public Result<ModelDataVO> getFormedStruct(String modelId,String formTime,String modelCycle, String companyId,String groupId,String fillInFormDeadline ){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-企业数据上报统计-导出明细")
    @GetMapping(path = "/company/exportDetail")
    @ApiOperation(value = "数据上报-企业数据上报统计-导出明细",notes = "导出excel明细")
    @RequiresPermissions("/data/company/getFormedStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板ID",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="formTime",value = "填报账期",dataType = "String",paramType = "query",example = "填报周期为月时YYYYMM，为年时YYYY"),
            @ApiImplicitParam(name="modelCycle",value = "填报周期",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="companyId",value = "企业ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="groupId",value = "群组ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="fillInFormDeadline",value = "群组ID",dataType = "String",paramType = "query",example = "1")
    })
    public Result exportDetail(String modelId,String formTime,String modelCycle,String companyId,String groupId,String fillInFormDeadline){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-企业数据上报统计-汇总导出")
    @GetMapping(path = "/company/exportCollect")
    @ApiOperation(value = "数据上报-企业数据上报统计-汇总导出",notes = "导出excel汇总")
    @RequiresPermissions("/data/company/exportCollect")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelId",value = "模板ID",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="formTime",value = "填报账期",dataType = "String",paramType = "query",example = "填报周期为月时YYYYMM，为年时YYYY"),
            @ApiImplicitParam(name="modelCycle",value = "填报周期",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="companyId",value = "企业ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="groupId",value = "群组ID",dataType = "String",paramType = "query",example = "1"),
            @ApiImplicitParam(name="fillInFormDeadline",value = "群组ID",dataType = "String",paramType = "query",example = "1")
    })
    public Result exportCollect(String modelId,String formTime,String modelCycle,String companyId,String groupId,String fillInFormDeadline){
        return new Result();
    }

    /**园区上报数据统计**/

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区广告获取")
    @GetMapping(path = "/garden/getAd")
    @ApiOperation(value = "历史记录详细信息获取",notes = "返回历史记录详细信息")
    @RequiresPermissions("/data/garden/getAd")
    public Result<Map<String,Object>> getAd(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-本月数据上报")
    @GetMapping(path = "/garden/getCurrentMonthTasks")
    @ApiOperation(value = "园区本月数据上报",notes = "返回园区本月数据上报任务")
    @RequiresPermissions("/data/garden/getCurrentMonthTasks")
    public Result<PaginationData<List<CompanyDataModel>>> getCurrentMonthTasks(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-本月数据上报保存")
    @PostMapping(path = "/garden/saveTaskData")
    @ApiOperation(value = "园区本月数据上报保存",notes = "返回成功或失败")
    @RequiresPermissions("/data/garden/saveTaskData")
    public Result saveTaskData(@ModelAttribute ModelDataVO data){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-本月数据上报,空白表单获取")
    @GetMapping(path = "/garden/getCurrentMonthForm")
    @ApiOperation(value = "本月数据上报,空白表单获取",notes = "返回园区本月数据上报任务表单")
    @RequiresPermissions("/data/garden/getCurrentMonthForm")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "任务Id",dataType = "String",paramType = "query",example = "001")
    })
    public Result<ModelDataVO> getCurrentMonthForm(String fileId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-数据上报历史记录列表")
    @GetMapping(path = "/garden/getHostoryTask")
    @ApiOperation(value = "数据上报历史记录列表",notes = "返回数据上报历史记录列表")
    @RequiresPermissions("/data/garden/getHostoryTask")
    @ApiImplicitParams({
            @ApiImplicitParam(name="modelType",defaultValue = "" ,value = "填报类型",dataType = "String",paramType = "query",example = "填报周期1：年，0：月"),
            @ApiImplicitParam(name="modelName",defaultValue = "" ,value = "填报名称",dataType = "String",paramType = "query",example = "")
    })
    public Result<PaginationData<List<CompanyDataModel>>> getHostoryTask(@ModelAttribute CompanyDataParamModel param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-历史记录详细信息获取")
    @GetMapping(path = "/garden/getFormStruct")
    @ApiOperation(value = "历史记录详细信息获取",notes = "返回历史记录详细信息")
    @RequiresPermissions("/data/garden/getFormStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "任务Id",dataType = "String",paramType = "query",example = "001")
    })
    public Result<ModelDataVO> getGardenFormStruct(String fileId){
        return new Result();
    }

    /**园区上报数据审核**/

    @ControllerLog(doAction = "数据上报-园区数据上报统计-审核列表")
    @GetMapping(path = "/garden/getCheckList")
    @ApiOperation(value = "审核列表",notes = "返回审核列表")
    @RequiresPermissions("/data/garden/getCheckList")
    public Result<PaginationData<List<GardenCheckModel>>> getGardenCheckList(@ModelAttribute GardenCheckParamModel param){
        return new Result();
    }


    @ControllerLog(doAction = "数据上报-园区数据上报统计-审核/详情")
    @GetMapping(path = "/garden/getCheckOrLookInfo")
    @ApiOperation(value = "审核列表",notes = "返回审核列表")
    @RequiresPermissions("/data/garden/getCheckOrLookInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",defaultValue = "",value = "工单编号",dataType = "String",paramType = "query",example = "001")
    })
    public Result<ModelDataVO> getCheckOrLookInfo(String fileId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-审核建议")
    @GetMapping(path = "/garden/saveCheck")
    @ApiOperation(value = "审核建议",notes = "返回审核建议结果")
    @RequiresPermissions("/data/garden/saveCheck")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "工单编号",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="gardenExamineStauts",value = "审批结果",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="examineComment",value = "审批意见",dataType = "String",paramType = "query",example = "001")
    })
    public Result saveCheck(String fileId,String gardenExamineStauts,String examineComment){
        return new Result();
    }

    /**园区上报数据统计**/

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区内部数据上报列表")
    @GetMapping(path = "/garden/getStatisticsList")
    @ApiOperation(value = "园区内部数据上报列表",notes = "返回列表")
    @RequiresPermissions("/data/garden/getStatisticsList")
    public Result<PaginationData<List<CompanyDataStatisticsModel>>> getStatisticsList(@ModelAttribute CompanyDataStatisticsParamModel param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区内部数据列表详情")
    @GetMapping(path = "/garden/getStatisticsListInfo")
    @ApiOperation(value = "园区内部数据列表详情",notes = "返回列表详情")
    @RequiresPermissions("/data/garden/getStatisticsListInfo")
    public Result<PaginationData<List<CompanyDataModel>>> getStatisticsListInfo(@ModelAttribute CompanyDataParamModel param){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区内部数据列表催报")
    @GetMapping(path = "/garden/setStatisticsListUrge")
    @ApiOperation(value = "园区内部数据列表催报",notes = "返回催报结果")
    @RequiresPermissions("/data/garden/setStatisticsListUrge")
    @ApiImplicitParams({
            @ApiImplicitParam(name="formTime",value = "账期",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelName",value = "模板名称",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelCycle",value = "填报周期",dataType = "String",paramType = "query",example = "001")

    })
    public Result setStatisticsListUrge(String formTime,String modelName,String modelCycle){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区内部数据列表修改截至日期")
    @GetMapping(path = "/garden/setDeadline")
    @ApiOperation(value = "园区内部数据列表修改截至日期",notes = "返回修改截至日期的结果")
    @RequiresPermissions("/data/garden/setDeadline")
    @ApiImplicitParams({
            @ApiImplicitParam(name="formTime",value = "账期",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelName",value = "模板名称",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelCycle",value = "填报周期",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="fillInFormDeadline",value = "截至日期",dataType = "String",paramType = "query",example = "001")

    })
    public Result setDeadline(String formTime,String modelName,String modelCycle){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区内部数据详细信息")
    @GetMapping(path = "/garden/getStruct")
    @ApiOperation(value = "获取园区内部数据详细信息",notes = "返回园区内部数据详细信息")
    @RequiresPermissions("/data/garden/getStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "任务id",dataType = "String",paramType = "query",example = "001")

    })
    public Result<ModelDataVO> getStruct(String fileId){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区内部数据列表详情页面汇总导出")
    @GetMapping(path = "/garden/gardenExport")
    @ApiOperation(value = "汇总导出",notes = "返回excel文件")
    @RequiresPermissions("/data/garden/gardenExport")
    @ApiImplicitParams({
            @ApiImplicitParam(name="formTime",value = "账期",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelName",value = "模板名称",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelCycle",value = "填报周期",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="fillInFormDeadline",value = "截至日期",dataType = "String",paramType = "query",example = "001")

    })
    public Result gardenExport(String formTime,String modelName,String modelCycle,String fillInFormDeadline){
        return new Result();
    }


}
