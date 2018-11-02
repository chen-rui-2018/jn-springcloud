package com.jn.system.vo;

import com.jn.system.model.SysDepartmentPost;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 */
public class TbSysUser implements Serializable {

    private static final long serialVersionUID = 3235175375305639033L;
    private String id;

    private String account; //用户账号

    private String password; //用户密码

    private String name; //用户名称

    private String phone;//手机号码

    private String email;//邮箱

    private String creator;//创建人

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效 -1:删除

    private List<SysDepartmentPost> sysDepartmentPostList;

    public TbSysUser() {
    }

    public TbSysUser(String id, String account, String password, String name, String phone, String email,
                     String creator, Date createTime, String status, List<SysDepartmentPost> sysDepartmentPostList) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
        this.sysDepartmentPostList = sysDepartmentPostList;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SysDepartmentPost> getSysDepartmentPostList() {
        return sysDepartmentPostList;
    }

    public void setSysDepartmentPostList(List<SysDepartmentPost> sysDepartmentPostList) {
        this.sysDepartmentPostList = sysDepartmentPostList;
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
        return "TbSysUser{" +
                "id='" + id + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                ", sysDepartmentPostList=" + sysDepartmentPostList +
                '}';
    }
}