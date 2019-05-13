package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/13 14:45
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorCarOutParkingInfo", description = "道尔: 出场信息列表,传入park-api实体")
public class DoorCarOutParkingInfo implements Serializable {

    private static final long serialVersionUID = 7099791386925641499L;
    @ApiModelProperty(value = "道尔:出场信息列表")
    List<DoorCarOutParkingShow> caroutlist;
    @ApiModelProperty(value = "停车场id")
    private String parkId;

    public List<DoorCarOutParkingShow> getCaroutlist() {
        return caroutlist;
    }

    public void setCaroutlist(List<DoorCarOutParkingShow> caroutlist) {
        this.caroutlist = caroutlist;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    @Override
    public String toString() {
        return "DoorCarOutParkingInfo{" +
                "caroutlist=" + caroutlist +
                ", parkId='" + parkId + '\'' +
                '}';
    }
}
