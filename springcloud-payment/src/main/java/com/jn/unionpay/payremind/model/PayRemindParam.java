package com.jn.unionpay.payremind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * 账单核对提醒
 * @author： jiangyl
 * @date： Created on 2019/3/15 17:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayRemindParam", description = "账单核对提醒")
public class PayRemindParam implements Serializable {
    @ApiModelProperty(value = "账单[数组]",required = true,example = "['48w55wwffno383912','48w55wwffno383913']")
    @NotBlank(message = "账单不能为空")
    private String[] billIds;
    @ApiModelProperty(value = "开户行名称",required = true,example = "中国农业银行")
    @NotBlank(message = "支付平台订单ID不能为空")
    private String bankName;
    @ApiModelProperty(value = "银行卡号",required = true,example = "6228481121140222555")
    private String bankId;
    @ApiModelProperty(value = "银行户名",required = true,example = "王松")
    private String bankAccount;
    @ApiModelProperty(value = "缴费金额",required = true,example = "20.00")
    @NotBlank(message = "缴费金额不能为空")
    private Double payAmount;
    @ApiModelProperty(value = "缴费说明",example = "通过线下转账缴费")
    private String payRemark;
    @NotBlank(message = "缴费图片不能为空")
    @ApiModelProperty(value = "缴费证明(图片链接)",required = true,example = "**/**/a.jpg")
    private String payImg;

    public String[] getBillIds() {
        return billIds;
    }

    public void setBillIds(String[] billIds) {
        this.billIds = billIds;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public String getPayImg() {
        return payImg;
    }

    public void setPayImg(String payImg) {
        this.payImg = payImg;
    }
}