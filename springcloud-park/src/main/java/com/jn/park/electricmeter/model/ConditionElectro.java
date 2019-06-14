package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ConditionElectro",description = "用电情况的实体")
public class ConditionElectro {

    @ApiModelProperty("账期")
    private String data;

    @ApiModelProperty("小时")
    private String hours;

    @ApiModelProperty("能耗")
    private String sumelectro;


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getSumelectro() {
        return sumelectro;
    }

    public void setSumelectro(String sumelectro) {
        this.sumelectro = sumelectro;
    }

    @Override
    public String toString() {
        return "TodayElectro{" +
                "data='" + data + '\'' +
                ", hours='" + hours + '\'' +
                ", sumelectro='" + sumelectro + '\'' +
                '}';
    }

}
