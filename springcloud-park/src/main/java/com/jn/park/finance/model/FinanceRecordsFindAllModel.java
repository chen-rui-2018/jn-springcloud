package com.jn.park.finance.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**备案查询
 * @author： tangry
 * @date： Created on 2019/3/20
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceRecordsFindAllModel",description = "备案查询分页查询")
public class FinanceRecordsFindAllModel extends Page implements Serializable {


    private static final long serialVersionUID = -623711746996691788L;
    @ApiModelProperty(value = "录入状态 0：已录入；1：未录入")
    private String  createState;

    @ApiModelProperty(value = "财务状态 0：已确认；1：未确认")
    private String  financerSure;

    @ApiModelProperty(value = "部门ID",example="281f4005-0363-4528-92a3-60a730532e53")
    private String  departmentId;

    @ApiModelProperty(value = "录入人")
    private String creatorAccount;

    @ApiModelProperty(value = "资料名称")
    private String name;

    @ApiModelProperty(value = "排序字段 排序方式",example = "deadline DESC")
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

    public String getCreateState() {
        return createState;
    }

    public void setCreateState(String createState) {
        this.createState = createState;
    }

    public String getFinancerSure() {
        return financerSure;
    }

    public void setFinancerSure(String financerSure) {
        this.financerSure = financerSure;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "FinanceRecordsFindAllModel{" +
                "createState='" + createState + '\'' +
                ", financerSure='" + financerSure + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", name='" + name + '\'' +
                ", orderByClause='" + orderByClause + '\'' +
                '}';
    }
}
