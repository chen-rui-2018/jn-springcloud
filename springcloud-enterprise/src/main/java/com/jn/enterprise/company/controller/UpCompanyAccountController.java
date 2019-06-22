package com.jn.enterprise.company.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.enterprise.company.model.ServiceCompany;
import com.jn.enterprise.company.service.UpCompanyAccountService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 升级企业账号控制层
 *
 * @author： shaobao
 * @date： Created on 2019/5/28 19:21
 * @version： v1.0
 * @modified By:
 **/
@Api(tags = "用户中心-我的企业-升级企业账号", hidden = true)
@RestController
@RequestMapping("/enterprise/UpCompanyAccount")
public class UpCompanyAccountController extends BaseController {

    @Autowired
    private UpCompanyAccountService upCompanyAccountService;

    @ControllerLog(doAction = "升级企业账号流程后置处理")
    @ApiOperation(value = "升级企业账号流程后置处理", notes = "设置企业申请人为企业管理员", hidden = true)
    @RequestMapping(value = "/setComApplicantToManager", method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/UpCompanyAccount/setComApplicantToManager")
    @TxTransaction(isStart = true)
    public Result setComApplicantToManager(@Validated @RequestBody ServiceCompany ServiceCompany) {
        upCompanyAccountService.setComApplicantToManager(ServiceCompany);
        return new Result();
    }
}
