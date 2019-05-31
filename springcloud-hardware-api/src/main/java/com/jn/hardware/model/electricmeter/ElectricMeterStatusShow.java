package com.jn.hardware.model.electricmeter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 16:36
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterStatusShow",description = "仪表状态实体")
public class ElectricMeterStatusShow implements Serializable {

    private static final long serialVersionUID = -2420651368691521093L;
    @ApiModelProperty(value = "仪表状态,仪表开关状态  0-关闭；1-开启;''-没有这个仪表")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ElectricMeterStatusShow{" +
                "status='" + status + '\'' +
                '}';
    }
}
