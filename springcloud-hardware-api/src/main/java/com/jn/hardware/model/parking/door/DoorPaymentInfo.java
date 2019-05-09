package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/22 19:35
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorPaymentInfo",description = "费用信息")
public class DoorPaymentInfo implements Serializable {

    private static final long serialVersionUID = -7419705251609474222L;
    @ApiModelProperty(value = "应收金额 单位：元")
    private String accountCharge;
    @ApiModelProperty(value = "实收金额 单位：元")
    private String payCharge;
    @ApiModelProperty(value = "折扣金额 单位：元")
    private String disAmount;
    @ApiModelProperty(value = " 支付方式--0，现金支付，1微信支付,2，支付宝支付,3,银联闪付，4，交通卡支付，5,自助缴费机,6，其它")
    private String  paymentType;
    @ApiModelProperty(value = " 交易编号 唯一值")
    private String  paymentTnx;
    @ApiModelProperty(value = "交易支付时间")
    private String  PayDate;

    public String getAccountCharge() {
        return accountCharge;
    }

    public void setAccountCharge(String accountCharge) {
        this.accountCharge = accountCharge;
    }

    public String getPayCharge() {
        return payCharge;
    }

    public void setPayCharge(String payCharge) {
        this.payCharge = payCharge;
    }

    public String getDisAmount() {
        return disAmount;
    }

    public void setDisAmount(String disAmount) {
        this.disAmount = disAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentTnx() {
        return paymentTnx;
    }

    public void setPaymentTnx(String paymentTnx) {
        this.paymentTnx = paymentTnx;
    }

    public String getPayDate() {
        return PayDate;
    }
    public void setPayDate(String payDate) {
        PayDate = payDate;
    }
    @Override
    public String toString() {
        return "DoorPaymentInfo{" +
                "accountCharge='" + accountCharge + '\'' +
                ", payCharge='" + payCharge + '\'' +
                ", disAmount='" + disAmount + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTnx='" + paymentTnx + '\'' +
                ", PayDate='" + PayDate + '\'' +
                '}';
    }

}
