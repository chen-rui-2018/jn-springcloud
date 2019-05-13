package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.awt.*;
import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 15:22
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorParkingSpaceAmountShow",description = "道尔:停车场停车位数量统计实体")
public class DoorParkingSpaceAmountShow implements Serializable {

     private static final long serialVersionUID = 7713761213180477734L;
     @ApiModelProperty(value = "停车场编号")
     private String parkId ;
     @ApiModelProperty(value = "车位总数")
     private DoorParkingSpaceShow total ;
     @ApiModelProperty(value = "剩余车位总数")
     private DoorParkingSpaceShow idle ;

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public DoorParkingSpaceShow getTotal() {
        return total;
    }

    public void setTotal(DoorParkingSpaceShow total) {
        this.total = total;
    }

    public DoorParkingSpaceShow getIdle() {
        return idle;
    }

    public void setIdle(DoorParkingSpaceShow idle) {
        this.idle = idle;
    }

    @Override
    public String toString() {
        return "DoorParkingSpaceAmountShow{" +
                "parkId='" + parkId + '\'' +
                ", total=" + total +
                ", idle=" + idle +
                '}';
    }
}
