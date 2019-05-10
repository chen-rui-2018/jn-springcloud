package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 19:30
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorParkingMonthlyCardInfo" ,description = "获取月租卡信息出参实体")
public class DoorParkingMonthlyCardInfo implements Serializable {
    private static final long serialVersionUID = 1206801346580676170L;
    @ApiModelProperty(value = "车牌号码")
    private String carNo;
    @ApiModelProperty(value = "卡号")
    private String cardNo;
    @ApiModelProperty(value = "卡编号")
    private String cardId;
    @ApiModelProperty(value = "有效开始 格式 YYYY-MM-DD")
    private String startDate;
    @ApiModelProperty(value = "有效结束日期 格式 yyyy-MM-dd")
    private String endDate;
    @ApiModelProperty(value = "卡类型编号")
    private String cardTypeId;
    @ApiModelProperty(value = "卡类型名称")
    private String cardTypeName;
    @ApiModelProperty(value = "月租用户姓名")
    private String contactName;
    @ApiModelProperty(value = "月租用户电话")
    private String contactPhone;
    @ApiModelProperty(value = "最后操作时间 格式 YYYY-MM-DD")
    private String operationOn;
    @ApiModelProperty(value = "最后操作人姓名")
    private String operationBy;
    @ApiModelProperty(value = "返回状态，0正常、1正在挂失、2已挂失、3正在解挂、4已补卡、5挂失退款、6已销户")
    private String cardStatus;

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

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getOperationOn() {
        return operationOn;
    }

    public void setOperationOn(String operationOn) {
        this.operationOn = operationOn;
    }

    public String getOperationBy() {
        return operationBy;
    }

    public void setOperationBy(String operationBy) {
        this.operationBy = operationBy;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    @Override
    public String toString() {
        return "DoorParkingMonthlyCardInfo{" +
                "carNo='" + carNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", cardTypeId='" + cardTypeId + '\'' +
                ", cardTypeName='" + cardTypeName + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                ", operationOn='" + operationOn + '\'' +
                ", operationBy='" + operationBy + '\'' +
                ", cardStatus='" + cardStatus + '\'' +
                '}';
    }
}






