package com.jn.park.policy.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/4/1 14:06
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PolicyGuideDiagramDetailsShow",description = "政策指南图解政策详情出参")
public class PolicyGuideDiagramDetailsShow implements Serializable {
    @ApiModelProperty(value = "政策id")
    private String policyId;
    @ApiModelProperty(value = "政策编码")
    private String policyCode;
    @ApiModelProperty(value = "专题类型(0：一号专题   1：民营专题)")
    private String thematicType;
    @ApiModelProperty(value = "政策标题")
    private String policyTitle;
    @ApiModelProperty(value = "阅读次数")
    private Integer readNum;
    @ApiModelProperty(value = "发布日期")
    private String releaseDate;
    @ApiModelProperty(value = "状态(0:无效  1:有效)")
    private String status;
    @ApiModelProperty(value = "有无关联政策原文(0:无  1:有)")
    private String isPolicyOriginal;
    @ApiModelProperty(value = "关联的政策原文id")
    private String relationPolicyOriginalId;
    @ApiModelProperty(value = "关联的政策原文标题")
    private String relationPolicyOriginalTitle;
    @ApiModelProperty(value = "图解政策url")
    private String policyDiagramUrl;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyCode() {
        return policyCode;
    }

    public void setPolicyCode(String policyCode) {
        this.policyCode = policyCode;
    }

    public String getThematicType() {
        return thematicType;
    }

    public void setThematicType(String thematicType) {
        this.thematicType = thematicType;
    }

    public String getPolicyTitle() {
        return policyTitle;
    }

    public void setPolicyTitle(String policyTitle) {
        this.policyTitle = policyTitle;
    }

    public Integer getReadNum() {
        return readNum;
    }

    public void setReadNum(Integer readNum) {
        this.readNum = readNum;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsPolicyOriginal() {
        return isPolicyOriginal;
    }

    public void setIsPolicyOriginal(String isPolicyOriginal) {
        this.isPolicyOriginal = isPolicyOriginal;
    }

    public String getRelationPolicyOriginalId() {
        return relationPolicyOriginalId;
    }

    public void setRelationPolicyOriginalId(String relationPolicyOriginalId) {
        this.relationPolicyOriginalId = relationPolicyOriginalId;
    }

    public String getRelationPolicyOriginalTitle() {
        return relationPolicyOriginalTitle;
    }

    public void setRelationPolicyOriginalTitle(String relationPolicyOriginalTitle) {
        this.relationPolicyOriginalTitle = relationPolicyOriginalTitle;
    }

    public String getPolicyDiagramUrl() {
        return policyDiagramUrl;
    }

    public void setPolicyDiagramUrl(String policyDiagramUrl) {
        this.policyDiagramUrl = policyDiagramUrl;
    }

    @Override
    public String toString() {
        return "PolicyGuideDiagramDetailsShow{" +
                "policyId='" + policyId + '\'' +
                ", policyCode='" + policyCode + '\'' +
                ", thematicType='" + thematicType + '\'' +
                ", policyTitle='" + policyTitle + '\'' +
                ", readNum=" + readNum +
                ", releaseDate='" + releaseDate + '\'' +
                ", status='" + status + '\'' +
                ", isPolicyOriginal='" + isPolicyOriginal + '\'' +
                ", relationPolicyOriginalId='" + relationPolicyOriginalId + '\'' +
                ", relationPolicyOriginalTitle='" + relationPolicyOriginalTitle + '\'' +
                ", policyDiagramUrl='" + policyDiagramUrl + '\'' +
                '}';
    }
}
