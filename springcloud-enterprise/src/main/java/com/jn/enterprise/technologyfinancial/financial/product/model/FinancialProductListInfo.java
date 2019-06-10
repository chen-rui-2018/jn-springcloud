package com.jn.enterprise.technologyfinancial.financial.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/18 20:19
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "FinancialProductListInfo", description = "金融产品列表出参")
public class FinancialProductListInfo implements Serializable {
    @ApiModelProperty(value = "产品id)")
    private String productId;
    @ApiModelProperty(value = "产品名称)")
    private String productName;
    @ApiModelProperty(value = "产品图片)")
    private String pictureUrl;
    @ApiModelProperty(value = "服务机构id)")
    private String orgId;
    @ApiModelProperty(value = "服务机构名称)")
    private String orgName;
    @ApiModelProperty(value = "参考利率最小值)")
    private String refRateMin;
    @ApiModelProperty(value = "参考利率最大值)")
    private String refRateMax;
    @ApiModelProperty(value = "贷款额度最小值)")
    private String loanAmountMin;
    @ApiModelProperty(value = "贷款额度最大值)")
    private String loanAmountMax;
    @ApiModelProperty(value = "担保方式)")
    private String assureMethodName;
    @ApiModelProperty(value = "贷款期限最小值)")
    private String loanTermMin;
    @ApiModelProperty(value = "贷款期限最大值)")
    private String loanTermMax;
    @ApiModelProperty(value = "评价次数)")
    private String ratingNum;
    @ApiModelProperty(value = "评价分数)")
    private String ratingScore;
    @ApiModelProperty(value = "累计交易数)")
    private String transactionNum;

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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
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

    public String getRefRateMin() {
        return refRateMin;
    }

    public void setRefRateMin(String refRateMin) {
        this.refRateMin = refRateMin;
    }

    public String getRefRateMax() {
        return refRateMax;
    }

    public void setRefRateMax(String refRateMax) {
        this.refRateMax = refRateMax;
    }

    public String getLoanAmountMin() {
        return loanAmountMin;
    }

    public void setLoanAmountMin(String loanAmountMin) {
        this.loanAmountMin = loanAmountMin;
    }

    public String getLoanAmountMax() {
        return loanAmountMax;
    }

    public void setLoanAmountMax(String loanAmountMax) {
        this.loanAmountMax = loanAmountMax;
    }

    public String getAssureMethodName() {
        return assureMethodName;
    }

    public void setAssureMethodName(String assureMethodName) {
        this.assureMethodName = assureMethodName;
    }

    public String getLoanTermMin() {
        return loanTermMin;
    }

    public void setLoanTermMin(String loanTermMin) {
        this.loanTermMin = loanTermMin;
    }

    public String getLoanTermMax() {
        return loanTermMax;
    }

    public void setLoanTermMax(String loanTermMax) {
        this.loanTermMax = loanTermMax;
    }

    public String getRatingNum() {
        return ratingNum;
    }

    public void setRatingNum(String ratingNum) {
        this.ratingNum = ratingNum;
    }

    public String getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(String ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getTransactionNum() {
        return transactionNum;
    }

    public void setTransactionNum(String transactionNum) {
        this.transactionNum = transactionNum;
    }

    @Override
    public String toString() {
        return "FinancialProductListInfo{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", refRateMin='" + refRateMin + '\'' +
                ", refRateMax='" + refRateMax + '\'' +
                ", loanAmountMin='" + loanAmountMin + '\'' +
                ", loanAmountMax='" + loanAmountMax + '\'' +
                ", assureMethodName='" + assureMethodName + '\'' +
                ", loanTermMin='" + loanTermMin + '\'' +
                ", loanTermMax='" + loanTermMax + '\'' +
                ", ratingNum='" + ratingNum + '\'' +
                ", ratingScore='" + ratingScore + '\'' +
                ", transactionNum='" + transactionNum + '\'' +
                '}';
    }
}
