package com.jn.park.finance.dao;

import com.jn.park.finance.vo.FinanceWorkbenchMonitoringVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 智能工作台
 * @author： tangry
 * @date： Created on 2019/3/18
 * @version： v1.0
 * @modified By:
 */
@Component("FinanceWorkbenchDao")
public interface FinanceWorkbenchDao {

    /**
     * 财务监控
     * @param StartTime 开始
     * @param endTime 结束
     * @return
     */
    List<FinanceWorkbenchMonitoringVo> financeMonitoring(@Param("StartTime") String StartTime,@Param("endTime") String endTime);
}
