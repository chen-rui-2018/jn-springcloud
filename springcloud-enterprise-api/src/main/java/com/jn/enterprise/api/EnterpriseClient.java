package com.jn.enterprise.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 企业服务客户端
 * @Author: yangph
 * @Date: 2019/2/14 10:25
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-enterprise")
public interface EnterpriseClient {
}
