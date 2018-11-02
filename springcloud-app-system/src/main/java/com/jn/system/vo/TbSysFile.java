package com.jn.system.vo;

import java.util.Date;

/**
 * 文件表
 */
public class TbSysFile {
    private String id; //文件表id

    private String fileName; //文件名称

    private String fileUrl; // 文件路径

    private Date createTime; // 创建时间

    private String status; // 状态 1:有效 0无效

    public TbSysFile() {
    }

    public TbSysFile(String id, String fileName, String fileUrl, Date createTime, String status) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
        this.createTime = createTime;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
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
        return "TbSysFile{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}