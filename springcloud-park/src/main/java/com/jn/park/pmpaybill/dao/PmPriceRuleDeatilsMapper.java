package com.jn.park.pmpaybill.dao;

import com.jn.park.pmpaybill.entity.TbPmPriceRuleDeatils;

import java.util.List;

/**
 * 物业费规则明细dao
 *
 * @author： shaobao
 * @date： Created on 2019/6/10 15:55
 * @version： v1.0
 * @modified By:
 **/
public interface PmPriceRuleDeatilsMapper {

    /**
     * 物业费单价规则管理明细批量插入
     *
     * @param tbPmPriceRuleDeatilsList
     */
    void insertBatch(List<TbPmPriceRuleDeatils> tbPmPriceRuleDeatilsList);
}
