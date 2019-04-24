package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/22 20:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorCarOutParkingShow",description = "道尔 停车场的车辆出场信息实体")
public class DoorCarOutParkingShow  implements Serializable {

    private static final long serialVersionUID = 1448481247582093420L;
    @ApiModelProperty(value = "停车时长 分钟")
    private String  parkTime;
    @ApiModelProperty(value = "出场编号")
    private String  id;
    @ApiModelProperty(value = "卡id")
    private String  cardId;
    @ApiModelProperty(value = "卡编号")
    private String  cardNo;
    @ApiModelProperty(value = "车牌号")
    private String  carNo;
    @ApiModelProperty(value = "车主名")
    private String  ownerName;
    @ApiModelProperty(value = "卡类型编号")
    private String  cardTypeId;
    @ApiModelProperty(value = "卡类型名称")
    private String  cardTypeName;
    @ApiModelProperty(value = "入场时间")
    private String  entranceTime;
    @ApiModelProperty(value = "入场操作员")
    private String  entranceUserName;
    @ApiModelProperty(value = "定点收费时间")
    private String  centralTime;
    @ApiModelProperty(value = "出场时间")
    private String  exportTime;
    @ApiModelProperty(value = "出场操作员")
    private String  exportUserName;
    @ApiModelProperty(value = "支付类型 0现金支付，1微信支付,2支付宝支付,3银联闪付，4交通卡支付，5自助缴费机,6，其它")
    private String  payType;
    @ApiModelProperty(value = "收费金额  元")
    private String  payCharge;
    @ApiModelProperty(value = "卡上金额 元")
    private String  balanceMoney;
    @ApiModelProperty(value = "打折机号")
    private String  discountNo;
    @ApiModelProperty(value = "打折时间")
    private String  discountTime;
    @ApiModelProperty(value = "折扣金额")
    private String  disAmount;
    @ApiModelProperty(value = "应收金额")
    private String  accountCharge;
    @ApiModelProperty(value = "是否出场（中央收费时为0，出场后更新为1）")
    private String  isOut;
    @ApiModelProperty(value = "异常原因（1车闸故障2卡遗失等等）")
    private String  unusualMemo;
    @ApiModelProperty(value = "免费金额")
    private String  freeAmount;
    @ApiModelProperty(value = "出口名称")
    private String  export;
    @ApiModelProperty(value = "入口名称")
    private String  entrance;
    @ApiModelProperty(value = "入场图片路径")
    private String  entrancePic;
    @ApiModelProperty(value = "出场图片路径")
    private String  exportPic;
    @ApiModelProperty(value = "停车费用信息")
    private List<DoorPaymentInfo> paymentInfo;

    public String getParkTime() {
        return parkTime;
    }

    public void setParkTime(String parkTime) {
        this.parkTime = parkTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCardTypeId() {
        return cardTypeId;
    }

    public void setCardTypeId(String cardTypeId) {
        this.cardTypeId = cardTypeId;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public String getEntranceUserName() {
        return entranceUserName;
    }

    public void setEntranceUserName(String entranceUserName) {
        this.entranceUserName = entranceUserName;
    }

    public String getCentralTime() {
        return centralTime;
    }

    public void setCentralTime(String centralTime) {
        this.centralTime = centralTime;
    }

    public String getExportTime() {
        return exportTime;
    }

    public void setExportTime(String exportTime) {
        this.exportTime = exportTime;
    }

    public String getExportUserName() {
        return exportUserName;
    }

    public void setExportUserName(String exportUserName) {
        this.exportUserName = exportUserName;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayCharge() {
        return payCharge;
    }

    public void setPayCharge(String payCharge) {
        this.payCharge = payCharge;
    }

    public String getBalanceMoney() {
        return balanceMoney;
    }

    public void setBalanceMoney(String balanceMoney) {
        this.balanceMoney = balanceMoney;
    }

    public String getDiscountNo() {
        return discountNo;
    }

    public void setDiscountNo(String discountNo) {
        this.discountNo = discountNo;
    }

    public String getDiscountTime() {
        return discountTime;
    }

    public void setDiscountTime(String discountTime) {
        this.discountTime = discountTime;
    }

    public String getDisAmount() {
        return disAmount;
    }

    public void setDisAmount(String disAmount) {
        this.disAmount = disAmount;
    }

    public String getAccountCharge() {
        return accountCharge;
    }

    public void setAccountCharge(String accountCharge) {
        this.accountCharge = accountCharge;
    }

    public String getIsOut() {
        return isOut;
    }

    public void setIsOut(String isOut) {
        this.isOut = isOut;
    }

    public String getUnusualMemo() {
        return unusualMemo;
    }

    public void setUnusualMemo(String unusualMemo) {
        this.unusualMemo = unusualMemo;
    }

    public String getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(String freeAmount) {
        this.freeAmount = freeAmount;
    }

    public String getExport() {
        return export;
    }

    public void setExport(String export) {
        this.export = export;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getEntrancePic() {
        return entrancePic;
    }

    public void setEntrancePic(String entrancePic) {
        this.entrancePic = entrancePic;
    }

    public String getExportPic() {
        return exportPic;
    }

    public void setExportPic(String exportPic) {
        this.exportPic = exportPic;
    }



    public List<DoorPaymentInfo> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<DoorPaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    @Override
    public String toString() {
        return "DoorCarOutParkingShow{" +
                "parkTime='" + parkTime + '\'' +
                ", id='" + id + '\'' +
                ", cardId='" + cardId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", carNo='" + carNo + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", entranceTime='" + entranceTime + '\'' +
                ", entranceUserName='" + entranceUserName + '\'' +
                ", centralTime='" + centralTime + '\'' +
                ", exportTime='" + exportTime + '\'' +
                ", exportUserName='" + exportUserName + '\'' +
                ", payType='" + payType + '\'' +
                ", payCharge='" + payCharge + '\'' +
                ", balanceMoney='" + balanceMoney + '\'' +
                ", discountNo='" + discountNo + '\'' +
                ", discountTime='" + discountTime + '\'' +
                ", disAmount='" + disAmount + '\'' +
                ", accountCharge='" + accountCharge + '\'' +
                ", isOut='" + isOut + '\'' +
                ", unusualMemo='" + unusualMemo + '\'' +
                ", freeAmount='" + freeAmount + '\'' +
                ", export='" + export + '\'' +
                ", entrance='" + entrance + '\'' +
                ", entrancePic='" + entrancePic + '\'' +
                ", exportPic='" + exportPic + '\'' +
                ", paymentInfo=" + paymentInfo +
                '}';
    }
}
