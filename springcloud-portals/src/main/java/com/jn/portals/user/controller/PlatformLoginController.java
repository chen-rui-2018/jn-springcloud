package com.jn.portals.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.model.UserLogin;
import com.jn.system.model.UserNoPasswordLogin;
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
        //1、各自业务进行认证，并获取用户账号
        String account = "huangchen";
        //2、调用系统登录接口
        //Result<String> data = client.login(userLogin);
        //2、免密登录
        UserNoPasswordLogin u2 = new UserNoPasswordLogin();
        u2.setAccount(account);
        Result<String> data = client.noPasswordLogin(u2);

        if (!GlobalConstants.SUCCESS_CODE.equals(data.getCode())) {
            return data;
        }
        //3、通过获取用户信息
        Result<User> user = client.getUser(new User(account));
        //token
        data.getData();

        //4、对用户信息进行扩展封装，token 和用户信息 一并返回返回
        return user;
    }

    @ControllerLog(doAction = "测试")
    @ApiOperation(value = "测试", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/test")
    public Result test() {
        //获取用户信息，请求时前端需要带上token
        User shiroUser = (User) SecurityUtils.getSubject().getPrincipal();
        //TODO 对用户信息进行扩展封装，返回
        return new Result(shiroUser);
    }
}
