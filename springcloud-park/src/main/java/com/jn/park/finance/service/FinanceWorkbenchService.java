package com.jn.park.finance.service;

import com.jn.park.finance.vo.FinanceWorkbenchMonitoringVo;

import java.util.List;

/**
 * 智能工作台
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
public interface FinanceWorkbenchService {

    /**
     * 财务监控
     * @return
     */
    List<FinanceWorkbenchMonitoringVo> financeMonitoring();
}
