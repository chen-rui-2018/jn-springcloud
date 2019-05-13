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
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "物品租赁列表",notes = "返回可租赁的资产列表")
    @GetMapping(value = "/articleLeaseList")
    public Result<PaginationData<List<AssetArticleLeaseModel>>> getArticleLeaseList(Page page){
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<AssetArticleLeaseModel>> data = assetArticleLeaseService.getArticleLeaseList(page);
            return new Result<>(data);
        }else{
            throw new JnSpringCloudException(PageExceptionEnums.PAGE_NOT_NULL);
        }
    }


    @ControllerLog(doAction = "获取物品租赁详细信息")
    @ApiOperation(value = "获取物品租赁详细信息",notes = "根据资产编号获取物品详细信息")
    @GetMapping(value = "/getArticleLease")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "572058527984517120")
    })
    public Result<AssetArticleLeaseModel> getArticleLease (String assetNumber){
        Assert.notNull(assetNumber,"资产编号不能为空");
        AssetArticleLeaseModel assetArticleLeaseModel = assetArticleLeaseService.getArticleLease(assetNumber);
        return new Result<>(assetArticleLeaseModel);
    }

    @ControllerLog(doAction = "租借资料填写")
    @ApiOperation(value = "租借资料填写",notes = "租借企业资料填写")
    @PostMapping(value = "/leaseWriter")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "572058527984517120",required = true),
            @ApiImplicitParam(name = "leaseEnterprise",value = "租借企业",example = "美的",required = true),
            @ApiImplicitParam(name = "contactName",value = "联系人姓名",example = "先生",required = true),
            @ApiImplicitParam(name = "contactPhone",value = "联系人电话",example = "123456",required = true),
            @ApiImplicitParam(name = "startTime",value = "开始时间",example = "2019-5-1",required = true),
            @ApiImplicitParam(name = "endTime",value = "结束时间",example = "2019-6-1",required = true)
    })
    public Result leaseWriter(String assetNumber,String leaseEnterprise, String contactName, String contactPhone, Date startTime,Date endTime){
        assetArticleLeaseService.leaseWriter(assetNumber,leaseEnterprise,contactName,contactPhone,startTime,endTime);
        return new Result();
    }

    @ControllerLog(doAction = "新增租赁订单")
    @ApiOperation(value ="新增租赁订单",notes = "新增租赁订单")
    @PostMapping(value = "/addLeaseOrders")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "assetNumber",value = "资产编号",example = "572058527984517120")
    })
    public Result addLeaseOrders(String assetNumber){
        //获取登录信息
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        String ordersNumber= assetArticleLeaseService.addLeaseOrders(assetNumber,user);
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
        if (page.getPage() > 0 && page.getRows() > 0){
            PaginationData<List<AssetArticleLeaseOrdersModel>> articleLeaseList = assetArticleLeaseOrdersService.getArticleLeaseList(page);
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
    public Result giveBack(String id){
        assetArticleLeaseOrdersService.giveBack(id);
        return new Result();
    }

    @ControllerLog(doAction = "确认归还")
    @ApiOperation(value = "确认归还",notes = "确认归还")
    @GetMapping(value = "/returnArticle")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050417220960019"),
    })
    public Result returnArticle(String id){
        assetArticleLeaseOrdersService.returnArticle(id);
        return new Result();
    }

    @ControllerLog(doAction = "确认交付")
    @ApiOperation(value = "确认交付",notes = "确认交付")
    @GetMapping(value = "/deliveryArticle")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "订单编号",example = "2019050417220960019"),
    })
    public Result deliveryArticle(String id){
        assetArticleLeaseOrdersService.deliveryArticle(id);
        return new Result();
    }


}
