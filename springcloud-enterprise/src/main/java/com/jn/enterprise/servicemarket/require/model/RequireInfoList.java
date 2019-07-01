package com.jn.enterprise.servicemarket.require.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/4 19:24
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequireInfoList", description = "需求列表信息")
public class RequireInfoList implements Serializable {
    @ApiModelProperty(value = "需求id")
    private String id;
    @ApiModelProperty(value = "需求单号")
    private String reqNum;
    @ApiModelProperty(value = "领域id")
    private String businessId;
    @ApiModelProperty(value = "领域名称")
    private String businessArea;
    @ApiModelProperty(value = "意向产品id")
    private String productId;
    @ApiModelProperty(value = "意向产品名称")
    private String productName;
    @ApiModelProperty(value = "意向机构id")
    private String orgId;
    @ApiModelProperty(value = "意向机构名称")
    private String orgName;
    @ApiModelProperty(value = "意向专员账号")
    private String advisorAccount;
    @ApiModelProperty(value = "意向专员名称")
    private String advisorName;
    @ApiModelProperty(value = "提需求日期")
    private String requireTime;
    @ApiModelProperty(value = "需求状态(-1:已撤销 1：待处理，2：已处理)")
    private String status;
    @ApiModelProperty(value = "对接结果((1:对接成功  2:对接失败  3:企业需求撤销 4:未对接))")
    private String handleResult;
    @ApiModelProperty(value = "点评状态 (0未点评  1已点评)")
    private String isComment;
    @ApiModelProperty(value = "评价分数")
    private String ratingScore;
    @ApiModelProperty(value = "评价描述")
    private String evaluationDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReqNum() {
        return reqNum;
    }

    public void setReqNum(String reqNum) {
        this.reqNum = reqNum;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
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

    public String getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(String requireTime) {
        this.requireTime = requireTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment;
    }

    public String getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(String ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getEvaluationDesc() {
        return evaluationDesc;
    }

    public void setEvaluationDesc(String evaluationDesc) {
        this.evaluationDesc = evaluationDesc;
    }

    @Override
    public String toString() {
        return "RequireInfoList{" +
                "reqNum='" + reqNum + '\'' +
                ", businessId='" + businessId + '\'' +
                ", businessArea='" + businessArea + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", requireTime='" + requireTime + '\'' +
                ", status='" + status + '\'' +
                ", handleResult='" + handleResult + '\'' +
                ", isComment='" + isComment + '\'' +
                ", ratingScore='" + ratingScore + '\'' +
                '}';
    }
}
