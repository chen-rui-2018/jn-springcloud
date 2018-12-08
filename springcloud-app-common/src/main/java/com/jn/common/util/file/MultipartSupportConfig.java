package com.jn.common.util.file;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

/**
 * 使用form实现feign的文件上传，配置类
 *
 * @author： fengxh
 * @date： Created on 2018/12/7 11:38
 * @version： v1.0
 * @modified By:
 */
public class MultipartSupportConfig {

    @Bean
    @Primary
    @Scope("prototype")
    public Encoder feignEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }


}
