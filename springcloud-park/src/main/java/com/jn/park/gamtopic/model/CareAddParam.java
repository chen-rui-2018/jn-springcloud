package com.jn.park.gamtopic.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/16 9:58
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="CareAddParam",description = "关注/取关入参")
public class CareAddParam implements Serializable {
    @ApiModelProperty(value= "被关注者的账号",required = true ,example = "wangsong")
    @NotBlank(message = "被关注者账号不能为空")
    private String account;
    @ApiModelProperty(value= "被关注者的账号类型 0:个人账号--1:企业账号",required = true ,example = "0")
    @NotBlank(message = "被关注者账号类型不能为空")
    private String receiveType;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getReceiveType() {
        return receiveType;
    }

    public void setReceiveType(String receiveType) {
        this.receiveType = receiveType;
    }
}
