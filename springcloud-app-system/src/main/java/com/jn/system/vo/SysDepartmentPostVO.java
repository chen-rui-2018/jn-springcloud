package com.jn.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *部门岗位实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartmentPostVO",description = "部门岗位实体类")
public class SysDepartmentPostVO implements Serializable {
    private static final long serialVersionUID = 5393600301120145656L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("部门id")
    private String departmentId;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("岗位id")
    private String postId;
    @ApiModelProperty("岗位民称")
    private String postName;
    @ApiModelProperty("是否默认")
    private String isDefault;

    public SysDepartmentPostVO() {
    }

    public SysDepartmentPostVO(String id, String departmentId, String departmentName,
                               String postId, String postName, String isDefault) {
        this.id = id;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.postId = postId;
        this.postName = postName;
        this.isDefault = isDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "SysDepartmentPostVO{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
