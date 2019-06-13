package com.jn.authorization.controller;

import com.jn.authorization.LoginService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.common.util.encryption.EncryptUtil;
import com.jn.system.log.annotation.ControllerLog;
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
 * 登录
 *
 * @author： fengxh
 * @date： Created on 2018/9/20 15:31
 * @version： v1.0
 * @modified By: shenph
 */
@Api(tags = "登录鉴权管理")
@RestController
public class LoginController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @ControllerLog(doAction = "登录")
    @ApiOperation(value = "登录", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/login")
    public Result<String> loginPost(@RequestBody @Validated UserLogin userLogin) {
        loginService.login(userLogin, Boolean.FALSE);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }

    @ControllerLog(doAction = "退出")
    @ApiOperation(value = "退出", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/logoutJSON")
    public Result logoutJSON() {
        loginService.logoutJSON();
        return new Result();
    }

    @ControllerLog(doAction = "authLogin")
    @ApiOperation(value = "authLogin",
            notes = "ibps oauth 自动登录使用", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/authLogin")
    public Result authLogin() {
        logger.info("用户：{}，进行authLogin获取token", SecurityUtils.getSubject().getSession().getId());
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }

    @ControllerLog(doAction = "noPwdLogin")
    @ApiOperation(value = "noPwdLogin",
            notes = "ibps 调用 swagger接口，登录鉴权", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/noPwdLogin")
    public Result noPwdLogin(@RequestBody @Validated UserLogin userLogin) {
        if (userLogin.getPassword().equals(EncryptUtil.encryptSha256(userLogin.getAccount()))) {
            userLogin.setPassword("");
            loginService.login(userLogin, Boolean.TRUE);
            return new Result(SecurityUtils.getSubject().getSession().getId());
        }
        return new Result();
    }


}
