package com.jn.hardware.parking.service;

import com.jn.common.model.Result;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.*;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 17:12
 * @Version： v1.0
 * @Modified By:
 */
public interface ParkingService {

    /**
     * 获取临停预缴费信息(场内缴费)
     * @param temporaryCarParkingFeeRequest
     * @return
     */
    Result<DoorTemporaryCarParkingFeeResponse> getTemporaryCarParkingFee(TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest);

    /**
     * 保存用户停车缴费信息
     * @param paymentCarParkingFeeRequest
     * @return
     */
    Result savePaymentCarParkingFee(PaymentCarParkingFeeRequest paymentCarParkingFeeRequest);

    /**
     * 月租卡开户信息保存
     * @param parkingMonthlyRentCardUnite
     * @return
     */
    Result saveParkingMonthlyRentCard(ParkingMonthlyRentCardUnite parkingMonthlyRentCardUnite);

    /**
     * 月租卡信息查询
     * @param parkingMonthlyCardInfoRequest
     * @return
     */
    Result findParkingMonthlyRentCard(ParkingMonthlyCardInfoRequest parkingMonthlyCardInfoRequest);

    /**
     * 月租卡续费信息保存
     * @param monthlyRentalCardRenewalFeeRequset
     * @return
     */
    Result saveMonthlyRentalCardRenewalFee(MonthlyRentalCardRenewalFeeRequset monthlyRentalCardRenewalFeeRequset);

    /**
     * 月租信息获取(含费率)
     * @param monthyRentalCardRateRequest
     * @return
     */
    Result  findMonthlyRentCardRateInfo(MonthyRentalCardRateRequest monthyRentalCardRateRequest);

    /**
     * 月租卡销户操作
     * @param cancelMonthlyRentAccountRequest
     * @return
     */
    Result cancelMonthlyRentAccount(CancelMonthlyRentAccountRequest cancelMonthlyRentAccountRequest);

    /**
     * 停车场车位查询
     * @param parkingSpaceAmountRequest
     * @return
     */
    Result findParkingSpaceAmount(ParkingSpaceAmountRequest parkingSpaceAmountRequest);

    /**
     * 车辆入场记录信息
     * @param doorCarInParkingShow
     * @param url
     * @param parkId 车场id
     * @return
     */
    DoorParam saveDoorCarInParkingInfo(DoorCarInParkingParam doorCarInParkingShow, String url,String parkId);

    /**
     * 车辆出场记录信息
     * @param doorCarOutParkingShow
     * @param url
     * @param parkId 车场id
     * @return
     */
    DoorParam  saveDoorCarOutParkingInfo(@RequestBody DoorCarOutParkingParam doorCarOutParkingShow, String url,String parkId);

}
