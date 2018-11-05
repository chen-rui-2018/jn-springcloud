package com.jn.system.model;

import com.jn.common.model.Page;

import java.io.Serializable;

/**
 *查询工具类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysUserQuery extends Page implements Serializable {

    private static final long serialVersionUID = 2197567068130372509L;
    /**
     * 根据id查询
     */
    private String id;
    /**
     * 查询名称条件
     */
    private String name;
    /**
     * 状态查询条件
     */
    private String status;
    /**
     * 部门查询id
     */
    private String departmentId;
    /**
     * 部门岗位状态
     */
    private String udpStatus;
    /**
     * 是否默认
     */
    private String isDefault;

    public SysUserQuery() {
    }

    public SysUserQuery(String id, String name, String status, String departmentId, String udpStatus, String isDefault) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.departmentId = departmentId;
        this.udpStatus = udpStatus;
        this.isDefault = isDefault;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUdpStatus() {
        return udpStatus;
    }

    public void setUdpStatus(String udpStatus) {
        this.udpStatus = udpStatus;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "SysUserQuery{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", udpStatus='" + udpStatus + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
