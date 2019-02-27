package com.jn.enterprise.servicemarket.comment.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/2/13 11:17
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceRating",description = "服务评价")
public class ServiceRating extends Page implements Serializable {
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
    @ApiModelProperty(value = "服务态度评分")
    private String attitudeScore;
    @ApiModelProperty(value = "服务专业评分")
    private String professionScore;
    @ApiModelProperty(value = "服务响应评分")
    private String responseScore;
    @ApiModelProperty(value = "服务价格评分")
    private String priceScore;
    @ApiModelProperty(value = "服务评分")
    private String evaluationScore;
    @ApiModelProperty(value = "服务评价描述")
    private String evaluationDesc;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "记录状态")
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
                ", attitudeScore='" + attitudeScore + '\'' +
                ", professionScore='" + professionScore + '\'' +
                ", responseScore='" + responseScore + '\'' +
                ", priceScore='" + priceScore + '\'' +
                ", evaluationScore='" + evaluationScore + '\'' +
                ", evaluationDesc='" + evaluationDesc + '\'' +
                ", createdTime=" + createdTime +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
