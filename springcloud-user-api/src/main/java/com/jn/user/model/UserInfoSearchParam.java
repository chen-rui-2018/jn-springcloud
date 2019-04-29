package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;

/**
 * 批量获取用户信息入参
 * @author： huxw
 * @date： Created on 2019-4-12 11:03:06
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserInfoSearchParam",description = "批量获取用户信息入参")
public class UserInfoSearchParam implements Serializable {

    @ApiModelProperty(value = "账号数组", required = true)
    @NotNull(message = "账号数组不能为空")
    private List<String> accountList;

    @ApiModelProperty(value = "查询字段", required = true)
    @NotNull(message = "查询字段")
    private String searchFiled;

    public List<String> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<String> accountList) {
        this.accountList = accountList;
    }

    public String getSearchFiled() {
        return searchFiled;
    }

    public void setSearchFiled(String searchFiled) {
        this.searchFiled = searchFiled;
    }
}
