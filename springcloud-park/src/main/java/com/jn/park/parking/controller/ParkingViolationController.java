package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.model.ParkingSpaceModel;
import com.jn.park.parking.model.ParkingViolationModel;
import com.jn.park.parking.service.ParkingSpaceService;
import com.jn.park.parking.service.ParkingViolationService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *   停车位
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:12
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "智慧停车-违停管理")
@RestController
@RequestMapping("/user/parking/violation")
public class ParkingViolationController extends BaseController {

    @Autowired
    private ParkingViolationService parkingViolationService;


    @ControllerLog(doAction = " 违停上报")
    @ApiOperation(value = "违停上报", notes = "违停上报需要园区管理员权限")
    @RequestMapping(value = "/saveParkingViolation",method = RequestMethod.POST)
    public Result<String> saveParkingViolation(@Validated @RequestBody ParkingViolationModel parkingViolationModel){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingViolationService.saveParkingViolation(parkingViolationModel,user.getAccount()));
    }



}
