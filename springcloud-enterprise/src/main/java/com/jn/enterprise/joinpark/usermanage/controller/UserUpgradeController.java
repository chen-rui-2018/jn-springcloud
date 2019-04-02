package com.jn.enterprise.joinpark.usermanage.controller;

import com.jn.common.model.Result;
import com.jn.enterprise.company.model.Company;
import com.jn.enterprise.company.model.CompanyCheckCallBackParam;
import com.jn.enterprise.company.model.CompanyCheckParam;
import com.jn.enterprise.joinpark.usermanage.model.StaffCheckCallBackParam;
import com.jn.enterprise.joinpark.usermanage.model.StaffCheckParam;
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
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "升级企业", notes = "返回值为响应数据条数,正常情况为1")
    @RequestMapping(value = "/changeToCompany",method = RequestMethod.POST)
    public Result<Integer> changeToCompany(@RequestBody @Validated CompanyCheckParam companyCheckParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = userUpgradeService.changeToCompany(companyCheckParam, user.getPhone(), user.getAccount());
        return new Result(i);
    }

    @ControllerLog(doAction = "升级员工")
    @ApiOperation(value = "升级员工",notes = "返回值为响应数据条数，正常为情况1")
    @RequestMapping(value = "/changeToStaff",method = RequestMethod.POST)
    public Result<Integer> changeToStaff(@RequestBody @Validated StaffCheckParam staffCheckParam) {
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = userUpgradeService.changeToStaff(staffCheckParam, user.getPhone(), user.getAccount());
        return new Result(i);
    }


    @ControllerLog(doAction = "升级企业工作流回调接口")
    @ApiOperation(value = "升级企业工作流回调接口",notes = "前端无需理会该接口，此处仅为测试使用")
    @RequestMapping(value = "/changeToCompanyCallBack",method = RequestMethod.POST)
    public Result<Boolean> changeToCompanyCallBack(@RequestBody @Validated CompanyCheckCallBackParam companyCheckCallBackParam) {
        Boolean aBoolean = userUpgradeService.changeToCompanyCallBack(companyCheckCallBackParam);
        return new Result(aBoolean);
    }

    @ControllerLog(doAction = "升级员工工作流回调接口")
    @ApiOperation(value = "升级员工工作流回调接口",notes = "前端无需理会该接口，此处仅为测试使用")
    @RequestMapping(value = "/changeToStaffCallBack",method = RequestMethod.POST)
    public Result<Boolean> changeToStaffCallBack(@RequestBody @Validated StaffCheckCallBackParam staffCheckCallBackParam) {
        Boolean aBoolean = userUpgradeService.changeToStaffCallBack(staffCheckCallBackParam);
        return new Result(aBoolean);
    }



    @ControllerLog(doAction = "查询公司列表")
    @ApiOperation(value = "查询公司列表",notes = "comName可为空，不分页查询，只用于查询企业基本数据{企业id，企业名，企业logo}")
    @RequestMapping(value = "/selectCompany",method = RequestMethod.GET)
    public Result<List<Company>> selectCompany(@ApiParam(name="comName",value = "企业名",example = "君南")@RequestParam(value = "comName")  String comName) {
        List<Company> companies = userUpgradeService.selectCompany(comName);
        return new Result(companies);
    }

}
