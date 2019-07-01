package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/28 10:27
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SwitchModel",description = "电表开启和关闭的实体")
public class SwitchModel implements Serializable {
    @ApiModelProperty("开启/关闸规则Id")
    private String id;
    @ApiModelProperty("开启/关闸规则名称")
    private String turnName;
    @ApiModelProperty("开启/关闸规则余额")
    private String thresholds;
    @ApiModelProperty("开启/关闸规则内容")
    private String turnContent;
    @ApiModelProperty("触发企业")
    private String companyId;
    @ApiModelProperty("触发企业名称")
    private String companyName;
    @ApiModelProperty("企业的余额")
    private String balance;
    @ApiModelProperty("电表编码")
    private String meterCode;

    private String factoryCode;

    public String getFactoryCode() {
        return factoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        this.factoryCode = factoryCode;
    }

    public String getMeterCode() {
        return meterCode;
    }

    public void setMeterCode(String meterCode) {
        this.meterCode = meterCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTurnName() {
        return turnName;
    }

    public void setTurnName(String turnName) {
        this.turnName = turnName;
    }

    public String getThresholds() {
        return thresholds;
    }

    public void setThresholds(String thresholds) {
        this.thresholds = thresholds;
    }

    public String getTurnContent() {
        return turnContent;
    }

    public void setTurnContent(String turnContent) {
        this.turnContent = turnContent;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
