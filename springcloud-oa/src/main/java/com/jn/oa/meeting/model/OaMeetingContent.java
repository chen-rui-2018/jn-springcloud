package com.jn.oa.meeting.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议申请内容
 *
 * @author： yuanyy
 * @date： Created on 2019/2/18 15:52
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingContent", description = "会议申请内容实体")
public class OaMeetingContent  implements Serializable {

    private static final long serialVersionUID = 7252981735944287744L;

    @ApiModelProperty(value = "会议申请内容id")
    private String id;

    @ApiModelProperty(value = "会议申请id")
    private String meetingId;

    @ApiModelProperty(value = "会议内容状态（0：删除，1：正常）")
    private Byte recordStatus;

    @ApiModelProperty(value = "创建人")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "修改人")
    private String modifierAccount;

    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "会议申请内容")
    private String content;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(String meetingId) {
        this.meetingId = meetingId;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
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

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
