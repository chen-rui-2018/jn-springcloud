package com.jn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableCaching
@EnableFeignClients
@SpringCloudApplication
@MapperScan("com.wangsong.*.dao")
public class SpringcloudAppSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringcloudAppSystemApplication.class, args);

    }


}