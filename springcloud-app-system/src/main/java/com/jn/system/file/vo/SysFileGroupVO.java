package com.jn.system.file.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel(value = "SysFileGroupVO",description = "文件组vo")
public class SysFileGroupVO implements Serializable {
    private static final long serialVersionUID = -6429287926788524602L;
    private String id;

    /**
     * 文件组名称
     */
    @ApiModelProperty("文件组名称")
    private String fileGroupName;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creator;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty("状态 1:有效 0:无效 -1:删除")
    private String status;

    public SysFileGroupVO() {
    }

    public SysFileGroupVO(String id, String fileGroupName, String creator, Date createTime, String status) {
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

    @Override
    public String toString() {
        return "SysFileGroupVO{" +
                "id='" + id + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", status='" + status + '\'' +
                '}';
    }
}
