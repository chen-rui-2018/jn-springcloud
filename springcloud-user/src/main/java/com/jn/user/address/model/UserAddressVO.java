package com.jn.user.address.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户地址信息
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserAddressVO",description = "用户地址信息")
public class UserAddressVO implements Serializable {

    @ApiModelProperty(value = "地址ID")
    private String addressId;
    @ApiModelProperty(value = "收货人")
    private String userAccount;
    @ApiModelProperty(value = "收货人")
    private String receiverName;
    @ApiModelProperty(value = "手机号码")
    private String reveiverPhone;
    @ApiModelProperty(value = "固话/备用号码")
    private String reveiverTel;
    @ApiModelProperty(value = "省")
    private String addressProvince;
    @ApiModelProperty(value = "市")
    private String addressCity;
    @ApiModelProperty(value = "区县")
    private String addressArea;
    @ApiModelProperty(value = "街道")
    private String addressStreet;
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;
    @ApiModelProperty(value = "是否默认 0否1是")
    private String isDefault;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReveiverPhone() {
        return reveiverPhone;
    }

    public void setReveiverPhone(String reveiverPhone) {
        this.reveiverPhone = reveiverPhone;
    }

    public String getReveiverTel() {
        return reveiverTel;
    }

    public void setReveiverTel(String reveiverTel) {
        this.reveiverTel = reveiverTel;
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
