package com.jn.park.finance.dao;

import com.jn.park.finance.vo.FinanceIncomeLastYearContrastVo;
import com.jn.park.finance.vo.FinanceIncomePeriodVo;
import com.jn.park.finance.vo.FinanceIncomeSummarizingProportionVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * 收入情况
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@Component("FinanceIncomeDao")
public interface FinanceIncomeDao {

    /**
     * 明细,同期对比
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<FinanceIncomePeriodVo> periodContrast(@Param("startTime") String startTime,@Param("endTime") String endTime);

    /**
     * 汇总占比
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<FinanceIncomeSummarizingProportionVo> summarizingProportion(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * 汇总占比
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<FinanceIncomeLastYearContrastVo> lastYearContrast(@Param("startTime") String startTime, @Param("endTime") String endTime);
}
