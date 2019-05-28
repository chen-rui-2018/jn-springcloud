package com.jn.park.pmpaybill.service;

import com.jn.park.property.model.PayCallBackNotify;
import com.jn.paycode.model.PaymentCode;

/**
 * 缴费单-类型条目管理service
 *
 * @author： shaobao
 * @date： Created on 2019/5/24 16:56
 * @version： v1.0
 * @modified By:
 **/
public interface PmPayBillService {

    /**
     * 每月1号凌辰两点,自动生成物业费账单明细
     */
    void autoGeneratePmPayBillDeatils();

    /**
     * 每月16号凌晨更新缴费单条目是否逾期状态
     */
    void updatePmPayBillItemExpireStatus();

    /**
     * 对处于已生成状态,但处于未发送账单的数据生成账单,推送给企业
     */
    void generatePmBill();

    /**
     * 物业费账单缴费回调接口
     *
     * @param payCallBackNotify
     */
    void pmPayBillCallBack(PayCallBackNotify payCallBackNotify);
}
