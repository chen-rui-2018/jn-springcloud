package com.jn.user.address.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * y用户地址查询入参
 * @author： jiangyl
 * @date： Created on 2019/3/6 16:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserDefaultAddressParam",description = "地址查询入参")
public class UserDefaultAddressParam implements Serializable {

    @ApiModelProperty(value = "地址ID【传ID为修改，不传为新增】",example = "e2941***")
    private String addressId;

    @NotNull(message="是否默认不能为空")
    @ApiModelProperty(value = "是否默认 0否1是",required = true,example = "0")
    private String isDefault;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "UserDefaultAddressParam{" +
                "addressId='" + addressId + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
