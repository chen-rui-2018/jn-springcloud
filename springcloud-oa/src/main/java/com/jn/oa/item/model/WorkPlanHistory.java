package com.jn.oa.item.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作计划历史记录实体
 *
 * @author： shaobao
 * @date： Created on 2019/3/4 19:32
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "WorkPlanHistory", description = "工作计划历史记录实体")
public class WorkPlanHistory implements Serializable {
    private static final long serialVersionUID = 460775970232605830L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "工作计划id")
    private String workPlanId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "历史操作记录")
    private String operateRecode;

    @ApiModelProperty(value = "历史操作细节")
    private String operateDetails;

    @ApiModelProperty(value = "是否删除（0标记删除，1正常）")
    private Byte recordStatus;

    @ApiModelProperty(value = "创建者账号")
    private String creatorAccount;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdTime;

    @ApiModelProperty(value = "最新更新人账号")
    private String modifierAccount;

    @ApiModelProperty(value = "最新更新人时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedTime;

    public WorkPlanHistory() {
    }

    public WorkPlanHistory(String id, String workPlanId, String remark, String operateRecode, String operateDetails,
                           Byte recordStatus, String creatorAccount, Date createdTime, String modifierAccount,
                           Date modifiedTime) {
        this.id = id;
        this.workPlanId = workPlanId;
        this.remark = remark;
        this.operateRecode = operateRecode;
        this.operateDetails = operateDetails;
        this.recordStatus = recordStatus;
        this.creatorAccount = creatorAccount;
        this.createdTime = createdTime;
        this.modifierAccount = modifierAccount;
        this.modifiedTime = modifiedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkPlanId() {
        return workPlanId;
    }

    public void setWorkPlanId(String workPlanId) {
        this.workPlanId = workPlanId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperateRecode() {
        return operateRecode;
    }

    public void setOperateRecode(String operateRecode) {
        this.operateRecode = operateRecode;
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

    public String getOperateDetails() {
        return operateDetails;
    }

    public void setOperateDetails(String operateDetails) {
        this.operateDetails = operateDetails;
    }

    @Override
    public String toString() {
        return "WorkPlanHistory{" +
                "id='" + id + '\'' +
                ", workPlanId='" + workPlanId + '\'' +
                ", remark='" + remark + '\'' +
                ", operateRecode='" + operateRecode + '\'' +
                ", operateDetails='" + operateDetails + '\'' +
                ", recordStatus=" + recordStatus +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", createdTime=" + createdTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
