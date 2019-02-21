package com.jn.wechat.base.controller;

import com.jn.system.log.annotation.ControllerLog;
import com.jn.wechat.base.service.WxService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 处理微信请求
 *
 * @Author： cm
 * @Date： Created on 2019/1/7 14:35
 * @Version： v1.0
 * @Modified By:
 */
@RestController
@RequestMapping("/guest/wechat/portal")
public class WxPortalController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WxService wxService;

    /**
     * 微信请求认证，确认消息来源于微信服务器
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @ControllerLog(doAction = "微信请求认证，确认消息来源于微信服务器")
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authGet(@RequestParam(name = "signature", required = false) String signature,
                          @RequestParam(name = "timestamp", required = false) String timestamp,
                          @RequestParam(name = "nonce", required = false) String nonce,
                          @RequestParam(name = "echostr", required = false) String echostr) {

        logger.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", signature, timestamp, nonce, echostr);
        if(StringUtils.isBlank(signature) || StringUtils.isBlank(timestamp) ||
                StringUtils.isBlank(nonce) || StringUtils.isBlank(echostr)) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
        //校验signature
        if (wxService.checkSignature(timestamp, nonce, signature)) {
            return echostr;
        }

        return "非法请求";
    }


    /**
     * 接收微信请求
     * @param requestBody
     * @param signature
     * @param timestamp
     * @param nonce
     * @param openid
     * @return
     */
    @ControllerLog(doAction = "接收并处理微信请求")
    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(@RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid) {
        logger.info("\n接收微信请求：[openid=[{}], [signature=[{}], msgSignature=[{}],"
                        + " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
                openid, signature, timestamp, nonce, requestBody);

        if (!wxService.checkSignature(timestamp, nonce, signature)) {
            throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
        }
        //处理微信消息,获取回复信息
        String out = wxService.processRequest(requestBody);
        logger.debug("\n组装回复信息：{}", out);
        return out;
    }

}
