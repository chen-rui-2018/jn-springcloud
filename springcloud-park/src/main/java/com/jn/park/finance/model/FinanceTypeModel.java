package com.jn.park.finance.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author： huangbq
 * @date： Created on 2019/3/4 15:38
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "FinanceTypeModel",description = "财务项目类型")
public class FinanceTypeModel implements Serializable {
    @ApiModelProperty("财务项目ID")
    private Integer id;

    @NotNull(message = "财务项目名称不能为空")
    @ApiModelProperty("财务项目名称")
    private String financeName;

    @ApiModelProperty("显示顺序（越小越靠前）")
    private Integer showOrder;

    @ApiModelProperty("是否公用（0否,1所有部门都适用）")
    private Byte isPublic;


    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public Byte getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Byte isPublic) {
        this.isPublic = isPublic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FinanceTypeModel that = (FinanceTypeModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(financeName, that.financeName) &&
                Objects.equals(showOrder, that.showOrder) &&
                Objects.equals(isPublic, that.isPublic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, financeName, showOrder, isPublic);
    }

    @Override
    public String toString() {
        return "FinanceTypeModel{" +
                "id=" + id +
                ", financeName='" + financeName + '\'' +
                ", showOrder=" + showOrder +
                ", isPublic=" + isPublic +
                '}';
    }
}