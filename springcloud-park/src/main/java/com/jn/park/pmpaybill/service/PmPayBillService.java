package com.jn.park.pmpaybill.service;

import com.jn.park.pmpaybill.entity.TbPmPayBillItem;
import com.jn.park.property.model.PayCallBackNotify;

import java.util.Date;
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
     * 每季度第一天凌晨,为企业生成物业费账单
     */
    void createPmPayBillByQuarter();

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

    /**
     * 为企业生成物业费账单明细
     *
     * @param companyId     公司id
     * @param rentStartTime 开始租赁时间
     */
    void createPmBill(String companyId, Date rentStartTime);
}
