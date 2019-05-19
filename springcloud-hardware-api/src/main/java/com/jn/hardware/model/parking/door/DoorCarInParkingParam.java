package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/23 11:00
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorCarInParkingParam",description = "道尔停车场的车辆入场信息参数实体")
public class DoorCarInParkingParam  implements Serializable {

    private static final long serialVersionUID = -7894120790912162965L;
    @ApiModelProperty(value = "道尔:入场信息列表")
    private String carinlist;
    @ApiModelProperty(value = "动态签名")
    private String signature;
    @ApiModelProperty(value = "时间戳")
    private String  t;

    public String getCarinlist() {
        return carinlist;
    }

    public void setCarinlist(String carinlist) {
        this.carinlist = carinlist;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "DoorCarInParkingParam{" +
                "carinlist=" + carinlist +
                ", signature='" + signature + '\'' +
                ", t='" + t + '\'' +
                '}';
    }
}
