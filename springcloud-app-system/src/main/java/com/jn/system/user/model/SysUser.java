package com.jn.system.user.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
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
    private String creator;

    @ApiModelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty("状态 1有效 0无效 -1删除")
    @Pattern(regexp="^\\-1|[01]$",message="{status:'状态值只允许为0,1,-1'}")
    private String status;

    public SysUser() {
    }

    public SysUser(String id, String account, String password, String name, String phone,
                   String email, String creator, Date createTime, String status) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
