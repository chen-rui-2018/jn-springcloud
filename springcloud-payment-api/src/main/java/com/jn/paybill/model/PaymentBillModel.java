package com.jn.paybill.model;

import com.esotericsoftware.kryo.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费账单
 * @author： jiangyl
 * @date： Created on 2019/3/12 11:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PaymentBillModel", description = "缴费账单生成实体")
public class PaymentBillModel implements Serializable {
    @ApiModelProperty(value = "账单编号")
    @NotBlank(message = "账单编号不能为空")
    private String billNum;
    @ApiModelProperty(value = "账单名称")
    @NotBlank(message = "账单名称不能为空")
    private String billName;
    @ApiModelProperty(value = "账单类型")
    @NotBlank(message = "账单类型不能为空")
    private String billType;
    @ApiModelProperty(value = "账单对象类型[1企业2个人]")
    @NotBlank(message = "账单对象类型不能为空")
    @Pattern(regexp="^\\[12]$",message="{billObjType:'账单对象类型只允许为1/2'}")
    private String billObjType;
    @ApiModelProperty(value = "账单对象ID")
    @NotBlank(message = "账单对象ID不能为空")
    private String billObjId;
    @ApiModelProperty(value = "账单对象名")
    @NotBlank(message = "账单对象名不能为空")
    private String billObjName;
    @ApiModelProperty(value = "账单金额")
    @NotBlank(message = "账单金额不能为空")
    private Double billAmount;
    @ApiModelProperty(value = "账单生成时间[yyyy-MM-dd HH:mm:ss]")
    @NotBlank(message = "账单生成时间不能为空")
    private String billCreateTime;
    @ApiModelProperty(value = "最晚缴费时间[yyyy-MM-dd HH:mm:ss]")
    @NotBlank(message = "最晚缴费时间不能为空")
    private String payEndTime;
    @ApiModelProperty(value = "生成操作人")
    @NotBlank(message = "生成操作人不能为空")
    private String billCreateAccount;
    @ApiModelProperty(value = "账单说明")
    @NotBlank(message = "账单说明不能为空")
    private String billRemark;


    private static final long serialVersionUID = 1L;

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

    public String getBillObjType() {
        return billObjType;
    }

    public void setBillObjType(String billObjType) {
        this.billObjType = billObjType;
    }

    public String getBillObjId() {
        return billObjId;
    }

    public void setBillObjId(String billObjId) {
        this.billObjId = billObjId;
    }

    public String getBillObjName() {
        return billObjName;
    }

    public void setBillObjName(String billObjName) {
        this.billObjName = billObjName;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public String getBillCreateTime() {
        return billCreateTime;
    }

    public void setBillCreateTime(String billCreateTime) {
        this.billCreateTime = billCreateTime;
    }

    public String getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(String payEndTime) {
        this.payEndTime = payEndTime;
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

    @Override
    public String toString() {
        return "PaymentBillModel{" +
                "billNum='" + billNum + '\'' +
                ", billName='" + billName + '\'' +
                ", billType='" + billType + '\'' +
                ", billObjType='" + billObjType + '\'' +
                ", billObjId='" + billObjId + '\'' +
                ", billObjName='" + billObjName + '\'' +
                ", billAmount=" + billAmount +
                ", billCreateTime=" + billCreateTime +
                ", payEndTime=" + payEndTime +
                ", billCreateAccount='" + billCreateAccount + '\'' +
                ", billRemark='" + billRemark + '\'' +
                '}';
    }
}