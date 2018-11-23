package com.jn.system.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 *用户实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value ="SysUserVO",description = "用户关联部门和岗位")
public class SysUserVO implements Serializable {

    private static final long serialVersionUID = 3235175375305639033L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("用户账号")
    private String account;
    @ApiModelProperty("用户名称")
    private String name;
    @ApiModelProperty("手机号码")
    private String phone;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("岗位名称")
    private String postName;

    public SysUserVO() {
    }

    public SysUserVO(String id, String account, String name, String phone, String email,
                     Date createTime, String status, String departmentName, String postName) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createTime = createTime;
        this.status = status;
        this.departmentName = departmentName;
        this.postName = postName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "SysUserVO{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}