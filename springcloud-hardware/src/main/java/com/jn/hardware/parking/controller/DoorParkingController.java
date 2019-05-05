package com.jn.hardware.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.model.parking.*;
import com.jn.hardware.model.parking.door.*;
import com.jn.hardware.parking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author： chenr
 * @date： Created on 2019/4/22 20:00
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "停车消息推送")
@RestController
@RequestMapping(value = "/hardware/parking")
public class DoorParkingController extends BaseController {
    /**
     * 日志组件
     */
    Logger logger = LoggerFactory.getLogger(DoorParkingController.class);

    @Autowired
    private ParkingService parkingService;

    @ApiOperation(value = "道尔: 车辆入场信息保存",notes = "返回保存的数据的id string")
    @RequestMapping(value = "/saveDoorCarInParkingInfo",method = RequestMethod.POST)
    public DoorResult saveDoorCarInParkingInfo(@RequestBody DoorCarInParkingParam doorCarInParkingParam, HttpServletRequest request){
        String  url = request.getRequestURL().toString();

        DoorResult result =  parkingService.saveDoorCarInParkingInfo(doorCarInParkingParam,url);
        return  result;
    }
    @ApiOperation(value = "道尔: 车辆出场信息保存",notes = "返回保存的数据的id string")
    @RequestMapping(value = "/saveDoorCarOutParkingInfo",method = RequestMethod.POST)
    public DoorResult  saveDoorCarOutParkingInfo(@RequestBody DoorCarOutParkingParam doorCarOutParkingParam, HttpServletRequest request){
        String  url = request.getRequestURL().toString();
        DoorResult  result =  parkingService.saveDoorCarOutParkingInfo(doorCarOutParkingParam,url);
        return  result;
    }

    @ApiOperation(value = "道尔: 获取临停车费用",notes = "根据车场编号和车辆牌照获取停车信息")
    @RequestMapping(value = "/getTemporaryCarParkingFee",method = RequestMethod.GET)
    public Result<DoorTemporaryCarParkingFeeResponse> getTemporaryCarParkingFee(TemporaryCarParkingFeeRequest temporaryCarParkingFeeRequest) {
        return parkingService.getTemporaryCarParkingFee(temporaryCarParkingFeeRequest);
    }

    @ApiOperation(value = "道尔: 缴费信息保存",notes = "保存停车缴费信息")
    @RequestMapping(value = "/getTemporaryCarParkingFee",method = RequestMethod.POST)
    public Result savePaymentCarParkingFee(@RequestBody PaymentCarParkingFeeRequest paymentCarParkingFeeRequest) {
        return  parkingService.savePaymentCarParkingFee(paymentCarParkingFeeRequest);
    }

    @ApiOperation(value = "道尔: 月租卡开户信息保存",notes = "月租卡开户信息保存")
    @RequestMapping(value = "/saveParkingMonthlyRentCard",method = RequestMethod.POST)
    public Result saveParkingMonthlyRentCard(@RequestBody ParkingMonthlyRentCardRequest parkingMonthlyRentCardRequest) {
        return parkingService.saveParkingMonthlyRentCard(parkingMonthlyRentCardRequest);
    }

    @ApiOperation(value = "道尔: 月租卡开户信息列表",notes = "根据车场编号和车辆牌照 月租卡开户信息列表")
    @RequestMapping(value = "/findParkingMonthlyRentCard",method = RequestMethod.GET)
    public Result<DoorParkingMonthlyCardShow> findParkingMonthlyRentCard(ParkingMonthlyCardInfoRequest parkingMonthlyCardInfoRequest) {
        return parkingService.findParkingMonthlyRentCard(parkingMonthlyCardInfoRequest);
    }

    @ApiOperation(value = "道尔: 保存月租卡续费信息",notes = "保存月租卡续费信息")
    @RequestMapping(value = "/saveMonthlyRentalCardRenewalFee",method = RequestMethod.POST)
    public Result saveMonthlyRentalCardRenewalFee(@RequestBody  MonthlyRentalCardRenewalFeeRequset monthlyRentalCardRenewalFeeRequset) {
        return parkingService.saveMonthlyRentalCardRenewalFee(monthlyRentalCardRenewalFeeRequset);
    }

    @ApiOperation(value = "道尔: 月租信息获取(含费率)",notes = "根据车场编号和车辆牌照,获取月租信息获取(含费率)")
    @RequestMapping(value = "/findMonthlyRentCardRateInfo",method = RequestMethod.GET)
    public Result<DoorMonthlyRentCardRateInfo>  findMonthlyRentCardRateInfo(MonthyRentalCardRateRequest monthyRentalCardRateRequest) {
        return parkingService.findMonthlyRentCardRateInfo(monthyRentalCardRateRequest);
    }

    @ApiOperation(value = "道尔: 月租卡销户操作",notes = "根据车场编号和车辆牌照,对月租卡进行销户")
    @RequestMapping(value = "/cancelMonthlyRentAccount",method = RequestMethod.POST)
    public Result cancelMonthlyRentAccount(@RequestBody CancelMonthlyRentAccountRequest cancelMonthlyRentAccountRequest) {
        return parkingService.cancelMonthlyRentAccount(cancelMonthlyRentAccountRequest);
    }

    @ApiOperation(value = "道尔: 车场车位查询",notes = "根据停车场id,过去车场的车位情况信息")
    @RequestMapping(value = "/findParkingSpaceAmount",method = RequestMethod.GET)
    public Result<DoorParkingSpaceAmountShow> findParkingSpaceAmount(ParkingSpaceAmountRequest parkingSpaceAmountRequest) {
        return parkingService.findParkingSpaceAmount(parkingSpaceAmountRequest);
    }
}
