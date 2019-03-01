package com.jn.enterprise.servicemarket.advisor.model;

import com.jn.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangph
 * @Date: 2019/2/14 16:45
 * @Version v1.0
 * @modified By:
 */
@ApiModel(value = "ServiceProjectExperience",description = "顾问项目经验")
public class ServiceProjectExperience extends Page implements Serializable {
    @ApiModelProperty(value = "主键id")
    private String id;
    @ApiModelProperty(value = "顾问账号")
    @NotNull(message="顾问账号不能为空")
    private String advisorAccount;
    @ApiModelProperty(value = "公司名称")
    @NotNull(message="公司名称不能为空")
    private String companyName;
    @ApiModelProperty(value = "项目名称")
    @NotNull(message="项目名称不能为空")
    private String projectName;
    @ApiModelProperty(value = "项目时间(格式：201903)")
    @Pattern(regexp = "((19[2-9][0-9])|(20((0[0-9])|(1[0-8]))))((0?[1-9])|(1[0-2]))",
            message = "{projectTime:'项目时间格式错误'}")
    private String projectTime;
    @ApiModelProperty(value = "个人职责")
    @Size(max = 500, message = "个人职责描述不能超过500字")
    private String personalDuties;
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectTime() {
        return projectTime;
    }

    public void setProjectTime(String projectTime) {
        this.projectTime = projectTime;
    }

    public String getPersonalDuties() {
        return personalDuties;
    }

    public void setPersonalDuties(String personalDuties) {
        this.personalDuties = personalDuties;
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
        return "ServiceProjectExperience{" +
                "id='" + id + '\'' +
                ", advisorAccount='" + advisorAccount + '\'' +
                ", companyName='" + companyName + '\'' +
                ", projectName='" + projectName + '\'' +
                ", projectTime=" + projectTime +
                ", personalDuties='" + personalDuties + '\'' +
                ", createdTime=" + createdTime +
                ", creatorAccount='" + creatorAccount + '\'' +
                ", modifiedTime=" + modifiedTime +
                ", modifierAccount='" + modifierAccount + '\'' +
                ", recordStatus=" + recordStatus +
                '}';
    }
}
