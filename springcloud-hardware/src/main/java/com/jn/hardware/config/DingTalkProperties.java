package com.jn.hardware.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 钉钉配置属性
 *
 * @Author： cm
 * @Date： Created on 2019/6/14 21:47
 * @Version： v1.0
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "jn.ding")
@RefreshScope
public class DingTalkProperties {
    /**
     * 钉钉：企业内部应用appkey
     */
    private String appkey;
    /**
     * 钉钉：企业内部应用appsecret
     */
    private String appsecret;

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }
}
