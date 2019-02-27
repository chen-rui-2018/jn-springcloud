package com.jn.enterprise.servicemarket.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.ServiceProductException;
import com.jn.enterprise.servicemarket.product.model.CommonServiceShelf;
import com.jn.enterprise.servicemarket.product.model.ProductInquiryInfo;
import com.jn.enterprise.servicemarket.product.model.ServiceContent;
import com.jn.enterprise.servicemarket.product.model.WebServiceProductDetails;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 前台服务产品接口
 * @author： chenr
 * @date： Created on 2019/2/20 17:13
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "前台服务产品接口")
@RestController
@RequestMapping(value = "/servicemarket/product/web/")
public class ServiceProductWebController  extends BaseController {
    @Autowired
    private ServiceProductService productService;

    @ControllerLog(doAction = "上架常规服务产品")
    @ApiOperation(value = "上架常规服务产品", httpMethod = "POST", response = Result.class)
//    @RequiresPermissions("/servicemarket/product/web/upShelfCommonService")
    @RequestMapping(value = "/upShelfCommonService")
    public Result upShelfCommonService(@RequestBody @Validated CommonServiceShelf commonService){
        Assert.notNull(commonService.getProductId(), ServiceProductException.SERVICE_PRODUCT_NAME_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.upShelfCommonService(commonService,user != null?user.getAccount():"");
        return new Result();
    }

    @ControllerLog(doAction = "添加特色服务产品")
    @ApiOperation(value = "添加特色服务产品", httpMethod = "POST", response = Result.class)
//    @RequiresPermissions("/servicemarket/product/web/addFeatureService")
    @RequestMapping(value = "/addFeatureService")
    public Result addFeatureService(@RequestBody @Validated ServiceContent content){
        Assert.notNull(content, ServiceProductException.SERVICE_PRODUCT_NAME_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.addServiceProduct(content,user != null?user.getAccount():"");
        return new Result();
    }


    @ControllerLog(doAction = "服务超市首页,热门产品")
    @ApiOperation(value ="服务超市首页,热门产品",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/web/findHotProducts")
    @RequestMapping(value = "/findHotProducts")
    public Result findHotProducts(@RequestBody Page page){
        PaginationData data = productService.findHotProducts(page);
        return new Result(data);
    }
    @ControllerLog(doAction = "服务产品列表")
    @ApiOperation(value ="服务产品列表",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/web/findProductList")
    @RequestMapping(value = "/findProductList")
    public Result findProductList(@RequestBody ProductInquiryInfo info){
        PaginationData data = productService.findWebProductList(info,true);
        return new Result(data);
    }

    @ControllerLog(doAction = "服务产品详情")
    @ApiOperation(value ="服务产品详情",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/web/findProductDetails")
    @RequestMapping(value = "/findProductDetails")
    public Result findProductDetails(@ApiParam(name = "productId", value = "服务产品id", required = true) @RequestParam String productId){
        WebServiceProductDetails details = productService.findWebProductDetails(productId);
        return new Result(details);
    }
    @ControllerLog(doAction = "机构-服务产品列表")
    @ApiOperation(value ="机构-服务产品列表",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/web/findOrgProductList")
    @RequestMapping(value = "/findOrgProductList")
    public Result findOrgProductList(@RequestBody  ProductInquiryInfo info){
        Assert.notNull(info.getOrgId(), ServiceProductException.SERVICE_PRODUCT_ORG_ID_EMPTY.getMessage());
        Assert.notNull(info.getProductType(), ServiceProductException.SERVICE_PRODUCT_PRODUCT_TYPE_EMPTY.getMessage());
        PaginationData data =    productService.findOrgProductList(info,true);
                return  new Result(data);
    }
    @ControllerLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于机构上架常规服务产品")
    @ApiOperation(value="服务产品列表,只包含服务Id和服务名称,用于机构上架常规服务产品",httpMethod = "POST",response = Result.class)
    @RequestMapping()
    public Result findShelfProductList(@ApiParam(name = "orgId", value = "机构Id", required = true) @RequestParam String  orgId){
        Assert.notNull(orgId, ServiceProductException.SERVICE_PRODUCT_ORG_ID_EMPTY.getMessage());
        List<CommonServiceShelf> data =    productService.findShelfProductList(orgId);
        return new Result(data);
    }

}
