package com.jn.enterprise.data.vo;

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
@ApiModel(value="ReminderParam" ,description = "园区提醒人员查询" )
public class ReminderParam extends Page implements Serializable {

    @ApiModelProperty(value = "部门ID")
    private String departmentId;

    @ApiModelProperty(value = "部门名称")
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
