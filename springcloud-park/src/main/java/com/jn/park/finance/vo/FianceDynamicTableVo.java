package com.jn.park.finance.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: tangry
 * @Date: 2019/3/21
 * @Version 1.0
 */
@ApiModel(value = "FianceDynamicTableVo",description = "动态表格包装VO")
public class FianceDynamicTableVo<T> implements Serializable {
    @ApiModelProperty("动态显示的表头LIST")
    private List<String>dynamicHeadList;
    @ApiModelProperty("表体内容")
    private T rows;

    public List<String> getDynamicHeadList() {
        return dynamicHeadList;
    }

    public void setDynamicHeadList(List<String> dynamicHeadList) {
        this.dynamicHeadList = dynamicHeadList;
    }

    public T getRows() {
        return rows;
    }

    public void setRows(T rows) {
        this.rows = rows;
    }


    @Override
    public String toString() {
        return "FianceDynamicTableVo{" +
                "dynamicHeadList=" + dynamicHeadList +
                ", rows=" + rows +
                '}';
    }
}
