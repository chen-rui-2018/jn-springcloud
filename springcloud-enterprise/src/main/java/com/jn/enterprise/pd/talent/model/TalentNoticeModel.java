package com.jn.enterprise.pd.talent.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 人才服务公告实体类
 *
 * @author： wzy
 * @date： Created on 2019/4/10 10:12
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "TalentNoticeModel", description = "人才服务公告实体类")
public class TalentNoticeModel extends Page implements Serializable {
    private static final long serialVersionUID = -4770449500384923742L;

    @ApiModelProperty(value = "公告id",  example = "563303936585367552")
    private String id;

    @ApiModelProperty(value = "公告标题", example = "政策来啦")
    private String noticeTitle;

    @ApiModelProperty(value = "所属类型ID",example = "10000")
    private String rangeId;

    @ApiModelProperty(value = "所属类型名称",example = "人才服务指南")
    private String rangeName;

    @ApiModelProperty(value = "所属平台ID",example = "10000")
    private String subordinatePlatformId;

    @ApiModelProperty(value = "所属平台名称",example = "1")
    private String subordinatePlatformName;

    @ApiModelProperty(value = "截止时间",  example = "2019-04-20 00:00:00")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deadline;

    @ApiModelProperty(value = "截止描述",example = "很牛逼")
    private String timeNode;

    @ApiModelProperty(value = "是否置顶（1：置顶，2：不置顶）",example = "1")
    private Byte isRoofPlacement;

    @ApiModelProperty(value = "公告内容",example = "")
    private String announcementContent;

    @ApiModelProperty(value = "浏览次数",example = "0")
    private Integer browseTimes;

    @ApiModelProperty(value = "状态（1;草稿，2：已发布，3：已下架）",example = "3")
    private Byte status;

    @ApiModelProperty(value = "是否删除（0标记删除，1正常）",example = "1")
    private Byte recordStatus;

    @ApiModelProperty(value = "创建者账号",example = "1")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间",  example = "2019-04-04 10:07:46")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value = "最新更新者账号",example = "wangsong")
    private String modifierAccount;

    @ApiModelProperty(value = "最新更新时间", example = "2019-03-20 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getRangeId() {
        return rangeId;
    }

    public void setRangeId(String rangeId) {
        this.rangeId = rangeId;
    }

    public String getRangeName() {
        return rangeName;
    }

    public void setRangeName(String rangeName) {
        this.rangeName = rangeName;
    }

    public String getSubordinatePlatformId() {
        return subordinatePlatformId;
    }

    public void setSubordinatePlatformId(String subordinatePlatformId) {
        this.subordinatePlatformId = subordinatePlatformId;
    }

    public String getSubordinatePlatformName() {
        return subordinatePlatformName;
    }

    public void setSubordinatePlatformName(String subordinatePlatformName) {
        this.subordinatePlatformName = subordinatePlatformName;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getTimeNode() {
        return timeNode;
    }

    public void setTimeNode(String timeNode) {
        this.timeNode = timeNode;
    }

    public Byte getIsRoofPlacement() {
        return isRoofPlacement;
    }

    public void setIsRoofPlacement(Byte isRoofPlacement) {
        this.isRoofPlacement = isRoofPlacement;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public Integer getBrowseTimes() {
        return browseTimes;
    }

    public void setBrowseTimes(Integer browseTimes) {
        this.browseTimes = browseTimes;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public TalentNoticeModel(String id, String noticeTitle, String rangeId, String rangeName, String subordinatePlatformId, String subordinatePlatformName, Date deadline, String timeNode, Byte isRoofPlacement, String announcementContent, Integer browseTimes, Byte status, Byte recordStatus, String creatorAccount, Date createdTime, String modifierAccount, Date modifiedTime) {
        this.id = id;
        this.noticeTitle = noticeTitle;
        this.rangeId = rangeId;
        this.rangeName = rangeName;
        this.subordinatePlatformId = subordinatePlatformId;
        this.subordinatePlatformName = subordinatePlatformName;
        this.deadline = deadline;
        this.timeNode = timeNode;
        this.isRoofPlacement = isRoofPlacement;
        this.announcementContent = announcementContent;
        this.browseTimes = browseTimes;
        this.status = status;
        this.recordStatus = recordStatus;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.modifierAccount = modifierAccount;
        this.modifiedTime = modifiedTime;
    }
}
