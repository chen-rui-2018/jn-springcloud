package com.jn.enterprise.company.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.company.model.ServiceCompany;
import com.jn.enterprise.company.enums.CompanyExceptionEnum;
import com.jn.enterprise.company.model.ServiceRecruitEditParam;
import com.jn.enterprise.company.model.ServiceRecruitParam;
import com.jn.enterprise.company.model.ServiceRecruitPublishParam;
import com.jn.enterprise.company.model.ServiceRecruitUnderParam;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.company.service.RecruitService;
import com.jn.enterprise.company.vo.RecruitVO;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:20:58
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-我的企业-招聘管理")
@RestController
@RequestMapping("/enterprise/RecruitController")
public class RecruitController extends BaseController {

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "招聘列表（用户中心）")
    @ApiOperation(value = "招聘列表（用户中心）", notes = "分页查询[默认15条]，日期查询请传开始和结束日期[只传一个忽略]")
    @RequestMapping(value = "/getRecruitList",method = RequestMethod.GET)
    @RequiresPermissions("/enterprise/RecruitController/getRecruitList")
    public Result<PaginationData<List<RecruitVO>>> getRecruitList(@Validated ServiceRecruitParam serviceRecruitParam){
        User user = checkUserValid();
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        serviceRecruitParam.setComId(company.getId());
        return new Result(recruitService.getRecruitList(serviceRecruitParam, null));
    }

    @ControllerLog(doAction = "发布招聘信息")
    @ApiOperation(value = "发布招聘信息（app/pc-发布招聘）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/publishRecruitInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/publishRecruitInfo")
    public Result<Integer> publishRecruitInfo(@Validated @RequestBody ServiceRecruitPublishParam serviceRecruitPublishParam){
        User user = checkUserValid();
        ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        return new Result(recruitService.publishRecruitInfo(serviceRecruitPublishParam, company, user));
    }

    @ControllerLog(doAction = "编辑招聘信息")
    @ApiOperation(value = "编辑招聘信息（app/pc-编辑招聘）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/editRecruitInfo",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/editRecruitInfo")
    public Result<Integer> editRecruitInfo(@Validated @RequestBody ServiceRecruitEditParam serviceRecruitEditParam){
        User user = checkUserValid();
        // 只有企业管理员有权限编辑
        companyService.getCompanyDetailByAccountOrId(user.getAccount());
        return new Result(recruitService.editRecruitInfo(serviceRecruitEditParam, user));
    }

    @ControllerLog(doAction = "上/下架招聘信息")
    @ApiOperation(value = "上/下架招聘信息（pc-上下架招聘）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/underRecruit",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/underRecruit")
    public Result<Integer> underRecruit(@Validated @RequestBody ServiceRecruitUnderParam serviceRecruitUnderParam){
        User user = checkUserValid();
        // 园区管理员和企业管理员都可以上下架
        // companyService.getCompanyDetailByAccountOrId(user.getAccount());
        return new Result(recruitService.underRecruit(serviceRecruitUnderParam, user));
    }

    @ControllerLog(doAction = "删除招聘信息")
    @ApiOperation(value = "删除招聘信息（pc-删除招聘）", notes = "返回数据响应条数，正常情况为1")
    @RequestMapping(value = "/delRecruit",method = RequestMethod.POST)
    @RequiresPermissions("/enterprise/RecruitController/delRecruit")
    public Result<Integer> delRecruit(String recruitId){
        Assert.notNull(recruitId, CompanyExceptionEnum.PARAM_IS_NULL.getMessage());
        User user = checkUserValid();

        // 园区管理员才有删除权限
        // ServiceCompany company = companyService.getCompanyDetailByAccountOrId(user.getAccount());
        // RecruitDetailsVO recruitDetails = recruitService.getRecruitDetailsById(recruitId);
        // Assert.notNull(recruitDetails,RecruitExceptionEnum.RECRUIT_INFO_IS_NOT_EXIST.getMessage());
        // Assert.isTrue(recruitDetails.getComId().equals(company.getId()),RecruitExceptionEnum.RECRUIT_USER_NOT_ENTERPRISE_ADMIN.getMessage());
        return new Result(recruitService.delRecruitById(recruitId, user));
    }


    /**
     * 判断当前账号是否有效
     * @return
     */
    public User checkUserValid() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user == null){
            throw new JnSpringCloudException(CompanyExceptionEnum.NETWORK_ANOMALY);
        }
        return user;
    }

}
