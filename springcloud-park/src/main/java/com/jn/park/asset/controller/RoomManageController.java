package com.jn.park.asset.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.asset.entity.TbRoomOrdersItem;
import com.jn.park.asset.enums.PageExceptionEnums;
import com.jn.park.asset.enums.RoomLeaseStatusEnums;
import com.jn.park.asset.model.*;
import com.jn.park.asset.service.RoomInformationService;
import com.jn.park.asset.service.RoomOrdersService;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.*;

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
    @Autowired
    private RoomOrdersService roomOrdersService;

    @ControllerLog(doAction = "房间租赁列表")
    @ApiOperation(value = "房间租赁列表",notes = "返回房间租赁列表")
    @GetMapping(value = "/getRoomLeaseList")
    public Result<PaginationData<List<RoomInformationModel>>> getRoomLeaseList(Page page){
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<RoomInformationModel>> data = roomInformationService.getRoomLeaseList(page);
            return new Result(data);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }
    }

    @ControllerLog(doAction = "获取房间信息")
    @ApiOperation(value = "获取房间信息",notes = "返回房间详细信息")
    @GetMapping(value = "/getRoomInformation" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "房间id",example = "575020345132580865")
    })
    public Result<RoomInformationModel> getRoomInformation(String id){
        Assert.notNull(id,"房间id不能为空");
        RoomInformationModel roomInformationModel = roomInformationService.getRoomInformation(id);
        return new Result<>(roomInformationModel);
    }

    @ControllerLog(doAction = "获取房间基本信息")
    @ApiOperation(value = "获取房间基本信息",notes = "获取房间基本信息")
    @GetMapping(value = "/getRoomBaseInfo" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roomId",value = "房间id",example = "575020345132580865")
    })
    public Result<RoomBaseModel> getRoomBaseInfo(String roomId){
        Assert.notNull(roomId,"房间id不能为空");
        RoomBaseModel roomBaseModel = roomInformationService.getRoomBaseInfo(roomId);
        return new Result<>(roomBaseModel);
    }

    @ControllerLog(doAction = "房间搜索")
    @ApiOperation(value = "房间搜索",notes = "房间搜索")
    @GetMapping(value = "/searchRoomList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "房间名称或楼层名称",example = "1")
    })
    public Result<PaginationData<List<RoomInformationModel>>> searchRoomList(Page page,String name){
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<RoomInformationModel>> data = roomInformationService.searchRoomList(page ,name);
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
           @ApiImplicitParam(name = "leaseEndTime",value = "结束时间",example = "2019-5-1",required = true)
   })
    public Result addRoomOrders(String id,  String contactName, String contactPhone, Date leaseStartTime, Date leaseEndTime){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        Result ordersNumber= roomInformationService.addRoomOrders(id,contactName,contactPhone,leaseStartTime,leaseEndTime,user.getAccount());
        return ordersNumber;
    }

    @ControllerLog(doAction = "支付订单")
    @ApiOperation(value = "支付订单",notes = "支付订单")
    @GetMapping(value = "/getPayOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050811515490657")
    })
    public Result<RoomPayOrdersModel> getPayOrders (String id){
        Assert.notNull(id,"订单编号不能为空");
        RoomPayOrdersModel roomPayOrdersModel =  roomOrdersService.getPayOrders(id);
        return new Result<>(roomPayOrdersModel);
    }

    @ControllerLog(doAction = "房间租赁历史列表")
    @ApiOperation(value = "房间租赁历史列表",notes = "获取房间租赁历史列表")
    @GetMapping(value = "/getRoomOrdersList")
    public Result<PaginationData<List<RoomPayOrdersItemModel>>> getRoomOrdersList(Page page){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<RoomPayOrdersItemModel>> roomOrdersList = roomOrdersService.getRoomOrdersList(user.getAccount(),page);
            return new Result<>(roomOrdersList);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }
    }

    @ControllerLog(doAction = "房间租借详情")
    @ApiOperation(value = "房间租借详情",notes = "根据订单编号获取租借详情")
    @GetMapping(value = "/getRoomOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050811515490657")
    })
    public Result<RoomPayOrdersItemModel> getRoomOrders (String id){
        Assert.notNull(id,"订单编号不能为空");
        RoomPayOrdersItemModel roomPayOrdersItemModel =  roomOrdersService.getRoomOrders(id);
        return new Result<>(roomPayOrdersItemModel);
    }

    @ControllerLog(doAction = "房间退租")
    @ApiOperation(value = "房间退租",notes = "房间退租")
    @GetMapping(value = "/quitApply")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050811515490657"),
    })
    public Result<RoomOrdersModle> quitApply(String id){
        RoomOrdersModle roomOrdersModle = roomOrdersService.quitApply(id);
        return new Result(roomOrdersModle);
    }

}
