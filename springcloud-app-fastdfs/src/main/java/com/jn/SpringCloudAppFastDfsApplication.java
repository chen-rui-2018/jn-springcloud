package com.jn;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 项目启动
 * 使用人家整合后的代码，地址是：https://github.com/tobato/FastDFS_Client
 * @author： fengxh
 * @date： Created on 2018/10/01 15:31
 * @version： v1.0
 * @modified By:
 */
@SpringCloudApplication
@EnableFeignClients
@Import(FdfsClientConfig.class)//注解，就可以拥有带有连接池的FastDFS Java客户端了
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)// 解决jmx重复注册bean的问题
public class SpringCloudAppFastDfsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudAppFastDfsApplication.class).web(true).run(args);
    }
}