package com.jn.park.asset.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.asset.enums.PageExceptionEnums;
import com.jn.park.asset.model.*;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.pay.model.PayOrderRsp;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
*
* @author： zhuyz
* @date： Created on 2019/5/7 16:01
* @version： v1.0
* @modified By:
*/
@Api(tags = "房间租赁APP")
@RestController
@RequestMapping(value = "/room/lease")
public class RoomManageController {
    @Autowired
    private RoomInformationService roomInformationService;


    @ControllerLog(doAction = "获取房间信息")
    @ApiOperation(value = "获取房间信息",notes = "返回房间详细信息")
    @GetMapping(value = "/getRoomInformation" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "房间id",example = "575020345132580865")
    })
    public Result<RoomInformationModel> getRoomInformation(String id){
        Assert.notNull(id,"房间id不能为空");
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        RoomInformationModel roomInformationModel = roomInformationService.getRoomInformation(id,user.getAccount());
        return new Result<>(roomInformationModel);
    }

    @ControllerLog(doAction = "获取房间基本信息(含同属分组的所有房间)")
    @ApiOperation(value = "获取房间基本信息(含同属分组的所有房间)",notes = "获取房间基本信息(含同属分组的所有房间)")
    @GetMapping(value = "/getRoomBaseInfo" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roomId",value = "房间id",example = "575020345132580865")
    })
    public Result<RoomBaseModel> getRoomBaseInfo(String roomId){
        Assert.notNull(roomId,"房间id不能为空");
        RoomBaseModel roomBaseModel = roomInformationService.getRoomBaseInfo(roomId);
        return new Result<>(roomBaseModel);
    }

    @ControllerLog(doAction = "房间租赁列表")
    @ApiOperation(value = "房间租赁列表",notes = "返回房间租赁列表(可搜索)")
    @GetMapping(value = "/getRoomLeaseList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "房间名称或楼层名称",example = "1")
    })
    public Result<PaginationData<List<RoomInformationModel>>> getRoomLeaseList(Page page,String name){
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<RoomInformationModel>> data = roomInformationService.getRoomLeaseList(page ,name);
            return new Result<>(data);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }

    }


   @ControllerLog(doAction = "新增房间租赁订单")
    @ApiOperation(value ="新增房间租赁订单",notes = "新增房间租赁订单")
    @PostMapping(value = "/addRoomOrders")
   @ApiImplicitParams({
           @ApiImplicitParam(name = "id",value = "房间id",example = "575020345132580865",required = true),
           @ApiImplicitParam(name = "contactName",value = "联系人姓名",example = "先生",required = true),
           @ApiImplicitParam(name = "contactPhone",value = "联系人电话",example = "123456",required = true),
           @ApiImplicitParam(name = "leaseStartTime",value = "开始时间",example = "2018-5-1",required = true),
           @ApiImplicitParam(name = "month",value = "填写租期(月份)",example = "6",required = true)
   })
    public Result addRoomOrders(String id,  String contactName, String contactPhone, Date leaseStartTime, String month){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Result ordersNumber= roomInformationService.addRoomOrders(id,contactName,contactPhone,leaseStartTime,month,user.getAccount());
        return ordersNumber;
    }

    @ControllerLog(doAction = "返回支付订单")
    @ApiOperation(value = "返回支付订单",notes = "返回支付订单")
    @PostMapping(value = "/getPayOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId",value = "订单ID",example = "2019050811515490657"),
    })
    public Result<RoomPayOrdersModel> getPayOrders (String orderId){
        Assert.notNull(orderId,"订单编号不能为空");
        RoomPayOrdersModel roomPayOrdersModel = roomInformationService.getPayOrders(orderId);
        return new Result<>(roomPayOrdersModel);
    }

    @ControllerLog(doAction = "房间退租")
    @ApiOperation(value = "房间退租",notes = "房间退租")
    @GetMapping(value = "/quitApply")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderItemId",value = "(子)订单编号",example = "2019050811515490657"),
    })
    public Result<RoomPayOrdersItemModel> quitApply(String orderItemId){
        RoomPayOrdersItemModel roomPayOrdersItemModel = roomInformationService.quitApply(orderItemId);
        return new Result(roomPayOrdersItemModel);
    }


    @ControllerLog(doAction = "房间租赁历史列表(新)")
    @ApiOperation(value = "房间租赁历史列表(新)",notes = "获取房间租赁历史列表")
    @GetMapping(value = "/getNewRoomOrdersList")
    public Result<PaginationData<List<RoomLeaseRecordModel>>> getNewRoomOrdersList(Page page){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<RoomLeaseRecordModel>> roomLeaseRecordModel= roomInformationService.getNewRoomOrdersList(user.getAccount(),page);
            return new Result<>(roomLeaseRecordModel);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }
    }

    @ControllerLog(doAction = "房间租借详情(新)")
    @ApiOperation(value = "房间租借详情(新)",notes = "根据订单编号获取租借详情(新)")
    @GetMapping(value = "/getNewRoomOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "itemId",value = "(子)订单编号",example = "2019051111365096306")
    })
    public Result<RoomOrdersModel> getNewRoomOrders (String itemId){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Assert.notNull(itemId,"订单编号不能为空");
        RoomOrdersModel roomOrdersModel =  roomInformationService.getNewRoomOrders(itemId,user.getAccount());
        return new Result<>(roomOrdersModel);
    }


    @ControllerLog(doAction = "调用生成缴费单接口")
    @ApiOperation(value = "调用生成缴费单接口",notes = "调用生成缴费单接口")
    @PostMapping(value = "/createBill")
    public Result createBill(@RequestBody BillParam billParam){
        Assert.notNull(billParam,"缴费单参数不能为空");
        return roomInformationService.createBill(billParam.getBillId(),billParam.getBillSum());
    }

    @ControllerLog(doAction = "撤销缴费单")
    @ApiOperation(value = "撤销缴费单",notes = "撤销缴费单")
    @PostMapping(value = "/withdrawBill")
    public Result withdrawBill(@RequestBody BillParam billParam){
        Assert.notNull(billParam.getBillId(),"缴费单id不能为空");
        return roomInformationService.withdrawBill(billParam.getBillId());
    }

}
