package com.jn.enterprise.servicemarket.product.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.ServiceProductExceptionEnum;
import com.jn.enterprise.servicemarket.product.model.*;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.enterprise.servicemarket.product.vo.ProductListAndCountVO;
import com.jn.enterprise.servicemarket.product.vo.WebServiceProductDetails;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 前台服务产品接口
 * @author： chenr
 * @date： Created on 2019/2/20 17:13
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "(非科技金融)前台服务产品接口")
@RestController
@RequestMapping(value = "/servicemarket/product/web/")
public class ServiceProductWebController  extends BaseController {
    @Autowired
    private ServiceProductService productService;

    @ControllerLog(doAction = "上架常规服务产品")
    @ApiOperation(value = "上架常规服务产品(非科技金融),(app常规产品新增)")
    @RequiresPermissions("/servicemarket/product/web/upShelfCommonService")
    @RequestMapping(value = "/upShelfCommonService",method = RequestMethod.POST)
    public Result upShelfCommonService(@RequestBody @Validated CommonServiceShelf commonService){
        Assert.notNull(commonService.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        //服务产品主键Id
        String productId = UUID.randomUUID().toString().replaceAll("-", "");
        commonService.setProductId(productId);
        productService.upShelfCommonService(commonService,user != null?user.getAccount():"");
        return new Result();
    }

    @ControllerLog(doAction = "添加特色服务产品")
    @ApiOperation(value = "添加特色服务产品(非科技金融)(App特色产品新增)")
    @RequiresPermissions("/servicemarket/product/web/addFeatureService")
    @RequestMapping(value = "/addFeatureService",method = RequestMethod.POST)
    public Result addFeatureService(@RequestBody @Validated ServiceContent content){
        Assert.notNull(content, ServiceProductExceptionEnum.SERVICE_PRODUCT_NAME_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        String productId = UUID.randomUUID().toString().replaceAll("-","");
        productService.addServiceProduct(content,user != null?user.getAccount():"",productId);
        return new Result();
    }


    @ControllerLog(doAction = "服务超市首页,热门产品")
    @ApiOperation(value ="服务超市首页,热门产品")
    @RequestMapping(value = "/findHotProducts",method = RequestMethod.GET)
    public Result<PaginationData<List<HotProducts>>> findHotProducts(Page page){
        PaginationData data = productService.findHotProducts(page);
        return new Result(data);
    }
    @ControllerLog(doAction = "服务产品列表")
    @ApiOperation(value ="服务产品列表(app共用)")
    @RequestMapping(value = "/findProductList",method = RequestMethod.GET)
    public Result<PaginationData<List<WebServiceProductInfo>>> findProductList(ProductInquiryInfo info){
        PaginationData data = productService.findWebProductList(info,true);
        return new Result(data);
    }

    @ControllerLog(doAction = "服务产品详情")
    @ApiOperation(value ="服务产品详情(非科技金融,app服务此产品详情)")
    @RequestMapping(value = "/findProductDetails",method = RequestMethod.GET)
    public Result<WebServiceProductDetails> findProductDetails(@ApiParam(name = "productId", value = "服务产品id", required = true) @RequestParam String productId){
        WebServiceProductDetails details = productService.findWebProductDetails(productId);
        return new Result(details);
    }
    @ControllerLog(doAction = "机构-服务产品列表")
    @ApiOperation(value ="机构-服务产品列表,(app-产品管理)")
    @RequiresPermissions("/servicemarket/product/web/findOrgProductList")
    @RequestMapping(value = "/findOrgProductList",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceProductManage>>> findOrgProductList(ProductInquiryInfo info){
        Assert.notNull(info.getOrgId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY.getMessage());
        Assert.notNull(info.getProductType(), ServiceProductExceptionEnum.SERVICE_PRODUCT_PRODUCT_TYPE_EMPTY.getMessage());
        PaginationData data =    productService.findOrgProductList(info,true);
                return  new Result(data);
    }
    @ControllerLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于机构上架常规服务产品,")
    @ApiOperation(value="服务产品列表,只包含服务Id和服务名称,用于机构上架常规服务产品(App上架常规产品)")
    @RequiresPermissions("/servicemarket/product/web/findShelfProductList")
    @RequestMapping(value = "/findShelfProductList",method = RequestMethod.GET)
    public Result< List<CommonServiceShelf>> findShelfProductList(@ApiParam(name = "orgId", value = "机构Id", required = true) @RequestParam String  orgId){
        Assert.notNull(orgId, ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY.getMessage());
        List<CommonServiceShelf> data =    productService.findShelfProductList(orgId);
        return new Result(data);
    }
    @ControllerLog(doAction = "服务产品信息,上架常规服务产品时展示")
    @ApiOperation(value="服务产品信息,上架常规服务产品时展示(App产品详情)")
    @RequiresPermissions("/servicemarket/product/web/findShelfProductInfo")
    @RequestMapping(value = "/findShelfProductInfo",method = RequestMethod.GET)
    public Result<WebServiceProductInfo> findShelfProductInfo(@ApiParam(name = "productId", value = "产品id", required = true) @RequestParam String  productId){
        Assert.notNull(productId, ServiceProductExceptionEnum.SERVICE_PRODUCT_ORG_ID_EMPTY.getMessage());
        WebServiceProductInfo data =    productService.findShelfProductInfo(productId);
        return new Result(data);
    }
    @ControllerLog(doAction = "服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件")
    @ApiOperation(value="服务产品列表,只包含服务Id和服务名称,用于评价的筛选条件")
    @RequestMapping(value = "/productQueryList",method = RequestMethod.GET)
    public Result<List<CommonServiceShelf>> productQueryList(String productName){
        List<CommonServiceShelf> data =    productService.productQueryList(productName);
        return new Result(data);
    }

    @ControllerLog(doAction = "机构-编辑常规产品")
    @ApiOperation(value="机构-编辑常规产品(App编辑常规服务产品")
    @RequiresPermissions("/servicemarket/product/web/updateCommonProduct")
    @RequestMapping(value = "/updateCommonProduct",method = RequestMethod.POST)
    public Result updateCommonProduct(@RequestBody  CommonServiceShelf product){
        Assert.notNull(product.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.updateCommonProduct(product,user.getAccount());
        return new Result();
    }
    @ControllerLog(doAction = "机构-编辑特色产品")
    @ApiOperation(value="机构-编辑特色产品,(App编辑特色服务产品)")
    @RequiresPermissions("/servicemarket/product/web/updateFeatureProduct")
    @RequestMapping(value = "/updateFeatureProduct",method = RequestMethod.POST)
    public Result updateFeatureProduct(@RequestBody @Validated ServiceContent content){
        Assert.notNull(content.getProductId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ID_EMPTY.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        productService.updateFeatureProduct(content,user.getAccount());
        return new Result();
    }
    @ControllerLog(doAction = "顾问-服务产品列表")
    @ApiOperation(value="顾问-服务产品列表")
    @RequiresPermissions("/servicemarket/product/web/advisorProductList")
    @RequestMapping(value = "/advisorProductList",method = RequestMethod.GET)
    public Result<PaginationData< List<AdvisorProductInfo>>> advisorProductList(@Validated AdvisorProductQuery query){
        Assert.notNull(query.getAdvisorAccount(), ServiceProductExceptionEnum.SERVICE_PRODUCT_ADVISOR_ACCOUNT_EMPTY.getMessage());
        PaginationData data =   productService.advisorProductList(query,true);

        return new Result(data);
    }
    @ControllerLog(doAction = "同类型服务产品列表")
    @ApiOperation(value ="同类型服务产品列表(App服务产品详情下的同类型服务列表)")
    @RequestMapping(value = "/sameTypeProductList",method = RequestMethod.GET)
    public Result<PaginationData<List<WebServiceProductInfo>>> sameTypeProductList(ProductInquiryInfo info){
        Assert.notNull(info.getSignoryId(), ServiceProductExceptionEnum.SERVICE_PRODUCT_SIGNORY_ID_EMPTY.getMessage());
        PaginationData data = productService.findWebProductList(info,true);
        return new Result(data);
    }
    @ControllerLog(doAction = "首次进入产品列表界面,统计信息加产品列表信息")
    @ApiOperation(value ="首次进入产品列表界面,统计信息加产品列表信息,(app产品列表))")
    @RequestMapping(value = "/productListAndStatistics",method = RequestMethod.GET)
    public Result<ProductListAndCountVO> productListAndStatistics(ProductInquiryInfo info){
        PaginationData data = productService.findWebProductList(info,true);
        ServiceStatistics serviceStatistics =productService.findServiceStatistics();
        ProductListAndCountVO vo = new ProductListAndCountVO();
        vo.setProductInfos(data);
        vo.setServiceStatistics(serviceStatistics);
        return new Result(vo);
    }
}
