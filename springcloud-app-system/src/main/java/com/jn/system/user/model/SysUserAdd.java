package com.jn.system.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户信息添加实体
 *
 * @author： shaobao
 * @date： Created on 2018/12/6 17:29
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserAdd", description = "用户信息添加实体")
public class SysUserAdd implements Serializable {
    private static final long serialVersionUID = -2990338272082087290L;

    @ApiModelProperty("用户id")
    private String id;

    @ApiModelProperty("用户账号")
    @Pattern(regexp = "^[A-Za-z0-9]{1,16}$", message = "{\"account\":\"账号只允许1-16位数字及字母\"}")
    private String account;

    @ApiModelProperty("用户密码")
    @Pattern(regexp="^(?!^\\d+$)(?!^[A-Za-z]+$)(?!^[^A-Za-z0-9]+$)(?!^.*[\\u4E00-\\u9FA5].*$)^\\S{8,16}$",
            message="{password:'密码至少为字母、数字、符号两种组成，不包含空格,不能输入中文'}")
    private String password;

    @ApiModelProperty("用户名称")
    @Size(max = 16, message = "用户名称长度不能超过16个字")
    private String name;

    @ApiModelProperty("手机号码")
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$",
            message = "{phone:'手机号码验证出错'}")
    private String phone;

    @ApiModelProperty("邮箱")
    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?",
            message = "{email:'邮箱验证出错'}")
    private String email;

    @ApiModelProperty("状态")
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    @ApiModelProperty("微信账号")
    @Pattern(regexp = "^$|[a-zA-Z0-9][-_a-zA-Z0-9]{5,19}$", message = "{weixinAccount:'微信号校验错误'}")
    private String wechatAccount;

    @ApiModelProperty(value = "备注")
    @Size(max = 200, message = "备注字符不能超过200字")
    private String remark;

    @ApiModelProperty("部门id")
    private String departmentId;

    @ApiModelProperty("岗位id")
    private String postId;

    public SysUserAdd() {
    }

    public SysUserAdd(String id, String account, String password, String name, String phone, String email,
                      Byte recordStatus, String wechatAccount, String remark, String departmentId, String postId) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.recordStatus = recordStatus;
        this.wechatAccount = wechatAccount;
        this.remark = remark;
        this.departmentId = departmentId;
        this.postId = postId;
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    @Override
    public String toString() {
        return "SysUserAdd{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", recordStatus=" + recordStatus +
                ", wechatAccount='" + wechatAccount + '\'' +
                ", remark='" + remark + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", postId='" + postId + '\'' +
                '}';
    }
}
