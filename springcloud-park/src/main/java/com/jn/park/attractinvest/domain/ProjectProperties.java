package com.jn.park.attractinvest.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 项目管理配置类
 *
 * @author： shaobao
 * @date： Created on 2019/1/29 19:51
 * @version： v1.0
 * @modified By:
 **/
@ConfigurationProperties(
        prefix = "park.attractinvest.project"
)
@Component
@RefreshScope
public class ProjectProperties {
    /**
     * 数据字典缓存时间
     */
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
