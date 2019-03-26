package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/28 14:58
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorServiceManagementInfo",description = "服务顾问管理信息（后台门户管理）")
public class AdvisorServiceManagementInfo implements Serializable {
    @ApiModelProperty(value = "顾问头像")
    private String avatar;
    @ApiModelProperty(value = "顾问姓名")
    private String advisorName;
    @ApiModelProperty(value = "描述")
    private String personalProfile;
    @ApiModelProperty(value = "所属机构")
    private String orgName;
    @ApiModelProperty(value = "服务产品")
    private String productName;
    @ApiModelProperty(value = "服务评价得分")
    private String evaluationScore;
    @ApiModelProperty(value = "是否认证(0:未认证  1：已认证)")
    private String isCertification;
    @ApiModelProperty(value = "从业年限")
    private Float workingYears;
    @ApiModelProperty(value = "业务擅长")
    private String goodAtBusiness;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification;
    }

    public Float getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Float workingYears) {
        this.workingYears = workingYears;
    }

    public String getGoodAtBusiness() {
        return goodAtBusiness;
    }

    public void setGoodAtBusiness(String goodAtBusiness) {
        this.goodAtBusiness = goodAtBusiness;
    }

    @Override
    public String toString() {
        return "AdvisorServiceManagementInfo{" +
                "avatar='" + avatar + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", personalProfile='" + personalProfile + '\'' +
                ", orgName='" + orgName + '\'' +
                ", productName='" + productName + '\'' +
                ", evaluationScore='" + evaluationScore + '\'' +
                ", isCertification='" + isCertification + '\'' +
                ", workingYears=" + workingYears +
                ", goodAtBusiness='" + goodAtBusiness + '\'' +
                '}';
    }
}
