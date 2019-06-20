package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayBill;

import java.util.List;

/**
 * 缴费单的dao层
 *
 * @author： shaobao
 * @date： Created on 2019/5/25 19:46
 * @version： v1.0
 * @modified By:
 **/
public interface PmPayBillMapper {

    /**
     * 批量插入缴费单信息
     * @param tbPmPayBillList
     */
    void insertBatch(List<TbPmPayBill> tbPmPayBillList);
}
