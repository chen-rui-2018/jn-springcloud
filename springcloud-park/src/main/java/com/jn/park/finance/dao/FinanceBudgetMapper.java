package com.jn.park.finance.dao;

import com.jn.park.finance.entity.TbFinanceTotalBudget;
import com.jn.park.finance.entity.TbFinanceTotalBudgetExample;
import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface FinanceBudgetMapper {

    //查询预算历史中的总预算（按月统计）
    FinanceBudgetHistoryModel calcHistoryMoney(@Param("departmentId")String departmentId, @Param("costTypeId")Integer costTypeId, @Param("budgetMonth")Date budgetMonth );

    int updateTotal(@Param("departmentId") String departmentId,@Param("costTypeId")Integer costTypeId,@Param("budgetMonth")Date budgetMonth);
}