package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.model.BusinessAdDynamic;

import java.util.List;

/**
 * 招商动态dao
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 16:38
 * @version： v1.0
 * @modified By:
 **/
public interface BusinessAdDynamicMapper {

    /**
     * 获取招商动态信息
     *
     * @return
     */
    List<BusinessAdDynamic> getBusinessAdDynamic();

    /**
     * 更新招商动态状态
     */
    void updateBusinessAdStatus();
}