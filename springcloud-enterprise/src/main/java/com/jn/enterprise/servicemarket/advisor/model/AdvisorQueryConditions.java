package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/13 17:23
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorQueryConditions", description = "服务顾问列表查询条件")
public class AdvisorQueryConditions implements Serializable {
    @ApiModelProperty(value = "人气权重")
    private Float popularityWeight=0.01f;
    @ApiModelProperty(value = "好评权重")
    private Float praiseWeight=1.0f;
    @ApiModelProperty(value = "服务量权重")
    private Float serviceWeight=0.1f;
    @ApiModelProperty(value = "其他因素分值")
    private Float otherFactorScore=0.0f;
    @ApiModelProperty(value = "领域")
    private String domain;
    @ApiModelProperty(value = "排序类型")
    private String sortTypes;
    @ApiModelProperty(value = "关键词")
    private String keyWords;
    @ApiModelProperty(value = "机构id")
    private String orgId;

    private static final long serialVersionUID = 1L;

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

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
