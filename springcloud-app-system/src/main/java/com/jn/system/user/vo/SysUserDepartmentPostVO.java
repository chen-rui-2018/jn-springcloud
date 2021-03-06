package com.jn.system.user.vo;

import com.jn.system.vo.SysDepartmentPostVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author： shaobao
 * @date： Created on 2018/11/10 21:08
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysUserDepartmentPostVO", description = "用户具有的部门及岗位")
public class SysUserDepartmentPostVO implements Serializable {
    private static final long serialVersionUID = -1994539003144578150L;
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
    private Date createdTime;
    @ApiModelProperty("状态")
    private Byte recordStatus;
    @ApiModelProperty("部门岗位集合")
    private List<SysDepartmentPostVO> sysDepartmentPostVOList;

    public SysUserDepartmentPostVO() {
    }

    public SysUserDepartmentPostVO(String id, String account, String name, String phone, String email,
                                   Date createdTime, Byte recordStatus, List<SysDepartmentPostVO> sysDepartmentPostVOList) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
        this.sysDepartmentPostVOList = sysDepartmentPostVOList;
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

    public List<SysDepartmentPostVO> getSysDepartmentPostVOList() {
        return sysDepartmentPostVOList;
    }

    public void setSysDepartmentPostVOList(List<SysDepartmentPostVO> sysDepartmentPostVOList) {
        this.sysDepartmentPostVOList = sysDepartmentPostVOList;
    }

    @Override
    public String toString() {
        return "SysUserDepartmentPostVO{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                ", sysDepartmentPostVOList=" + sysDepartmentPostVOList +
                '}';
    }
}
