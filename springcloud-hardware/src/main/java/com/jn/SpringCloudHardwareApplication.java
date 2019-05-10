package com.jn;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 硬件服务
 *
 * @author： shenph
 * @date： Created on 2018/16/06 20:36
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@EnableSwagger2Doc
@SpringCloudApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class SpringCloudHardwareApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudHardwareApplication.class).web(true).run(args);
    }
}