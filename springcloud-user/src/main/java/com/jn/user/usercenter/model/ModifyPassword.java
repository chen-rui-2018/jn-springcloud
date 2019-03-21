package com.jn.user.usercenter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 修改密码
 * @author： chenr
 * @date： Created on 2019/3/5 20:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="ModifyPassword" ,description = "修改用户密码")
public class ModifyPassword implements Serializable {
    @ApiModelProperty(value = "用户账号" ,required = true)
    @NotBlank(message="用户账号不能为空")
    private String account;
    @ApiModelProperty(value = "旧密码",required = true)
    @NotBlank(message="用户旧密码不能为空")
    private String oldPassword;
    @ApiModelProperty(value = "新密码A" ,required = true)
    @NotBlank(message="新密码不能为空")
    private String newPasswordA;
    @ApiModelProperty(value = "新密码B" ,required = true)
    @NotBlank(message="新密码不能为空")
    private String newPasswordB;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPasswordA() {
        return newPasswordA;
    }

    public void setNewPasswordA(String newPasswordA) {
        this.newPasswordA = newPasswordA;
    }

    public String getNewPasswordB() {
        return newPasswordB;
    }

    public void setNewPasswordB(String newPasswordB) {
        this.newPasswordB = newPasswordB;
    }
}
