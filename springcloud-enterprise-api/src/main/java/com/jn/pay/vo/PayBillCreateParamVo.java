package com.jn.pay.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.pay.model.PayBillDetails;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 创建账单入參
 *
 * @author： wzy
 * @date： Created on 2019/5/9 20:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PayBillCreateParamVo" ,description = "创建账单入參实体类")
public class PayBillCreateParamVo implements Serializable {
    private static final long serialVersionUID = 9048434121544891874L;

    @ApiModelProperty(value="账单编号",example = "201905090000001")
    private String billId;

    @ApiModelProperty(value="账单名称",example = "电费账单")
    private String billName;

    @ApiModelProperty(value="账单来源",example = "来源办公室用电")
    private String billSource;

    @ApiModelProperty(value="账单费用",example = "123.00")
    private BigDecimal billExpense;

    @ApiModelProperty(value="对象类型【1：企业，2：个人】",example = "1")
    private String objType;

    @ApiModelProperty(value="对象Id（传企业ID或用户ID）",example = "wangsong")
    private String objId;

    @ApiModelProperty(value="对象名称（传企业名称或用户名称）",example = "XXX科技企业")
    private String objName;

    @ApiModelProperty(value="账本类型ID【1：电费，2：物业费】",example = "1")
    private String acBookType;

    @ApiModelProperty(value="回调ID",example = "springcloud-app-system")
    private String callbackId;

    @ApiModelProperty(value="回调URL",example = "/api/system/getUser")
    private String callbackUrl;

    @ApiModelProperty(value="创建时间",example = "2019-05-07 12:12:12")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value="创建人",example = "wangsong")
    private String creatorAccount;

    @ApiModelProperty(value="最迟缴费时间",example = "2019-05-09 12:12:12")
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date latePayment;

    @ApiModelProperty(value="缴费详情【存list对象集合】")
    List<PayBillDetails> payBillDetails;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillSource() {
        return billSource;
    }

    public void setBillSource(String billSource) {
        this.billSource = billSource;
    }

    public BigDecimal getBillExpense() {
        return billExpense;
    }

    public void setBillExpense(BigDecimal billExpense) {
        this.billExpense = billExpense;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getAcBookType() {
        return acBookType;
    }

    public void setAcBookType(String acBookType) {
        this.acBookType = acBookType;
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

    public Date getLatePayment() {
        return latePayment;
    }

    public void setLatePayment(Date latePayment) {
        this.latePayment = latePayment;
    }

    public List<PayBillDetails> getPayBillDetails() {
        return payBillDetails;
    }

    public void setPayBillDetails(List<PayBillDetails> payBillDetails) {
        this.payBillDetails = payBillDetails;
    }
}
