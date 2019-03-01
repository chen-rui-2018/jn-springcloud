package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 顾问-服务产品列表查询条件
 * @author： chenr
 * @date： Created on 2019/2/27 17:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorProductQuery", description = "顾问-服务产品列表查询条件")
public class AdvisorProductQuery extends Page implements Serializable {
    @ApiModelProperty(value ="顾问账号",required = true)
    @NotBlank(message = "顾问账号不能为空!")
    private String advisorAccount;
    @ApiModelProperty(value ="产品类型")
    private String productType;
    @ApiModelProperty(value ="五星好评")
    private String praise;

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getPraise() {
        return praise;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }
}
