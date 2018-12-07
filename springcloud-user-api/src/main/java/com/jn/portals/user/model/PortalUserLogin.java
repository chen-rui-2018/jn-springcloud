package com.jn.portals.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

/**
 * 平台登录用户信息
 *
 * @Author: yangph
 * @Date: 2018/11/29 14:08
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "PortalUserLogin", description = "用户信息")
public class PortalUserLogin {
    private static final long serialVersionUID = -7484136779753770396L;

    @ApiModelProperty(value = "账户名", required = true)
    @Size(min = 6, max = 16, message = "账号不正确")
    private String account;
    @ApiModelProperty(value = "密码", required = true)
    @Size(min = 6, max = 16, message = "密码不正确")
    private String password;
    @ApiModelProperty(value = "登录模式  账号密码登录--account  手机号验证码登录--sms   微信登录--wechat", required = true)
    private String logintype;
    @ApiModelProperty(value = "滑动验证key  账号密码登录需要传递滑动验证key", required = true)
    private String verifyKey;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogintype() {
        return logintype;
    }

    public void setLogintype(String logintype) {
        this.logintype = logintype;
    }

    public String getVerifyKey() {
        return verifyKey;
    }

    public void setVerifyKey(String verifyKey) {
        this.verifyKey = verifyKey;
    }
}
