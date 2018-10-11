package com.jn;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心启动方法
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class SpringCloudAppConfigApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringCloudAppConfigApplication.class).web(true).run(args);
	}

}