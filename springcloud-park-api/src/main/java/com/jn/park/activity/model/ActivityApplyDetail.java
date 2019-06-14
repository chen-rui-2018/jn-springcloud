package com.jn.park.activity.model;

import io.swagger.annotations.ApiModel;
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
@ApiModel(value = "ActivityApplyDetail", description = "活动报名信息")
public class ActivityApplyDetail implements Serializable {
    @ApiModelProperty(value = "报名信息标识")
    private String id;
    @ApiModelProperty(value = "活动ID")
    private String activityId;
    @ApiModelProperty(value = "用户账号")
    private String account;
    @ApiModelProperty(value = "用户名称")
    private String name;
    @ApiModelProperty(value = "用户性别 0女1男")
    private String sex;
    @ApiModelProperty(value = "用户年龄")
    private Integer age;
    @ApiModelProperty(value = "公司名称")
    private String company;
    @ApiModelProperty(value = "岗位名称")
    private String post;
    @ApiModelProperty(value = "电话")
    private String phone;
    @ApiModelProperty(value = "头像地址")
    private String avatar;
    @ApiModelProperty(value = "签到状态(0:未签到  1:已签到)")
    private String signStatus;
    @ApiModelProperty(value = "报名状态(0:取消报名  1:报名成功  2:报名待审核)")
    private String applyStatus;
    @ApiModelProperty(value = "报名时间 yyyy-MM-dd HH:mm:ss")
    private String applyTime;
    @ApiModelProperty(value = "签到时间 yyyy-MM-dd HH:mm:ss")
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "ActivityApplyDetail{" +
                "id='" + id + '\'' +
                ", activityId='" + activityId + '\'' +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                ", post='" + post + '\'' +
                ", phone='" + phone + '\'' +
                ", avatar='" + avatar + '\'' +
                ", signStatus='" + signStatus + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", signTime='" + signTime + '\'' +
                '}';
    }
}
