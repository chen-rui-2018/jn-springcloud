package com.jn.park.finance.dao;

import com.jn.park.finance.model.*;
import com.jn.park.finance.vo.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 收入情况
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@Component("FinanceIndexDao")
public interface FinanceIndexDao {

    /**
     * 管委会支出/预算占比
     * @param financeIndexRatioStateModel 起止时间
     * @return
     */
    String ratioAndState(FinanceIndexRatioStateModel financeIndexRatioStateModel);

    /**
     * 全年支出/预算 统计柱状图-首页
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return
     */
    List<FinanceIndexExpendBudgetStatisticsVo> expendBudget(@Param("startTime")String startTime, @Param("endTime") String endTime);

    /**
     * 首页 - 各部门支出预算明细
     * @param map
     * @return
     */
    List<FinanceIndexBudgetExpendRatioVo> budgetExpendRatio(Map<String,Object> map);

    /**
     * 部门支出预算统计
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param departmentId 部门ID
     * @param typeId 类型
     * @return
     */
    List<FinanceIndexSectionBudgetExpendVo>  sectionBudgetExpend(@Param("startTime")String startTime,@Param("endTime")String endTime, @Param("departmentId")String departmentId, @Param("typeId")int typeId);

    /**
     * 部门资产明细/ 各项支出占比情况 饼状图
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param departmentId 部门 ID
     * @return
     */
    List<FinanceIndexExpendBudgetRatioVo>  accumulativeExpendRatio(@Param("startTime")String startTime, @Param("endTime")String endTime, @Param("departmentId") String departmentId);


    /**
     * 部门资产明细/ 各项支出占比情况 报表
     * @param startMonth 开始时间
     * @param endMonth 结束时间
     * @param departmentId 部门ID
     * @return
     */
    List<FinanceIndexSectionExpendFormsVo>  sectionExpendForms(@Param("startMonth")String startMonth, @Param("endMonth")String endMonth, @Param("departmentId") String departmentId);

    /**
     * 合计
     * @param startMonth
     * @param endMonth
     * @param departmentId
     * @return
     */

    List<FinanceIndexSectionExpendFormsModel> total(@Param("startMonth")String startMonth, @Param("endMonth")String endMonth,@Param("departmentId") String departmentId);

    /**
     * 类型下拉框
     * @return
     */
    List<FinanceIndexDownTypeModel> downType();

}
