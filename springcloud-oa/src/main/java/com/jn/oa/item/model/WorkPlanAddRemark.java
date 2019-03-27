package com.jn.oa.item.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 工作计划添加备注实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 16:50
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanAddRemark", description = "工作计划添加备注实体")
public class WorkPlanAddRemark implements Serializable {
    private static final long serialVersionUID = -2004038545138489335L;

    @ApiModelProperty(value = "工作计划id", required = true, example = "\"10000\"")
    @NotNull(message = "工作计划id不能为空")
    private String id;

    @ApiModelProperty(value = "备注", required = true, example = "备注信息添加测试")
    @NotNull(message = "备注不能为空")
    private String remark;

    public WorkPlanAddRemark() {
    }

    public WorkPlanAddRemark(String id, String remark) {
        this.id = id;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WorkPlanAddRemark{" +
                "id='" + id + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
