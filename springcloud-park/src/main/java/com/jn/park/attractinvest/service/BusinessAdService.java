package com.jn.park.attractinvest.service;

import com.jn.common.model.PaginationData;
import com.jn.park.attractinvest.model.BusinessAdContent;
import com.jn.park.attractinvest.model.BusinessAdDynamic;
import com.jn.park.attractinvest.model.BusinessAdPage;
import com.jn.park.attractinvest.model.BusinessAdPolicy;

import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2019/4/24 16:31
 * @version： v1.0
 * @modified By:
 **/
public interface BusinessAdService {

    /**
     * 获取招商信息
     *
     * @param page
     * @return
     */
    PaginationData<List<BusinessAdContent>> getBusinessAdContent(BusinessAdPage page);

    /**
     * 获取招商动态信息
     *
     * @return
     */
    List<BusinessAdDynamic> getBusinessAdDynamic();

    /**
     * 获取招商政策信息
     *
     * @return
     */
    List<BusinessAdPolicy> getBusinessAdPolicy();

    /**
     * 查询招商信息详情
     *
     * @param id 招商信息id
     * @return
     */
    BusinessAdContent getBusinessAdContentInfo(String id);

    /**
     * 根据招商动态id获取招商动态信息详情
     *
     * @param id 招商动态信息id
     * @return
     */
    BusinessAdDynamic getBusinessAdDynamicInfo(String id);

    /**
     * 根据招商政策id获取招商政策信息详情
     *
     * @param id
     * @return
     */
    BusinessAdPolicy getBusinessAdPolicyInfo(String id);

    /**
     * 定时更新招商信息,招商动态,招商政策状态
     */
    void updateBusinessAdStatus();
}
