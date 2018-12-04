package com.jn;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

/**
 * 项目启动
 *
 * @author： fengxh
 * @date： Created on 2018/12/01 15:31
 * @version： v1.0
 * @modified By:
 */
@Configuration
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableTurbineStream
public class SpringCloudAppAdminApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudAppAdminApplication.class).web(true).run(args);
    }
}