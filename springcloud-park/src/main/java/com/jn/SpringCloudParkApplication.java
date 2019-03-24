package com.jn;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 园区服务
 *
 * @author： shenph
 * @date： Created on 2018/16/06 20:36
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@EnableSwagger2Doc
@SpringCloudApplication
@SpringBootApplication
@EnableScheduling
@MapperScan("com.jn.**.dao")
public class SpringCloudParkApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudParkApplication.class).web(true).run(args);
    }


}