package com.jn.enterprise.pay.service;

import com.jn.common.model.PaginationData;
import com.jn.common.model.Result;
import com.jn.enterprise.pay.model.*;
import com.jn.enterprise.pay.vo.PayBillVo;
import com.jn.pay.model.PayOrderNotify;
import com.jn.system.model.User;

import java.util.List;

/**
 * 我的账单(业务层)
 *
 * @author： wzy
 * @date： Created on 2019/5/2 17:15
 * @version： v1.0
 * @modified By:
 */
public interface MyPayBillService {

    /**
     * 查询账单
     * @param payBill
     * @return
     */
    PaginationData<List<PayBillVo>> getBillQueryList(PayBill payBill);

    /**
     * 账单催缴次数更新
     * @param billId,reminderNumber
     * @return
     */
    void updateBillNumber(String billId,int reminderNumber);

    /**
     * 核查提醒录入
     * @param payCheckReminder,user
     * @return
     */
    void billCheckReminder(PayCheckReminder payCheckReminder, User user);

    /**
     * 缴费单支付发起
     * @param payBIllInitiateParam,user
     * @param user
     * @return
     */
    Result startPayment(PayBIllInitiateParam payBIllInitiateParam, User user);

    /**
     * 支付回调接口
     * @param callBackParam
     * @return
     */
    String payCallBack(PayOrderNotify callBackParam, User user);
}
