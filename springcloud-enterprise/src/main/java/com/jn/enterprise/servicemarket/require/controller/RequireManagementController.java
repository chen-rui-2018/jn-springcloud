package com.jn.enterprise.servicemarket.require.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.RequireExceptionEnum;
import com.jn.enterprise.servicemarket.require.model.*;
import com.jn.enterprise.servicemarket.require.service.RequireManagementService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/3/4 9:29
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "需求管理（web+手机）")
@RestController
@RequestMapping(value = "/serviceMarket/requireManagementController")
public class RequireManagementController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(RequireManagementController.class);

    @Autowired
    private RequireManagementService requireManagementService;

    @ControllerLog(doAction = "用户提需求(非科技金融)")
    @ApiOperation(value = "用户提需求(非科技金融)", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/userDemand")
    @RequestMapping(value = "/userDemand")
    public Result userDemand(@RequestBody @Validated RequireParam requireParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户提需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        requireManagementService.userDemand(requireParam,user.getAccount());
        return  new Result();
    }

    @ControllerLog(doAction = "用户提需求(科技金融)")
    @ApiOperation(value = "用户提需求(科技金融)", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/userDemandTechnology")
    @RequestMapping(value = "/userDemandTechnology")
    public Result userDemandTechnology(@RequestBody @Validated RequireTechnologyParam requireTechnologyParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户提需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        requireManagementService.userDemandTechnology(requireTechnologyParam,user.getAccount());
        return  new Result();
    }

    @ControllerLog(doAction = "对他人的需求列表查询")
    @ApiOperation(value = "对他人的需求列表查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/getRequireOtherList")
    @RequestMapping(value = "/getRequireOtherList")
    public Result getRequireOtherList(@RequestBody @Validated RequireOtherParam requireOtherParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("对他人的需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        PaginationData requireOtherList = requireManagementService.getRequireOtherList(requireOtherParam, user.getAccount());
        return  new Result(requireOtherList);
    }


    @ControllerLog(doAction = "撤销对他人的需求")
    @ApiOperation(value = "撤销对他人的需求", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/cancelRequire")
    @RequestMapping(value = "/cancelRequire")
    public Result cancelRequire(@ApiParam(value = "需求单号" ,required = true)@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        int responseNum=requireManagementService.cancelRequire(reqNum);
        logger.info("-----数据响应条数：{}-----",responseNum);
        return  new Result();
    }

    @ControllerLog(doAction = "需求详情（对他人需求）")
    @ApiOperation(value = "需求详情（对他人需求）", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/getOtherRequireDetails")
    @RequestMapping(value = "/getOtherRequireDetails")
    public Result getOtherRequireDetails(@ApiParam(value = "需求单号" ,required = true)@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        RequireOtherDetails otherRequireDetails = requireManagementService.getOtherRequireDetails(reqNum);
        return  new Result(otherRequireDetails);
    }

    @ControllerLog(doAction = "我收到的需求列表查询")
    @ApiOperation(value = "我收到的需求列表查询", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/getRequireReceivedList")
    @RequestMapping(value = "/getRequireReceivedList")
    public Result getRequireReceivedList(@RequestBody @Validated RequireReceivedParam requireReceivedParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("我收到的需求列表查询获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        PaginationData requireOtherList = requireManagementService.getRequireReceivedList(requireReceivedParam, user.getAccount());
        return  new Result(requireOtherList);
    }

    @ControllerLog(doAction = "对接操作")
    @ApiOperation(value = "对接操作", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/handleOperating")
    @RequestMapping(value = "/handleOperating")
    public Result handleOperating(@ApiParam(value = "需求单号" ,required = true)@RequestParam("reqNum") String reqNum){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("对接操作获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=requireManagementService.handleOperating(reqNum, user.getAccount(),user.getName());
        logger.info("-----数据响应条数：{}-----",responseNum);
        return  new Result();
    }

    @ControllerLog(doAction = "需求详情（我收到的需求）")
    @ApiOperation(value = "需求详情（我收到的需求）", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/getReceivedRequireDetails")
    @RequestMapping(value = "/getReceivedRequireDetails")
    public Result getReceivedRequireDetails(@ApiParam(value = "需求单号" ,required = true)@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        RequireReceivedDetails requireReceivedDetails = requireManagementService.getReceivedRequireDetails(reqNum);
        return  new Result(requireReceivedDetails);
    }

    @ControllerLog(doAction = "对接需求（我收到的需求）")
    @ApiOperation(value = "对接需求（我收到的需求）", httpMethod = "POST", response = Result.class)
    @RequiresPermissions("/serviceMarket/requireManagementController/handleRequire")
    @RequestMapping(value = "/handleRequire")
    public Result handleRequire(@RequestBody @Validated HandleRequireParam handleRequireParam){
        int responseNum=requireManagementService.handleRequire(handleRequireParam);
        logger.info("-----数据响应条数：{}-----",responseNum);
        return  new Result();
    }
}
