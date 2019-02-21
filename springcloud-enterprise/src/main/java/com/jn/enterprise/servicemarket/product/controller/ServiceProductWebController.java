package com.jn.enterprise.servicemarket.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.product.dao.ServiceProductDao;
import com.jn.enterprise.servicemarket.product.model.ServiceSelectConstraint;
import com.jn.enterprise.servicemarket.product.model.WebServiceProductDetails;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Web前台服务产品接口
 * @author： chenr
 * @date： Created on 2019/2/20 17:13
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "Web前台服务产品接口")
@RestController
@RequestMapping(value = "/servicemarket/product/web/")
public class ServiceProductWebController  extends BaseController {
    @Autowired
    private ServiceProductService productService;

    @ControllerLog(doAction = "服务超市首页,热门产品")
    @ApiOperation(value ="服务超市首页,热门产品",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/findHotProducts")
    @RequestMapping(value = "/findHotProducts")
    public Result findHotProducts(@RequestBody Page page){
        PaginationData data = productService.findHotProducts(page);
        return new Result(data);
    }
    @ControllerLog(doAction = "服务产品列表")
    @ApiOperation(value ="服务产品列表",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/findHotProducts")
    @RequestMapping(value = "/findProductList")
    public Result findProductList(@RequestBody ServiceSelectConstraint constraint){
        PaginationData data = productService.findWebProductList(constraint);
        return new Result();
    }

    @ControllerLog(doAction = "服务产品详情")
    @ApiOperation(value ="服务产品详情",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/findHotProducts")
    @RequestMapping(value = "/findProductDetails")
    public Result findProductDetails(@ApiParam(name = "productId", value = "服务产品id", required = true) @RequestParam String productId){
        WebServiceProductDetails details = productService.findWebProductDetails(productId);
        return new Result(details);
    }


}
