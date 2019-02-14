package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.servicemarket.advisor.model.AdvisorInquiryInfo;
import com.jn.enterprise.servicemarket.advisor.service.AdvisorService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

}
