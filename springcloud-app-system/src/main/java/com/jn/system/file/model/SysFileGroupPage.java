package com.jn.system.file.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 文件组分页实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/6 10:15
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileGroupPage", description = "文件组分页实体")
public class SysFileGroupPage extends Page implements Serializable {

    private static final long serialVersionUID = 1964622157773498642L;

    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 文件组名称
     */
    @ApiModelProperty(value = "文件组名称")
    private String fileGroupName;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createdTime;

    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    private Byte recordStatus;

    public SysFileGroupPage() {
    }

    public SysFileGroupPage(String id, String fileGroupName, String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.fileGroupName = fileGroupName;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.recordStatus = recordStatus;
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

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "SysFileGroupPage{" +
                "id='" + id + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
