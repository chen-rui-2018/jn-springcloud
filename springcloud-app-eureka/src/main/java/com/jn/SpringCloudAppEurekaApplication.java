package com.jn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
/**
 * 注册中心启动方法
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringCloudAppEurekaApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringCloudAppEurekaApplication.class).web(true).run(args);
	}

}