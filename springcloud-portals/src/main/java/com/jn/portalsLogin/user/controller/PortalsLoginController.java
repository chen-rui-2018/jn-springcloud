package com.jn.portalsLogin.user.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.GlobalConstants;
import com.jn.common.util.cache.RedisCache;
import com.jn.portalsLogin.model.PortalUserLogin;
import com.jn.portalsLogin.model.PortalsUser;
import com.jn.portalsLogin.user.service.PortalsLoginDataCheckService;
import com.jn.portalsLogin.user.service.PortalsLoginService;
import com.jn.system.api.SystemClient;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.system.model.UserLogin;
import com.jn.system.model.UserNoPasswordLogin;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 平台登录
 * @Author: yangph
 * @Date: 2018/11/21 15:50
 * @Version v1.0
 * @modified By:
 */
@Api(tags = "门户，微信公众号，微信小程序,app登录")
@RestController
public class PortalsLoginController extends BaseController {
    /**
     * 日志组件
     */
    private static Logger logger = LoggerFactory.getLogger(PortalsLoginController.class);

    @Autowired
    private SystemClient client;

    @Autowired
    private PortalsLoginService loginService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private PortalsLoginDataCheckService portalsLoginDataCheckService;

    /**
     * 用户扩展信息的resis的key
     */
    @Value(value = "${user.outreach.information.key}")
    private String redisUserKey;

    /**
     * 用户扩展信息的resis的过期时间
     */
    @Value(value = "${user.outhrache.information.expire}")
    private int expire;

    /**
     * 用户扩展信息的resis的前缀
     */
    @Value(value = "${user.outhrache.information.prefix}")
    private String prefix;

    /**
     * 登录模式：账号密码登录、手机号验证码登录、微信登录、app登录
     */
    @Value(value = "${LOGIN_TYPE_WEB}")
    private String loginTypeWeb;
    @Value(value = "${LOGIN_TYPE_SMS}")
    private String loginTypeSms;
    @Value(value = "${LOGIN_TYPE_WECHAT}")
    private String loginTypeWechat;
    @Value(value = "${LOGIN_TYPE_APP}")
    private String loginTypeApp;


    @ControllerLog(doAction = "登录")
    @ApiOperation(value = "登录", httpMethod = "POST", response = Result.class,
                 notes ="account:账号（账号、手机号、邮箱）  passwor:密码 (短信验证码)    verifyKey：账号密码登录需要传递滑动验证key"    +
                         "logintype：账号密码登录传web  手机号验证码登录传sms   微信登录传wechat  app登录传app" )
    @RequestMapping(value = "/login")
    public Result portalsLoginPost(@RequestBody @Validated PortalUserLogin portalUserLogin) {
        //1、各自业务进行认证，并获取用户账号
        //1.1、登录用户信息数据校验
        Result result= portalsLoginDataCheckService.loginDataCheck(portalUserLogin);
        if (!GlobalConstants.SUCCESS_CODE.equals(result.getCode())) {
            return result;
        }
        //1.2.通过用户账号获取用户扩展信息
        List<PortalsUser> userList = loginService.getUserOutreachInfo(portalUserLogin.getAccount());
        if (userList == null || userList.size() == 0) {
            return new Result();
        }
        PortalsUser portalsUser=userList.get(0);
        String account =portalsUser.getAccount();
        //2.1、账号+密码登录、app登录调用系统登录接口
        Result<String> data=new Result<>();
        if(loginTypeWeb.equals(portalUserLogin.getLogintype())
                || loginTypeApp.equals(portalUserLogin.getLogintype())){
            UserLogin userLogin=new UserLogin();
            userLogin.setAccount(account);
            userLogin.setPassword(portalUserLogin.getPassword());
            data = client.login(userLogin);
        }else if(loginTypeSms.equals(portalUserLogin.getLogintype())){
            //2.2、手机号+短信验证码登录，免密登录
            UserNoPasswordLogin u2 = new UserNoPasswordLogin();
            u2.setAccount(account);
            data = client.noPasswordLogin(u2);
        }else if(loginTypeWechat.equals(portalUserLogin.getLogintype())){
            //2.3、微信登录调用微信登录接口
            //todo:微信相关验证、微信登录接口

        }
        //若登录失败，直接返回结果
        if (!GlobalConstants.SUCCESS_CODE.equals(data.getCode())) {
            return data;
        }
        //3、获取token
        String shiroSessionId = data.getData();
        //4.获取用户基础信息
        Result<User> user = client.getUser(new User(account));
        //把用户基础信息中特有的信息（拓展表没有的）拷贝到拓展信息
        BeanUtils.copyProperties(user, portalsUser);
        //5、把用户拓展信息写入redis中
        logger.info("登录api把用户扩展信息写入redis中保存，用户参数{}",portalsUser.toString());
        RedisCache cache=new RedisCache(redisTemplate, prefix, expire);
        cache.put(redisUserKey+"_"+ portalsUser.getAccount(), portalsUser);
        //6、把token 和用户信息 一并返回
        portalsUser.setShiroSessionId(shiroSessionId);
        result.setData(portalsUser);
        return  result;
    }
}
