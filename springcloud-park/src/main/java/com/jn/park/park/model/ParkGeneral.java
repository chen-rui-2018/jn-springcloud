package com.jn.park.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GardenGeneral",description = "园区管理—获取园区介绍")
public class ParkGeneral {

    @ApiModelProperty(value = "园区介绍")
    private String parkIntroduce;


    public String getParkIntroduce() {
        return parkIntroduce;
    }

    public void setParkIntroduce(String parkIntroduce) {
        this.parkIntroduce = parkIntroduce;
    }

    @Override
    public String toString() {
        return "ParkGeneral{" +
                "parkIntroduce='" + parkIntroduce + '\'' +
                '}';
    }
}
