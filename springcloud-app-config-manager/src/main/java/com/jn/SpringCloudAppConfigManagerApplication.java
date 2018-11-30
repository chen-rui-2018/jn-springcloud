package com.jn;

import com.didispace.scca.service.persistence.db.SccaDbConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 配置中心管理
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(exclude={
		SccaDbConfiguration.class
		})
public class SpringCloudAppConfigManagerApplication {

	public static void main(String[] args) {

		new SpringApplicationBuilder(SpringCloudAppConfigManagerApplication.class).web(true).run(args);
	}

}