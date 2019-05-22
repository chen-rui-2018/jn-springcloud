package com.jn.hr.archives.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author dt
 * @create 2019-04-17 上午 9:24
 */
@ApiModel(value = "EmployeeFileClass", description = "员工档案分类实体")
public class EmployeeFileClass {
    @ApiModelProperty(value = "分类ID")
    private String classId;
    @ApiModelProperty(value = "父类ID")
    private String parentId;
    @ApiModelProperty(value = "分类名称")
    private String nodeName;
    @ApiModelProperty(value = "层级")
    private String level;

    private List<EmployeeFileClass> children;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<EmployeeFileClass> getChildren() {
        return children;
    }

    public void setChildren(List<EmployeeFileClass> children) {
        this.children = children;
    }
}
