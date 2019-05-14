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
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/saveDoorCarInParkingInfo/{parkId}",method = RequestMethod.POST)
    public DoorResult saveDoorCarInParkingInfo(@RequestBody DoorCarInParkingParam doorCarInParkingParam, HttpServletRequest request,@PathVariable String parkId){
        String  url = request.getRequestURL().toString();
        logger.info("\n道尔: 车辆入场信息保存{}入场信息实体:"+doorCarInParkingParam.toString());
        DoorResult result =  parkingService.saveDoorCarInParkingInfo(doorCarInParkingParam,url,parkId);
        logger.info("\n道尔: 车辆入场信息保存{}返回信息实体:"+result.toString());
        return  result;
    }
    @ApiOperation(value = "道尔: 车辆出场信息保存",notes = "返回保存的数据的id string")
    @RequestMapping(value = "/saveDoorCarOutParkingInfo/{parkId}",method = RequestMethod.POST)
    public DoorResult  saveDoorCarOutParkingInfo(@RequestBody DoorCarOutParkingParam doorCarOutParkingParam, HttpServletRequest request,@PathVariable String parkId){
        String  url = request.getRequestURL().toString();
        logger.info("\n道尔: 车辆出场信息保存{}出场信息实体:"+doorCarOutParkingParam.toString());
        DoorResult  result =  parkingService.saveDoorCarOutParkingInfo(doorCarOutParkingParam,url,parkId);
        logger.info("\n道尔: 车辆出场信息保存{}返回信息实体:"+result.toString());
        return  result;
    }
}
