package com.jn.park.care.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: jiangyl
 * @Date: 2019/5/9 16:44
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "CareParam",description = "政策中心首页入参")
public class CareParam extends Page implements Serializable {
    @ApiModelProperty(value = "查询的公司账号",example = "wangsong")
    private String account;
    @ApiModelProperty(value = "当前账号",example = "wangsong")
    private String currentAccount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(String currentAccount) {
        this.currentAccount = currentAccount;
    }
}
