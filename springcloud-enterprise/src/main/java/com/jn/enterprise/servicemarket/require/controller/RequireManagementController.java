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
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/4 9:29
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务超市-需求管理")
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
    @ApiOperation(value = "用户提需求(非科技金融)(pc/app新增需求)",notes = "返回数据响应条数，正常情况为1")
    @RequiresPermissions("/serviceMarket/requireManagementController/userDemand")
    @RequestMapping(value = "/userDemand",method = RequestMethod.POST)
    public Result<Integer> userDemand(@RequestBody @Validated RequireParam requireParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户提需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum = requireManagementService.userDemand(requireParam, user.getAccount());
        logger.info("-----数据响应条数:{}----",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "用户提需求(科技金融)")
    @ApiOperation(value = "用户提需求(科技金融)",notes = "返回数据响应条数，正常情况为1")
    @RequiresPermissions("/serviceMarket/requireManagementController/userDemandTechnology")
    @RequestMapping(value = "/userDemandTechnology",method = RequestMethod.POST)
    public Result<Integer> userDemandTechnology(@RequestBody @Validated RequireTechnologyParam requireTechnologyParam){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("用户提需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum = requireManagementService.userDemandTechnology(requireTechnologyParam, user.getAccount());
        logger.info("-----数据响应条数:{}----",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "对他人的需求列表查询")
    @ApiOperation(value = "对他人的需求列表查询")
    @RequiresPermissions("/serviceMarket/requireManagementController/getRequireOtherList")
    @RequestMapping(value = "/getRequireOtherList,(pc/app需求管理)",method = RequestMethod.GET)
    public Result<PaginationData<List<RequireInfoList>>> getRequireOtherList(@Validated RequireOtherParam requireOtherParam){
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
    @ApiOperation(value = "撤销对他人的需求 (app 需求撤销)",notes = "返回数据响应条数，正常情况为1")
    @RequiresPermissions("/serviceMarket/requireManagementController/cancelRequire")
    @RequestMapping(value = "/cancelRequire",method = RequestMethod.POST)
    public Result<Integer> cancelRequire(@ApiParam(value = "需求单号" ,required = true,example = "123****")@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("对他人的需求获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=requireManagementService.cancelRequire(reqNum,user.getAccount());
        logger.info("-----数据响应条数：{}-----",responseNum);
        return  new Result(reqNum);
    }

    @ControllerLog(doAction = "需求详情（对他人需求）")
    @ApiOperation(value = "需求详情（对他人需求）,(pc/App需求详情)")
    @RequiresPermissions("/serviceMarket/requireManagementController/getOtherRequireDetails")
    @RequestMapping(value = "/getOtherRequireDetails",method = RequestMethod.GET)
    public Result<RequireOtherDetails> getOtherRequireDetails(@ApiParam(value = "需求单号" ,required = true,example = "123****")@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        RequireOtherDetails otherRequireDetails = requireManagementService.getOtherRequireDetails(reqNum);
        return  new Result(otherRequireDetails);
    }

    @ControllerLog(doAction = "我收到的需求列表查询")
    @ApiOperation(value = "我收到的需求列表查询 (pc/app 需求管理(机构/顾问))")
    @RequiresPermissions("/serviceMarket/requireManagementController/getRequireReceivedList")
    @RequestMapping(value = "/getRequireReceivedList",method = RequestMethod.GET)
    public Result<PaginationData<List<RequireInfoList>>> getRequireReceivedList(@Validated RequireReceivedParam requireReceivedParam){
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
    @ApiOperation(value = "对接操作",notes = "返回数据响应条数，正常情况为1")
    @RequiresPermissions("/serviceMarket/requireManagementController/handleOperating")
    @RequestMapping(value = "/handleOperating",method = RequestMethod.POST)
    public Result<Integer> handleOperating(@ApiParam(value = "需求单号" ,required = true,example = "123****")@RequestParam("reqNum") String reqNum){
        //获取当前登录用户基本信息
        User user = (User)SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("对接操作获取当前登录用户信息失败");
            return new Result(RequireExceptionEnum.NETWORK_ANOMALY.getCode(),RequireExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=requireManagementService.handleOperating(reqNum, user.getAccount(),user.getName());
        logger.info("-----数据响应条数：{}-----",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "需求详情（我收到的需求）")
    @ApiOperation(value = "需求详情（我收到的需求）(pc/app维护对接)")
    @RequiresPermissions("/serviceMarket/requireManagementController/getReceivedRequireDetails")
    @RequestMapping(value = "/getReceivedRequireDetails",method = RequestMethod.GET)
    public Result<RequireReceivedDetails> getReceivedRequireDetails(@ApiParam(value = "需求单号" ,required = true,example = "123****")@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        RequireReceivedDetails requireReceivedDetails = requireManagementService.getReceivedRequireDetails(reqNum);
        return  new Result(requireReceivedDetails);
    }

    @ControllerLog(doAction = "对接需求（我收到的需求）")
    @ApiOperation(value = "对接需求（我收到的需求）",notes = "返回数据响应条数，正常情况为1")
    @RequiresPermissions("/serviceMarket/requireManagementController/handleRequire")
    @RequestMapping(value = "/handleRequire",method = RequestMethod.POST)
    public Result<Integer> handleRequire(@RequestBody @Validated HandleRequireParam handleRequireParam){
        int responseNum=requireManagementService.handleRequire(handleRequireParam);
        logger.info("-----数据响应条数：{}-----",responseNum);
        return  new Result(responseNum);
    }


    @ControllerLog(doAction = "需求管理列表查询（后台门户管理）")
    @ApiOperation(value = "需求管理列表查询（后台门户管理）")
    @RequiresPermissions("/serviceMarket/requireManagementController/getPortalRequireInfoList")
    @RequestMapping(value = "/getPortalRequireInfoList",method = RequestMethod.GET)
    public Result<PaginationData< List<RequirePortalInfoList>>> getPortalRequireInfoList(@Validated RequirePortalParam requirePortalParam){
        PaginationData requireOtherList = requireManagementService.getPortalRequireInfoList(requirePortalParam);
        return  new Result(requireOtherList);
    }

    @ControllerLog(doAction = "需求详情（后台门户管理）")
    @ApiOperation(value = "需求详情（后台门户管理）")
    @RequiresPermissions("/serviceMarket/requireManagementController/getPortalRequireDetails")
    @RequestMapping(value = "/getPortalRequireDetails",method = RequestMethod.GET)
    public Result<RequirePortalDetails> getPortalRequireDetails(@ApiParam(value = "需求编号" ,required = true,example = "20190801*****")@RequestParam("reqNum") String reqNum){
        Assert.notNull(reqNum, RequireExceptionEnum.REQUIRE_NUM_NOT_NULL.getMessage());
        RequirePortalDetails requirePortalDetails = requireManagementService.getPortalRequireDetails(reqNum);
        return  new Result(requirePortalDetails);
    }

}
