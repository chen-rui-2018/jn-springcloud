package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务超市首页,热门产品
 * @author： chenr
 * @date： Created on 2019/2/19 15:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "HotProducts" ,description = "热门产品")
public class HotProducts  implements Serializable {

    @ApiModelProperty(value = "产品id")
    private String  productId;
    @ApiModelProperty(value = "产品名称")
    private String  productName;
    @ApiModelProperty(value = "领域Id")
    private String  signoryId;
    @ApiModelProperty(value = "产品图片路径")
    private String  pictureUrl;
    @ApiModelProperty(value = "服务产品参考价格范围")
    private String referPrice;
    @ApiModelProperty(value = "机构个数")
    private Integer orgCount;
    @ApiModelProperty(value = "专员人数")
    private Integer advisorCount;
    @ApiModelProperty(value = "评论次数")
    private Integer ratingCount;
    @ApiModelProperty(value = "产品详情")
    private String productDetails;
    @ApiModelProperty(value = "产品简介")
    private String productBrief;

    public String getProductBrief() {
        return productBrief;
    }

    public void setProductBrief(String productBrief) {
        this.productBrief = productBrief;
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

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Integer getOrgCount() {
        return orgCount;
    }

    public void setOrgCount(Integer orgCount) {
        this.orgCount = orgCount;
    }

    public Integer getAdvisorCount() {
        return advisorCount;
    }

    public void setAdvisorCount(Integer advisorCount) {
        this.advisorCount = advisorCount;
    }

    public Integer getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(Integer ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getReferPrice() {
        return referPrice;
    }

    public void setReferPrice(String referPrice) {
        this.referPrice = referPrice;
    }

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "HotProducts{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", signoryId='" + signoryId + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", referPrice='" + referPrice + '\'' +
                ", orgCount=" + orgCount +
                ", advisorCount=" + advisorCount +
                ", ratingCount=" + ratingCount +
                ", productDetails='" + productDetails + '\'' +
                ", productBrief='" + productBrief + '\'' +
                '}';
    }
}
