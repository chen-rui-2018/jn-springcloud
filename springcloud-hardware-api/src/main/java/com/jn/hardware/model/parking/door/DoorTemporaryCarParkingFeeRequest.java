package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 道尔：
 *      临停预缴费信息(场内缴费)入参
 *
 * @Author： cm
 * @Date： Created on 2019/4/17 16:14
 * @Version： v1.0
 * @Modified By:
 */
@ApiModel(value = "DoorTemporaryCarParkingFeeRequest",description = "道尔：临停预缴费信息(场内缴费)入参")
public class DoorTemporaryCarParkingFeeRequest implements Serializable {
    private static final long serialVersionUID = 4821707076234957782L;

    /**
     * 车场编号
     */
    @ApiModelProperty(value = "车场编号",required = true,example = "100010_0004")
    private String parkid;
    /**
     * 车牌号码
     */
    @ApiModelProperty(value = "车牌号码",required = true,example = "粤Z76760")
    private String carNo;

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

    @Override
    public String toString() {
        return "DoorTemporaryCarParkingFeeRequest{" +
                "parkid='" + parkid + '\'' +
                ", carNo='" + carNo + '\'' +
                '}';
    }
}
