package com.jn.authorization.controller;

import com.jn.authorization.LoginService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By:
 */

@Api(tags = "鉴权管理")
@RestController
public class LoginController extends BaseController  {

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录", httpMethod = "POST", response=Result.class)
    @RequestMapping(value = "/login")
    public Result loginPost(@Validated User user) {
        loginService.login(user);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }

    @ApiOperation(value = "退出", httpMethod = "POST", response=Result.class)
    @RequestMapping(value = "/logoutJSON")
    public Result logoutJSON() {
        loginService.logoutJSON();
        return new Result();
    }

}