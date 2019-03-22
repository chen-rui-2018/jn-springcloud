package com.jn.oa.item.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/4 9:41
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlan", description = "工作计划实体")
public class WorkPlan implements Serializable {
    private static final long serialVersionUID = -168687554083194167L;

    @ApiModelProperty(value = "工作计划id")
    private String id;

    @ApiModelProperty(value = "项目id")
    private String itemId;

    @ApiModelProperty(value = "工作计划名称")
    private String workPlanName;

    @ApiModelProperty(value = "工作计划内容")
    private String content;

    @ApiModelProperty(value = "工作计划需求描述")
    private String demandDescribe;

    @ApiModelProperty(value = "工作计划预计开始时间")
    private Date planStartTime;

    @ApiModelProperty(value = "工作计划预计结束时间")
    private Date planEndTime;

    @ApiModelProperty(value = "工作计划实际开始时间")
    private Date startTime;

    @ApiModelProperty(value = "工作计划实际结束时间")
    private Date endTime;

    @ApiModelProperty(value = "计划工时")
    private Integer planTime;

    @ApiModelProperty(value = "消耗总时间")
    private Integer totalConsumeTime;

    @ApiModelProperty(value = "剩余总时间")
    private Integer totalRemainTime;

    @ApiModelProperty(value = "任务状态(0未开始,1进行中,2已挂起,3已完成,4已延期)")
    private String workPlanStatus;

    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value = "附件",
            example = "[{\"title\":\"附件\",\"url\":\"https://www.baidu.com/img/dong_09e2cf5ed88fbc0093809ab8d37faf6e.gif\"}]")
    private String attachment;

    @ApiModelProperty(value = "创建人账号")
    private String creatorAccount;

    @ApiModelProperty(value = "修改人账号")
    private String modifierAccount;

    @ApiModelProperty(value = "修改创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    public WorkPlan() {
    }

    public WorkPlan(String id, String itemId, String workPlanName, String content, String demandDescribe,
                    Date planStartTime, Date planEndTime, Date startTime, Date endTime, Integer planTime,
                    Integer totalConsumeTime, Integer totalRemainTime, String workPlanStatus, Byte recordStatus,
                    String attachment, String creatorAccount, String modifierAccount, Date createdTime,
                    Date modifiedTime) {
        this.id = id;
        this.itemId = itemId;
        this.workPlanName = workPlanName;
        this.content = content;
        this.demandDescribe = demandDescribe;
        this.planStartTime = planStartTime;
        this.planEndTime = planEndTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.planTime = planTime;
        this.totalConsumeTime = totalConsumeTime;
        this.totalRemainTime = totalRemainTime;
        this.workPlanStatus = workPlanStatus;
        this.recordStatus = recordStatus;
        this.attachment = attachment;
        this.creatorAccount = creatorAccount;
        this.modifierAccount = modifierAccount;
        this.createdTime = createdTime;
        this.modifiedTime = modifiedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getWorkPlanName() {
        return workPlanName;
    }

    public void setWorkPlanName(String workPlanName) {
        this.workPlanName = workPlanName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDemandDescribe() {
        return demandDescribe;
    }

    public void setDemandDescribe(String demandDescribe) {
        this.demandDescribe = demandDescribe;
    }

    public Date getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    public Date getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
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

    public Integer getPlanTime() {
        return planTime;
    }

    public void setPlanTime(Integer planTime) {
        this.planTime = planTime;
    }

    public Integer getTotalConsumeTime() {
        return totalConsumeTime;
    }

    public void setTotalConsumeTime(Integer totalConsumeTime) {
        this.totalConsumeTime = totalConsumeTime;
    }

    public Integer getTotalRemainTime() {
        return totalRemainTime;
    }

    public void setTotalRemainTime(Integer totalRemainTime) {
        this.totalRemainTime = totalRemainTime;
    }

    public String getWorkPlanStatus() {
        return workPlanStatus;
    }

    public void setWorkPlanStatus(String workPlanStatus) {
        this.workPlanStatus = workPlanStatus;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "WorkPlan{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", workPlanName='" + workPlanName + '\'' +
                ", content='" + content + '\'' +
                ", demandDescribe='" + demandDescribe + '\'' +
                ", planStartTime=" + planStartTime +
                ", planEndTime=" + planEndTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", planTime=" + planTime +
                ", totalConsumeTime=" + totalConsumeTime +
                ", totalRemainTime=" + totalRemainTime +
                ", workPlanStatus='" + workPlanStatus + '\'' +
                ", recordStatus=" + recordStatus +
                ", attachment='" + attachment + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
