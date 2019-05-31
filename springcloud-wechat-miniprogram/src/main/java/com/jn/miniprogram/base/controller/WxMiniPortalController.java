package com.jn.miniprogram.base.controller;

import com.jn.miniprogram.base.service.WxMiniService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处理微信小程序请求
 *
 * @Author： cm
 * @Date： Created on 2019/3/9 16:08
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/mini/portal")
public class WxMiniPortalController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxMiniService wxMiniService;

    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {
        this.logger.info("\n接收到来自微信服务器的认证消息：signature = [{}], timestamp = [{}], nonce = [{}], echostr = [{}]",
                signature, timestamp, nonce, echostr);

        if(StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) ||
                StringUtils.isBlank(nonce) || StringUtils.isBlank(echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
        //校验signature
        if (wxMiniService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }

}
