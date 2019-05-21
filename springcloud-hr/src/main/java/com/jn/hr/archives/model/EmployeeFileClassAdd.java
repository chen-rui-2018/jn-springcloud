package com.jn.hr.archives.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author dt
 * @create 2019-04-17 上午 9:29
 */
@ApiModel(value = "EmployeeFileClass", description = "员工档案分类新增实体")
public class EmployeeFileClassAdd {
    @ApiModelProperty(value = "分类ID")
    private String classId;
    @ApiModelProperty(value = "父类ID")
    private String parentId;
    @ApiModelProperty(value = "分类名称")
    @NotNull(message = "分类名称不能为空")
    private String nodeName;
    @ApiModelProperty(value = "层级")
    @Pattern( regexp="^[1-9]\\d*$",message = "层级必须是大于0的整数")
    @NotNull(message = "层级不能为空")
    private String level;

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
}
