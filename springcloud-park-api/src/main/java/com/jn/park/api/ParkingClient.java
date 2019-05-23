package com.jn.park.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.door.DoorCarInParkingInfo;
import com.jn.hardware.model.parking.door.DoorCarOutParkingInfo;
import com.jn.park.parking.model.ParkingCount;
import com.jn.park.parking.model.ParkingCountParam;
import com.jn.pay.model.PayOrderNotify;
import com.jn.paybill.model.PaymentBillCallBack;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    /**
     * 道尔 车辆入场推送接口
     * @param doorCarInParkingInfo
     * @return
     */
    @RequestMapping(value = "/api/parking/carJoinParking", method = RequestMethod.POST)
    Result<String> carJoinParking(@RequestBody  DoorCarInParkingInfo doorCarInParkingInfo);

    /**
     * 道尔 车辆出场推送接口
     * @param doorCarOutParkingInfo
     * @return
     */
    @RequestMapping(value = "/api/parking/carOutParking", method = RequestMethod.POST)
    Result<String> carOutParking(@RequestBody  DoorCarOutParkingInfo doorCarOutParkingInfo);

    /**
     * 智慧停车支付成功回调 - （由统一缴费侧回调）
     * @param paymentBillCallBack
     * @return
     */
    @RequestMapping(value = "/api/parking/parkingPayCallBack", method = RequestMethod.POST)
    Result parkingPayCallBack(@RequestBody PaymentBillCallBack paymentBillCallBack);

    /**
     * 统计停车场数据
     * @param parkingCountParam
     * @return
     */
    @RequestMapping(value = "/api/parking/countParking",method = RequestMethod.POST)
    Result<ParkingCount> countParking(@RequestBody ParkingCountParam parkingCountParam);

}
