package com.jn.hardware.model.electricmeter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2019/4/24 15:47
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ElectricMeterInfoShow",description = "仪表信息查询返回实体")
public class ElectricMeterInfoShow implements Serializable {

    private static final long serialVersionUID = 5416291448288621955L;
    @ApiModelProperty(value = "数据总条数")
    private String total;
    @ApiModelProperty(value = "数据总页数")
    private String pages;
    @ApiModelProperty(value = "仪表信息列表")
    private List<ElectricMeterInfo> data;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public List<ElectricMeterInfo> getData() {
        return data;
    }

    public void setData(List<ElectricMeterInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ElectricMeterInfoShow{" +
                "total='" + total + '\'' +
                ", pages='" + pages + '\'' +
                ", data=" + data +
                '}';
    }
}
