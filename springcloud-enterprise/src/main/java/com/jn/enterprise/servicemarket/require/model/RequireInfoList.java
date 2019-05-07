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
    @ApiModelProperty(value = "意向顾问账号")
    private String advisorAccount;
    @ApiModelProperty(value = "意向顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "提需求日期")
    private String requireTime;
    @ApiModelProperty(value = "需求状态")
    private String status;
    @ApiModelProperty(value = "对接结果")
    private String handleResult;


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
                '}';
    }
}
