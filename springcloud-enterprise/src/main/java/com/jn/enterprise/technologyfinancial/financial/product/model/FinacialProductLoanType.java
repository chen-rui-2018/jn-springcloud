package com.jn.enterprise.technologyfinancial.financial.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/19 16:35
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "FinacialProductLoanType", description = "金融产品贷款类别")
public class FinacialProductLoanType implements Serializable {
    @ApiModelProperty(value = "贷款类别编码)")
    private String loanCode;
    @ApiModelProperty(value = "贷款类别名称)")
    private String loanName;

    public String getLoanCode() {
        return loanCode;
    }

    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }
}
