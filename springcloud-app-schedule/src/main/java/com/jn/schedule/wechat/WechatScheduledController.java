package com.jn.schedule.wechat;

import com.jn.common.util.LoadBalancerUtil;
import com.jn.wechat.api.WechatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 微信定时调度
 *
 * @Author： cm
 * @Date： Created on 2019/1/23 16:17
 * @Version： v1.0
 * @Modified By:
 */
@Component
public class WechatScheduledController {
    @Autowired
    private LoadBalancerUtil loadBalancerUtils;

    @Autowired
    WechatClient wechatClient;

    /**
     * 每小时第2分钟强制刷新access_token
     */
    @Scheduled(cron = "0 2 * * * ?")
    public void refreshAccessToken() {
        wechatClient.refreshAccessToken();
    }

}
