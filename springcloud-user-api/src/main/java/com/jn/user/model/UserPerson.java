package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人用户扩展信息
 * @Author: yangph
 * @Date: 2018/12/10 15:41
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "UserExtension", description = "个人用户扩展信息")
public class UserPerson implements Serializable {
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "年龄")
    private Integer age;
    @ApiModelProperty(value = "身份证号")
    private String idCard;
    @ApiModelProperty(value = "公司")
    private String company;
    @ApiModelProperty(value = "岗位")
    private String post;
    @ApiModelProperty(value = "学历")
    private String education;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "用户类型")
    private String userType;
    @ApiModelProperty(value = "积分")
    private Double point;
    @ApiModelProperty(value = "生日")
    private Date birthday;
    @ApiModelProperty(value = "创建人")
    private String creator_account;
    @ApiModelProperty(value = "创建时间")
    private Date created_time;
    @ApiModelProperty(value = "最新更新者账号")
    private String modifier_account;
    @ApiModelProperty(value = "最新更新时间")
    private Date modified_time;
    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Date record_status;

    private static final long serialVersionUID = 1L;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCreator_account() {
        return creator_account;
    }

    public void setCreator_account(String creator_account) {
        this.creator_account = creator_account;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getModifier_account() {
        return modifier_account;
    }

    public void setModifier_account(String modifier_account) {
        this.modifier_account = modifier_account;
    }

    public Date getModified_time() {
        return modified_time;
    }

    public void setModified_time(Date modified_time) {
        this.modified_time = modified_time;
    }

    public Date getRecord_status() {
        return record_status;
    }

    public void setRecord_status(Date record_status) {
        this.record_status = record_status;
    }

    @Override
    public String toString() {
        return "UserPerson{" +
                "account='" + account + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                ", company='" + company + '\'' +
                ", post='" + post + '\'' +
                ", education='" + education + '\'' +
                ", avatar='" + avatar + '\'' +
                ", userType='" + userType + '\'' +
                ", point=" + point +
                ", birthday=" + birthday +
                ", creator_account='" + creator_account + '\'' +
                ", created_time=" + created_time +
                ", modifier_account='" + modifier_account + '\'' +
                ", modified_time=" + modified_time +
                ", record_status=" + record_status +
                '}';
    }
}
