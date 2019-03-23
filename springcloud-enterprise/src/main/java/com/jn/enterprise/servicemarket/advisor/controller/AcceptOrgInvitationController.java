package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.service.AcceptOrgInvitationService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/2/25 14:19
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "接受机构邀请")
@RestController
@RequestMapping(value = "/serviceMarket/acceptOrgInvitationController")
public class AcceptOrgInvitationController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AcceptOrgInvitationController.class);

    @Autowired
    private AcceptOrgInvitationService acceptOrgInvitationService;

    @ControllerLog(doAction = "接受机构邀请")
    @ApiOperation(value = "接受机构邀请", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/acceptOrgInvitation")
    public Result acceptOrgInvitation(@ApiParam(value = "顾问账号" ,required = true) @RequestParam("advisorAccount") String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        acceptOrgInvitationService.acceptOrgInvitation(advisorAccount);
        return  new Result();
    }

    @ControllerLog(doAction = "拒绝邀请")
    @ApiOperation(value = "拒绝邀请", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/refuseInvitation")
    public Result refuseInvitation(@ApiParam(value = "顾问账号" ,required = true) @RequestParam("advisorAccount")  String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        acceptOrgInvitationService.refuseInvitation(advisorAccount);
        return  new Result();
    }

}
