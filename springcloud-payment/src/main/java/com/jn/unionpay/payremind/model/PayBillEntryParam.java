package com.jn.unionpay.payremind.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费账单录入
 * @author： jiangyl
 * @date： Created on 2019/3/18 20:10
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillEntryParam", description = "缴费账单录入")
public class PayBillEntryParam implements Serializable {
    @ApiModelProperty(value = "账单编号",required = true,example = "TCJF-20190312558166")
    @NotBlank(message = "账单编号不能为空")
    private String billNum;
    @ApiModelProperty(value = "账单类型[从'查询账单类型数据'接口获取]"
            ,required = true,example = "isp",notes = "[从'查询账单类型数据'接口获取]")
    @NotBlank(message = "账单类型不能为空")
    private String billType;
    @ApiModelProperty(value = "账单名称",required = true,example = "湘AH2323-20190315停车费")
    @NotBlank(message = "账单名称不能为空")
    private String billName;
    @ApiModelProperty(value = "账单对象类型[1企业2个人]",required = true,example = "1")
    @NotBlank(message = "账单对象不能为空")
    @Pattern(regexp = "^[12]$", message = "{billObjType:'账单对象只能为1,2'}")
    private String billObjType;
    @ApiModelProperty(value = "账单对象ID",required = true,example = "wangsong")
    @NotBlank(message = "账单对象ID不能为空")
    private String billObjId;
    @ApiModelProperty(value = "账单对象名称",required = true,example = "王松")
    @NotBlank(message = "账单对象名称不能为空")
    private String billObjName;
    @ApiModelProperty(value = "账单金额",required = true,example = "10.00")
    @NotBlank(message = "账单金额不能为空")
    private Double billAmount;
    @ApiModelProperty(value = "最晚缴费时间 yyyy-MM-dd HH:mm:ss",required = true,example = "2019-03-25 10:00:00")
    @NotBlank(message = "最晚缴费时间不能为空")
    private String payEndTime;
    @ApiModelProperty(value = "缴费说明",required = true,example = "停车缴费")
    @NotBlank(message = "缴费说明不能为空")
    private String billRemark;

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
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

    public String getPayEndTime() {
        return payEndTime;
    }

    public void setPayEndTime(String payEndTime) {
        this.payEndTime = payEndTime;
    }

    public String getBillRemark() {
        return billRemark;
    }

    public void setBillRemark(String billRemark) {
        this.billRemark = billRemark;
    }
}
