package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 11:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorMonthlyRentalCardRenewalFeeParam",description = "道尔:月租卡续费入参实体")
public class DoorMonthlyRentalCardRenewalFeeParam implements Serializable {

    private static final long serialVersionUID = 3850731856223900631L;
    @ApiModelProperty(value = "停车场编号",required = true,example = "100010_0004")
    @NotBlank(message = "停车场编号不能为空")
    private String parkid;
    @ApiModelProperty(value = "车牌号码",required = true,example = "粤Z76760")
    @NotBlank(message = "车牌号码不能为空")
    private String carNo;
    @ApiModelProperty(value = "卡编号",example = "粤Z76760")
    private String cardId;
    @ApiModelProperty(value = "卡号",example = "粤Z76760")
    private String  cardNo;
    @ApiModelProperty(value = "月租卡类型: 11，月租卡A；12，月租卡B；13，月租卡C；14，月租卡D",required = true,example = "11")
    @NotBlank(message = "月租卡类型不能为空")
    private String cardTypeId;
    @ApiModelProperty(value = "新开始有效时间 格式yyyy-MM-dd",required = true,example = "2019-04-18")
    @NotBlank(message = "新开始有效时间不能为空")
    private String startDate;
    @ApiModelProperty(value = "新结束有效时间 格式yyyy-MM-dd",required = true,example = "2020-04-18")
    @NotBlank(message = "新结束有效时间不能为空")
    private String endDate;
    @ApiModelProperty(value = "收费金额 格式0.00",required = true,example = "1000.00")
    @NotBlank(message = "收费金额不能为空")
    private String amount;
    @ApiModelProperty(value = "支付类型0:现金 - 1:银联闪付 - 2:微信 - 3: 支付宝",required = true,example = "1")
    @NotBlank(message = "支付类型不能为空")
    private String payType;
    @ApiModelProperty(value = "支付编号 唯一值",required = true,example = "23132311")
    @NotBlank(message = "支付编号不能为空")
    private String paymentNumber;
    @ApiModelProperty(value = "支付时间 格式：yyyy-MM-dd HH：mm：ss",required = true,example = "2019-04-16 12:12:12")
    @NotBlank(message = "支付时间不能为空")
    private String payDate;

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

    public String getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "DoorMonthlyRentalCardRenewalFeeParam{" +
                "parkid='" + parkid + '\'' +
                ", carNo='" + carNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", amount='" + amount + '\'' +
                ", payType='" + payType + '\'' +
                ", paymentNumber='" + paymentNumber + '\'' +
                ", payDate='" + payDate + '\'' +
                '}';
    }
}
