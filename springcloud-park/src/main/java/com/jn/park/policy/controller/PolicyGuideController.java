package com.jn.park.policy.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.enums.PolicyInfoExceptionEnum;
import com.jn.park.policy.model.PolicyInfoEditParam;
import com.jn.park.policy.model.PolicyInfoShow;
import com.jn.park.policy.model.PolicyManagementParam;
import com.jn.park.policy.model.PolicyManagementShow;
import com.jn.park.policy.service.PolicyGuideService;
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

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/29 10:22
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "政策中心-政策指南")
@RestController
@RequestMapping(value = "/policy/policyGuideController")
public class PolicyGuideController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PolicyGuideController.class);

    @Autowired
    private PolicyGuideService policyGuideService;

    @ControllerLog(doAction = "政策管理")
    @ApiOperation(value = "政策管理",notes = "获取政策管理列表数据")
    @RequiresPermissions("/policy/policyCenterController/getPolicyManagementList")
    @RequestMapping(value = "/getPolicyManagementList",method = RequestMethod.GET)
    public Result<PaginationData<List<PolicyManagementShow>>> getPolicyManagementList(@Validated PolicyManagementParam policyManagementParam){
        PaginationData policyManagementList = policyGuideService.getPolicyManagementList(policyManagementParam);
        return new Result(policyManagementList);
    }

    @ControllerLog(doAction = "政策管理编辑（新增/修改）")
    @ApiOperation(value = "政策管理编辑（新增/修改）",notes = "返回数据为响应条数，正常值为1")
    @RequiresPermissions("/policy/policyCenterController/saveOrUpdatePolicyInfo")
    @RequestMapping(value = "/saveOrUpdatePolicyInfo",method = RequestMethod.POST)
    public Result<Integer> saveOrUpdatePolicyInfo(@RequestBody @Validated PolicyInfoEditParam policyManagementParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if(user==null || user.getAccount()==null){
            logger.warn("政策管理编辑（新增/修改）获取登录用户失败");
            return new Result(PolicyInfoExceptionEnum.NETWORK_ANOMALY.getCode(),PolicyInfoExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        int responseNum=policyGuideService.saveOrUpdatePolicyInfo(policyManagementParam,user.getAccount());
        logger.info("---------政策管理编辑（新增/修改）成功，响应数据条数：{}---------",responseNum);
        return new Result(responseNum);
    }

    @ControllerLog(doAction = "关联图解政策信息/关联政策原文信息")
    @ApiOperation(value = "关联图解政策信息/关联政策原文信息",notes = "获取系统中有效的图解政策/政策原文")
    @RequiresPermissions("/policy/policyCenterController/getPolicyInfo")
    @RequestMapping(value = "/getPolicyInfo",method = RequestMethod.GET)
    public Result<List<PolicyInfoShow>> getPolicyInfo(@ApiParam(value="政策类型（0：普通政策/政策原文  1：图解政策）",required = true,example = "1")
                                                          @Pattern(regexp = "^[01]$", message = "{policyType:'默认值只允许为0,1'}")
                                                          @RequestParam("policyType") String policyType){
        List<PolicyInfoShow> policyInfoShowList =policyGuideService.getPolicyInfo(policyType);
        return new Result(policyInfoShowList);
    }

}
