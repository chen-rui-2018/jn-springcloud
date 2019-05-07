package com.jn.park.parking.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： jiangyl
 * @date： Created on 2019/4/18 17:37
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ParkingServiceTypeVo",description = "停车场服务")
public class ParkingServiceTypeVo implements Serializable {

    @ApiModelProperty(value = "车场服务ID",example = "e2ew3***")
    private String id;

    @ApiModelProperty(value = "车场服务名称",example = "充电桩")
    private String serviceName;

    @ApiModelProperty(value = "车场服务编码",example = "charging_pile")
    private String serviceCode;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
