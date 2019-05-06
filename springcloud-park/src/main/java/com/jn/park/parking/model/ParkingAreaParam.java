package com.jn.park.parking.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingAreaParam",description = "停车场列表查询入参")
public class ParkingAreaParam extends Page implements Serializable {
    @ApiModelProperty(value = "停车场名字[模糊查询]",example = "F1栋停车场")
    private String areaName;

    @ApiModelProperty(value = "停车场地址[模糊查询]",example = "文轩路")
    private String areaAddress;

    @ApiModelProperty(value = "经度[排序条件][APP必传-当前经纬度]",example = "118.245616")
    private String longitude;

    @ApiModelProperty(value = "纬度[排序条件][APP必传-当前经纬度]",example = "45.548156")
    private String latitude;

    @ApiModelProperty(value = "是否需要分页 0不需要1需要",required = true,example = "1")
    private String needPage;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaAddress() {
        return areaAddress;
    }

    public void setAreaAddress(String areaAddress) {
        this.areaAddress = areaAddress;
    }

    public String getNeedPage() {
        return needPage;
    }

    public void setNeedPage(String needPage) {
        this.needPage = needPage;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
