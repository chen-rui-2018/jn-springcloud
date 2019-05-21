package com.jn.hr.employee.entity;

import java.io.Serializable;

public class TbManpowerBackgroundInvest implements Serializable {
    private String id;

    private Byte identityCheck;

    private Byte educationCheck;

    private String corporateName;

    private String corporateJob;

    private String companyCertifier;

    private String inspectors;

    private String inspectorsPhone;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Byte getIdentityCheck() {
        return identityCheck;
    }

    public void setIdentityCheck(Byte identityCheck) {
        this.identityCheck = identityCheck;
    }

    public Byte getEducationCheck() {
        return educationCheck;
    }

    public void setEducationCheck(Byte educationCheck) {
        this.educationCheck = educationCheck;
    }

    public String getCorporateName() {
        return corporateName;
    }

    public void setCorporateName(String corporateName) {
        this.corporateName = corporateName == null ? null : corporateName.trim();
    }

    public String getCorporateJob() {
        return corporateJob;
    }

    public void setCorporateJob(String corporateJob) {
        this.corporateJob = corporateJob == null ? null : corporateJob.trim();
    }

    public String getCompanyCertifier() {
        return companyCertifier;
    }

    public void setCompanyCertifier(String companyCertifier) {
        this.companyCertifier = companyCertifier == null ? null : companyCertifier.trim();
    }

    public String getInspectors() {
        return inspectors;
    }

    public void setInspectors(String inspectors) {
        this.inspectors = inspectors == null ? null : inspectors.trim();
    }

    public String getInspectorsPhone() {
        return inspectorsPhone;
    }

    public void setInspectorsPhone(String inspectorsPhone) {
        this.inspectorsPhone = inspectorsPhone == null ? null : inspectorsPhone.trim();
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
        TbManpowerBackgroundInvest other = (TbManpowerBackgroundInvest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIdentityCheck() == null ? other.getIdentityCheck() == null : this.getIdentityCheck().equals(other.getIdentityCheck()))
            && (this.getEducationCheck() == null ? other.getEducationCheck() == null : this.getEducationCheck().equals(other.getEducationCheck()))
            && (this.getCorporateName() == null ? other.getCorporateName() == null : this.getCorporateName().equals(other.getCorporateName()))
            && (this.getCorporateJob() == null ? other.getCorporateJob() == null : this.getCorporateJob().equals(other.getCorporateJob()))
            && (this.getCompanyCertifier() == null ? other.getCompanyCertifier() == null : this.getCompanyCertifier().equals(other.getCompanyCertifier()))
            && (this.getInspectors() == null ? other.getInspectors() == null : this.getInspectors().equals(other.getInspectors()))
            && (this.getInspectorsPhone() == null ? other.getInspectorsPhone() == null : this.getInspectorsPhone().equals(other.getInspectorsPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIdentityCheck() == null) ? 0 : getIdentityCheck().hashCode());
        result = prime * result + ((getEducationCheck() == null) ? 0 : getEducationCheck().hashCode());
        result = prime * result + ((getCorporateName() == null) ? 0 : getCorporateName().hashCode());
        result = prime * result + ((getCorporateJob() == null) ? 0 : getCorporateJob().hashCode());
        result = prime * result + ((getCompanyCertifier() == null) ? 0 : getCompanyCertifier().hashCode());
        result = prime * result + ((getInspectors() == null) ? 0 : getInspectors().hashCode());
        result = prime * result + ((getInspectorsPhone() == null) ? 0 : getInspectorsPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", identityCheck=").append(identityCheck);
        sb.append(", educationCheck=").append(educationCheck);
        sb.append(", corporateName=").append(corporateName);
        sb.append(", corporateJob=").append(corporateJob);
        sb.append(", companyCertifier=").append(companyCertifier);
        sb.append(", inspectors=").append(inspectors);
        sb.append(", inspectorsPhone=").append(inspectorsPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}