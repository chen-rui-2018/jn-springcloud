package com.jn.oa.meeting.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 系统路径配置类
 *
 * @author： yuanyy
 * @date： Created on 2019/6/28 16:48
 * @version： v1.0
 * @modified By:
 **/
@ConfigurationProperties(
        prefix = "jn.cms"
)
@Component
@RefreshScope
public class SystemUrlProperties {

    /**
     * 系统路径配置
     */
    private String systemUrl;

    public String getSystemUrl() {
        return systemUrl;
    }

    public void setSystemUrl(String systemUrl) {
        this.systemUrl = systemUrl;
    }
}
