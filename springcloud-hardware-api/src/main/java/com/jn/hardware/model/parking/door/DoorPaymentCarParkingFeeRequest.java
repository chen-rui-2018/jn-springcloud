package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 14:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorPaymentCarParkingFeeRequest",description = "道尔：下发预缴费到车场信息入参")
public class DoorPaymentCarParkingFeeRequest  implements Serializable {
    @ApiModelProperty(value = "停车场编号",required = true,example = "100010_0004")
    private String parkid;
    @ApiModelProperty(value = "车牌号码",required = true,example = "粤Z76760")
    private String carNo;
    @ApiModelProperty(value = "卡编号",example = "xxxx123")
    private String cardId;
    @ApiModelProperty(value = "卡号",example = "xxxx123")
    private String cardNo;
    @ApiModelProperty(value = "入场时间 格式 yyyy-MM-dd HH:mm:ss",required = true,example = "2019-04-03 15:45:36")
    private String entryTime;
    @ApiModelProperty(value = "缴费时间 格式 yyyy-MM-dd HH:mm:ss",required = true,example = "2019-04-03 15:45:36")
    private String payTime;
    @ApiModelProperty(value = "计费时长 单位：分钟",required = true,example = "100")
    private String chargeDuration;
    @ApiModelProperty(value = "应收金额 单位：元",required = true,example = "100")
    private String amount;
    @ApiModelProperty(value = "实收金额 单位：元",required = true,example = "100")
    private String purchaseAmount;
    @ApiModelProperty(value = "优惠金额 单位：元",required = true,example = "100")
    private String couponAmount;
    @ApiModelProperty(value = "支付方式 0:现金 1:微信 2:支付宝 3:银联闪付 4:交通卡",required = true,example = "1")
    private String paymentType;
    @ApiModelProperty(value = "支付流水号 注：全局唯一",required = true,example = "521375845641")
    private String paymentTnx;
    @ApiModelProperty(value = "付款记录生成用户",required = true,example = "wangsong")
    private String operator;
    @ApiModelProperty(value = "出入口编号 ，当缴费为出口扫码缴费时，请添加通道编号",example = "123131")
    private String channelId;

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getChargeDuration() {
        return chargeDuration;
    }

    public void setChargeDuration(String chargeDuration) {
        this.chargeDuration = chargeDuration;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public String getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(String couponAmount) {
        this.couponAmount = couponAmount;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "DoorPaymentCarParkingFeeRequest{" +
                "parkId='" + parkid + '\'' +
                ", carNo='" + carNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", payTime='" + payTime + '\'' +
                ", chargeDuration='" + chargeDuration + '\'' +
                ", amount='" + amount + '\'' +
                ", purchaseAmount='" + purchaseAmount + '\'' +
                ", couponAmount='" + couponAmount + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentTnx='" + paymentTnx + '\'' +
                ", operator='" + operator + '\'' +
                ", channelId='" + channelId + '\'' +
                '}';
    }
}
