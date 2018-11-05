package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:文件组类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysFileGroup implements Serializable {
    private static final long serialVersionUID = -4676519264453291735L;
    /**
     * 文件组id
     */
    private String id;
    /**
     * 文件组名称
     */
    private String fileGroupName;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效,-1删除
     */
    private String status;

    public SysFileGroup() {
    }

    public SysFileGroup(String id, String fileGroupName, String creator, Date createTime, String status) {
        this.id = id;
        this.fileGroupName = fileGroupName;
        this.creator = creator;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileGroupName() {
        return fileGroupName;
    }

    public void setFileGroupName(String fileGroupName) {
        this.fileGroupName = fileGroupName;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysFileGroup{" +
                "id='" + id + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}