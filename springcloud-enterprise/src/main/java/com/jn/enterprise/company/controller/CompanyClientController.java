package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.enterprise.api.CompanyClient;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.CompanyDetailsVo;
import com.jn.enterprise.model.CompanyInfoModel;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/6/10 17:17
 * @version： v1.0
 * @modified By:
 */
@RestController
public class CompanyClientController extends BaseController implements CompanyClient {

    @Autowired
    CompanyService companyService;
    @ControllerLog(doAction = "获取企业信息(关注企业列表展示)")
    @Override
    public CompanyInfoModel getCompanyInfo(@RequestParam(value = "companyId") String companyId) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        CompanyInfoModel companyInfoModel =   companyService.getCompanyInfo(companyId,user==null?"":user.getAccount());


        return companyInfoModel;
    }
}
