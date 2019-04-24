package com.jn.hardware.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.hardware.model.parking.door.DoorCarInParkingParam;
import com.jn.hardware.model.parking.door.DoorCarOutParkingParam;
import com.jn.hardware.model.parking.door.DoorResult;
import com.jn.hardware.parking.service.ParkingService;
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
}
