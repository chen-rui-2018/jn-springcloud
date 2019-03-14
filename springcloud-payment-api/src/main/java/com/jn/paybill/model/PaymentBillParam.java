package com.jn.paybill.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author： jiangyl
 * @date： Created on 2019/3/12 10:54
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PaymentBillParam", description = "账单查询入参")
public class PaymentBillParam extends Page implements Serializable {
    @ApiModelProperty(value = "账单ID")
    private String billId;
    @ApiModelProperty(value = "账单编号")
    private String billNum;
    @ApiModelProperty(value = "账单名称")
    private String billName;
    @ApiModelProperty(value = "账单类型")
    private String billType;
    @ApiModelProperty(value = "账单对象ID")
    private String billObjId;
    @ApiModelProperty(value = "账单金额")
    private Double billAmount;
    @ApiModelProperty(value = "账单生成开始时间[yyyy-MM-dd HH:mm:ss]")
    private String billCreateTimeBegin;
    @ApiModelProperty(value = "账单生成结束时间[yyyy-MM-dd HH:mm:ss]")
    private String billCreateTimeEnd;
    @ApiModelProperty(value = "最晚缴费开始时间[yyyy-MM-dd HH:mm:ss]")
    private String payEndTimeBegin;
    @ApiModelProperty(value = "最晚缴费结束时间[yyyy-MM-dd HH:mm:ss]")
    private String payEndTimeEnd;
    @ApiModelProperty(value = "生成操作人")
    private String billCreateAccount;
    @ApiModelProperty(value = "账单说明")
    private String billRemark;
    @ApiModelProperty(value = "账单状态[0未审核1待支付2已支付待审核3确认支付]")
    private String billStatus;
    @ApiModelProperty(value = "是否已催付[0否1是]")
    private String isUrge;

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillObjId() {
        return billObjId;
    }

    public void setBillObjId(String billObjId) {
        this.billObjId = billObjId;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCreateTimeBegin() {
        return billCreateTimeBegin;
    }

    public void setBillCreateTimeBegin(String billCreateTimeBegin) {
        this.billCreateTimeBegin = billCreateTimeBegin;
    }

    public String getBillCreateTimeEnd() {
        return billCreateTimeEnd;
    }

    public void setBillCreateTimeEnd(String billCreateTimeEnd) {
        this.billCreateTimeEnd = billCreateTimeEnd;
    }

    public String getPayEndTimeBegin() {
        return payEndTimeBegin;
    }

    public void setPayEndTimeBegin(String payEndTimeBegin) {
        this.payEndTimeBegin = payEndTimeBegin;
    }

    public String getPayEndTimeEnd() {
        return payEndTimeEnd;
    }

    public void setPayEndTimeEnd(String payEndTimeEnd) {
        this.payEndTimeEnd = payEndTimeEnd;
    }

    public String getBillCreateAccount() {
        return billCreateAccount;
    }

    public void setBillCreateAccount(String billCreateAccount) {
        this.billCreateAccount = billCreateAccount;
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }

    public String getIsUrge() {
        return isUrge;
    }

    public void setIsUrge(String isUrge) {
        this.isUrge = isUrge;
    }
}
