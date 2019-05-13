package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账单明细记录实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/6 17:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayAccountBookMoneyRecord" ,description = "账单明细记录实体类")
public class PayAccountBookMoneyRecord extends Page implements Serializable {
    private static final long serialVersionUID = -9188211298326552354L;

    @ApiModelProperty(value="日志流水ID")
    private String deductionId;

    @ApiModelProperty(value="账单编号")
    private String billId;

    @ApiModelProperty(value="账本ID",example = "20190504123")
    @NotEmpty(message = "{acBookId :'账本ID不能为空'}")
    private String acBookId;

    @ApiModelProperty(value="备注说明")
    private String remark;

    @ApiModelProperty(value="付款方式（1:钱包 2::微信  3:支付宝  4:银行卡 ）")
    private String paymentMethod;

    @ApiModelProperty(value="支付行为（1:手动支付，2:自动付款）")
    private String paymentAction;

    @ApiModelProperty(value="交易性质编码")
    private String natureCode;

    @ApiModelProperty(value="金额")
    private BigDecimal money;

    @ApiModelProperty(value="当前余额")
    private BigDecimal balance;

    @ApiModelProperty(value="创建时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="创建人")
    private String creatorAccount;

    @ApiModelProperty(value="记录状态   0标记删除，1正常")
    private String recordStatus;

    @ApiModelProperty(value="更新时间")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    @ApiModelProperty(value="更新账号")
    private String modifierAccount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDeductionId() {
        return deductionId;
    }

    public void setDeductionId(String deductionId) {
        this.deductionId = deductionId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getAcBookId() {
        return acBookId;
    }

    public void setAcBookId(String acBookId) {
        this.acBookId = acBookId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentAction() {
        return paymentAction;
    }

    public void setPaymentAction(String paymentAction) {
        this.paymentAction = paymentAction;
    }

    public String getNatureCode() {
        return natureCode;
    }

    public void setNatureCode(String natureCode) {
        this.natureCode = natureCode;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
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

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
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
}
