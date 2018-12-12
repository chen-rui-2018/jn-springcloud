package com.jn.park.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 活动信息部分字段
 *
 * @Author: chenr
 * @Date: 2018/12/11 11:15
 * @Version v1.0
 * @modified By:
 */
public class ActivityApplyDetail implements Serializable {
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "用户账号")
    private String account;
    @ApiModelProperty(value = "用户名称")
    private String name;
    @ApiModelProperty(value = "用户性别")
    private String sex;
    @ApiModelProperty(value = "用户年龄")
    private String age;
    @ApiModelProperty(value = "公司名称")
    private String company;
    @ApiModelProperty(value = "岗位名称")
    private String post;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "头像地址")
    private String avatar;
    @ApiModelProperty(value = "签到状态")
    private String signState;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSignState() {
        return signState;
    }

    public void setSignState(String signState) {
        this.signState = signState;
    }
}
