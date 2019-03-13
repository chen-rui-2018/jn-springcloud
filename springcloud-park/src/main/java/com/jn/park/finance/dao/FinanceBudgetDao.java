package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceTotalBudget;
import com.jn.park.finance.entity.TbFinanceTotalBudgetExample;
import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceBudgetHistoryQueryModel;
import com.jn.park.finance.model.FinanceBudgetQueryModel;
import com.jn.park.finance.vo.FinanceBudgetHistoryVo;
import com.jn.park.finance.vo.FinanceTotalBudgetVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FinanceBudgetDao {

    /**
     * 求总预算
     * @param departmentId
     * @param costTypeId
     * @param budgetMonth
     * @return
     */
    FinanceBudgetHistoryModel calcHistoryMoney(@Param("departmentId")String departmentId, @Param("costTypeId")Integer costTypeId, @Param("budgetMonth")String budgetMonth );

    /**
     * 查询总预算
     * @param financeBudgetQueryModel
     * @return
     */
    List<FinanceTotalBudgetVo> selectTotalBudget(FinanceBudgetQueryModel financeBudgetQueryModel);

    /**
     * 查询预算录入历史
     * @param financeBudgetHistoryQueryModel
     * @return
     */
    List<FinanceBudgetHistoryVo> selectBudgetHistory(FinanceBudgetHistoryQueryModel financeBudgetHistoryQueryModel);
}