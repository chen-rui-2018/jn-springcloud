package com.jn.system.model;

import com.jn.system.vo.SysDepartmentPostVO;
import com.jn.system.vo.SysGroupVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 用户信息
 */
@ApiModel(value = "User", description = "用户信息")
public class User implements Serializable {

    private static final long serialVersionUID = -7484136779753770396L;

    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "账户名")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty("用户真实姓名")
    private String name;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("创建邮箱")
    private String email;

    @ApiModelProperty("创建人")
    private String creatorAccount;

    @ApiModelProperty("创建时间")
    private Date createdTime;

    @ApiModelProperty("状态")
    private Byte recordStatus;

    @ApiModelProperty("微信账号")
    @Pattern(regexp = "^$|[a-zA-Z0-9][-_a-zA-Z0-9]{5,19}$", message = "{weixinAccount:'微信号校验错误'}")
    private String wechatAccount;

    @ApiModelProperty(value = "备注")
    @Size(max = 200, message = "备注字符不能超过200字")
    private String remark;

    @ApiModelProperty(value = "用户具有的角色")
    private List<SysRole> sysRole;

    @ApiModelProperty(value = "用户具有的部门信息")
    private List<SysDepartmentPostVO> sysDepartmentPostVO;

    @ApiModelProperty(value = "用户具有的用户组信息")
    private List<SysGroupVO> sysGroupVO;

    public User() {
    }

    public User(String id, String account, String password, String name, String phone, String email,
                String creatorAccount, Date createdTime, Byte recordStatus, String wechatAccount,
                String remark, List<SysRole> sysRole, List<SysDepartmentPostVO> sysDepartmentPostVO,
                List<SysGroupVO> sysGroupVO) {
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
        this.sysRole = sysRole;
        this.sysDepartmentPostVO = sysDepartmentPostVO;
        this.sysGroupVO = sysGroupVO;
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

    public List<SysRole> getSysRole() {
        return sysRole;
    }

    public void setSysRole(List<SysRole> sysRole) {
        this.sysRole = sysRole;
    }

    public List<SysDepartmentPostVO> getSysDepartmentPostVO() {
        return sysDepartmentPostVO;
    }

    public void setSysDepartmentPostVO(List<SysDepartmentPostVO> sysDepartmentPostVO) {
        this.sysDepartmentPostVO = sysDepartmentPostVO;
    }

    public List<SysGroupVO> getSysGroupVO() {
        return sysGroupVO;
    }

    public void setSysGroupVO(List<SysGroupVO> sysGroupVO) {
        this.sysGroupVO = sysGroupVO;
    }

    @Override
    public String toString() {
        return "User{" +
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
                ", sysRole=" + sysRole +
                ", sysDepartmentPostVO=" + sysDepartmentPostVO +
                ", sysGroupVO=" + sysGroupVO +
                '}';
    }
}