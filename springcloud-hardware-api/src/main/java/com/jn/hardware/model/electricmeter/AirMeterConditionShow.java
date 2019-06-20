package com.jn.hardware.model.electricmeter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/15 17:19
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "AirMeterConditionShow", description = "空调表数据收集实体")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AirMeterConditionShow implements Serializable {

    private static final long serialVersionUID = -3166166530726010510L;
    @ApiModelProperty(value = "空调表数据列表")
    private List<ElectricMeterAirConditionShow> data;
    @ApiModelProperty(value = "数据总页数")
    private String pages;
    @ApiModelProperty(value = "数据总条数")
    private String total;

    public List<ElectricMeterAirConditionShow> getData() {
        return data;
    }

    public void setData(List<ElectricMeterAirConditionShow> data) {
        this.data = data;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "AirMeterConditionShow{" +
                "data=" + data +
                ", pages='" + pages + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
