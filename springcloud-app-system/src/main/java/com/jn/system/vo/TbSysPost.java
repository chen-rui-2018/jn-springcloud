package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位表
 */
public class TbSysPost implements Serializable {

    private static final long serialVersionUID = -4700078673130094037L;
    private String id;

    private String postName; //岗位名称

    private String creator;

    private Date createTime; // 创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysPost() {

    }


    public TbSysPost(String id, String postName, String creator, Date createTime, String status) {
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
        return "TbSysPost{" +
                "id='" + id + '\'' +
                ", postName='" + postName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}