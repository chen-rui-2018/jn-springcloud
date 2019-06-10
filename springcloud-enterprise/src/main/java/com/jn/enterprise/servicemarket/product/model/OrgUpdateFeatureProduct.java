package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 机构更新特色服务产品
 * @author： chenr
 * @date： Created on 2019/3/23 17:44
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgUpdateFeatureProduct", description = "机构更新特色服务产品")
public class OrgUpdateFeatureProduct extends AddFeatureProduct implements Serializable {
    @ApiModelProperty(value="服务产品id",required = true)
    private String productId;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
