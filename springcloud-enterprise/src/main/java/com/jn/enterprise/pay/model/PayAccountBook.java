package com.jn.enterprise.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账本表（实体类）
 *
 * @author： wzy
 * @date： Created on 2019/5/5 14:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBook" ,description = "账本实体类")
public class PayAccountBook extends Page implements Serializable {
    private static final long serialVersionUID = -8404234392448710481L;

    @ApiModelProperty(value="账本ID")
    private String acBookId;

    @ApiModelProperty(value="账号ID")
    private String accountId;

    @ApiModelProperty(value="账本名称")
    private String acBookName;

    @ApiModelProperty(value="账本类型ID（如电费，房租）")
    private String acBookType;

    @ApiModelProperty(value="余额")
    private BigDecimal balance;

    @ApiModelProperty(value="是否开通自动扣款（0：不开通，1：开通）")
    private String automaticDeductions;

    @ApiModelProperty(value="是否可充值（0：不可充值，1：可充值）")
    private String canRecharge;

    @ApiModelProperty(value="创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="创建人")
    private String creatorAccount;

    @ApiModelProperty(value="修改时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value="修改人")
    private String modifierAccount;

    @ApiModelProperty(value="记录状态   0标记删除，1正常")
    private String recordStatus;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAcBookName() {
        return acBookName;
    }

    public void setAcBookName(String acBookName) {
        this.acBookName = acBookName;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAutomaticDeductions() {
        return automaticDeductions;
    }

    public void setAutomaticDeductions(String automaticDeductions) {
        this.automaticDeductions = automaticDeductions;
    }

    public String getCanRecharge() {
        return canRecharge;
    }

    public void setCanRecharge(String canRecharge) {
        this.canRecharge = canRecharge;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }
}
