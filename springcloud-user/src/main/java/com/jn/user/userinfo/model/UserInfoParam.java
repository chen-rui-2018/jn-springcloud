package com.jn.user.userinfo.model;

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
@ApiModel(value = "CompanyCheckParam",description = "用户信息入参")
public class UserInfoParam implements Serializable {

    @ApiModelProperty(value = "用户昵称")
    @NotNull(message = "用户昵称不能为空")
    private String nick_name;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "个性签名")
    private String signature;

    @ApiModelProperty(value = "头像路径")
    private String avatar;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "性别[0女1男]")
    @NotNull(message = "性别不能为空")
    @Pattern(regexp="^[01]$",message="{sex:'性别只允许为0,1'}")
    private String sex;

    @ApiModelProperty(value = "公司")
    private String company;

    @ApiModelProperty(value = "兴趣爱好[数组]")
    private String[] hobbys;

    @ApiModelProperty(value = "职业[数组]")
    private String[] jobs;


    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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
}
