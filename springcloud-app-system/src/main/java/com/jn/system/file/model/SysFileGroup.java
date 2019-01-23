package com.jn.system.file.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 文件组实体
 *
 * @author： yuanyy
 * @date： Created on 2018/11/1 10:40
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "SysFileGroup", description = "文件组信息")
public class SysFileGroup implements Serializable {

    private static final long serialVersionUID = 3190737665694460176L;
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 文件组名称
     */
    @ApiModelProperty(value = "文件组名称")
    @NotBlank(message = "文件组名称不能为空！")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w]{1,20}$", message = "文件组名称校验失败")
    private String fileGroupName;

    /**
     * 文件组名称
     */
    @ApiModelProperty(value = "文件组描述")
    @Size(max = 150, message = "文件组描述,字数不能超过150个字")
    private String fileGroupDescribe;

    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String creatorAccount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    /**
     * 状态，0删除，1有效，2无效
     */
    @ApiModelProperty("状态，0删除，1有效，2无效")
    @NotNull(message = "状态值不能为空")
    private Byte recordStatus;

    public SysFileGroup() {
    }

    public SysFileGroup(String id, String fileGroupName, String fileGroupDescribe,
                        String creatorAccount, Date createdTime, Byte recordStatus) {
        this.id = id;
        this.fileGroupName = fileGroupName;
        this.fileGroupDescribe = fileGroupDescribe;
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

    public String getFileGroupDescribe() {
        return fileGroupDescribe;
    }

    public void setFileGroupDescribe(String fileGroupDescribe) {
        this.fileGroupDescribe = fileGroupDescribe;
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
        return "SysFileGroup{" +
                "id='" + id + '\'' +
                ", fileGroupName='" + fileGroupName + '\'' +
                ", fileGroupDescribe='" + fileGroupDescribe + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", recordStatus=" + recordStatus +
                '}';
    }
}