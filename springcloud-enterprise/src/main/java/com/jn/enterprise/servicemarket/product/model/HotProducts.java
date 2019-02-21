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
    @ApiModelProperty(value = "产品名称")
    private String  productName;
    @ApiModelProperty(value = "产品图片路径")
    private String  pictureUrl;
    @ApiModelProperty(value = "服务产品参考价格范围")
    private String referPrice;
    @ApiModelProperty(value = "机构个数")
    private Integer orgCount;
    @ApiModelProperty(value = "顾问人数")
    private Integer advisorCount;
    @ApiModelProperty(value = "评论次数")
    private Integer ratingCount;

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
}
