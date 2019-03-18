package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


/**支出录入查询分页
 * @author： tangry
 * @date： Created on 2019/3/9
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceExpendPageModel",description = "支出录入查询分页")
public class FinanceExpendPageModel extends Page implements Serializable {

    private static final long serialVersionUID = -9026795813093175630L;

    @ApiModelProperty(value = "部门ID")
    private String  departmentId;
    @ApiModelProperty(value = "开始时间YYYYMM")
    private String  startTime;
    @ApiModelProperty(value = "结束时间YYYYMM")
    private String  endTime;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
