package com.jn.user.usercenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * 用户中心- 用户资料
 * @author： chenr
 * @date： Created on 2019/3/22 11:25
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value="UserCenterInfoVo",description = "用户中心- 用户资料")
public class UserCenterInfoVo implements Serializable {
    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "账号")
    private String account;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "真实姓名")
    private String name;
    @ApiModelProperty(value = "呢称")
    private String nickName;
    @ApiModelProperty(value = "性别 0:女-1:男")
    private String sex;
    @ApiModelProperty(value = "个性签名")
    private String signature;
    @ApiModelProperty(value = "兴趣爱好")
    private List<String> hobbys;
    @ApiModelProperty(value = "职业")
    private List<String>jobs;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public List<String> getHobbys() {
        return hobbys;
    }

    public void setHobbys(List<String> hobbys) {
        this.hobbys = hobbys;
    }

    public List<String> getJobs() {
        return jobs;
    }

    public void setJobs(List<String> jobs) {
        this.jobs = jobs;
    }
}
