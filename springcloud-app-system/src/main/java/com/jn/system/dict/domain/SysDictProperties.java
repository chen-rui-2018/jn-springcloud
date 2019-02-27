package com.jn.system.dict.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 数据字典配置
 *
 * @author： shaobao
 * @date： Created on 2019/1/29 19:51
 * @version： v1.0
 * @modified By:
 **/
@ConfigurationProperties(
        prefix = "system.dict.information"
)
@Component
@RefreshScope
public class SysDictProperties {
    /**
     * 数据字典缓存时间
     */
    private int expire;

    public int getExpire() {
        return expire;
    }

    public void setExpire(int expire) {
        this.expire = expire;
    }
}
