package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.park.parking.model.ParkingCarInfoModel;
import com.jn.park.parking.model.ParkingCarInfoParam;
import com.jn.park.parking.model.ParkingRecordParam;
import com.jn.park.parking.service.ParkingCarInfoService;
import com.jn.park.parking.vo.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *   停车位
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:12
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "智慧停车-车辆管理")
@RestController
@RequestMapping("/user/parking/carInfo")
public class ParkingCarInfoController extends BaseController {

    @Autowired
    private ParkingCarInfoService parkingCarInfoService;

    @ControllerLog(doAction = "车辆管理-车辆列表")
    @ApiOperation(value = "车辆管理-车辆列表[后台管理]", notes = "查询园区用户绑定车辆数据[临时车不查询]。入参状态分为两种：未入场、已入场。")
    @RequestMapping(value = "/getCarInfoList",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingCarInfoVo>>> getCarInfoList(ParkingCarInfoParam parkingCarInfoParam){
        return new Result<>(parkingCarInfoService.getCarInfoList(parkingCarInfoParam));
    }

    @ControllerLog(doAction = "查询当前用户车辆列表")
    @ApiOperation(value = "查询当前用户车辆列表[前端用户]")
    @RequestMapping(value = "/getCarInfoListByNowUser",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingCarInfoVo>>> getCarInfoListByNowUser(Page page){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingCarInfoService.getCarInfoListByNowUser(user.getAccount(),page));
    }

    @ControllerLog(doAction = " 查询当前用户车辆统计数据")
    @ApiOperation(value = "查询当前用户车辆统计数据[前端用户]", notes = "查询当前用户车辆统计数据")
    @RequestMapping(value = "/getUserCarInfoCount",method = RequestMethod.GET)
    public Result<ParkingUserCarInfoCountVo> getUserCarInfoCount(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingCarInfoService.getUserCarInfoCount(user.getAccount()));
    }

    @ControllerLog(doAction = " 新增用户车辆")
    @ApiOperation(value = "新增用户车辆[前端用户]", notes = "返回内容为数据响应条数，正常情况为1")
    @RequestMapping(value = "/saveCarInfo",method = RequestMethod.POST)
    public Result<String> saveCarInfo(@Validated @RequestBody ParkingCarInfoModel parkingCarInfoModel){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingCarInfoService.saveCarInfo(parkingCarInfoModel,user));
    }

    @ControllerLog(doAction = " 删除本人用户车辆")
    @ApiOperation(value = "删除本人用户车辆[前端用户]", notes = "入参为车辆id，只能删除本人车辆。返回内容为数据响应条数，正常情况为1")
    @RequestMapping(value = "/deleteCarInfoByUser",method = RequestMethod.POST)
    public Result<String> deleteCarInfoByUser(String carId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingCarInfoService.deleteCarInfoByUser(user.getAccount(),carId));
    }

    @ControllerLog(doAction = "停车记录[查询停车记录列表]")
    @ApiOperation(value = "停车记录[查询停车记录列表]", notes = "车辆的历史停车记录数据")
    @RequestMapping(value = "/getCarParkingRecordList",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingRecordVo>>> getCarParkingRecordList(ParkingRecordParam parkingRecordParam){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingCarInfoService.getCarParkingRecordList(parkingRecordParam));
    }


}
