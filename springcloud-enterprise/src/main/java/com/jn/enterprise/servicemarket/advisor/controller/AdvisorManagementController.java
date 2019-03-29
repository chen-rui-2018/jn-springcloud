package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementParam;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorManagementShow;
import com.jn.enterprise.servicemarket.advisor.model.ApprovalParam;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorManagementService;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
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
 * 顾问管理
 * @Author: yangph
 * @Date: 2019/2/19 9:40
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务超市-顾问管理(web+手机)")
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
    @ApiOperation(value = "通过注册账号回显用户信息")
    @RequestMapping(value = "/echoUserInfo",method = RequestMethod.GET)
    public Result<UserExtensionInfo> echoUserInfo(@ApiParam(value = "注册手机/邮箱" ,required = true,example = "18088888888")@RequestParam("registerAccount") String registerAccount){
        Assert.notNull(registerAccount, AdvisorExceptionEnum.REGISTER_ACCOUNT.getMessage());
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(registerAccount);
        return  userExtension;
    }


    @ControllerLog(doAction = "邀请顾问")
    @RequiresPermissions("/advisor/advisorManagementController/inviteAdvisor")
    @ApiOperation(value = "邀请顾问,(pc/app邀请顾问)",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/inviteAdvisor",method = RequestMethod.POST)
    public Result inviteAdvisor(@ApiParam(value = "注册手机/邮箱" ,required = true,example = "181*****") String registerAccount){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        int responseNum = advisorManagementService.inviteAdvisor(registerAccount,user.getAccount());
        logger.info("------邀请顾问操作成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "顾问管理")
    @RequiresPermissions("/advisor/advisorManagementController/getAdvisorManagementInfo")
    @ApiOperation(value = "顾问管理(pc/app顾问管理)")
    @RequestMapping(value = "/getAdvisorManagementInfo",method = RequestMethod.GET)
    public Result<PaginationData<List<AdvisorManagementShow>>> getAdvisorManagementInfo(@Validated AdvisorManagementParam advisorManagementParam){
        Assert.notNull(advisorManagementParam.getApprovalStatus(), AdvisorExceptionEnum.APPROVAL_STATUS_NOT_NULL.getMessage());
        PaginationData advisorManagementInfo = advisorManagementService.getAdvisorManagementInfo(advisorManagementParam);
        return  new Result(advisorManagementInfo);
    }

    @ControllerLog(doAction = "审批顾问填写信息")
    @RequiresPermissions("/advisor/advisorManagementController/approvalAdvisorInfo")
    @ApiOperation(value = "审批顾问填写信息",notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/approvalAdvisorInfo",method = RequestMethod.POST)
    public Result approvalAdvisorInfo(@RequestBody @Validated ApprovalParam approvalParam){
        int responseNum = advisorManagementService.approvalAdvisorInfo(approvalParam);
        logger.info("------审批顾问填写信息成功，数据响应条数：{}-------",responseNum);
        return  new Result(responseNum);
    }

    @ControllerLog(doAction = "用户中心顾问详情")
    @RequiresPermissions("/advisor/advisorManagementController/advisorDetails")
    @ApiOperation(value = "用户中心顾问详情")
    @RequestMapping(value = "/advisorDetails",method = RequestMethod.GET)
    public Result<AdvisorDetailsVo> advisorDetails(@ApiParam(value = "顾问账号" ,required = true,example = "wangsong") @RequestParam("advisorAccount") String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount);
        return  new Result(advisorDetailsVo);
    }
}

