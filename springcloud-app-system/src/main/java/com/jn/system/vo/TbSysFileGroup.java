package com.jn.system.vo;

import java.util.Date;

/**
 * 文件组表
 */
public class TbSysFileGroup {
    private String id; //文件组id

    private String fileGroupName; //文件组名称

    private Date createTime; // 创建时间

    private String status; //状态 1:有效 0:无效

    public TbSysFileGroup() {
    }

    public TbSysFileGroup(String id, String fileGroupName, Date createTime, String status) {
        this.id = id;
        this.fileGroupName = fileGroupName;
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

    @Override
    public String toString() {
        return "TbSysFileGroup{" +
                "id='" + id + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}