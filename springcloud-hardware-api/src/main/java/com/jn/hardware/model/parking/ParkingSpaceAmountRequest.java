package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 15:29
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceAmountRequest",description = "停车场车位查询实体bean")
public class ParkingSpaceAmountRequest implements Serializable {

    private static final long serialVersionUID = -6838781808583991956L;
    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;

    /**
     * 道尔 停车场车位查询车场id
     */
    @ApiModelProperty(value = "道尔 停车场车位查询车场id")
    private String parkid;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public String getParkid() {
        return parkid;
    }

    @Override
    public String toString() {
        return "ParkingSpaceAmountRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", parkid='" + parkid + '\'' +
                '}';
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }
}
