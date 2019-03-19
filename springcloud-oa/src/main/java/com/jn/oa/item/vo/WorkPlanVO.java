package com.jn.oa.item.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划VO
 * @author： shaobao
 * @date： Created on 2019/2/20 17:25
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanVO", description = "工作计划VO")
public class WorkPlanVO implements Serializable {
    private static final long serialVersionUID = 1757363777123032299L;
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("项目id")
    private String itemId;
    @ApiModelProperty("项目名称")
    private String itemName;
    @ApiModelProperty("工作计划名称")
    private String workPlanName;
    @ApiModelProperty("工作计划内容")
    private String content;
    @ApiModelProperty("需求描述")
    private String demandDescribe;
    @ApiModelProperty("计划开始时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planStartTime;
    @ApiModelProperty("计划结束时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planEndTime;
    @ApiModelProperty("实际开始时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
    @ApiModelProperty("实际结束时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
    @ApiModelProperty("计划工时")
    private Integer planTime;
    @ApiModelProperty("总消耗工时")
    private Integer totalConsumeTime;
    @ApiModelProperty("总剩余工时")
    private Integer totalRemainTime;
    @ApiModelProperty("任务状态(1未开始,2进行中,3已挂起,4已完成,5已延期)")
    private String workPlanStatus;
    @ApiModelProperty("是否删除（0标记删除，1正常)")
    private Byte recordStatus;
    @ApiModelProperty("附件")
    private String attachment;
    @ApiModelProperty("创建人账号")
    private String creatorAccount;
    @ApiModelProperty("创建人时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;
    @ApiModelProperty("工作计划负责人账号，多个账号以逗号隔开")
    private String responsibleUserAccount;
    @ApiModelProperty("工作计划负责人名称，多个负责人名称以逗号隔开")
    private String responsibleUserName;

    public WorkPlanVO() {
    }

    public WorkPlanVO(String id, String itemId, String itemName, String workPlanName, String content,
                      String demandDescribe, Date planStartTime, Date planEndTime, Date startTime,
                      Date endTime, Integer planTime, Integer totalConsumeTime, Integer totalRemainTime,
                      String workPlanStatus, Byte recordStatus, String attachment, String creatorAccount,
                      Date createdTime, String responsibleUserAccount, String responsibleUserName) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
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
        this.createdTime = createdTime;
        this.responsibleUserAccount = responsibleUserAccount;
        this.responsibleUserName = responsibleUserName;
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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getResponsibleUserName() {
        return responsibleUserName;
    }

    public void setResponsibleUserName(String responsibleUserName) {
        this.responsibleUserName = responsibleUserName;
    }

    public String getResponsibleUserAccount() {
        return responsibleUserAccount;
    }

    public void setResponsibleUserAccount(String responsibleUserAccount) {
        this.responsibleUserAccount = responsibleUserAccount;
    }

    @Override
    public String toString() {
        return "WorkPlanVO{" +
                "id='" + id + '\'' +
                ", itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
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
                ", createdTime=" + createdTime +
                ", responsibleUserAccount='" + responsibleUserAccount + '\'' +
                ", responsibleUserName='" + responsibleUserName + '\'' +
                '}';
    }
}
