package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorInquiryInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceEvaluationQuery;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务顾问
 * @Author: yangph
 * @Date: 2019/2/12 15:16
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务顾问")
@RestController
public class AdvisorController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorController.class);

    @Autowired
    private AdvisorService advisorService;


    @ControllerLog(doAction = "服务顾问列表")
    @ApiOperation(value = "服务顾问列表", httpMethod = "POST", response = Result.class
                ,notes = "查询条件--活动ID，关键字,分页页码及行数，不传页码行数默认查询前15条")
    @RequestMapping(value = "/guest/advisor/getServiceConsultantList")
    public Result getServiceConsultantList(@RequestBody AdvisorInquiryInfo advisorInquiryInfo){
        PaginationData serviceConsultantList = advisorService.getServiceConsultantList(advisorInquiryInfo, Boolean.TRUE);
        return  new Result(serviceConsultantList);
    }

    @ControllerLog(doAction = "服务顾问详情")
    @ApiOperation(value = "服务顾问详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/advisor/getServiceAdvisorInfo")
    public Result getServiceAdvisorInfo(@ApiParam(value = "顾问账号" ,required = true) String advisorAccount){
        logger.warn("顾问详情查询{}",AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount);
        return  new Result(advisorDetailsVo);
    }

    @ControllerLog(doAction = "服务评价")
    @ApiOperation(value = "服务评价", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/advisor/getServcieRatingInfo")
    public Result getServcieRatingInfo(@RequestBody @Validated ServiceEvaluationQuery serviceEvaluationQuery){
        PaginationData servcieRatingInfo = advisorService.getServcieRatingInfo(serviceEvaluationQuery);
        return  new Result(servcieRatingInfo);
    }

}
