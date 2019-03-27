package com.jn.oa.item.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 修改工作计划状态实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/5 10:12
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanUpdateStatus", description = "修改工作计划状态实体")
public class WorkPlanUpdateStatus implements Serializable {
    private static final long serialVersionUID = -844408024421886033L;

    @ApiModelProperty(value = "工作计划id", required = true, example = "\"10000\"")
    @NotNull(message = "工作计划id不能为空")
    private String id;

    @ApiModelProperty(value = "消耗总时间", example = "20")
    private Integer totalConsumeTime;

    @ApiModelProperty(value = "剩余总时间", example = "10")
    private Integer totalRemainTime;

    @ApiModelProperty(value = "任务状态(0未开始,1进行中,2已挂起,3已完成,5.添加备注,6继续)", required = true, example = "\"1\"")
    @NotNull(message = "工作计划状态不能为空")
    private String workPlanStatus;

    @ApiModelProperty(value = "工作计划实际开始时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ApiModelProperty(value = "工作计划实际结束时间", example = "2019-12-12 12:12:12")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    @ApiModelProperty(value = "附件",
            example = "\"[{\"title\":\"附件\",\"url\":\"https://www.baidu.com/img/dong_09e2cf5ed88fbc0093809ab8d37faf6e.gif\"}]\"")
    private String attachment;

    @ApiModelProperty(value = "备注", example = "这是工作计划的备注测试")
    private String remark;

    public WorkPlanUpdateStatus() {
    }

    public WorkPlanUpdateStatus(String id, Integer totalConsumeTime, Integer totalRemainTime, String workPlanStatus,
                                Date startTime, Date endTime, String attachment, String remark) {
        this.id = id;
        this.totalConsumeTime = totalConsumeTime;
        this.totalRemainTime = totalRemainTime;
        this.workPlanStatus = workPlanStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.attachment = attachment;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWorkPlanStatus() {
        return workPlanStatus;
    }

    public void setWorkPlanStatus(String workPlanStatus) {
        this.workPlanStatus = workPlanStatus;
    }

    @Override
    public String toString() {
        return "WorkPlanUpdateStatus{" +
                "id='" + id + '\'' +
                ", totalConsumeTime=" + totalConsumeTime +
                ", totalRemainTime=" + totalRemainTime +
                ", workPlanStatus='" + workPlanStatus + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", attachment='" + attachment + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
