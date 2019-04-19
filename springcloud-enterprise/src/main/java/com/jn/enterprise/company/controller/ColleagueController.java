package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.enums.CompanyDataEnum;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.ColleagueListParam;
import com.jn.enterprise.company.model.StaffListParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.StaffService;
import com.jn.enterprise.company.vo.StaffListVO;
import com.jn.enterprise.enums.OrgExceptionEnum;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.user.api.UserExtensionClient;
import com.jn.user.model.UserExtensionInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-4-9 10:53:30
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-我的企业-企业同事")
@RestController
@RequestMapping("/enterprise/ColleagueController")
public class ColleagueController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private UserExtensionClient userExtensionClient;

    @ControllerLog(doAction = "同事列表")
    @ApiOperation(value = "同事列表（pc/app-同事列表）", notes = "按手机号或名称（模糊查询）[分页查询]")
    @RequestMapping(value = "/getColleagueList",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/ColleagueController/getColleagueList")
    public Result<PaginationData<List<StaffListVO>>> getColleagueList(@Validated ColleagueListParam colleagueListParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            return new Result(CompanyExceptionEnum.NETWORK_ANOMALY.getCode(),CompanyExceptionEnum.NETWORK_ANOMALY.getMessage());
        }

        // 获取当前用户扩展信息
        Result<UserExtensionInfo> userExtension = userExtensionClient.getUserExtension(user.getAccount());
        if(userExtension == null || userExtension.getData() == null){
            throw new JnSpringCloudException(OrgExceptionEnum.USER_EXTENSION_IS_NULL);
        }
        // 判断当前用户是否为企业员工并获取企业ID
        String comId = userExtension.getData().getCompanyCode();
        if(StringUtils.isBlank(comId)){
            throw new JnSpringCloudException(CompanyExceptionEnum.USER_NO_STAFF);
        }

        StaffListParam staffListParam = new StaffListParam();
        BeanUtils.copyProperties(colleagueListParam, staffListParam);
        // 查询通过审核的员工
        staffListParam.setStatus(CompanyDataEnum.STAFF_CHECK_STATUS_PASS.getCode());
        return new Result(staffService.getColleagueList(staffListParam, comId));
    }

    @ControllerLog(doAction = "批量删除同事")
    @ApiOperation(value = "批量删除同事（pc/app-删除同事）", notes = "返回数据响应条数")
    @RequestMapping(value = "/delColleague",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/delColleague")
    public Result<Integer> delColleague(@Validated @RequestBody @ApiParam(name="accountList", value = "员工账号列表", required = true, example = "['zhangsan','lisi']") String[] accountList){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null) {
            return new Result(CompanyExceptionEnum.NETWORK_ANOMALY.getCode(),CompanyExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        Assert.notNull(company, CompanyExceptionEnum.USER_IS_NOT_COMPANY_ADMIN.getMessage());
        return new Result(staffService.delMoreStaffs(accountList, company.getId(), user.getAccount()));
    }

    @ControllerLog(doAction = "设置联系人")
    @ApiOperation(value = "设置联系人（pc-设为联系人）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/setContact",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/setContact")
    public Result<Integer> setContact(@Validated @NotNull @RequestBody @ApiParam(name="account", value = "员工账号", required = true) String account){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null) {
            return new Result(CompanyExceptionEnum.NETWORK_ANOMALY.getCode(),CompanyExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        Assert.notNull(company, CompanyExceptionEnum.USER_IS_NOT_COMPANY_ADMIN.getMessage());
        return new Result(staffService.setContact(account, company.getId()));
    }

    @ControllerLog(doAction = "取消联系人")
    @ApiOperation(value = "取消联系人（pc-取消联系人）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/cancelContact",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/ColleagueController/cancelContact")
    public Result<Integer> cancelContact(@Validated @NotNull @RequestBody @ApiParam(name="account", value = "员工账号", required = true) String account){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null) {
            return new Result(CompanyExceptionEnum.NETWORK_ANOMALY.getCode(),CompanyExceptionEnum.NETWORK_ANOMALY.getMessage());
        }
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        Assert.notNull(company, CompanyExceptionEnum.USER_IS_NOT_COMPANY_ADMIN.getMessage());
        return new Result(staffService.cancelContact(account, company.getId()));
    }

}
