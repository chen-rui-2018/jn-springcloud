package com.jn.system.user.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @author： shaobao
 * @date： Created on 2018/11/6 14:00
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUser",description = "用户信息")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 5917002469697213234L;

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户账号")
    @Pattern(regexp="^[A-Za-z0-9]{6,16}$",message="{\"account\":\"账号只允许6-16位数字及字母\"}")
    private String account;

    @ApiModelProperty("用户密码")
    @Pattern(regexp="^[a-zA-Z0-9]{6,16}$",message="{password:'密码只允许6-16位数字及字母'}")
    private String password;

    @ApiModelProperty("用户名称")
    @Size(max = 16, message = "用户名称长度不能超过16个字")
    private String name;

    @ApiModelProperty("手机号码")
    @Pattern(regexp="^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message="{phone:'手机号码验证出错'}")
    private String phone;

    @ApiModelProperty("邮箱")
    @Pattern(regexp="[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",
            message="{email:'邮箱验证出错'}")
    private String email;

    @ApiModelProperty("创建人")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("状态")
    private Byte recordStatus;

    @ApiModelProperty("微信账号")
    @Pattern(regexp="^$|[a-zA-Z0-9][-_a-zA-Z0-9]{5,19}$",message="{weixinAccount:'微信号校验错误'}")
    private String wechatAccount;

    @ApiModelProperty(value = "备注")
    @Size(max = 200, message = "备注字符不能超过200字")
    private String remark;

    public SysUser() {
    }

    public SysUser(String id, String account, String password, String name, String phone, String email,
                   String creatorAccount, Date createdTime, Byte recordStatus, String wechatAccount, String remark) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.wechatAccount = wechatAccount;
        this.remark = remark;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
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

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
