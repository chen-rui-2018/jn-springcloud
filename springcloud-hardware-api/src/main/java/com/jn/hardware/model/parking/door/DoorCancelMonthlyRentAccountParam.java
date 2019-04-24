package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 14:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorCancelMonthlyRentAccountParam",description = "道尔:月租销户入参实体bean")
public class DoorCancelMonthlyRentAccountParam implements Serializable {
    private static final long serialVersionUID = -4022994872111479691L;
    @ApiModelProperty(value = "车场编号",required = true,example = "100010_0004")
    @NotBlank(message = "车场编号不能为空")
    private String parkid;

    @ApiModelProperty(value = "车牌号码",required = true,example = "粤Z76760")
    @NotBlank(message = "车牌号码不能为空")
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
        return "DoorCancelMonthlyRentlyAccountParam{" +
                "parkid='" + parkid + '\'' +
                ", carNo='" + carNo + '\'' +
                '}';
    }
}
