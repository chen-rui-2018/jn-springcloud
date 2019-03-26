package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 机构上架常规服务产品上架时用户选择的产品列表
 * @author： chenr
 * @date： Created on 2019/3/23 17:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="ProductShelf",description = "机构上架常规服务产品上架时用户选择的产品列表")
public class ProductShelf implements Serializable {
    @ApiModelProperty(value = "服务产品Id")
    private String productId;
    @ApiModelProperty(value = "服务产品名称")
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
