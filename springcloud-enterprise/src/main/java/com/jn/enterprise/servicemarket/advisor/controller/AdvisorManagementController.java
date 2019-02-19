package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.InviteAdvisorInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtension;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping(value = "/advisor/advisorManagementController")
public class AdvisorManagementController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementController.class);

    @Autowired
    private UserExtensionClient userExtensionClient;

    @Autowired
    private AdvisorManagementService  advisorManagementService;

    @ControllerLog(doAction = "通过注册账号回显用户信息")
    @ApiOperation(value = "通过注册账号回显用户信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/echoUserInfo")
    public Result echoUserInfo(@ApiParam(value = "注册手机/邮箱" ,required = true) String registerAccount){
        Assert.notNull(registerAccount, AdvisorExceptionEnum.REGISTER_ACCOUNT.getMessage());
        Result<UserExtension> userExtension = userExtensionClient.getUserExtension(registerAccount);
        return  userExtension;
    }


    @ControllerLog(doAction = "邀请顾问")
    @ApiOperation(value = "邀请顾问", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/inviteAdvisor")
    public Result inviteAdvisor(@RequestBody @Validated InviteAdvisorInfo inviteAdvisorInfo){
        advisorManagementService.inviteAdvisor(inviteAdvisorInfo);
        return  new Result();
    }
}

