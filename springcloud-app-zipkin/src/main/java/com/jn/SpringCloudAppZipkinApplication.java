package com.jn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

/**
 * 链路追踪
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableZipkinServer
@SpringBootApplication
public class SpringCloudAppZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAppZipkinApplication.class, args);
    }
}