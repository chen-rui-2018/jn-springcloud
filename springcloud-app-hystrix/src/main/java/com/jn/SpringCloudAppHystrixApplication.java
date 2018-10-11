package com.jn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
/**
 * 断路器监控启动方法
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class SpringCloudAppHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAppHystrixApplication.class, args);
    }
}