package com.jn.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 用户服务配置文件
 * @author： huxw
 * @date： Created on 2019-5-23 20:28:44
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
    prefix = "jn.user"
)
@Component
@RefreshScope
public class UserServiceConfig implements Serializable {

    // 门户可展示角色串
    private String homeRoleStr;

    public String getHomeRoleStr() {
        return homeRoleStr;
    }

    public void setHomeRoleStr(String homeRoleStr) {
        this.homeRoleStr = homeRoleStr;
    }

    @Override
    public String toString() {
        return "UserServiceConfig{" +
                "homeRoleStr='" + homeRoleStr + '\'' +
                '}';
    }
}
