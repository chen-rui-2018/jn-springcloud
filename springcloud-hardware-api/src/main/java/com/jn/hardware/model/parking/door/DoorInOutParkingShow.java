package com.jn.hardware.model.parking.door;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/5/13 19:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "DoorInOutParkingShow",description = "道尔:出入场数据存储成功后所返回的id列表")
public class DoorInOutParkingShow implements Serializable {

    private static final long serialVersionUID = -6445519824088459777L;
    @ApiModelProperty(value = "存储成功的id列表组成的字符串")
    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "DoorInOutParkingShow{" +
                "ids='" + ids + '\'' +
                '}';
    }
}
