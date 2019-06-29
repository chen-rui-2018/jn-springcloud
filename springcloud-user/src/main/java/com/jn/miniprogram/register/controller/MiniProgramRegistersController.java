package com.jn.miniprogram.register.controller;

import com.codingapi.tx.annotation.TxTransaction;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.miniprogram.register.enums.RegisterTypeEnum;
import com.jn.miniprogram.register.service.MiniProgramRegistersService;
import com.jn.user.model.RegisterInfoParam;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.model.WeChatRequestParam;
import com.jn.user.userjoin.service.UserJoinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
public class MiniProgramRegistersController extends BaseController {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniProgramRegistersController.class);

    @Autowired
    private MiniProgramRegistersService miniprogramRegistersService;

    @Autowired
    private UserJoinService userJoinService;

    @ControllerLog(doAction = "判断OpenId是否已绑定账号")
    @ApiOperation(value = "判断OpenId是否已绑定账号")
    @RequestMapping(value = "/isBindingAccountByOpenId",method = RequestMethod.POST)
    public Result isBindingOpenId(@RequestBody @Validated WeChatRequestParam weChatRequestParam) {
        return new Result(miniprogramRegistersService.isBindingAccountByOpenId(weChatRequestParam, RegisterTypeEnum.SMALL_PROGRAM));
    }

    @ControllerLog(doAction = "根据OpenId判断OpenId是否已绑定")
    @ApiOperation(value = "根据OpenId判断OpenId是否已绑定")
    @RequestMapping(value = "/openIdIsBindingAccount",method = RequestMethod.POST)
    public Result<String> openIdIsBindingAccount(@RequestBody String openId) {
        logger.info("----进入判断OpenId是否已绑定API,入参：{}----",openId);
        Assert.notNull(openId, MiniProgramRegisterExceptionEnum.OPEN_ID_IS_NOT_NULL.getMessage());
        return new Result(miniprogramRegistersService.openIdIsBindingAccount(openId, RegisterTypeEnum.SMALL_PROGRAM));
    }

    @ControllerLog(doAction = "发送短信验证码")
    @ApiOperation(value = "发送短信验证码")
    @RequestMapping(value = "/getCode",method = RequestMethod.GET)
    public Result getCode(@ApiParam(value = "手机号" ,required = true) @RequestParam("phone")String phone) {
        Assert.notNull(phone, MiniProgramRegisterExceptionEnum.PASSWORD_CANNOT_EMPTY.getMessage());
        userJoinService.getCode(phone);
        return new Result();
    }

    @TxTransaction(isStart = true)
    @ControllerLog(doAction = "注册并绑定")
    @ApiOperation(value = "注册并绑定",notes = "注册绑定成功后返回注册的手机号")
    @RequestMapping(value = "/registerAndBinding",method = RequestMethod.POST)
    public Result<String> registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam) {
        return new Result(miniprogramRegistersService.registerAndBinding(registerInfoParam, RegisterTypeEnum.SMALL_PROGRAM));
    }
}
