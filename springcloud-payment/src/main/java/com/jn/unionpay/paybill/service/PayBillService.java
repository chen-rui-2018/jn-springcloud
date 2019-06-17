package com.jn.unionpay.paybill.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.pay.model.CreateOrderAndPayReqModel;
import com.jn.pay.model.CreatePayReqModel;
import com.jn.pay.model.PayOrderNotify;
import com.jn.pay.model.PayOrderRsp;
import com.jn.paybill.model.*;
import com.jn.system.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 统一缴费单service
 * @author： jiangyl
 * @date： Created on 2019/3/12 11:21
 * @version： v1.0
 * @modified By:
 */
public interface PayBillService {

    /**
     * 根据条件查询账单数据
     * @param paymentBillParam
     * @return
     */
    PaginationData<List<PaymentBill>> getPaymentBillList(PaymentBillParam paymentBillParam);
    /**
     * 根据条件查询账单数据
     * @param billIds
     * @return
     */
    List<PaymentBill> getPaymentBillListByIds(String[] billIds);

    /**
     * 创建缴费账单,返回账单ID
     * @param paymentBillModel
     * @return 返回账单ID
     */
    String createBill(PaymentBillModel paymentBillModel);

    /**
     * 根据账单ID或账单编号查询账单详情
     * @param idOrNum
     * @return
     */
    PayBillVO getPayBillDetailByIdOrNum(String idOrNum);

    /**
     * 按天查询缴费系统中各分类的收入情况
     * @param payBillCountParam
     * @return
     */
    PayBillCountVO statisticsBillAmount(PayBillCountParam payBillCountParam);

    /**
     * 缴费单支付发起
     * @param createPayReqModel
     * @return
     */

    Result<PayOrderRsp> createPayOrder(CreatePayReqModel createPayReqModel);

    /**
     * 支付回调接口
     * @param payOrderNotify
     * @return
     */
    Result payCallBack(PayOrderNotify payOrderNotify);

    /**
     * 取消支付订单接口
     * @param orderId
     * @param account
     * @return
     */
    Integer cancelPayOrderById(String orderId,String account);

    /**
     * 获取当前用户支付订单列表
     * @param page
     * @param account
     * @return
     */
    PaginationData<List<PayOrderModel>> getPayOrderForUser(Page page,String account);

    /**
     * 根据订单ID获取订单详情（包含订单明细）
     * @param orderId
     * @return
     */
    PayOrderVO getPayOrderDetail(String orderId);

    /**
     * 通过账单号取消账单及生成的订单
     * @param payBillCancelParam
     * @return
     */
    Boolean cancelPayBillByBillNum(PayBillCancelParam payBillCancelParam);

    /**
     * 根据账单号取消对应的账单
     * @param billId
     * @return
     */
    Boolean cancelPayBillByBillId(String billId);


}
