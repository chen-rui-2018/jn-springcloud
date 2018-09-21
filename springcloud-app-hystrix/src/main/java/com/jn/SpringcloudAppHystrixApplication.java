package com.jn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard
@SpringCloudApplication
public class SpringcloudAppHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAppHystrixApplication.class, args);
    }
}