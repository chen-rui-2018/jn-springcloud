package com.jn.server;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.paybill.api.PayBillClient;
import com.jn.paybill.model.PayBillVO;
import com.jn.paybill.model.PaymentBill;
import com.jn.paybill.model.PaymentBillModel;
import com.jn.paybill.model.PaymentBillParam;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.unionpay.paybill.service.PayBillService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @ApiOperation(value = "获取账单列表", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getBillList")
    @Override
    public Result<PaginationData<List<PaymentBill>>> getPaymentBillList(@RequestBody PaymentBillParam paymentBillParam){
        PaginationData<List<PaymentBill>> paymentBillList = payBillService.getPaymentBillList(paymentBillParam);
        return new Result<>(paymentBillList);
    }

    @ControllerLog(doAction = "创建账单")
    @ApiOperation(value = "创建账单", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/createBill")
    @Override
    public Result<String> createBill(@RequestBody PaymentBillModel paymentBillModel){
        String bill = payBillService.createBill(paymentBillModel);
        return new Result<>(bill);
    }

    @ControllerLog(doAction = "获取账单详情")
    @ApiOperation(value = "获取账单详情", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/getPayBillDetailByIdOrNum")
    @Override
    public Result<PayBillVO> getPayBillDetailByIdOrNum(@RequestParam String idOrNum){
        return new Result<>(payBillService.getPayBillDetailByIdOrNum(idOrNum));
    }
}
