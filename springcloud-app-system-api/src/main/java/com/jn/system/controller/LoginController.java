package com.jn.system.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.system.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
public class LoginController extends BaseController  {

    public static String INDEX= "index";

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/index")
    public Result index() {
        return new Result(INDEX,null);
    }

    @RequestMapping(value = "/login")
    public Object loginPost(String username, String password) {
        loginService.loginPost(username, password);
        return new Result(SecurityUtils.getSubject().getSession().getId());
    }

    @RequestMapping(value = "/logoutJSON")
    public Result logoutJSON() {
        loginService.logoutJSON();
        return new Result();
    }

}
