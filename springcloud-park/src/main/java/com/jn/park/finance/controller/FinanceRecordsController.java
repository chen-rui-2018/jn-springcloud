package com.jn.park.finance.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-财务备案")
@RestController
@RequestMapping("/finance/records")
public class FinanceRecordsController extends BaseController {

    @ControllerLog(doAction = "备案项,需录入项等查询")
    @ApiOperation(value = "备案项,需录入项等查询", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/findDetail")
    @RequiresPermissions("/finance/records/findDetail")
    public Result findDetail( @RequestBody FinanceBudgetQueryModel financeBudgetQueryModel){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "备案查询")
    @ApiOperation(value = "备案查询", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/findAll")
    @RequiresPermissions("/finance/records/findAll")
    public Result findAll( @RequestBody FinanceBudgetQueryModel financeBudgetQueryModel){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "查看")
    @ApiOperation(value = "备案查看查看", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/single")
    @RequiresPermissions("/finance/records/single")
    public Result single( @RequestBody FinanceBudgetQueryModel financeBudgetQueryModel){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "录入")
    @ApiOperation(value = "录入", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/entering")
    @RequiresPermissions("/finance/records/entering")
    public Result entering( @RequestBody FinanceBudgetQueryModel financeBudgetQueryModel){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "财务确认")
    @ApiOperation(value = "财务确认", httpMethod = "POST", response = Result.class)
    @PostMapping(value = "/notarize")
    @RequiresPermissions("/finance/records/notarize")
    public Result notarize( @RequestBody FinanceBudgetQueryModel financeBudgetQueryModel){
        //todo
        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }
}
