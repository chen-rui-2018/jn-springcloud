package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/15 11:45
 * @version： v1.0
 * @modified By:
 */
public class OrgCountProductInfo implements Serializable {
    @ApiModelProperty(value = "产品Id")
    private String productId;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value = "领域id")
    private String signoryId;
      @ApiModelProperty(value = "领域名称")
    private String signoryName;

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
}
