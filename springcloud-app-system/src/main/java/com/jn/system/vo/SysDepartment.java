package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:部门实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysDepartment implements Serializable {
    private static final long serialVersionUID = -6961951858143702934L;
    /**
     * 部门id
     */
    private String id;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 状态 1:有效,0:无效,-1删除
     */
    private String status;

    public SysDepartment() {
    }

    public SysDepartment(String id, String departmentName, Date createTime, String creator, String status) {
        this.id = id;
        this.departmentName = departmentName;
        this.createTime = createTime;
        this.creator = creator;
        this.status = status;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "SysDepartment{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}