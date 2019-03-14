package com.jn.oa.meeting.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 会议审核实体
 *
 * @author： yuanyy
 * @date： Created on 2019/1/13 10:18
 * @version： v1.0
 * @modified By:
 */
@ApiModel(value = "OaMeetingApprove", description = "会议审核实体")
public class OaMeetingApprove implements Serializable {
    private static final long serialVersionUID = 7252981735944287744L;

    @ApiModelProperty(value = "会议申请id")
    private String id;

    @ApiModelProperty(value = "审批状态（0:已取消、1:审批中、2:审批通过、3:审批不通过、4:已作废）")
    private String approvalStatus;

    @ApiModelProperty(value = "修改人")
    private String modifierAccount;

    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;

    @ApiModelProperty(value = "审核角色")
    private String approvalRole;

    @ApiModelProperty(value = "审核人员")
    private String approvalUser;

    @ApiModelProperty(value = "审核意见")
    private String approvalOpinion;

    @ApiModelProperty(value = "会议状态（0:待开始、1:进行中、2:已完成、3:已取消）")
    private String meetingStatus;

    public String getMeetingStatus() {
        return meetingStatus;
    }

    public void setMeetingStatus(String meetingStatus) {
        this.meetingStatus = meetingStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
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

    public String getApprovalRole() {
        return approvalRole;
    }

    public void setApprovalRole(String approvalRole) {
        this.approvalRole = approvalRole;
    }

    public String getApprovalUser() {
        return approvalUser;
    }

    public void setApprovalUser(String approvalUser) {
        this.approvalUser = approvalUser;
    }

    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }
}
