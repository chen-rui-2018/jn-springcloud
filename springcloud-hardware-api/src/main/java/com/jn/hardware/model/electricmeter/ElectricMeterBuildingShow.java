package com.jn.hardware.model.electricmeter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 14:17
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterBuildingShow" ,description = "物业下建筑信息实体")
public class ElectricMeterBuildingShow implements Serializable {

    private static final long serialVersionUID = -7242006126959035088L;
    @ApiModelProperty(value = "建筑主键id")
    private String id;
    @ApiModelProperty(value = "建筑编码")
    private String code;
    @ApiModelProperty(value = "建筑名称")
    private String name;
    @ApiModelProperty(value = "区域编号")
    private String area;
    @ApiModelProperty(value = "省名称")
    private String provinceName;
    @ApiModelProperty(value = "市名称")
    private String cityName;
    @ApiModelProperty(value = "区名称")
    private String areaName;
    @ApiModelProperty(value = "地址")
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "ElectricMeterBuildingShow{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                ", provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
