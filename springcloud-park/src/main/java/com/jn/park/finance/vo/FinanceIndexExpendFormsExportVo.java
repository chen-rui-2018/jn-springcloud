package com.jn.park.finance.vo;

import com.jn.park.finance.model.FinanceIndexSectionExpendFormsModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author： tangry
 * @date： Created on 2019/3/21
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIndexExpendFormsExportVo",description = "导出部门预算支出报表")
public class FinanceIndexExpendFormsExportVo implements Serializable {


    @ApiModelProperty(value = "费用类型名称")
    private String costTypeName;

    @ApiModelProperty("1月支出")
    private BigDecimal cost1;
    @ApiModelProperty("1月预算")
    private BigDecimal budgetNumber1;

    @ApiModelProperty("2月支出")
    private BigDecimal cost2;
    @ApiModelProperty("2月预算")
    private BigDecimal budgetNumber2;

    @ApiModelProperty("3月支出")
    private BigDecimal cost3;
    @ApiModelProperty("3月预算")
    private BigDecimal budgetNumber3;

    @ApiModelProperty("4月预算")
    private BigDecimal budgetNumber4;
    @ApiModelProperty("4月支出")
    private BigDecimal cost4;

    @ApiModelProperty("5月预算")
    private BigDecimal budgetNumber5;
    @ApiModelProperty("5月支出")
    private BigDecimal cost5;

    @ApiModelProperty("6月预算")
    private BigDecimal budgetNumber6;
    @ApiModelProperty("6月支出")
    private BigDecimal cost6;

    @ApiModelProperty("7月预算")
    private BigDecimal budgetNumber7;
    @ApiModelProperty("7月支出")
    private BigDecimal cost7;

    @ApiModelProperty("8月预算")
    private BigDecimal budgetNumber8;
    @ApiModelProperty("8月支出")
    private BigDecimal cost8;

    @ApiModelProperty("9月预算")
    private BigDecimal budgetNumber9;
    @ApiModelProperty("9月支出")
    private BigDecimal cost9;

    @ApiModelProperty("10月支出")
    private BigDecimal cost10;
    @ApiModelProperty("10月预算")
    private BigDecimal budgetNumber10;

    @ApiModelProperty("11月支出")
    private BigDecimal cost11;
    @ApiModelProperty("11月预算")
    private BigDecimal budgetNumber11;

    @ApiModelProperty("12月支出")
    private BigDecimal cost12;
    @ApiModelProperty("12月预算")
    private BigDecimal budgetNumber12;


    public String getCostTypeName() {
        return costTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public BigDecimal getCost1() {
        return cost1;
    }

    public void setCost1(BigDecimal cost1) {
        this.cost1 = cost1;
    }

    public BigDecimal getBudgetNumber1() {
        return budgetNumber1;
    }

    public void setBudgetNumber1(BigDecimal budgetNumber1) {
        this.budgetNumber1 = budgetNumber1;
    }

    public BigDecimal getCost2() {
        return cost2;
    }

    public void setCost2(BigDecimal cost2) {
        this.cost2 = cost2;
    }

    public BigDecimal getBudgetNumber2() {
        return budgetNumber2;
    }

    public void setBudgetNumber2(BigDecimal budgetNumber2) {
        this.budgetNumber2 = budgetNumber2;
    }

    public BigDecimal getCost3() {
        return cost3;
    }

    public void setCost3(BigDecimal cost3) {
        this.cost3 = cost3;
    }

    public BigDecimal getBudgetNumber3() {
        return budgetNumber3;
    }

    public void setBudgetNumber3(BigDecimal budgetNumber3) {
        this.budgetNumber3 = budgetNumber3;
    }

    public BigDecimal getBudgetNumber4() {
        return budgetNumber4;
    }

    public void setBudgetNumber4(BigDecimal budgetNumber4) {
        this.budgetNumber4 = budgetNumber4;
    }

    public BigDecimal getCost4() {
        return cost4;
    }

    public void setCost4(BigDecimal cost4) {
        this.cost4 = cost4;
    }

    public BigDecimal getBudgetNumber5() {
        return budgetNumber5;
    }

    public void setBudgetNumber5(BigDecimal budgetNumber5) {
        this.budgetNumber5 = budgetNumber5;
    }

    public BigDecimal getCost5() {
        return cost5;
    }

    public void setCost5(BigDecimal cost5) {
        this.cost5 = cost5;
    }

    public BigDecimal getBudgetNumber6() {
        return budgetNumber6;
    }

    public void setBudgetNumber6(BigDecimal budgetNumber6) {
        this.budgetNumber6 = budgetNumber6;
    }

    public BigDecimal getCost6() {
        return cost6;
    }

    public void setCost6(BigDecimal cost6) {
        this.cost6 = cost6;
    }

    public BigDecimal getBudgetNumber7() {
        return budgetNumber7;
    }

    public void setBudgetNumber7(BigDecimal budgetNumber7) {
        this.budgetNumber7 = budgetNumber7;
    }

    public BigDecimal getCost7() {
        return cost7;
    }

    public void setCost7(BigDecimal cost7) {
        this.cost7 = cost7;
    }

    public BigDecimal getBudgetNumber8() {
        return budgetNumber8;
    }

    public void setBudgetNumber8(BigDecimal budgetNumber8) {
        this.budgetNumber8 = budgetNumber8;
    }

    public BigDecimal getCost8() {
        return cost8;
    }

    public void setCost8(BigDecimal cost8) {
        this.cost8 = cost8;
    }

    public BigDecimal getBudgetNumber9() {
        return budgetNumber9;
    }

    public void setBudgetNumber9(BigDecimal budgetNumber9) {
        this.budgetNumber9 = budgetNumber9;
    }

    public BigDecimal getCost9() {
        return cost9;
    }

    public void setCost9(BigDecimal cost9) {
        this.cost9 = cost9;
    }

    public BigDecimal getCost10() {
        return cost10;
    }

    public void setCost10(BigDecimal cost10) {
        this.cost10 = cost10;
    }

    public BigDecimal getBudgetNumber10() {
        return budgetNumber10;
    }

    public void setBudgetNumber10(BigDecimal budgetNumber10) {
        this.budgetNumber10 = budgetNumber10;
    }

    public BigDecimal getCost11() {
        return cost11;
    }

    public void setCost11(BigDecimal cost11) {
        this.cost11 = cost11;
    }

    public BigDecimal getBudgetNumber11() {
        return budgetNumber11;
    }

    public void setBudgetNumber11(BigDecimal budgetNumber11) {
        this.budgetNumber11 = budgetNumber11;
    }

    public BigDecimal getCost12() {
        return cost12;
    }

    public void setCost12(BigDecimal cost12) {
        this.cost12 = cost12;
    }

    public BigDecimal getBudgetNumber12() {
        return budgetNumber12;
    }

    public void setBudgetNumber12(BigDecimal budgetNumber12) {
        this.budgetNumber12 = budgetNumber12;
    }


    @Override
    public String toString() {
        return "FinanceIndexExpendFormsExportVo{" +
                "costTypeName='" + costTypeName + '\'' +
                ", cost1=" + cost1 +
                ", budgetNumber1=" + budgetNumber1 +
                ", cost2=" + cost2 +
                ", budgetNumber2=" + budgetNumber2 +
                ", cost3=" + cost3 +
                ", budgetNumber3=" + budgetNumber3 +
                ", budgetNumber4=" + budgetNumber4 +
                ", cost4=" + cost4 +
                ", budgetNumber5=" + budgetNumber5 +
                ", cost5=" + cost5 +
                ", budgetNumber6=" + budgetNumber6 +
                ", cost6=" + cost6 +
                ", budgetNumber7=" + budgetNumber7 +
                ", cost7=" + cost7 +
                ", budgetNumber8=" + budgetNumber8 +
                ", cost8=" + cost8 +
                ", budgetNumber9=" + budgetNumber9 +
                ", cost9=" + cost9 +
                ", cost10=" + cost10 +
                ", budgetNumber10=" + budgetNumber10 +
                ", cost11=" + cost11 +
                ", budgetNumber11=" + budgetNumber11 +
                ", cost12=" + cost12 +
                ", budgetNumber12=" + budgetNumber12 +
                '}';
    }
}
