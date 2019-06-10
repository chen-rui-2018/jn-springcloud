package com.jn.system.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserVO", description = "用户关联部门和岗位")
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private String createdTime;
    @ApiModelProperty("状态")
    private Byte recordStatus;
    @ApiModelProperty("微信账号")
    private String wechatAccount;
    @ApiModelProperty(value = "备注")
    private String remark;
    @ApiModelProperty("部门名称")
    private String departmentName;
    @ApiModelProperty("岗位名称")
    private String postName;
    @ApiModelProperty("岗位类型名称")
    private String postTypeName;

    public SysUserVO() {
    }

    public SysUserVO(String id, String account, String name, String phone, String email, String createdTime,
                     Byte recordStatus, String wechatAccount, String remark, String departmentName, String postName,
                     String postTypeName) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.wechatAccount = wechatAccount;
        this.remark = remark;
        this.departmentName = departmentName;
        this.postName = postName;
        this.postTypeName = postTypeName;
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

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getWechatAccount() {
        return wechatAccount;
    }

    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    @Override
    public String toString() {
        return "SysUserVO{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createdTime='" + createdTime + '\'' +
                ", recordStatus=" + recordStatus +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", remark='" + remark + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", postName='" + postName + '\'' +
                ", postTypeName='" + postTypeName + '\'' +
                '}';
    }
}