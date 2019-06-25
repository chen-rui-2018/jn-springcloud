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

    /**
     * 员工id
    * */
    private String userid;
    /**
     * 员工在当前开发者企业账号范围内的唯一标识，系统生成，固定值，不会改变
    * */
    private String unionid;
    /**
     *
    * */
    private String openId;
    /**
     * 手机号
     * */
    private String mobile;
    /**
     * 分机号
     * */
    private String tel;
    /**
     * 办公地点
     * */
    private String workPlace;
    /**
     * 备注
     * */
    private String remark;
    /**
     * 表示人员在此部门中的排序，列表是按order的倒序排列输出的，即从大到小排列输出的
     * （钉钉管理后台里面调整了顺序的话order才有值）
     * */
    private Long order;
    /**
     * 是否是企业的管理员，true表示是，false表示不是
     * */
    private Boolean isAdmin;
    /**
     * 是否为企业的老板，true表示是，false表示不是
     * */
    private Boolean isBoss;
    /**
     * 是否隐藏号码，true表示是，false表示不是
     * */
    private Boolean isHide;
    /**
     * 是否是部门的主管，true表示是，false表示不是
     * */
    private Boolean isLeader;
    /**
     * 员工名称
     * */
    private String name;
    /**
     * 表示该用户是否激活了钉钉
     * */
    private Boolean active;
    /**
     * 成员所属部门id列表
     * */
    private List<Integer> department;
    /**
     * 职位信息
     * */
    private String position;
    /**
     * 员工的邮箱
     * */
    private String email;
    /**
     * 头像url
     * */
    private String avatar;
    /**
     * 员工工号
     * */
    private String jobnumber;
    /**
     * 扩展属性，可以设置多种属性（但手机上最多只能显示10个扩展属性，具体显示哪些属性，请到OA管理后台->设置->通讯录信息设置和OA管理后台->设置->手机端显示信息设置）
     * */
    private String extattr;
    /**
     * 	入职时间
    * */
    private Long hiredDate;
    /**
     * 国家地区码
    * */
    private String stateCode;

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

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
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

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
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

    public Boolean getIsHide() {
        return isHide;
    }

    public void setIsHide(Boolean hide) {
        isHide = hide;
    }

    public Boolean getIsLeader() {
        return isLeader;
    }

    public void setIsLeader(Boolean leader) {
        isLeader = leader;
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

    public Long getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(Long hiredDate) {
        this.hiredDate = hiredDate;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
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
                ", order=" + order +
                ", isAdmin=" + isAdmin +
                ", isBoss=" + isBoss +
                ", isHide=" + isHide +
                ", isLeader=" + isLeader +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", department=" + department +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", jobnumber='" + jobnumber + '\'' +
                ", extattr='" + extattr + '\'' +
                ", hiredDate=" + hiredDate +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}
