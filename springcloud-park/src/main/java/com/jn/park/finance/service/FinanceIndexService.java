package com.jn.park.finance.service;

import com.jn.park.finance.model.FinanceIndexDownTypeModel;
import com.jn.park.finance.model.FinanceIndexExpendBudgetRatioModel;
import com.jn.park.finance.vo.*;

import java.util.List;

/**
 * 监控首页
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
public interface FinanceIndexService {
    /**
     * 管委会支出/预算占比，状态
     * @param year
     * @return
     */
    FinanceIndexVo ratioAndState(String year);

    /**
     * 首页-各部门预算支出占比模块
     * @param year 年份
     * @return
     */
    List<FinanceIndexBudgetExpendRatioVo> budgetExpendRatio(String year);

    /**
     * 全年支出/预算 统计柱状图
     * @param year 年份
     * @return
     */
    FianceDynamicTableVo<List<FinanceIndexExpendBudgetStatisticsVo>>  expendBudget(String year);

    /**
     * 部门支出预算统计
     * @param year 年份
     * @param departmentId  部门ID
     * @param typeId 类型ID
     * @return
     */
    List<FinanceIndexSectionBudgetExpendVo>  sectionBudgetExpend(String year, String departmentId, String typeId);

    /**
     * 部门资产明细/ 各项支出占比情况
     * @param year 年份
     * @param departmentId 部门ID
     * @return
     */
    List<FinanceIndexExpendBudgetRatioVo>  accumulativeExpendRatio(String year, String departmentId);

    /**
     * 部门资产明细/ 各项支出预算报表
     * @param year 年份
     * @param departmentId 部门ID
     * @return
     */
    FianceDynamicTableVo<List<FinanceIndexSectionExpendFormsVo>>  sectionExpendForms(String year, String departmentId);

    /**
     * 导出
     * @param year 年份
     * @param departmentId 部门ID
     * @return
     */
    List<FinanceIndexExpendFormsExportVo>  expendFormsExport(String year, String departmentId);

    /**
     * 类型下拉框
     * @return
     */
    List<FinanceIndexDownTypeModel> downType();
}
