package com.jn.news;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 消息业务实现启动类
 *
 * @author： chenm
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@SpringBootApplication
public class SpringCloudNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudNewsApplication.class, args);
    }
}
