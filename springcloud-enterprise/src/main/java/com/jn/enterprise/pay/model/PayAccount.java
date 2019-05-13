package com.jn.enterprise.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户表（实体类）
 *
 * @author： wzy
 * @date： Created on 2019/5/5 14:04
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccount" ,description = "账户实体类")
public class PayAccount extends Page implements Serializable {
    private static final long serialVersionUID = -1777686413161140271L;

    @ApiModelProperty(value="用户ID")
    private String accountId;

    @ApiModelProperty(value="账户ID")
    private String userId;

    @ApiModelProperty(value="支付密码")
    private String passwd;

    @ApiModelProperty(value="余额")
    private BigDecimal balance;

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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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
