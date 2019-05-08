package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.common.util.DateUtils;
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
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(tags = "企业服务")
@RestController
@RequestMapping("/enterprise/company")
public class CompanyEditController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "编辑企业资料")
    @ApiOperation(value = "编辑企业资料", notes = "编辑企业资料")
    @RequestMapping(value = "/updateCompanyInfo",method = RequestMethod.POST)
    public Result updateCompanyInfo(@Validated @RequestBody CompanyUpdateParam companyUpdateParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        // 判断当前用户是否为企业管理员
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());

        // 如果有数据且正在审核中抛出异常
        TbServiceCompanyModify companyModify = companyService.getLastModify(company.getId());
        if (companyModify != null && companyModify.getCheckStatus().equals(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode())) {
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_CHECK_ING);
        }

        // 封装ibps数据
        companyUpdateParam.setCheckStatus(CompanyDataEnum.STAFF_CHECK_STATUS_WAIT.getCode());
        companyUpdateParam.setComId(company.getId());
        companyUpdateParam.setCreatedTime(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
        companyUpdateParam.setCreatorAccount(user.getAccount());
        companyUpdateParam.setRecordStatus(CompanyDataEnum.RECORD_STATUS_VALID.getCode());

        IBPSResult ibpsResult = IBPSUtils.sendRequest("574913700364812288", user.getAccount(), companyUpdateParam);

        // ibps启动流程失败
        if (ibpsResult == null || ibpsResult.getState().equals("-1")) {
            throw new JnSpringCloudException(CompanyExceptionEnum.COMPANY_CHECK_ERROR);
        }
        return new Result("企业信息提交审核成功");
    }
}