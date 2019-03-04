package com.jn.enterprise.servicemarket.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.model.ServiceContent;
import com.jn.enterprise.servicemarket.product.model.ServiceProductApproval;
import com.jn.enterprise.servicemarket.product.model.ServiceProductDetail;
import com.jn.enterprise.servicemarket.product.model.ServiceSelectConstraint;
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

import java.util.UUID;

/**
 * 服务产品管理
 * @author： chenr
 * @date： Created on 2019/2/13 11:51
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "服务产品管理")
@RestController
@RequestMapping(value = "/servicemarket/product/manage/")
public class ServiceProductManageController extends BaseController {
    @Autowired
    private  ServiceProductService productService;


    @ControllerLog(doAction = "添加常规服务产品")
    @ApiOperation(value = "添加常规服务产品", httpMethod = "POST", response = Result.class)
//    @RequiresPermissions("/servicemarket/product/addCommonService")
    @RequestMapping(value = "/addCommonService")
    public Result addCommonService(@RequestBody @Validated ServiceContent content){
        Assert.notNull(content, ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //服务产品主键Id
        String productId = UUID.randomUUID().toString().replaceAll("-", "");
        content.setProductId(productId);
        productService.addServiceProduct(content,user != null?user.getAccount():"",null);
        return new Result();
    }
    @ControllerLog(doAction = "按条件查找后台服务产品列表")
    @ApiOperation(value = "查找服务产品列表信息", httpMethod = "POST", response = Result.class)
//    @RequiresPermissions("/servicemarket/product/findServiceList")
    @RequestMapping(value = "/findServiceList")
    public Result findServiceList(@RequestBody  ServiceSelectConstraint constraint){
        PaginationData data =  productService.findServiceList(constraint);
        return new Result(data);
    }


    @ControllerLog(doAction = "服务产品详情查看")
    @ApiOperation(value = "服务产品详情查看", httpMethod = "POST", response = Result.class)
//    @RequiresPermissions("/servicemarket/product/findServiceDetail")
    @RequestMapping(value = "/findServiceDetail")
    public Result findServiceDetail(@ApiParam(name = "productId", value = "服务产品id", required = true) @RequestParam String productId){
        Assert.notNull(productId, ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        ServiceProductDetail detail =  productService.findServiceDetail(productId);
        return new Result(detail);
    }
    @ControllerLog(doAction = "特色服务产品审批")
    @ApiOperation(value ="特色服务产品审批",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/productApproval")
    @RequestMapping(value = "/productApproval")
    public Result productApproval(@RequestBody @Validated  ServiceProductApproval approval){
        Assert.notNull(approval.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.productApproval(approval,user.getAccount());
    return new Result();
    }
    @ControllerLog(doAction = "服务产品上架/下架")
    @ApiOperation(value ="服务产品上架/下架",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/productShelf")
    @RequestMapping(value = "/productShelf")
    public Result productShelf(@RequestBody @Validated  ServiceProductApproval approval){
        Assert.notNull(approval.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.productShelf(approval,user.getAccount());
        return new Result();
    }
    @ControllerLog(doAction = "特色产品发布")
    @ApiOperation(value ="特色产品发布",httpMethod = "POST",response = Result.class)
//    @RequiresPermissions("/servicemarket/product/featuredProductRelease")
    @RequestMapping(value = "/featuredProductRelease")
     public Result featuredProductRelease(@RequestBody  ServiceSelectConstraint constraint){
        PaginationData data =   productService.featuredProductRelease(constraint);
        return new Result(data);

    }
    @ControllerLog(doAction = "编辑修改常规服务产品")
    @ApiOperation(value ="修改常规服务产品",httpMethod = "POST",response = Result.class,notes = "编辑常规产品时,1、产品类型、业务领域、相关机构和相关顾问是不可编辑项")
//    @RequiresPermissions("/servicemarket/product/modifyCommonService")
    @RequestMapping(value = "/modifyCommonService")
    public Result modifyCommonService(@RequestBody @Validated ServiceContent content){
        Assert.notNull(content.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user =  (User) SecurityUtils.getSubject().getPrincipal();
        productService.modifyCommonService(content,user.getAccount());
        return new Result();
    }

}
