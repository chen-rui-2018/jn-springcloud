package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayBillItem;

import java.util.List;

/**
 * 缴费单条目的dao层
 *
 * @author： shaobao
 * @date： Created on 2019/5/25 19:46
 * @version： v1.0
 * @modified By:
 **/
public interface PmPayBillItemMapper {

    /**
     * 批量插入缴费单条目信息
     *
     * @param tbPmPayBillItemList
     */
    void insertBatch(List<TbPmPayBillItem> tbPmPayBillItemList);

    /**
     * 更新企业缴费单条目状态
     */
    void updatePmPayBillItemExpireStatus();

    /**
     * 批量更新物业费发送状态
     *
     * @param tbPmPayBillItemList
     */
    void updateBatchItemSendStatus(List<TbPmPayBillItem> tbPmPayBillItemList);
}
