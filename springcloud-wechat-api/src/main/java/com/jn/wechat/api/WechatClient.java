package com.jn.wechat.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 强制刷新微信access_token的api
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 15:39
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-wechat")
public interface WechatClient {

    /**
     * 强制刷新access_token
     * @return
     */
    @RequestMapping(value = "/api/wechat/refreshAccessToken")
    void refreshAccessToken();
}
