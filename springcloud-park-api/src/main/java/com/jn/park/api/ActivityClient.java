package com.jn.park.api;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * 活动客户端
 *
 * @Author: yangph
 * @Date: 2018/11/28 19:30
 * @Version v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface ActivityClient {

}
