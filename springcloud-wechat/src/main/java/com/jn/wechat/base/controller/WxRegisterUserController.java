package com.jn.wechat.base.controller;

import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.wechat.base.service.WxRegisterUserService;
import com.jn.wechat.model.WxUserRegisterBindingParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信服务号用户绑定注册
 *
 * @Author： cm
 * @Date： Created on 2019/6/25 21:22
 * @Version： v1.0
 * @Modified By:
 */
@Api(tags = "微信服务号绑定手机号码")
@RestController
@RequestMapping("/guest/wx/user")
public class WxRegisterUserController {

    @Autowired
    private WxRegisterUserService wxRegisterUserService;

    /**
     * 微信服务号绑定手机号码,注册用户信息
     */
    @ControllerLog(doAction = "微信服务号绑定手机号码")
    @ApiOperation(value = "微信服务号绑定手机号码", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/registerBinding")
    public Result<String> registerBinding(@Validated @RequestBody WxUserRegisterBindingParam wxUserRegisterBindingParam) {
        wxRegisterUserService.registerBinding(wxUserRegisterBindingParam);
        return new Result();
    }

}
