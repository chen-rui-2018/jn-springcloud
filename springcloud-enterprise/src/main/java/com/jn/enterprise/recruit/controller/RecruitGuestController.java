package com.jn.enterprise.recruit.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.common.util.StringUtils;
import com.jn.enterprise.company.service.CompanyService;
import com.jn.enterprise.recruit.enums.RecruitExceptionEnum;
import com.jn.enterprise.recruit.model.ServiceRecruitParam;
import com.jn.enterprise.recruit.service.RecruitService;
import com.jn.enterprise.recruit.vo.RecruitDetailsVO;
import com.jn.enterprise.recruit.vo.RecruitVO;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author： huxw
 * @date： Created on 2019-3-29 15:20:58
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "用户中心-招聘管理")
@RestController
@RequestMapping("/guest/RecruitController")
public class RecruitGuestController extends BaseController {

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private CompanyService companyService;

    @ControllerLog(doAction = "招聘列表")
    @ApiOperation(value = "招聘列表", notes = "分页查询[默认15条]，日期查询请传开始和结束日期[只传一个忽略]")
    @RequestMapping(value = "/getRecruitList",method = RequestMethod.GET)
    public Result<PaginationData<List<RecruitVO>>> getRecruitList(@Validated ServiceRecruitParam serviceRecruitParam){
        if(StringUtils.isNotEmpty(serviceRecruitParam.getComId())) {
            companyService.getCompanyDetailByAccountOrId(serviceRecruitParam.getComId());
        }
        return new Result(recruitService.getRecruitList(serviceRecruitParam));
    }

    @ControllerLog(doAction = "招聘详情")
    @ApiOperation(value = "招聘详情", notes = "必传招聘ID")
    @RequestMapping(value = "/viewRecruitDetails",method = RequestMethod.GET)
    public Result<RecruitDetailsVO> addRecruitClick(@Validated @RequestParam @ApiParam(name="recruitId",value = "招聘ID", required = true) String recruitId){
        Assert.notNull(recruitId,RecruitExceptionEnum.RECRUIT_ID_IS_NULL.getMessage());
        return new Result(recruitService.getRecruitDetailsById(recruitId));
    }

}
