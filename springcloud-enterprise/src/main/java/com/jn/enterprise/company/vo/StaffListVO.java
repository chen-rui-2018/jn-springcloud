package com.jn.enterprise.company.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工列表出参
 * @author： huxw
 * @date： Created on 2019-4-9 14:18:49
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "StaffListVO",description = "员工列表出参")
public class StaffListVO implements Serializable {

    @ApiModelProperty(value = "员工ID")
    private String staffId;
    @ApiModelProperty(value = "邀请状态显示")
    private String statusShow;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "呢称")
    private String nickName;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "性别(0:女  1：男)")
    private String sex;
    @ApiModelProperty(value = "角色名称")
    private String roleName;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "加入方式（0升级员工 1企业邀请）")
    private String joinPattern;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private Date birthday;
    @ApiModelProperty(value = "入驻日期")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    public String getJoinPattern() {
        return joinPattern;
    }

    public void setJoinPattern(String joinPattern) {
        this.joinPattern = joinPattern;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStatusShow() {
        return statusShow;
    }

    public void setStatusShow(String statusShow) {
        this.statusShow = statusShow;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "StaffListVO{" +
                "staffId='" + staffId + '\'' +
                ", statusShow='" + statusShow + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", roleName='" + roleName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", joinPattern='" + joinPattern + '\'' +
                ", birthday=" + birthday +
                ", checkTime=" + checkTime +
                '}';
    }
}
