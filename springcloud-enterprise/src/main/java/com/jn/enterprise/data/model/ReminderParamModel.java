package com.jn.enterprise.data.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author： yangh
 * @date： Created on 2019/4/8 15:07
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="ReminderParamModel" ,description = "园区提醒人员查询" )
public class ReminderParamModel extends Page implements Serializable {

    @ApiModelProperty(value = "部门ID",example = "0001")
    private String departmentId;

    @ApiModelProperty(value = "部门名称",example = "招商部")
    private String getDepartmentName;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getGetDepartmentName() {
        return getDepartmentName;
    }

    public void setGetDepartmentName(String getDepartmentName) {
        this.getDepartmentName = getDepartmentName;
    }
}
