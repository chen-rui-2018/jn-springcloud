package com.jn.park.index.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.park.activity.model.ActivitySlimQuery;
import com.jn.park.activity.service.ActivityDetailsService;
import com.jn.park.activity.service.ActivityService;
import com.jn.park.index.enums.IndexDataEnum;
import com.jn.park.index.enums.IndexExceptionEnum;
import com.jn.park.index.model.ImportantNews;
import com.jn.park.index.model.ServiceSearchParam;
import com.jn.park.index.service.IndexService;
import com.jn.park.policy.model.PolicyCenterHomeParam;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.park.policy.service.PolicyGuideService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页
 * @author： huxw
 * @date： Created on 2019-4-16 16:17:08
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "首页")
@RestController
@RequestMapping("/guest/IndexController")
public class IndexController extends BaseController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private PolicyCenterService policyCenterService;

    @Autowired
    private IndexService indexService;

    @ControllerLog(doAction = "推荐-服务搜索")
    @ApiOperation(value = "推荐-服务搜索（APP）", notes = "根据活动名称，政策服务，商务服务名称[模糊搜索]")
    @RequestMapping(value = "/serviceSearch", method = RequestMethod.GET)
    public Result<PaginationData> serviceSearch(@Validated ServiceSearchParam serviceSearchParam){
        // 检索关键字
        String searchFiledStr = serviceSearchParam.getSearchFiled();
        PaginationData paginationData = new PaginationData();

        // 判断搜索类型
        if (serviceSearchParam.getServiceType().equals(IndexDataEnum.SERVICE_TYPE_ACTIVITY.getCode())) {
            ActivitySlimQuery activitySlimQuery = new ActivitySlimQuery();
            BeanUtils.copyProperties(serviceSearchParam, activitySlimQuery);
            activitySlimQuery.setKeyWord(searchFiledStr);
            paginationData = activityService.activityListSlim(activitySlimQuery);
        } else if (serviceSearchParam.getServiceType().equals(IndexDataEnum.SERVICE_TYPE_POLICY.getCode())) {
            PolicyCenterHomeParam policyCenterHomeParam = new PolicyCenterHomeParam();
            BeanUtils.copyProperties(serviceSearchParam, policyCenterHomeParam);
            policyCenterHomeParam.setPolicySearch(searchFiledStr);

            // 如果未传table类型，默认查询政策一览
            String tableTypeCode = StringUtils.isEmpty(serviceSearchParam.getTableType())
                    ? IndexDataEnum.ALL_POLICY.getCode() : serviceSearchParam.getTableType();
            String tableTypeName = "";

            if (tableTypeCode.equals(IndexDataEnum.ALL_POLICY.getCode())) {
                tableTypeName = IndexDataEnum.ALL_POLICY.getMessage();

                // 设置政策类型，不传默认普通政策
                policyCenterHomeParam.setPolicyType(StringUtils.isEmpty(serviceSearchParam.getPolicyType()) ? "0" : serviceSearchParam.getPolicyType());
            } else if (tableTypeCode.equals(IndexDataEnum.DIAGRAM_POLICY.getCode())) {
                tableTypeName = IndexDataEnum.DIAGRAM_POLICY.getMessage();
            } else if (tableTypeCode.equals(IndexDataEnum.FIRST_TOPIC.getCode())) {
                tableTypeName = IndexDataEnum.FIRST_TOPIC.getMessage();
            } else if (tableTypeCode.equals(IndexDataEnum.PRIVATE_TOPIC.getCode())) {
                tableTypeName = IndexDataEnum.PRIVATE_TOPIC.getMessage();
            } else {
                throw new JnSpringCloudException(IndexExceptionEnum.POLICY_TYPE_NOT_VALID);
            }

            policyCenterHomeParam.setTableType(tableTypeName);
            paginationData = policyCenterService.getPolicyCenterList(policyCenterHomeParam);
        }  else {
            throw new JnSpringCloudException(IndexExceptionEnum.PARAM_IS_NULL);
        }

        return new Result<>(paginationData);
    }

    @ControllerLog(doAction = "门户首页-重要消息弹框")
    @ApiOperation(value = "门户首页-重要消息弹框", notes = "获取重要消息列表")
    @RequestMapping(value = "/getImportantNewsList",method = RequestMethod.GET)
    public Result<List<ImportantNews>> getImportantNewsList() {
        return new Result(indexService.getImportantNewsList());
    }

    @ControllerLog(doAction = "推荐-行政审批")
    @ApiOperation(value = "推荐-行政审批（APP）", notes = "获取行政审批列表")
    @RequestMapping(value = "/getAdministrativeApprovalList",method = RequestMethod.GET)
    public Result getAdministrativeApprovalList() {
        // TODO 调行政审批列表接口
        return new Result();
    }

    @ControllerLog(doAction = "推荐-行政审批详情")
    @ApiOperation(value = "推荐-行政审批详情（APP）", notes = "获取行政审批详情")
    @RequestMapping(value = "/getAdministrativeApprovalDetails",method = RequestMethod.GET)
    public Result getAdministrativeApprovalDetails(@ApiParam(value ="行政审批ID", required = true, example = "")
                                                       @NotBlank(message = "行政审批ID不能为空")
                                                       @RequestParam(value = "approvalId") String approvalId) {
        // TODO 调行政审批详情接口
        return new Result();
    }

    @ControllerLog(doAction = "人才申报")
    @ApiOperation(value = "人才申报（PC/APP）", notes = "获取人才申报列表")
    @RequestMapping(value = "/getPersonnelDeclareList",method = RequestMethod.GET)
    public Result getPersonnelDeclareList() {
        // TODO 调人才申报列表接口
        return new Result();
    }

    @ControllerLog(doAction = "人才申报详情")
    @ApiOperation(value = "人才申报详情（PC/APP）", notes = "获取人才申报详情")
    @RequestMapping(value = "/getPersonnelDeclareDetails",method = RequestMethod.GET)
    public Result getPersonnelDeclareDetails(@ApiParam(value ="人才申报ID", required = true, example = "")
                                                 @NotBlank(message = "人才申报ID不能为空")
                                                 @RequestParam(value = "perDeclareId") String perDeclareId) {
        // TODO 调人才申报列表接口
        return new Result();
    }



    // 招商模块
    @ControllerLog(doAction = "招商搜索")
    @ApiOperation(value = "招商搜索（APP）", notes = "根据关键字搜索相关招商信息[模糊搜索]")
    @RequestMapping(value = "/investmentSearch", method = RequestMethod.GET)
    public Result investmentSearch(){
        // TODO 调用招商列表接口
        return new Result();
    }

    @ControllerLog(doAction = "招商-图片轮播")
    @ApiOperation(value = "招商-图片轮播（APP）", notes = "获取首页招商页面的轮播图")
    @RequestMapping(value = "/getInvestmentBannerPics", method = RequestMethod.GET)
    public Result getInvestmentBannerPics(){
        // TODO 调用招商轮播图接口
        return new Result();
    }

    @ControllerLog(doAction = "招商动态")
    @ApiOperation(value = "招商动态（PC/APP）", notes = "获取招商动态列表")
    @RequestMapping(value = "/getInvestmentDynamicList", method = RequestMethod.GET)
    public Result getInvestmentDynamicList(){
        // TODO 调用招商动态列表接口
        return new Result();
    }

    @ControllerLog(doAction = "招商政策")
    @ApiOperation(value = "招商政策（PC/APP）", notes = "获取招商政策列表")
    @RequestMapping(value = "/getInvestmentPolicyList", method = RequestMethod.GET)
    public Result getInvestmentPolicyList(){
        // TODO 调用招商政策列表接口
        return new Result();
    }

    @ControllerLog(doAction = "一区多园")
    @ApiOperation(value = "一区多园（PC/APP）", notes = "获取数据列表")
    @RequestMapping(value = "/getOneToManyGarden", method = RequestMethod.GET)
    public Result getOneToManyGarden(){
        // TODO 调用一区多园接口（展示多区）
        return new Result();
    }



    // 资讯模块
    @ControllerLog(doAction = "资讯列表")
    @ApiOperation(value = "资讯列表（PC/APP）", notes = "获取资讯列表数据")
    @RequestMapping(value = "/getNewsList", method = RequestMethod.GET)
    public Result getInformationList(){
        // TODO 调用资讯列表接口
        return new Result();
    }

    @ControllerLog(doAction = "资讯详情")
    @ApiOperation(value = "资讯详情", notes = "获取资讯详情数据")
    @RequestMapping(value = "/getNewsDetails", method = RequestMethod.GET)
    public Result  getInformationDetails(@ApiParam(value ="资讯ID", required = true)
                                         @NotBlank(message = "资讯ID不能为空")
                                         @RequestParam(value = "newsId") String newsId) {
        // TODO 调用资讯详情接口
        return new Result();
    }

}
