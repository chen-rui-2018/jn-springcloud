package com.jn.wechat.base.controller;

import com.jn.common.util.StringUtils;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.wechat.base.service.WxInRedisConfigStorage;
import com.jn.wechat.base.service.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信连wifi配置提供给新锐技术用来获取access_token的接口
 *
 * @Author： cm
 * @Date： Created on 2019/6/6 14:27
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/wechat/gettoken")
public class WxTokenToWiFiController {

    @Autowired
    private WxInRedisConfigStorage wxInRedisConfigStorage;
    @Autowired
    private WxService wxService;

    @ControllerLog(doAction = "获取access_token给新锐技术，用于微信连wifi服务")
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String getToken() {
        //先校验access_token是否存在,不存在则调微信接口获取
        String accessToken = wxInRedisConfigStorage.getAccessToken();
        if(StringUtils.isBlank(accessToken)) {
            accessToken = wxService.getAccessToken();
        }
        return accessToken;
    }

}
