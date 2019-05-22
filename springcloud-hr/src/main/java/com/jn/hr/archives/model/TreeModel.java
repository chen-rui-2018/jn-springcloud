package com.jn.hr.archives.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author dt
 * @create 2019-05-08 下午 3:22
 */
@ApiModel(value = "TreeModel", description = "树实体")
public class TreeModel {
    @ApiModelProperty(value = "ID")
    private String id;
    @ApiModelProperty(value = "label")
    private String label;
    @ApiModelProperty(value = "父类ID")
    private String parentId;
    @ApiModelProperty(value = "层级")
    private String level;
    private List<TreeModel> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<TreeModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel> children) {
        this.children = children;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
