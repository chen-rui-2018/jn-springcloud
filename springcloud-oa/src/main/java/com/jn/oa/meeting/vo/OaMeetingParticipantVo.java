package com.jn.oa.meeting.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.oa.meeting.entity.TbOaMeetingParticipants;
import com.jn.oa.meeting.entity.TbOaMeetingRoom;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 会议室实体
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingParticipantVo", description = "会议纪录分页实体")
public class OaMeetingParticipantVo implements Serializable {
    private static final long serialVersionUID = 7252981735944287744L;

    @ApiModelProperty(value = "会议id")
    private String id;

    @ApiModelProperty(value = "会议主题（工单名称）")
    private String title;


    @ApiModelProperty(value = "开始日期")
    @JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
    private Date startDate;

    @ApiModelProperty(value = "开始时间")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    @ApiModelProperty(value = "会议室id")
    private String meetingRoomId;

    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value = "创建人")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "修改人")
    private String modifierAccount;

    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "参会人员")
    private String participantsStr;

    @ApiModelProperty(value = "申请人")
    private String applicant;

    @ApiModelProperty(value = "申请时间")
    private Date applicationTime;

    @ApiModelProperty(value = "签到二维码")
    private String signInQr;

    @ApiModelProperty(value = "微信提醒（0:不提醒、1:提醒）")
    private String wechatRemind;

    @ApiModelProperty(value = "短信提醒（0:不提醒、1:提醒）")
    private String messageRemind;

    @ApiModelProperty(value = "pc提醒（0:不提醒、1:提醒）")
    private String pcRemind;

    @ApiModelProperty(value = "app提醒（0:不提醒、1:提醒）")
    private String appRemind;

    @ApiModelProperty(value = "是否提醒（0:否、1:是）")
    private String isRemind;

    @ApiModelProperty(value = "会议内容")
    private String oaMeetingContent;

    @ApiModelProperty(value = "会议室")
    private TbOaMeetingRoom tbOaMeetingRoom;

    @ApiModelProperty(value = "会议申请内容")
    private String content;

    @ApiModelProperty(value = "预约人用户名")
    private String userName;

    @ApiModelProperty(value = "预约人部门")
    private String departmentName;

    @ApiModelProperty(value = "组织人")
    private String organizationalUserName;

    @ApiModelProperty(value = "组织人部门")
    private String organizationalDepartmentName;

    @ApiModelProperty(value = "组织部门id")
    private String organizationalId;

    @ApiModelProperty(value = "组织人id")
    private String organizationalUserId;

    @ApiModelProperty(value = "会议状态（0:待开始、1:进行中、2:已完成、3:已取消）")
    private String meetingStatus;

    @ApiModelProperty(value = "附件url")
    private String fileUrl;

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getOrganizationalId() {
        return organizationalId;
    }

    public String getOrganizationalUserId() {
        return organizationalUserId;
    }

    public void setOrganizationalUserId(String organizationalUserId) {
        this.organizationalUserId = organizationalUserId;
    }

    public void setOrganizationalId(String organizationalId) {
        this.organizationalId = organizationalId;
    }

    public String getOrganizationalUserName() {
        return organizationalUserName;
    }

    public void setOrganizationalUserName(String organizationalUserName) {
        this.organizationalUserName = organizationalUserName;
    }

    public String getOrganizationalDepartmentName() {
        return organizationalDepartmentName;
    }

    public void setOrganizationalDepartmentName(String organizationalDepartmentName) {
        this.organizationalDepartmentName = organizationalDepartmentName;
    }

    public TbOaMeetingRoom getTbOaMeetingRoom() {
        return tbOaMeetingRoom;
    }

    public void setTbOaMeetingRoom(TbOaMeetingRoom tbOaMeetingRoom) {
        this.tbOaMeetingRoom = tbOaMeetingRoom;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getOaMeetingContent() {
        return oaMeetingContent;
    }

    public void setOaMeetingContent(String oaMeetingContent) {
        this.oaMeetingContent = oaMeetingContent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getMeetingRoomId() {
        return meetingRoomId;
    }

    public void setMeetingRoomId(String meetingRoomId) {
        this.meetingRoomId = meetingRoomId;
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

    public String getParticipantsStr() {
        return participantsStr;
    }

    public void setParticipantsStr(String participantsStr) {
        this.participantsStr = participantsStr;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getSignInQr() {
        return signInQr;
    }

    public void setSignInQr(String signInQr) {
        this.signInQr = signInQr;
    }

    public String getWechatRemind() {
        return wechatRemind;
    }

    public void setWechatRemind(String wechatRemind) {
        this.wechatRemind = wechatRemind;
    }

    public String getMessageRemind() {
        return messageRemind;
    }

    public void setMessageRemind(String messageRemind) {
        this.messageRemind = messageRemind;
    }

    public String getPcRemind() {
        return pcRemind;
    }

    public void setPcRemind(String pcRemind) {
        this.pcRemind = pcRemind;
    }

    public String getAppRemind() {
        return appRemind;
    }

    public void setAppRemind(String appRemind) {
        this.appRemind = appRemind;
    }

    public String getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(String isRemind) {
        this.isRemind = isRemind;
    }
}
