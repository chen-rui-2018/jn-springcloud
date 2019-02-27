package com.jn.wechat.base.controller;

import com.jn.system.log.annotation.ControllerLog;
import com.jn.wechat.base.model.result.WxOAuth2AccessToken;
import com.jn.wechat.base.service.WxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * OAuth2机制
 * 举例获取WxOAuth2AccessToken信息
 *
 * @Author： cm
 * @Date： Created on 2019/1/22 15:07
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/wechat/redirect")
public class WxRedirectController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxService wxService;

    @ControllerLog(doAction = "用oauth2获取用户信息举例")
    @RequestMapping("/greet")
    public String greetUser(@RequestParam String code, ModelMap map) {
        logger.info("页面code===========>>"+code);
        WxOAuth2AccessToken wxOAuth2AccessToken = wxService.oauth2getAccessToken(code);
        map.put("wxOAuth2AccessToken",wxOAuth2AccessToken);
        return "greet_user";
    }
}
