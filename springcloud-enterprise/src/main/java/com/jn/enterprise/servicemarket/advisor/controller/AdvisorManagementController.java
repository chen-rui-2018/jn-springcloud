package com.jn.enterprise.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 顾问管理
 * @Author: yangph
 * @Date: 2019/2/19 9:40
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "顾问管理")
@RestController
@RequestMapping(value = "/advisor/advisorManagementController")
public class AdvisorManagementController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorManagementController.class);



    
    @ControllerLog(doAction = "邀请顾问")
    @ApiOperation(value = "邀请顾问", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/inviteAdvisor")
    public Result inviteAdvisor(@ApiParam(value = "注册手机/邮箱" ,required = true) String regestAccount){
        return  new Result();
    }
}

