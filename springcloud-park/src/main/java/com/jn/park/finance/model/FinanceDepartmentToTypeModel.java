package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceDepartmentToTypeModel",description = "部门与财务类型关系")
public class FinanceDepartmentToTypeModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("关系ID")
    private Integer id;

    @NotNull(message = "财务ID不能为空")
    @ApiModelProperty("部门ID")
    private String departmentId;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @NotNull(message = "财务类型ID不能为空")
    @ApiModelProperty("财务类型")
    private String financeTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getFinanceTypeId() {
        return financeTypeId;
    }

    public void setFinanceTypeId(String financeTypeId) {
        this.financeTypeId = financeTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceDepartmentToTypeModel that = (FinanceDepartmentToTypeModel) o;
        return Objects.equals(departmentId, that.departmentId) &&
                Objects.equals(departmentName, that.departmentName) &&
                Objects.equals(financeTypeId, that.financeTypeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, financeTypeId);
    }

    @Override
    public String toString() {
        return "FinanceDepartmentToTypeModel{" +
                "id=" + id +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", financeTypeId=" + financeTypeId +
                '}';
    }
}