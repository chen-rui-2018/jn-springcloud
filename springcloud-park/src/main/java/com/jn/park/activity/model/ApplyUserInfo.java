package com.jn.park.activity.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 报名用户基本信息
 * @Author: yangph
 * @Date: 2018/12/10 18:22
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ApplyUserInfo", description = "报名用户基本信息")
public class ApplyUserInfo implements Serializable {
    @ApiModelProperty(value = "人员头像")
    private String avatar;
    @ApiModelProperty(value = "人员名称")
    private String name;
    @ApiModelProperty(value = "性别")
    private String sex;
    @ApiModelProperty(value = "公司")
    private String company;
    @ApiModelProperty(value = "岗位/职务")
    private String position;

    private static final long serialVersionUID = 1L;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
