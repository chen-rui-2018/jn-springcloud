package com.jn.park.finance.dao;

import com.jn.park.finance.model.FinanceBudgetHistoryModel;
import com.jn.park.finance.model.FinanceDepartmentToTypeModel;
import com.jn.park.finance.model.FinanceTypeModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FinanceTypeDao {

    /**
     *  查看所有财务项目类型
     * @param departmentIds
     * @return
     */
//    List<FinanceTypeModel> selectTypeByDepartmentId(@Param("departmentId") String departmentId) ;
    List<FinanceTypeModel> selectTypeByDepartmentIds(@Param("departmentIds") String departmentIds,@Param("name") String name) ;

    /**
     * 查看所有部门
     * @param typeId
     * @return
     */
    List<FinanceDepartmentToTypeModel>selectDepartmentByTypeId(@Param("typeId") Integer typeId);
}