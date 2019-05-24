package com.jn.user.userinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户设备入参（极光推送）
 * @author： huxw
 * @date： Created on 2019-5-23 19:50:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserDeviceParam",description = "用户设备入参（极光推送）")
public class UserDeviceParam implements Serializable {

    @ApiModelProperty(value = "账号", hidden = true)
    private String account;

    @ApiModelProperty(value = "极光推送注册ID")
    @NotNull(message = "极光推送注册ID不能为空")
    private String registrationId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public String toString() {
        return "UserDeviceParam{" +
                "account='" + account + '\'' +
                ", registrationId='" + registrationId + '\'' +
                '}';
    }
}
