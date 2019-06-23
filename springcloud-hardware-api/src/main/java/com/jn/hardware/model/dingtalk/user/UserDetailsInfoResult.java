package com.jn.hardware.model.dingtalk.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName：钉钉：用户详情出参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/23 12:03
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailsInfoResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = -8448602859073356277L;

    /**
     *员工在当前企业内的唯一标识，也称staffId
    * */
    private String userid;
    /**
     *员工在当前开发者企业账号范围内的唯一标识，系统生成，固定值，不会改变
     * */
    private String unionid;
    /**
     *	员工名字
     * */
    private String name;
    /**
     * 是否已经激活，true表示已激活，false表示未激活
     * */
    private Boolean active;
    /**
     * 在对应的部门中的排序，key是部门的Id，value是人员在这个部门的排序值
     * */
    private String orderInDepts;
    /**
     * 是否为企业的管理员，true表示是，false表示不是
     * */
    private Boolean isAdmin;
    /**
     * 	是否为企业的老板，true表示是，false表示不是
     * */
    private Boolean isBoss;
    /**
     * 在对应的部门中是否为主管：Map结构的json字符串，key是部门的Id，
     * value是人员在这个部门中是否为主管，true表示是，false表示不是
     * */
    private String isLeaderInDepts;
    /**
     *是否号码隐藏，true表示隐藏，false表示不隐藏
     * */
    private Boolean isHide;
    /**
     * 成员所属部门id列表
     * */
    private List<String> department;
    /**
     * 职位信息
     * */
    private String position;
    /**
     * 头像url
     * */
    private String avatar;
    /**
     * 入职时间。Unix时间戳 （在OA后台通讯录中的员工基础信息中维护过入职时间才会返回)
     * */
    private Long hiredDate;
    /**
     * 	员工工号
     * */
    private String jobnumber;
    /**
     * 是否是高管
     * */
    private Boolean isSenior;
    /**
     * 	用户所在角色列表
    * */
    private List<UserRole> roles;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getOrderInDepts() {
        return orderInDepts;
    }

    public void setOrderInDepts(String orderInDepts) {
        this.orderInDepts = orderInDepts;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getIsBoss() {
        return isBoss;
    }

    public void setIsBoss(Boolean boss) {
        isBoss = boss;
    }

    public String getIsLeaderInDepts() {
        return isLeaderInDepts;
    }

    public void setIsLeaderInDepts(String isLeaderInDepts) {
        this.isLeaderInDepts = isLeaderInDepts;
    }

    public Boolean getIsHide() {
        return isHide;
    }

    public void setIsHide(Boolean hide) {
        isHide = hide;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Long getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Long hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public Boolean getIsSenior() {
        return isSenior;
    }

    public void setIsSenior(Boolean senior) {
        isSenior = senior;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserInfoResult{" +
                "userid='" + userid + '\'' +
                ", unionid='" + unionid + '\'' +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", orderInDepts='" + orderInDepts + '\'' +
                ", isAdmin=" + isAdmin +
                ", isBoss=" + isBoss +
                ", isLeaderInDepts='" + isLeaderInDepts + '\'' +
                ", isHide=" + isHide +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", avatar='" + avatar + '\'' +
                ", hiredDate=" + hiredDate +
                ", jobnumber='" + jobnumber + '\'' +
                ", isSenior=" + isSenior +
                ", roles=" + roles +
                '}';
    }
}
