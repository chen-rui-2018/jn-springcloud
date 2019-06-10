package com.jn.park.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "GardenName",description = "园区管理-获取全部园区数据列表")
public class ParkName {

    @ApiModelProperty(value = "园区名")
    private String parkName;

    @ApiModelProperty(value = "园区ID")
    private String id;

    @ApiModelProperty(value = "园区图片（主要 一张）")
    private String mainPicture;


    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    @Override
    public String toString() {
        return "ParkName{" +
                "parkName='" + parkName + '\'' +
                ", id='" + id + '\'' +
                ", mainPicture='" + mainPicture + '\'' +
                '}';
    }
}