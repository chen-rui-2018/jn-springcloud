package com.jn.enterprise.company.controller;

import com.google.gson.Gson;
import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.CallOtherSwaggerUtils;
import com.jn.common.util.DateUtils;
import com.jn.common.util.StringUtils;
import com.jn.company.model.IBPSResult;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.entity.TbServiceCompanyModify;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.CompanyUpdateParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.utils.IBPSUtils;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author： huxw
 * @date： Created on 2019-4-18 16:54:39
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业服务", hidden = true)
@RestController
@RequestMapping("/guest/company")
public class CompanyEditController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "编辑企业资料")
    @ApiOperation(value = "编辑企业资料", notes = "编辑企业资料")
    @RequestMapping(value = "/updateCompanyInfo",method = RequestMethod.POST)
    public Result updateCompanyInfo(@Validated @RequestBody CompanyUpdateParam companyUpdateParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.NETWORK_ANOMALY);
        }
        // 判断当前用户是否为企业管理员
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());

        TbServiceCompanyModify companyModify = companyService.getLastModify(company.getId());

        // 如果有数据且正在审核中抛出异常
        if (companyModify != null && (StringUtils.isEmpty(companyModify.getCheckStatus()) || companyModify.getCheckStatus().equals(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode()))) {
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_CHECK_ING);
        }

        // 封装ibps数据
        companyUpdateParam.setId("");
        companyUpdateParam.setComId(company.getId());
        companyUpdateParam.setCreatedTime(new Date());
        companyUpdateParam.setCreatorAccount(user.getAccount());
        companyUpdateParam.setRecordStatus(CompanyDataEnum.RECORD_STATUS_VALID.getCode());

        // TODO 调用ibps
        IBPSResult ibpsResult = IBPSUtils.sendRequest("574913700364812288", user.getAccount(), companyUpdateParam);
//        if (ibpsResult != null && ibpsResult.getState().equals("200") && ibpsResult.getMessage().equals("流程启动成功!")) {

//        }
        return new Result(ibpsResult);
    }
}