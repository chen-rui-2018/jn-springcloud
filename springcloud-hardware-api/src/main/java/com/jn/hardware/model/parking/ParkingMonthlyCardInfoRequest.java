package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorParkingMonthlyCardParam;
import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 19:55
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingMonthlyCardInfoRequest",description = "月租卡信息查询入参实体")
public class ParkingMonthlyCardInfoRequest implements Serializable {
    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;

    /**
     * 道尔 月租卡信息查询入参实体
     */
    @ApiModelProperty(value = "道尔 查月租卡信息查询入参实体对象")
    private DoorParkingMonthlyCardParam doorParkingMonthlyCardParam;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorParkingMonthlyCardParam getDoorParkingMonthlyCardParam() {
        return doorParkingMonthlyCardParam;
    }

    public void setDoorParkingMonthlyCardParam(DoorParkingMonthlyCardParam doorParkingMonthlyCardParam) {
        this.doorParkingMonthlyCardParam = doorParkingMonthlyCardParam;
    }

    @Override
    public String toString() {
        return "ParkingMonthlyCardInfoRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorParkingMonthlyCardParam=" + doorParkingMonthlyCardParam +
                '}';
    }
}
