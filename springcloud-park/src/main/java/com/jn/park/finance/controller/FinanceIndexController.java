package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.model.FinanceIndexDownTypeModel;
import com.jn.park.finance.service.FinanceIndexService;
import com.jn.park.finance.vo.*;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    @ApiOperation(value = "管委会支出预算占比", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/ratioAndState")
    @RequiresPermissions("/finance/index/ratioAndState")
    @ApiImplicitParam(name = "year",value = "年份",dataType = "String",paramType = "query")
    public Result ratioAndState(String year){
        //todo
        FinanceIndexVo financeIndexVo =financeIndexService.ratioAndState(year);

        return new Result(financeIndexVo);
    }


    @ControllerLog(doAction = "首页-各部门预算支出占比模块")
    @ApiOperation(value = "各部门预算支出占比模块", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/budgetExpendRatio")
    @RequiresPermissions("/finance/index/budgetExpendRatio")
    @ApiImplicitParam(name = "year",value = "年份",dataType = "String",paramType = "query")
    public Result budgetExpendRatio(String year){
        //todo
        List<FinanceIndexBudgetExpendRatioVo> financeIndexBudgetExpendRatioVos=financeIndexService.budgetExpendRatio(year);
        return new Result(financeIndexBudgetExpendRatioVos);
    }

    /** 测试通过 2019/3/14
     */
    @ControllerLog(doAction = "首页-已支出全年预算统计-柱状图")
    @ApiOperation(value = "已支出全年预算统计柱状图", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/expendBudget")
    @RequiresPermissions("/finance/index/expendBudget")
    @ApiImplicitParam(name = "year",value = "年份",dataType = "String",paramType = "query")
    public Result<FinanceIndexExpendBudgetStatisticsVo> expendBudget(String year){
        //todo
        List<FinanceIndexExpendBudgetStatisticsVo> expendBudget=financeIndexService.expendBudget(year);
        return new Result(expendBudget);
    }

    @ControllerLog(doAction = "明细-部门支出预算统计-柱状图")
    @ApiOperation(value = "部门支出预算统计", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/sectionBudgetExpend")
    @RequiresPermissions("/finance/index/sectionBudgetExpend")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "typeId",value = "类型ID",dataType = "int",paramType = "query")
    })
    public Result<FinanceIndexSectionBudgetExpendVo> sectionBudgetExpend(String year, String departmentId, int typeId){
        //todo
        List<FinanceIndexSectionBudgetExpendVo> sectionBudgetExpend=financeIndexService.sectionBudgetExpend(year,departmentId,typeId);
        return new Result(sectionBudgetExpend);
    }

    @ControllerLog(doAction = "明细-各项累计支出占比-饼状图")
    @ApiOperation(value = "各项累计支出占比", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/accumulativeExpendRatio")
    @RequiresPermissions("/finance/index/accumulativeExpendRatio")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query")
    })

    public Result<FinanceIndexExpendBudgetRatioVo> accumulativeExpendRatio(String year,String departmentId){
        //todo
        List<FinanceIndexExpendBudgetRatioVo> accumulativeExpendRatio=financeIndexService.accumulativeExpendRatio(year,departmentId);
        return new Result(accumulativeExpendRatio);
    }

    @ControllerLog(doAction = "部门预算支出报表")
    @ApiOperation(value = "部门预算支出报表", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/sectionExpendForms")
    @RequiresPermissions("/finance/index/sectionExpendForms")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "departmentId",value = "部门ID",dataType = "String",paramType = "query")
    })

    public Result<FinanceIndexSectionExpendFormsVo> sectionExpendForms(String year,String departmentId){
        //todo
        List<FinanceIndexSectionExpendFormsVo> sectionExpendForms=financeIndexService.sectionExpendForms(year,departmentId);
        return new Result(sectionExpendForms);
    }

    @ControllerLog(doAction = "导出")
    @ApiOperation(value = "导出", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/expendFormsExport")
    @RequiresPermissions("/finance/index/expendFormsExport")
    public Result expendFormsExport(HttpServletResponse response){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "明细-分类条件下拉框选项")
    @ApiOperation(value = "分类条件下拉框选项", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/downType")
    @RequiresPermissions("/finance/index/downType")
    public Result<FinanceIndexDownTypeModel> downType(){
        //todo
        List<FinanceIndexDownTypeModel> downType=financeIndexService.downType();
        return new Result(downType);
    }
}
