package com.jn.hardware.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.api.ParkingClient;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.DoorMonthlyRentCardRateInfo;
import com.jn.hardware.model.parking.door.DoorParkingMonthlyCardShow;
import com.jn.hardware.model.parking.door.DoorParkingSpaceAmountShow;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeResponse;
import com.jn.hardware.parking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:06
 * @Version： v1.0
 * @Modified By:
 */
@RestController
public class ParkingController extends BaseController implements ParkingClient {

    @Autowired
    private ParkingService parkingService;

    @Override
    public Result getTemporaryCarParkingFee(@RequestBody TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest) {
        return parkingService.getTemporaryCarParkingFee(temporaryCarParkingFeeRequest);
    }

    @Override
    public Result savePaymentCarParkingFee(PaymentCarParkingFeeRequest paymentCarParkingFeeRequest) {
        return  parkingService.savePaymentCarParkingFee(paymentCarParkingFeeRequest);
    }

    @Override
    public Result saveParkingMonthlyRentCard(ParkingMonthlyRentCardRequest parkingMonthlyRentCardRequest) {

        return parkingService.saveParkingMonthlyRentCard(parkingMonthlyRentCardRequest);
    }

    @Override
    public Result findParkingMonthlyRentCard(ParkingMonthlyCardInfoRequest parkingMonthlyCardInfoRequest) {
        return parkingService.findParkingMonthlyRentCard(parkingMonthlyCardInfoRequest);
    }

    @Override
    public Result saveMonthlyRentalCardRenewalFee(MonthlyRentalCardRenewalFeeRequset monthlyRentalCardRenewalFeeRequset) {
        return parkingService.saveMonthlyRentalCardRenewalFee(monthlyRentalCardRenewalFeeRequset);
    }

    @Override
    public Result  findMonthlyRentCardRateInfo(MonthyRentalCardRateRequest monthyRentalCardRateRequest) {
        return parkingService.findMonthlyRentCardRateInfo(monthyRentalCardRateRequest);
    }

    @Override
    public Result cancelMonthlyRentAccount(CancelMonthlyRentAccountRequest cancelMonthlyRentAccountRequest) {
        return parkingService.cancelMonthlyRentAccount(cancelMonthlyRentAccountRequest);
    }

    @Override
    public Result findParkingSpaceAmount(ParkingSpaceAmountRequest parkingSpaceAmountRequest) {
        return parkingService.findParkingSpaceAmount(parkingSpaceAmountRequest);
    }


}
