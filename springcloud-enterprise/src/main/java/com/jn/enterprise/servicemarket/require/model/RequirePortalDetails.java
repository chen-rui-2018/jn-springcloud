package com.jn.enterprise.servicemarket.require.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/5 11:23
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequirePortalDetails", description = "后台门户管理需求详情")
public class RequirePortalDetails implements Serializable {
    @ApiModelProperty(value = "需求单号")
    private String reqNum;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "发布时间")
    private String issueTime;
    @ApiModelProperty(value = "业务领域")
    private String businessArea;
    @ApiModelProperty(value = "服务机构")
    private String orgName;
    @ApiModelProperty(value = "服务产品")
    private String productName;
    @ApiModelProperty(value = "服务顾问")
    private String advisorName;
    @ApiModelProperty(value = "产品分类")
    private String productType;
    @ApiModelProperty(value = "联系人姓名")
    private String reqName;
    @ApiModelProperty(value = "联系人手机")
    private String reqPhone;
    @ApiModelProperty(value = "联系人邮箱")
    private String reqEmail;
    @ApiModelProperty(value = "合同总金额")
    private String contractAmount;
    @ApiModelProperty(value = "需求描述")
    private String requireDetail;
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


    public String getReqNum() {
        return reqNum;
    }

    public void setReqNum(String reqNum) {
        this.reqNum = reqNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(String issueTime) {
        this.issueTime = issueTime;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getRequireDetail() {
        return requireDetail;
    }

    public void setRequireDetail(String requireDetail) {
        this.requireDetail = requireDetail;
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

    public String getActualLoanAmount() {
        return actualLoanAmount;
    }

    public void setActualLoanAmount(String actualLoanAmount) {
        this.actualLoanAmount = actualLoanAmount;
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
        return "RequirePortalDetails{" +
                "reqNum='" + reqNum + '\'' +
                ", companyName='" + companyName + '\'' +
                ", issueTime=" + issueTime +
                ", businessArea='" + businessArea + '\'' +
                ", orgName='" + orgName + '\'' +
                ", productName='" + productName + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", productType='" + productType + '\'' +
                ", reqName='" + reqName + '\'' +
                ", reqPhone='" + reqPhone + '\'' +
                ", reqEmail='" + reqEmail + '\'' +
                ", contractAmount='" + contractAmount + '\'' +
                ", requireDetail='" + requireDetail + '\'' +
                ", handleResult='" + handleResult + '\'' +
                ", resultDetail='" + resultDetail + '\'' +
                ", contractHomePage='" + contractHomePage + '\'' +
                ", contractEndPage='" + contractEndPage + '\'' +
                ", financingAmount='" + financingAmount + '\'' +
                ", financingPeriod='" + financingPeriod + '\'' +
                ", actualLoanAmount='" + actualLoanAmount + '\'' +
                ", fundsReqDesc='" + fundsReqDesc + '\'' +
                ", expectedDate='" + expectedDate + '\'' +
                '}';
    }
}
