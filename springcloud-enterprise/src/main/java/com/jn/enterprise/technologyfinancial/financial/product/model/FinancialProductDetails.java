package com.jn.enterprise.technologyfinancial.financial.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/19 15:48
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialProductDetails", description = "金融产品详情")
public class FinancialProductDetails implements Serializable {
    @ApiModelProperty(value = "产品id)")
    private String productId;
    @ApiModelProperty(value = "产品名称)")
    private String productName;
    @ApiModelProperty(value = "产品编号)")
    private String serialNumber;
    @ApiModelProperty(value = "领域id)")
    private String signoryId;
    @ApiModelProperty(value = "领域名称)")
    private String signoryName;
    @ApiModelProperty(value = "机构id)")
    private String orgId;
    @ApiModelProperty(value = "机构名称)")
    private String orgName;
    @ApiModelProperty(value = "产品图片)")
    private String pictureUrl;
    @ApiModelProperty(value = "产品类型)")
    private String productType;
    @ApiModelProperty(value = "状态(0:无效  1：有效))")
    private String status;
    @ApiModelProperty(value = "参考利率最小值)")
    private Double refRateMin;
    @ApiModelProperty(value = "参考利率最大值)")
    private Double refRateMax;
    @ApiModelProperty(value = "是否网贷直联(0:否 1：是))")
    private String isOnlineLoan;
    @ApiModelProperty(value = "是否政策性产品(0:否 1：是))")
    private String isPolicyPro;
    @ApiModelProperty(value = "是否通用产品(0:否 1：是))")
    private String isGeneralPro;
    @ApiModelProperty(value = "是否人民币(0:否 1：是))")
    private String isRmb;
    @ApiModelProperty(value = "贷款类别编码)")
    private String loanCategoryCode;
    @ApiModelProperty(value = "贷款类别名称)")
    private String loanCategoryName;
    @ApiModelProperty(value = "贷款最小额度)")
    private Double loanAmountMin;
    @ApiModelProperty(value = "贷款最大额度)")
    private Double loanAmountMax;
    @ApiModelProperty(value = "贷款最小期限)")
    private Integer loanTermMin;
    @ApiModelProperty(value = "贷款最大期限)")
    private Integer loanTermMax;
    @ApiModelProperty(value = "担保方式编码)")
    private String assureMethodCode;
    @ApiModelProperty(value = "担保方式名称)")
    private String assureMethodName;
    @ApiModelProperty(value = "产品特点)")
    private String productFeature;
    @ApiModelProperty(value = "申请条件)")
    private String applyCondition;
    @ApiModelProperty(value = "提交材料)")
    private String submitMaterial;
    @ApiModelProperty(value = "适用客户)")
    private String applicableCuster;
    @ApiModelProperty(value = "交易量)")
    private String transactionNum;
    @ApiModelProperty(value = "浏览量)")
    private String viewCount;
    @ApiModelProperty(value = "评分)")
    private String evaluationScore;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getSignoryName() {
        return signoryName;
    }

    public void setSignoryName(String signoryName) {
        this.signoryName = signoryName;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRefRateMin() {
        return refRateMin;
    }

    public void setRefRateMin(Double refRateMin) {
        this.refRateMin = refRateMin;
    }

    public Double getRefRateMax() {
        return refRateMax;
    }

    public void setRefRateMax(Double refRateMax) {
        this.refRateMax = refRateMax;
    }

    public String getIsOnlineLoan() {
        return isOnlineLoan;
    }

    public void setIsOnlineLoan(String isOnlineLoan) {
        this.isOnlineLoan = isOnlineLoan;
    }

    public String getIsPolicyPro() {
        return isPolicyPro;
    }

    public void setIsPolicyPro(String isPolicyPro) {
        this.isPolicyPro = isPolicyPro;
    }

    public String getIsGeneralPro() {
        return isGeneralPro;
    }

    public void setIsGeneralPro(String isGeneralPro) {
        this.isGeneralPro = isGeneralPro;
    }

    public String getIsRmb() {
        return isRmb;
    }

    public void setIsRmb(String isRmb) {
        this.isRmb = isRmb;
    }

    public String getLoanCategoryCode() {
        return loanCategoryCode;
    }

    public void setLoanCategoryCode(String loanCategoryCode) {
        this.loanCategoryCode = loanCategoryCode;
    }

    public String getLoanCategoryName() {
        return loanCategoryName;
    }

    public void setLoanCategoryName(String loanCategoryName) {
        this.loanCategoryName = loanCategoryName;
    }

    public Double getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(Double loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public Double getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(Double loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    public Integer getLoanTermMin() {
        return loanTermMin;
    }

    public void setLoanTermMin(Integer loanTermMin) {
        this.loanTermMin = loanTermMin;
    }

    public Integer getLoanTermMax() {
        return loanTermMax;
    }

    public void setLoanTermMax(Integer loanTermMax) {
        this.loanTermMax = loanTermMax;
    }

    public String getAssureMethodCode() {
        return assureMethodCode;
    }

    public void setAssureMethodCode(String assureMethodCode) {
        this.assureMethodCode = assureMethodCode;
    }

    public String getAssureMethodName() {
        return assureMethodName;
    }

    public void setAssureMethodName(String assureMethodName) {
        this.assureMethodName = assureMethodName;
    }

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    public String getApplyCondition() {
        return applyCondition;
    }

    public void setApplyCondition(String applyCondition) {
        this.applyCondition = applyCondition;
    }

    public String getSubmitMaterial() {
        return submitMaterial;
    }

    public void setSubmitMaterial(String submitMaterial) {
        this.submitMaterial = submitMaterial;
    }

    public String getApplicableCuster() {
        return applicableCuster;
    }

    public void setApplicableCuster(String applicableCuster) {
        this.applicableCuster = applicableCuster;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public String getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    @Override
    public String toString() {
        return "FinancialProductDetails{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", signoryId='" + signoryId + '\'' +
                ", signoryName='" + signoryName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", productType='" + productType + '\'' +
                ", status='" + status + '\'' +
                ", refRateMin=" + refRateMin +
                ", refRateMax=" + refRateMax +
                ", isOnlineLoan='" + isOnlineLoan + '\'' +
                ", isPolicyPro='" + isPolicyPro + '\'' +
                ", isGeneralPro='" + isGeneralPro + '\'' +
                ", isRmb='" + isRmb + '\'' +
                ", loanCategoryCode='" + loanCategoryCode + '\'' +
                ", loanCategoryName='" + loanCategoryName + '\'' +
                ", loanAmountMin=" + loanAmountMin +
                ", loanAmountMax=" + loanAmountMax +
                ", loanTermMin=" + loanTermMin +
                ", loanTermMax=" + loanTermMax +
                ", assureMethodCode='" + assureMethodCode + '\'' +
                ", assureMethodName='" + assureMethodName + '\'' +
                ", productFeature='" + productFeature + '\'' +
                ", applyCondition='" + applyCondition + '\'' +
                ", submitMaterial='" + submitMaterial + '\'' +
                ", applicableCuster='" + applicableCuster + '\'' +
                ", transactionNum='" + transactionNum + '\'' +
                ", viewCount='" + viewCount + '\'' +
                ", evaluationScore='" + evaluationScore + '\'' +
                '}';
    }
}
