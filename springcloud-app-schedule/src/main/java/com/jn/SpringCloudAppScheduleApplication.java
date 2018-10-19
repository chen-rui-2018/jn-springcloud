package com.jn;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 调度中心启动方法
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@EnableScheduling
@SpringCloudApplication
public class SpringCloudAppScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAppScheduleApplication.class, args);

	}


}