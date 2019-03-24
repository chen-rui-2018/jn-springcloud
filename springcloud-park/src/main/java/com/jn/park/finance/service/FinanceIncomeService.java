package com.jn.park.finance.service;

import com.jn.park.finance.vo.*;

import java.util.List;

/**
 * 收入情况
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
public interface FinanceIncomeService {

    /**
     * 明细,同期对比
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<FinanceIncomePeriodVo> periodContrast(String startTime,String endTime);

    /**
     * 汇总占比
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<FinanceIncomeSummarizingProportionVo> summarizingProportion(String startTime, String endTime);


    /**
     * 往年对比
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    FianceDynamicTableVo<List<FinanceIncomeLastYearContrastVo>> lastYearContrast(String startTime, String endTime);

    /**
     * 导出往年对比数据
     * @param year 年份
     * @return
     */
    List<FinanceIncomeExportContrastVo> exportContrast(String year);


}
