package com.jn.park.parking.vo;

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
@ApiModel(value = "ParkingCarLeaveVo",description = "车辆离场响应结果")
public class ParkingCarLeaveVo implements Serializable {

    @ApiModelProperty(value = "车牌号码",example = "湘A00001")
    private String carLicense;

    @ApiModelProperty(value = "停车场标识",example = "24518153811")
    private String areaId;

    @ApiModelProperty(value = "待支付金额",example = "0")
    private String waitPayAmount;

    @ApiModelProperty(value = "是否放行[0不放行1放行]",example = "1")
    private String isDischar;

    @ApiModelProperty(value = "是否为月租卡[0不是1是]",example = "1")
    private String isRental;

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

    public String getWaitPayAmount() {
        return waitPayAmount;
    }

    public void setWaitPayAmount(String waitPayAmount) {
        this.waitPayAmount = waitPayAmount;
    }

    public String getIsDischar() {
        return isDischar;
    }

    public void setIsDischar(String isDischar) {
        this.isDischar = isDischar;
    }

    public String getIsRental() {
        return isRental;
    }

    public void setIsRental(String isRental) {
        this.isRental = isRental;
    }
}
