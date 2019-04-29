package com.jn.enterprise.servicemarket.industryarea.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 机构数据字典
 * @author： jiangyl
 * @date： Created on 2019/3/1 15:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "IndustryProduct",description = "机构数据字典产品")
public class IndustryProduct {
    @ApiModelProperty(value = "产品ID")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
