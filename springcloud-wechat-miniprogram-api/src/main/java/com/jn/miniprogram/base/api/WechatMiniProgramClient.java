package com.jn.miniprogram.base.api;

import com.jn.common.model.Result;
import com.jn.miniprogram.base.model.qrcode.WxaCode;
import com.jn.miniprogram.base.model.qrcode.WxaCodeUnlimit;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 微信提供内部服务接口
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 15:39
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-wechat-miniprogram")
public interface WechatMiniProgramClient {

    /**
     * 强制刷新access_token
     * @return
     */
    @RequestMapping(value = "/api/wechatminiprogram/refreshAccessToken")
    void refreshAccessToken();

    /**
     * 小程序码生成接口A
     * @param wxaCode
     * @return 返回小程序码完整路径
     */
    @RequestMapping(value = "/api/wechatminiprogram/createWxaCode")
    Result<String> createWxaCode(@RequestBody WxaCode wxaCode);

    /**
     * 小程序码生成接口B
     * @param wxaCodeUnlimit
     * @return 返回小程序码完整路径
     */
    @RequestMapping(value = "/api/wechatminiprogram/createWxaCodeUnlimit")
    Result<String> createWxaCodeUnlimit(@RequestBody WxaCodeUnlimit wxaCodeUnlimit);

    /**
     * 小程序码生成接口C
     * @param wxaCode
     * @return 返回小程序码完整路径
     */
    @RequestMapping(value = "/api/wechatminiprogram/createQrcode")
    Result<String> createQrcode(@RequestBody WxaCode wxaCode);

}
