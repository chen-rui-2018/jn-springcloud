package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.util.StringUtils;
import com.jn.common.util.excel.ExcelUtil;
import com.jn.park.finance.enums.FinanceBudgetExceptionEnums;
import com.jn.park.finance.service.FinanceIncomeService;
import com.jn.park.finance.vo.*;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import com.jn.common.model.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "财务协同-收入情况")
@RestController
@RequestMapping("/finance/income")
public class FinanceIncomeController extends BaseController {

    @Autowired
    private FinanceIncomeService financeIncomeService;

    @ControllerLog(doAction = "明细,同期对比")
    @ApiOperation(value = "明细,同期对比",notes = "同期对比",httpMethod = "GET")
    @GetMapping(value = "/periodContrast")
    @RequiresPermissions("/finance/income/periodContrast")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间YYYYMM",dataType = "String",paramType = "query",example = "201901"),
            @ApiImplicitParam(name = "endTime",value = "结束时间YYYYMM",dataType = "String",paramType = "query",example = "201912")
    })
    public Result<FianceDynamicTableVo<List<FinanceIncomePeriodVo>>> periodContrast(String startTime,String endTime){
        //todo
        this.checkIsSomeYear(startTime,endTime);
        FianceDynamicTableVo<List<FinanceIncomePeriodVo>> periodContrast=financeIncomeService.periodContrast(startTime,endTime);
        return new Result(periodContrast);
    }

    @ControllerLog(doAction = "汇总占比")
    @ApiOperation(value = "汇总占比",notes = "汇总占比", httpMethod = "GET")
    @GetMapping(value = "/summarizingProportion")
    @RequiresPermissions("/finance/income/summarizingProportion")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间YYYYMM",dataType = "String",paramType = "query",example = "201901"),
            @ApiImplicitParam(name = "endTime",value = "结束时间YYYYMM",dataType = "String",paramType = "query",example = "201912")
    })
    public Result<FinanceIncomeSummarizingProportionVo> summarizingProportion(String startTime,String endTime){
        //todo
        this.checkIsSomeYear(startTime,endTime);
        List<FinanceIncomeSummarizingProportionVo> summarizingProportion=financeIncomeService.summarizingProportion(startTime,endTime);
        return new Result(summarizingProportion);
    }

    @ControllerLog(doAction = "往年对比")
    @ApiOperation(value = "往年对比", notes = "往年对比",httpMethod = "GET")
    @GetMapping(value = "/lastYearContrast")
    @RequiresPermissions("/finance/income/lastYearContrast")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间YYYYMM",dataType = "String",paramType = "query",example = "201901"),
            @ApiImplicitParam(name = "endTime",value = "结束时间YYYYMM",dataType = "String",paramType = "query",example = "201912")
    })
    public Result<FianceDynamicTableVo<List<FinanceIncomeLastYearContrastVo>>> lastYearContrast(String startTime,String endTime){
        //todo
        this.checkIsSomeYear(startTime,endTime);
        FianceDynamicTableVo<List<FinanceIncomeLastYearContrastVo>> lastYearContrast=financeIncomeService.lastYearContrast(startTime,endTime);
        return new Result(lastYearContrast);
    }

    @ControllerLog(doAction = "导出往年对比数据")
    @ApiOperation(value = "导出往年对比数据", httpMethod = "GET")
    @GetMapping(value = "/exportContrast")
    @RequiresPermissions("/finance/income/exportContrast")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "year",value = "年份YYYY",dataType = "String",paramType = "query",example = "2019"),
    })
    public Result exportContrast(HttpServletResponse response, String year){
        //todo
        List<FinanceIncomeExportContrastVo> sectionExpendForms=financeIncomeService.exportContrast(year);

        String exportTitle = "分类,去年1月收入,今年1月收入,去年2月收入,今年2月收入,去年3月收入,今年3月收入," +
                "去年4月收入,今年4月收入,去年5月收入,今年5月收入,去年6月收入,今年6月收入,去年7月收入,今年7月收入,去年8月收入," +
                "今年8月收入,去年9月收入,今年9月收入,去年10月收入,今年10月收入,去年11月收入,今年11月收入,去年12月收入,今年12月收入";

        String exportColName = "incomeTypeName,lastYearIncome1,income1,lastYearIncome2,income2,lastYearIncome3,income3," +
                "lastYearIncome4,income4,lastYearIncome5,income5,lastYearIncome5,income6,lastYearIncome7,income7,lastYearIncome7,income8," +
                "lastYearIncome9,income9,lastYearIncome10,income10,lastYearIncome11,income11,lastYearIncome12,income12,";

        String fileName = year+"年-往年对比数据";
        String sheetName = year+"年-往年对比数据";
        ExcelUtil.writeExcelWithCol(response, fileName, sheetName, exportTitle, exportColName, sectionExpendForms);
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }


    /**
     * 校验开始结束日期是否为同一年
     * @param startMonth
     * @param endMonth
     */
    private void checkIsSomeYear(String startMonth,String endMonth){
        if(StringUtils.isBlank(startMonth)||startMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"开始月份格式必须是YYYYMM");
        }
        if(null!=endMonth&&endMonth.length()!=6){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"结束月份格式必须是YYYYMM");
        }
        if((startMonth.compareTo(endMonth))>0){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"结束月份必须大于等于开始月份");
        }
        if(!startMonth.substring(0,4).equals(endMonth.substring(0,4))){
            throw new JnSpringCloudException(FinanceBudgetExceptionEnums.UN_KNOW,"只能查同一年的数据");
        }
    }
}
