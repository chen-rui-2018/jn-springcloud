package com.jn.park.policy.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.PolicyCenterExceptionEnum;
import com.jn.park.policy.model.*;
import com.jn.park.policy.service.PolicyCenterService;
import com.jn.park.policy.vo.PolicyDiagramDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangph
 * @Date: 2019/3/27 14:04
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "政策中心-政策中心首页")
@RestController
@RequestMapping(value = "/policy/policyCenterController")
public class PolicyCenterController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PolicyCenterController.class);

    @Autowired
    private PolicyCenterService  policyCenterService;

    @ControllerLog(doAction = "政策级别列表")
    @ApiOperation(value = "政策级别列表",notes = "获取政策中心首页查询条件政策级别")
    @RequiresPermissions("/policy/policyCenterController/getPolicyLevelList")
    @RequestMapping(value = "/getPolicyLevelList",method = RequestMethod.GET)
    public Result<List<PolicyLevelShow>> getPolicyLevelList(){
        List<PolicyLevelShow> levelShowList =policyCenterService.getPolicyLevelList();
        return new Result(levelShowList);
    }

    @ControllerLog(doAction = "政策分类列表")
    @ApiOperation(value = "政策分类列表",notes = "获取政策中心首页查询条件政策类型")
    @RequiresPermissions("/policy/policyCenterController/getPolicyClassList")
    @RequestMapping(value = "/getPolicyClassList",method = RequestMethod.GET)
    public Result<List<PolicyClassShow>> getPolicyClassList(){
        List<PolicyClassShow> classList =policyCenterService.getPolicyClassList();
        return new Result(classList);
    }

    @ControllerLog(doAction = "政策中心首页列表")
    @ApiOperation(value = "政策中心首页列表",notes = "获取政策中心首页列表数据")
    @RequiresPermissions("/policy/policyCenterController/getPolicyCenterList")
    @RequestMapping(value = "/getPolicyCenterList",method = RequestMethod.GET)
    public Result<PaginationData<List<PolicyCenterHomeShow>>> getPolicyCenterList(@Validated PolicyCenterHomeParam policyCenterHomeParam){
        PaginationData policyCenterList = policyCenterService.getPolicyCenterList(policyCenterHomeParam);
        return new Result(policyCenterList);
    }


    @ControllerLog(doAction = "政策指南详情")
    @ApiOperation(value = "政策指南详情",notes = "获取普通政策数据的详情")
    @RequiresPermissions("/policy/policyCenterController/getPolicyDetails")
    @RequestMapping(value = "/getPolicyDetails",method = RequestMethod.GET)
    public Result<PolicyDetailsShow> getPolicyDetails(@ApiParam(value = "政策id",required = true,example="xxx123")
                                    @RequestParam("policyId") String policyId){
        Assert.notNull(policyId, PolicyCenterExceptionEnum.POLICY_ID_NOT_NULL.getMessage());
        PolicyDetailsShow policyDetails = policyCenterService.getPolicyDetails(policyId);
        return new Result(policyDetails);
    }

    @ControllerLog(doAction = "图解政策详情")
    @ApiOperation(value = "图解政策详情",notes = "获取图解政策数据的详情")
    @RequiresPermissions("/policy/policyCenterController/getPolicyDiagramDetails")
    @RequestMapping(value = "/getPolicyDiagramDetails",method = RequestMethod.GET)
    public Result<PolicyDiagramDetailsVo> getPolicyDiagramDetails(@ApiParam(value = "政策id",required = true,example="xxx123")
                                                      @RequestParam("policyId") String policyId){
        Assert.notNull(policyId, PolicyCenterExceptionEnum.POLICY_ID_NOT_NULL.getMessage());
        PolicyDiagramDetailsVo policyDiagramDetailsVo = policyCenterService.getPolicyDiagramDetails(policyId);
        return new Result(policyDiagramDetailsVo);
    }
}
