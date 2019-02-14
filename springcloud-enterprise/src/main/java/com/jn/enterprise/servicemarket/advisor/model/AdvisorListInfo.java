package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/13 10:26
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorListInfo", description = "服务顾问列表信息")
public class AdvisorListInfo extends Page implements Serializable {
    @ApiModelProperty(value = "机构id")
    private String orgId;
    @ApiModelProperty(value = "顾问账号")
    private String advisorAccount;
    @ApiModelProperty(value = "顾问姓名")
    private String advisorName;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "所属机构名称")
    private String orgName;
    @ApiModelProperty(value = "是否认证")
    private String isCertification;
    @ApiModelProperty(value = "业务擅长")
    private String goodAtBusiness;
    @ApiModelProperty(value = "服务态度评分")
    private String attitudeScore;
    @ApiModelProperty(value = "服务专业评分")
    private String professionScore;
    @ApiModelProperty(value = "服务响应评分")
    private String responseScore;
    @ApiModelProperty(value = "服务价格评分")
    private String priceScore;
    @ApiModelProperty(value = "综合得分")
    private Integer integratedSort;
    @ApiModelProperty(value = "评价等级（好评）")
    private String evaluationLevel;
    @ApiModelProperty(value = "浏览量（人气）")
    private Integer pageviews;
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

    public String getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(String attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public String getProfessionScore() {
        return professionScore;
    }

    public void setProfessionScore(String professionScore) {
        this.professionScore = professionScore;
    }

    public String getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(String responseScore) {
        this.responseScore = responseScore;
    }

    public String getPriceScore() {
        return priceScore;
    }

    public void setPriceScore(String priceScore) {
        this.priceScore = priceScore;
    }

    public Integer getIntegratedSort() {
        return integratedSort;
    }

    public void setIntegratedSort(Integer integratedSort) {
        this.integratedSort = integratedSort;
    }

    public String getEvaluationLevel() {
        return evaluationLevel;
    }

    public void setEvaluationLevel(String evaluationLevel) {
        this.evaluationLevel = evaluationLevel;
    }

    public Integer getPageviews() {
        return pageviews;
    }

    public void setPageviews(Integer pageviews) {
        this.pageviews = pageviews;
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

    @Override
    public String toString() {
        return "AdvisorListInfo{" +
                "orgId='" + orgId + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", position='" + position + '\'' +
                ", orgName='" + orgName + '\'' +
                ", isCertification='" + isCertification + '\'' +
                ", goodAtBusiness='" + goodAtBusiness + '\'' +
                ", attitudeScore='" + attitudeScore + '\'' +
                ", professionScore='" + professionScore + '\'' +
                ", responseScore='" + responseScore + '\'' +
                ", priceScore='" + priceScore + '\'' +
                ", integratedSort=" + integratedSort +
                ", evaluationLevel='" + evaluationLevel + '\'' +
                ", pageviews=" + pageviews +
                ", transactionNum=" + transactionNum +
                ", evaluationNum=" + evaluationNum +
                '}';
    }
}
