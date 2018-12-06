package com.jn.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 文件配置
 *
 * @author： fengxh
 * @date： Created on 2018/12/4 21:08
 * @version： v1.0
 * @modified By:
 */
@ConfigurationProperties(
        prefix = "fdfs.storege"
)
@Component
@RefreshScope
public class FastDfsProperties {

    private final FastDfsProperties.Url url = new FastDfsProperties.Url();


    public FastDfsProperties.Url getUrl() {
        return this.url;
    }

    public static class Url {
        /**
         * 不需要token的地址
         */
        private String noNeedToken;
        /**
         * 需要token的地址
         */
        private String needToken;


        public String getNoNeedToken() {
            return noNeedToken;
        }

        public void setNoNeedToken(String noNeedToken) {
            this.noNeedToken = noNeedToken;
        }

        public String getNeedToken() {
            return needToken;
        }

        public void setNeedToken(String needToken) {
            this.needToken = needToken;
        }
    }
}
