package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.company.api.CompanyClient;
import com.jn.company.model.CreditUpdateParam;
import com.jn.company.model.ServiceCompany;
import com.jn.company.model.ServiceCompanyParam;
import com.jn.company.model.UpdateCompanyInfoParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/14 17:44
 * @version： v1.0
 * @modified By:
 */
@RestController
public class CompanyServerController extends BaseController implements CompanyClient {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "查询企业列表")
    @Override
    public Result<PaginationData<List<ServiceCompany>>> getCompanyList(@RequestBody ServiceCompanyParam serviceCompanyParam){
        return new Result<>(companyService.getCompanyList(serviceCompanyParam));
    }


    @ControllerLog(doAction = "根据用户账号/企业ID查询企业信息（用户为企业管理员）")
    @Override
    public Result<ServiceCompany> getCompanyDetailByAccountOrCompanyId(@RequestBody String accountOrCompanyId){
        return new Result<>(companyService.getCompanyDetailByAccountOrId(accountOrCompanyId));
    }


    @ControllerLog(doAction = "修改企业信用分")
    @Override
    public Result<Boolean> updateCreditPoints(@RequestBody CreditUpdateParam creditUpdateParam){
        return companyService.updateCreditPoints(creditUpdateParam);
    }


    @Override
    @ControllerLog(doAction = "企业缴费成功修改企业信息")
    public Result<Boolean> updateCompanyInfoAfterPay(@Validated @RequestBody UpdateCompanyInfoParam updateCompanyInfoParam){
        return new Result(companyService.updateCompanyInfoAfterPay(updateCompanyInfoParam));
    }

}
