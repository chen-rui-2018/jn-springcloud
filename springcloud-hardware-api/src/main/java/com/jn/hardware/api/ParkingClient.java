package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.TemporaryCarParkingFeeRequest;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 智慧停车提供的内部服务接口
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:19
 * @Version： v1.0
 * @Modified By:
 */
@FeignClient("springcloud-hardware")
public interface ParkingClient {

    /**
     * 获取临停车费用
     * @param temporaryCarParkingFeeRequest 实体类参数
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/getTemporaryCarParkingFee")
    Result getTemporaryCarParkingFee(@RequestBody TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest);

}
