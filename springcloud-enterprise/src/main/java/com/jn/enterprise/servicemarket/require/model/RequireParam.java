package com.jn.enterprise.servicemarket.require.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/4 9:43
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequireParam", description = "需求管理（非科技金融提需求入参）")
public class RequireParam extends Page implements Serializable {
    @ApiModelProperty(value = "产品Id")
    @NotNull(message = "产品Id不能为空")
    private String productId;
    @ApiModelProperty(value = "产品名称")
    @NotNull(message = "产品名称不能为空")
    private String productName;
    @ApiModelProperty(value = "需求描述")
    private String requireDetail;

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

    public String getRequireDetail() {
        return requireDetail;
    }

    public void setRequireDetail(String requireDetail) {
        this.requireDetail = requireDetail;
    }
}
