package com.jn.enterprise.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 待办事项统计报警配置文件（单位：小时）
 * @author： huxw
 * @date： Created on 2019-5-27 19:04:52
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
    prefix = "jn.task.tipDays"
)
@Component
@RefreshScope
public class TaskStatisticsConfig implements Serializable {

    // 报警时间
    private Integer warn;

    // 预警时间
    private Integer earlyWarn;

    public Integer getWarn() {
        return warn;
    }

    public void setWarn(Integer warn) {
        this.warn = warn;
    }

    public Integer getEarlyWarn() {
        return earlyWarn;
    }

    public void setEarlyWarn(Integer earlyWarn) {
        this.earlyWarn = earlyWarn;
    }
}
