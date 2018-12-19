package com.jn.system.dept.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 根据层级关系返回部门信息实体
 *
 * @author： shaobao
 * @date： Created on 2018/11/12 16:34
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentVO", description = "根据层级关系返回部门信息实体")
public class SysDepartmentVO implements Serializable {
    private static final long serialVersionUID = 8857934360566700442L;

    @ApiModelProperty("部门id")
    private String value;
    @ApiModelProperty("部门名称")
    private String label;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("父级名称")
    private String parentName;
    @ApiModelProperty("子部门的集合")
    private List<SysDepartmentVO> children;

    public SysDepartmentVO() {
    }

    public SysDepartmentVO(String value, String label, String parentId, String parentName, List<SysDepartmentVO> children) {
        this.value = value;
        this.label = label;
        this.parentId = parentId;
        this.parentName = parentName;
        this.children = children;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<SysDepartmentVO> getChildren() {
        return children;
    }

    public void setChildren(List<SysDepartmentVO> children) {
        this.children = children;
    }


    @Override
    public String toString() {
        return "SysDepartmentVO{" +
                "value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", children=" + children +
                '}';
    }
}
