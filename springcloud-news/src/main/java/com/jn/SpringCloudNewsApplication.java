package com.jn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 消息业务实现启动类
 *
 * @author： cm
 * @date： Created on 2018/9/19 15:58
 * @version： v1.0
 * @modified By:
 */
@EnableFeignClients
@SpringCloudApplication
@MapperScan("com.jn.**.dao")
public class SpringCloudNewsApplication {
    // TODO: 2018/12/6 陈苗，1，干掉stream项目，由news来接管；2，判断消息消费成功与否，只跟异常有关系 3，文件方式；
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudNewsApplication.class).web(true).run(args);
    }
}
