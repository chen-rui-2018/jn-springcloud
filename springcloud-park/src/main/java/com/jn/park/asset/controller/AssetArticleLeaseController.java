package com.jn.park.asset.controller;

import com.jn.common.exception.JnSpringCloudException;
import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.park.asset.enums.PageExceptionEnums;
import com.jn.park.asset.model.AssetArticleLeaseModel;
import com.jn.park.asset.model.AssetArticleLeaseOrdersModel;
import com.jn.park.asset.model.LeaseOrdersModel;
import com.jn.park.asset.service.AssetArticleLeaseOrdersService;
import com.jn.park.asset.service.AssetArticleLeaseService;
import com.jn.pay.model.PayOrderRsp;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
*
* @author： zhuyz
* @date： Created on 2019/4/29 15:30
* @version： v1.0
* @modified By:
*/
@Api(tags = "物品租赁(APP)")
@RestController
@RequestMapping("/asset/lease")
public class AssetArticleLeaseController {

    @Autowired
    private AssetArticleLeaseService assetArticleLeaseService;
    @Autowired
    private AssetArticleLeaseOrdersService assetArticleLeaseOrdersService;

    @ControllerLog(doAction = "物品租赁列表")
    @ApiOperation(value = "物品租赁列表",notes = "返回可租赁的资产列表(可搜索)")
    @GetMapping(value = "/articleLeaseList")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value = "搜索关键字",example = "空调")
    })
    public Result<PaginationData<List<AssetArticleLeaseModel>>> getArticleLeaseList(Page page,String name){
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<AssetArticleLeaseModel>> data = assetArticleLeaseService.getArticleLeaseList(page ,name);
            return new Result<>(data);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }

    }


    @ControllerLog(doAction = "获取物品租赁详细信息")
    @ApiOperation(value = "获取物品租赁详细信息",notes = "根据资产编号获取物品详细信息")
    @GetMapping(value = "/getArticleLease")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "577555965931421696")
    })
    public Result<AssetArticleLeaseModel> getArticleLease (String assetNumber){
        Assert.notNull(assetNumber,"资产编号不能为空");
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        AssetArticleLeaseModel assetArticleLeaseModel = assetArticleLeaseService.getArticleLease(assetNumber,user.getAccount());
        return new Result<>(assetArticleLeaseModel);
    }

    @ControllerLog(doAction = "租借资料填写")
    @ApiOperation(value = "租借资料填写",notes = "租借企业资料填写")
    @PostMapping(value = "/leaseWriter")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "577555965931421696",required = true),
            @ApiImplicitParam(name = "leaseEnterprise",value = "租借企业",example = "美的",required = true),
            @ApiImplicitParam(name = "contactName",value = "联系人姓名",example = "先生",required = true),
            @ApiImplicitParam(name = "contactPhone",value = "联系人电话",example = "123456",required = true),
            @ApiImplicitParam(name = "startTime",value = "开始时间",example = "2019-5-1",required = true),
            @ApiImplicitParam(name = "time",value = "填写租期",example = "10",required = true)
    })
    public Result leaseWriter(String assetNumber,String leaseEnterprise, String contactName, String contactPhone, Date startTime,String time){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String ordersNumber = assetArticleLeaseService.leaseWriter(assetNumber,leaseEnterprise,contactName,contactPhone,startTime,time,user);
        if (ordersNumber.equals("-1")){
            return new Result("-1","新增租赁订单失败");
        }
        return new Result(ordersNumber);
    }


    @ControllerLog(doAction = "支付订单")
    @ApiOperation(value = "支付订单",notes = "支付订单")
    @GetMapping(value = "/getPayOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050417220960019")
    })
    public Result<LeaseOrdersModel> getPayOrders (String id){
        Assert.notNull(id,"订单编号不能为空");
        LeaseOrdersModel leaseOrders =  assetArticleLeaseOrdersService.getPayOrders(id);
        return new Result<>(leaseOrders);
    }


    @ControllerLog(doAction = "物品租赁历史列表")
    @ApiOperation(value = "物品租赁历史列表",notes = "获取物品租赁历史列表")
    @GetMapping(value = "/LeaseOrdersList")
    public Result<PaginationData<List<AssetArticleLeaseOrdersModel>>> getArticleLeaseOrdersList(Page page){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<AssetArticleLeaseOrdersModel>> articleLeaseList = assetArticleLeaseOrdersService.getArticleLeaseOrdersList(user.getAccount(),page);
            return new Result<>(articleLeaseList);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }
    }


    @ControllerLog(doAction = "物品租借详情")
    @ApiOperation(value = "物品租借详情",notes = "根据订单编号获取租借详情")
    @GetMapping(value = "/getLeaseOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050417220960019")
    })
    public Result<AssetArticleLeaseOrdersModel> getLeaseOrders (String id){
        Assert.notNull(id,"订单编号不能为空");
        AssetArticleLeaseOrdersModel assetArticleLeaseModel =  assetArticleLeaseOrdersService.getLeaseOrders(id);
        return new Result<>(assetArticleLeaseModel);
    }

    @ControllerLog(doAction = "归还")
    @ApiOperation(value = "归还",notes = "归还")
    @GetMapping(value = "/giveBack")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050417220960019"),
    })
    public Result<AssetArticleLeaseOrdersModel> giveBack(String id){
        AssetArticleLeaseOrdersModel assetArticleLeaseOrdersModel = assetArticleLeaseOrdersService.giveBack(id);
        return new Result<>(assetArticleLeaseOrdersModel);
    }


}
