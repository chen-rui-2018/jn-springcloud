package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 前台 web 服务产品信息
 * @author： chenr
 * @date： Created on 2019/2/20 17:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="WebServiceProductInfo", description = "前台 web 服务产品信息")
public class WebServiceProductInfo implements Serializable {
    @ApiModelProperty(value = "产品Id")
    private String productId;
    @ApiModelProperty(value ="产品编号")
    private String serialNumber;
    @ApiModelProperty(value = "服务产品领域ID")
    private String signoryId;
    @ApiModelProperty(value = "产品名称")
    private String productName;
    @ApiModelProperty(value ="机构名称")
    private String orgId;
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
    @ApiModelProperty(value = "前台展示产品详情,产品内容")
    private String productDetails;
    @ApiModelProperty(value = "后台进行产品详情转换使用")
    private String serviceDetails;
    @ApiModelProperty(value = "交易数")
    private Integer transactionsNumber;
    @ApiModelProperty(value = "浏览数")
    private Integer viewCount;
    @ApiModelProperty(value = "评价分数")
    private String evaluationScore;
    @ApiModelProperty(value = "评价数")
    private String evaluationNumber;
    @ApiModelProperty(value = "上架此产品的机构数")
    private String upShelfOrgNumber;
    @ApiModelProperty(value = "同类型产品总数")
    private String sameTypeNum;
    @ApiModelProperty(value = "同类型产品常规产品数")
    private String commentNum;
    @ApiModelProperty(value = "同类型产品特色产品数")
    private String featureNum;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getSameTypeNum() {
        return sameTypeNum;
    }

    public void setSameTypeNum(String sameTypeNum) {
        this.sameTypeNum = sameTypeNum;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getFeatureNum() {
        return featureNum;
    }

    public void setFeatureNum(String featureNum) {
        this.featureNum = featureNum;
    }

    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getUpShelfOrgNumber() {
        return upShelfOrgNumber;
    }

    public void setUpShelfOrgNumber(String upShelfOrgNumber) {
        this.upShelfOrgNumber = upShelfOrgNumber;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
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

    public String getEvaluationNumber() {
        return evaluationNumber;
    }

    public void setEvaluationNumber(String evaluationNumber) {
        this.evaluationNumber = evaluationNumber;
    }

    @Override
    public String toString() {
        return "WebServiceProductInfo{" +
                "productId='" + productId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", signoryId='" + signoryId + '\'' +
                ", productName='" + productName + '\'' +
                ", orgId='" + orgId + '\'' +
                ", orgName='" + orgName + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", referPrice='" + referPrice + '\'' +
                ", serviceCycle='" + serviceCycle + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", serviceDetails='" + serviceDetails + '\'' +
                ", transactionsNumber=" + transactionsNumber +
                ", viewCount=" + viewCount +
                ", evaluationScore='" + evaluationScore + '\'' +
                ", evaluationNumber='" + evaluationNumber + '\'' +
                ", upShelfOrgNumber='" + upShelfOrgNumber + '\'' +
                ", sameTypeNum='" + sameTypeNum + '\'' +
                ", commentNum='" + commentNum + '\'' +
                ", featureNum='" + featureNum + '\'' +
                '}';
    }
}
