package com.jn.enterprise.servicemarket.comment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author： jiangyl
 * @date： Created on 2019/2/25 18:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "RatingDetail",description = "评价详细信息")
public class RatingDetail {
    @ApiModelProperty(value = "需求id")
    private String id;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "需求单号")
    private String reqNum;
    @ApiModelProperty(value = "发布日期")
    private String issueTime;
    @ApiModelProperty(value = "意向机构")
    private String orgName;
    @ApiModelProperty(value = "意向专员")
    private String advisorName;
    @ApiModelProperty(value = "意向产品")
    private String productName;
    @ApiModelProperty(value = "合同总金额")
    private String contractAmount;
    @ApiModelProperty(value = "机构联系人姓名")
    private String conName;
    @ApiModelProperty(value = "机构联系人手机")
    private String conPhone;
    @ApiModelProperty(value = "机构联系人邮箱")
    private String conEmail;
    @ApiModelProperty(value = "需求提出联系人姓名")
    private String reqName;
    @ApiModelProperty(value = "需求提出联系人手机")
    private String reqPhone;
    @ApiModelProperty(value = "需求提出联系人邮箱")
    private String reqEmail;
    @ApiModelProperty(value = "需求描述")
    private String reqDetail;
    @ApiModelProperty(value = "[科技金融]融资金额")
    private String financingAmount;
    @ApiModelProperty(value = "[科技金融]实际贷款金额(万元)")
    private String actualLoanAmount;
    @ApiModelProperty(value = "[科技金融]融资期限")
    private String financingPeriod;
    @ApiModelProperty(value = "[科技金融]资金需求日期")
    private String expectedDate;
    @ApiModelProperty(value = "[科技金融]资金需求说明")
    private String fundsReqDesc;
    @ApiModelProperty(value = "结果描述")
    private String resultDetail;
    @ApiModelProperty(value = "是否已点评0否1是")
    private String isComment;
    @ApiModelProperty(value = "服务评分")
    private String attitudeScore;
    @ApiModelProperty(value = "评价描述")
    private String evaluationDesc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getReqNum() {
        return reqNum;
    }

    public void setReqNum(String reqNum) {
        this.reqNum = reqNum;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public String getReqName() {
        return reqName;
    }

    public void setReqName(String reqName) {
        this.reqName = reqName;
    }

    public String getReqPhone() {
        return reqPhone;
    }

    public void setReqPhone(String reqPhone) {
        this.reqPhone = reqPhone;
    }

    public String getReqEmail() {
        return reqEmail;
    }

    public void setReqEmail(String reqEmail) {
        this.reqEmail = reqEmail;
    }

    public String getReqDetail() {
        return reqDetail;
    }

    public void setReqDetail(String reqDetail) {
        this.reqDetail = reqDetail;
    }

    public String getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(String financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
    }

    public String getFinancingPeriod() {
        return financingPeriod;
    }

    public void setFinancingPeriod(String financingPeriod) {
        this.financingPeriod = financingPeriod;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String getIsComment() {
        return isComment;
    }

    public void setIsComment(String isComment) {
        this.isComment = isComment;
    }

    public String getAttitudeScore() {
        return attitudeScore;
    }

    public void setAttitudeScore(String attitudeScore) {
        this.attitudeScore = attitudeScore;
    }

    public String getEvaluationDesc() {
        return evaluationDesc;
    }

    public void setEvaluationDesc(String evaluationDesc) {
        this.evaluationDesc = evaluationDesc;
    }

    public String getFundsReqDesc() {
        return fundsReqDesc;
    }

    public void setFundsReqDesc(String fundsReqDesc) {
        this.fundsReqDesc = fundsReqDesc;
    }
}
