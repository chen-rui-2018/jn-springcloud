package com.jn.system.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO:文件实体类
 *
 * @author： shaobao
 * @date： Created on 2018/11/5 9:52
 * @version： v1.0
 * @modified By:
 **/
public class SysFile implements Serializable {
    private static final long serialVersionUID = 2304931228385092627L;
    /**
     * 文件表id
     */
    private String id;
    /**
     * 文件名称
     */
    private String fileName;
    /**
     * 文件路径
     */
    private String fileUrl;
    /**
     * 创建者
     */
    private String  creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;

    public SysFile() {
    }

    public SysFile(String id, String fileName, String fileUrl, String creator, Date createTime, String status) {
        this.id = id;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "SysFile{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileUrl='" + fileUrl + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}