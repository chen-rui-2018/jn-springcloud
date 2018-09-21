package com.jn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.wangsong.*.dao")
public class SpringcloudAppScheduleApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringcloudAppScheduleApplication.class, args);

	}


}