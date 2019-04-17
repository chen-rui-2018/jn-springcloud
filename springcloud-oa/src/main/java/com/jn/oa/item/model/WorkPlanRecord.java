package com.jn.oa.item.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划工作记录添加实体
 *
 * @author： shaobao
 * @date： Created on 2019/2/25 9:13
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanRecord", description = "工作计划工作记录添加实体")
public class WorkPlanRecord implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "记录时间", required = true, example = "2019-03-20 12:12:12")
    @NotNull(message = "记录时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordDate;

    @ApiModelProperty(value = "工作计划id", required = true, example = "sadfhadfhkfdkksdj")
    @NotNull(message = "工作计划id不能为空")
    private String workPlanId;

    @ApiModelProperty(value = "消耗时间", required = true, example = "10")
    @NotNull(message = "消耗时间不能为空")
    private Integer consumeTime;

    @ApiModelProperty(value = "剩余时间", required = true, example = "10")
    @NotNull(message = "剩余时间不能为空")
    private Integer remainTime;

    @ApiModelProperty(value = "备注", example = "记录工时,备注测试")
    private String remark;

    @ApiModelProperty(value = "创建人", example = "不用传")
    private String creatorAccount;

    @ApiModelProperty(value = "排序", example = "不用传")
    private Integer sort;

    public WorkPlanRecord() {
    }

    public WorkPlanRecord(String id, Date recordDate, String workPlanId, Integer consumeTime,
                          Integer remainTime, String remark, String creatorAccount, Integer sort) {
        this.id = id;
        this.recordDate = recordDate;
        this.workPlanId = workPlanId;
        this.consumeTime = consumeTime;
        this.remainTime = remainTime;
        this.remark = remark;
        this.creatorAccount = creatorAccount;
        this.sort = sort;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getWorkPlanId() {
        return workPlanId;
    }

    public void setWorkPlanId(String workPlanId) {
        this.workPlanId = workPlanId;
    }

    public Integer getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Integer consumeTime) {
        this.consumeTime = consumeTime;
    }

    public Integer getRemainTime() {
        return remainTime;
    }

    public void setRemainTime(Integer remainTime) {
        this.remainTime = remainTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "WorkPlanRecord{" +
                "id='" + id + '\'' +
                ", recordDate=" + recordDate +
                ", workPlanId='" + workPlanId + '\'' +
                ", consumeTime=" + consumeTime +
                ", remainTime=" + remainTime +
                ", remark='" + remark + '\'' +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", sort=" + sort +
                '}';
    }
}
