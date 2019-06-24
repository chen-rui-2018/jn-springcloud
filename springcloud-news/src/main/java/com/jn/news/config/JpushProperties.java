package com.jn.news.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 激光推送属性配置类
 *
 * @Author： cm
 * @Date： Created on 2019/6/14 17:28
 * @Version： v1.0
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "jn.news.jpush")
@RefreshScope
public class JpushProperties {
    /**
     * 应用的appKey
     * 测试appKey：080b2d2bf80c41248e159dba
     * 正式appKey：7b20e6375099fe80ff706dca
     */
    private String appKey;
    /**
     * 应用的Master Secret
     * 用于服务器端 API 调用时与 AppKey 配合使用达到鉴权的目的，请保管好 Master Secret 防止外泄。
     * 测试Master Secret：2273860de366bd73e545d858
     * 正式Master Secret：2a35e0e5980a109b10814468
     */
    private String masterSecret;

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getMasterSecret() {
        return masterSecret;
    }

    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }
}
