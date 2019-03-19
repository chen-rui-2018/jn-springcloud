package com.jn.enterprise.technologyfinancial.financial.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/19 17:41
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialProductListParam", description = "科技金融首页投资人数、金融产品数、金融机构数")
public class TechnologyInfoNum implements Serializable {
    @ApiModelProperty(value = "投资人数)")
    private String investorsNum;
    @ApiModelProperty(value = "金融产品数)")
    private String financialProductNum;
    @ApiModelProperty(value = "金融机构数)")
    private String financialOrgNum;

    public String getInvestorsNum() {
        return investorsNum;
    }

    public void setInvestorsNum(String investorsNum) {
        this.investorsNum = investorsNum;
    }

    public String getFinancialProductNum() {
        return financialProductNum;
    }

    public void setFinancialProductNum(String financialProductNum) {
        this.financialProductNum = financialProductNum;
    }

    public String getFinancialOrgNum() {
        return financialOrgNum;
    }

    public void setFinancialOrgNum(String financialOrgNum) {
        this.financialOrgNum = financialOrgNum;
    }
}
