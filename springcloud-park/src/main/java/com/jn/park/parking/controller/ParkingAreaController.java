package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.model.ParkingAreaParam;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingAreaVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
*   停车场
* @author： jiangyl
* @date： Created on 2019/4/18 17:12
* @version： v1.0
* @modified By:
*/
@Api(tags = "智慧停车-停车场")
@RestController
@RequestMapping("/guest/parking/area")
public class ParkingAreaController extends BaseController {

    @Autowired
    private ParkingAreaService parkingAreaService;

    @ControllerLog(doAction = " 查询停车场列表")
    @ApiOperation(value = "查询停车场列表[后台管理]", notes = "后台查询停车场列表信息")
    @RequestMapping(value = "/getParkingAreaListForAdmin",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingAreaVo>>> getParkingAreaListForAdmin(ParkingAreaParam parkingAreaParam){
        return new Result<>(parkingAreaService.getParkingAreaListForAdmin(parkingAreaParam));
    }

    @ControllerLog(doAction = "前台查询停车场列表")
    @ApiOperation(value = "查询停车场列表[前台用户]", notes = "前台查询停车场列表信息")
    @RequestMapping(value = "/getParkingAreaList",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingAreaVo>>> getParkingAreaList(ParkingAreaParam parkingAreaParam){
        return new Result<>(parkingAreaService.getParkingAreaList(parkingAreaParam));
    }

    @ControllerLog(doAction = " 根据ID查询停车场详情")
    @ApiOperation(value = "根据ID查询停车场详情[前端用户/后台管理公用]", notes = "查询停车场详细数据")
    @RequestMapping(value = "/getParkingAreaDetailById",method = RequestMethod.GET)
    public Result<ParkingAreaDetailVo> getParkingAreaDetailById(
            @ApiParam(name="areaId",value = "停车场ID",required = true,example = "51we20***")
            @RequestParam(value = "areaId") String areaId){
        Assert.notNull(areaId, ParkingExceptionEnum.PARKING_AREA_ID_IS_NOT_NULL.getMessage());
        return new Result<>(parkingAreaService.getParkingAreaDetailById(areaId));
    }

}
