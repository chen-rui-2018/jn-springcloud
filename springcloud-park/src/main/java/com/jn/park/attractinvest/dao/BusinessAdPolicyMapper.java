package com.jn.park.attractinvest.dao;

import com.jn.park.attractinvest.model.BusinessAdPolicy;

import java.util.List;

/**
 * 招商政策dao
 *
 * @author： shaobao
 * @date： Created on 2019/4/24 19:04
 * @version： v1.0
 * @modified By:
 **/
public interface BusinessAdPolicyMapper {

    /**
     * 获取招商政策信息
     *
     * @return
     */
    List<BusinessAdPolicy> getBusinessAdPolicy();

    /**
     * 更新招商政策状态
     */
    void updateBusinessAdStatus();
}
