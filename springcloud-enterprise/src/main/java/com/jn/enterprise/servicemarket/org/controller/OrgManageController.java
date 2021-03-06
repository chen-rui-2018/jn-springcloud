package com.jn.enterprise.servicemarket.org.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.InvestorExceptionEnum;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.*;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.enterprise.technologyfinancial.investors.model.InvestorInfoWorkFlow;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 专员认证管理
 * @author： jiangyl
 * @date： Created on 2019/2/15 15:38
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心--角色认证--服务机构认证,(app机构认证)")
@RestController
@RequestMapping(value = "/serviceMarket/org")
public class OrgManageController extends BaseController {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgManageController.class);

    @Autowired
    private OrgService orgService;

    @ControllerLog(doAction = "保存服务机构基本信息")
    @ApiOperation(value = "保存服务机构基本信息,(pc/app-基本资料)",notes = "返回结果为机构ID")
    @RequestMapping(value = "/saveOrgBasicData",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/org/saveOrgBasicData")
    public Result<String> saveOrgBasicData(@RequestBody @Validated OrgBasicData orgBasicData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String s = orgService.saveOrUpdateOrgBasicData(orgBasicData, user.getAccount());
        logger.info("保存服务机构基本信息成功，响应ID："+s);
        return new Result<>(s);
    }

    @ControllerLog(doAction = "修改服务机构基本信息")
    @ApiOperation(value = "修改服务机构基本信息(pc/app-修改基本资料)",notes = "返回结果为机构ID")
    @RequestMapping(value = "/updateOrgBasicData",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/org/updateOrgBasicData")
    public Result<String> updateOrgBasicData(@RequestBody @Validated OrgBasicDataServlet basicDataServlet){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        OrgBasicData orgBasicData = new OrgBasicData();
        BeanUtils.copyProperties(basicDataServlet,orgBasicData);
        String s = orgService.saveOrUpdateOrgBasicData(orgBasicData, user.getAccount());
        logger.info("修改服务机构基本信息成功，响应ID："+s);
        return new Result(s);
    }

    @ControllerLog(doAction = "保存/修改服务机构资质信息")
    @ApiOperation(value = "保存/修改服务机构资质信息[保存/修改入参相同] ,(pc/app-资质认证)",notes = "返回结果为响应数据条数，正常情况为1")
    @RequestMapping(value = "/saveOrgLicenseData",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/org/saveOrgLicenseData")
    public Result<Integer> saveOrgLicenseData(@RequestBody @Validated OrgLicenseData orgLicenseData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgService.saveOrgLicenseData(orgLicenseData, user.getAccount());
        logger.info("保存服务机构资质信息成功，响应条数："+i);
        return new Result(i);
    }


    @ControllerLog(doAction = "保存/修改服务机构团队信息")
    @ApiOperation(value = "保存/修改服务机构团队信息,(pc/app-团队资料)",notes = "返回结果为响应数据条数，正常情况为1")
    @RequestMapping(value = "/saveOrgTeamData",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/org/saveOrgTeamData")
    public Result<Integer> saveOrgTeamData(@RequestBody @Validated OrgTeamData orgTeamData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgService.saveOrUpdateOrgTeamData(orgTeamData, user.getAccount());
        logger.info("保存服务机构资质信息成功，响应条数："+i);
        return new Result(i);
    }

    @ControllerLog(doAction = "保存/修改服务机构联系方式")
    @ApiOperation(value = "保存/修改服务机构联系方式[保存/修改入参相同],(pc/app-联系方式)",notes = "返回结果为响应数据条数，正常情况为1")
    @RequestMapping(value = "/saveOrgContactData",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/org/saveOrgContactData")
    public Result<Integer> saveOrgContactData(@RequestBody @Validated OrgContactData orgContactData){
        Assert.notNull(orgContactData.getOrgId(), OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgService.saveOrUpdateOrgContactData(orgContactData, user.getAccount());
        logger.info("保存服务机构资质信息成功，响应条数："+i);
        return new Result(i);
    }

    @ControllerLog(doAction = "获取当前用户机构状态")
    @ApiOperation(value = "获取当前用户机构状态",notes = "返回值为状态属性。【0审核中 1审核通过2审核不通过 -1无机构数据，即普通用户】")
    @RequestMapping(value = "/getOrgStatusByUser",method = RequestMethod.POST)
    @RequiresPermissions("/serviceMarket/org/getOrgStatusByUser")
    public Result<String> getOrgStatusByUser(){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(orgService.getOrgStatusByUser(user.getAccount()));
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "添加机构管理员角色")
    @ApiOperation(value = "添加机构管理员角色",notes = "originalId:原有机构id(修改时，旧数据的机构id,新增时可为空),机构认证审批通过后，ibps后置处理器调用此接口添加机构专员角色,返回数据响应条数")
    @RequiresPermissions("/serviceMarket/org/addOrgRole")
    @RequestMapping(value = "/addOrgRole",method = RequestMethod.POST)
    public Result<Integer> addOrgRole(@RequestBody TbServiceOrgCopy  tbServiceOrgCopy){
        Assert.notNull(tbServiceOrgCopy.getOrgAccount(), OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        Assert.notNull(tbServiceOrgCopy.getOrgId(),OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int resNum = orgService.addOrgRole(tbServiceOrgCopy,user.getAccount());
        logger.info("-----------添加机构管理员角色成功，数据响应条数：{}----------",resNum);
        return  new Result(resNum);
    }

    @ControllerLog(doAction = "机构认证流程后置处理")
    @ApiOperation(value = "机构认证流程后置处理", notes = "设置机构认证申请人角色为机构管理员")
    @RequiresPermissions("/serviceMarket/org/setAccountRoleToOrgManager")
    @RequestMapping(value = "/setAccountRoleToOrgManager", method = RequestMethod.POST)
    @TxTransaction(isStart = true)
    public Result<Integer> setAccountRoleToOrgManager(@Validated @RequestBody TbServiceOrgCopy  tbServiceOrgCopy) {
        logger.info("机构认证流程后置处理API,入参：{}",tbServiceOrgCopy.toString());
        Assert.notNull(tbServiceOrgCopy,OrgExceptionEnum.ORG_APPLY_PARAM_NOT_NULL.getMessage());
        Assert.notNull(tbServiceOrgCopy.getOrgAccount(),OrgExceptionEnum.ACCOUNT_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int resNum = orgService.addOrgRole(tbServiceOrgCopy,user.getAccount());
        logger.info("-----------添加机构管理员角色成功，数据响应条数：{}----------",resNum);
        return  new Result(resNum);
    }

}
