package com.jn.unionpay.payremind.dao;

import com.jn.unionpay.payremind.model.PayRemindVO;

/**
 * 账单核对单
 * @author： jiangyl
 * @date： Created on 2019/3/18 11:55
 * @version： v1.0
 * @modified By:
 */
public interface PaymentRemindMapper {
    /**
     * 获取账单核对单详情
     * @param remindId
     * @return
     */
    PayRemindVO getBillRemindDetail(String remindId);
}
