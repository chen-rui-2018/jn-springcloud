package com.jn.enterprise.data.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.data.dao.TargetDao;
import com.jn.enterprise.data.model.*;
import com.jn.enterprise.data.service.DataModelService;
import com.jn.enterprise.data.service.DataUploadService;
import com.jn.enterprise.data.service.impl.DataModelServiceImpl;
import com.jn.enterprise.data.util.POICompany;
import com.jn.enterprise.data.util.POIDescribe;
import com.jn.enterprise.data.util.POIScience;
import com.jn.enterprise.data.util.POIScienceHeader;
import com.jn.enterprise.data.vo.*;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

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


    @Autowired
    private TargetDao targetDao;


    @Autowired
    private DataUploadService uploadService;
    private static Logger logger = LoggerFactory.getLogger(DataUploadController.class);

    /**企业数据上报**/

    @ControllerLog(doAction = "数据上报-企业数据上报-页面广告获取")
    @GetMapping(path = "/company/getPcAd")
    @ApiOperation(value = "页面广告获取",notes = "返回广告图片")
    @RequiresPermissions("/data/company/getPcAd")
    public Result<Map<String,Set<String>>> getPcAd(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        Map<String,Set<String>> result = uploadService.getCompanyAd(user);
        return new Result(result);
    }

    @ControllerLog(doAction = "数据上报-企业数据上报-获取本月待填报的任务")
    @PostMapping(path = "/company/getForm")
    @ApiOperation(value = "获取本月待填报的任务",notes = "返回本月待填报的任务")
    @RequiresPermissions("/data/company/getForm")
    public Result<List<CompanyDataModel>> getForm(){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        List<CompanyDataModel> result = uploadService.getNeedFormList(user);
        return new Result(result);
    }

    @ControllerLog(doAction = "数据上报-企业数据上报-获取企业填报历史表单列表")
    @PostMapping(path = "/company/getFormed")
    @ApiOperation(value = "获取企业填报历史表单列表",notes = "返回企业填报历史表单列表")
    @RequiresPermissions("/data/company/getFormed")
    public Result<PaginationData<List<CompanyDataModel>>> getFormed(@RequestBody CompanyDataParamModel param){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        PaginationData<List<CompanyDataModel>> result = uploadService.getFormedHistory(param,user);
        return new Result(result);
    }


    @ControllerLog(doAction = "数据上报-企业数据上报-获取待填报的表单结构")
    @GetMapping(path = "/company/getFormStruct")
    @ApiOperation(value = "获取待填报的表单结构",notes = "返回表单的信息结构")
    @RequiresPermissions("/data/company/getFormStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "填报ID",dataType = "String",paramType = "query",example = "1")
    })
    public Result<ModelDataVO> getFormStruct(String fileId){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        ModelDataVO modelDataVO = uploadService.getFormStruct(fileId,user);
        return new Result(modelDataVO);
    }

    @ControllerLog(doAction = "数据上报-企业数据上报-保存企业数据上报信息")
    @PostMapping(path = "/company/saveCompanyFormData")
    @ApiOperation(value = "保存企业数据上报信息",notes = "返回成功或失败,正常结果为1")
    @RequiresPermissions("/data/company/saveCompanyFormData")
    public Result<Integer> saveCompanyFormData(@RequestBody ModelDataVO data){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        int result = uploadService.saveCompanyFormData(data,user);
        return new Result(result);
    }



    @ControllerLog(doAction = "数据上报-企业数据上报-获取企业已经填报的表单的结构信息和值")
    @GetMapping(path = "/company/getCompanyFormedStruct")
    @ApiOperation(value = "获取企业已经填报的表单的结构信息和值",notes = "返回企业已经填报的表单的结构信息和值，未填报的直接返回空白表单")
    @RequiresPermissions("/data/company/getCompanyFormedStruct")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fileId",value = "填报id",dataType = "String",paramType = "query",example = "1")
    })
    public Result<ModelDataVO> getCompanyFormedStruct(String fileId){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        ModelDataVO result = uploadService.getFormedStruct(user,fileId);
        return new Result(result);
    }


    @ControllerLog(doAction = "数据上报-企业数据上报-保存企业数据上报保存为草稿")
    @PostMapping(path = "/company/saveCompanyFormDataIsDraft")
    @ApiOperation(value = "保存企业数据上报保存为草稿",notes = "返回成功或失败,正常结果为1")
    @RequiresPermissions("/data/company/saveCompanyFormDataIsDraft")
    public Result<Integer> saveCompanyFormDataIsDraft(@RequestBody ModelDataVO data){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        int result = uploadService.saveCompanyFormDataAsDraft(data,user);
        return new Result(result);
    }



    /**企业上报数据统计**/

    @ControllerLog(doAction = "数据上报-企业数据上报统计-数据列表催报")
    @PostMapping(path = "/company/setStatisticsListUrgeCompany")
    @ApiOperation(value = "园区内部数据列表催报",notes = "返回催报结果,正常结果为1")
    @RequiresPermissions("/data/company/setStatisticsListUrgeCompany")
    @ApiImplicitParams({
            @ApiImplicitParam(name="taskBatch",value = "任务批次",dataType = "String",paramType = "query",example = "001",required = true),
            @ApiImplicitParam(name="fillId",value = "填报Id",dataType = "String",paramType = "query",example = "001")
    })
    public Result<Integer> setStatisticsListUrgeCompany(String taskBatch,String fillId){
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        Integer num = uploadService.setStatisticsListUrgeCompany(taskBatch,fillId,user);
        return new Result(num);
    }




    /**园区上报数据统计**/

    @ControllerLog(doAction = "数据上报-园区数据上报统计-园区广告获取")
    @GetMapping(path = "/garden/getAd")
    @ApiOperation(value = "园区广告获取",notes = "返回园区广告获取")
    @RequiresPermissions("/data/garden/getAd")
    public Result<Map<String,Set<String>>> getAd(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result(uploadService.getGardenAd(user));
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-本月数据上报")
    @GetMapping(path = "/garden/getCurrentMonthTasks")
    @ApiOperation(value = "园区本月数据上报",notes = "返回园区本月数据上报任务")
    @RequiresPermissions("/data/garden/getCurrentMonthTasks")
    public Result<List<CompanyDataModel>> getCurrentMonthTasks(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result(uploadService.getCurrentMonthTasks(user));
    }


    @ControllerLog(doAction = "数据上报-园区数据上报-科技园导入接口")
    @PostMapping(path = "/garden/importData")
    @ApiOperation(value = "科技园导入接口",notes = "返回excel文件")
    @RequiresPermissions("/data/garden/importData")
    @ApiImplicitParams({
            @ApiImplicitParam(name="formTime",value = "账期",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="fillId",value = "任务Id",dataType = "String",paramType = "query",example = "001"),
            @ApiImplicitParam(name="modelId",value = "模板Id",dataType = "String",paramType = "query",example = "001")

    })
    public Result importData(@RequestParam("formTime") String formTime,@RequestParam("fillId") String fillId,@RequestParam("modelId") String modelId, @RequestParam("file") MultipartFile file){
        Integer result = uploadService.importData(file,formTime,fillId,modelId);
        return new Result(result);
    }


    @ControllerLog(doAction = "数据上报-园区数据上报-科技园数据查询接口")
    @PostMapping(path = "/garden/getImportData")
    @ApiOperation(value = "科技园模板查询数据接口",notes = "返回数据")
    @RequiresPermissions("/data/garden/getImportData")
    public Result<PaginationData<Map<String,List<ScientModel>>>> getImportData(@RequestBody ScientLookupParamModel paramModel){
        PaginationData<Map<String,List<ScientModel>>> result = uploadService.getImportData(paramModel);
        return new Result(result);
    }

    @ControllerLog(doAction = "数据上报-园区数据上报-科技园查询表头")
    @GetMapping(path = "/garden/getScientTabHeader")
    @ApiOperation(value = "科技园查询表头",notes = "返回数据")
    @RequiresPermissions("/data/garden/getScientTabHeader")
    @ApiImplicitParams({
            @ApiImplicitParam(name="fillId",value = "任务Id",dataType = "String",paramType = "query",example = "001")

    })
    public Result<Map<String,Object>> getScientTabHeader(String fillId){
        Map<String,Object> result = uploadService.getScientTabHeader(fillId);
        return new Result(result);
    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-纵向树形指标导出模式")
    @GetMapping(path = "/garden/getCompanyExcel")
    @ApiOperation(value = "纵向树形指标导出模式",notes = "返回excel文件")
    @RequiresPermissions("/data/garden/getCompanyExcel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="taskbatch",value = "任务批次",dataType = "String",paramType = "query",example = "6745d724836540ff9fc661337c36020a"),
            @ApiImplicitParam(name="modelid",value = "模板ID",dataType = "String",paramType = "query",example = "e12f8f4bd1d94c068917955ed258617b"),

    })
    public void getCompanyExcel(String taskbatch, String modelid, HttpServletRequest req,
                                    HttpServletResponse resp)throws IOException {
        List<CompanyTree> list = targetDao.getExcel(taskbatch,modelid);
        POICompany company = new POICompany();
       company.getTable(list,req,resp);

    }


    @ControllerLog(doAction = "数据上报-园区数据上报统计-指标描述导出模式")
    @GetMapping(path = "/garden/getDescribeExcel")
    @ApiOperation(value = "指标描述导出模式",notes = "返回excel文件")
    @RequiresPermissions("/data/garden/getDescribeExcel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="taskbatch",value = "任务批次",dataType = "String",paramType = "query",example = "6745d724836540ff9fc661337c36020a"),
            @ApiImplicitParam(name="modelid",value = "模板ID",dataType = "String",paramType = "query",example = "e12f8f4bd1d94c068917955ed258617b"),

    })
    public void getDescribeExcel(String taskbatch, String modelid, HttpServletRequest req,
                                HttpServletResponse resp)throws IOException {
        List<CompanyTree> list = targetDao.getExcel(taskbatch,modelid);
        POIDescribe de = new POIDescribe();
        de.getDescribeTable(list,req,resp);

    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-科技园模板")
    @GetMapping(path = "/garden/getScienceExcel")
    @ApiOperation(value = "科技园模板",notes = "返回excel文件")
    @RequiresPermissions("/data/garden/getScienceExcel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="taskbatch",value = "任务批次",dataType = "String",paramType = "query",example = "6745d724836540ff9fc661337c36020a"),
            @ApiImplicitParam(name="modelid",value = "模板ID",dataType = "String",paramType = "query",example = "e12f8f4bd1d94c068917955ed258617b"),

    })
    public void getScienceExcel(String taskbatch, String modelid, HttpServletRequest req,
                                 HttpServletResponse resp)throws IOException {
        List<CompanyTree> list = targetDao.getExcel(taskbatch,modelid);
        POIScience science = new POIScience();
        science.getScienceTable(list,req,resp);

    }

    @ControllerLog(doAction = "数据上报-园区数据上报统计-科技园模板表头")
    @GetMapping(path = "/garden/getScienceHeaderExcel")
    @ApiOperation(value = "科技园模板表头",notes = "返回excel文件")
    @RequiresPermissions("/data/garden/getScienceHeaderExcel")
    @ApiImplicitParams({
            @ApiImplicitParam(name="taskbatch",value = "任务批次",dataType = "String",paramType = "query",example = "6745d724836540ff9fc661337c36020a"),
            @ApiImplicitParam(name="modelid",value = "模板ID",dataType = "String",paramType = "query",example = "e12f8f4bd1d94c068917955ed258617b"),

    })
    public void getScienceHeaderExcel(String taskbatch, String modelid, HttpServletRequest req,
                                HttpServletResponse resp)throws IOException {
        List<CompanyTree> list = targetDao.getExcel(taskbatch,modelid);
        POIScienceHeader header = new POIScienceHeader();
        header.getScienceHeaderTable(list,req,resp);

    }

}
