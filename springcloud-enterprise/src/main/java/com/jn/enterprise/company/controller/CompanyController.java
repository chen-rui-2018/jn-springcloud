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
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "查询企业列表")
    @RequestMapping(value = "/getCompanyList",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceCompany>>> getCompanyList(ServiceCompanyParam serviceCompanyParam){
        return new Result<>(companyService.getCompanyList(serviceCompanyParam));
    }

    @ControllerLog(doAction = "根据用户账号/企业ID查询企业信息（用户为企业管理员）")
    @ApiOperation(value = "根据用户账号查询企业信息",notes = "用户为企业管理员")
    @RequestMapping(value = "/getCompanyDetailByAccountOrCompanyId",method = RequestMethod.GET)
    public Result<ServiceCompany> getCompanyDetailByAccountOrCompanyId(
            @ApiParam(name="accountOrCompanyId",value = "用户账号或企业ID",required = true,example = "wangsong")
            @RequestParam(value = "accountOrCompanyId") String accountOrCompanyId){
        return new Result<>(companyService.getCompanyDetailByAccountOrId(accountOrCompanyId));
    }

}
