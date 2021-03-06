package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.model.ParkingAreaParam;
import com.jn.park.parking.service.ParkingAreaService;
import com.jn.park.parking.service.ParkingPreferentailService;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingAreaVo;
import com.jn.park.parking.vo.ParkingPreferentialVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
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
@Api(tags = "智慧停车-优惠政策")
@RestController
@RequestMapping("/guest/parking/preferential")
public class ParkingPreferentailController extends BaseController {

    @Autowired
    private ParkingPreferentailService parkingPreferentailService;

    @ControllerLog(doAction = " 查询所有优惠政策")
    @ApiOperation(value = "查询所有优惠政策",notes = "优惠金额计算逻辑复杂，前端若不计算金额，则选择对应政策后调用‘租车位费用计算接口[前端用户]’接口，展示后台返回的金额数据")
    @RequestMapping(value = "/getParkingPreferentialList",method = RequestMethod.GET)
    public Result<List<ParkingPreferentialVo>> getParkingPreferentialList(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingPreferentailService.getParkingPreferentialList(user.getAccount()));
    }


    @ControllerLog(doAction = " 查询某个停车场优惠政策")
    @ApiOperation(value = "查询某个停车场优惠政策",notes = "优惠金额计算逻辑复杂，前端若不计算金额，则选择对应政策后调用‘租车位费用计算接口[前端用户]’接口，展示后台返回的金额数据")
    @RequestMapping(value = "/getParkingPreferentialListForArea",method = RequestMethod.GET)
    public Result<List<ParkingPreferentialVo>> getParkingPreferentialListForArea(
            @ApiParam(name="areaId",value = "停车场ID",required = true,example = "51we20***")
            @RequestParam(value = "areaId") String areaId){
        Assert.notNull(areaId, ParkingExceptionEnum.PARKING_AREA_ID_IS_NOT_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingPreferentailService.getParkingPreferentialListForArea(areaId,user.getAccount()));
    }



}
