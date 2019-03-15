package com.jn.unionpay.paybill.service;

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
     * 根据条件查询某个用户账单数据
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
}
