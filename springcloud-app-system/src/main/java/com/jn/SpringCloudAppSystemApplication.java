package com.jn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
/**
 * 项目启动
 *
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */

@EnableFeignClients
@SpringCloudApplication
@MapperScan("com.jn.*.dao")
public class SpringCloudAppSystemApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudAppSystemApplication.class).web(true).run(args);
    }


}