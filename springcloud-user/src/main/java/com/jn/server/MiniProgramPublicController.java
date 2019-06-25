package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.miniprogram.register.enums.RegisterTypeEnum;
import com.jn.miniprogram.register.service.MiniProgramRegistersService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.MiniProgramRegisterClient;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.model.RegisterInfoParam;
import com.jn.user.model.WeChatRequestParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 微信公众号注册绑定
 * @Author: yangph
 * @Date: 2019/3/19 14:09
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "微信公众号注册绑定")
@RestController
@RequestMapping("/api/miniProgramPublicController")
public class MiniProgramPublicController extends BaseController implements MiniProgramRegisterClient {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniProgramPublicController.class);

    @Autowired
    private MiniProgramRegistersService miniprogramRegistersService;


    @ControllerLog(doAction = "判断OpenId是否已绑定")
    @ApiOperation(value = "判断OpenId是否已绑定")
    @RequestMapping(value = "/isBindingAccountByOpenId",method = RequestMethod.POST)
    @Override
    public Result<String> isBindingAccountByOpenId(@RequestBody @Validated WeChatRequestParam weChatRequestParam) {
        logger.info("----进入判断OpenId是否已绑定API,入参：{}----",weChatRequestParam.toString());
        return new Result(miniprogramRegistersService.isBindingAccountByOpenId(weChatRequestParam, RegisterTypeEnum.PUBLIC_NUMBER));
    }



    @ControllerLog(doAction = "注册并绑定")
    @ApiOperation(value = "注册并绑定", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/registerAndBinding")
    @Override
    public Result<String> registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam) {
        logger.info("----进入注册并绑定的API,入参：{}----",registerInfoParam.toString());
        return new Result(miniprogramRegistersService.registerAndBinding(registerInfoParam,RegisterTypeEnum.PUBLIC_NUMBER));
    }

    @ControllerLog(doAction = "根据账号获取openId")
    @ApiOperation(value = "根据账号获取openId", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getOpenIdByAccount")
    @Override
    public Result<String> getOpenIdByAccount(@RequestBody String account) {
        Assert.notNull(account, MiniProgramRegisterExceptionEnum.PHONE_NUMBER_CANNOT_EMPTY.getMessage());
        logger.info("----进入根据账号获取openId的API,入参：{}----",account);
        return new Result(miniprogramRegistersService.getOpenIdByAccount(account,RegisterTypeEnum.PUBLIC_NUMBER));
    }
}
