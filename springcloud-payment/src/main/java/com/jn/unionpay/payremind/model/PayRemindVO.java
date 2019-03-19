package com.jn.unionpay.payremind.model;

import com.jn.paybill.model.PayBillVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;
import java.util.List;

/**
 * 账单核对单详情
 * @author： jiangyl
 * @date： Created on 2019/3/15 17:51
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayRemindVO", description = "账单核对单详情")
public class PayRemindVO implements Serializable {
    @ApiModelProperty(value = "审核项ID")
    private String remindId;
    @ApiModelProperty(value = "银行名")
    private String bankName;
    @ApiModelProperty(value = "银行账号")
    private String bankId;
    @ApiModelProperty(value = "银行户名")
    private String bankAccount;
    @ApiModelProperty(value = "支付金额")
    private Double payAmount;
    @ApiModelProperty(value = "缴费说明")
    private String payRemark;
    @ApiModelProperty(value = "支付凭证图片")
    private String payImg;
    @ApiModelProperty(value = "审核状态0未审核1审核通过2审核不通过")
    private String remindStatus;
    @ApiModelProperty(value = "审核备注")
    private String checkRemark;
    @ApiModelProperty(value = "账单列表")
    private List<PayBillVO> bills;

    public String getRemindId() {
        return remindId;
    }

    public void setRemindId(String remindId) {
        this.remindId = remindId;
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

    public String getRemindStatus() {
        return remindStatus;
    }

    public void setRemindStatus(String remindStatus) {
        this.remindStatus = remindStatus;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    public List<PayBillVO> getBills() {
        return bills;
    }

    public void setBills(List<PayBillVO> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "PayRemindVO{" +
                "remindId='" + remindId + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankId='" + bankId + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", payAmount=" + payAmount +
                ", payRemark='" + payRemark + '\'' +
                ", payImg='" + payImg + '\'' +
                ", remindStatus='" + remindStatus + '\'' +
                ", checkRemark='" + checkRemark + '\'' +
                ", bills=" + bills +
                '}';
    }
}