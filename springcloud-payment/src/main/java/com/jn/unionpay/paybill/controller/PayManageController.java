package com.jn.unionpay.paybill.controller;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.PayBillEntryCallbackParam;
import com.jn.paybill.model.PaymentBill;
import com.jn.paybill.model.PaymentBillParam;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.service.PayBillService;
import com.jn.unionpay.payremind.model.PayBillEntryParam;
import com.jn.unionpay.payremind.model.PayRemindCheckParam;
import com.jn.unionpay.payremind.model.PayRemindVO;
import com.jn.unionpay.payremind.service.PayRemindService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 支付管理
 * @author： jiangyl
 * @date： Created on 2019/3/18 10:21
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "账单管理")
@RestController
@RequestMapping("/payment/manage")
public class PayManageController {

    @Autowired
    private PayBillService payBillService;
    @Autowired
    private PayRemindService payRemindService;

    @ControllerLog(doAction = "获取账单列表")
    @ApiOperation(value = "获取账单列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getBillList")
    public Result<PaginationData<List<PaymentBill>>> getPaymentBillList(@RequestBody PaymentBillParam paymentBillParam){
        PaginationData<List<PaymentBill>> paymentBillList = payBillService.getPaymentBillList(paymentBillParam);
        return new Result<>(paymentBillList);
    }

    @ControllerLog(doAction = "获取账单核对单详情")
    @ApiOperation(value = "获取账单核对单详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getBillRemindDetail")
    public Result<PayRemindVO> getBillRemindDetail(@ApiParam(value = "支付提醒remindId" ,required = true)
                                                       @RequestParam(value = "remindId") String remindId){
        Assert.notNull(remindId, PayBillExceptionEnum.PAYMENT_REMIND_ID_IS_NOT_NULL.getMessage());
        PayRemindVO payRemindVO = payRemindService.getBillRemindDetail(remindId);
        return new Result<>(payRemindVO);
    }

    @ControllerLog(doAction = "线下支付账单审核")
    @ApiOperation(value = "线下支付账单审核", httpMethod = "POST", response = Result.class,notes = "返回结果为响应账单条数")
    @RequestMapping(value = "/checkBillRemind")
    public Result<Integer> checkBillRemind(@RequestBody PayRemindCheckParam payRemindCheckParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = payRemindService.checkBillRemind(payRemindCheckParam,user.getAccount(),"3");
        return new Result<>(i);
    }

    @ControllerLog(doAction = "线上支付账单审核")
    @ApiOperation(value = "线上支付账单审核", httpMethod = "POST", response = Result.class,notes = "返回结果为响应账单条数")
    @RequestMapping(value = "/checkOnlineBillRemind")
    public Result<Integer> checkOnlineBillRemind(@RequestBody PayRemindCheckParam payRemindCheckParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = payRemindService.checkBillRemind(payRemindCheckParam,user.getAccount(),null);
        return new Result<>(i);
    }

    @ControllerLog(doAction = "缴费账单后台生成")
    @ApiOperation(value = "缴费账单后台生成", httpMethod = "POST", response = Result.class,notes = "返回结果为响应账单条数")
    @RequestMapping(value = "/createBillRemind")
    public Result<Integer> createBillRemind(@RequestBody PayBillEntryParam payBillEntryParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        int i = payRemindService.createBillRemind(payBillEntryParam,user.getAccount());
        return new Result<>(i);
    }

    @ControllerLog(doAction = "缴费单审核回调")
    @ApiOperation(value = "缴费单审核回调", httpMethod = "POST", response = Result.class,notes = "返回结果为响应账单条数")
    @RequestMapping(value = "/billRemindCheck")
    public Result<Integer> createBillCallback(@RequestBody PayBillEntryCallbackParam payBillEntryCallbackParam){
        int i = payRemindService.createBillCallback(payBillEntryCallbackParam);
        return new Result<>(i);
    }


}
