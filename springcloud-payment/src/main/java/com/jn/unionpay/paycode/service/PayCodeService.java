package com.jn.unionpay.paycode.service;

import com.jn.paycode.model.PaymentCode;

import java.util.List;

/**
 * 支付字典service
 * @author： jiangyl
 * @date： Created on 2019/3/12 17:29
 * @version： v1.0
 * @modified By:
 */
public interface PayCodeService {

    /**
     * 查询账单类型值
     * @return
     */
    List<PaymentCode> getBillTypeList();

}
