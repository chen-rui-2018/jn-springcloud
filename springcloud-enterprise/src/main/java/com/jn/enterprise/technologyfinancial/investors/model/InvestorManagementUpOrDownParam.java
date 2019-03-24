package com.jn.enterprise.technologyfinancial.investors.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @Author: yangph
 * @Date: 2019/3/21 19:39
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "InvestorManagementUpOrDownParam", description = "科技金融管理投资人管理投资人上架/下架")
public class InvestorManagementUpOrDownParam implements Serializable {
    @ApiModelProperty(value = "投资人账号")
    private String investorAccount;
    @ApiModelProperty(value = "上/下架操作状态(0:下架  1：上架)")
    @Pattern(regexp = "^[01]$", message = "{needPage:'默认值只允许为0,1'}")
    private String operatingStatus;

    public String getInvestorAccount() {
        return investorAccount;
    }

    public void setInvestorAccount(String investorAccount) {
        this.investorAccount = investorAccount;
    }

    public String getOperatingStatus() {
        return operatingStatus;
    }

    public void setOperatingStatus(String operatingStatus) {
        this.operatingStatus = operatingStatus;
    }
}
