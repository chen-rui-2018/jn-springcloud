package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorTemporaryCarParkingFeeRequest;

import java.io.Serializable;

/**
 * TODO：未添加类描述
 *
 * @Author： cm
 * @Date： Created on 2019/4/18 9:20
 * @Version： v1.0
 * @Modified By:
 */
public class TemporaryCarParkingFeeRequest implements Serializable {
    private static final long serialVersionUID = 4156816275095794240L;

    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，没家硬件厂商可能存在多个停车场
     */
    private String parkingCompanyId;

    /**
     * 道尔 查询临停预缴费信息(场内缴费)入参对象
     */
    private DoorTemporaryCarParkingFeeRequest doorTemporaryCarParkingFeeRequest;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorTemporaryCarParkingFeeRequest getDoorTemporaryCarParkingFeeRequest() {
        return doorTemporaryCarParkingFeeRequest;
    }

    public void setDoorTemporaryCarParkingFeeRequest(DoorTemporaryCarParkingFeeRequest doorTemporaryCarParkingFeeRequest) {
        this.doorTemporaryCarParkingFeeRequest = doorTemporaryCarParkingFeeRequest;
    }

    @Override
    public String toString() {
        return "TemporaryCarParkingFeeRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorTemporaryCarParkingFeeRequest=" + doorTemporaryCarParkingFeeRequest +
                '}';
    }
}
