package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.parking.model.ParkingCarJoinParam;
import com.jn.park.parking.model.ParkingCarLeaveParam;
import com.jn.park.parking.service.ParkingCarInfoService;
import com.jn.park.parking.service.ParkingTemporaryService;
import com.jn.park.parking.vo.ParkingCarLeaveVo;
import com.jn.park.parking.vo.ParkingCarPayVo;
import com.jn.park.parking.vo.ParkingRecordDetailVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
*   停车场
* @author： jiangyl
* @date： Created on 2019/4/18 17:12
* @version： v1.0
* @modified By:
*/
@Api(tags = "智慧停车-临时停车")
@RestController
@RequestMapping("/guest/parking/temporary")
public class ParkingTemporaryController extends BaseController {

    @Autowired
    private ParkingTemporaryService parkingTemporaryService;
    @Autowired
    private ParkingCarInfoService parkingCarInfoService;

    @ControllerLog(doAction = " 车辆入场接口")
    @ApiOperation(value = "车辆入场接口[提供给swagger仅供测试，前台请忽略该接口]", notes = "[提供给swagger仅供测试，前台请忽略该接口]")
    @RequestMapping(value = "/carJoinParking",method = RequestMethod.POST)
    public Result<String> carJoinParking(@RequestBody ParkingCarJoinParam parkingCarJoinParam){
        return new Result<>(parkingTemporaryService.carJoinParking(parkingCarJoinParam));
    }

    @ControllerLog(doAction = " 车辆出场接口")
    @ApiOperation(value = "车辆出场接口[提供给swagger仅供测试，前台请忽略该接口]", notes = "[提供给swagger仅供测试，前台请忽略该接口]")
    @RequestMapping(value = "/carLeaveParking",method = RequestMethod.POST)
    public Result<ParkingCarLeaveVo> carLeaveParking(ParkingCarLeaveParam parkingCarLeaveParam){
        return new Result<>(parkingTemporaryService.carLeaveParking(parkingCarLeaveParam));
    }

    @ControllerLog(doAction = "临停缴费查询停车信息详情")
    @ApiOperation(value = "临停缴费查询停车信息详情", notes = "临停缴费查询停车信息详情,返回空则表示未查询到相关数据")
    @RequestMapping(value = "/getCarTempParkingDetail",method = RequestMethod.GET)
    public Result<ParkingRecordDetailVo> getCarTempParkingDetail(@ApiParam(name="carLicense",value = "车牌号",required = true,example = "湘A00001")
                                                                     @RequestParam(value = "carLicense")String carLicense){
        return new Result<>(parkingCarInfoService.getCarTempParkingDetail(carLicense));
    }

    @ControllerLog(doAction = " 临停缴费账单创建")
    @ApiOperation(value = "临停缴费账单创建", notes = "前台用户点击‘缴费离场’，调用该接口返回账单ID，携带该id进入支付方式选择页。然后调用‘/guest/pay/bill/startPayment" +
            "统一缴费--发起支付’发起支付")
    @RequestMapping(value = "/createCarParkingBill",method = RequestMethod.POST)
    public Result<ParkingCarPayVo> createCarParkingBill(String parkingId){
        return new Result<>(parkingTemporaryService.createCarParkingBill(parkingId));
    }

}
