package com.jn;

import com.netflix.discovery.DiscoveryClient;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调度中心启动方法
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableSwagger2Doc
@EnableFeignClients
@EnableScheduling
@SpringCloudApplication
public class SpringCloudAppScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAppScheduleApplication.class, args);

	}

}