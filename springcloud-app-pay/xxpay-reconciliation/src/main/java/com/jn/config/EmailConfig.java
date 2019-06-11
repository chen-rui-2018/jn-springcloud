package com.jn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 *  邮件配置
 * @Author： hey
 * @Date： Created on 2019/05/23 11:08
 * @Version： v1.0
 * @Modified By:
 */

@Component
@ConfigurationProperties(prefix = "reconciliation.email")
@RefreshScope
public class EmailConfig {
    /**
     * 邮件内容模板
    * */
   private String  template;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
