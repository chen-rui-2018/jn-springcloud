package com.jn.park.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "GardenGeneral",description = "园区管理—获取园区介绍")
public class ParkGeneral {

    @ApiModelProperty(value = "园区介绍")
    private String parkIntroduce;

    @ApiModelProperty("园区宣传图片（主要 一张）")
    private String mainPicture;

    @ApiModelProperty(value = "园区简短介绍（列表页显示）")
    private String shortIntroduce;

    @ApiModelProperty(value = "显示顺序（顺序排列）")
    private Integer showOrder;

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
        return "ParkGeneral{" +
                "parkIntroduce='" + parkIntroduce + '\'' +
                ", mainPicture='" + mainPicture + '\'' +
                ", shortIntroduce='" + shortIntroduce + '\'' +
                ", showOrder=" + showOrder +
                '}';
    }
}
