package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.door.DoorCarInParkingInfo;
import com.jn.hardware.model.parking.door.DoorCarOutParkingInfo;
import com.jn.park.property.model.PayCallBackNotify;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.sql.Date;

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
     * 定时生成缴费单
     * @return
     */
    @RequestMapping(value = "/api/order/createOrderBill",method = RequestMethod.POST)
    Result createOrderBill();


    /**
     * 缴费单回调
     * @param payCallBackNotify
     * @return
     */
    @RequestMapping(value = "/api/order/updateBill", method = RequestMethod.POST)
    Result updateBill(@RequestBody PayCallBackNotify payCallBackNotify);

    /**
     * 新增房间订单
     * @param roomIds   房间ID集合，多个用逗号隔开
     * @param contactName
     * @param contactPhone
     * @param leaseStartTime 起租时间
     * @param month 租多少个月
     * @param userAccount
     * @return 订单ID
     */
    @RequestMapping(value = "/api/order/addRoomOrders",method = RequestMethod.POST)
    Result addRoomOrders(@RequestParam("roomIds")String roomIds, @RequestParam("contactName") String contactName,@RequestParam("contactPhone") String contactPhone, @RequestParam("leaseStartTime") Date leaseStartTime, @RequestParam("month") String month, @RequestParam("userAccount") String userAccount);


    /**
     * 根据订单生成缴费单
     * @param orderId 房间订单ID
     * @return 缴费单ID
     */
    @RequestMapping(value = "/api/order/createRoomOrderBillByOrder",method = RequestMethod.POST)
    Result createRoomOrderBillByOrder(@RequestParam("orderId") String orderId);
}
