package com.jn.enterprise.company.vo;

import com.jn.common.model.PaginationData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 同事列表出参
 * @author： huxw
 * @date： Created on 2019-5-21 09:18:25
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "ColleagueListVO",description = "同事列表出参")
public class ColleagueListVO implements Serializable {

    @ApiModelProperty(value = "是否展示管理列（1：显示 0：隐藏）[PC]")
    private String isShow;

    @ApiModelProperty(value = "分页数据")
    private PaginationData<List<StaffListVO>> data;

    public String getIsShow() {
        return isShow;
    }

    public void setIsShow(String isShow) {
        this.isShow = isShow;
    }

    public PaginationData<List<StaffListVO>> getData() {
        return data;
    }

    public void setData(PaginationData<List<StaffListVO>> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ColleagueListVO{" +
                "isShow='" + isShow + '\'' +
                ", data=" + data +
                '}';
    }
}
