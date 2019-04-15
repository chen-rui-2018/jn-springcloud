package com.jn.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 用户信息入参
 * @author： jiangyl
 * @date： Created on 2019/3/6 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "UserInfo",description = "用户信息入参")
public class UserInfo implements Serializable {

    @ApiModelProperty(value = "账号",required = true, example = "wangsong")
    @NotNull(message = "账号不能为空")
    private String account;

    @ApiModelProperty(value = "用户昵称",required = true,example = "杨辉辉")
    @NotNull(message = "用户昵称不能为空")
    private String nickName;

    @ApiModelProperty(value = "姓名",example = "懒洋洋")
    private String name;

    @ApiModelProperty(value = "个性签名",example = "别看我只是一头羊")
    private String signature;

    @ApiModelProperty(value = "头像路径",example = "***/***.png")
    private String avatar;

    @ApiModelProperty(value = "年龄",example = "20")
    private Integer age;

    @ApiModelProperty(value = "电话号码",example = "110")
    private String phone;

    @ApiModelProperty(value = "性别[0女1男]",required = true,example = "1")
    @NotNull(message = "性别不能为空")
    @Pattern(regexp="^[01]$",message="{sex:'性别只允许为0,1'}")
    private String sex;

    @ApiModelProperty(value = "公司",example = "青青草原")
    private String company;

    @ApiModelProperty(value = "兴趣爱好ID[数组]，传“用户标签-获取用户字典表 tagType=0的ID”",example = "['001','002']")
    private String[] hobbys;

    @ApiModelProperty(value = "职业ID[数组],传“用户标签-获取用户字典表 tagType=1的ID”",example = "['101','102']")
    private String[] jobs;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }

    public String[] getJobs() {
        return jobs;
    }

    public void setJobs(String[] jobs) {
        this.jobs = jobs;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
