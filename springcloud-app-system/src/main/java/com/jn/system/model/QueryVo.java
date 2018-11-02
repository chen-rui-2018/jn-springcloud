package com.jn.system.model;

import com.jn.common.model.Page;

import java.io.Serializable;

/**
 * 查询实体类
 * @author： shaobao
 * @date： Created on 2018/11/1 9:05
 * @version： v1.0
 * @modified By:
 **/
public class QueryVo extends Page implements Serializable {

    private static final long serialVersionUID = 2197567068130372509L;
    private String id; //根据id查询
    private String name; //查询名称条件
    private String status; // 状态查询条件
    private String departmentId; //部门查询id
    private String udpStatus; //部门岗位状态

    public QueryVo() {
    }

    public QueryVo(String id, String name, String status, String departmentId, String udpStatus) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.departmentId = departmentId;
        this.udpStatus = udpStatus;
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

    @Override
    public String toString() {
        return "QueryVo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", udpStatus='" + udpStatus + '\'' +
                '}';
    }
}
