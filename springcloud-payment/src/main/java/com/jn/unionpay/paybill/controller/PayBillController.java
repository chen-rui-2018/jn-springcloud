package com.jn.unionpay.paybill.controller;

import com.jn.common.controller.BaseController;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.common.util.Assert;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import com.jn.paybill.enums.PayBillExceptionEnum;
import com.jn.paybill.model.*;
import com.jn.system.log.annotation.ControllerLog;
import com.jn.system.model.User;
import com.jn.unionpay.paybill.service.PayBillService;
import io.swagger.annotations.*;
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

    @ControllerLog(doAction = "根据账单IDs获取账单列表内容")
    @ApiOperation(value = "根据账单IDs获取账单列表内容",notes = "根据账单IDs获取账单列表内容[不分页查询]")
    @RequestMapping(value = "/getPaymentBillListByBillIds",method = RequestMethod.GET)
    public Result<List<PaymentBill>> getPaymentBillListByBillIds(@ApiParam(name="billIds",value = "账单ID或编号",required = true,example = "{'123**','235***'}")
                                                                        @RequestParam(value = "billIds") String[] billIds){
        List<PaymentBill> paymentBillList = payBillService.getPaymentBillListByIds(billIds);
        return new Result<>(paymentBillList);
    }

    @ControllerLog(doAction = "获取账单详情")
    @ApiOperation(value = "获取账单详情",notes = "可根据账单ID和账单编号查询")
    @RequestMapping(value = "/getPayBillDetailByIdOrNum",method = RequestMethod.GET)
    public Result<PayBillVO> getPayBillDetailByIdOrNum(
            @ApiParam(name="idOrNum",value = "账单ID或编号",required = true,example = "TC-2019031910124")
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


    @ControllerLog(doAction = "支付回调接口")
    @ApiOperation(value = "统一缴费--支付回调接口", httpMethod = "POST", response = Result.class)
    @RequestMapping(value = "/payCallBack")
    public Result payCallBack(@RequestBody PayOrderNotify payOrderNotify){
        return payBillService.payCallBack(payOrderNotify);
    }


}
