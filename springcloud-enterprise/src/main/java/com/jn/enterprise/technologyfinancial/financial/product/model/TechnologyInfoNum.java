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
    private long investorsNum;
    @ApiModelProperty(value = "金融产品数)")
    private long financialProductNum;
    @ApiModelProperty(value = "金融机构数)")
    private long financialOrgNum;

    public long getInvestorsNum() {
        return investorsNum;
    }

    public void setInvestorsNum(long investorsNum) {
        this.investorsNum = investorsNum;
    }

    public long getFinancialProductNum() {
        return financialProductNum;
    }

    public void setFinancialProductNum(long financialProductNum) {
        this.financialProductNum = financialProductNum;
    }

    public long getFinancialOrgNum() {
        return financialOrgNum;
    }

    public void setFinancialOrgNum(long financialOrgNum) {
        this.financialOrgNum = financialOrgNum;
    }
}
