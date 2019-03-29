package com.jn.enterprise.servicemarket.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 服务产品管理
 * @author： chenr
 * @date： Created on 2019/2/13 11:51
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "(非科技金融)服务产品管理")
@RestController
@RequestMapping(value = "/servicemarket/product/manage/")
public class ServiceProductManageController extends BaseController {

    @Autowired
    private  ServiceProductService productService;


    @ControllerLog(doAction = "添加常规服务产品")
    @ApiOperation(value = "添加常规服务产品",notes = "后台添加(非科技金融)服务产品")
    @RequiresPermissions("/servicemarket/product/addCommonService")
    @RequestMapping(value = "/addCommonService" ,method = RequestMethod.POST)
    public Result addCommonService(@RequestBody @Validated AddCommonProduct product){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //服务产品主键Id
        String productId = UUID.randomUUID().toString().replaceAll("-", "");
        ServiceContent content = new ServiceContent();
        BeanUtils.copyProperties(product,content);
        content.setProductId(productId);
        productService.addServiceProduct(content,user != null?user.getAccount():"",null);
        return new Result();
    }

    @ControllerLog(doAction = "后台按条件查找后台服务产品列表")
    @ApiOperation(value = "查找服务产品列表信息")
    @RequiresPermissions("/servicemarket/product/findServiceList")
    @RequestMapping(value = "/findServiceList",method = RequestMethod.GET)
    public Result<PaginationData< List<ServiceProductManage>>> findServiceList(@Validated  ServiceSelectConstraint constraint){
        PaginationData data =  productService.findServiceList(constraint);
        return new Result(data);
    }


    @ControllerLog(doAction = "服务产品详情查看")
    @ApiOperation(value = "服务产品详情查看")
    @RequiresPermissions("/servicemarket/product/findServiceDetail")
    @RequestMapping(value = "/findServiceDetail",method = RequestMethod.GET)
    public Result<ServiceProductDetail> findServiceDetail(@ApiParam(name = "productId", value = "服务产品id", required = true) @RequestParam String productId){
        Assert.notNull(productId, ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        ServiceProductDetail detail =  productService.findServiceDetail(productId);
        return new Result(detail);
    }
    @ControllerLog(doAction = "特色服务产品审批")
    @ApiOperation(value ="特色服务产品审批")
    @RequiresPermissions("/servicemarket/product/productApproval")
    @RequestMapping(value = "/productApproval",method = RequestMethod.POST)
    public Result productApproval(@RequestBody @Validated  ServiceProductApproval approval){
        Assert.notNull(approval.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.productApproval(approval,user.getAccount());
        return new Result();
    }
    @ControllerLog(doAction = "服务产品上架/下架")
    @ApiOperation(value ="服务产品上架/下架,(前端 App产品上架下架操作)")
    @RequiresPermissions("/servicemarket/product/productShelf")
    @RequestMapping(value = "/productShelf",method = RequestMethod.POST)
    public Result productShelf(@RequestBody @Validated  ProductShelfOperation operation){
        Assert.notNull(operation.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.productShelf(operation,user.getAccount());
        return new Result();
    }
    @ControllerLog(doAction = "特色产品发布")
    @ApiOperation(value ="特色产品发布",notes = "后台展示的特色产品列表")
    @RequiresPermissions("/servicemarket/product/featuredProductRelease")
    @RequestMapping(value = "/featuredProductRelease",method = RequestMethod.GET)
     public Result<PaginationData<List<ServiceProductManage>>> featuredProductRelease( ServiceSelectConstraint constraint){
        PaginationData data =   productService.featuredProductRelease(constraint);
        return new Result(data);

    }
    @ControllerLog(doAction = "编辑修改常规服务产品界面产品详情信息")
    @ApiOperation(value ="编辑修改常规服务产品界面产品详情信息")
    @RequiresPermissions("/servicemarket/product/modifyCommonServiceShow")
    @RequestMapping(value = "/modifyCommonService",method = RequestMethod.GET)
    public Result<UpdateCommonProductShow> modifyCommonServiceShow(@ApiParam(name = "productId", value = "服务产品id", required = true) @RequestParam String productId){
        Assert.notNull(productId, ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        UpdateCommonProductShow show =  productService.modifyCommonServiceShow(productId);

        return new Result(show);
    }
    @ControllerLog(doAction = "编辑修改常规服务产品")
    @ApiOperation(value ="修改常规服务产品",notes = "编辑常规产品时,1、产品类型、业务领域、相关机构和相关顾问是不可编辑项")
    @RequiresPermissions("/servicemarket/product/modifyCommonService")
    @RequestMapping(value = "/modifyCommonService",method = RequestMethod.POST)
    public Result modifyCommonService(@RequestBody @Validated UpdateCommonProduct product){
        Assert.notNull(product.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user =  (User) SecurityUtils.getSubject().getPrincipal();
        ServiceContent content = new ServiceContent();
        BeanUtils.copyProperties(product,content);
        productService.modifyCommonService(content,user.getAccount());
        return new Result();
    }
    @ControllerLog(doAction = "获取产品编号")
    @ApiOperation(value ="获取产品编号(pc+app新增特色产品获取编号)",notes = "新增常规产品/新增特色产品时获取产品编号")
    @RequestMapping(value = "/getProductSerialNumber",method = RequestMethod.GET)
    public Result<String> getProductSerialNumber(@ApiParam(name = "productType", value = "服务产品类型(0:常规-1:特色)", required = true) @RequestParam String productType){
        return new Result(productService.getProductSerialNumber(productType));
    }
}
