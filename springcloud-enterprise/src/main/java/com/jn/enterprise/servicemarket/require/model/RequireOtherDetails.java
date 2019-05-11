package com.jn.enterprise.servicemarket.require.model;

import com.jn.common.model.Page;
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

    @ApiModelProperty(value = "[科技金融]融资金额")
    private String financingAmount;
    @ApiModelProperty(value = "[科技金融]融资期限")
    private String financingPeriod;
    @ApiModelProperty(value = "[科技金融]资金需求说明")
    private String fundsReqDesc;
    @ApiModelProperty(value = "[科技金融]资金需求日期")
    private Date expectedDate;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getExpectedDate() {
        return expectedDate;
    }

    public void setExpectedDate(Date expectedDate) {
        this.expectedDate = expectedDate;
    }

    @Override
    public String toString() {
        return "RequireOtherDetails{" +
                "companyName='" + companyName + '\'' +
                ", reqNum='" + reqNum + '\'' +
                ", issueTime=" + issueTime +
                ", orgName='" + orgName + '\'' +
                ", productName='" + productName + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", reqName='" + reqName + '\'' +
                ", reqPhone='" + reqPhone + '\'' +
                ", reqEmail='" + reqEmail + '\'' +
                ", requireDetail='" + requireDetail + '\'' +
                ", financingAmount='" + financingAmount + '\'' +
                ", financingPeriod='" + financingPeriod + '\'' +
                ", fundsReqDesc='" + fundsReqDesc + '\'' +
                ", expectedDate=" + expectedDate +
                '}';
    }
}
