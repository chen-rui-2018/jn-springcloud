package com.jn.pay.controller;/**
 * @author： huangbq
 * @date： Created on 2019/5/22 11:40
 * @version： v1.0
 * @modified By:
 */

import com.alibaba.fastjson.JSONObject;
import com.jn.common.model.Result;
import com.jn.common.util.LoadBalancerUtil;
import com.jn.pay.model.CreateOrderAndPayReqModel;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderRsp;
import com.jn.system.log.annotation.ControllerLog;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 *
 *<pre> 
 * 开发公司：深圳君南信息系统有限公司
 * 开发人员：huangbq
 * 邮箱地址：huangbq@op-mobile.com.cn
 * 创建时间：2019/5/22
 *</pre>
 */
@Api(tags = "统一发起支付")
@RestController
@RequestMapping("/pay")
public class PayController {

    @ControllerLog(doAction = "发起支付")
    @ApiOperation(value = "发起支付",notes = "发起支付单")
    @PostMapping(value = "/createPay")
    @RequiresPermissions("/pay/createPay")
    public Result<PayOrderRsp> createPay(CreatePayReqModel createPayReqModel){

        return new Result<PayOrderRsp>();
    }

    @ControllerLog(doAction = "创建订单并发起支付")
    @ApiOperation(value = "创建订单并发起支付",notes = "创建订单并发起支付单")
    @PostMapping(value = "/createOrderAndPay")
    @RequiresPermissions("/pay/createOrderAndPay")
    public Result<PayOrderRsp> createOrderAndPay(CreateOrderAndPayReqModel createOrderAndPayReqModel
                                                 ){
        return new Result<PayOrderRsp>();
    }
}
