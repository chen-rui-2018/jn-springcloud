package com.jn.enterprise.common.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pd.declaration.service.DeclarationNoticeService;
import com.jn.enterprise.technologyfinancial.financial.product.service.FinancialProductService;
import com.jn.enterprise.technologyfinancial.investors.service.InvestorService;
import com.jn.park.activity.model.ActivitySlim;
import com.jn.park.activity.model.ActivitySlimQuery;
import com.jn.park.api.ActivityClient;
import com.jn.park.api.PolicyCenterClient;
import com.jn.park.api.SpPowerPortalClient;
import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.model.PolicyCenterHomeShow;
import com.jn.park.spPower.model.SpAdModel;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-4-16 09:31:34
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业服务首页")
@RestController
@RequestMapping("/guest/EnterpriseIndexController")
public class EnterpriseIndexController extends BaseController {

    // 申报中心
    @Autowired
    private DeclarationNoticeService declarationNoticeService;

    // 科技金融-金融产品
    @Autowired
    private FinancialProductService financialProductService;

    // 科技金融-投资人
    @Autowired
    private InvestorService investorService;

    // 政策中心
    @Autowired
    private PolicyCenterClient policyCenterClient;

    // 活动中心
    @Autowired
    private ActivityClient activityClient;

    // 行政审批
    @Autowired
    private SpPowerPortalClient spPowerPortalClient;


//    @ControllerLog(doAction = "申报中心")
//    @ApiOperation(value = "申报中心", notes = "申报中心公告列表")
//    @RequestMapping(value = "/getDeclarationCenterList" ,method = RequestMethod.GET)
//    public Result<List<TbPdDeclarationNoticeManage>> list(@ApiParam(value = "所属类型",example = "白下高新区") @RequestParam String rangeName,
//                                                          @ApiParam(value = "排序（1：发布时间排序，2：时间节点排序，3：热度排序）",required = true,example = "1") @RequestParam String sortType) {
//        List<TbPdDeclarationNoticeManage> data = declarationNoticeService.selectByDeclarationNoticeList(rangeName,sortType);
//        return new Result(data);
//    }

    @ControllerLog(doAction = "政策中心")
    @ApiOperation(value = "政策中心", notes = "政策中心首页列表")
    @RequestMapping(value = "/getPolicyCenterList" ,method = RequestMethod.GET)
    public Result<PaginationData<List<PolicyCenterHomeShow>>> getPolicyCenterList(@Validated PolicyCenterHomeParam policyCenterHomeParam) {
        return policyCenterClient.getPolicyList(policyCenterHomeParam);
    }

    @ControllerLog(doAction = "活动中心")
    @ApiOperation(value = "活动中心", notes = "活动中心列表")
    @RequestMapping(value = "/getActivityList" ,method = RequestMethod.POST)
    public Result<PaginationData<List<ActivitySlim>>> getActivityList(@Validated ActivitySlimQuery activitySlimQuery) {
        return activityClient.getActivityList(activitySlimQuery);
    }

    @ControllerLog(doAction = "行政审批")
    @ApiOperation(value = "行政审批", notes = "获取行政审批广告轮播图")
    @RequestMapping(value = "/getAdvertising" ,method = RequestMethod.GET)
    public Result<List<SpAdModel>> getAdvertising() {
        return spPowerPortalClient.getAdvertising();
    }

//    @ControllerLog(doAction = "科技金融-金融产品")
//    @ApiOperation(value = "科技金融-金融产品", notes = "金融产品列表查询")
//    @RequestMapping(value = "/getFinancialProductList",method = RequestMethod.GET)
//    public Result<PaginationData<List<FinancialProductListInfo>>> getFinancialProductList(@Validated FinancialProductListParam financialProductListParam){
//        PaginationData investorInfoList = financialProductService.getFinancialProductList(financialProductListParam);
//        return  new Result(investorInfoList);
//    }
//
//    @ControllerLog(doAction = "科技金融-投资人")
//    @ApiOperation(value = "科技金融-投资人", notes = "投资人列表查询")
//    @RequestMapping(value = "/getInvestorInfoList",method = RequestMethod.GET)
//    public Result<PaginationData<List<InvestorInfoListShow>>> getInvestorInfoList(@Validated InvestorInfoListParam investorInfoListParam){
//        PaginationData investorInfoList = investorService.getInvestorInfoList(investorInfoListParam);
//        return  new Result(investorInfoList);
//    }
//
//    @ControllerLog(doAction = "企业招聘版块")
//    @ApiOperation(value = "企业招聘版块", notes = "获取企业招聘版块图片")
//    @RequestMapping(value = "/getCompanyRecruitPic",method = RequestMethod.GET)
//    public Result<String> getCompanyRecruitPic(){
//        // TODO 企业招聘版块图片返回
//        return  new Result();
//    }
//
//    @ControllerLog(doAction = "人力资源版块")
//    @ApiOperation(value = "人力资源版块", notes = "获取人力资源版块图片")
//    @RequestMapping(value = "/getHumanResourcesPic",method = RequestMethod.GET)
//    public Result<String> getHumanResourcesPic(){
//        // TODO 人力资源版块图片返回
//        return  new Result();
//    }
}
