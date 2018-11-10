package com.jn;

import com.jn.common.channel.MessageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 路由器启动类
 *
 * @author： fengxh
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringCloudApplication
public class SpringCloudAppStreamDemoApplication {
  
	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringCloudAppStreamDemoApplication.class).web(true).run(args);
	}





}