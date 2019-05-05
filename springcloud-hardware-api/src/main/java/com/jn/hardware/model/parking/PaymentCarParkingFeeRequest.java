package com.jn.hardware.model.parking;

import com.jn.hardware.model.parking.door.DoorPaymentCarParkingFeeRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/18 14:20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "PaymentCarParkingFeeRequest",description = "停车缴费信息入库入参")
public class PaymentCarParkingFeeRequest implements Serializable {


    /**
     * 硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场
     */
    @ApiModelProperty(value = "硬件公司ID，取值ParkingCompanyEnum类，每家硬件厂商可能存在多个停车场",required = true)
    private String parkingCompanyId;

    /**
     * 道尔: 下发预缴费到车场信息
     */
    @ApiModelProperty(value = "道尔 下发(保存)预缴费到车场信息入参对象")
    private DoorPaymentCarParkingFeeRequest doorPaymentCarParkingFeeRequest;

    public String getParkingCompanyId() {
        return parkingCompanyId;
    }

    public void setParkingCompanyId(String parkingCompanyId) {
        this.parkingCompanyId = parkingCompanyId;
    }

    public DoorPaymentCarParkingFeeRequest getDoorPaymentCarParkingFeeRequest() {
        return doorPaymentCarParkingFeeRequest;
    }

    public void setDoorPaymentCarParkingFeeRequest(DoorPaymentCarParkingFeeRequest doorPaymentCarParkingFeeRequest) {
        doorPaymentCarParkingFeeRequest = doorPaymentCarParkingFeeRequest;
    }

    @Override
    public String toString() {
        return "PaymentCarParkingFeeRequest{" +
                "parkingCompanyId='" + parkingCompanyId + '\'' +
                ", doorPaymentCarParkingFeeRequest=" + doorPaymentCarParkingFeeRequest +
                '}';
    }
}
