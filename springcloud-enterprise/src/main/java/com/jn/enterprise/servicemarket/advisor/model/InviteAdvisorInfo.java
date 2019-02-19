package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/2/19 16:09
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "AdvisorInquiryInfo",description = "顾问邀请入参")
public class InviteAdvisorInfo extends Page implements Serializable {
    @ApiModelProperty(value = "注册手机/邮箱")
    @NotNull(message = "注册手机/邮箱不能为空")
    private String registerAccount;
    @ApiModelProperty(value = "邀请人账号(当前登录用户账号)")
    @NotNull(message = "邀请人账号不能为空")
    private String inviteAccount;

    private static final long serialVersionUID = 1L;

    public String getRegisterAccount() {
        return registerAccount;
    }

    public void setRegisterAccount(String registerAccount) {
        this.registerAccount = registerAccount;
    }

    public String getInviteAccount() {
        return inviteAccount;
    }

    public void setInviteAccount(String inviteAccount) {
        this.inviteAccount = inviteAccount;
    }
}
