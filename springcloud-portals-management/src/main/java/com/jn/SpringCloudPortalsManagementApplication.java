package com.jn;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 门户管理启动
 *
 * @author： huangchen
 * @date： Created on 2018/11/19 10:15
 * @version： v1.0
 * @modified By:
 */

@EnableFeignClients
@EnableSwagger2Doc
@SpringCloudApplication
@MapperScan("com.jn.**.dao")
public class SpringCloudPortalsManagementApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudPortalsManagementApplication.class).web(true).run(args);
    }






}