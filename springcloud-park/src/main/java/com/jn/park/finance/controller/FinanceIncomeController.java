package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.park.finance.service.FinanceIncomeService;
import com.jn.park.finance.vo.FinanceIncomeLastYearContrastVo;
import com.jn.park.finance.vo.FinanceIncomePeriodVo;
import com.jn.park.finance.vo.FinanceIncomeSummarizingProportionVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import com.jn.common.model.Result;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "明细,同期对比", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/periodContrast")
    @RequiresPermissions("/finance/income/periodContrast")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间YYYYMM",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endTime",value = "结束时间YYYYMM",dataType = "String",paramType = "query")
    })
    public Result<FinanceIncomePeriodVo> periodContrast(String startTime,String endTime){
        //todo
        List<FinanceIncomePeriodVo> periodContrast=financeIncomeService.periodContrast(startTime,endTime);
        return new Result(periodContrast);
    }

    @ControllerLog(doAction = "汇总占比")
    @ApiOperation(value = "汇总占比", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/summarizingProportion")
    @RequiresPermissions("/finance/income/summarizingProportion")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间YYYYMM",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endTime",value = "结束时间YYYYMM",dataType = "String",paramType = "query")
    })
    public Result<FinanceIncomeSummarizingProportionVo> summarizingProportion(String startTime,String endTime){
        //todo
        List<FinanceIncomeSummarizingProportionVo> summarizingProportion=financeIncomeService.summarizingProportion(startTime,endTime);
        return new Result(summarizingProportion);
    }

    @ControllerLog(doAction = "往年对比")
    @ApiOperation(value = "往年对比", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/lastYearContrast")
    @RequiresPermissions("/finance/income/lastYearContrast")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startTime",value = "开始时间YYYYMM",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "endTime",value = "结束时间YYYYMM",dataType = "String",paramType = "query")
    })
    public Result<FinanceIncomeLastYearContrastVo> lastYearContrast(String startTime,String endTime){
        //todo
        List<FinanceIncomeLastYearContrastVo> lastYearContrast=financeIncomeService.lastYearContrast(startTime,endTime);
        return new Result(lastYearContrast);
    }

    @ControllerLog(doAction = "导出往年对比数据")
    @ApiOperation(value = "导出往年对比数据", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/exportContrast")
    @RequiresPermissions("/finance/income/exportContrast")
    public Result exportContrast(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }
}
