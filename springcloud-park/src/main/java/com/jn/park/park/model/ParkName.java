package com.jn.park.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "GardenName",description = "园区管理-获取全部园区数据列表")
public class ParkName {

    @ApiModelProperty(value = "园区名")
    private String parkname;

    @ApiModelProperty(value = "园区ID")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }


}