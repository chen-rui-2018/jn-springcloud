package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 *  机构新增特色服务产品的bean(非科技金融)
 * @author： chenr
 * @date： Created on 2019/3/23 16:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="AddFeatureProduct",description = "机构新增特色服务产品的bean(非科技金融)")
public class AddFeatureProduct implements Serializable {
    @ApiModelProperty(value = "服务产品编号,从编号接口获取",required = true,example = "TS000131226.0570718997558")
    @NotBlank(message = "服务产品编号不能为空")
    private String serialNumber;
    @ApiModelProperty(value = "服务产品名称",required = true,example = "代理记账")
    @NotBlank(message = "服务产品名称不能为空")
    private String productName;
    @ApiModelProperty(value = "服务产品参考价格范围",required = true, example = "100-1000")
    @NotBlank(message = "服务产品参考价格范围不能为空")
    private String referPrice;
    @ApiModelProperty(value = "服务产品领域ID,所选领域的id",required = true,example = "human_resources")
    @NotBlank(message = "服务产品领域ID不能为空")
    private String signoryId;
    @ApiModelProperty(value = "服务产品领域名称,所选领域的名称",required = true,example = "人力资源")
    @NotBlank(message = "服务产品领域名称不能为空")
    private String signoryName;
    @ApiModelProperty(value = "服务产品服务周期,单位为年或月或者日(天)",required = true,example = "如资料齐全,一个月")
    @NotBlank(message = "服务产品服务周期不能为空")
    private String serviceCycle;
    @ApiModelProperty(value = "服务产品图片路径",example = "http://www.pptok.com/wp-content/uploads/2012/08/xunguang-4.jpg")
    private String pictureUrl;
    @ApiModelProperty(value = "服务产品类型(0-常规产品,1-特色产品)0 ",required = true,example = "1")
    @NotBlank(message = "服务产品类型不能为空")
    private String productType;
    @ApiModelProperty(value = "服务产品顾问账号,多个时使用逗号','分隔",example = "wangsong,qianqi")
    private String advisorAccount;
    @ApiModelProperty(value = "服务产品详情",example = "本产品,服务........")
    private String productDetails;
    @ApiModelProperty(value = "服务产品机构id",required = true,example = "040e6f1a459e49989fd6db3dc2dfd6a4")
    @NotBlank(message = "上架此服务产品的机构id不能为空")
    private String orgId;

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

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
