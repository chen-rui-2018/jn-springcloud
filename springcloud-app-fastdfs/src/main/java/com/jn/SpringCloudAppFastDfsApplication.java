package com.jn;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
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
@EnableFeignClients
@Import(FdfsClientConfig.class)
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class
})
@SpringCloudApplication
public class SpringCloudAppFastDfsApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringCloudAppFastDfsApplication.class).web(true).run(args);
    }
}