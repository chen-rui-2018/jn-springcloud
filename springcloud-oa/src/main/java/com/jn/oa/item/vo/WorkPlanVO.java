package com.jn.oa.item.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jn.oa.item.model.WorkPlanHistory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 工作计划VO
 *
 * @author： shaobao
 * @date： Created on 2019/2/20 17:25
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanVO", description = "工作计划VO")
public class WorkPlanVO implements Serializable {
    private static final long serialVersionUID = 1757363777123032299L;
    @ApiModelProperty(value = "id", example = "10000")
    private String id;

    @ApiModelProperty(value = "项目id", example = "10000")
    private String itemId;

    @ApiModelProperty(value = "项目名称")
    private String itemName;

    @ApiModelProperty(value = "工作计划名称", example = "工作计划1")
    private String workPlanName;

    @ApiModelProperty("工作计划内容")
    private String content;

    @ApiModelProperty(value = "需求描述", example = "工作计划需求描述测试")
    private String demandDescribe;

    @ApiModelProperty(value = "计划开始时间", example = "2019-12-12 12:12:12")
    private String planStartTime;

    @ApiModelProperty(value = "计划结束时间", example = "2019-12-13 12:13:13")
    private String planEndTime;

    @ApiModelProperty(value = "实际开始时间", example = "2019-12-12 12:12:12")
    private String startTime;

    @ApiModelProperty(value = "实际结束时间", example = "2019-12-13 12:12:13")
    private String endTime;

    @ApiModelProperty(value = "计划工时", example = "30")
    private Integer planTime;

    @ApiModelProperty(value = "总消耗工时", example = "10")
    private Integer totalConsumeTime;

    @ApiModelProperty(value = "总剩余工时", example = "20")
    private Integer totalRemainTime;

    @ApiModelProperty(value = "任务状态(0未开始,1进行中,2已挂起,3已完成,4已延期)", example = "1")
    private String workPlanStatus;

    @ApiModelProperty(value = "任务状态值")
    private String workPlanStatusMessage;

    @ApiModelProperty(value = "是否延期")
    private String isExpire;

    @ApiModelProperty(value = "是否延期状态值")
    private String isExpireMessage;

    @ApiModelProperty("是否删除（0标记删除，1正常)")
    private Byte recordStatus;

    @ApiModelProperty(value = "附件",
            example = "[{\"title\":\"附件\",\"url\":\"https://www.baidu.com/img/dong_09e2cf5ed88fbc0093809ab8d37faf6e.gif\"}]")
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

    @ApiModelProperty(value = "工作计划历史记录集合", example = "liuxiong,wangsong")
    private List<WorkPlanHistory> workPlanHistorys;

    public WorkPlanVO() {
    }

    public WorkPlanVO(String id, String itemId, String itemName, String workPlanName, String content,
                      String demandDescribe, String planStartTime, String planEndTime, String startTime,
                      String endTime, Integer planTime, Integer totalConsumeTime,
                      Integer totalRemainTime, String workPlanStatus, String workPlanStatusMessage,
                      String isExpire, String isExpireMessage, Byte recordStatus, String attachment,
                      String creatorAccount, Date createdTime, String responsibleUserAccount,
                      String responsibleUserName, List<WorkPlanHistory> workPlanHistorys) {
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
        this.workPlanStatusMessage = workPlanStatusMessage;
        this.isExpire = isExpire;
        this.isExpireMessage = isExpireMessage;
        this.recordStatus = recordStatus;
        this.attachment = attachment;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.responsibleUserAccount = responsibleUserAccount;
        this.responsibleUserName = responsibleUserName;
        this.workPlanHistorys = workPlanHistorys;
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

    public String getPlanStartTime() {
        return planStartTime;
    }

    public void setPlanStartTime(String planStartTime) {
        this.planStartTime = planStartTime;
    }

    public String getPlanEndTime() {
        return planEndTime;
    }

    public void setPlanEndTime(String planEndTime) {
        this.planEndTime = planEndTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
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

    public String getWorkPlanStatusMessage() {
        return workPlanStatusMessage;
    }

    public void setWorkPlanStatusMessage(String workPlanStatusMessage) {
        this.workPlanStatusMessage = workPlanStatusMessage;
    }

    public String getIsExpire() {
        return isExpire;
    }

    public void setIsExpire(String isExpire) {
        this.isExpire = isExpire;
    }

    public String getIsExpireMessage() {
        return isExpireMessage;
    }

    public void setIsExpireMessage(String isExpireMessage) {
        this.isExpireMessage = isExpireMessage;
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

    public String getResponsibleUserAccount() {
        return responsibleUserAccount;
    }

    public void setResponsibleUserAccount(String responsibleUserAccount) {
        this.responsibleUserAccount = responsibleUserAccount;
    }

    public String getResponsibleUserName() {
        return responsibleUserName;
    }

    public void setResponsibleUserName(String responsibleUserName) {
        this.responsibleUserName = responsibleUserName;
    }

    public List<WorkPlanHistory> getWorkPlanHistorys() {
        return workPlanHistorys;
    }

    public void setWorkPlanHistorys(List<WorkPlanHistory> workPlanHistorys) {
        this.workPlanHistorys = workPlanHistorys;
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
                ", planStartTime='" + planStartTime + '\'' +
                ", planEndTime='" + planEndTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", planTime=" + planTime +
                ", totalConsumeTime=" + totalConsumeTime +
                ", totalRemainTime=" + totalRemainTime +
                ", workPlanStatus='" + workPlanStatus + '\'' +
                ", workPlanStatusMessage='" + workPlanStatusMessage + '\'' +
                ", isExpire='" + isExpire + '\'' +
                ", isExpireMessage='" + isExpireMessage + '\'' +
                ", recordStatus=" + recordStatus +
                ", attachment='" + attachment + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", responsibleUserAccount='" + responsibleUserAccount + '\'' +
                ", responsibleUserName='" + responsibleUserName + '\'' +
                ", workPlanHistorys=" + workPlanHistorys +
                '}';
    }
}
