package com.jn.unionpay.payremind.service;

import com.jn.paybill.model.PayBillEntryCallbackParam;
import com.jn.unionpay.payremind.model.PayBillEntryParam;
import com.jn.unionpay.payremind.model.PayRemindCheckParam;
import com.jn.unionpay.payremind.model.PayRemindParam;
import com.jn.unionpay.payremind.model.PayRemindVO;

/**
 * 账单核对
 * @author： jiangyl
 * @date： Created on 2019/3/15 17:02
 * @version： v1.0
 * @modified By:
 */
public interface PayRemindService {

    /**
     * 保存账单核对提醒信息
     * @param payRemindParam
     * @param account
     * @return
     */
    int saveCheckRemind(PayRemindParam payRemindParam,String account);

    /**
     * 获取账单核对单详情
     * @param remindId
     * @return
     */
    PayRemindVO getBillRemindDetail(String remindId);

    /**
     * 线下支付账单审核
     * @param payRemindCheckParam
     * @param account
     * @param payType 支付方式 null表示线上支付
     * @return
     */
    int checkBillRemind(PayRemindCheckParam payRemindCheckParam,String account,String payType);

    /**
     * 后台管理员生成账单
     * @param payBillEntryParam
     * @param account
     * @return
     */
    int createBillRemind(PayBillEntryParam payBillEntryParam, String account);

    /**
     * 审核流回调接口 - 账单生成业务
     * @param payBillEntryCallbackParam
     * @return
     */
    int createBillCallback(PayBillEntryCallbackParam payBillEntryCallbackParam);

}
