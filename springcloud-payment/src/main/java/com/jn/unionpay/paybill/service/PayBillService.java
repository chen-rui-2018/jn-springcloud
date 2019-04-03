package com.jn.unionpay.paybill.service;

import com.jn.common.model.Page;
import com.jn.common.model.PaginationData;
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
     * 创建缴费账单
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
     * @param payInitiateParam
     * @param user
     * @return
     */
    PayResponseVO startPayment(PayInitiateParam payInitiateParam, User user);

    /**
     * 支付回调接口
     * @param callBackParam
     * @return
     */
    PayCallBackVO payCallBack(PayCallBackParam callBackParam);

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


}
