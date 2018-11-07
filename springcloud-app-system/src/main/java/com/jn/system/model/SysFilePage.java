package com.jn.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFilePage" ,description = "文件分页实体")
public class SysFilePage extends Page implements Serializable {
    private static final long serialVersionUID = 7252981735944287742L;

    @ApiModelProperty(value = "id" )
    private String id;

    /**
     * 文件名称
     */
    @ApiModelProperty(value = "文件名称" )
    private String fileName;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径" )
    private String fileUrl;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人" )
    private String creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间" )
    private Date createTime;

    /**
     * 状态 1:有效 0:无效 -1:删除
     */
    @ApiModelProperty(value = "状态 1:有效 0:无效 -1:删除" )
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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
}
