package com.jn.oa.item.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划编辑实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/19 19:22
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanEdit", description = "工作计划编辑实体")
public class WorkPlanEdit implements Serializable {
    private static final long serialVersionUID = -1618754603454723159L;

    @ApiModelProperty(value = "id", required = true, example = "\"10000\"")
    @NotNull(message = "工作计划id不能为空")
    private String id;

    @ApiModelProperty(value = "项目id", required = true, example = "\"10000\"")
    @NotNull(message = "项目id不能为空")
    private String itemId;

    @ApiModelProperty(value = "工作计划名称", required = true, example = "工作计划1")
    @NotNull(message = "工作计划名称不能为空")
    private String workPlanName;

    @ApiModelProperty(value = "工作计划内容", example = "工作计划内容测试")
    private String content;

    @ApiModelProperty(value = "需求描述", example = "工作计划需求描述测试")
    private String demandDescribe;

    @ApiModelProperty(value = "计划开始时间", required = true, example = "2019-12-12")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @NotNull(message = "计划开始时间不能为空")
    private Date planStartTime;

    @ApiModelProperty(value = "计划结束时间", required = true, example = "2019-12-13")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @NotNull(message = "计划结束时间不能为空")
    private Date planEndTime;

    @ApiModelProperty(value = "实际开始时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty(value = "实际结束时间", example = "2019-12-13 12:12:13")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty(value = "计划工时", required = true, example = "30")
    @NotNull(message = "计划工时不能为空")
    private Integer planTime;

    @ApiModelProperty(value = "总消耗工时", required = true, example = "10")
    @NotNull(message = "总消耗工时不能为空")
    private Integer totalConsumeTime;

    @ApiModelProperty(value = "总剩余工时", required = true, example = "20")
    @NotNull(message = "总剩余工时不能为空")
    private Integer totalRemainTime;

    @ApiModelProperty(value = "任务状态(0未开始,1进行中,2已挂起,3已完成,4已延期)", example = "1")
    @NotNull(message = "任务状态不能为空")
    private String workPlanStatus;

    @ApiModelProperty(value = "附件",
            example = "\"[{\"title\":\"附件\",\"url\":\"https://www.baidu.com/img/dong_09e2cf5ed88fbc0093809ab8d37faf6e.gif\"}]\"")
    private String attachment;

    @ApiModelProperty(value = "工作计划负责人账号，多个账号以逗号隔开", required = true, example = "liuxiong,wangsong")
    @NotNull(message = "用户负责人不能为空")
    private String responsibleUserAccount;

    @ApiModelProperty(value = "备注", example = "编辑测试,备注信息")
    private String remark;

    public WorkPlanEdit() {
    }

    public WorkPlanEdit(String id, String itemId, String workPlanName, String content, String demandDescribe,
                        Date planStartTime, Date planEndTime, Date startTime, Date endTime, Integer planTime,
                        Integer totalConsumeTime, Integer totalRemainTime, String workPlanStatus,
                        String attachment, String responsibleUserAccount, String remark) {
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
        this.attachment = attachment;
        this.responsibleUserAccount = responsibleUserAccount;
        this.remark = remark;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getResponsibleUserAccount() {
        return responsibleUserAccount;
    }

    public void setResponsibleUserAccount(String responsibleUserAccount) {
        this.responsibleUserAccount = responsibleUserAccount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "WorkPlanEdit{" +
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
                ", attachment='" + attachment + '\'' +
                ", responsibleUserAccount='" + responsibleUserAccount + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
