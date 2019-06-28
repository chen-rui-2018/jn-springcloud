package com.jn.park.api;

import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 环境监测api
 *
 * @author： shaobao
 * @date： Created on 2019/6/28 14:19
 * @version： v1.0
 * @modified By:
 **/
@FeignClient("springcloud-park")
public interface EnvironmentMonitorClient {

    /**
     * 定时获取环境监测数据
     *
     * @param hour 小时,传入-1
     */
    @RequestMapping(value = "/api/park/getEnvironmentMonitorRealTimeDate", method = RequestMethod.POST)
    void getEnvironmentMonitorRealTimeDate(@RequestBody String hour);
}
