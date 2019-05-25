package com.jn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付对账
 *
 * @Author： cm
 * @Date： Created on 2019/5/20 15:13
 * @Version： v1.0
 * @Modified By:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class XxPayReconciliationApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxPayReconciliationApplication.class, args);

    }
}
