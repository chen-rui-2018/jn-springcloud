package com.jn.hardware.api;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.DoorMonthlyRentCardRateInfo;
import com.jn.hardware.model.parking.door.DoorParkingMonthlyCardShow;
import com.jn.hardware.model.parking.door.DoorParkingSpaceAmountShow;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeResponse;
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
    Result<DoorTemporaryCarParkingFeeResponse> getTemporaryCarParkingFee(@RequestBody TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest);

    /**
     * 缴费信息保存
     * @param paymentCarParkingFeeRequest 实体类参数
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/savePaymentCarParkingFee")
    Result savePaymentCarParkingFee(@RequestBody PaymentCarParkingFeeRequest paymentCarParkingFeeRequest);

    /**
     * 月租卡开户信息保存
     * @param ParkingMonthlyRentCardUnite
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/saveParkingMonthlyRentCard")
    Result saveParkingMonthlyRentCard(@RequestBody ParkingMonthlyRentCardUnite ParkingMonthlyRentCardUnite);
    /**
     * 月租卡开户信息列表
     * @param parkingMonthlyCardInfoRequest
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/findParkingMonthlyRentCard")
    Result findParkingMonthlyRentCard(@RequestBody ParkingMonthlyCardInfoRequest parkingMonthlyCardInfoRequest);

    /**
     * 保存月租卡续费信息
     * @param monthlyRentalCardRenewalFeeRequset
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/saveMonthlyRentalCardRenewalFee")
    Result saveMonthlyRentalCardRenewalFee(@RequestBody MonthlyRentalCardRenewalFeeRequset monthlyRentalCardRenewalFeeRequset);
    /**
     * 月租信息获取(含费率)
     * @param monthyRentalCardRateRequest
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/findMonthlyRentCardRateInfo")
    Result  findMonthlyRentCardRateInfo(@RequestBody MonthyRentalCardRateRequest monthyRentalCardRateRequest);
    /**
     * 月租卡销户操作
     * @param cancelMonthlyRentAccountRequest
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/cancelMonthlyRentAccount")
    Result cancelMonthlyRentAccount(@RequestBody CancelMonthlyRentAccountRequest cancelMonthlyRentAccountRequest);
    /**
     * 车场车位查询
     * @param cancelMonthlyRentAccountRequest
     * @return
     */
    @RequestMapping(value = "/api/hardware/parking/findParkingSpaceAmount")
    Result findParkingSpaceAmount(@RequestBody ParkingSpaceAmountRequest cancelMonthlyRentAccountRequest);

}
