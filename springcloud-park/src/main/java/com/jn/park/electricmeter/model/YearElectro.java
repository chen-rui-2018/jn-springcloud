package com.jn.park.electricmeter.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "YearElectro",description = "今年用电情况的实体")
public class YearElectro {

    @ApiModelProperty("年")
    private String year;

    @ApiModelProperty("月")
    private String month;

    @ApiModelProperty("能耗")
    private String sumelectro;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSumelectro() {
        return sumelectro;
    }

    public void setSumelectro(String sumelectro) {
        this.sumelectro = sumelectro;
    }

    @Override
    public String toString() {
        return "YearElectro{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", sumelectro='" + sumelectro + '\'' +
                '}';
    }
}
