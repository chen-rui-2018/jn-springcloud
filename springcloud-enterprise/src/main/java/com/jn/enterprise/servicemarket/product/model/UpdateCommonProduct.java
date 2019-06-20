package com.jn.enterprise.servicemarket.product.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 后台更新服务产品
 * @author： chenr
 * @date： Created on 2019/3/23 15:03
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="UpdateCommonProduct",description = "后台更新服务产品bean")
public class UpdateCommonProduct implements Serializable {
    @ApiModelProperty(value = "服务产品Id",required = true,example = "19d19552832f47198b193d1913275866")
    @NotBlank(message = "更新服务产品时服务产品id不能为空")
    private String productId;
    @ApiModelProperty(value = "服务产品编号",required = true,example = "CG000131226.0570718997558")
    @NotBlank(message = "服务产品编号不能为空")
    private String serialNumber;
    @ApiModelProperty(value = "服务产品名称",required = true,example = "代理记账")
    @NotBlank(message = "服务产品名称不能为空")
    private String productName;
    @ApiModelProperty(value = "服务产品参考价格范围",required = true, example = "100-1000")
    @NotBlank(message = "服务产品参考价格范围不能为空")
    private String referPrice;
    @ApiModelProperty(value = "服务产品服务周期,单位为年或月或者日(天)",required = true,example = "如资料齐全,一个月")
    @NotBlank(message = "服务产品服务周期不能为空")
    private String serviceCycle;
    @ApiModelProperty(value = "服务产品图片路径",example = "http://www.pptok.com/wp-content/uploads/2012/08/xunguang-4.jpg")
    private String pictureUrl;
    @ApiModelProperty(value = "服务产品详情",example = "本产品,服务........")
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

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "UpdateCommonProduct{" +
                "productId='" + productId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", productName='" + productName + '\'' +
                ", referPrice='" + referPrice + '\'' +
                ", serviceCycle='" + serviceCycle + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", productDetails='" + productDetails + '\'' +
                '}';
    }
}
