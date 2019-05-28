package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author： yangh
 * @date： Created on 2019/5/28 17:26
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TrendChartParam",description = "趋势图入参实体")
public class TrendChartParam implements Serializable {
    @ApiModelProperty(value = "开始日期" ,example = "2018-9-10")
    private Date dealDateStart;
    @ApiModelProperty(value = "结束日期",example = "2018-9-10")
    private Date dealDateEnd;
    @ApiModelProperty(value = "设备类型")
    private Byte type;
    @ApiModelProperty(value = "电表需求")
    private String meterName;
    @ApiModelProperty(value = "楼宇位置")
    private String position;

    public Date getDealDateStart() {
        return dealDateStart;
    }

    public void setDealDateStart(Date dealDateStart) {
        this.dealDateStart = dealDateStart;
    }

    public Date getDealDateEnd() {
        return dealDateEnd;
    }

    public void setDealDateEnd(Date dealDateEnd) {
        this.dealDateEnd = dealDateEnd;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
