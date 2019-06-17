package com.jn.enterprise.data.model;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/5/30 21:25
 * @version： v1.0
 * @modified By:
 */

public class InMoneyModel implements Serializable {
    /**
     * 年份
     */
    private String year;
    /**
     * 营业值
     */
    private Double value;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
