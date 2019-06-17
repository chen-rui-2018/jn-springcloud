package com.jn.park.asset.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
* @author： zhuyz
* @date： Created on 2019/4/19 16:05
* @version： v1.0
* @modified By:
*/
@ApiModel(value = "TowerInformationModel",description = "楼宇信息")
public class TowerInformationModel implements Serializable {
    private static final long serialVersionUID = 8606256492421642414L;
    @ApiModelProperty(value = "主键",example = "568817802354360320")
    private String id;
    @ApiModelProperty(value = "所属园区id",example ="568531381404041216")
    private String parkId;
    @ApiModelProperty(value = "所属园区名称",example = "园区一")
    private String parkName;
    @ApiModelProperty(value = "楼宇名称",example = "1号楼")
    private String name;
    @ApiModelProperty(value = "实景图片",example = "[{\"fileName\":\"楼宇.png\",\"id\":\"568814300517367808\"}]")
    private String imgUrl;
    @ApiModelProperty(value = "楼宇地址",example = "南京市秦淮区白下智慧园区XX街1号")
    private String address;
    @ApiModelProperty(value = "详细介绍",example = "<p>南京市秦淮区白下智慧园区XX街1号</p>")
    private String introduce;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
