package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/13 10:26
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorListInfo", description = "服务专员列表信息")
public class AdvisorListInfo implements Serializable {
    @ApiModelProperty(value = "机构id")
    private String orgId;
    @ApiModelProperty(value = "所属机构名称")
    private String orgName;
    @ApiModelProperty(value = "专员账号")
    private String advisorAccount;
    @ApiModelProperty(value = "专员姓名")
    private String advisorName;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "从业年限")
    private Double workingYears;
    @ApiModelProperty(value = "是否认证(0：未认证  1：已认证)")
    private String isCertification;
    @ApiModelProperty(value = "业务擅长")
    private String goodAtBusiness;
    @ApiModelProperty(value = "综合得分")
    private Integer integratedSort;
    @ApiModelProperty(value = "评价分数（好评）")
    private String evaluationScore;
    @ApiModelProperty(value = "浏览量（人气）")
    private Integer pageViews;
    @ApiModelProperty(value = "累计交易次数（服务量）")
    private Integer transactionNum;
    @ApiModelProperty(value = "评价次数")
    private Integer evaluationNum;



    private static final long serialVersionUID = 1L;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Double getWorkingYears() {
        return workingYears;
    }

    public void setWorkingYears(Double workingYears) {
        this.workingYears = workingYears;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIsCertification() {
        return isCertification;
    }

    public void setIsCertification(String isCertification) {
        this.isCertification = isCertification;
    }

    public String getGoodAtBusiness() {
        return goodAtBusiness;
    }

    public void setGoodAtBusiness(String goodAtBusiness) {
        this.goodAtBusiness = goodAtBusiness;
    }

    public Integer getIntegratedSort() {
        return integratedSort;
    }

    public void setIntegratedSort(Integer integratedSort) {
        this.integratedSort = integratedSort;
    }

    public String getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public Integer getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(Integer transactionNum) {
        this.transactionNum = transactionNum;
    }

    public Integer getEvaluationNum() {
        return evaluationNum;
    }

    public void setEvaluationNum(Integer evaluationNum) {
        this.evaluationNum = evaluationNum;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "AdvisorListInfo{" +
                "orgId='" + orgId + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", position='" + position + '\'' +
                ", workingYears=" + workingYears +
                ", orgName='" + orgName + '\'' +
                ", isCertification='" + isCertification + '\'' +
                ", goodAtBusiness='" + goodAtBusiness + '\'' +
                ", integratedSort=" + integratedSort +
                ", evaluationScore='" + evaluationScore + '\'' +
                ", pageViews=" + pageViews +
                ", transactionNum=" + transactionNum +
                ", evaluationNum=" + evaluationNum +
                '}';
    }
}
