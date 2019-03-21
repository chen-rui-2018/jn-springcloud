package com.jn.enterprise.servicemarket.org.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.enterprise.servicemarket.org.model.OrgBasicData;
import com.jn.enterprise.servicemarket.org.model.OrgContactData;
import com.jn.enterprise.servicemarket.org.model.OrgLicenseData;
import com.jn.enterprise.servicemarket.org.model.OrgTeamData;
import com.jn.enterprise.servicemarket.org.service.OrgService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顾问认证管理
 * @author： jiangyl
 * @date： Created on 2019/2/15 15:38
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "服务机构管理,(app机构认证)")
@RestController
@RequestMapping(value = "/serviceMarket/org")
public class OrgManageController extends BaseController {

    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(OrgManageController.class);

    @Autowired
    private OrgService orgService;

    @ControllerLog(doAction = "保存服务机构基本信息,(app-基本资料)")
    @ApiOperation(value = "保存服务机构基本信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrgBasicData")
    @RequiresPermissions("/serviceMarket/org/saveOrgBasicData")
    public Result saveOrgBasicData(@RequestBody @Validated OrgBasicData orgBasicData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String s = orgService.saveOrUpdateOrgBasicData(orgBasicData, user.getAccount());
        logger.info("保存服务机构基本信息成功，响应ID："+s);
        return new Result(s);
    }

    @ControllerLog(doAction = "修改服务机构基本信息,(app-修改基本资料)")
    @ApiOperation(value = "修改服务机构基本信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/updateOrgBasicData")
    @RequiresPermissions("/serviceMarket/org/updateOrgBasicData")
    public Result updateOrgBasicData(@RequestBody @Validated OrgBasicData orgBasicData){
        Assert.notNull(orgBasicData.getOrgId(), OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String s = orgService.saveOrUpdateOrgBasicData(orgBasicData, user.getAccount());
        logger.info("修改服务机构基本信息成功，响应ID："+s);
        return new Result(s);
    }

    @ControllerLog(doAction = "保存/修改服务机构资质信息,(app-资质认证)")
    @ApiOperation(value = "保存/修改服务机构资质信息[保存/修改入参相同]", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrgLicenseData")
    @RequiresPermissions("/serviceMarket/org/saveOrgLicenseData")
    public Result saveOrgLicenseData(@RequestBody @Validated OrgLicenseData orgLicenseData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgService.saveOrgLicenseData(orgLicenseData, user.getAccount());
        logger.info("保存服务机构资质信息成功，响应条数："+i);
        return new Result(i);
    }


    @ControllerLog(doAction = "保存/修改服务机构团队信息,(app-团队资料)")
    @ApiOperation(value = "保存/修改服务机构团队信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrgTeamData")
    @RequiresPermissions("/serviceMarket/org/saveOrgTeamData")
    public Result saveOrgTeamData(@RequestBody @Validated OrgTeamData orgTeamData){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgService.saveOrUpdateOrgTeamData(orgTeamData, user.getAccount());
        logger.info("保存服务机构资质信息成功，响应条数："+i);
        return new Result(i);
    }

    @ControllerLog(doAction = "保存/修改服务机构联系方式,(app-联系方式)")
    @ApiOperation(value = "保存/修改服务机构联系方式[保存/修改入参相同]", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/saveOrgContactData")
    @RequiresPermissions("/serviceMarket/org/saveOrgContactData")
    public Result saveOrgContactData(@RequestBody @Validated OrgContactData orgContactData){
        Assert.notNull(orgContactData.getOrgId(), OrgExceptionEnum.ORG_ID_IS_NOT_NULL.getMessage());
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = orgService.saveOrUpdateOrgContactData(orgContactData, user.getAccount());
        logger.info("保存服务机构资质信息成功，响应条数："+i);
        return new Result(i);
    }



}
