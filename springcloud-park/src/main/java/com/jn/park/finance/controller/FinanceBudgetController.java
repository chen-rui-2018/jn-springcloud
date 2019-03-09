package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.model.FinanceBudgetHistoryQueryModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.service.FinanceBudgetService;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 14:38
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "预算录入")
@RestController
@RequestMapping("/finance/budget")
public class FinanceBudgetController extends FinanceBaseController {
    @Autowired
    private FinanceBudgetService financeBudgetService;

    @ControllerLog(doAction = "总预算查询")
    @ApiOperation(value = "总预算查询", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/selectTotalBudget")
    @RequiresPermissions("/finance/budget/selectTotalBudget")
    public Result selectTotalBudget( @RequestBody FinanceBudgetQueryModel financeBudgetQueryModel){
        List<FinanceTotalBudgetVo>  financeTotalBudgetVoList=financeBudgetService.selectTotalBudget(financeBudgetQueryModel,getUser().getAccount());
        return new Result(financeTotalBudgetVoList);
    }

    @ControllerLog(doAction = "预算录入历史查询")
    @ApiOperation(value = "预算录入历史查询", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/historyList")
    @RequiresPermissions("/finance/budget/historyList")
    public Result historyList( @RequestBody FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }


    @ControllerLog(doAction = "预算录入")
    @ApiOperation(value = "预算录入", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/add")
    @RequiresPermissions("/finance/budget/add")
    public Result add( @RequestParam("file") CommonsMultipartFile file){
        //todo 处理excel文件

        return new Result();
    }
}
