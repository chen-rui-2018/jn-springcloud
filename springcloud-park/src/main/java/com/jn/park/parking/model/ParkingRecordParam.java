package com.jn.park.parking.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/19 9:31
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingRecordParam",description = "停车记录查询入参")
public class ParkingRecordParam extends Page implements Serializable {

    @ApiModelProperty(value = "车牌号码",required = true,example = "湘A00001")
    private String carLicense;

    @ApiModelProperty(value = "开始时间yyyy-MM-dd",example = "2019-04-10")
    private String startTime;

    @ApiModelProperty(value = "结束时间yyyy-MM-dd",example = "2019-05-10")
    private String endTime;

    public String getCarLicense() {
        return carLicense;
    }

    public void setCarLicense(String carLicense) {
        this.carLicense = carLicense;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
