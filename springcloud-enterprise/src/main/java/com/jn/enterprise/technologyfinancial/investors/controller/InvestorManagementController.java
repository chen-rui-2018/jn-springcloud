package com.jn.enterprise.technologyfinancial.investors.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListParam;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorManagementListShow;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorManagementService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/21 14:58
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "科技金融管理投资人管理")
@RestController
@RequestMapping(value = "/technologyFinancial/investorManagementController")
public class InvestorManagementController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(InvestorManagementController.class);

    @Autowired
    private InvestorManagementService investorManagementService;

    @ControllerLog(doAction = "投资人管理列表查询")
    @ApiOperation(value = "投资人管理列表查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/investorController/getInvestorManagementList")
    @RequestMapping(value = "/getInvestorManagementList")
    public Result<PaginationData<List<InvestorManagementListShow>>> getInvestorManagementList(@RequestBody @Validated InvestorManagementListParam investorManagementListParam){
        investorManagementService.getInvestorManagementList(investorManagementListParam);
        return  new Result();
    }
}
