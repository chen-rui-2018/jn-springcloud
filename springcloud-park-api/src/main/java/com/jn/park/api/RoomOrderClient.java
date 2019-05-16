package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.door.DoorCarInParkingInfo;
import com.jn.hardware.model.parking.door.DoorCarOutParkingInfo;
import com.jn.pay.model.PayOrderNotify;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 订单订单相关接口
 */
@FeignClient("springcloud-park")
public interface RoomOrderClient {
    /**
     * 支付回调
     * @param payOrderNotify
     * @return
     */
    @RequestMapping(value = "/api/order/payCallBack", method = RequestMethod.POST)
    Result payCallBack(@RequestBody PayOrderNotify payOrderNotify);

}
