package com.jn.park.parking.controller;

import com.jn.common.model.Result;
import com.jn.park.parking.service.ParkingServerService;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 智慧停车-停车缴费服务
 * @author： jiangyl
 * @date： Created on 2019/5/14 16:46
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "智慧停车-停车缴费服务[测试接口]")
@RestController
@RequestMapping("/guest/parking/server_test")
public class ParkingServerCallController {
    private static Logger logger = LoggerFactory.getLogger(ParkingServerCallController.class);
    @Autowired
    private ParkingServerService parkingServerService;

    @ControllerLog(doAction = " 停车位租赁支付成功回调接口")
    @ApiOperation(value = "停车位租赁支付成功回调接口[提供给swagger仅供测试，前台请忽略该接口]", notes = "[提供给swagger仅供测试，前台请忽略该接口]")
    @RequestMapping(value = "/parkingSpaceBillCallBack",method = RequestMethod.GET)
    public Result<Boolean> parkingSpaceBillCallBack(
            @ApiParam(name="billNum",value = "账单号",required = true,example = "PK-20190514155033836")
            @RequestParam(value = "billNum") String billNum){
        Boolean aBoolean = parkingServerService.parkingSpaceBillCallBack(billNum);
        logger.info("停车位租赁支付成功回调接口，响应结果：{}",aBoolean);
        return new Result<>(aBoolean);
    }
    @ControllerLog(doAction = " 临时车支付成功回调接口")
    @ApiOperation(value = "临时车支付成功回调接口[提供给swagger仅供测试，前台请忽略该接口]", notes = "[提供给swagger仅供测试，前台请忽略该接口]")
    @RequestMapping(value = "/parkingCarBillCallBack",method = RequestMethod.GET)
    public Result<Boolean> parkingCarBillCallBack(
            @ApiParam(name="billNum",value = "账单号",required = true,example = "PK-20190514155033836")
            @RequestParam(value = "billNum") String billNum){
        Boolean aBoolean = parkingServerService.parkingCarBillCallBack(billNum);
        logger.info("临时车支付成功回调接口，响应结果：{}",aBoolean);
        return new Result<>(aBoolean);
    }
}
