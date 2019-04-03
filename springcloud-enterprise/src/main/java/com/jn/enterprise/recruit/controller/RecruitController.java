package com.jn.enterprise.recruit.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.recruit.enums.RecruitExceptionEnum;
import com.jn.enterprise.recruit.model.ServiceRecruitEditParam;
import com.jn.enterprise.recruit.model.ServiceRecruitPublishParam;
import com.jn.enterprise.recruit.model.ServiceRecruitUnderParam;
import com.jn.enterprise.recruit.service.RecruitService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:20:58
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-招聘管理")
@RestController
@RequestMapping("/enterprise/RecruitController")
public class RecruitController extends BaseController {

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "发布招聘信息")
    @ApiOperation(value = "发布招聘信息", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/publishRecruitInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/publishRecruitInfo")
    public Result<Integer> publishRecruitInfo(@Validated @RequestBody ServiceRecruitPublishParam serviceRecruitPublishParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        return new Result(recruitService.publishRecruitInfo(serviceRecruitPublishParam, company.getId(), user));
    }

    @ControllerLog(doAction = "编辑招聘信息")
    @ApiOperation(value = "编辑招聘信息", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/editRecruitInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/editRecruitInfo")
    public Result<Integer> editRecruitInfo(@Validated @RequestBody ServiceRecruitEditParam serviceRecruitEditParam){
        Assert.notNull(serviceRecruitEditParam.getId(),RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 只有企业管理员有权限编辑
        companyService.getCompanyDetailByAccountOrId(user.getAccount());
        return new Result(recruitService.editRecruitInfo(serviceRecruitEditParam, user));
    }

    @ControllerLog(doAction = "上/下架招聘信息")
    @ApiOperation(value = "上/下架招聘信息", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/underRecruit",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/underRecruit")
    public Result<Integer> underRecruit(@Validated @RequestBody ServiceRecruitUnderParam serviceRecruitUnderParam){
        Assert.notNull(serviceRecruitUnderParam.getId(),RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        Assert.notNull(serviceRecruitUnderParam.getStatus(),RecruitExceptionEnum.RECRUIT_STATUS_IS_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 园区管理员和企业管理员都可以上下架
        // companyService.getCompanyDetailByAccountOrId(user.getAccount());
        return new Result(recruitService.underRecruit(serviceRecruitUnderParam, user));
    }

    @ControllerLog(doAction = "删除招聘信息")
    @ApiOperation(value = "删除招聘信息", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/delRecruit",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/delRecruit")
    public Result<Integer> delRecruit(@Validated @RequestBody @ApiParam(name="recruitId", value = "招聘ID", required = true) String recruitId){
        Assert.notNull(recruitId,RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        // 园区管理员才有删除权限
        // ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        // RecruitDetailsVO recruitDetails = recruitService.getRecruitDetailsById(recruitId);
        // Assert.notNull(recruitDetails,RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST.getMessage());
        // Assert.isTrue(recruitDetails.getComId().equals(company.getId()),RecruitExceptionEnum.RECRUIT_USER_NOT_ENTERPRISE_ADMIN.getMessage());
        return new Result(recruitService.delRecruitById(recruitId, user));
    }

}
