package com.jn.common.util.log;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * kafka的配置
 *
 * @author： fengxh
 * @date： Created on 2018/12/4 21:08
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
        prefix = "jn.kafka"
)
@Component
@RefreshScope
public class KafkaProperties {
    /**
     * kafka的链接
     */
    private String url ;

    /**
     * top
     */
    private String top = "springcloud-log";

    /**
     * kafka的超时时间
     */
    private String requestTimeout = "1000";

    /**
     * 重试
     */
    private Integer retriesConfig = 0;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getRequestTimeout() {
        return requestTimeout;
    }

    public void setRequestTimeout(String requestTimeout) {
        this.requestTimeout = requestTimeout;
    }

    public Integer getRetriesConfig() {
        return retriesConfig;
    }

    public void setRetriesConfig(Integer retriesConfig) {
        this.retriesConfig = retriesConfig;
    }
}
