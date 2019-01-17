package com.jn;

import com.codingapi.tm.RestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * 分布式事务协调器
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAppTxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAppTxManagerApplication.class, args);
    }
}