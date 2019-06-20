package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.model.FinanceIndexDownTypeModel;
import com.jn.park.finance.model.FinanceIndexSectionExpendFormsModel;
import com.jn.park.finance.service.FinanceIndexService;
import com.jn.park.finance.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-监控首页")
@RestController
@RequestMapping("/finance/index")
public class FinanceIndexController extends BaseController {

    @Autowired
    private FinanceIndexService financeIndexService;



    /** 测试通过 2019/3/14
     */
    @ControllerLog(doAction = "首页-管委会支出预算占比")
    @ApiOperation(value = "管委会支出预算占比",notes = "管委会支出预算占比", httpMethod = "GET")
    @GetMapping(value = "/ratioAndState")
    @RequiresPermissions("/finance/index/ratioAndState")
    @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019")
    public Result<FinanceIndexVo> ratioAndState(String year){

        FinanceIndexVo financeIndexVo =financeIndexService.ratioAndState(year);

        return new Result(financeIndexVo);
    }


    @ControllerLog(doAction = "首页-各部门预算支出占比模块")
    @ApiOperation(value = "各部门预算支出占比模块",notes = "各部门预算支出占比模块", httpMethod = "GET")
    @GetMapping(value = "/budgetExpendRatio")
    @RequiresPermissions("/finance/index/budgetExpendRatio")
    @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019")
    public Result<FinanceIndexBudgetExpendRatioVo> budgetExpendRatio(String year){

        List<FinanceIndexBudgetExpendRatioVo> financeIndexBudgetExpendRatioVos=financeIndexService.budgetExpendRatio(year);
        return new Result(financeIndexBudgetExpendRatioVos);
    }

    /** 测试通过 2019/3/14
     */
    @ControllerLog(doAction = "首页-已支出全年预算统计-柱状图")
    @ApiOperation(value = "已支出全年预算统计柱状图",notes = "已支出全年预算统计-柱状图", httpMethod = "GET")
    @GetMapping(value = "/expendBudget")
    @RequiresPermissions("/finance/index/expendBudget")
    @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019")
    public Result<FianceDynamicTableVo<List<FinanceIndexExpendBudgetStatisticsVo>>> expendBudget(String year){

        FianceDynamicTableVo<List<FinanceIndexExpendBudgetStatisticsVo>> expendBudget=financeIndexService.expendBudget(year);
        return new Result(expendBudget);
    }

    @ControllerLog(doAction = "明细-部门支出预算统计-柱状图")
    @ApiOperation(value = "部门支出预算统计",notes = "部门支出预算统计", httpMethod = "GET")
    @GetMapping(value = "/sectionBudgetExpend")
    @RequiresPermissions("/finance/index/sectionBudgetExpend")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "281f4005-0363-4528-92a3-60a730532e53"),
            @ApiImplicitParam(name = "typeId",value = "类型ID",dataType = "String",paramType = "query")
    })
    public Result<FianceDynamicTableVo<List<FinanceIndexSectionBudgetExpendVo>>> sectionBudgetExpend(String year, String departmentId, String typeId){

        FianceDynamicTableVo<List<FinanceIndexSectionBudgetExpendVo>> sectionBudgetExpend=financeIndexService.sectionBudgetExpend(year,departmentId,typeId);
        return new Result(sectionBudgetExpend);
    }

    @ControllerLog(doAction = "明细-各项累计支出占比-饼状图")
    @ApiOperation(value = "各项累计支出占比",notes = "各项累计支出占比-饼状图", httpMethod = "GET")
    @GetMapping(value = "/accumulativeExpendRatio")
    @RequiresPermissions("/finance/index/accumulativeExpendRatio")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "281f4005-0363-4528-92a3-60a730532e53")
    })

    public Result<FinanceIndexExpendBudgetRatioVo> accumulativeExpendRatio(String year,String departmentId){

        List<FinanceIndexExpendBudgetRatioVo> accumulativeExpendRatio=financeIndexService.accumulativeExpendRatio(year,departmentId);
        return new Result(accumulativeExpendRatio);
    }

    @ControllerLog(doAction = "部门预算支出报表")
    @ApiOperation(value = "部门预算支出报表",notes = "部门预算支出报表", httpMethod = "GET")
    @GetMapping(value = "/sectionExpendForms")
    @RequiresPermissions("/finance/index/sectionExpendForms")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "281f4005-0363-4528-92a3-60a730532e53")
    })

    public Result<FianceDynamicTableVo<List<FinanceIndexSectionExpendFormsVo>>> sectionExpendForms(String year,String departmentId){

        FianceDynamicTableVo<List<FinanceIndexSectionExpendFormsVo>> sectionExpendForms=financeIndexService.sectionExpendForms(year,departmentId);
        return new Result(sectionExpendForms);
    }

    @ControllerLog(doAction = "导出")
    @ApiOperation(value = "导出", httpMethod = "GET")
    @GetMapping(value = "/expendFormsExport")
    @RequiresPermissions("/finance/index/expendFormsExport")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query",example = "281f4005-0363-4528-92a3-60a730532e53")
    })
    public void expendFormsExport(HttpServletResponse response,String year,String departmentId){

        List<FinanceIndexExpendFormsExportVo> sectionExpendForms=financeIndexService.expendFormsExport(year,departmentId);

        String exportTitle = "分类,1月支出,1月预算,2月支出,2月预算,3月支出,3月预算," +
                "4月支出,4月预算,5月支出,5月预算,6月支出,6月预算,7月支出,7月预算,8月支出," +
                "8月预算,9月支出,9月预算,10月支出,10月预算,11月支出,11月预算,12月支出,12月预算";

        String exportColName = "costTypeName,cost1,budgetNumber1,cost2,budgetNumber2,cost3,budgetNumber3," +
                "cost4,budgetNumber4,cost5,budgetNumber5,cost6,budgetNumber6,cost7,budgetNumber7,cost8,budgetNumber8," +
                "cost9,budgetNumber9,cost10,budgetNumber10,cost11,budgetNumber11,cost12,budgetNumber12,";

        String fileName = year+"年预算支出报表";
        String sheetName = year+"年预算支出报表";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, sectionExpendForms);

    }

    @ControllerLog(doAction = "明细-分类条件下拉框选项")
    @ApiOperation(value = "分类条件下拉框选项",notes = "分类条件下拉框选项", httpMethod = "GET")
    @GetMapping(value = "/downType")
    @RequiresPermissions("/finance/index/downType")
    public Result<FinanceIndexDownTypeModel> downType(){

        List<FinanceIndexDownTypeModel> downType=financeIndexService.downType();
        return new Result(downType);
    }



}
