package com.jn.enterprise.joinpark.usermanage.controller;

import com.jn.common.model.Result;
import com.jn.enterprise.joinpark.usermanage.model.*;
import com.jn.enterprise.joinpark.usermanage.service.UserUpgradeService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 升级用户
 * @author： jiangyl
 * @date： Created on 2019/3/5 9:54
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "加入园区-升级用户")
@RestController
@RequestMapping("/guest/userUpgrade")
public class UserUpgradeController {

    private static Logger logger = LoggerFactory.getLogger(UserUpgradeController.class);

    @Autowired
    private UserUpgradeService userUpgradeService;


    @ControllerLog(doAction = "升级企业")
    @ApiOperation(value = "升级企业", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/changeToCompany")
    public Result changeToCompany(@RequestBody @Validated CompanyCheckParam companyCheckParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = userUpgradeService.changeToCompany(companyCheckParam, user.getPhone(), user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "升级员工")
    @ApiOperation(value = "升级企业", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/changeToStaff")
    public Result changeToStaff(@RequestBody @Validated StaffCheckParam staffCheckParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = userUpgradeService.changeToStaff(staffCheckParam, user.getPhone(), user.getAccount());
        return new Result(i);
    }


    @ControllerLog(doAction = "升级企业工作流回调接口")
    @ApiOperation(value = "升级企业工作流回调接口", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/changeToCompanyCallBack")
    public Result changeToCompanyCallBack(@RequestBody @Validated CompanyCheckCallBackParam companyCheckCallBackParam) {
        Boolean aBoolean = userUpgradeService.changeToCompanyCallBack(companyCheckCallBackParam);
        return new Result(aBoolean);
    }

    @ControllerLog(doAction = "升级员工工作流回调接口")
    @ApiOperation(value = "升级员工工作流回调接口", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/changeToStaffCallBack")
    public Result changeToStaffCallBack(@RequestBody @Validated StaffCheckCallBackParam staffCheckCallBackParam) {
        Boolean aBoolean = userUpgradeService.changeToStaffCallBack(staffCheckCallBackParam);
        return new Result(aBoolean);
    }



    @ControllerLog(doAction = "升级员工")
    @ApiOperation(value = "升级企业", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/changeToStaff")
    public Result selectCompany(@ApiParam(name="comName",value = "企业名")@RequestParam(value = "comName")  String comName) {
        List<Conpany> conpanies = userUpgradeService.selectCompany(comName);
        return new Result(conpanies);
    }

}
