package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


/**
 * @author： chenr
 * @date： Created on 2019/02/13 9:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceContent", description = "服务基本信息")
public class ServiceContent  implements Serializable {
    @ApiModelProperty(value = "服务产品ID")
    private String productId;
    @ApiModelProperty(value = "服务产品编号,新增常规产品时不能为空")
    private String serialNumber;
    @ApiModelProperty(value = "服务产品名称",required = true)
    @NotBlank(message = "服务产品名称不能为空")
    private String productName;
    @ApiModelProperty(value = "服务产品参考价格范围",required = true)
    @NotBlank(message = "服务产品参考价格范围不能为空")
    private String referPrice;
    @ApiModelProperty(value = "服务产品领域ID",required = true)
    @NotBlank(message = "服务产品领域ID不能为空")
    private String signoryId;
    @ApiModelProperty(value = "服务产品领域名称",required = true)
    @NotBlank(message = "服务产品领域名称不能为空")
    private String signoryName;
    @ApiModelProperty(value = "服务产品机构id,,机构上架常规服务,添加特色服务时不能为空")
    private String orgId;
    @ApiModelProperty(value = "服务产品服务周期,单位为年或月或者日(天)",required = true)
    @NotBlank(message = "服务产品服务周期不能为空")
    private String serviceCycle;
    @ApiModelProperty(value = "服务产品图片路径")
    private String pictureUrl;
    @ApiModelProperty(value = "服务产品类型(0-常规产品,1-特色产品)0 ",required = true)
    @NotBlank(message = "服务产品类型不能为空")
    private String productType;
    @ApiModelProperty(value = "服务产品顾问账号,多个时使用逗号','分隔")
    private String advisorAccount;
    @ApiModelProperty(value = "服务产品描述byte数组")
    private byte[] serviceDetails;
    @ApiModelProperty(value = "服务产品详情")
    private String productDetails;

    private static final long serialVersionUID = 1L;

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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public byte[] getServiceDetails() {
        return serviceDetails;
    }

    public void setServiceDetails(byte[] serviceDetails) {
        this.serviceDetails = serviceDetails;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }
}
