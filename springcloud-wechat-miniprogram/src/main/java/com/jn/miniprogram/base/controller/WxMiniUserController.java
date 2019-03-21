package com.jn.miniprogram.base.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信小程序用户接口
 *
 * @Author： cm
 * @Date： Created on 2019/3/11 17:42
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/mini/user")
public class WxMiniUserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 登陆接口
     */
    @GetMapping("/login")
    public String login(String code) {
        if (StringUtils.isBlank(code)) {
            return "empty jscode";
        }
        //todo 做自己的业务
        return "";
    }

    /**
     * 获取用户信息接口
     * @return
     */
    @GetMapping("/info")
    public String info() {
        //todo 需补充
        return null;
    }

}
