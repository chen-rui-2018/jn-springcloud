package com.jn.enterprise.recruit.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.recruit.enums.RecruitExceptionEnum;
import com.jn.enterprise.recruit.model.ServiceRecruitEditParam;
import com.jn.enterprise.recruit.model.ServiceRecruitParam;
import com.jn.enterprise.recruit.model.ServiceRecruitPublishParam;
import com.jn.enterprise.recruit.service.RecruitService;
import com.jn.enterprise.recruit.vo.RecruitDetailsVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:20:58
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "企业招聘服务")
@RestController
@RequestMapping("/enterprise/RecruitController")
public class RecruitController extends BaseController {

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private CompanyService companyService;


    @ControllerLog(doAction = "发布企业招聘信息")
    @ApiOperation(value = "发布企业招聘信息", notes = "发布企业招聘信息")
    @RequestMapping(value = "/publishRecruitInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/publishRecruitInfo")
    public Result<Integer> publishRecruitInfo(@Validated @RequestBody ServiceRecruitPublishParam serviceRecruitPublishParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        ServiceCompany companyDetails = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        int i = recruitService.publishRecruitInfo(serviceRecruitPublishParam, companyDetails.getId());
        return new Result(i);
    }

    @ControllerLog(doAction = "编辑/下架 企业招聘信息")
    @ApiOperation(value = "编辑/下架 企业招聘信息", notes = "编辑/下架 企业招聘信息")
    @RequestMapping(value = "/editRecruitInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/editRecruitInfo")
    public Result<Integer> editRecruitInfo(@Validated @RequestBody ServiceRecruitEditParam serviceRecruitEditParam){
        Assert.notNull(serviceRecruitEditParam.getId(),RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        companyService.getCompanyDetailByAccountOrId(user.getAccount());
        int i = recruitService.editRecruitInfo(serviceRecruitEditParam);
        return new Result(i);
    }

    @ControllerLog(doAction = "根据招聘ID删除企业招聘条目")
    @ApiOperation(value = "根据招聘ID删除企业招聘条目", notes = "根据招聘ID删除企业招聘条目")
    @RequestMapping(value = "/delRecruit",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/delRecruit")
    public Result<Integer> delRecruit(@Validated @RequestBody @ApiParam(name="recruitId", value = "招聘ID", required = true) String recruitId){
        Assert.notNull(recruitId,RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        return new Result(recruitService.delRecruitById(recruitId));
    }

}
