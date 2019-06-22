package com.jn.enterprise.servicemarket.require.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/3/5 11:23
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequireOtherDetails", description = "对他人的需求详情")
public class RequireOtherDetails implements Serializable {
    @ApiModelProperty(value = "需求id")
    private String id;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "需求单号")
    private String reqNum;
    @ApiModelProperty(value = "发布时间")
    private Date issueTime;
    @ApiModelProperty(value = "意向机构名称")
    private String orgName;
    @ApiModelProperty(value = "意向产品名称")
    private String productName;
    @ApiModelProperty(value = "意向顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "需求联系人姓名")
    private String reqName;
    @ApiModelProperty(value = "需求联系人手机")
    private String reqPhone;
    @ApiModelProperty(value = "需求联系人邮箱")
    private String reqEmail;
    @ApiModelProperty(value = "需求描述")
    private String requireDetail;
    @ApiModelProperty(value="需求状态, (-1:已撤销 1：待处理，2：已处理)")
    private String status;
    @ApiModelProperty(value = "合同总金额")
    private String contractAmount;
    @ApiModelProperty(value = "对接结果(1:对接成功  2:对接失败  3:企业需求撤销 4:未对接)")
    private String handleResult;
    @ApiModelProperty(value = "结果描述")
    private String resultDetail;
    @ApiModelProperty(value = "合同首页")
    private String contractHomePage;
    @ApiModelProperty(value = "合同尾页")
    private String contractEndPage;


    @ApiModelProperty(value = "[科技金融]融资金额")
    private String financingAmount;
    @ApiModelProperty(value = "[科技金融]融资期限")
    private String financingPeriod;
    @ApiModelProperty(value = "[科技金融]实际贷款金额(万元)")
    private String actualLoanAmount;
    @ApiModelProperty(value = "[科技金融]资金需求说明")
    private String fundsReqDesc;
    @ApiModelProperty(value = "[科技金融]资金需求日期")
    private String expectedDate;

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

    public Date getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
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

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
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

    public String getRequireDetail() {
        return requireDetail;
    }

    public void setRequireDetail(String requireDetail) {
        this.requireDetail = requireDetail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }

    public String getResultDetail() {
        return resultDetail;
    }

    public void setResultDetail(String resultDetail) {
        this.resultDetail = resultDetail;
    }

    public String getContractHomePage() {
        return contractHomePage;
    }

    public void setContractHomePage(String contractHomePage) {
        this.contractHomePage = contractHomePage;
    }

    public String getContractEndPage() {
        return contractEndPage;
    }

    public void setContractEndPage(String contractEndPage) {
        this.contractEndPage = contractEndPage;
    }

    public String getFinancingAmount() {
        return financingAmount;
    }

    public void setFinancingAmount(String financingAmount) {
        this.financingAmount = financingAmount;
    }

    public String getFinancingPeriod() {
        return financingPeriod;
    }

    public void setFinancingPeriod(String financingPeriod) {
        this.financingPeriod = financingPeriod;
    }

    public String getFundsReqDesc() {
        return fundsReqDesc;
    }

    public void setFundsReqDesc(String fundsReqDesc) {
        this.fundsReqDesc = fundsReqDesc;
    }

    public String getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(String expectedDate) {
        this.expectedDate = expectedDate;
    }

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
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
        return "RequireOtherDetails{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", reqNum='" + reqNum + '\'' +
                ", issueTime=" + issueTime +
                ", orgName='" + orgName + '\'' +
                ", productName='" + productName + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", reqName='" + reqName + '\'' +
                ", reqPhone='" + reqPhone + '\'' +
                ", reqEmail='" + reqEmail + '\'' +
                ", requireDetail='" + requireDetail + '\'' +
                ", status='" + status + '\'' +
                ", contractAmount='" + contractAmount + '\'' +
                ", handleResult='" + handleResult + '\'' +
                ", resultDetail='" + resultDetail + '\'' +
                ", contractHomePage='" + contractHomePage + '\'' +
                ", contractEndPage='" + contractEndPage + '\'' +
                ", financingAmount='" + financingAmount + '\'' +
                ", financingPeriod='" + financingPeriod + '\'' +
                ", actualLoanAmount='" + actualLoanAmount + '\'' +
                ", fundsReqDesc='" + fundsReqDesc + '\'' +
                ", expectedDate='" + expectedDate + '\'' +
                ", ratingScore='" + ratingScore + '\'' +
                ", evaluationDesc='" + evaluationDesc + '\'' +
                '}';
    }
}
