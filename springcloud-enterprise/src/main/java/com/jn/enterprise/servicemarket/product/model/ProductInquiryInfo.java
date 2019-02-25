package com.jn.enterprise.servicemarket.product.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/2/22 10:47
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorInquiryInfo",description = "前台服务产品列表查询入参")
public class ProductInquiryInfo extends Page implements Serializable {
    @ApiModelProperty(value = "领域Id")
    private String signoryId;
    @ApiModelProperty(value = "排序类型,(人气-popularity,好评-praise,服务量-serviceNum,综合-integrate)")
    private String sortTypes;
    @ApiModelProperty(value = "关键词")
    private String keyWords;
    @ApiModelProperty(value = "产品类型 0-常规产品,1-特色产品")
    private String productType;
    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
