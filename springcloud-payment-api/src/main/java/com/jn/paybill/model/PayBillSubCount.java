package com.jn.paybill.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 缴费统计小项
 * @author： jiangyl
 * @date： Created on 2019/3/13 10:36
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillSubCount", description = "缴费统计小项")
public class PayBillSubCount implements Serializable {

    @ApiModelProperty(value = "账单类型ID")
    private String billTypeId;
    @ApiModelProperty(value = "账单类型名称")
    private String billTypeName;
    @ApiModelProperty(value = "账单时间")
    private String billDate;
    @ApiModelProperty(value = "账单总金额[已支付+未支付]")
    private Double billTypeAmount;
    @ApiModelProperty(value = "账单未支付金额")
    private Double billTypeUnpayAmount;
    @ApiModelProperty(value = "账单已支付金额")
    private Double billTypePayAmount;

    public String getBillTypeId() {
        return billTypeId;
    }

    public void setBillTypeId(String billTypeId) {
        this.billTypeId = billTypeId;
    }

    public String getBillTypeName() {
        return billTypeName;
    }

    public void setBillTypeName(String billTypeName) {
        this.billTypeName = billTypeName;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public Double getBillTypeAmount() {
        return billTypeAmount;
    }

    public void setBillTypeAmount(Double billTypeAmount) {
        this.billTypeAmount = billTypeAmount;
    }

    public Double getBillTypeUnpayAmount() {
        return billTypeUnpayAmount;
    }

    public void setBillTypeUnpayAmount(Double billTypeUnpayAmount) {
        this.billTypeUnpayAmount = billTypeUnpayAmount;
    }

    public Double getBillTypePayAmount() {
        return billTypePayAmount;
    }

    public void setBillTypePayAmount(Double billTypePayAmount) {
        this.billTypePayAmount = billTypePayAmount;
    }
}
