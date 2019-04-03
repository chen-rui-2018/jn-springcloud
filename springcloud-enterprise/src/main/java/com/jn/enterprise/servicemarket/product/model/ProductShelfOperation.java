package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 产品上下架操作 的 bean
 * @author： chenr
 * @date： Created on 2019/3/23 11:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="ProductShelfOperation" ,description = "产品上下架操作的 bean")
public class ProductShelfOperation implements Serializable {
    @ApiModelProperty(value = "服务产品ID",required = true)
    @NotBlank(message = "产品Id 不能为空")
    private String productId;
    @ApiModelProperty(value = "状态(上架 1,下架-1)",required = true)
    @NotBlank(message = "操作行为结果不能为空")
    private String status;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
