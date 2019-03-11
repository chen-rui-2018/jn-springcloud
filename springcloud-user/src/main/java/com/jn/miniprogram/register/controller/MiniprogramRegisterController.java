package com.jn.miniprogram.register.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.miniprogram.register.service.MiniprogramRegisterService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/miniprogram/miniprogramRegisterController")
public class MiniprogramRegisterController extends BaseController {
    /**
     * 日志组件
     */
    private static final Logger logger= LoggerFactory.getLogger(MiniprogramRegisterController.class);

    @Autowired
    private MiniprogramRegisterService miniprogramRegisterService;

    @ControllerLog(doAction = "判断OpenId是否已绑定")
    @ApiOperation(value = "判断OpenId是否已绑定", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/bindingOpenId")
    @RequiresPermissions("/miniprogram/miniprogramRegisterController/isBindingOpenId")
    public Result isBindingOpenId(@ApiParam(value = "微信用户OpenId" ,required = true) @RequestParam("advisorAccount")String openId) {
        Assert.notNull(openId,"微信用户OpenId不能为空");
        int bindingOpenId = miniprogramRegisterService.isBindingOpenId(openId);
        return new Result(bindingOpenId);
    }

}
