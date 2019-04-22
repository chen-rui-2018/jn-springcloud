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

    @ApiModelProperty(value = "账号", required = true)
    @NotNull(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "企业ID", required = true)
    @NotNull(message = "企业ID不能为空")
    private String comId;

    @ApiModelProperty(value = "昵称", required = true)
    @NotNull(message = "昵称不能为空")
    private String nickName;

    @ApiModelProperty(value = "真实姓名", required = true)
    @NotNull(message = "真实姓名不能为空")
    private String name;

    @ApiModelProperty(value = "手机号", required = true)
    @NotNull(message = "手机不能为空")
    private String phone;

    @ApiModelProperty(value = "出生年月yyyy-mm-dd", required = true, example = "2019-01-01")
    @NotNull(message = "出生年月不能为空")
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
}
