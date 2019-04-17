package com.jn.hardware.model.parking.door;

import java.io.Serializable;

/**
 * 道尔：
 *      临停预缴费信息(场内缴费)出参实体类
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:43
 * @Version： v1.0
 * @Modified By:
 */
public class DoorTemporaryCarParkingFeeResponse implements Serializable {
    private static final long serialVersionUID = 4239028722945707861L;
    /**
     * 车牌号码
     */
    private String carNo;
    /**
     * 卡编号
     */
    private String cardNo;
    /**
     * 卡号
     */
    private String cardId;
    /**
     * 车辆入场时间 格式 yyyy-MM-dd HH:mm:ss
     */
    private String entryTime;
    /**
     * 计费时间 格式 yyyy-MM-dd HH:mm:ss
     */
    private String chargeTime;
    /**
     * 0 临停缴费 1 超时缴费
     */
    private int paymentType;
    /**
     * 缴费时长 单位：分钟
     */
    private String chargeDuration;
    /**
     * 应收金额 单位：元
     */
    private float amount;
    /**
     * 优惠金额 单位：元
     */
    private float discountAmount;

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getChargeDuration() {
        return chargeDuration;
    }

    public void setChargeDuration(String chargeDuration) {
        this.chargeDuration = chargeDuration;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(float discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "DoorTemporaryCarParkingFeeResponse{" +
                "carNo='" + carNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", entryTime='" + entryTime + '\'' +
                ", chargeTime='" + chargeTime + '\'' +
                ", paymentType=" + paymentType +
                ", chargeDuration='" + chargeDuration + '\'' +
                ", amount=" + amount +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
