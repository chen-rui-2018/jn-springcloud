package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 顾问-服务产品列表信息
 * @author： chenr
 * @date： Created on 2019/2/27 17:08
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorProductInfo" ,description = "顾问-服务产品列表信息")
public class AdvisorProductInfo implements Serializable {
    @ApiModelProperty(value = "产品Id")
    private String productId;
    @ApiModelProperty(value ="产品编号")
    private String serialNumber;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "领域id")
    private String signoryId;
    @ApiModelProperty(value ="机构名称")
    private String orgName;
    @ApiModelProperty(value = "顾问名称")
    private String advisorName;
    @ApiModelProperty(value = "参考价格")
    private String referPrice;
    @ApiModelProperty(value = "服务周期")
    private String serviceCycle;
    @ApiModelProperty(value ="产品图片")
    private String pictureUrl;
    @ApiModelProperty(value = "交易数")
    private Integer transactionsNumber;
    @ApiModelProperty(value = "浏览数")
    private Integer viewCount;
    @ApiModelProperty(value = "评价分数")
    private String evaluationScore;
    @ApiModelProperty(value = "评价数")
    private String evaluationNumber;
    @ApiModelProperty(value ="全部服务数")
    private Integer serviceTotal;
    @ApiModelProperty(value = "常规服务数")
    private Integer commonTotal;
    @ApiModelProperty(value = "特色服务数")
    private Integer featureTotal;
    @ApiModelProperty(value = "五星好评数")
    private Integer praiseTotal;
    public Integer getServiceTotal() {
        return serviceTotal;
    }

    public void setServiceTotal(Integer serviceTotal) {
        this.serviceTotal = serviceTotal;
    }

    public Integer getCommonTotal() {
        return commonTotal;
    }

    public void setCommonTotal(Integer commonTotal) {
        this.commonTotal = commonTotal;
    }

    public Integer getFeatureTotal() {
        return featureTotal;
    }

    public void setFeatureTotal(Integer featureTotal) {
        this.featureTotal = featureTotal;
    }

    public Integer getPraiseTotal() {
        return praiseTotal;
    }

    public void setPraiseTotal(Integer praiseTotal) {
        this.praiseTotal = praiseTotal;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getReferPrice() {
        return referPrice;
    }

    public void setReferPrice(String referPrice) {
        this.referPrice = referPrice;
    }

    public String getServiceCycle() {
        return serviceCycle;
    }

    public void setServiceCycle(String serviceCycle) {
        this.serviceCycle = serviceCycle;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getTransactionsNumber() {
        return transactionsNumber;
    }

    public void setTransactionsNumber(Integer transactionsNumber) {
        this.transactionsNumber = transactionsNumber;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public String getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(String evaluationScore) {
        this.evaluationScore = evaluationScore;
    }

    public String getEvaluationNumber() {
        return evaluationNumber;
    }

    public void setEvaluationNumber(String evaluationNumber) {
        this.evaluationNumber = evaluationNumber;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    @Override
    public String toString() {
        return "AdvisorProductInfo{" +
                "productId='" + productId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", signoryId='" + signoryId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", referPrice='" + referPrice + '\'' +
                ", serviceCycle='" + serviceCycle + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", transactionsNumber=" + transactionsNumber +
                ", viewCount=" + viewCount +
                ", evaluationScore='" + evaluationScore + '\'' +
                ", evaluationNumber='" + evaluationNumber + '\'' +
                ", serviceTotal=" + serviceTotal +
                ", commonTotal=" + commonTotal +
                ", featureTotal=" + featureTotal +
                ", praiseTotal=" + praiseTotal +
                '}';
    }
}
