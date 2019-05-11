package com.jn.user.address.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户地址Param
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserAddressParam",description = "地址参数")
public class UserAddressParam implements Serializable {

    @ApiModelProperty(value = "地址ID【传ID为修改，不传为新增】",example = "e2941***")
    private String addressId;
    @ApiModelProperty(value = "收货人",required = true,example = "wangsong")
    @NotNull(message="收货人不能为空")
    private String receiverName;
    @ApiModelProperty(value = "手机号码",required = true,example = "18155557777")
    @NotNull(message="手机号码不能为空")
    private String reveiverPhone;
    @ApiModelProperty(value = "固话/备用号码",example = "0739-42225500")
    private String reveiverTel;
    @ApiModelProperty(value = "省",required = true,example = "湖南省")
    @NotNull(message="省不能为空")
    private String addressProvince;
    @ApiModelProperty(value = "市",required = true,example = "长沙市")
    @NotNull(message="市不能为空")
    private String addressCity;
    @ApiModelProperty(value = "区县",required = true,example = "岳麓区")
    @NotNull(message="区县不能为空")
    private String addressArea;
    @ApiModelProperty(value = "街道",required = true,example = "岳麓街道")
    private String addressStreet;
    @ApiModelProperty(value = "详细地址",required = true,example = "文轩路麓谷企业广场F3栋")
    @NotNull(message="详细地址不能为空")
    private String addressDetail;
    @NotNull(message="是否默认不能为空")
    @ApiModelProperty(value = "是否默认 0否1是",required = true,example = "0")
    private String isDefault;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
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
