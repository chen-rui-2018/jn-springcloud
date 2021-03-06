package com.jn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 支付对账
 *
 * @Author： cm
 * @Date： Created on 2019/5/20 15:13
 * @Version： v1.0
 * @Modified By:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages={"org.xxpay","com.jn"})
@MapperScan("org.xxpay.**.dao")
public class XxPayReconciliationApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxPayReconciliationApplication.class, args);

    }
}
