package com.jn.system.user.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Arrays;

/**
 *查询工具类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserPage",description = "用户条件分页查询类")
public class SysUserPage extends Page implements Serializable {

    private static final long serialVersionUID = 2197567068130372509L;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("状态")
    private Byte recordStatus;

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("岗位或岗位类型名称")
    private String postOrTypeName;

    public SysUserPage() {
    }

    public SysUserPage(String name, Byte recordStatus, String departmentId, String postOrTypeName) {
        this.name = name;
        this.recordStatus = recordStatus;
        this.departmentId = departmentId;
        this.postOrTypeName = postOrTypeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPostOrTypeName() {
        return postOrTypeName;
    }

    public void setPostOrTypeName(String postOrTypeName) {
        this.postOrTypeName = postOrTypeName;
    }

    @Override
    public String toString() {
        return "SysUserPage{" +
                "name='" + name + '\'' +
                ", recordStatus=" + recordStatus +
                ", departmentId='" + departmentId + '\'' +
                ", postOrTypeName='" + postOrTypeName + '\'' +
                '}';
    }
}
