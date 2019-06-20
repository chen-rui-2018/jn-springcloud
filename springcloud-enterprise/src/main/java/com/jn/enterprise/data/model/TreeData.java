package com.jn.enterprise.data.model;

import com.jn.common.model.Attributes;
import com.jn.common.model.JsonTreeData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： yangh
 * @date： Created on 2019/4/9 14:09
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TreeData1",description = "树")
public class TreeData implements Serializable {

    @ApiModelProperty(value = "指标ID",example = "0001")
    private String id;
    @ApiModelProperty(value = "父节点id",example = "0001")
    private String pid;
    @ApiModelProperty(value = "指标名称",example = "法人名称")
    private String text;
    @ApiModelProperty(value = "指标状态是否删除（0标记删除，1正常）",example = "0")
    private String state;
    @ApiModelProperty(value = "模板排序序号",example = "0")
    private Integer orderNumber;

    @ApiModelProperty(value = "子节点",example = "1")
    public List<TreeData> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TreeData> getChildren() {
        return children;
    }

    public void setChildren(List<TreeData> children) {
        this.children = children;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }
}
