package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementQuery;
import com.jn.enterprise.servicemarket.advisor.model.ApprovalQuery;
import com.jn.enterprise.servicemarket.advisor.model.InviteAdvisorInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顾问管理
 * @Author: yangph
 * @Date: 2019/2/19 9:40
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "顾问管理")
@RestController
@RequestMapping(value = "/serviceMarket/advisorManagementController")
public class AdvisorManagementController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementController.class);

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private AdvisorManagementService  advisorManagementService;

    @Autowired
    private AdvisorService advisorService;

    @ControllerLog(doAction = "通过注册账号回显用户信息")
    @RequiresPermissions("/advisor/advisorManagementController/echoUserInfo")
    @ApiOperation(value = "通过注册账号回显用户信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/echoUserInfo")
    public Result echoUserInfo(@ApiParam(value = "注册手机/邮箱" ,required = true) String registerAccount){
        Assert.notNull(registerAccount, AdvisorExceptionEnum.REGISTER_ACCOUNT.getMessage());
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(registerAccount);
        return  userExtension;
    }


    @ControllerLog(doAction = "邀请顾问")
    @RequiresPermissions("/advisor/advisorManagementController/inviteAdvisor")
    @ApiOperation(value = "邀请顾问", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/inviteAdvisor")
    public Result inviteAdvisor(@RequestBody @Validated InviteAdvisorInfo inviteAdvisorInfo){
        advisorManagementService.inviteAdvisor(inviteAdvisorInfo);
        return  new Result();
    }

    @ControllerLog(doAction = "顾问管理")
    @RequiresPermissions("/advisor/advisorManagementController/getAdvisorManagementInfo")
    @ApiOperation(value = "顾问管理", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getAdvisorManagementInfo")
    public Result getAdvisorManagementInfo(@RequestBody @Validated AdvisorManagementQuery advisorManagementQuery){
        Assert.notNull(advisorManagementQuery.getApprovalStatus(), AdvisorExceptionEnum.APPROVAL_STATUS_NOT_NULL.getMessage());
        PaginationData advisorManagementInfo = advisorManagementService.getAdvisorManagementInfo(advisorManagementQuery);
        return  new Result(advisorManagementInfo);
    }

    @ControllerLog(doAction = "审批顾问填写信息")
    @RequiresPermissions("/advisor/advisorManagementController/approvalAdvisorInfo")
    @ApiOperation(value = "审批顾问填写信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/approvalAdvisorInfo")
    public Result approvalAdvisorInfo(@RequestBody @Validated ApprovalQuery approvalQuery){
        advisorManagementService.approvalAdvisorInfo(approvalQuery);
        return  new Result();
    }

    @ControllerLog(doAction = "用户中心顾问详情")
    @RequiresPermissions("/advisor/advisorManagementController/advisorDetails")
    @ApiOperation(value = "用户中心顾问详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/advisorDetails")
    public Result advisorDetails(@ApiParam(value = "顾问账号" ,required = true) @RequestBody  String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount);
        return  new Result(advisorDetailsVo);
    }
}

