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
@ApiModel(value = "FinanceExpensesPageModel",description = "支出录入查询分页")
public class FinanceExpensesPageModel extends Page implements Serializable {

    private static final long serialVersionUID = -9026795813093175630L;

    @ApiModelProperty(value = "部门ID",example = "281f4005-0363-4528-92a3-60a730532e53")
    private String  departmentId;
    @ApiModelProperty(value = "数据月份-开始时间YYYYMM",example = "201901")
    private String  startTime;
    @ApiModelProperty(value = "数据月份-结束时间YYYYMM",example = "201912")
    private String  endTime;

    @ApiModelProperty(value = "金额" ,example = "35")
    private String  cost;
    @ApiModelProperty(value = "支出类型ID",example = "4")
    private String  costAfterTypeId;
    @ApiModelProperty(value = "操作日期-开始时间YYYYMM",example = "201901")
    private String  startMonth;
    @ApiModelProperty(value = "操作日期-结束时间YYYYMM",example = "201912")
    private String  endMonth;
    @ApiModelProperty(value = "排序字段 排序方式",example = "cost_happend_time desc")
    private String  orderByClause;

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

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

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCostAfterTypeId() {
        return costAfterTypeId;
    }

    public void setCostAfterTypeId(String costAfterTypeId) {
        this.costAfterTypeId = costAfterTypeId;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }



    @Override
    public String toString() {
        return "FinanceExpensesPageModel{" +
                "departmentId='" + departmentId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", cost='" + cost + '\'' +
                ", costAfterTypeId='" + costAfterTypeId + '\'' +
                ", startMonth='" + startMonth + '\'' +
                ", endMonth='" + endMonth + '\'' +
                '}';
    }
}
