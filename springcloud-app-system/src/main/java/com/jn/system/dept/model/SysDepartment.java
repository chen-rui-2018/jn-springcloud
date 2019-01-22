package com.jn.system.dept.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
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
    @ApiModelProperty(value = "id",required = true)
    private String id;
    @ApiModelProperty(value = "部门名称",required = true)
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "部门名称校验失败")
    private String departmentName;
    @ApiModelProperty("创建时间")
    private Date createdTime;
    @ApiModelProperty("状态 1有效 0无效 -1删除")
    private Byte recordStatus;
    @ApiModelProperty(value = "父级id",required = true)
    @NotBlank(message = "父级id不能为空")
    private String parentId;

    public SysDepartment() {
    }

    public SysDepartment(String id, String departmentName, Date createdTime, Byte recordStatus, String parentId) {
        this.id = id;
        this.departmentName = departmentName;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
