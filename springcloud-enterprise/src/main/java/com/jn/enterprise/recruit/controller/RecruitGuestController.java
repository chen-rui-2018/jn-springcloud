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
@RequestMapping("/guest/RecruitController")
public class RecruitGuestController extends BaseController {

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "查询企业招聘信息")
    @ApiOperation(value = "查询企业招聘信息", notes = "查询企业招聘信息")
    @RequestMapping(value = "/getRecruitList",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceCompany>>> getRecruitList(@Validated ServiceRecruitParam serviceRecruitParam){
        if(StringUtils.isNotEmpty(serviceRecruitParam.getComId())) {
            companyService.getCompanyDetailByAccountOrId(serviceRecruitParam.getComId());
        }
        return new Result(recruitService.getRecruitList(serviceRecruitParam));
    }

    @ControllerLog(doAction = "查看企业招聘信息详情")
    @ApiOperation(value = "查看企业招聘信息详情", notes = "查看企业招聘信息详情")
    @RequestMapping(value = "/viewRecruitDetails",method = RequestMethod.GET)
    public Result<RecruitDetailsVO> addRecruitClick(@Validated @RequestParam @ApiParam(name="recruitId",value = "招聘ID", required = true) String recruitId){
        Assert.notNull(recruitId,RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        return new Result(recruitService.getRecruitDetailsById(recruitId));
    }

}
