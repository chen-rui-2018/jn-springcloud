package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.system.log.annotation.ControllerLog;
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
 * @date： Created on 2019/3/14 17:44
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/api/company")
public class CompanyServerController extends BaseController implements CompanyClient {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "查询企业列表")
    @ApiOperation(value = "查询企业列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCompanyList")
    @Override
    public Result<PaginationData<List<ServiceCompany>>> getCompanyList(@RequestBody ServiceCompanyParam serviceCompanyParam){
        return new Result<>(companyService.getCompanyList(serviceCompanyParam));
    }

    @ControllerLog(doAction = "根据企业ID查询企业详细信息")
    @ApiOperation(value = "根据企业ID查询企业详细信息", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCompanyDetail")
    @Override
    public Result<ServiceCompany> getCompanyDetail(@RequestBody String companyId){
        return new Result<>(companyService.getCompanyDetail(companyId));
    }

    @ControllerLog(doAction = "根据用户账号查询企业信息（用户为企业管理员）")
    @ApiOperation(value = "根据用户账号查询企业信息（用户为企业管理员）", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCompanyDetailByAccount")
    @Override
    public Result<ServiceCompany> getCompanyDetailByAccount(@RequestBody String account){
        return new Result<>(companyService.getCompanyDetailByAccount(account));
    }

}
