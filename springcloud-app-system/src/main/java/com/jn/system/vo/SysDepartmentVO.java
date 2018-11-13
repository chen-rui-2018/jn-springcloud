package com.jn.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;
import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/12 16:34
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentVO" ,description = "根据层级关系获取部门信息")
public class SysDepartmentVO implements Serializable {
    private static final long serialVersionUID = 8857934360566700442L;

    @ApiModelProperty("部门id")
    private String id;
    @ApiModelProperty("部门名称")
    private String label ;
    @ApiModelProperty("子部门的集合")
    private List<SysDepartmentVO> children;

    public SysDepartmentVO() {
    }

    public SysDepartmentVO(String id, String label, List<SysDepartmentVO> children) {
        this.id = id;
        this.label = label;
        this.children = children;
    }

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

    public List<SysDepartmentVO> getChildren() {
        return children;
    }

    public void setChildren(List<SysDepartmentVO> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SysDepartmentVO{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", children=" + children +
                '}';
    }
}
