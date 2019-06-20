package com.jn.enterprise.technologyfinancial.financial.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.FinancialProductExceptionEnum;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.model.CommonProductShelf;
import com.jn.enterprise.servicemarket.product.model.CommonServiceShelf;
import com.jn.enterprise.technologyfinancial.financial.product.model.*;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @Author: yangph
 * @Date: 2019/3/18 19:33
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "科技金融-金融产品")
@RestController
public class FinancialProductController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(FinancialProductController.class);

    @Autowired
    private FinancialProductService financialProductService;

    @ControllerLog(doAction = "金融产品列表查询")
    @ApiOperation(value = "金融产品列表查询")
    @RequestMapping(value = "/guest/technologyFinancial/financialProductController/getFinancialProductList",method = RequestMethod.GET)
    public Result<PaginationData<List<FinancialProductListInfo>>> getFinancialProductList(@Validated FinancialProductListParam financialProductListParam){
        PaginationData investorInfoList = financialProductService.getFinancialProductList(financialProductListParam);
        return  new Result(investorInfoList);
    }
    @ControllerLog(doAction = "机构下金融产品列表查询")
    @ApiOperation(value = "机构下金融产品列表查询")
    @RequestMapping(value = "/guest/technologyFinancial/financialProductController/getOrgFinancialProductList",method = RequestMethod.GET)
    public Result<PaginationData<List<FinancialProductListInfo>>> getOrgFinancialProductList(@Validated FinancialOrgProductParam financialOrgProductParam){
        PaginationData investorInfoList = financialProductService.getOrgFinancialProductList(financialOrgProductParam);
        return  new Result(investorInfoList);
    }


    @ControllerLog(doAction = "金融产品详情")
    @ApiOperation(value = "金融产品详情")
    @RequestMapping(value = "/guest/technologyFinancial/financialProductController/getFinancialProductDetails",method = RequestMethod.GET)
    public Result<FinancialProductDetails> getFinancialProductDetails(@ApiParam(value = "产品id" ,required = true,example = "1234") @RequestParam("productId") String productId){
        Assert.notNull(productId, FinancialProductExceptionEnum.PRODUCT_ID_NOT_NULL.getMessage());
        FinancialProductDetails financialProductDetails = financialProductService.getFinancialProductDetails(productId);
        return  new Result(financialProductDetails);
    }

    @ControllerLog(doAction = "金融产品贷款类别")
    @ApiOperation(value = "金融产品贷款类别")
    @RequestMapping(value = "/guest/technologyFinancial/financialProductController/getFinancialProductLoanType",method = RequestMethod.GET)
    public Result<List<FinancialProductLoanType>> getFinancialProductLoanType(){
        List<FinancialProductLoanType> financialProductLoanTypeList = financialProductService.getFinancialProductLoanType();
        return  new Result(financialProductLoanTypeList);
    }

    @ControllerLog(doAction = "金融产品担保方式")
    @ApiOperation(value = "金融产品担保方式")
    @RequestMapping(value = "/guest/technologyFinancial/financialProductController/getFinancialProductAssureType",method = RequestMethod.GET)
    public Result<List<FinancialProductAssureType>> getFinancialProductAssureType(){
        List<FinancialProductAssureType> financialProductAssureTypeList = financialProductService.getFinancialProductAssureType();
        return  new Result(financialProductAssureTypeList);
    }


    @ControllerLog(doAction = "科技金融首页投资人数，金融产品数，金融机构数")
    @ApiOperation(value = "科技金融首页投资人数，金融产品数，金融机构数")
    @RequestMapping(value = "/guest/technologyFinancial/financialProductController/getTechnologyInfoNum",method = RequestMethod.GET)
    public Result<TechnologyInfoNum> getTechnologyInfoNum(){
        TechnologyInfoNum technologyInfoNum= financialProductService.getTechnologyInfoNum();
        return  new Result(technologyInfoNum);
    }
    @ControllerLog(doAction = "后台常规金融产品添加")
    @ApiOperation(value = "后台常规金融产品添加")
    @RequiresPermissions("/technologyFinancial/financialProductController/addFinancialProduct")
    @RequestMapping(value = "/technologyFinancial/financialProductController/addFinancialProduct",method = RequestMethod.POST)
    public Result addFinancialProduct(@RequestBody @Validated FinancialProductCommonAdd commonProduct){
        User user =(User) SecurityUtils.getSubject().getPrincipal();
        String productId = UUID.randomUUID().toString().replaceAll("-","");
        FinancialProductAddInfo info  = new FinancialProductAddInfo();
        BeanUtils.copyProperties(commonProduct,info);
        info.setProductId(productId);
        financialProductService.addFinancialProduct(info,user != null?user.getAccount():"");
        return  new Result();
    }
    @ControllerLog(doAction = "科技金融上架常规服务产品")
    @ApiOperation(value = "科技金融上架常规服务产品")
    @RequiresPermissions("/technologyFinancial/financialProductController/upShelfCommonProduct")
    @RequestMapping(value = "/technologyFinancial/financialProductController/upShelfCommonProduct",method = RequestMethod.POST)
    public Result upShelfCommonProduct(@RequestBody @Validated CommonProductShelf commonService ){
        Assert.notNull(commonService.getTemplateId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_TEMPLE_ID_EMPTY.getMessage());
//        Assert.notNull(commonService.getOrgId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //服务产品主键Id
        //String productId = UUID.randomUUID().toString().replaceAll("-", "");
        CommonServiceShelf serviceShelf = new CommonServiceShelf();
        BeanUtils.copyProperties(commonService,serviceShelf);
        serviceShelf.setProductId("");
        financialProductService.upShelfCommonProduct(serviceShelf,user != null?user.getAccount():"");
        return new Result();
    }
    @ControllerLog(doAction = "科技金融上架特色服务产品")
    @ApiOperation(value = "科技金融上架特色服务产品)")
    @RequiresPermissions("/technologyFinancial/financialProductController/upShelfFeatureProduct")
    @RequestMapping(value = "/technologyFinancial/financialProductController/upShelfFeatureProduct",method = RequestMethod.POST)
    public Result upShelfFeatureProduct(@RequestBody @Validated  FinancialProductFeatureAdd featureProduct){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //服务产品主键Id
        //String productId = UUID.randomUUID().toString().replaceAll("-", "");
        FinancialProductAddInfo info = new FinancialProductAddInfo();
        BeanUtils.copyProperties(featureProduct,info);
        info.setProductId("");
        financialProductService.upShelfFeatureProduct(info,user != null?user.getAccount():"");
        return new Result();
    }
    @ControllerLog(doAction = "科技金融编辑服务产品")
    @ApiOperation(value = "科技金融编辑服务产品)")
    @RequiresPermissions("/technologyFinancial/financialProductController/modifyFeatureProduct")
    @RequestMapping(value = "/technologyFinancial/financialProductController/modifyFeatureProduct",method = RequestMethod.POST)
    public Result modifyFeatureProduct(@RequestBody @Validated  FinancialProductModifyParam product){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int i=  financialProductService.modifyFeatureProduct(product,user != null?user.getAccount():"");
        return new Result(i);
    }

}
