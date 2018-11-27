package com.jn.authorization.controller;

import com.jn.authorization.api.PlatformClient;
import com.jn.authorization.enums.PlatformExcepitonEnum;
import com.jn.authorization.model.PlatformUser;
import com.jn.authorization.model.PlatformUserLogin;
import com.jn.authorization.service.PlatformLoginService;
import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.WebSessionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 平台登录
 * @Author: yangph
 * @Date: 2018/11/21 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags="门户，微信公众号，微信小程序,app登录")
@RestController
public class PlatformLoginController extends BaseController {
    private static final AtomicInteger INSTANCE_COUNT = new AtomicInteger();
    @Autowired
    private PlatformClient platformClient;

    @Autowired
    private PlatformLoginService platformLoginService;

    @ControllerLog(doAction = "登录")
    @ApiOperation(value = "登录", httpMethod = "POST", response= Result.class)
    @RequestMapping(value = "/login")
    public Result<String> platformLoginPost(@RequestBody  @Validated PlatformUserLogin userLogin, HttpServletRequest request, HttpServletResponse response) {
        Result<String> result = new Result<>();
        //调用系统登录接口，通过shiro框架进行登录
        Result<String> data = platformClient.loginPost(userLogin);
        String sessionId=data.getData();

        if(sessionId==null){
            result.setCode(PlatformExcepitonEnum.ACCOUNT_OR_PASSWORD_UNKNOWN.getCode());
            result.setResult(PlatformExcepitonEnum.ACCOUNT_OR_PASSWORD_UNKNOWN.getMessage());
            return  result;
        }
        SessionKey key= new WebSessionKey(sessionId, request ,response);
        Session session = SecurityUtils.getSecurityManager().getSession(key);
        //默认key
        String principalsSessionKey = DefaultSubjectContext.PRINCIPALS_SESSION_KEY;
        Object obj = session.getAttribute(principalsSessionKey);
        SimplePrincipalCollection coll=(SimplePrincipalCollection)obj;
        //获取当前登录用户信息
        User user= (User)coll.getPrimaryPrincipal();

        //根据用户id(userId)获取用户的拓展信息
        PlatformUser platformUser=platformLoginService.platformLoginPost(user.getId());
        //更新session中的用户基础信息
        session.setAttribute(principalsSessionKey,platformUser);
        platformUser.setToken(sessionId);
        response.addCookie(new Cookie("shiroSessionId",sessionId));
        response.addCookie(new Cookie("rememberMe", "deleteMe"));
        return new Result(platformUser);
    }

    //todo:添加微信登录接口

    @RequestMapping(value = "/getUser")
    public Result<String> getUser() {
        Subject subject = SecurityUtils.getSubject();
        Object principal = subject.getPrincipal();
        return new Result<String>(principal.toString());
    }
}
