package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.enterprise.enums.AdvisorExceptionEnum;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorListParam;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorListInfo;
import com.jn.enterprise.servicemarket.advisor.model.ServiceEvaluationParam;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.enterprise.servicemarket.advisor.vo.AdvisorDetailsVo;
import com.jn.enterprise.servicemarket.comment.model.ServiceRating;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务顾问
 * @Author: yangph
 * @Date: 2019/2/12 15:16
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "服务顾问")
@RestController
@RequestMapping(value = "/guest/serviceMarket/advisorController")
public class AdvisorController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorController.class);

    @Autowired
    private AdvisorService advisorService;


    @ControllerLog(doAction = "服务顾问列表")
    @ApiOperation(value = "服务顾问列表",notes = "查询条件--活动ID，关键字,分页页码及行数，不传页码行数默认查询前15条")
    @RequestMapping(value = "/getServiceConsultantList",method = RequestMethod.GET)
    public Result<PaginationData<List<AdvisorListInfo>>>getServiceConsultantList(AdvisorListParam advisorListParam){
        PaginationData serviceConsultantList = advisorService.getServiceConsultantList(advisorListParam, Boolean.TRUE);
        return  new Result(serviceConsultantList);
    }

    @ControllerLog(doAction = "服务顾问详情")
    @ApiOperation(value = "服务顾问详情 (app顾问详情+顾问信息)",notes="根据顾问账号获取顾问详情")
    @RequestMapping(value = "/getServiceAdvisorInfo",method = RequestMethod.GET)
    public Result<AdvisorDetailsVo> getServiceAdvisorInfo(@ApiParam(value = "顾问账号" ,required = true,example = "wangsong")@RequestParam("advisorAccount") String advisorAccount){
        Assert.notNull(advisorAccount, AdvisorExceptionEnum.ADVISOR_ACCOUNT_NOT_NULL.getMessage());
        AdvisorDetailsVo advisorDetailsVo = advisorService.getServiceAdvisorInfo(advisorAccount);
        return  new Result(advisorDetailsVo);
    }

    @ControllerLog(doAction = "服务评价")
    @ApiOperation(value = "服务评价",notes="根据顾问账号和评价类型获取顾问的评价")
    @RequestMapping(value = "/getServiceRatingInfo",method = RequestMethod.GET)
    public Result<PaginationData<List<ServiceRating>>> getServiceRatingInfo(@Validated ServiceEvaluationParam serviceEvaluationParam){
        PaginationData serviceRatingInfo = advisorService.getServiceRatingInfo(serviceEvaluationParam);
        return  new Result(serviceRatingInfo);
    }

}
