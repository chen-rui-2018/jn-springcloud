package com.jn.hardware.model.dingtalk.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 钉钉：用户信息
 *
 * @Author： cm
 * @Date： Created on 2019/6/15 17:32
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DingTalkUser implements Serializable {
    private static final long serialVersionUID = 8434878660437106838L;

    private String userid;
    private String unionid;
    private String openId;
    private String mobile;
    private String tel;
    private String workPlace;
    private String remark;
    private String order;
    private String isAdmin;
    private String isBoss;
    private String isHide;
    private String isLeader;
    private String name;
    private String active;
    private List<Integer> department;
    private String position;
    private String email;
    private String avatar;
    private String jobnumber;
    private String extattr;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getIsBoss() {
        return isBoss;
    }

    public void setIsBoss(String isBoss) {
        this.isBoss = isBoss;
    }

    public String getIsHide() {
        return isHide;
    }

    public void setIsHide(String isHide) {
        this.isHide = isHide;
    }

    public String getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(String isLeader) {
        this.isLeader = isLeader;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public List<Integer> getDepartment() {
        return department;
    }

    public void setDepartment(List<Integer> department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getExtattr() {
        return extattr;
    }

    public void setExtattr(String extattr) {
        this.extattr = extattr;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "DingTalkUser{" +
                "userid='" + userid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", openId='" + openId + '\'' +
                ", mobile='" + mobile + '\'' +
                ", tel='" + tel + '\'' +
                ", workPlace='" + workPlace + '\'' +
                ", remark='" + remark + '\'' +
                ", order='" + order + '\'' +
                ", isAdmin='" + isAdmin + '\'' +
                ", isBoss='" + isBoss + '\'' +
                ", isHide='" + isHide + '\'' +
                ", isLeader='" + isLeader + '\'' +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", jobnumber='" + jobnumber + '\'' +
                ", extattr='" + extattr + '\'' +
                '}';
    }
}
