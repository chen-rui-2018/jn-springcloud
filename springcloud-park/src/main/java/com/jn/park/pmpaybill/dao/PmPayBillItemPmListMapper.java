package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPayBillItemPmList;

import java.util.List;

/**
 * 物业费条目明细的dao层
 *
 * @author： shaobao
 * @date： Created on 2019/5/25 19:46
 * @version： v1.0
 * @modified By:
 **/
public interface PmPayBillItemPmListMapper {

    /**
     * 批量插入物业费详情信息
     * @param tbPmPayBillItemPmList
     */
    void insertBatch(List<TbPmPayBillItemPmList> tbPmPayBillItemPmList);
}
