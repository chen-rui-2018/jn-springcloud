package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/13 14:41
 * @version： v1.0
 * @modified By:
 */

@ApiModel(value = "DoorCarInParkingInfo" ,description = "道尔: 入场信息推送,传入park-api实体")
public class DoorCarInParkingInfo implements Serializable {
    private static final long serialVersionUID = 8414099114074178951L;
    @ApiModelProperty(value = "道尔:入场信息列表")
    private List<DoorCarInParkingShow> carinlist;
    @ApiModelProperty(value = "停车场id")
    private String parkId;

    public List<DoorCarInParkingShow> getCarinlist() {
        return carinlist;
    }

    public void setCarinlist(List<DoorCarInParkingShow> carinlist) {
        this.carinlist = carinlist;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    @Override
    public String toString() {
        return "DoorCarInParkingInfo{" +
                "carinlist=" + carinlist +
                ", parkId='" + parkId + '\'' +
                '}';
    }
}
