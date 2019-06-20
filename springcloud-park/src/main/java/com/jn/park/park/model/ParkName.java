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

    @ApiModelProperty(value = "园区简短介绍（列表页显示）")
    private String shortIntroduce;

    @ApiModelProperty(value = "显示顺序（顺序排列）")
    private Integer showOrder;


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

    public String getShortIntroduce() {
        return shortIntroduce;
    }

    public void setShortIntroduce(String shortIntroduce) {
        this.shortIntroduce = shortIntroduce;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    @Override
    public String toString() {
        return "ParkName{" +
                "parkName='" + parkName + '\'' +
                ", id='" + id + '\'' +
                ", mainPicture='" + mainPicture + '\'' +
                ", shortIntroduce='" + shortIntroduce + '\'' +
                ", showOrder=" + showOrder +
                '}';
    }
}