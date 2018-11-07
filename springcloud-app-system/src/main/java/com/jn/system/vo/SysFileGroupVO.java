package com.jn.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.util.enums.EnumUtil;
import com.jn.system.enums.SysStatusEnums;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件组vo
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:14
 * @version： v1.0
 * @modified By:
 */
public class SysFileGroupVO implements Serializable {
    private static final long serialVersionUID = -6429287926788524602L;
    private String id;

    /**
     * 文件组名称
     */
    private String fileGroupName;

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



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFileGroupName() {
        return fileGroupName;
    }

    public void setFileGroupName(String fileGroupName) {
        this.fileGroupName = fileGroupName == null ? null : fileGroupName.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
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

    public String getStatusDesc() {
        return EnumUtil.getByKey(status,SysStatusEnums.class).getValue();
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
