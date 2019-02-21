package com.jn.schedule.wechat;

import com.jn.common.util.LoadBalancerUtil;
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

    /**
     * 获取刷新微信服务ID
     */
    private final static String WECHAT_CLIENT = "springcloud-wechat";
    /**
     * 获取微信服务刷新access_token的地址
     */
    private final static String WECHAT_CLIENT_REFRESH_ACCESS_TOKEN_SERVICE = "/api/wechat/refreshAccessToken";


    /**
     * 每小时第2分钟强制刷新access_token
     */
    @Scheduled(cron = "0 2 * * * ?")
    public void refreshAccessToken() {
        loadBalancerUtils.getClientPostForEntity(WECHAT_CLIENT,WECHAT_CLIENT_REFRESH_ACCESS_TOKEN_SERVICE,null);
    }

}
