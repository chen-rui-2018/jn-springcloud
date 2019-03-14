package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 16:42
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业服务")
@RestController
@RequestMapping("/guest/company")
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "查询企业列表")
    @ApiOperation(value = "查询企业列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCompanyList")
    public Result<PaginationData<List<ServiceCompany>>> getCompanyList(@RequestBody ServiceCompanyParam serviceCompanyParam){
        return new Result<>(companyService.getCompanyList(serviceCompanyParam));
    }

    @ControllerLog(doAction = "根据企业ID查询企业详细信息")
    @ApiOperation(value = "根据企业ID查询企业详细信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCompanyDetail")
    public Result<ServiceCompany> getCompanyDetail(
            @ApiParam(name="companyId",value = "企业ID",required = true)
            @RequestParam(value = "companyId") String companyId){
        return new Result<>(companyService.getCompanyDetail(companyId));
    }

    @ControllerLog(doAction = "根据用户账号查询企业信息（用户为企业管理员）")
    @ApiOperation(value = "根据用户账号查询企业信息（用户为企业管理员）", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCompanyDetailByAccount")
    public Result<ServiceCompany> getCompanyDetailByAccount(
            @ApiParam(name="account",value = "用户账号",required = true)
            @RequestParam(value = "account") String account){
        return new Result<>(companyService.getCompanyDetailByAccount(account));
    }

}
