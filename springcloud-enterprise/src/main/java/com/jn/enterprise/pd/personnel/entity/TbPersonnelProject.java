package com.jn.enterprise.pd.personnel.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPersonnelProject implements Serializable {
    /*@ApiModelProperty("主键")*/
    private String id;

    /*@ApiModelProperty("租户ID")*/
    private String tenantId;

    /*@ApiModelProperty("IP地址")*/
    private String ip;

    /*@ApiModelProperty("创建人")*/
    private String createBy;

    /*@ApiModelProperty("创建时间")*/
    private Date createTime;

    /*@ApiModelProperty("更新人")*/
    private String updateBy;

    /*@ApiModelProperty("更新时间")*/
    private Date updateTime;

    /*@ApiModelProperty("企业（团队）名称")*/
    private String name;

    /*@ApiModelProperty("统一社会信用代码")*/
    private String creditCode;

    /*@ApiModelProperty("类型")*/
    private String type;

    /*@ApiModelProperty("产业领域")*/
    private String industrial;

    /*@ApiModelProperty("企业法人")*/
    private String companyPerson;

    /*@ApiModelProperty("公司地址")*/
    private String companyAddress;

    /*@ApiModelProperty("企业LOGO")*/
    private String companyLogo;

    /*@ApiModelProperty("企业简介")*/
    private String companyIntroduce;

    /*@ApiModelProperty("项目名称（团队）")*/
    private String projectName;

    /*@ApiModelProperty("项目简介（团队）")*/
    private String projectIntroduce;

    /*@ApiModelProperty("联系人姓名")*/
    private String contactName;

    /*@ApiModelProperty("联系人电话")*/
    private String contactPhone;

    /*@ApiModelProperty("联系人电子邮箱")*/
    private String contactEmail;

    /*@ApiModelProperty("项目介绍书附件")*/
    private String projectFile;

    /*@ApiModelProperty("政策通知（获取扶持政策环节使用）")*/
    private String policyNotice;

    /*@ApiModelProperty("标签名称（人才管理企业打标用）")*/
    private String labelName;

    /*@ApiModelProperty("标签ID（人才管理企业打标用）")*/
    private String labelId;

    /*@ApiModelProperty("是否完成核名")*/
    private String registerIsCheck;

    /*@ApiModelProperty("注册落户附件")*/
    private String registerFile;

    /*@ApiModelProperty("是否已领取执照")*/
    private String registerLicense;

    /*@ApiModelProperty("是否已完成盖章")*/
    private String registerSeal;

    /*@ApiModelProperty("人才申报书模板附件")*/
    private String templateFile;

    /*@ApiModelProperty("人才申报书附件")*/
    private String applyFile;

    /*@ApiModelProperty("政策材料附件")*/
    private String policyFile;

    /*@ApiModelProperty("所在阶段")*/
    private String stepName;

    /*@ApiModelProperty("当前正在进行的辅导类型")*/
    private String curRecordType;

    /*@ApiModelProperty("申请人ID")*/
    private String createId;

    /*@ApiModelProperty("当前正在进行的辅导类型名称")*/
    private String curRecordName;

    /*@ApiModelProperty("所在阶段ID")*/
    private Short stepId;

    /*@ApiModelProperty("正在进行的流程任务ID")*/
    private String taskId;

    /*@ApiModelProperty("转办人ID")*/
    private String dealUserId;

    /*@ApiModelProperty("转办人名称")*/
    private String dealUserName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId == null ? null : tenantId.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getIndustrial() {
        return industrial;
    }

    public void setIndustrial(String industrial) {
        this.industrial = industrial == null ? null : industrial.trim();
    }

    public String getCompanyPerson() {
        return companyPerson;
    }

    public void setCompanyPerson(String companyPerson) {
        this.companyPerson = companyPerson == null ? null : companyPerson.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo == null ? null : companyLogo.trim();
    }

    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce == null ? null : companyIntroduce.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce == null ? null : projectIntroduce.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getProjectFile() {
        return projectFile;
    }

    public void setProjectFile(String projectFile) {
        this.projectFile = projectFile == null ? null : projectFile.trim();
    }

    public String getPolicyNotice() {
        return policyNotice;
    }

    public void setPolicyNotice(String policyNotice) {
        this.policyNotice = policyNotice == null ? null : policyNotice.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId == null ? null : labelId.trim();
    }

    public String getRegisterIsCheck() {
        return registerIsCheck;
    }

    public void setRegisterIsCheck(String registerIsCheck) {
        this.registerIsCheck = registerIsCheck == null ? null : registerIsCheck.trim();
    }

    public String getRegisterFile() {
        return registerFile;
    }

    public void setRegisterFile(String registerFile) {
        this.registerFile = registerFile == null ? null : registerFile.trim();
    }

    public String getRegisterLicense() {
        return registerLicense;
    }

    public void setRegisterLicense(String registerLicense) {
        this.registerLicense = registerLicense == null ? null : registerLicense.trim();
    }

    public String getRegisterSeal() {
        return registerSeal;
    }

    public void setRegisterSeal(String registerSeal) {
        this.registerSeal = registerSeal == null ? null : registerSeal.trim();
    }

    public String getTemplateFile() {
        return templateFile;
    }

    public void setTemplateFile(String templateFile) {
        this.templateFile = templateFile == null ? null : templateFile.trim();
    }

    public String getApplyFile() {
        return applyFile;
    }

    public void setApplyFile(String applyFile) {
        this.applyFile = applyFile == null ? null : applyFile.trim();
    }

    public String getPolicyFile() {
        return policyFile;
    }

    public void setPolicyFile(String policyFile) {
        this.policyFile = policyFile == null ? null : policyFile.trim();
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName == null ? null : stepName.trim();
    }

    public String getCurRecordType() {
        return curRecordType;
    }

    public void setCurRecordType(String curRecordType) {
        this.curRecordType = curRecordType == null ? null : curRecordType.trim();
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public String getCurRecordName() {
        return curRecordName;
    }

    public void setCurRecordName(String curRecordName) {
        this.curRecordName = curRecordName == null ? null : curRecordName.trim();
    }

    public Short getStepId() {
        return stepId;
    }

    public void setStepId(Short stepId) {
        this.stepId = stepId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(String dealUserId) {
        this.dealUserId = dealUserId == null ? null : dealUserId.trim();
    }

    public String getDealUserName() {
        return dealUserName;
    }

    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName == null ? null : dealUserName.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TbPersonnelProject other = (TbPersonnelProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTenantId() == null ? other.getTenantId() == null : this.getTenantId().equals(other.getTenantId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreditCode() == null ? other.getCreditCode() == null : this.getCreditCode().equals(other.getCreditCode()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIndustrial() == null ? other.getIndustrial() == null : this.getIndustrial().equals(other.getIndustrial()))
            && (this.getCompanyPerson() == null ? other.getCompanyPerson() == null : this.getCompanyPerson().equals(other.getCompanyPerson()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()))
            && (this.getCompanyLogo() == null ? other.getCompanyLogo() == null : this.getCompanyLogo().equals(other.getCompanyLogo()))
            && (this.getCompanyIntroduce() == null ? other.getCompanyIntroduce() == null : this.getCompanyIntroduce().equals(other.getCompanyIntroduce()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectIntroduce() == null ? other.getProjectIntroduce() == null : this.getProjectIntroduce().equals(other.getProjectIntroduce()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getContactEmail() == null ? other.getContactEmail() == null : this.getContactEmail().equals(other.getContactEmail()))
            && (this.getProjectFile() == null ? other.getProjectFile() == null : this.getProjectFile().equals(other.getProjectFile()))
            && (this.getPolicyNotice() == null ? other.getPolicyNotice() == null : this.getPolicyNotice().equals(other.getPolicyNotice()))
            && (this.getLabelName() == null ? other.getLabelName() == null : this.getLabelName().equals(other.getLabelName()))
            && (this.getLabelId() == null ? other.getLabelId() == null : this.getLabelId().equals(other.getLabelId()))
            && (this.getRegisterIsCheck() == null ? other.getRegisterIsCheck() == null : this.getRegisterIsCheck().equals(other.getRegisterIsCheck()))
            && (this.getRegisterFile() == null ? other.getRegisterFile() == null : this.getRegisterFile().equals(other.getRegisterFile()))
            && (this.getRegisterLicense() == null ? other.getRegisterLicense() == null : this.getRegisterLicense().equals(other.getRegisterLicense()))
            && (this.getRegisterSeal() == null ? other.getRegisterSeal() == null : this.getRegisterSeal().equals(other.getRegisterSeal()))
            && (this.getTemplateFile() == null ? other.getTemplateFile() == null : this.getTemplateFile().equals(other.getTemplateFile()))
            && (this.getApplyFile() == null ? other.getApplyFile() == null : this.getApplyFile().equals(other.getApplyFile()))
            && (this.getPolicyFile() == null ? other.getPolicyFile() == null : this.getPolicyFile().equals(other.getPolicyFile()))
            && (this.getStepName() == null ? other.getStepName() == null : this.getStepName().equals(other.getStepName()))
            && (this.getCurRecordType() == null ? other.getCurRecordType() == null : this.getCurRecordType().equals(other.getCurRecordType()))
            && (this.getCreateId() == null ? other.getCreateId() == null : this.getCreateId().equals(other.getCreateId()))
            && (this.getCurRecordName() == null ? other.getCurRecordName() == null : this.getCurRecordName().equals(other.getCurRecordName()))
            && (this.getStepId() == null ? other.getStepId() == null : this.getStepId().equals(other.getStepId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getDealUserId() == null ? other.getDealUserId() == null : this.getDealUserId().equals(other.getDealUserId()))
            && (this.getDealUserName() == null ? other.getDealUserName() == null : this.getDealUserName().equals(other.getDealUserName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTenantId() == null) ? 0 : getTenantId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreditCode() == null) ? 0 : getCreditCode().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIndustrial() == null) ? 0 : getIndustrial().hashCode());
        result = prime * result + ((getCompanyPerson() == null) ? 0 : getCompanyPerson().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        result = prime * result + ((getCompanyLogo() == null) ? 0 : getCompanyLogo().hashCode());
        result = prime * result + ((getCompanyIntroduce() == null) ? 0 : getCompanyIntroduce().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectIntroduce() == null) ? 0 : getProjectIntroduce().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getContactEmail() == null) ? 0 : getContactEmail().hashCode());
        result = prime * result + ((getProjectFile() == null) ? 0 : getProjectFile().hashCode());
        result = prime * result + ((getPolicyNotice() == null) ? 0 : getPolicyNotice().hashCode());
        result = prime * result + ((getLabelName() == null) ? 0 : getLabelName().hashCode());
        result = prime * result + ((getLabelId() == null) ? 0 : getLabelId().hashCode());
        result = prime * result + ((getRegisterIsCheck() == null) ? 0 : getRegisterIsCheck().hashCode());
        result = prime * result + ((getRegisterFile() == null) ? 0 : getRegisterFile().hashCode());
        result = prime * result + ((getRegisterLicense() == null) ? 0 : getRegisterLicense().hashCode());
        result = prime * result + ((getRegisterSeal() == null) ? 0 : getRegisterSeal().hashCode());
        result = prime * result + ((getTemplateFile() == null) ? 0 : getTemplateFile().hashCode());
        result = prime * result + ((getApplyFile() == null) ? 0 : getApplyFile().hashCode());
        result = prime * result + ((getPolicyFile() == null) ? 0 : getPolicyFile().hashCode());
        result = prime * result + ((getStepName() == null) ? 0 : getStepName().hashCode());
        result = prime * result + ((getCurRecordType() == null) ? 0 : getCurRecordType().hashCode());
        result = prime * result + ((getCreateId() == null) ? 0 : getCreateId().hashCode());
        result = prime * result + ((getCurRecordName() == null) ? 0 : getCurRecordName().hashCode());
        result = prime * result + ((getStepId() == null) ? 0 : getStepId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getDealUserId() == null) ? 0 : getDealUserId().hashCode());
        result = prime * result + ((getDealUserName() == null) ? 0 : getDealUserName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tenantId=").append(tenantId);
        sb.append(", ip=").append(ip);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", name=").append(name);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", type=").append(type);
        sb.append(", industrial=").append(industrial);
        sb.append(", companyPerson=").append(companyPerson);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append(", companyLogo=").append(companyLogo);
        sb.append(", companyIntroduce=").append(companyIntroduce);
        sb.append(", projectName=").append(projectName);
        sb.append(", projectIntroduce=").append(projectIntroduce);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", projectFile=").append(projectFile);
        sb.append(", policyNotice=").append(policyNotice);
        sb.append(", labelName=").append(labelName);
        sb.append(", labelId=").append(labelId);
        sb.append(", registerIsCheck=").append(registerIsCheck);
        sb.append(", registerFile=").append(registerFile);
        sb.append(", registerLicense=").append(registerLicense);
        sb.append(", registerSeal=").append(registerSeal);
        sb.append(", templateFile=").append(templateFile);
        sb.append(", applyFile=").append(applyFile);
        sb.append(", policyFile=").append(policyFile);
        sb.append(", stepName=").append(stepName);
        sb.append(", curRecordType=").append(curRecordType);
        sb.append(", createId=").append(createId);
        sb.append(", curRecordName=").append(curRecordName);
        sb.append(", stepId=").append(stepId);
        sb.append(", taskId=").append(taskId);
        sb.append(", dealUserId=").append(dealUserId);
        sb.append(", dealUserName=").append(dealUserName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}