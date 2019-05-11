package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 17:28
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorParkingMonthlyRentCardShow",description = "保存月租卡信息出参实体")
public class DoorParkingMonthlyRentCardShow implements Serializable {
    @ApiModelProperty(value = "车牌号")
    private String    carNo;
    @ApiModelProperty(value = "卡编号")
    private String    cardNo;
    @ApiModelProperty(value = "依据车牌号生成的卡id，唯一")
    private String    cardId;

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

    @Override
    public String toString() {
        return "DoorParkingMonthlyRentCardShow{" +
                "carNo='" + carNo + '\'' +
                ", cardNo='" + cardNo + '\'' +
                ", cardId='" + cardId + '\'' +
                '}';
    }
}
