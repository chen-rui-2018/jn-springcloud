package com.jn.enterprise.servicemarket.org.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务超市统计数据[业务领域查询]
 * @author： jiangyl
 * @date： Created on 2019/2/13 15:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "BusinessStatisticalNumVO", description = "服务超市统计数据[业务领域查询]")
public class BusinessStatisticalParam implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "产品ID",example = "568d595476164c92b3d715629bf9ffcc")
    private String productId;

    @ApiModelProperty(value = "业务领域(数据从【服务超市-机构字典】接口获取(id))",example = "ogistics")
    private String businessType ;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
