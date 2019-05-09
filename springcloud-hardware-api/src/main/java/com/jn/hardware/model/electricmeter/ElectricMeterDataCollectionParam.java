package com.jn.hardware.model.electricmeter;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 20:50
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterDataCollectionParam",description = "仪表数据采集入参实体")
public class ElectricMeterDataCollectionParam extends Page implements Serializable {

    private static final long serialVersionUID = -1956269167041339803L;
    @ApiModelProperty(value = "仪表编码，如果该参数存在deviceType不生效，否则deviceType必传")
    private String code;
    @ApiModelProperty(value = "仪表类型,1:电表--2:水表--3:空调表",required = true,example = "1")
    private String deviceType;
    @ApiModelProperty(value = "String字符串”yyyy-MM-dd HH:mm:ss”，查询该时间之后1小时的数据",required = true ,example = "2019-04-16")
    private String startTime;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "ElectricMeterDataCollectionParam{" +
                "code='" + code + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
