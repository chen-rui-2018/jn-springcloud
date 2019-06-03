package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.model.ServiceOrg;
import com.jn.enterprise.servicemarket.org.vo.*;
import com.jn.enterprise.servicemarket.org.model.OrgParameter;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.servicemarket.product.model.ProductInquiryInfo;
import com.jn.enterprise.servicemarket.product.model.WebServiceProductInfo;
import com.jn.enterprise.servicemarket.product.service.ServiceProductService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.UserExtensionClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务机构
 * @Author: jiangyl
 * @Date: 2019/2/13 10:43
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务超市-服务机构(前台用户)")
@RestController
@RequestMapping(value = "/guest/serviceMarket/org")
public class OrgController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgController.class);

    @Autowired
    private OrgService orgService;
    @Autowired
    private ServiceProductService productService;
    @Autowired
    private UserExtensionClient userExtensionClient;


    @ControllerLog(doAction = "获取服务机构列表")
    @ApiOperation(value = "获取服务机构列表,(pc/app机构列表)")
    @RequestMapping(value = "/selectServiceOrgList",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceOrg>>> selectServiceOrgList(@Validated OrgParameter orgParameter){
        PaginationData<List<ServiceOrg>> paginationData = orgService.selectServiceOrgList(orgParameter);
        return new Result<>(paginationData);
    }

    @ControllerLog(doAction = "获取服务机构详情")
    @ApiOperation(value = "获取服务机构详情,(pc/app机构详情)", notes = "查询条件orgId")
    @RequestMapping(value = "/getActivityDetailsForManage",method = RequestMethod.GET)
    public Result<OrgDetailVo> getServiceOrgDetail(@ApiParam(name="orgId",value = "服务机构ID",required = true,example = "1a60dafd775941eab2e9be879591f367")
                                                       @RequestParam(value = "orgId")  String orgId){
        Assert.notNull(orgId, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        return new Result<>(orgService.getServiceOrgDetail(orgId));
    }

    @ControllerLog(doAction = "获取服务机构详情+产品列表")
    @ApiOperation(value = "获取服机构信息[机构详情+产品列表](pc/app机构信息)",notes = "查询条件orgId")
    @RequestMapping(value = "/getOrgInfoForManage",method = RequestMethod.GET)
    public Result<OrgDetailAndProductVo> getOrgInfoForManage(@ApiParam(name="orgId",value = "服务机构ID",required = true,example = "1a60dafd775941eab2e9be879591f367")@RequestParam(value = "orgId")  String orgId){
        Assert.notNull(orgId, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        ProductInquiryInfo info = new ProductInquiryInfo();
        info.setOrgId(orgId);
        PaginationData<List<WebServiceProductInfo>> infoList = productService.findWebProductList(info,true);
        OrgDetailVo orgDetailVo = orgService.getServiceOrgDetail(orgId);
        OrgDetailAndProductVo vo = new OrgDetailAndProductVo();
        vo.setOrgDetailVo(orgDetailVo);
        vo.setProductList(infoList);
        return new Result(vo);
    }
    @ControllerLog(doAction = "我的机构")
    @ApiOperation(value = "获取我的服机构信息(app我的机构)",notes = "根据用户账号查询其所属机构信息")
    @RequestMapping(value = "/getMyOrgInfo",method = RequestMethod.GET)
    public Result<MyOrgInfoVo>  getMyOrgInfo(@ApiParam(name="account",value = "用户账号",required = true,example = "wangsong" )@RequestParam(value = "account")  String account){
        Assert.notNull(account, OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        MyOrgInfoVo vo = orgService.getMyOrgInfo(account);
        return new Result<MyOrgInfoVo>(vo);

    }

    @ControllerLog(doAction = "获取服务超市统计数据")
    @ApiOperation(value = "获取服务超市统计数据",notes = "查询机构、顾问、买家、活动、投资人 统计数据")
    @RequestMapping(value = "/selectServiceStatisticalNum",method = RequestMethod.GET)
    public Result<ServiceStatisticalNumVO> selectServiceStatisticalNum(){
        return new Result<>(orgService.selectServiceStatisticalNum());
    }

    @ControllerLog(doAction = "根据业务领域查询服务超市统计数据")
    @ApiOperation(value = "根据业务领域查询服务超市统计数据",notes = "查询机构、顾问、产品、评价、交易量 统计数据。[产品ID和业务领域不能同时为空]")
    @RequestMapping(value = "/selectBusinessAreaStatisticalNum",method = RequestMethod.GET)
    public Result<BusinessStatisticalNumVO> selectBusinessAreaStatisticalNum(BusinessStatisticalParam businessStatisticalParam){
        return new Result<>(orgService.selectBusinessAreaStatisticalNum(businessStatisticalParam));
    }


}
