package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 前台服务产品列表,添加综合排序的权重\
 * @author： chenr
 * @date： Created on 2019/2/22 10:50
 * @version： v1.0
 * @modified By:
 */
public class ProductQueryConditions implements Serializable {
    @ApiModelProperty(value = "人气权重")
    private Float popularityWeight=0.01f;
    @ApiModelProperty(value = "好评权重")
    private Float praiseWeight=1.0f;
    @ApiModelProperty(value = "服务量权重")
    private Float serviceWeight=0.1f;
    @ApiModelProperty(value = "其他因素分值")
    private Float otherFactorScore=0.0f;
    @ApiModelProperty(value = "领域Id")
    private String signoryId;
    @ApiModelProperty(value = "排序类型")
    private String sortTypes;
    @ApiModelProperty(value = "关键词")
    private String keyWords;
    @ApiModelProperty(value = "产品类型")
    private String productType;
    public Float getPopularityWeight() {
        return popularityWeight;
    }

    public void setPopularityWeight(Float popularityWeight) {
        this.popularityWeight = popularityWeight;
    }

    public Float getPraiseWeight() {
        return praiseWeight;
    }

    public void setPraiseWeight(Float praiseWeight) {
        this.praiseWeight = praiseWeight;
    }

    public Float getServiceWeight() {
        return serviceWeight;
    }

    public void setServiceWeight(Float serviceWeight) {
        this.serviceWeight = serviceWeight;
    }

    public Float getOtherFactorScore() {
        return otherFactorScore;
    }

    public void setOtherFactorScore(Float otherFactorScore) {
        this.otherFactorScore = otherFactorScore;
    }

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
