package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.door.DoorCarInParkingInfo;
import com.jn.hardware.model.parking.door.DoorCarOutParkingInfo;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * 房间租赁相关接口
 */
@FeignClient("springcloud-park")
public interface RoomOrderClient {
    /**
     * 支付回调
     * test RoomOrderClientTest.java
     * @param payOrderNotify
     * @return
     */
    @RequestMapping(value = "/api/order/payCallBack", method = RequestMethod.POST)
    Result payCallBack(@RequestBody PayOrderNotify payOrderNotify);


    /**
     * 发起支付
     * @param createPayReqModel
     * @return
     */
    @RequestMapping(value = "/api/order/createPay", method = RequestMethod.POST)
    public Result<PayOrderRsp> createPay(@RequestBody CreatePayReqModel createPayReqModel);

     /**
     * 是否支付,未支付取消订单
     * @return
     */
    @RequestMapping(value = "/api/order/updateRoomPayStatus",method = RequestMethod.POST)
    Result updateRoomPayStatus();

    /**
     * 生成缴费单
     * @return
     */
    @RequestMapping(value = "/api/order/createOrderBill",method = RequestMethod.POST)
    Result createOrderBill();
}
