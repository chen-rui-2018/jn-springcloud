package com.jn.enterprise.technologyfinancial.financial.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.FinancialProductExceptionEnum;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @ControllerLog(doAction = "金融产品详情")
    @ApiOperation(value = "金融产品详情", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/financialProductController/getFinancialProductDetails")
    @RequestMapping(value = "/getFinancialProductDetails")
    public Result getFinancialProductDetails(@ApiParam(value = "产品id" ,required = true) @RequestParam("productId") String productId){
        Assert.notNull(productId, FinancialProductExceptionEnum.PRODUCT_ID_NOT_NULL.getMessage());
        FinacialProductDetails finacialProductDetails = financialProductService.getFinancialProductDetails(productId);
        return  new Result(finacialProductDetails);
    }

    @ControllerLog(doAction = "金融产品贷款类别")
    @ApiOperation(value = "金融产品贷款类别", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/financialProductController/getFinancialProductLoanType")
    @RequestMapping(value = "/getFinancialProductLoanType")
    public Result getFinancialProductLoanType(){
        List<FinacialProductLoanType> finacialProductLoanTypeList = financialProductService.getFinancialProductLoanType();
        return  new Result(finacialProductLoanTypeList);
    }

    @ControllerLog(doAction = "金融产品担保方式")
    @ApiOperation(value = "金融产品担保方式", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/financialProductController/getFinancialProductAssureType")
    @RequestMapping(value = "/getFinancialProductAssureType")
    public Result getFinancialProductAssureType(){
        List<FinancialProductAssureType> financialProductAssureTypeList = financialProductService.getFinancialProductAssureType();
        return  new Result(financialProductAssureTypeList);
    }


    @ControllerLog(doAction = "科技金融首页投资人数，金融产品数，金融机构数")
    @ApiOperation(value = "科技金融首页投资人数，金融产品数，金融机构数", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/technologyFinancial/financialProductController/getTechnologyInfoNum")
    @RequestMapping(value = "/getTechnologyInfoNum")
    public Result getTechnologyInfoNum(){
        TechnologyInfoNum technologyInfoNum= financialProductService.getTechnologyInfoNum();
        return  new Result(technologyInfoNum);
    }

}
