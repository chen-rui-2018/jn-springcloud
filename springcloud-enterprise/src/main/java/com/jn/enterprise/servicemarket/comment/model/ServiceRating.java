package com.jn.enterprise.servicemarket.comment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/13 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRating",description = "服务评价")
public class ServiceRating implements Serializable {
    @ApiModelProperty(value = "机构id")
    private String orgId;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "服务产品id")
    private String productId;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务顾问账号")
    private String advisorAccount;
    @ApiModelProperty(value = "服务顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "服务产品图片")
    private String pictureUrl;
    @ApiModelProperty(value = "评价人账号")
    private String evaluationAccount;
    @ApiModelProperty(value = "评价人头像")
    private String evaluationAvatar;
    @ApiModelProperty(value = "评价人姓名")
    private String evaluationName;
    @ApiModelProperty(value = "服务评分")
    private String evaluationScore;
    @ApiModelProperty(value = "服务评价描述")
    private String evaluationDesc;
    @ApiModelProperty(value = "评价时间")
    private String evaluationTime;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getEvaluationAccount() {
        return evaluationAccount;
    }

    public void setEvaluationAccount(String evaluationAccount) {
        this.evaluationAccount = evaluationAccount;
    }

    public String getEvaluationAvatar() {
        return evaluationAvatar;
    }

    public void setEvaluationAvatar(String evaluationAvatar) {
        this.evaluationAvatar = evaluationAvatar;
    }

    public String getEvaluationName() {
        return evaluationName;
    }

    public void setEvaluationName(String evaluationName) {
        this.evaluationName = evaluationName;
    }

    public String getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public String getEvaluationDesc() {
        return evaluationDesc;
    }

    public void setEvaluationDesc(String evaluationDesc) {
        this.evaluationDesc = evaluationDesc;
    }

    public String getEvaluationTime() {
        return evaluationTime;
    }

    public void setEvaluationTime(String evaluationTime) {
        this.evaluationTime = evaluationTime;
    }


    @Override
    public String toString() {
        return "ServiceRating{" +
                "orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", evaluationAccount='" + evaluationAccount + '\'' +
                ", evaluationAvatar='" + evaluationAvatar + '\'' +
                ", evaluationName='" + evaluationName + '\'' +
                ", evaluationScore='" + evaluationScore + '\'' +
                ", evaluationDesc='" + evaluationDesc + '\'' +
                ", evaluationTime='" + evaluationTime + '\'' +
                '}';
    }
}
