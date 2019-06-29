package com.jn.hardware.model.dingtalk.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jn.hardware.model.dingtalk.BaseResult;

import java.io.Serializable;

/**
 * @ClassName：钉钉 ：获取部门详情出参实体类
 * @Descript：
 * @Author： hey
 * @Date： Created on 2019/6/23 14:39
 * @Version： v1.0
 * @Modified By:
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDetailsInfoResult extends BaseResult implements Serializable {

    private static final long serialVersionUID = 7676097590862746963L;

    /**
     * 部门id
    * */
    private String id;
    /**
     * 部门名称
     * */
    private String name;
    /**
     * 父部门id，根部门为1
     * */
    private String parentid;
    /**
     * 当前部门在父部门下的所有子部门中的排序值
     * */
    private String order;
    /**
     * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     * */
    private Boolean createDeptGroup;
    /**
     * 当部门群已经创建后，是否有新人加入部门会自动加入该群，true表示是，false表示不是
     * */
    private Boolean autoAddUser;
    /**
     * 是否隐藏部门，true表示隐藏，false表示显示
     * */
    private Boolean deptHiding;
    /**
     * 是否本部门的员工仅可见员工自己，为true时，本部门员工默认只能看到员工自己
     * */
    private Boolean outerDept;
    /**
     * 可以查看指定隐藏部门的其他部门列表，如果部门隐藏，则此值生效，取值为其他的部门id组成的的字符串，使用“|”符号进行分割
     * */
    private String deptPermits;
    /**
     * 可以查看指定隐藏部门的其他人员列表，如果部门隐藏，则此值生效，取值为其他的人员userid组成的的字符串，使用“|”符号进行分割
     * */
    private String userPermits;
    /**
     * 本部门的员工仅可见员工自己为true时，可以配置额外可见部门，值为部门id组成的的字符串，使用“|”符号进行分割
     * */
    private String outerPermitDepts;
    /**
     * 	本部门的员工仅可见员工自己为true时，可以配置额外可见人员，值为userid组成的的字符串，使用“|”符号进行分割
     * */
    private String outerPermitUsers;
    /**
     * 企业群群主
     * */
    private String orgDeptOwner;
    /**
     * 	部门的主管列表，取值为由主管的userid组成的字符串，不同的userid使用“|”符号进行分割
     * */
    private String deptManagerUseridList;
    /**
     * 部门标识字段，开发者可用该字段来唯一标识一个部门，并与钉钉外部通讯录里的部门做映射
     * */
    private String sourceIdentifier;
    /**
     * 部门群是否包含子部门
    * */
    private Boolean groupContainSubDept;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Boolean getCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setCreateDeptGroup(Boolean createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public Boolean getAutoAddUser() {
        return autoAddUser;
    }

    public void setAutoAddUser(Boolean autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    public Boolean getDeptHiding() {
        return deptHiding;
    }

    public void setDeptHiding(Boolean deptHiding) {
        this.deptHiding = deptHiding;
    }

    public Boolean getOuterDept() {
        return outerDept;
    }

    public void setOuterDept(Boolean outerDept) {
        this.outerDept = outerDept;
    }

    public String getDeptPermits() {
        return deptPermits;
    }

    public void setDeptPermits(String deptPermits) {
        this.deptPermits = deptPermits;
    }

    public String getUserPermits() {
        return userPermits;
    }

    public void setUserPermits(String userPermits) {
        this.userPermits = userPermits;
    }

    public String getOuterPermitDepts() {
        return outerPermitDepts;
    }

    public void setOuterPermitDepts(String outerPermitDepts) {
        this.outerPermitDepts = outerPermitDepts;
    }

    public String getOuterPermitUsers() {
        return outerPermitUsers;
    }

    public void setOuterPermitUsers(String outerPermitUsers) {
        this.outerPermitUsers = outerPermitUsers;
    }

    public String getOrgDeptOwner() {
        return orgDeptOwner;
    }

    public void setOrgDeptOwner(String orgDeptOwner) {
        this.orgDeptOwner = orgDeptOwner;
    }

    public String getDeptManagerUseridList() {
        return deptManagerUseridList;
    }

    public void setDeptManagerUseridList(String deptManagerUseridList) {
        this.deptManagerUseridList = deptManagerUseridList;
    }

    public String getSourceIdentifier() {
        return sourceIdentifier;
    }

    public void setSourceIdentifier(String sourceIdentifier) {
        this.sourceIdentifier = sourceIdentifier;
    }

    public Boolean getGroupContainSubDept() {
        return groupContainSubDept;
    }

    public void setGroupContainSubDept(Boolean groupContainSubDept) {
        this.groupContainSubDept = groupContainSubDept;
    }

    @Override
    public String toString() {
        return "DepartmentDetailsInfoResult{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                ", order='" + order + '\'' +
                ", createDeptGroup=" + createDeptGroup +
                ", autoAddUser=" + autoAddUser +
                ", deptHiding=" + deptHiding +
                ", outerDept=" + outerDept +
                ", deptPermits='" + deptPermits + '\'' +
                ", userPermits='" + userPermits + '\'' +
                ", outerPermitDepts='" + outerPermitDepts + '\'' +
                ", outerPermitUsers='" + outerPermitUsers + '\'' +
                ", orgDeptOwner='" + orgDeptOwner + '\'' +
                ", deptManagerUseridList='" + deptManagerUseridList + '\'' +
                ", sourceIdentifier='" + sourceIdentifier + '\'' +
                ", groupContainSubDept=" + groupContainSubDept +
                '}';
    }
}
