package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorCancelMonthlyRentAccountParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 14:19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "CancelMonthlyRentAccountRequest",description = "月租销户入参实体bean")
public class CancelMonthlyRentAccountRequest implements Serializable {

    private static final long serialVersionUID = -2667746612420612216L;
    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;

    /**
     * 道尔 月租销户入参实体bean入参对象
     */
    @ApiModelProperty(value = "道尔 月租销户入参实体bean入参对象")
    private DoorCancelMonthlyRentAccountParam doorCancelMonthlyRentAccountParam;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorCancelMonthlyRentAccountParam getDoorCancelMonthlyRentAccountParam() {
        return doorCancelMonthlyRentAccountParam;
    }

    public void setDoorCancelMonthlyRentAccountParam(DoorCancelMonthlyRentAccountParam doorCancelMonthlyRentAccountParam) {
        this.doorCancelMonthlyRentAccountParam = doorCancelMonthlyRentAccountParam;
    }

    @Override
    public String toString() {
        return "CancelMonthlyRentAccountRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorCancelMonthlyRentAccountParam=" + doorCancelMonthlyRentAccountParam +
                '}';
    }
}
