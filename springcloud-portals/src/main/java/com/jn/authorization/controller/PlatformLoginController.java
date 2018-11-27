package com.jn.authorization.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.model.UserLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 平台登录
 *
 * @Author: yangph
 * @Date: 2018/11/21 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "门户，微信公众号，微信小程序,app登录")
@RestController
public class PlatformLoginController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(PlatformLoginController.class);

    @Autowired
    private SystemClient client;

    @ControllerLog(doAction = "登录")
    @ApiOperation(value = "登录", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/login")
    public Result platformLoginPost(@RequestBody @Validated UserLogin userLogin) {
        //调用系统登录接口，通过shiro框架进行登录
        Result<String> data = client.login(userLogin);
        if (!GlobalConstants.SUCCESS_CODE.equals(data.getCode())) {
            return data;
        }
        //获取用户信息
        User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
        //TODO 对用户信息进行扩展封装，返回
        return new Result(shiroUser);
    }
}
