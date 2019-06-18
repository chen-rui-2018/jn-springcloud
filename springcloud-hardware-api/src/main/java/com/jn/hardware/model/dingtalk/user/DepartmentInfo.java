package com.jn.hardware.model.dingtalk.user;

import java.io.Serializable;

/**
 * 钉钉：部门信息
 *
 * @Author： cm
 * @Date： Created on 2019/6/17 11:04
 * @Version： v1.0
 * @Modified By:
 */
public class DepartmentInfo implements Serializable {

    private static final long serialVersionUID = 4296455691838286727L;

    /**
     * 部门id
     */
    private String id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id，根部门为1
     */
    private String parentid;
    /**
     * 是否同步创建一个关联此部门的企业群，true表示是，false表示不是
     */
    private String createDeptGroup;
    /**
     * 当群已经创建后，是否有新人加入部门会自动加入该群, true表示是，false表示不是
     */
    private String autoAddUser;

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

    public String getCreateDeptGroup() {
        return createDeptGroup;
    }

    public void setCreateDeptGroup(String createDeptGroup) {
        this.createDeptGroup = createDeptGroup;
    }

    public String getAutoAddUser() {
        return autoAddUser;
    }

    public void setAutoAddUser(String autoAddUser) {
        this.autoAddUser = autoAddUser;
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                ", createDeptGroup='" + createDeptGroup + '\'' +
                ", autoAddUser='" + autoAddUser + '\'' +
                '}';
    }
}
