package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.model.ParkingSpaceModel;
import com.jn.park.parking.service.ParkingSpaceService;
import com.jn.park.parking.vo.ParkingAreaDetailVo;
import com.jn.park.parking.vo.ParkingSpaceDetailVo;
import com.jn.park.parking.vo.ParkingSpaceVo;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 *   停车位
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:12
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "智慧停车-停车位管理[后台管理接口]")
@RestController
@RequestMapping("/user/parking/space")
public class ParkingSpaceManageController extends BaseController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @ControllerLog(doAction = " 删除车位")
    @ApiOperation(value = "删除车位", notes = "入参为‘停车位ID’。 返回值为数据响应条数，正常情况为1")
    @RequestMapping(value = "/deleteParkingSpace",method = RequestMethod.POST)
    public Result<String> deleteParkingSpace(
            @ApiParam(name="spaceId",value = "停车位ID",required = true,example = "51we20***")
            @RequestBody String spaceId){
        Assert.notNull(spaceId, ParkingExceptionEnum.PARKING_AREA_ID_IS_NOT_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.deleteParkingSpace(spaceId,user.getAccount()));
    }

    @ControllerLog(doAction = " 新增停车位")
    @ApiOperation(value = "新增停车位", notes = "返回结果为响应数据条数")
    @RequestMapping(value = "/saveParkingSpace",method = RequestMethod.POST)
    public Result<String> saveParkingSpace(@Validated @RequestBody ParkingSpaceModel parkingSpaceModel){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.saveOrUpdateParkingSpace(parkingSpaceModel,user.getAccount()));
    }



}
