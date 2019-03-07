package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceDepartmentToTypeModel;
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
    List<FinanceTypeModel> selectTypeByDepartmentId(@Param("departmentId") String departmentId) ;

    /**
     * 查看所有部门
     * @param typeId
     * @return
     */
    List<FinanceDepartmentToTypeModel>selectDepartmentByTypeId(@Param("typeId") Integer typeId);
}