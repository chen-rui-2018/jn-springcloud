package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门
 *
 * @author： shaobao
 * @date： Created on 2018/11/7 16:45
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDepartment", description = "部门信息")
public class SysDepartment implements Serializable {

    private static final long serialVersionUID = 3850036433256084982L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private String status;
    @ApiModelProperty("父级id")
    private String parentId;

    public SysDepartment() {
    }

    public SysDepartment(String id, String departmentName, Date createTime, String status, String parentId) {
        this.id = id;
        this.departmentName = departmentName;
        this.createTime = createTime;
        this.status = status;
        this.parentId = parentId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
