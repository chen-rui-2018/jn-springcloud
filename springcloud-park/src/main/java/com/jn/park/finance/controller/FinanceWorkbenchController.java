package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.service.FinanceWorkbenchService;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.park.finance.vo.FinanceWorkbenchMonitoringVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
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
@Api(tags = "财务协同-智能工作台")
@RestController
@RequestMapping("/finance/workbench")
public class FinanceWorkbenchController extends BaseController {

    @Autowired
    private FinanceWorkbenchService financeWorkbenchService;

    @ControllerLog(doAction = "财务监控")
    @ApiOperation(value = "财务监控", httpMethod = "POST")
    @PostMapping(value = "/financeMonitoring")
    @RequiresPermissions("/finance/expend/financeMonitoring")
    public Result<FinanceWorkbenchMonitoringVo> financeMonitoring(){
        //todo
        List<FinanceWorkbenchMonitoringVo> financeMonitoring=financeWorkbenchService.financeMonitoring();
        return new Result(financeMonitoring);
    }

    @ControllerLog(doAction = "财务备案")
    @ApiOperation(value = "财务备案", httpMethod = "POST")
    @PostMapping(value = "/records")
    @RequiresPermissions("/finance/expend/records")
    public Result records(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "审批列表")
    @ApiOperation(value = "审批列表", httpMethod = "POST")
    @PostMapping(value = "/approveList")
    @RequiresPermissions("/finance/expend/approveList")
    public Result approveList(){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }
}
