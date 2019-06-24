package com.jn.enterprise.servicemarket.index.service;

import com.jn.enterprise.servicemarket.index.vo.DataStatisticsVO;

/**
 * @author： huxw
 * @date： Created on 2019-6-10 15:59:36
 * @version： v1.0
 * @modified By:
 */
public interface MarketIndexService {

    /**
     * 获取企业，机构，活动，服务专员数量
     * @return
     */
    DataStatisticsVO getDataStatistics();

}
