package com.jn.miniprogram.register.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.user.model.RegisterInfoParam;
import com.jn.miniprogram.register.service.MiniprogramRegisterService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.userjoin.service.UserJoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * 微信小程序注册绑定
 * @Author: yangph
 * @Date: 2019/3/11 20:09
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "微信小程序注册绑定")
@RestController
@RequestMapping("/guest/miniProgram/miniProgramRegisterController")
public class MiniProgramRegisterController extends BaseController {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniProgramRegisterController.class);

    @Autowired
    private MiniprogramRegisterService miniprogramRegisterService;

    @Autowired
    private UserJoinService userJoinService;

    @ControllerLog(doAction = "判断OpenId是否已绑定")
    @ApiOperation(value = "判断OpenId是否已绑定", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/isBindingOpenId")
    public Result isBindingOpenId(@ApiParam(value = "微信用户openId" ,required = true) @RequestParam("openId")String openId) {
        Assert.notNull(openId,MiniProgramRegisterExceptionEnum.WE_CHAT_OPENID_NOT_NULL.getMessage());
        int bindingOpenId = miniprogramRegisterService.isBindingOpenId(openId);
        return new Result(bindingOpenId);
    }

    @ControllerLog(doAction = "发送短信验证码")
    @ApiOperation(value = "发送短信验证码", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getCode")
    public Result getCode(@ApiParam(value = "手机号" ,required = true) @RequestParam("phone")String phone) {
        Assert.notNull(phone, MiniProgramRegisterExceptionEnum.PASSWORD_CANNOT_EMPTY.getMessage());
        userJoinService.getCode(phone);
        return new Result();
    }


    @ControllerLog(doAction = "注册并绑定")
    @ApiOperation(value = "注册并绑定", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/registerAndBinding")
    public Result registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam) {
        int responseNum = miniprogramRegisterService.registerAndBinding(registerInfoParam);
        logger.info("-----注册并绑定数据响应条数：{}条----",responseNum);
        return new Result(responseNum);
    }
}
