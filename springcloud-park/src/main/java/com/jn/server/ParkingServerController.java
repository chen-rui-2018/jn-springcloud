package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.hardware.model.parking.door.DoorCarInParkingInfo;
import com.jn.hardware.model.parking.door.DoorCarOutParkingInfo;
import com.jn.park.api.ParkingClient;
import com.jn.park.parking.service.ParkingServerService;
import com.jn.park.parking.service.ParkingTemporaryService;
import com.jn.system.log.annotation.ControllerLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
        logger.info("\n道尔 车辆入场推送接口 parkId:"+doorCarInParkingInfo.getParkId());
        return new Result<>(parkingServerService.carJoinParking(doorCarInParkingInfo.getCarinlist(),doorCarInParkingInfo.getParkId()));
    }

    @ControllerLog(doAction = "道尔 车辆出场推送接口")
    @Override
    public Result<String> carOutParking(@RequestBody DoorCarOutParkingInfo doorCarOutParkingInfo){
        return new Result<>(parkingServerService.carOutParking(doorCarOutParkingInfo.getCaroutlist()));
    }

}
