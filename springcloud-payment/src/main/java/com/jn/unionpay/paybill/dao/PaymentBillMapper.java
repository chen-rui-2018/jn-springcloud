package com.jn.unionpay.paybill.dao;

import com.jn.paybill.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/12 16:26
 * @version： v1.0
 * @modified By:
 */
public interface PaymentBillMapper {

    /**
     * 根据账单ID或账单编号查询账单详情
     * @param idOrNum
     * @return
     */
    PayBillVO getPayBillDetailByIdOrNum(@Param("idOrNum")String idOrNum);

    /**
     * 根据条件查询某个用户账单数据
     * @param paymentBillParam
     * @return
     */
    List<PaymentBill> getPaymentBillList(PaymentBillParam paymentBillParam);

    /**
     * 按天查询缴费系统中各分类的收入情况
     * @param payBillCountParam
     * @return
     */
    List<PayBillSubCount> statisticsBillAmountSubCount(PayBillCountParam payBillCountParam);

    /**
     * 查询当前时段类缴费总金额
     * @param payBillCountParam
     * @return
     */
    PayBillCountVO statisticsBillAmount(PayBillCountParam payBillCountParam);
}
