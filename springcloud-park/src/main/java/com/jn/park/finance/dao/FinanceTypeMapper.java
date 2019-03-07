package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceTypeModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FinanceTypeMapper {

    /**
     *  查看所有财务项目类型
     * @param departmentId
     * @return
     */
    List<FinanceTypeModel> selectByDepart(@Param("departmentId") String departmentId) ;
}