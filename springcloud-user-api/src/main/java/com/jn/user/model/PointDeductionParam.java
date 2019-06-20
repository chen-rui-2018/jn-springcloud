package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 积分收入入参
 * @author： jiangyl
 * @date： Created on 2019/4/10 10:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PointDeductionParam",description = "积分支出入参")
public class PointDeductionParam implements Serializable {

    @ApiModelProperty(value = "用户账号",example = "wangsong",required = true)
    @NotNull(message = "用户账号不能为空")
    private String account;

    @ApiModelProperty(value = "账单ID[数组]",example = "wangsong",required = true)
    @NotNull(message = "账单ID不能为空")
    private String[] billIds;


    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String[] getBillIds() {
        return billIds;
    }

    public void setBillIds(String[] billIds) {
        this.billIds = billIds;
    }

    @Override
    public String toString() {
        return "PointDeductionParam{" +
                "account='" + account + '\'' +
                ", billIds=" + Arrays.toString(billIds) +
                '}';
    }
}
