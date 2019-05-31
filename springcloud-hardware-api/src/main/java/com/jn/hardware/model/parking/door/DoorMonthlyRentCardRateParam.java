package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 11:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorMonthlyRentCardRateParam",description = " 道尔 月租信息获取(含费率)入参入参对象")
public class DoorMonthlyRentCardRateParam implements Serializable {
    private static final long serialVersionUID = 3565692786258140329L;
    @ApiModelProperty(value = "车场编号",required = true,example = "100010_0004")
    private String parkid;
    @ApiModelProperty(value = "车牌号码",required = true,example = "粤B7PU23")
    private String carNo;
    @ApiModelProperty(value = "卡编号",example = "100010_0004")
    private String cardId;
    @ApiModelProperty(value = "卡号",example = "100010_0004")
    private String cardNo;

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

    @Override
    public String toString() {
        return "DoorMonthlyRentCardRateparam{" +
                "parkid='" + parkid + '\'' +
                ", carNo='" + carNo + '\'' +
                ", cardId='" + cardId + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
