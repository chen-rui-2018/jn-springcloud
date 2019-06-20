package com.jn.park.parking.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/22 14:06
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingCarInfoModel",description = "用户车辆信息")
public class ParkingCarInfoModel implements Serializable {
    @ApiModelProperty(value = "车牌号",required = true,example = "湘A00001")
    private String carLicense;

    @ApiModelProperty(value = "车主姓名[不传默认为注册用户姓名]",example = "张三丰")
    private String name;

    @ApiModelProperty(value = "联系方式[不传默认为注册用户电话]" ,example = "82uew3***")
    private String phone;

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
