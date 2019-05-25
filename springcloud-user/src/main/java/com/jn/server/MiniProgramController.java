package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.miniprogram.register.service.MiniProgramRegisterService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.user.api.MiniProgramRegisterClient;
import com.jn.user.enums.MiniProgramRegisterExceptionEnum;
import com.jn.user.model.RegisterInfoParam;
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
 * @Date: 2019/3/19 14:09
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "微信小程序注册绑定")
@RestController
@RequestMapping("/api/miniProgramRegister")
public class MiniProgramController extends BaseController implements MiniProgramRegisterClient {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniProgramController.class);

    @Autowired
    private MiniProgramRegisterService miniprogramRegisterService;


    @ControllerLog(doAction = "判断OpenId是否已绑定")
    @ApiOperation(value = "判断OpenId是否已绑定")
    @RequestMapping(value = "/isBindingAccountByOpenId",method = RequestMethod.POST)
    @Override
    public Result isBindingAccountByOpenId(@RequestBody @Validated WeChatRequestParam weChatRequestParam) {
        return new Result(miniprogramRegisterService.isBindingAccountByOpenId(weChatRequestParam));
    }



    @ControllerLog(doAction = "注册并绑定")
    @ApiOperation(value = "注册并绑定", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/registerAndBinding")
    @Override
    public Result registerAndBinding(@RequestBody @Validated RegisterInfoParam registerInfoParam) {
        return new Result(miniprogramRegisterService.registerAndBinding(registerInfoParam));
    }
}
