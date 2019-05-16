package com.jn.enterprise.usercenterindex.controller;

import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.org.controller.OrgApproveController;
import com.jn.enterprise.usercenterindex.service.UserCenterIndexService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/userCenter/Index")
public class UserCenterIndexController {
    @Autowired
    private UserCenterIndexService userCenterIndexService;

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(UserCenterIndexController.class);

    protected User getUser(){
        return  (User) SecurityUtils.getSubject().getPrincipal();
    }

    @ControllerLog(doAction = "企业邀请")
    @ApiOperation(value = "企业邀请",notes = "企业邀请小方块", httpMethod = "GET")
    @GetMapping(value = "/findBusinessInvitation")
    @RequiresPermissions("/userCenter/Index/findBusinessInvitation")
    public Result findBusinessInvitation(){

        // TODO: 2019/5/15 前端直接调用接口,不需要在调用后台查询  tangry
        //String  findBusinessInvitation= userCenterIndexService.findBusinessInvitation(getUser());

        return new Result();
    }

    @ControllerLog(doAction = "员工申请")
    @ApiOperation(value = "员工申请",notes = "员工申请小方块", httpMethod = "GET")
    @GetMapping(value = "/findEmployeeRequisition")
    @RequiresPermissions("/userCenter/Index/findEmployeeRequisition")
    public Result findEmployeeRequisition(){
        String  findEmployeeRequisition= userCenterIndexService.findEmployeeRequisition(getUser());
        return new Result(findEmployeeRequisition);
    }

    @ControllerLog(doAction = "机构邀请")
    @ApiOperation(value = "企业邀请",notes = "机构邀请小方块", httpMethod = "GET")
    @GetMapping(value = "/findOrganizationInvitation")
    @RequiresPermissions("/userCenter/Index/findOrganizationInvitation")
    public Result findOrganizationInvitation(){

        // TODO: 2019/5/15 同上面 企业邀请  接口   tangry
        //String  findOrganizationInvitation= userCenterIndexService.findOrganizationInvitation(getUser());

        return new Result();
    }

    @ControllerLog(doAction = "顾问管理")
    @ApiOperation(value = "顾问管理",notes = "顾问管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findAdviserInvitation")
    @RequiresPermissions("/userCenter/Index/findAdviserInvitation")
    public Result findAdviserInvitation(){

        //// TODO: 2019/5/15 沟通怎么查询这个消息. 
        String  findAdviserInvitation= userCenterIndexService.findAdviserInvitation(getUser());

        return new Result(findAdviserInvitation);
    }

    @ControllerLog(doAction = "需求管理")
    @ApiOperation(value = "需求管理",notes = "需求管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findRequirementManage")
    @RequiresPermissions("/userCenter/Index/findRequirementManage")
    public Result findRequirementManage(){

        String  findRequirementManage= userCenterIndexService.findRequirementManage(getUser());

        return new Result(findRequirementManage);
    }

    @ControllerLog(doAction = "评价管理")
    @ApiOperation(value = "评价管理",notes = "评价管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findEvaluateManage")
    @RequiresPermissions("/userCenter/Index/findEvaluateManage")
    public Result findEvaluateManage(){

        String  findEvaluateManage= userCenterIndexService.findEvaluateManage(getUser());

        return new Result(findEvaluateManage);
    }

    @ControllerLog(doAction = "活动管理")
    @ApiOperation(value = "活动管理",notes = "活动管理小方块", httpMethod = "GET")
    @GetMapping(value = "/findActivityManage")
    @RequiresPermissions("/userCenter/Index/findActivityManage")
    public Result findActivityManage(){

        String  findActivityManage= userCenterIndexService.findActivityManage(getUser());

        return new Result(findActivityManage);
    }

    @ControllerLog(doAction = "数据上报")
    @ApiOperation(value = "数据上报",notes = "数据上报小方块", httpMethod = "GET")
    @GetMapping(value = "/findReportedData")
    @RequiresPermissions("/userCenter/Index/findReportedData")
    public Result findReportedData(){

        String  findReportedData= userCenterIndexService.findReportedData(getUser());

        return new Result(findReportedData);
    }

}
