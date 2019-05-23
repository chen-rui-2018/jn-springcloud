package com.jn.park.finance.controller;

import com.github.pagehelper.PageHelper;
import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "财务协同-财务事项")
@RestController
@RequestMapping("/finance/matter")
public class FinanceMatterController extends BaseController {

    @ControllerLog(doAction = "事项查询")
    @ApiOperation(value = "事项查询", httpMethod = "POST")
    @PostMapping(value = "/findMatter")
    @RequiresPermissions("/finance/matter/findMatter")
    public Result findMatter(){

        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "发起工单")
    @ApiOperation(value = "发起工单", httpMethod = "POST")
    @PostMapping(value = "/startWork")
    @RequiresPermissions("/finance/matter/startWork")
    public Result startWork(){

        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

    @ControllerLog(doAction = "工单审批")
    @ApiOperation(value = "工单审批", httpMethod = "POST")
    @PostMapping(value = "/workApprove")
    @RequiresPermissions("/finance/matter/workApprove")
    public Result workApprove(){

        return new Result(new PaginationData<FinanceTotalBudgetVo>());
    }

}
