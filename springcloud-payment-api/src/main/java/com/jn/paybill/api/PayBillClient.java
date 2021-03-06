package com.jn.paybill.api;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.pay.model.CreateOrderAndPayReqModel;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import com.jn.paybill.model.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 统一缴费账单客户端
 * @author： jiangyl
 * @date： Created on 2019/3/12 10:09
 * @version： v1.0
 * @modified By:
 */
@FeignClient("springcloud-payment")
public interface PayBillClient {
    /**
     * 获取账单列表
     * @param paymentBillParam
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/getPaymentBillList", method = RequestMethod.POST)
    Result<PaginationData<List<PaymentBill>>> getPaymentBillList(@RequestBody PaymentBillParam paymentBillParam);


    /**
     * 创建账单,返回账单ID
     * @param paymentBillModel
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/createBill", method = RequestMethod.POST)
    Result<String> createBill(@RequestBody PaymentBillModel paymentBillModel);

    /**
     * 获取账单详情
     * @param idOrNum
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/getPayBillDetailByIdOrNum", method = RequestMethod.POST)
    Result<PayBillVO> getPayBillDetailByIdOrNum(@RequestBody String idOrNum);

    /**
     * 根据订单ID获取订单详情
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/getPayOrderDetailByOrderId", method = RequestMethod.POST)
    Result<PayOrderVO> getPayOrderDetailByOrderId(@RequestBody String orderId);

    /**
     * 按天查询缴费系统中各分类的收入情况
     * @param payBillCountParam
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/statisticsBillAmount", method = RequestMethod.POST)
    Result<PayBillCountVO> statisticsBillAmount(@RequestBody PayBillCountParam payBillCountParam);

    /**
     * 支付回调接口
     * @param payOrderNotify
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/payCallBack", method = RequestMethod.POST)
    Result payCallBack(@RequestBody PayOrderNotify payOrderNotify);

    /**
     * 根据账单IDs获取账单列表内容
     * @param billIds
     * @return
     */
    @RequestMapping(value = "/api/pay/bill/getPaymentBillListByIds", method = RequestMethod.POST)
    Result<List<PaymentBill>> getPaymentBillListByIds(@RequestBody String[] billIds);

    /**
     * 根据账单号取消账单及生成的订单
     * @param payBillCancelParam
     * @return true取消成功 false取消失败
     */
    @RequestMapping(value = "/api/pay/bill/cancelPayBillByBillNum", method = RequestMethod.POST)
    Result<Boolean> cancelPayBillByBillNum(@RequestBody PayBillCancelParam payBillCancelParam);

    /**
     * 根据账单号取消对应的账单
     * @param orderId
     * @return true取消成功 false取消失败
     */
    @RequestMapping(value = "/api/pay/bill/cancelPayBillByBillId", method = RequestMethod.POST)
    Result<Boolean> cancelPayBillByBillId(@RequestBody String orderId);

    /**
     * 发起支付
     * @param createPayReqModel
     * @return
     */
    @ApiOperation(value = "发起支付")
    @RequestMapping(value = "/api/pay/bill/createPayOrder",method = RequestMethod.POST)
    Result<PayOrderRsp> createPayOrder(@RequestBody CreatePayReqModel createPayReqModel);
}
