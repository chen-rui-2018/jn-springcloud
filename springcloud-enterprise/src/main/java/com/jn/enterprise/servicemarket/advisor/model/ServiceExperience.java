package com.jn.enterprise.servicemarket.advisor.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/2/14 16:55
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceExperience",description = "专员服务经历出参")
public class ServiceExperience implements Serializable {
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "专员账号")
    private String advisorAccount;
    @ApiModelProperty(value = "公司名称")
    private String companyName;
    @ApiModelProperty(value = "职务")
    private String position;
    @ApiModelProperty(value = "工作时间")
    private String workTime;
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    @ApiModelProperty(value = "创建人")
    private String creatorAccount;
    @ApiModelProperty(value = "修改时间")
    private Date modifiedTime;
    @ApiModelProperty(value = "修改人")
    private String modifierAccount;
    @ApiModelProperty(value = "记录状态")
    private Byte recordStatus;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdvisorAccount() {
        return advisorAccount;
    }

    public void setAdvisorAccount(String advisorAccount) {
        this.advisorAccount = advisorAccount;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount;
    }

    public Byte getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Byte recordStatus) {
        this.recordStatus = recordStatus;
    }

    @Override
    public String toString() {
        return "ServiceExperience{" +
                "id='" + id + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", workTime=" + workTime +
                ", createdTime=" + createdTime +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
