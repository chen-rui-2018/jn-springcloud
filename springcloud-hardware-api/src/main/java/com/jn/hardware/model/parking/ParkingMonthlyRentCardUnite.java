package com.jn.hardware.model.parking;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/13 10:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingMonthlyRentCardUnite",description = "智慧停车月租卡信息入参实体")
public class ParkingMonthlyRentCardUnite implements Serializable {

    private static final long serialVersionUID = 7371851645774297906L;
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;
    @ApiModelProperty(value = "停车场编号",required = true,example = "100010_0004")
    @NotBlank(message = "停车场编号不能为空")
    private String  areaId;
    @ApiModelProperty(value = "车牌号码",required = true,example = "粤Z76760")
    @NotBlank(message = "车牌号码不能为空")
    private String carLicense;
    @ApiModelProperty(value = "月租卡类型: 11，月租卡A；12，月租卡B；13，月租卡C；14，月租卡D",required = true,example = "11")
    @NotBlank(message = "月租卡类型不能为空")
    private String cardTypeId;
    @ApiModelProperty(value = "新开始有效时间 格式yyyy-MM-dd",required = true,example = "2019-04-18")
    @NotBlank(message = "新开始有效时间不能为空")
    private String startTime;
    @ApiModelProperty(value = "新结束有效时间 格式yyyy-MM-dd",required = true,example = "2020-04-18")
    @NotBlank(message = "新结束有效时间不能为空")
    private String endTime;
    @ApiModelProperty(value = "收费金额 格式0.00",required = true,example = "1000.00")
    @NotBlank(message = "收费金额不能为空")
    private String actualMoney;
    @ApiModelProperty(value = "支付类型 1 银联闪付 2 微信 3 支付宝",required = true,example = "1")
    @NotBlank(message = "支付类型不能为空")
    private String payType;
    @ApiModelProperty(value = "支付编号 唯一值",required = true,example = "23132311")
    @NotBlank(message = "支付编号不能为空")
    private String orderBillNum;
    @ApiModelProperty(value = "支付时间 格式：yyyy-MM-dd HH：mm：ss",required = true,example = "2019-04-16 12:12:12")
    @NotBlank(message = "支付时间不能为空")
    private String payDate;
    @ApiModelProperty(value = "月租用户姓名",required = true,example = "wangsong")
    @NotBlank(message = "月租用户姓名不能为空")
    private String account;
    @ApiModelProperty(value = "月租用户电话",required = true,example = "18899996666")
    @NotBlank(message = "月租用户电话不能为空")
    private String phone;
    @ApiModelProperty(value = "操作员姓名",example = "王老吉")
    private String operaterName;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(String actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getOrderBillNum() {
        return orderBillNum;
    }

    public void setOrderBillNum(String orderBillNum) {
        this.orderBillNum = orderBillNum;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOperaterName() {
        return operaterName;
    }

    public void setOperaterName(String operaterName) {
        this.operaterName = operaterName;
    }

    @Override
    public String toString() {
        return "ParkingMonthlyRentCardUnite{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", area_id_='" + areaId + '\'' +
                ", car_license='" + carLicense + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", actualMoney='" + actualMoney + '\'' +
                ", payType='" + payType + '\'' +
                ", paymentNumber='" + orderBillNum + '\'' +
                ", payDate='" + payDate + '\'' +
                ", account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", operaterName='" + operaterName + '\'' +
                '}';
    }
}
