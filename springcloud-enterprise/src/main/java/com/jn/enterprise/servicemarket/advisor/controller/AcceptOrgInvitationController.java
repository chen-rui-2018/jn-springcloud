package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.service.AcceptOrgInvitationService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/2/25 14:19
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户中心--我的机构--接受机构邀请")
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
    @ApiOperation(value = "接受机构邀请",notes = "advisorAccount:顾问账号，返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/acceptOrgInvitation",method = RequestMethod.POST)
    public Result<Integer> acceptOrgInvitation(@RequestBody  String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        int responseNum = acceptOrgInvitationService.acceptOrgInvitation(advisorAccount);
        logger.info("------接受机构邀请成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "拒绝邀请")
    @ApiOperation(value = "拒绝邀请",notes = "advisorAccount:顾问账号，返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/refuseInvitation",method = RequestMethod.POST)
    public Result refuseInvitation(@RequestBody String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        int responseNum = acceptOrgInvitationService.refuseInvitation(advisorAccount);
        logger.info("------拒绝邀请成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }

}
