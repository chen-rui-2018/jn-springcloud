package com.jn.park.finance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbFinanceRecordInformation implements Serializable {
    /*@ApiModelProperty("序列")*/
    private Integer id;

    /*@ApiModelProperty("备案资料名称")*/
    private String name;

    /*@ApiModelProperty("流程节点类型")*/
    private String flowType;

    /*@ApiModelProperty("录入部门")*/
    private String departmentId;

    /*@ApiModelProperty("部门名称")*/
    private String departmentName;

    /*@ApiModelProperty("录入截至时间")*/
    private Date deadline;

    /*@ApiModelProperty("录入状态（0：已录入；1：未录入）")*/
    private Byte createState;

    /*@ApiModelProperty("财务确认状态（0：已确认；1：未确认）")*/
    private Byte financerSure;

    /*@ApiModelProperty("负责人是否预警（0：已预警；1：未预警）")*/
    private Byte earlyWarning;

    /*@ApiModelProperty("领导人是否预警（0：已预警；1：未预警）")*/
    private Byte leaderEarlyWarning;

    /*@ApiModelProperty("导入资料的编号；根据编码查询文件")*/
    private String fileCode;

    /*@ApiModelProperty("导入资料的名称")*/
    private String fileName;

    /*@ApiModelProperty("录入人ID")*/
    private String creatorId;

    /*@ApiModelProperty("是否预警
0：否，1:是")*/
    private Byte isWarning;

    /*@ApiModelProperty("预警频率
0：每天预警一次、
1：仅第一天预警一次、2：第一天和最后一天各预警一次")*/
    private Byte warningRate;

    /*@ApiModelProperty("预警对象
0：全部
1：负责人
2：领导")*/
    private Byte warningObject;

    /*@ApiModelProperty("预警方式
0：短信
1：邮件
2：APP
3：公共号方式")*/
    private Byte warningMethod;

    /*@ApiModelProperty("预警提前的天数
输入数值；整数")*/
    private Integer warningBeforeDays;

    /*@ApiModelProperty("是否删除0标记删除，1正常")*/
    private Byte recordStatus;

    /*@ApiModelProperty("录入人")*/
    private String creatorAccount;

    /*@ApiModelProperty("录入时间")*/
    private Date createdTime;

    /*@ApiModelProperty("最新更新者账号")*/
    private String modifierAccount;

    /*@ApiModelProperty("最新更新时间")*/
    private Date modifiedTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Byte getCreateState() {
        return createState;
    }

    public void setCreateState(Byte createState) {
        this.createState = createState;
    }

    public Byte getFinancerSure() {
        return financerSure;
    }

    public void setFinancerSure(Byte financerSure) {
        this.financerSure = financerSure;
    }

    public Byte getEarlyWarning() {
        return earlyWarning;
    }

    public void setEarlyWarning(Byte earlyWarning) {
        this.earlyWarning = earlyWarning;
    }

    public Byte getLeaderEarlyWarning() {
        return leaderEarlyWarning;
    }

    public void setLeaderEarlyWarning(Byte leaderEarlyWarning) {
        this.leaderEarlyWarning = leaderEarlyWarning;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode == null ? null : fileCode.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    public Byte getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(Byte isWarning) {
        this.isWarning = isWarning;
    }

    public Byte getWarningRate() {
        return warningRate;
    }

    public void setWarningRate(Byte warningRate) {
        this.warningRate = warningRate;
    }

    public Byte getWarningObject() {
        return warningObject;
    }

    public void setWarningObject(Byte warningObject) {
        this.warningObject = warningObject;
    }

    public Byte getWarningMethod() {
        return warningMethod;
    }

    public void setWarningMethod(Byte warningMethod) {
        this.warningMethod = warningMethod;
    }

    public Integer getWarningBeforeDays() {
        return warningBeforeDays;
    }

    public void setWarningBeforeDays(Integer warningBeforeDays) {
        this.warningBeforeDays = warningBeforeDays;
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
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
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
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
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
        TbFinanceRecordInformation other = (TbFinanceRecordInformation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFlowType() == null ? other.getFlowType() == null : this.getFlowType().equals(other.getFlowType()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getDepartmentName() == null ? other.getDepartmentName() == null : this.getDepartmentName().equals(other.getDepartmentName()))
            && (this.getDeadline() == null ? other.getDeadline() == null : this.getDeadline().equals(other.getDeadline()))
            && (this.getCreateState() == null ? other.getCreateState() == null : this.getCreateState().equals(other.getCreateState()))
            && (this.getFinancerSure() == null ? other.getFinancerSure() == null : this.getFinancerSure().equals(other.getFinancerSure()))
            && (this.getEarlyWarning() == null ? other.getEarlyWarning() == null : this.getEarlyWarning().equals(other.getEarlyWarning()))
            && (this.getLeaderEarlyWarning() == null ? other.getLeaderEarlyWarning() == null : this.getLeaderEarlyWarning().equals(other.getLeaderEarlyWarning()))
            && (this.getFileCode() == null ? other.getFileCode() == null : this.getFileCode().equals(other.getFileCode()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getIsWarning() == null ? other.getIsWarning() == null : this.getIsWarning().equals(other.getIsWarning()))
            && (this.getWarningRate() == null ? other.getWarningRate() == null : this.getWarningRate().equals(other.getWarningRate()))
            && (this.getWarningObject() == null ? other.getWarningObject() == null : this.getWarningObject().equals(other.getWarningObject()))
            && (this.getWarningMethod() == null ? other.getWarningMethod() == null : this.getWarningMethod().equals(other.getWarningMethod()))
            && (this.getWarningBeforeDays() == null ? other.getWarningBeforeDays() == null : this.getWarningBeforeDays().equals(other.getWarningBeforeDays()))
            && (this.getRecordStatus() == null ? other.getRecordStatus() == null : this.getRecordStatus().equals(other.getRecordStatus()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFlowType() == null) ? 0 : getFlowType().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getDepartmentName() == null) ? 0 : getDepartmentName().hashCode());
        result = prime * result + ((getDeadline() == null) ? 0 : getDeadline().hashCode());
        result = prime * result + ((getCreateState() == null) ? 0 : getCreateState().hashCode());
        result = prime * result + ((getFinancerSure() == null) ? 0 : getFinancerSure().hashCode());
        result = prime * result + ((getEarlyWarning() == null) ? 0 : getEarlyWarning().hashCode());
        result = prime * result + ((getLeaderEarlyWarning() == null) ? 0 : getLeaderEarlyWarning().hashCode());
        result = prime * result + ((getFileCode() == null) ? 0 : getFileCode().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getIsWarning() == null) ? 0 : getIsWarning().hashCode());
        result = prime * result + ((getWarningRate() == null) ? 0 : getWarningRate().hashCode());
        result = prime * result + ((getWarningObject() == null) ? 0 : getWarningObject().hashCode());
        result = prime * result + ((getWarningMethod() == null) ? 0 : getWarningMethod().hashCode());
        result = prime * result + ((getWarningBeforeDays() == null) ? 0 : getWarningBeforeDays().hashCode());
        result = prime * result + ((getRecordStatus() == null) ? 0 : getRecordStatus().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", flowType=").append(flowType);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", departmentName=").append(departmentName);
        sb.append(", deadline=").append(deadline);
        sb.append(", createState=").append(createState);
        sb.append(", financerSure=").append(financerSure);
        sb.append(", earlyWarning=").append(earlyWarning);
        sb.append(", leaderEarlyWarning=").append(leaderEarlyWarning);
        sb.append(", fileCode=").append(fileCode);
        sb.append(", fileName=").append(fileName);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", isWarning=").append(isWarning);
        sb.append(", warningRate=").append(warningRate);
        sb.append(", warningObject=").append(warningObject);
        sb.append(", warningMethod=").append(warningMethod);
        sb.append(", warningBeforeDays=").append(warningBeforeDays);
        sb.append(", recordStatus=").append(recordStatus);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}