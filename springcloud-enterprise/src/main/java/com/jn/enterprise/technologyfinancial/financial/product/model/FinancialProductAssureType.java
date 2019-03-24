package com.jn.enterprise.technologyfinancial.financial.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/19 16:38
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialProductAssureType", description = "金融产品担保方式")
public class FinancialProductAssureType implements Serializable {
    @ApiModelProperty(value = "贷款类别编码)")
    private String assureCode;
    @ApiModelProperty(value = "贷款类别名称)")
    private String assureName;

    public String getAssureCode() {
        return assureCode;
    }

    public void setAssureCode(String assureCode) {
        this.assureCode = assureCode;
    }

    public String getAssureName() {
        return assureName;
    }

    public void setAssureName(String assureName) {
        this.assureName = assureName;
    }
}
