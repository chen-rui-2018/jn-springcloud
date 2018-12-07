package com.jn.portals.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.portals.user.service.SmsService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送短信验证码
 * @Author: yangph
 * @Date: 2018/12/3 15:10
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "发送短信验证码")
@RestController
public class SmsController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(SmsController.class);

    @Autowired
    private SmsService smsService;


    @ControllerLog(doAction = "发送短信验证码")
    @ApiOperation(value = "发送短信验证码", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/guest/sendTextMessage")
    public Result sendTextMessage(String phone) {
        //todo:调用消息接口发送短信验证码
        //模拟生成验证码
        String nextInt = RandomUtils.nextInt(100000)+100000+"";
        logger.info("短信验证码是：{}",nextInt);
        Result result=smsService.saveSmsCode(phone,nextInt);
        return  result;
    }
}
