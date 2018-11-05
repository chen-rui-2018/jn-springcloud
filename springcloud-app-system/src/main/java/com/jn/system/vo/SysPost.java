package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:岗位实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysPost implements Serializable {
    private static final long serialVersionUID = -4700078673130094037L;
    /**
     * id
     */
    private String id;
    /**
     * 岗位名称
     */
    private String postName;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1删除
     */
    private String status;

    public SysPost() {

    }


    public SysPost(String id, String postName, String creator, Date createTime, String status) {
        this.id = id;
        this.postName = postName;
        this.creator = creator;
        this.createTime = createTime;
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

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
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
        return "SysPost{" +
                "id='" + id + '\'' +
                ", postName='" + postName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}