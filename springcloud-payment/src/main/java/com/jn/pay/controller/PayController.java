package com.jn.pay.controller;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 11:40
 * @version： v1.0
 * @modified By:
 */

import com.alibaba.druid.support.http.util.IPAddress;
import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.pay.model.CreateOrderAndPayReqModel;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderRsp;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 *统一发起支付-所有业务都从这里发起支付
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/22
 *</pre>
 */
@Api(tags = "统一发起支付(所有业务都从这里发起支付)")
@RestController
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private LoadBalancerUtil loadBalancerUtil;

    private static Result NOT_SUPPORT_RESULT=new Result<>("-1","暂不支持的此缴费类型");

    @ControllerLog(doAction = "发起支付")
    @ApiOperation(value = "发起支付",notes = "发起支付单")
    @PostMapping(value = "/createPay")
    @RequiresPermissions("/pay/createPay")
    public Result<PayOrderRsp> createPay(@Validated @RequestBody CreatePayReqModel createPayReqModel){
        createPayReqModel.setUserAccount(getUser().getAccount());
        createPayReqModel.setUserIp("");//todo 需要获取用户IP
        switch (createPayReqModel.getPayType()){
            case ELECTRIC://
                return NOT_SUPPORT_RESULT;
            case PROPERTY://
                return NOT_SUPPORT_RESULT;
            case REPAIR://
                return NOT_SUPPORT_RESULT;
            case ROOM_LEASE://
                return loadBalancerUtil.getClientPostForEntity("springcloud-park","/api/order/createPay",JSONObject.toJSONString(createPayReqModel));
            case GOODS_LEASE://
                return loadBalancerUtil.getClientPostForEntity("springcloud-park","/api/order/createArticlePay",JSONObject.toJSONString(createPayReqModel));
            case TEMPORARY_PARKING://
                return NOT_SUPPORT_RESULT;
            case PARKING_LEASE://
                return NOT_SUPPORT_RESULT;
            case WATER://
                return NOT_SUPPORT_RESULT;
            case PROMOTION://
                return NOT_SUPPORT_RESULT;
            case HEALTH://
                return NOT_SUPPORT_RESULT;
            case ELECTRIC_RECHARGE:
                return NOT_SUPPORT_RESULT;
                default:
                    return NOT_SUPPORT_RESULT;
        }

    }

    @ControllerLog(doAction = "创建订单并发起支付")
    @ApiOperation(value = "创建订单并发起支付",notes = "创建订单并发起支付单")
    @PostMapping(value = "/createOrderAndPay")
    @RequiresPermissions("/pay/createOrderAndPay")
    public Result<PayOrderRsp> createOrderAndPay(@Validated @RequestBody CreateOrderAndPayReqModel createOrderAndPayReqModel){
        createOrderAndPayReqModel.setUserAccount(getUser().getAccount());
        //缴费类型（1电费，2物业费，3维修费，4房租，5物品租赁，6停车费，7车位费，8水费，9宣传费，10体验费，11预缴充值电费）
        switch (createOrderAndPayReqModel.getPayType()){
            case ELECTRIC://
                return loadBalancerUtil.getClientPostForEntity("springcloud-enterprise","/api/payment/payBill/createOrderAndPay",JSONObject.toJSONString(createOrderAndPayReqModel));
            case PROPERTY://
                return loadBalancerUtil.getClientPostForEntity("springcloud-enterprise","/api/payment/payBill/createOrderAndPay",JSONObject.toJSONString(createOrderAndPayReqModel));
            case REPAIR://
                return loadBalancerUtil.getClientPostForEntity("springcloud-enterprise","/api/payment/payBill/createOrderAndPay",JSONObject.toJSONString(createOrderAndPayReqModel));
            case ROOM_LEASE://
                return loadBalancerUtil.getClientPostForEntity("springcloud-enterprise","/api/payment/payBill/createOrderAndPay",JSONObject.toJSONString(createOrderAndPayReqModel));
            case GOODS_LEASE://
                return NOT_SUPPORT_RESULT;
            case TEMPORARY_PARKING://
                return NOT_SUPPORT_RESULT;
            case PARKING_LEASE://
                return NOT_SUPPORT_RESULT;
            case WATER://
                return NOT_SUPPORT_RESULT;
            case PROMOTION://
                return NOT_SUPPORT_RESULT;
            case HEALTH://
                return NOT_SUPPORT_RESULT;
            case ELECTRIC_RECHARGE:
                return loadBalancerUtil.getClientPostForEntity("springcloud-enterprise","/api/payment/payAccount/createOrderAndPay",JSONObject.toJSONString(createOrderAndPayReqModel));
            default:
                return NOT_SUPPORT_RESULT;

        }
    }
    private User getUser(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }
}
