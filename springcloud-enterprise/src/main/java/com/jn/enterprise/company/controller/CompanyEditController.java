package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.CompanyUpdateParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： huxw
 * @date： Created on 2019-4-18 16:54:39
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业服务")
@RestController
@RequestMapping("/enterprise/company")
public class CompanyEditController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "编辑企业资料")
    @ApiOperation(value = "编辑企业资料", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/updateCompanyInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/company/updateCompanyInfo")
    public Result updateCompanyInfo(@Validated @RequestBody CompanyUpdateParam companyUpdateParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        Integer result = companyService.updateCompanyInfo(companyUpdateParam, user.getAccount(), user.getPhone());
        return new Result(result);
    }
}