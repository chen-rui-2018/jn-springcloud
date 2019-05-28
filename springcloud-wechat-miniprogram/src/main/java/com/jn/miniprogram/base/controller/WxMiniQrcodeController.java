package com.jn.miniprogram.base.controller;

import com.jn.common.model.Result;
import com.jn.miniprogram.base.service.WxMiniQrcodeService;
import com.jn.miniprogram.base.service.WxMiniUserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 微信小程序二维码生成接口
 *
 * @Author： cm
 * @Date： Created on 2019/5/27 15:54
 * @Version： v1.0
 * @Modified By:
 */
@Api(tags = "小程序码")
@RestController
@RequestMapping("/guest/mini/qr")
public class WxMiniQrcodeController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMiniQrcodeService wxMiniQrcodeService;

    @GetMapping(value = "/qrCode")
    public Result qrCode() {
        logger.info("小程序二维码:{}");
        wxMiniQrcodeService.createWxaCode("http://czezqr.natappfree.cc/springcloud-wechat-miniprogram/guest/mini/user/login");
        return new Result();
    }
}
