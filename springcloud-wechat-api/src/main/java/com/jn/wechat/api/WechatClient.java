package com.jn.wechat.api;

import com.jn.common.model.Result;
import com.jn.wechat.model.TemplateMessage;
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
@FeignClient("springcloud-wechat")
public interface WechatClient {

    /**
     * 强制刷新access_token
     * @return
     */
    @RequestMapping(value = "/api/wechat/refreshAccessToken")
    void refreshAccessToken();

    /**
     * 推送模板消息
     * @param templateMessage
     * @return
     */
    @RequestMapping(value = "/api/wechat/pushTemplateInfo")
    Result<String> pushTemplateInfo(@RequestBody TemplateMessage templateMessage);

}
