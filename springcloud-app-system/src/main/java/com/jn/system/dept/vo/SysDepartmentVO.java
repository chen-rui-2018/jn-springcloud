package com.jn.system.dept.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private String id;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("部门id，用于前端解析id别名")
    private String value;
    @ApiModelProperty("部门名称，用于前端解析部门名称别名")
    private String label;
    @ApiModelProperty("父级id")
    private String parentId;
    @ApiModelProperty("父级名称")
    private String parentName;
    @ApiModelProperty("等级")
    private String level;
    @ApiModelProperty("创建时间")
    private Date createdTime;
    @ApiModelProperty("子部门的集合")
    private List<SysDepartmentVO> children;

    public SysDepartmentVO() {
    }

    public SysDepartmentVO(String id, String departmentName, String value, String label, String parentId,
                           String parentName, String level, Date createdTime, List<SysDepartmentVO> children) {
        this.id = id;
        this.departmentName = departmentName;
        this.value = value;
        this.label = label;
        this.parentId = parentId;
        this.parentName = parentName;
        this.level = level;
        this.createdTime = createdTime;
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public List<SysDepartmentVO> getChildren() {
        if (children != null && children.size() == 0){
            return null;
        }
        return children;
    }

    public void setChildren(List<SysDepartmentVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysDepartmentVO{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", value='" + value + '\'' +
                ", label='" + label + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", level='" + level + '\'' +
                ", createdTime=" + createdTime +
                ", children=" + children +
                '}';
    }
}
