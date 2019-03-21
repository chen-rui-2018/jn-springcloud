package com.jn.park.finance.vo;

import com.jn.park.finance.model.FinanceIncomeLastYearContrastModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： tangry
 * @date： Created on 2019/3/11
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceIncomeLastYearContrastVo",description = "往年对比")
public class FinanceIncomeLastYearContrastVo implements Serializable {

    @ApiModelProperty(value = "收入类型：0：电费 ；1：物业费；2：楼宇租；3：其他；4：合计")
    private Integer incomeType;
    @ApiModelProperty(value = "收入名称")
    private String incomeTypeName;
    @ApiModelProperty(value = "往年对比列表")
    List<FinanceIncomeLastYearContrastModel> financeIncomeLastYearContrastModels;

    public Integer getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
    }

    public String getIncomeTypeName() {
        return incomeTypeName;
    }

    public void setIncomeTypeName(String incomeTypeName) {
        this.incomeTypeName = incomeTypeName;
    }

    public List<FinanceIncomeLastYearContrastModel> getFinanceIncomeLastYearContrastModels() {
        return financeIncomeLastYearContrastModels;
    }

    public void setFinanceIncomeLastYearContrastModels(List<FinanceIncomeLastYearContrastModel> financeIncomeLastYearContrastModels) {
        this.financeIncomeLastYearContrastModels = financeIncomeLastYearContrastModels;
    }
}
