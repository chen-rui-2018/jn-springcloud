package com.jn.hardware.model.electricmeter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 17:06
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricAccessTokenParam" ,description = "电表access_token获取入参")
public class ElectricAccessTokenParam  implements Serializable {

    private static final long serialVersionUID = 6138216455570246766L;
    @ApiModelProperty(value = "接口平台秘钥，取值：“client_leiyou” 不需要",required = true,example = "client_leiyou")
    @NotBlank(message = "接口平台秘钥不为空")
    private String  client_secret;
    @ApiModelProperty(value = "接口平台ID，取值：“client_api” 不需要",required = true,example = "client_api")
    @NotBlank(message = "接口平台ID不为空")
    private String  client_id;
    @ApiModelProperty(value = "认证类型，取值：“password”",required = true,example = "password")
    @NotBlank(message = "认证类型不能为空")
    private String  grant_type;
    @ApiModelProperty(value = "接口平台分配的物业用户名",required = true,example = "18351162350")
    @NotBlank(message = "用户名不能为空")
    private String  username;
    @ApiModelProperty(value = "接口平台分配的物业密码",required = true,example = "18351162350")
    @NotBlank(message = "密码不能为空")
    private String  password;
    @ApiModelProperty(value = "领域",required = true,example = "all")
    @NotBlank(message = "scopes 领域不能为空")
    private String  scopes;

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    @Override
    public String toString() {
        return "ElectricAccessTokenParam{" +
                "client_secret='" + client_secret + '\'' +
                ", client_id='" + client_id + '\'' +
                ", grant_type='" + grant_type + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", scopes='" + scopes + '\'' +
                '}';
    }
}
