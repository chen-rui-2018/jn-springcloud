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

    @ApiModelProperty(value = "是否展示管理列[PC]")
    private String isShowFlag;

    @ApiModelProperty(value = "分页数据")
    private PaginationData<List<StaffListVO>> paginationData;

    public String getIsShowFlag() {
        return isShowFlag;
    }

    public void setIsShowFlag(String isShowFlag) {
        this.isShowFlag = isShowFlag;
    }

    public PaginationData<List<StaffListVO>> getPaginationData() {
        return paginationData;
    }

    public void setPaginationData(PaginationData<List<StaffListVO>> paginationData) {
        this.paginationData = paginationData;
    }
}
