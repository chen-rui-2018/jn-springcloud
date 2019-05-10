package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorParkingMonthlyRentCardParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 16:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingMonthlyRentCardRequest",description = "停车月租卡办理入参")
public class ParkingMonthlyRentCardRequest  implements Serializable {
    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;
    @ApiModelProperty(value = "道尔: 停车场月租卡办理入参")
    private DoorParkingMonthlyRentCardParam doorParkingMonthlyRentCardParam;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorParkingMonthlyRentCardParam getDoorParkingMonthlyRentCardParam() {
        return doorParkingMonthlyRentCardParam;
    }

    public void setDoorParkingMonthlyRentCardParam(DoorParkingMonthlyRentCardParam doorParkingMonthlyRentCardParam) {
        this.doorParkingMonthlyRentCardParam = doorParkingMonthlyRentCardParam;
    }

    @Override
    public String toString() {
        return "ParkingMonthlyRentCardRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorParkingMonthlyRentCardParam=" + doorParkingMonthlyRentCardParam +
                '}';
    }
}
