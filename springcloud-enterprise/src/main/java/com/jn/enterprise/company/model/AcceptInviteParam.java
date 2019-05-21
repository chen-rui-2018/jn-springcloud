package com.jn.enterprise.company.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 接收邀请入参
 * @author： huxw
 * @date： Created on 2019-4-11 10:01:42
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AcceptInviteParam",description = "接收邀请入参")
public class AcceptInviteParam implements Serializable {

    @ApiModelProperty(value = "账号", hidden = true)
    private String account;

    @ApiModelProperty(value = "企业ID", required = true)
    @NotNull(message = "企业ID不能为空")
    private String comId;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "出生年月yyyy-mm-dd", example = "2019-01-01")
    private String birthday;

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AcceptInviteParam{" +
                "account='" + account + '\'' +
                ", comId='" + comId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
