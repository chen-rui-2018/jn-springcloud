package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingCarLeaveParam",description = "车辆离场")
public class ParkingCarLeaveParam implements Serializable {

    @ApiModelProperty(value = "车牌号码",required = true,example = "湘A00001")
    @NotNull(message = "车牌号不能为空")
    private String carLicense;

    @ApiModelProperty(value = "停车场标识",required = true,example = "24518153811")
    @NotNull(message = "停车场标识不能为空")
    private String areaId;

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
