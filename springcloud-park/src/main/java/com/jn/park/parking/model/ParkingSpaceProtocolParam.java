package com.jn.park.parking.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 停车位列表查询入参
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingSpaceProtocolParam",description = "停车位租聘协议入参")
public class ParkingSpaceProtocolParam implements Serializable {
    @ApiModelProperty(value = "停车场ID", example = "24518153811")
    private String areaId;

    @ApiModelProperty(value = "车主名称", example = "wangsong")
    private String name;


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "ParkingSpaceProtocolParam{" +
                "areaId='" + areaId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
