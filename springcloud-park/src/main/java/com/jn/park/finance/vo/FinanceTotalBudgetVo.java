package com.jn.park.finance.vo;

import com.jn.park.finance.model.FinanceBudgetMoneyModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 14:46
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceTotalBudgetVo", description = "总预算")
public class FinanceTotalBudgetVo implements Serializable {


    private static final long serialVersionUID = -6442093408224615797L;

    @ApiModelProperty("费用类型ID")
    private Integer costTypeId;

    @ApiModelProperty("费用类型名称")
    private String costTypeName;

    @ApiModelProperty("部门ID")
    private String departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("月度预算列表")
    private List<FinanceBudgetMoneyModel> budgetMoneyModels;

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

    public List<FinanceBudgetMoneyModel> getBudgetMoneyModels() {
        return budgetMoneyModels;
    }

    public void setBudgetMoneyModels(List<FinanceBudgetMoneyModel> budgetMoneyModels) {
        this.budgetMoneyModels = budgetMoneyModels;
    }
}
