package com.jn.pay.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Digits;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 线下核对提醒实体类
 *
 * @author： wzy
 * @date： Created on 2019/5/2 16:53
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayCheckReminder" ,description = "线下核对提醒实体类")
public class PayCheckReminder implements Serializable {
    private static final long serialVersionUID = 6589486251046038120L;

    @ApiModelProperty(value="缴费流水ID" ,example = "JF201905041212")
    @NotBlank(message = "{paymentId :'缴费流水ID不能为空'}")
    private String paymentId;

    @ApiModelProperty(value="账单编号",example = "JF201905041234")
    @NotBlank(message = "{billId :'账单编号不能为空'}")
    private String billId;

    @ApiModelProperty(value="企业名称",example = "某某科技集团")
    @NotBlank(message = "{enterpriseName:'企业名称不能为空'}")
    private String enterpriseName;

    @ApiModelProperty(value="银行账号",example = "62220329817353521")
    @NotBlank(message = "{bankAccount:'银行账号不能为空'}")
    private String bankAccount;

    @Digits(integer = 6, fraction = 2, message = "{paymentMoney:'请检查缴费金额格式'}")
    @ApiModelProperty(value="缴费金额",example = "123.00")
    private BigDecimal paymentMoney;

    @ApiModelProperty(value="缴费说明",example = "4月5号已线下缴费")
    private String paymentDesc;

    @ApiModelProperty(value="图片地址",example = "http://baidu.com")
    private String picturePath;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BigDecimal getPaymentMoney() {
        return paymentMoney;
    }

    public void setPaymentMoney(BigDecimal paymentMoney) {
        this.paymentMoney = paymentMoney;
    }

    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }
}
