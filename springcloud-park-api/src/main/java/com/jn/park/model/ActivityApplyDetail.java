package com.jn.park.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 活动报名信息字段
 *
 * @Author: chenr
 * @Date: 2018/12/11 11:15
 * @Version v1.0
 * @modified By:jiangyl
 */
public class ActivityApplyDetail implements Serializable {
    @ApiModelProperty(value = "报名标识")
    private String id;
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
    @ApiModelProperty(value = "报名状态")
    private String applyState;
    @ApiModelProperty(value = "报名时间")
    private String applyTime;
    @ApiModelProperty(value = "签到时间")
    private String signTime;


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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplyState() {
        return applyState;
    }

    public void setApplyState(String applyState) {
        this.applyState = applyState;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }
}
