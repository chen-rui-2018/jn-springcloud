package com.jn.enterprise.propaganda.controller;

import com.jn.common.controller.BaseController;
import com.jn.enterprise.propaganda.service.BusinessPromotionService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangph
 * @Date: 2019/4/18 9:39
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "用户中心--企业宣传")
@RestController
@RequestMapping("/propaganda/businessPromotionController")
public class BusinessPromotionController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(BusinessPromotionController.class);

    @Autowired
    private BusinessPromotionService businessPromotionService;

}
