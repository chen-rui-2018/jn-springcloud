package com.jn.hardware.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Sdnware的无线AP配置属性
 *
 * @Author： hey
 * @Date： Created on 2019/6/26 11:50
 * @Version： v1.0
 * @Modified By:
 */
@Component
@ConfigurationProperties(prefix = "jn.sdnware.ap")
@RefreshScope
public class SdnwareApProperties {

    /**
     * 用户ID
    * */
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SdnwareApProperties{" +
                "userId='" + userId + '\'' +
                '}';
    }
}
