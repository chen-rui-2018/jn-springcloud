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
@ApiModel(value = "TreeData",description = "树")
public class TreeData extends JsonTreeData implements Serializable {

    @ApiModelProperty(value = "指标ID",example = "0001")
    private String id;
    @ApiModelProperty(value = "父节点id",example = "0001")
    private String pid;
    @ApiModelProperty(value = "指标名称",example = "法人名称")
    private String text;
    @ApiModelProperty(value = "指标状态是否删除（0标记删除，1正常）",example = "0")
    private String state;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPid() {
        return pid;
    }

    @Override
    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return state;
    }

    public void setStatus(String status) {
        this.state = status;
    }
}
