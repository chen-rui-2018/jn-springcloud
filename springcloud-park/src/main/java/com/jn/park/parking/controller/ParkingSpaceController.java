package com.jn.park.parking.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.enums.ParkingExceptionEnum;
import com.jn.park.parking.model.ParkingSpaceApplyModel;
import com.jn.park.parking.model.ParkingSpaceAmountModel;
import com.jn.park.parking.model.ParkingSpaceParam;
import com.jn.park.parking.service.ParkingSpaceService;
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
@Api(tags = "智慧停车-停车位")
@RestController
@RequestMapping("/guest/parking/space")
public class ParkingSpaceController extends BaseController {

    @Autowired
    private ParkingSpaceService parkingSpaceService;

    @ControllerLog(doAction = " 查询停车位列表")
    @ApiOperation(value = "查询停车位列表[前端用户/后台管理共用]", notes = "查询停车位列表数据")
    @RequestMapping(value = "/getParkingSpaceList",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingSpaceVo>>> getParkingSpaceList(ParkingSpaceParam parkingSpaceParam){
        return new Result<>(parkingSpaceService.getParkingSpaceList(parkingSpaceParam));
    }

    @ControllerLog(doAction = " 查询当前用户车位统计数据")
    @ApiOperation(value = "查询当前用户车位统计数据[前端用户]", notes = "查询当前用户车位统计数据")
    @RequestMapping(value = "/getParkingSpaceUserCount",method = RequestMethod.GET)
    public Result<ParkingSpaceUserCountVo> getParkingSpaceUserCount(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.getParkingSpaceUserCount(user.getAccount()));
    }

    @ControllerLog(doAction = " 根据ID查询停车位详情")
    @ApiOperation(value = "根据ID查询停车位详情[包括车位出租情况][前端用户/后台管理共用]", notes = "查询停车场详细数据")
    @RequestMapping(value = "/getParkingSpaceDetailById",method = RequestMethod.GET)
    public Result<ParkingSpaceDetailVo> getParkingSpaceDetailById(
            @ApiParam(name="spaceId",value = "停车位ID",required = true,example = "51we20***")
            @RequestParam(value = "spaceId") String spaceId){
        Assert.notNull(spaceId, ParkingExceptionEnum.PARKING_SPACE_ID_IS_NOT_NULL.getMessage());
        return new Result<>(parkingSpaceService.getParkingSpaceDetailById(spaceId));
    }

    @ControllerLog(doAction = " 查询当前用户车位租赁记录")
    @ApiOperation(value = "查询当前用户车位租赁记录[前端用户]", notes = "前端展示停车位信息用停车场名称‘areaName’和停车位编号‘spaceSerial’拼接。例如‘白下智慧园区5号停车场A0001’")
    @RequestMapping(value = "/getParKingSpaceRentalListByUser",method = RequestMethod.GET)
    public Result<PaginationData<List<ParkingUserSpaceRentalVo>>> getParKingSpaceRentalListByUser(Page page){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.getParKingSpaceRentalListByUser(user.getAccount(),page));
    }


    @ControllerLog(doAction = "车位申请")
    @ApiOperation(value = "车位申请[前端用户]", notes = "进度车位申请后，选择停车场，此时会返回车位价格。选择对应的优惠政策后，调用‘租车位费用计算接口’接口查询应收金额。（注意：原型图中没有‘车辆选择’，后期需求已修改为车位和车辆必须绑定。）")
    @RequestMapping(value = "/applyParkingSpace",method = RequestMethod.POST)
    public Result<String> applyParkingSpace(@Validated @RequestBody ParkingSpaceApplyModel parkingSpaceApplyModel){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.applyParkingSpace(parkingSpaceApplyModel,user));
    }

    @ControllerLog(doAction = "租车位费用计算接口")
    @ApiOperation(value = "租车位费用计算接口[前端用户]", notes = "返回对应停车场对应的收费。（需传入起止时间）")
    @RequestMapping(value = "/applyParkingSpaceAmount",method = RequestMethod.GET)
    public Result<ParkingSpaceAmountVo> applyParkingSpaceAmount(@Validated ParkingSpaceAmountModel parkingSpaceAmountModel){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.applyParkingSpaceAmount(parkingSpaceAmountModel,user.getAccount()));
    }

    @ControllerLog(doAction = "生成支付账单")
    @ApiOperation(value = "生成支付账单", notes = "点击去支付，调用该接口生成账单号。前端接收到账单号后，携带账单号调用统一缴费服务‘/guest/pay/bill/createPayOrder统一缴费--发起支付’支付")
    @RequestMapping(value = "/createParkingSpaceBill",method = RequestMethod.POST)
    public Result<String> createParkingSpaceBill(String rentId){
        Assert.notNull(rentId, ParkingExceptionEnum.REND_ID_IS_NOT_NULL.getMessage());
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(parkingSpaceService.createParkingSpaceBill(rentId,user));
    }

}
