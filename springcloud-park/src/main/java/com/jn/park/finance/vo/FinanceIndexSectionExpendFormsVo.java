package com.jn.park.finance.vo;

import com.jn.park.finance.model.FinanceBudgetMoneyModel;
import com.jn.park.finance.model.FinanceIndexSectionExpendFormsModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： tangry
 * @date： Created on 2019/3/5
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexSectionExpendFormsVo",description = "部门预算支出报表")
public class FinanceIndexSectionExpendFormsVo implements Serializable {


    private static final long serialVersionUID = -5279232210968272526L;
    @ApiModelProperty(value = "费用类型ID")
    private Integer costTypeId;

    @ApiModelProperty(value = "费用类型名称")
    private String costTypeName;

    @ApiModelProperty(value = "部门ID")
    private String departmentId;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "年度预算列表")
    private List<FinanceIndexSectionExpendFormsModel> financeIndexSectionExpendFormsModels;

    public Integer getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(Integer costTypeId) {
        this.costTypeId = costTypeId;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<FinanceIndexSectionExpendFormsModel> getFinanceIndexSectionExpendFormsModels() {
        return financeIndexSectionExpendFormsModels;
    }

    public void setFinanceIndexSectionExpendFormsModels(List<FinanceIndexSectionExpendFormsModel> financeIndexSectionExpendFormsModels) {
        this.financeIndexSectionExpendFormsModels = financeIndexSectionExpendFormsModels;
    }
}
