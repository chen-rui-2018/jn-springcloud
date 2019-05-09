package com.jn.park.api;

import com.jn.common.model.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:30
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-park")
public interface ParkingClient {

    /**
     * 定时同步匝道系统停车数据
     * @return
     */
    @RequestMapping(value = "/api/parking/getInParkingCarInfoList", method = RequestMethod.POST)
    Result<Boolean> getInParkingCarInfoList();
    /**
     * 定时同步匝道系统车辆出场数据
     * @return
     */
    @RequestMapping(value = "/api/parking/getOutParkingCarInfoList", method = RequestMethod.POST)
    Result<Boolean> getOutParkingCarInfoList();

}
