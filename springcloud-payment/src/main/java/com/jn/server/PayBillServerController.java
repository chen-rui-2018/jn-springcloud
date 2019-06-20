package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.pay.model.CreateOrderAndPayReqModel;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.service.PayBillService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 统一缴费单接口：提供内部使用的API接口
 * @author： jiangyl
 * @date： Created on 2019/3/12 9:55
 * @version： v1.0
 * @modified By:
 */
@RestController
@RequestMapping("/api/pay/bill")
public class PayBillServerController extends BaseController implements PayBillClient {

    @Autowired
    private PayBillService payBillService;

    @ControllerLog(doAction = "获取账单列表")
    @ApiOperation(value = "获取账单列表", httpMethod = "POST")
    @RequestMapping(value = "/getPaymentBillList")
    @Override
    public Result<PaginationData<List<PaymentBill>>> getPaymentBillList(@RequestBody PaymentBillParam paymentBillParam){
        PaginationData<List<PaymentBill>> paymentBillList = payBillService.getPaymentBillList(paymentBillParam);
        return new Result<>(paymentBillList);
    }

    @ControllerLog(doAction = "创建账单")
    @ApiOperation(value = "创建账单,返回账单ID", httpMethod = "POST")
    @RequestMapping(value = "/createBill")
    @Override
    public Result<String> createBill(@RequestBody PaymentBillModel paymentBillModel){
        String bill = payBillService.createBill(paymentBillModel);
        return new Result<>(bill);
    }

    @ControllerLog(doAction = "获取账单详情")
    @ApiOperation(value = "获取账单详情", httpMethod = "POST")
    @RequestMapping(value = "/getPayBillDetailByIdOrNum")
    @Override
    public Result<PayBillVO> getPayBillDetailByIdOrNum(@RequestBody String idOrNum){
        return new Result<>(payBillService.getPayBillDetailByIdOrNum(idOrNum));
    }


    @ControllerLog(doAction = "按天查询缴费系统中各分类的收入情况")
    @ApiOperation(value = "按天查询缴费系统中各分类的收入情况", httpMethod = "POST")
    @RequestMapping(value = "/statisticsBillAmount")
    @Override
    public Result<PayBillCountVO> statisticsBillAmount(@RequestBody PayBillCountParam payBillCountParam){
        PayBillCountVO payBillCountVO = payBillService.statisticsBillAmount(payBillCountParam);
        return new Result<>(payBillCountVO);
    }

    @ControllerLog(doAction = "支付回调接口")
    @ApiOperation(value = "统一缴费--支付回调接口", httpMethod = "POST")
    @RequestMapping(value = "/payCallBack")
    @Override
    public Result payCallBack(@RequestBody PayOrderNotify payOrderNotify){
        return payBillService.payCallBack(payOrderNotify);
    }

    @ControllerLog(doAction = "根据账单IDs获取账单列表内容")
    @ApiOperation(value = "根据账单IDs获取账单列表内容",notes = "根据账单IDs获取账单列表内容", httpMethod = "POST")
    @RequestMapping(value = "/getPaymentBillListByIds")
    @Override
    public Result<List<PaymentBill>> getPaymentBillListByIds(@RequestBody String[] billIds){
        List<PaymentBill> paymentBillList = payBillService.getPaymentBillListByIds(billIds);
        return new Result<>(paymentBillList);
    }


    @ControllerLog(doAction = "获取订单详情")
    @ApiOperation(value = "获取订单详情", httpMethod = "POST")
    @RequestMapping(value = "/getPayOrderDetailByOrderId")
    @Override
    public Result<PayOrderVO> getPayOrderDetailByOrderId(@RequestBody String orderId){
        return new Result<>(payBillService.getPayOrderDetail(orderId));
    }

    @ControllerLog(doAction = "通过账单号取消账单及生成的订单")
    @ApiOperation(value = "通过账单号取消账单及生成的订单", httpMethod = "POST")
    @RequestMapping(value = "/cancelPayBillByBillNum")
    @Override
    public Result<Boolean> cancelPayBillByBillNum(@RequestBody PayBillCancelParam payBillCancelParam){
        return new Result<>(payBillService.cancelPayBillByBillNum(payBillCancelParam));
    }

    @ControllerLog(doAction = "根据账单号取消对应的账单")
    @ApiOperation(value = "根据账单号取消对应的账单", httpMethod = "POST")
    @RequestMapping(value = "/cancelPayBillByBillId")
    @Override
    public Result<Boolean> cancelPayBillByBillId(@RequestBody String orderId){
        return new Result<>(payBillService.cancelPayBillByBillId(orderId));
    }


    @ControllerLog(doAction = "统一缴费-->发起支付")
    @Override
    @RequestMapping(value = "/createPayOrder")
    public Result<PayOrderRsp> createPayOrder(@RequestBody CreatePayReqModel createPayReqModel) {
        return payBillService.createPayOrder(createPayReqModel);
    }
}
