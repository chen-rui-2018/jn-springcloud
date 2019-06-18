package com.jn.park.park.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


@ApiModel(value = "GardenDetailsVo", description = "根据ID获取对应园区详情")
public class ParkDetailsVo implements Serializable {
    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "园区名")
    private String parkName;

    @ApiModelProperty(value = "园区主要宣传图片")
    private String mainPicture;

    @ApiModelProperty(value = "园区介绍")
    private String parkIntroduce;

    @ApiModelProperty(value = "园区的发布状态")
    private String parkState;

    @ApiModelProperty(value = "园区企业入驻情况")
    private String isEnter;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "园区简短介绍（列表页显示）")
    private String shortIntroduce;


    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdTime;

    @ApiModelProperty(value = "园区次要宣传图片")
    private String minorPicture;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture) {
        this.mainPicture = mainPicture;
    }

    public String getParkIntroduce() {
        return parkIntroduce;
    }

    public void setParkIntroduce(String parkIntroduce) {
        this.parkIntroduce = parkIntroduce;
    }

    public String getParkState() {
        return parkState;
    }

    public void setParkState(String parkState) {
        this.parkState = parkState;
    }

    public String getIsEnter() {
        return isEnter;
    }

    public void setIsEnter(String isEnter) {
        this.isEnter = isEnter;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getMinorPicture() {
        return minorPicture;
    }

    public void setMinorPicture(String minorPicture) {
        this.minorPicture = minorPicture;
    }

    public String getShortIntroduce() {
        return shortIntroduce;
    }

    public void setShortIntroduce(String shortIntroduce) {
        this.shortIntroduce = shortIntroduce;
    }
}
