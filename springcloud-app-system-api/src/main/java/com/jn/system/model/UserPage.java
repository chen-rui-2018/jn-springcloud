package com.jn.system.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 *查询工具类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "UserPage",description = "用户条件分页查询类")
public class UserPage extends Page implements Serializable {

    private static final long serialVersionUID = 2197567068130372509L;

    @ApiModelProperty(value = "名称",example = "朱奕")
    private String name;

    @ApiModelProperty(value = "状态",example = "1")
    private Byte recordStatus;

    @ApiModelProperty(value = "部门id",example = "6b561892-5310-4ea8-877d-e791df462d0e")
    private String departmentId;

    @ApiModelProperty(value = "岗位或岗位类型名称",example = "领导")
    private String postOrTypeName;

    @ApiModelProperty(value = "手机号",example = "\"131\"")
    private String phone;

    public UserPage() {
    }

    public UserPage(String name, Byte recordStatus, String departmentId, String postOrTypeName, String phone) {
        this.name = name;
        this.recordStatus = recordStatus;
        this.departmentId = departmentId;
        this.postOrTypeName = postOrTypeName;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SysUserPage{" +
                "name='" + name + '\'' +
                ", recordStatus=" + recordStatus +
                ", departmentId='" + departmentId + '\'' +
                ", postOrTypeName='" + postOrTypeName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
