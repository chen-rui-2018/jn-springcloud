package com.jn.miniprogram.base.controller;

import com.jn.common.model.Result;
import com.jn.miniprogram.base.model.WxMiniGetTokenParam;
import com.jn.miniprogram.base.model.WxMiniRegisterUserGetTokenParam;
import com.jn.miniprogram.base.service.WxMiniUserService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信小程序用户接口
 *
 * @Author： cm
 * @Date： Created on 2019/3/11 17:42
 * @Version： v1.0
 * @Modified By:
 */
@Api(tags = "小程序获取TOKEN")
@RestController
@RequestMapping("/guest/mini/user")
public class WxMiniUserController {

    @Autowired
    private WxMiniUserService wxMiniUserService;

    /**
     * 获取token
     */
    @ControllerLog(doAction = "1、小程序登陆凭证校验,2、新增/修改微信用户信息,3、已绑定账号则返回token，未绑定token为空")
    @ApiOperation(value = "登陆凭证校验,返回Token", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/checkCodeAndGetToken")
    public Result<String> checkCodeAndGetToken(@Validated @RequestBody WxMiniGetTokenParam wxMiniGetTokenParam) {
        return wxMiniUserService.checkCodeAndGetToken(wxMiniGetTokenParam);
    }

    @ControllerLog(doAction = "1、小程序登陆凭证校验,2、注册绑定微信用户信息,3、返回token")
    @ApiOperation(value = "注册绑定微信用户信息，返回token", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/registerUserAndGetToken")
    public Result<String> registerUserAndGetToken(@Validated @RequestBody WxMiniRegisterUserGetTokenParam wxMiniRegisterUserGetTokenParam) {
        return wxMiniUserService.registerUserAndGetToken(wxMiniRegisterUserGetTokenParam);
    }

}
