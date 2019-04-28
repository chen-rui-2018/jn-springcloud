package com.jn.hardware.model.electricmeter;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 15:17
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterInfo",description = "仪表基本信息")
public class ElectricMeterInfo implements Serializable {

    private static final long serialVersionUID = 1140692325686591310L;
    @ApiModelProperty(value = "仪表主键id")
    private String id;
    @ApiModelProperty(value = "仪表编号")
    private String code;
    @ApiModelProperty(value = "仪表名称")
    private String name;
    @ApiModelProperty(value = "仪表类型编号")
    private String deviceType;
    @ApiModelProperty(value = "仪表类型名称")
    private String deviceTypeName;

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

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @Override
    public String toString() {
        return "ElectricMeterInfo{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                '}';
    }
}
