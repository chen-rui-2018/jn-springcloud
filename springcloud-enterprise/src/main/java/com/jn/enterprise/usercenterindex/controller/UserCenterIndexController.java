package com.jn.enterprise.usercenterindex.controller;

import com.jn.common.model.Result;
import com.jn.enterprise.usercenterindex.service.UserCenterIndexService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: tangry
 * @Date: 2019/5/13
 * @Version 1.0
 */
@Api(tags = "用户中心-首页")
@RestController
@RequestMapping("/usercenter/index")
public class UserCenterIndexController {
    @Autowired
    private UserCenterIndexService userCenterIndexService;

    @ControllerLog(doAction = "企业邀请")
    @ApiOperation(value = "企业邀请",notes = "企业邀请小方块", httpMethod = "GET")
    @GetMapping(value = "/findBusinessInvitation")
    @RequiresPermissions("/usercenter/index/findBusinessInvitation")
    public Result findBusinessInvitation(){
        return new Result();
    }

    @ControllerLog(doAction = "员工申请")
    @ApiOperation(value = "员工申请",notes = "员工申请小方块", httpMethod = "GET")
    @GetMapping(value = "/findEmployeeRequisition")
    @RequiresPermissions("/usercenter/index/findEmployeeRequisition")
    public Result findEmployeeRequisition(){
        return new Result();
    }

    @ControllerLog(doAction = "机构邀请")
    @ApiOperation(value = "企业邀请",notes = "机构邀请小方块", httpMethod = "GET")
    @GetMapping(value = "/findOrganizationInvitation")
    @RequiresPermissions("/usercenter/index/findOrganizationInvitation")
    public Result findOrganizationInvitation(){
        return new Result();
    }

    @ControllerLog(doAction = "顾问管理")
    @ApiOperation(value = "顾问管理",notes = "顾问管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findAdviserInvitation")
    @RequiresPermissions("/usercenter/index/findAdviserInvitation")
    public Result findAdviserInvitation(){
        return new Result();
    }

    @ControllerLog(doAction = "需求管理")
    @ApiOperation(value = "需求管理",notes = "需求管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findRequirementManage")
    @RequiresPermissions("/usercenter/index/findRequirementManage")
    public Result findRequirementManage(){
        return new Result();
    }

    @ControllerLog(doAction = "评价管理")
    @ApiOperation(value = "评价管理",notes = "评价管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findEvaluateManage")
    @RequiresPermissions("/usercenter/index/findEvaluateManage")
    public Result findEvaluateManage(){
        return new Result();
    }

    @ControllerLog(doAction = "活动管理")
    @ApiOperation(value = "活动管理",notes = "活动管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findActivityManage")
    @RequiresPermissions("/usercenter/index/findActivityManage")
    public Result findActivityManage(){
        return new Result();
    }

    @ControllerLog(doAction = "数据上报")
    @ApiOperation(value = "数据上报",notes = "数据上报小方块", httpMethod = "GET")
    @GetMapping(value = "/findReportedData")
    @RequiresPermissions("/usercenter/index/findReportedData")
    public Result findReportedData(){
        return new Result();
    }

}
