package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 前台 web 服务产品信息
 * @author： chenr
 * @date： Created on 2019/2/20 17:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="WebServiceProductDetails", description = "前台 web 服务产品信息")
public class WebServiceProductDetails implements Serializable {
    @ApiModelProperty(value = "产品Id")
    private String productId;
    @ApiModelProperty(value ="产品编号")
    private String serialNumber;
    @ApiModelProperty(value = "产品名称")
    private String productName;
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
    @ApiModelProperty(value = "产品详情")
    private String productDetails;
    @ApiModelProperty(value = "交易数")
    private Integer transactionsNumber;
    @ApiModelProperty(value = "浏览数")
    private Integer viewCount;
    @ApiModelProperty(value = "评价分数")
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

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
