package com.jn.park.pmpaybill.service;

import com.jn.park.pmpaybill.entity.TbPmPayBillItem;
import com.jn.park.property.model.PayCallBackNotify;

import java.util.List;

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
     * 批量生成缴费单
     *
     * @param pmPayBillItems
     */
    void generatePmBill(List<TbPmPayBillItem> pmPayBillItems);

    /**
     * 物业费账单缴费回调接口
     *
     * @param payCallBackNotify
     */
    void pmPayBillCallBack(PayCallBackNotify payCallBackNotify);
}
