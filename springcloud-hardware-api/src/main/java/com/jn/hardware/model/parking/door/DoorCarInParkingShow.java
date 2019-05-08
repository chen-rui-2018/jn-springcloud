package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/22 19:44
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorCarInParkingShow",description = "道尔停车场的车辆入场信息实体")
public class DoorCarInParkingShow implements Serializable {
    private static final long serialVersionUID = -8613370333661672554L;
    @ApiModelProperty(value = "入场车辆编号，全局唯一")
    private String id;
    @ApiModelProperty(value = "入口名称")
    private String entrance;
    @ApiModelProperty(value = "卡id")
    private String cardId;
    @ApiModelProperty(value = "卡编号")
    private String cardNo;
    @ApiModelProperty(value = "车牌号")
    private String carNo;
    @ApiModelProperty(value = "车主名")
    private String ownerName;
    @ApiModelProperty(value = "卡类型编号")
    private String cardTypeId;
    @ApiModelProperty(value = "卡类型名称")
    private String cardTypeName;
    @ApiModelProperty(value = "入场时间")
    private String entranceTime;
    @ApiModelProperty(value = "入场操作员")
    private String entranceUserName;
    @ApiModelProperty(value = "入场方式 0正常入场，1校正入场 ，2手工入场 3,扫码入场,4手持机入场")
    private String entranceWayId;
    @ApiModelProperty(value = "入场方式 名称")
    private String entranceWayName;
    @ApiModelProperty(value = "小车场 1 大车场")
    private String small;
    @ApiModelProperty(value = "入场图片路径")
    private String entryPic;
    @ApiModelProperty(value = "费用信息")
    List<DoorPaymentInfo> paymentInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
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

    public String getEntranceWayId() {
        return entranceWayId;
    }

    public void setEntranceWayId(String entranceWayId) {
        this.entranceWayId = entranceWayId;
    }

    public String getEntranceWayName() {
        return entranceWayName;
    }

    public void setEntranceWayName(String entranceWayName) {
        this.entranceWayName = entranceWayName;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getEntryPic() {
        return entryPic;
    }

    public void setEntryPic(String entryPic) {
        this.entryPic = entryPic;
    }

    public List<DoorPaymentInfo> getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(List<DoorPaymentInfo> paymentInfo) {
        this.paymentInfo = paymentInfo;
    }


    @Override
    public String toString() {
        return "DoorCarInParkingShow{" +
                "id='" + id + '\'' +
                ", entrance='" + entrance + '\'' +
                ", cardId='" + cardId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", carNo='" + carNo + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", entranceTime='" + entranceTime + '\'' +
                ", entranceUserName='" + entranceUserName + '\'' +
                ", entranceWayId='" + entranceWayId + '\'' +
                ", entranceWayName='" + entranceWayName + '\'' +
                ", small='" + small + '\'' +
                ", entryPic='" + entryPic + '\'' +
                ", paymentInfo=" + paymentInfo +
                '}';
    }
}
