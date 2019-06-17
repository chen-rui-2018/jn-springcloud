package com.jn.park.parking.model;

import com.jn.park.fileimg.model.FileImg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingViolationModel",description = "违停上报")
public class ParkingViolationModel implements Serializable {
    @ApiModelProperty(value = "车牌号",required = true,example = "苏A00001")
    @NotNull(message = "车牌号不能为空")
    private String carLicense;

    @ApiModelProperty(value = "预留手机号",example = "18155558888")
    private String carPhone;

    @ApiModelProperty(value = "违停地址",example = "南京市白下高新区金融中心裙楼")
    private String parkingAddress;

    @ApiModelProperty(value = "违停图片", required = true)
    private List<FileImg> fileImages;

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getCarPhone() {
        return carPhone;
    }

    public void setCarPhone(String carPhone) {
        this.carPhone = carPhone;
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public List<FileImg> getFileImages() {
        return fileImages;
    }

    public void setFileImages(List<FileImg> fileImages) {
        this.fileImages = fileImages;
    }
}
