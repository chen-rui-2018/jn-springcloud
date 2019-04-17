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

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }
}
