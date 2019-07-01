package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 机构修改上架的常规产品
 * @author： chenr
 * @date： Created on 2019/3/23 17:32
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="OrgUpdateCommonProduct" ,description = "机构修改上架的常规产品")
public class OrgUpdateCommonProduct implements Serializable {
    @ApiModelProperty(value = "服务产品Id",required = true,example = "id")
    @NotBlank(message = "服务产品id不能为空")
    private String productId;
    @ApiModelProperty(value = "专员账号",example = "wangsong,qianqi")
    private String advisorAccount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    @Override
    public String toString() {
        return "OrgUpdateCommonProduct{" +
                "productId='" + productId + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                '}';
    }
}
