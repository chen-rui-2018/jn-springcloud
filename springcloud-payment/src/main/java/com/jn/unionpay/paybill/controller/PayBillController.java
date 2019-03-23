package com.jn.unionpay.paybill.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.service.PayBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 统一缴费
 * @author： jiangyl
 * @date： Created on 2019/3/12 9:52
 * @version： v1.0
 * @modified By:
 */
@Api(tags = "统一缴费")
@RestController
@RequestMapping("/guest/pay/bill")
public class PayBillController extends BaseController {

    @Autowired
    private PayBillService payBillService;

    @ControllerLog(doAction = "获取账单列表")
    @ApiOperation(value = "获取账单列表",notes = "查询账单列表")
    @RequestMapping(value = "/getBillList",method = RequestMethod.GET)
    public Result<PaginationData<List<PaymentBill>>> getPaymentBillList(PaymentBillParam paymentBillParam){
        PaginationData<List<PaymentBill>> paymentBillList = payBillService.getPaymentBillList(paymentBillParam);
        return new Result<>(paymentBillList);
    }

    @ControllerLog(doAction = "创建账单")
    @ApiOperation(value = "创建账单【只供内部API调用，这里只用于测试】",notes = "【只供内部API调用，这里只用于测试】")
    @RequestMapping(value = "/createBill",method = RequestMethod.POST)
    public Result<String> createBill(@RequestBody PaymentBillModel paymentBillModel){
        String bill = payBillService.createBill(paymentBillModel);
        return new Result<>(bill);
    }

    @ControllerLog(doAction = "获取账单详情")
    @ApiOperation(value = "获取账单详情",notes = "可根据账单ID和账单编号查询")
    @RequestMapping(value = "/getPayBillDetailByIdOrNum",method = RequestMethod.GET)
    public Result<PayBillVO> getPayBillDetailByIdOrNum(
            @ApiParam(name="idOrNum",value = "账单ID或编号",required = true)
            @RequestParam(value = "idOrNum") String idOrNum){
        Assert.notNull(idOrNum, PayBillExceptionEnum.BILL_ID_OR_NUM_IS_NOT_NULL.getMessage());
        return new Result<>(payBillService.getPayBillDetailByIdOrNum(idOrNum));
    }

    @ControllerLog(doAction = "按天查询缴费系统中各分类的收入情况")
    @ApiOperation(value = "按天查询缴费系统中各分类的收入情况",notes = "API接口和前端都可调用这个类")
    @RequestMapping(value = "/statisticsBillAmount",method = RequestMethod.GET)
    public Result<PayBillCountVO> statisticsBillAmount(PayBillCountParam payBillCountParam){
        PayBillCountVO payBillCountVO = payBillService.statisticsBillAmount(payBillCountParam);
        return new Result<>(payBillCountVO);
    }

    /**
     * 支付发起接口
     * @param payInitiateParam
     * @return
     */
    @ControllerLog(doAction = "统一缴费--发起支付")
    @ApiOperation(value = "统一缴费--发起支付")
    @RequestMapping(value = "/startPayment",method = RequestMethod.POST)
    public Result<PayResponseVO> startPayment(@RequestBody PayInitiateParam payInitiateParam){
        User user=(User) SecurityUtils.getSubject().getPrincipal();
        return new Result<>(payBillService.startPayment(payInitiateParam,user));
    }


    @ControllerLog(doAction = "支付回调接口")
    @ApiOperation(value = "统一缴费--支付回调接口", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/payCallBack")
    public Result<PayCallBackVO> payCallBack(@RequestBody PayCallBackParam callBackParam){
        return new Result<>(payBillService.payCallBack(callBackParam));
    }




}
