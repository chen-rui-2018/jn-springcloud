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
@ApiModel(value = "DoorCarOutParkingParam",description = "道尔停车场的车辆入场信息参数实体")
public class DoorCarOutParkingParam implements Serializable {
    private static final long serialVersionUID = -2790193198828716737L;
    @ApiModelProperty(value = "道尔:入场信息列表")
   private String  caroutlist;
    @ApiModelProperty(value = "动态签名")
    private String  signature;
    @ApiModelProperty(value = "时间戳")
    private String  t;

    public String  getCaroutlist() {
        return caroutlist;
    }

    public void setCaroutlist(String caroutlist) {
        this.caroutlist = caroutlist;
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
        return "DoorCarOutParkingParam{" +
                "caroutlist=" + caroutlist +
                ", signature='" + signature + '\'' +
                ", t='" + t + '\'' +
                '}';
    }
}
