package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 后台 修改常规产品时,进入页面后的 常规产品详情展示
 * @author： chenr
 * @date： Created on 2019/3/25 10:57
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UpdateCommonProductShow",description = "后台 修改常规产品时,进入页面后的 常规产品详情展示")
public class UpdateCommonProductShow implements Serializable {
    @ApiModelProperty(value = "服务产品ID")
    private String productId;
    @ApiModelProperty(value = "服务产品编号")
    private String serialNumber;
    @ApiModelProperty(value = "服务产品类型(0-常规产品,1-特色产品)")
    private String productType;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务产品领域ID")
    private String signoryId;
    @ApiModelProperty(value = "服务产品领域名称")
    private String signoryName;
    @ApiModelProperty(value = "服务产品参考价格范围")
    private String referPrice;
    @ApiModelProperty(value = "服务产品服务周期,单位为年或月或者日(天)")
    private String serviceCycle;
    @ApiModelProperty(value = "机构名称")
    private String orgName;
    @ApiModelProperty(value = "服务产品图片路径")
    private String pictureUrl;
    @ApiModelProperty(value = "顾问名称")
    private String advisorName ;
    @ApiModelProperty(value = "服务产品的详情存入数据库时,后台转换使用")
    private String serviceDetails;
    @ApiModelProperty(value = "服务产品详情(描述)")
    private String productDetails;

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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


    public String getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(String serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
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

    @Override
    public String toString() {
        return "UpdateCommonProductShow{" +
                "productId='" + productId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", signoryId='" + signoryId + '\'' +
                ", signoryName='" + signoryName + '\'' +
                ", referPrice='" + referPrice + '\'' +
                ", serviceCycle='" + serviceCycle + '\'' +
                ", orgName='" + orgName + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", advisorName='" + advisorName + '\'' +
                ", serviceDetails='" + serviceDetails + '\'' +
                ", productDetails='" + productDetails + '\'' +
                '}';
    }
}
