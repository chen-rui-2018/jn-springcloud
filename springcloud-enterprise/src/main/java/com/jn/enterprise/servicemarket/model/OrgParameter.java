package com.jn.enterprise.servicemarket.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 机构查询入参Bean
 * @author： jiangyl
 * @date： Created on 2019/2/13 14:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OrgParameter",description = "机构查询入参")
public class OrgParameter extends Page {

    @ApiModelProperty("一级业务领域")
    private String businessType;

    @ApiModelProperty("二级业务领域")
    private String businessSType;

    @ApiModelProperty("机构名称")
    private String orgName;

    @ApiModelProperty("主营业务")
    private String orgBusiness;

    @ApiModelProperty("排序字段")
    private String sortTypes;

    @ApiModelProperty(value = "人气权重")
    private Float popularityWeight=0.01f;

    @ApiModelProperty(value = "好评权重")
    private Float praiseWeight=1.0f;

    @ApiModelProperty(value = "服务量权重")
    private Float serviceWeight=0.1f;

    @ApiModelProperty(value = "其他因素分值")
    private Float otherFactorScore=0.0f;

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessSType() {
        return businessSType;
    }

    public void setBusinessSType(String businessSType) {
        this.businessSType = businessSType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgBusiness() {
        return orgBusiness;
    }

    public void setOrgBusiness(String orgBusiness) {
        this.orgBusiness = orgBusiness;
    }

    public String getSortTypes() {
        return sortTypes;
    }

    public void setSortTypes(String sortTypes) {
        this.sortTypes = sortTypes;
    }

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
}
