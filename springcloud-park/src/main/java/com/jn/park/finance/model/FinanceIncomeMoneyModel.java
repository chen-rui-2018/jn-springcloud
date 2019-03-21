package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author： huangbq
 * @date： Created on 2019/3/5 0:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceBudgetMoneyModel",description = "月度预算")
public class FinanceIncomeMoneyModel implements Serializable {

    private static final long serialVersionUID = -2722782925178096971L;
    @ApiModelProperty("年月")
    private String month;
    @ApiModelProperty("收入")
    private BigDecimal money;
    @ApiModelProperty("去年同期收入")
    private BigDecimal lastYearMoney;


}
