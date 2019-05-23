package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 服务产品管理,查询列表展示的bean
 * @author： chenr
 * @date： Created on 2019/2/14 11:39
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceProductManage", description = "服务管理列表展示bean信息")
public class ServiceProductManage implements Serializable {
    @ApiModelProperty(value = "服务产品ID")
    private String productId;
    @ApiModelProperty(value = "服务产品图片路径")
    private String pictureUrl;
    @ApiModelProperty(value = "服务产品名称")
    private String productName;
    @ApiModelProperty(value = "服务产品类型")
    private String productType;
    @ApiModelProperty(value = "服务产品领域id")
    private String signoryId;
    @ApiModelProperty(value = "服务产品领域名称")
    private String signoryName;
    @ApiModelProperty(value = "服务产品发布日期")
    private String releaseTime;
    @ApiModelProperty(value = "产品机构名称")
    private String orgName;
    @ApiModelProperty(value = "机构联系人名称")
    private String conName;
    @ApiModelProperty(value = "机构联系电话")
    private String conPhone;
    @ApiModelProperty(value = "服务产品状态,(-1无效0待审核1有效2审核不通过)")
    private String status;
    @ApiModelProperty(value = "顾问名称")
    private String advisorName;
    @ApiModelProperty(value="参考价格")
    private String  referPrice;

    public String getSignoryId() {
        return signoryId;
    }

    public void setSignoryId(String signoryId) {
        this.signoryId = signoryId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getReferPrice() {
        return referPrice;
    }

    public void setReferPrice(String referPrice) {
        this.referPrice = referPrice;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSignoryName() {
        return signoryName;
    }

    public void setSignoryName(String signoryName) {
        this.signoryName = signoryName;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConPhone() {
        return conPhone;
    }

    public void setConPhone(String conPhone) {
        this.conPhone = conPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }
}
