package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:文件文件组实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysFileGroupFile implements Serializable {
    private static final long serialVersionUID = -210328037296057198L;
    /**
     * id
     */
    private String id;
    /**
     * 文件组id
     */
    private String fileGroupId;
    /**
     * 文件id
     */
    private String fileId;
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

    public SysFileGroupFile() {
    }

    public SysFileGroupFile(String id, String fileGroupId, String fileId, String creator,
                            Date createTime, String status) {
        this.id = id;
        this.fileGroupId = fileGroupId;
        this.fileId = fileId;
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

    public String getFileGroupId() {
        return fileGroupId;
    }

    public void setFileGroupId(String fileGroupId) {
        this.fileGroupId = fileGroupId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
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
        return "SysFileGroupFile{" +
                "id='" + id + '\'' +
                ", fileGroupId='" + fileGroupId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}