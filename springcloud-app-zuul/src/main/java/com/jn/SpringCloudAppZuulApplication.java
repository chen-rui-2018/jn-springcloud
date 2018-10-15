package com.jn;

import com.jn.pre.OneToAccessFilter;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 路由器启动类
 *
 * @author： fengxh
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
@EnableZuulProxy
@SpringCloudApplication
public class SpringCloudAppZuulApplication {
  
	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringCloudAppZuulApplication.class).web(true).run(args);
	}
	@Bean
	public OneToAccessFilter accessFilter() {
		return new OneToAccessFilter();
	}
}