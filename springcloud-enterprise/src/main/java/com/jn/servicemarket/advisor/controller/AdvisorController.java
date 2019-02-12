package com.jn.servicemarket.advisor.controller;

import com.jn.common.controller.BaseController;
import com.jn.servicemarket.advisor.service.AdvisorService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/activity/activityApply")
public class AdvisorController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(AdvisorController.class);

    @Autowired
    private AdvisorService advisorService;

}
