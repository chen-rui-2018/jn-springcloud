package com.jn.park.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GardenGeneral",description = "园区管理—获取园区介绍")
public class ParkGeneral {

    @ApiModelProperty(value = "园区介绍")
    private String parkIntroduce;

    @ApiModelProperty("园区宣传图片（主要 一张）")
    private String mainPicture;


    public String getParkIntroduce() {
        return parkIntroduce;
    }

    public void setParkIntroduce(String parkIntroduce) {
        this.parkIntroduce = parkIntroduce;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    @Override
    public String toString() {
        return "ParkGeneral{" +
                "parkIntroduce='" + parkIntroduce + '\'' +
                ", mainPicture='" + mainPicture + '\'' +
                '}';
    }
}
