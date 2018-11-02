package com.jn.system.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 部门岗位实体类
 * @author： shaobao
 * @date： Created on 2018/10/31 23:55
 * @version： v1.0
 * @modified By:
 **/
public class SysDepartmentPost implements Serializable {


    private static final long serialVersionUID = 5393600301120145656L;

    private String id; //部门岗位id

    private String departmentId; //部门id

    private String departmentName; //部门名称

    private Date departmentCreateTime;  //创建时间

    private String departmentCreator; //部门创造者

    private String departmentStatus;  // 状态 1:有效,0:无效

    private String postId; //岗位id

    private String postName; //岗位名称

    private String postCreator; //岗位创造者

    private Date postCreateTime; // 创建时间

    private String postStatus; //状态 1:有效 0:无效

    private String isDefault; // 是否默认

    public SysDepartmentPost() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SysDepartmentPost(String id, String departmentId, String departmentName, Date departmentCreateTime,
                             String departmentCreator, String departmentStatus, String postId, String postName,
                             String postCreator, Date postCreateTime, String postStatus, String isDefault) {
        this.id = id;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCreateTime = departmentCreateTime;
        this.departmentCreator = departmentCreator;
        this.departmentStatus = departmentStatus;
        this.postId = postId;
        this.postName = postName;
        this.postCreator = postCreator;
        this.postCreateTime = postCreateTime;
        this.postStatus = postStatus;
        this.isDefault = isDefault;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getDepartmentCreateTime() {
        return departmentCreateTime;
    }

    public void setDepartmentCreateTime(Date departmentCreateTime) {
        this.departmentCreateTime = departmentCreateTime;
    }

    public String getDepartmentCreator() {
        return departmentCreator;
    }

    public void setDepartmentCreator(String departmentCreator) {
        this.departmentCreator = departmentCreator;
    }

    public String getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(String departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getPostCreator() {
        return postCreator;
    }

    public void setPostCreator(String postCreator) {
        this.postCreator = postCreator;
    }

    public Date getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "SysDepartmentPost{" +
                "id='" + id + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCreateTime=" + departmentCreateTime +
                ", departmentCreator='" + departmentCreator + '\'' +
                ", departmentStatus='" + departmentStatus + '\'' +
                ", postId='" + postId + '\'' +
                ", postName='" + postName + '\'' +
                ", postCreator='" + postCreator + '\'' +
                ", postCreateTime=" + postCreateTime +
                ", postStatus='" + postStatus + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
