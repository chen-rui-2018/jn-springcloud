package com.jn.enterprise.technologyfinancial.financial.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.technologyfinancial.financial.product.model.FinancialProductListParam;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
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

/**
 * @Author: yangph
 * @Date: 2019/3/18 19:33
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "金融产品")
@RestController
@RequestMapping(value = "/technologyFinancial/financialProductController")
public class FinancialProductController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(FinancialProductController.class);

    @Autowired
    private FinancialProductService financialProductService;

    @ControllerLog(doAction = "金融产品列表查询")
    @ApiOperation(value = "金融产品列表查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/financialProductController/getFinancialProductList")
    @RequestMapping(value = "/getInvestorInfoList")
    public Result getFinancialProductList(@RequestBody @Validated FinancialProductListParam financialProductListParam){
        PaginationData investorInfoList = financialProductService.getFinancialProductList(financialProductListParam);
        return  new Result(investorInfoList);
    }
}
