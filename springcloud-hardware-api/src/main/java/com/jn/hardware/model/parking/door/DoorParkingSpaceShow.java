package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/19 15:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorParkingSpaceShow",description = "停车场车位数量实体bean")
public class DoorParkingSpaceShow implements Serializable {
    private static final long serialVersionUID = 4480159283272554735L;
    @ApiModelProperty(value = "vip车位 (混合车位时,舍弃改值)")
    private String fixed;
    @ApiModelProperty(value = "临时车位 (混合车位时,舍弃改值)")
    private String temporary;
    @ApiModelProperty(value = "车位数合计(混合车位时使用)")
    private String total;

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getTemporary() {
        return temporary;
    }

    public void setTemporary(String temporary) {
        this.temporary = temporary;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DoorParkingSpaceAmountShow{" +
                "fixed='" + fixed + '\'' +
                ", temporary='" + temporary + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
