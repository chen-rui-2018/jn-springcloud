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
    private String parkname;

    @ApiModelProperty(value = "园区主要宣传图片")
    private String mainpicture;

    @ApiModelProperty(value = "园区介绍")
    private String parkintroduce;

    @ApiModelProperty(value = "园区的发布状态")
    private String parkstate;

    @ApiModelProperty(value = "园区企业入驻情况")
    private String isenter;

    @ApiModelProperty(value = "创建者账号")
    private String creatoraccount;

    @ApiModelProperty(value = "创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createdtime;

    @ApiModelProperty(value = "园区次要宣传图片")
    private String minorpicture;


    public String getMinorpicture() {
        return minorpicture;
    }

    public void setMinorpicture(String minorpicture) {
        this.minorpicture = minorpicture;
    }

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

    public String getMainpicture() {
        return mainpicture;
    }

    public void setMainpicture(String mainpicture) {
        this.mainpicture = mainpicture;
    }

    public String getParkintroduce() {
        return parkintroduce;
    }

    public void setParkintroduce(String parkintroduce) {
        this.parkintroduce = parkintroduce;
    }

    public String getParkstate() {
        return parkstate;
    }

    public void setParkstate(String parkstate) {
        this.parkstate = parkstate;
    }

    public String getIsenter() {
        return isenter;
    }

    public void setIsenter(String isenter) {
        this.isenter = isenter;
    }

    public String getCreatoraccount() {
        return creatoraccount;
    }

    public void setCreatoraccount(String creatoraccount) {
        this.creatoraccount = creatoraccount;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }



    @Override
    public String toString() {
        return "GardenDetailsVo{" +
                "id='" + id + '\'' +
                ", parkname='" + parkname + '\'' +
                ", mainpicture='" + mainpicture + '\'' +
                ", parkintroduce='" + parkintroduce + '\'' +
                ", parkstate='" + parkstate + '\'' +
                ", isenter='" + isenter + '\'' +
                ", creatoraccount='" + creatoraccount + '\'' +
                ", createdtime=" + createdtime +
                ", minorpicture='" + minorpicture + '\'' +
                '}';
    }
}
