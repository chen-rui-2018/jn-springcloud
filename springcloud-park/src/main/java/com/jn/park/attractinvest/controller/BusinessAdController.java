package com.jn.park.attractinvest.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.attractinvest.model.BusinessAdContent;
import com.jn.park.attractinvest.model.BusinessAdDynamic;
import com.jn.park.attractinvest.model.BusinessAdPage;
import com.jn.park.attractinvest.model.BusinessAdPolicy;
import com.jn.park.attractinvest.service.BusinessAdService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 招商信息管理控制层
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:26
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "招商管理(门户匿名)")
@RestController
@RequestMapping("/guest/portal/businessAd")
public class BusinessAdController extends BaseController {

    @Autowired
    private BusinessAdService businessAdService;

    @ControllerLog(doAction = "获取招商信息")
    @ApiOperation(value = "获取招商信息", notes = "条件分页获取招商广告信息")
    @RequestMapping(value = "/getBusinessAdContent", method = RequestMethod.GET)
    public Result<PaginationData<List<BusinessAdContent>>> getBusinessAdContent(BusinessAdPage page) {
        PaginationData<List<BusinessAdContent>> data = businessAdService.getBusinessAdContent(page);
        return new Result(data);
    }

    @ControllerLog(doAction = "获取招商动态信息")
    @ApiOperation(value = "获取招商动态信息", notes = "获取招商动态信息")
    @RequestMapping(value = "/getBusinessAdDynamic", method = RequestMethod.GET)
    public Result<List<BusinessAdDynamic>> getBusinessAdDynamic() {
        List<BusinessAdDynamic> data = businessAdService.getBusinessAdDynamic();
        return new Result(data);
    }

    @ControllerLog(doAction = "获取招商政策信息")
    @ApiOperation(value = "获取招商政策信息", notes = "获取招商政策信息")
    @RequestMapping(value = "/getBusinessAdPolicy", method = RequestMethod.GET)
    public Result<List<BusinessAdPolicy>> getBusinessAdPolicy() {
        List<BusinessAdPolicy> data = businessAdService.getBusinessAdPolicy();
        return new Result(data);
    }

    @ControllerLog(doAction = "获取招商信息详情")
    @ApiOperation(value = "获取招商信息详情", notes = "根据招商id获取招商信息详情")
    @RequestMapping(value = "/getBusinessAdContentInfo", method = RequestMethod.GET)
    public Result<BusinessAdContent> getBusinessAdContentInfo(@RequestParam("id") String id) {
        BusinessAdContent businessAdContent = businessAdService.getBusinessAdContentInfo(id);
        return new Result(businessAdContent);
    }

    @ControllerLog(doAction = "获取招商动态信息详情")
    @ApiOperation(value = "获取招商动态信息详情", notes = "根据招商动态id获取招商动态信息详情")
    @RequestMapping(value = "/getBusinessAdDynamicInfo", method = RequestMethod.GET)
    public Result<BusinessAdDynamic> getBusinessAdDynamicInfo(@RequestParam("id") String id) {
        BusinessAdDynamic businessAdDynamic = businessAdService.getBusinessAdDynamicInfo(id);
        return new Result(businessAdDynamic);
    }

    @ControllerLog(doAction = "获取招商政策信息详情")
    @ApiOperation(value = "获取招商政策信息详情", notes = "根据招商政策id获取招商政策信息详情")
    @RequestMapping(value = "/getBusinessAdPolicyInfo", method = RequestMethod.GET)
    public Result<BusinessAdPolicy> getBusinessAdPolicyInfo(@RequestParam("id") String id) {
        BusinessAdPolicy businessAdPolicy = businessAdService.getBusinessAdPolicyInfo(id);
        return new Result(businessAdPolicy);
    }


}
