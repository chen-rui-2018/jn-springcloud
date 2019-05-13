package com.jn.park.park.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.park.park.dao.TbParkMapper;
import com.jn.park.park.model.ParkGeneral;
import com.jn.park.park.model.ParkName;
import com.jn.park.park.service.ParkService;
import com.jn.park.park.vo.ParkDetailsVo;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "园区管理")
@RestController
@RequestMapping(value="/guest/portal/park")
public class ParkController extends BaseController {

    @Autowired
    private ParkService parkService;

    @ControllerLog(doAction = "园区管理-获取全部园区数据列表")
    @ApiOperation(value = "获取全部园区数据列表", notes = "返回全部园区数据列表")
    @GetMapping(path = "/list")
    public Result<List<ParkName>> getGardenName()  {
        List<ParkName> list = parkService.getParkName();
        return new Result(list);
    }

    @ControllerLog(doAction = "园区管理-根据ID获取对应园区详情")
    @ApiOperation(value = "根据ID获取对应园区详情", notes = "返回对应园区数据列表")
    @GetMapping(path = "/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "园区ID", dataType = "String", paramType = "query", example = "570327211966464000"),
    })
    public Result<ParkDetailsVo> getGardendetails(String id)  {
        ParkDetailsVo park = parkService.getParkDetails(id);
        return new Result<>(park);
    }

    @ControllerLog(doAction = "园区管理-获取园区概况")
    @ApiOperation(value = "获取园区概况", notes = "返回获取园区概况")
    @GetMapping(path = "/basic")
    public Result<ParkGeneral> getGardenGeneral()  {
        ParkGeneral park=parkService.getParkGeneral();
        return new Result<>(park);
    }



}
