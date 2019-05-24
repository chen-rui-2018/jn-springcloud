package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.StringUtils;
import com.jn.hardware.model.parking.door.DoorCarInParkingInfo;
import com.jn.hardware.model.parking.door.DoorCarOutParkingInfo;
import com.jn.park.api.ParkingClient;
import com.jn.park.parking.model.ParkingCount;
import com.jn.park.parking.model.ParkingCountParam;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.service.ParkingServerService;
import com.jn.park.parking.service.ParkingTemporaryService;
import com.jn.pay.model.PayOrderNotify;
import com.jn.paybill.enums.PayTypeEnum;
import com.jn.paybill.model.PaymentBillCallBack;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 智慧停车系统服务定时任务
 * @author： jiangyl
 * @date： Created on 2019/4/25 15:29
 * @version： v1.0
 * @modified By:
 */
@RestController
public class ParkingServerController extends BaseController implements ParkingClient {
    private static Logger logger = LoggerFactory.getLogger(ParkingServerController.class);

    @Autowired
    private com.jn.park.parking.service.ParkingServerService parkingServerService;
    @Autowired
    private ParkingAreaService parkingAreaService;

    @ControllerLog(doAction = "定时同步匝道系统停车数据")
    @Override
    public Result<Boolean> getInParkingCarInfoList(){
        logger.info("定时同步匝道系统车辆入场数据开始--入场--");
        return new Result<>(parkingServerService.getInParkingCarInfoList());
    }

    @ControllerLog(doAction = "定时同步匝道系统车辆出场数据")
    @Override
    public Result<Boolean> getOutParkingCarInfoList(){
        logger.info("定时同步匝道系统车辆出场数据---出场--");
        return new Result<>(parkingServerService.getOutParkingCarInfoList());
    }

    @ControllerLog(doAction = "道尔 车辆入场推送接口")
    @Override
    public Result<String> carJoinParking(@RequestBody  DoorCarInParkingInfo doorCarInParkingInfo){
        logger.info("道尔 车辆入场推送接口 parkId:"+doorCarInParkingInfo.getParkId());
        return new Result<>(parkingServerService.carJoinParking(doorCarInParkingInfo.getCarinlist(),doorCarInParkingInfo.getParkId()));
    }

    @ControllerLog(doAction = "道尔 车辆出场推送接口")
    @Override
    public Result<String> carOutParking(@RequestBody DoorCarOutParkingInfo doorCarOutParkingInfo){
        return new Result<>(parkingServerService.carOutParking(doorCarOutParkingInfo.getCaroutlist()));
    }

    @ControllerLog(doAction = "智慧停车支付成功回调")
    @Override
    public Result parkingPayCallBack(@RequestBody PaymentBillCallBack paymentBillCallBack) {
        Boolean b = false;
        if(StringUtils.equals(paymentBillCallBack.getBillType(),PayTypeEnum.PAYMENT_ORDER_TYPE_PARKING_MONTH.getCode())){
           b = parkingServerService.parkingSpaceBillCallBack(paymentBillCallBack.getBillId());
        }else if(StringUtils.equals(paymentBillCallBack.getBillType(),PayTypeEnum.PAYMENT_ORDER_TYPE_PARKING_FEE.getCode())){
           b = parkingServerService.parkingCarBillCallBack(paymentBillCallBack.getBillId());
        }
        return new Result(b);
    }


    @ControllerLog(doAction = " 统计停车场数据")
    @Override
    public Result<ParkingCount> countParking(@RequestBody ParkingCountParam parkingCountParam){
        ParkingCount parkingCount = parkingAreaService.countParking(parkingCountParam);
        return new Result<>(parkingCount);
    }
}
