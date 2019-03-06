package com.jn.enterprise.servicemarket.require.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/6 10:25
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "RequireInfoList", description = "需求管理列表信息（后台门户管理）")
public class RequirePortalInfoList extends Page implements Serializable {
    @ApiModelProperty(value = "需求单号")
    private String reqNum;
    @ApiModelProperty(value = "企业名称")
    private String companyName;
    @ApiModelProperty(value = "领域id")
    private String businessId;
    @ApiModelProperty(value = "领域名称")
    private String businessArea;
    @ApiModelProperty(value = "服务产品id")
    private String productId;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务机构id")
    private String orgId;
    @ApiModelProperty(value = "服务机构名称")
    private String orgName;
    @ApiModelProperty(value = "服务顾问账号")
    private String advisorAccount;
    @ApiModelProperty(value = "服务顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "需求人")
    private String issueAccount;
    @ApiModelProperty(value = "产品分类")
    private String productType;
    @ApiModelProperty(value = "需求日期")
    private String requireTime;
    @ApiModelProperty(value = "对接结果")
    private String handleResult;

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

    public String getIssueAccount() {
        return issueAccount;
    }

    public void setIssueAccount(String issueAccount) {
        this.issueAccount = issueAccount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getRequireTime() {
        return requireTime;
    }

    public void setRequireTime(String requireTime) {
        this.requireTime = requireTime;
    }

    public String getHandleResult() {
        return handleResult;
    }

    public void setHandleResult(String handleResult) {
        this.handleResult = handleResult;
    }
}
