package com.jn.hardware.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.hardware.model.parking.door.DoorCarInParkingParam;
import com.jn.hardware.model.parking.door.DoorCarOutParkingParam;
import com.jn.hardware.model.parking.door.DoorParam;
import com.jn.hardware.parking.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "/saveDoorCarInParkingInfo/{parkId}",method = RequestMethod.POST)
    public DoorParam saveDoorCarInParkingInfo(DoorCarInParkingParam doorCarInParkingParam, HttpServletRequest request,@PathVariable String parkId){
        String  url = request.getRequestURL().toString();
        logger.info("\n道尔: 车辆入场信息推送,parkId:【{}】,车辆信息:【{}】",parkId,doorCarInParkingParam);
        DoorParam doorParam =  parkingService.saveDoorCarInParkingInfo(doorCarInParkingParam,url,parkId);
        logger.info("\n道尔: 车辆入场信息推送,处理完成后返回信息:【{}】",doorParam);
        return  doorParam;
    }
    @ApiOperation(value = "道尔: 车辆出场信息保存",notes = "返回保存的数据的id string")
    @RequestMapping(value = "/saveDoorCarOutParkingInfo/{parkId}",method = RequestMethod.POST)
    public DoorParam  saveDoorCarOutParkingInfo(DoorCarOutParkingParam doorCarOutParkingParam, HttpServletRequest request,@PathVariable String parkId){
        String  url = request.getRequestURL().toString();
        logger.info("\n道尔: 车辆出场信息推送,parkId:【{}】,车辆信息:【{}】",parkId,doorCarOutParkingParam.toString());
        DoorParam  doorParam =  parkingService.saveDoorCarOutParkingInfo(doorCarOutParkingParam,url,parkId);
        logger.info("\n道尔: 车辆出场信息推送，处理完后返回信息:【{}】",doorParam);
        return  doorParam;
    }
}
