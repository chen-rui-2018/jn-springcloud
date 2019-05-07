package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.parking.model.ParkingAreaModel;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.vo.ParkingServiceTypeVo;
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
*   停车场
* @author： jiangyl
* @date： Created on 2019/4/18 17:12
* @version： v1.0
* @modified By:
*/
@Api(tags = "智慧停车-停车场管理[后台管理接口]")
@RestController
@RequestMapping("/user/parking/area")
public class ParkingAreaManageController extends BaseController {

    @Autowired
    private ParkingAreaService parkingAreaService;

    @ControllerLog(doAction = " 查询停车场服务列表")
    @ApiOperation(value = "查询停车场列表", notes = "不分页查询")
    @RequestMapping(value = "/getParkingServiceTypeList",method = RequestMethod.GET)
    public Result<List<ParkingServiceTypeVo>> getParkingServiceTypeList(){
        return new Result<>(parkingAreaService.getParkingServiceTypeList());
    }

    @ControllerLog(doAction = " 新增停车场")
    @ApiOperation(value = "新增停车场", notes = "新增停车场，车位总数不需要录入，统计车场包含车位数即为车位总数，返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/saveCarPark",method = RequestMethod.POST)
    public Result<String> saveCarPark(@Validated @RequestBody ParkingAreaModel parkingAreaModel){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingAreaService.saveOrUpdateCarPark(parkingAreaModel,user.getAccount()));
    }

    @ControllerLog(doAction = " 删除停车场")
    @ApiOperation(value = "删除停车场", notes = "入参为‘停车场ID’,删除停车场，返回值为响应数据条数，正常为1")
    @RequestMapping(value = "/deleteCarPark",method = RequestMethod.POST)
    public Result<String> deleteCarPark(
            @ApiParam(name="areaId",value = "停车场ID",required = true,example = "51we20***")
            @RequestBody String areaId){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingAreaService.deleteCarPark(areaId,user.getAccount()));
    }

}
