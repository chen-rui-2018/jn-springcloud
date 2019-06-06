package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 16:20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="SameTypeProductParam",description = "同类型(领域)产品查找入参")
public class SameTypeProductParam extends Page implements Serializable {
    @ApiModelProperty(value="领域id",required = true,example = "jrywdljz012345689999999999999999")
    private  String signoryId;
    @ApiModelProperty(value="产品类型,1: 特色 0:常规 不传值则返回全部 ",example = "0")
    private  String productType;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }
}
