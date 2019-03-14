package com.jn.unionpay.paybill.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.unionpay.paybill.service.PayBillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    private static Logger logger = LoggerFactory.getLogger(PayBillController.class);

    @Autowired
    private PayBillService payBillService;

    @ControllerLog(doAction = "获取账单列表")
    @ApiOperation(value = "获取账单列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getBillList")
    public Result<PaginationData<List<PaymentBill>>> getPaymentBillList(@RequestBody PaymentBillParam paymentBillParam){
        PaginationData<List<PaymentBill>> paymentBillList = payBillService.getPaymentBillList(paymentBillParam);
        return new Result<>(paymentBillList);
    }

    @ControllerLog(doAction = "创建账单【只供内部API调用，这里只用于测试】")
    @ApiOperation(value = "创建账单", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/createBill")
    public Result<String> createBill(@RequestBody PaymentBillModel paymentBillModel){
        String bill = payBillService.createBill(paymentBillModel);
        return new Result<>(bill);
    }

    @ControllerLog(doAction = "获取账单详情")
    @ApiOperation(value = "获取账单详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getPayBillDetailByIdOrNum")
    public Result<PayBillVO> getPayBillDetailByIdOrNum(
            @ApiParam(name="idOrNum",value = "账单ID或编号",required = true)
            @RequestParam(value = "idOrNum") String idOrNum){
        Assert.notNull(idOrNum, PayBillExceptionEnum.BILL_ID_OR_NUM_IS_NOT_NULL.getMessage());
        return new Result<>(payBillService.getPayBillDetailByIdOrNum(idOrNum));
    }

    @ControllerLog(doAction = "按天查询缴费系统中各分类的收入情况")
    @ApiOperation(value = "按天查询缴费系统中各分类的收入情况", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/statisticsBillAmount")
    public Result<PayBillCountVO> statisticsBillAmount(@RequestBody PayBillCountParam payBillCountParam){
        PayBillCountVO payBillCountVO = payBillService.statisticsBillAmount(payBillCountParam);
        return new Result<>(payBillCountVO);
    }

    /**
     * 支付发起接口
     * @param payInitiateParam
     * @return
     */
    @ControllerLog(doAction = "统一缴费--发起支付")
    @ApiOperation(value = "统一缴费--发起支付", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/statisticsBillAmount")
    public Result<PayResponseVO> startPayment(@RequestBody PayInitiateParam payInitiateParam){
        return new Result<>(payBillService.startPayment(payInitiateParam));
    }


    //TODO 支付回调接口


}
