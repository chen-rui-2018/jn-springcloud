package com.jn.system.vo;

import java.util.Date;

/**
 * 文件组文件关联表
 */
public class TbSysFileGroupFile {
    private String id; //id

    private String fileGroupId; //文件组id

    private String fileId; // 文件id

    private Date createTime; //创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysFileGroupFile() {
    }

    public TbSysFileGroupFile(String id, String fileGroupId, String fileId, Date createTime, String status) {
        this.id = id;
        this.fileGroupId = fileGroupId;
        this.fileId = fileId;
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

    @Override
    public String toString() {
        return "TbSysFileGroupFile{" +
                "id='" + id + '\'' +
                ", fileGroupId='" + fileGroupId + '\'' +
                ", fileId='" + fileId + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}