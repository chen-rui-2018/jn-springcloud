package com.jn.system.vo;


import com.jn.common.util.enums.EnumUtil;
import com.jn.system.enums.SysStatusEnums;
import com.jn.system.model.SysFileGroup;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 文件vo
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:19
 * @version： v1.0
 * @modified By:
 */
public class SysFileVO implements Serializable {
    private static final long serialVersionUID = -7789819491793048921L;
    /**
     * 文件id
     */
    private String fileId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 文件路径
     */
    private String fileUrl;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    private String status;

    /**
     * 状态描述
     */
    private String statusDesc;

    /**
     * 文件所属文件组
     */
    private List<SysFileGroup> fileGroupList;


    public String getStatusDesc() {
        return EnumUtil.getByKey(status, SysStatusEnums.class).getValue();
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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
        this.status = status == null ? null : status.trim();
    }

    public List<SysFileGroup> getFileGroupList() {
        return fileGroupList;
    }

    public void setFileGroupList(List<SysFileGroup> fileGroupList) {
        this.fileGroupList = fileGroupList;
    }
}
