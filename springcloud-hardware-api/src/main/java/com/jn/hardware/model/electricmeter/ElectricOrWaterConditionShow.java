package com.jn.hardware.model.electricmeter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/5/15 17:24
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value ="ElectricOrWaterConditionShow",description = "电表或水表返回实体")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElectricOrWaterConditionShow implements Serializable {

    private static final long serialVersionUID = -6051443913557870616L;
    @ApiModelProperty(value = "电表或水表数据列表")
    private List<ElectricMeterWaterOrElectricShow>  data;
    @ApiModelProperty(value = "数据总页数")
    private String pages;
    @ApiModelProperty(value = "数据总条数")
    private String total;

    public List<ElectricMeterWaterOrElectricShow> getData() {
        return data;
    }

    public void setData(List<ElectricMeterWaterOrElectricShow> data) {
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
        return "ElectricOrWaterConditionShow{" +
                "data=" + data +
                ", pages='" + pages + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}

