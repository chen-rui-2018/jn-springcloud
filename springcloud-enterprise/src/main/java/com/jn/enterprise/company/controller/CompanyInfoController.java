package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Result;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.vo.UpgradeStatusVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： huxw
 * @date： Created on 2019-6-13 21:28:49
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业服务")
@RestController
@RequestMapping("/enterprise/company")
public class CompanyInfoController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "查询当前企业信息")
    @ApiOperation(value = "查询当前企业信息")
    @RequestMapping(value = "/getCurCompanyInfo",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/company/getCurCompanyInfo")
    public Result<ServiceCompany> getCompanyList(){
        User user = checkUserValid();
        return new Result(companyService.getCurCompanyInfo(user.getAccount()));
    }

    @ControllerLog(doAction = "查询当前账号是否允许认证")
    @ApiOperation(value = "查询当前账号是否允许认证")
    @RequestMapping(value = "/getJoinParkStatus",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/company/getJoinParkStatus")
    public Result<UpgradeStatusVO> getJoinParkStatus(){
        User user = checkUserValid();
        return new Result(companyService.getJoinParkStatus(user.getAccount()));
    }

    /**
     * 判断当前账号是否有效
     * @return
     */
    public User checkUserValid() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_LOGIN_IS_INVALID);
        }
        return user;
    }
}
