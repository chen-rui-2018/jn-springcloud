package com.jn.hr.increase.entity;

import java.io.Serializable;

public class TbManpowerInsuredDetail implements Serializable {
    private String id;

    private String creatDate;

    private String insuredMonth;

    private String jobNumber;

    private String name;

    private String department;

    private String departmentId;

    private String cityId;

    private String cityName;

    private Double personalSocialSecurity;

    private Double companySocialSecurity;

    private Double personalAccumulationFund;

    private Double companyAccumulationFund;

    private String schemeId;

    private Byte isEffective;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate == null ? null : creatDate.trim();
    }

    public String getInsuredMonth() {
        return insuredMonth;
    }

    public void setInsuredMonth(String insuredMonth) {
        this.insuredMonth = insuredMonth == null ? null : insuredMonth.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Double getPersonalSocialSecurity() {
        return personalSocialSecurity;
    }

    public void setPersonalSocialSecurity(Double personalSocialSecurity) {
        this.personalSocialSecurity = personalSocialSecurity;
    }

    public Double getCompanySocialSecurity() {
        return companySocialSecurity;
    }

    public void setCompanySocialSecurity(Double companySocialSecurity) {
        this.companySocialSecurity = companySocialSecurity;
    }

    public Double getPersonalAccumulationFund() {
        return personalAccumulationFund;
    }

    public void setPersonalAccumulationFund(Double personalAccumulationFund) {
        this.personalAccumulationFund = personalAccumulationFund;
    }

    public Double getCompanyAccumulationFund() {
        return companyAccumulationFund;
    }

    public void setCompanyAccumulationFund(Double companyAccumulationFund) {
        this.companyAccumulationFund = companyAccumulationFund;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId == null ? null : schemeId.trim();
    }

    public Byte getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Byte isEffective) {
        this.isEffective = isEffective;
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
        TbManpowerInsuredDetail other = (TbManpowerInsuredDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreatDate() == null ? other.getCreatDate() == null : this.getCreatDate().equals(other.getCreatDate()))
            && (this.getInsuredMonth() == null ? other.getInsuredMonth() == null : this.getInsuredMonth().equals(other.getInsuredMonth()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getDepartmentId() == null ? other.getDepartmentId() == null : this.getDepartmentId().equals(other.getDepartmentId()))
            && (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCityName() == null ? other.getCityName() == null : this.getCityName().equals(other.getCityName()))
            && (this.getPersonalSocialSecurity() == null ? other.getPersonalSocialSecurity() == null : this.getPersonalSocialSecurity().equals(other.getPersonalSocialSecurity()))
            && (this.getCompanySocialSecurity() == null ? other.getCompanySocialSecurity() == null : this.getCompanySocialSecurity().equals(other.getCompanySocialSecurity()))
            && (this.getPersonalAccumulationFund() == null ? other.getPersonalAccumulationFund() == null : this.getPersonalAccumulationFund().equals(other.getPersonalAccumulationFund()))
            && (this.getCompanyAccumulationFund() == null ? other.getCompanyAccumulationFund() == null : this.getCompanyAccumulationFund().equals(other.getCompanyAccumulationFund()))
            && (this.getSchemeId() == null ? other.getSchemeId() == null : this.getSchemeId().equals(other.getSchemeId()))
            && (this.getIsEffective() == null ? other.getIsEffective() == null : this.getIsEffective().equals(other.getIsEffective()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreatDate() == null) ? 0 : getCreatDate().hashCode());
        result = prime * result + ((getInsuredMonth() == null) ? 0 : getInsuredMonth().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDepartmentId() == null) ? 0 : getDepartmentId().hashCode());
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCityName() == null) ? 0 : getCityName().hashCode());
        result = prime * result + ((getPersonalSocialSecurity() == null) ? 0 : getPersonalSocialSecurity().hashCode());
        result = prime * result + ((getCompanySocialSecurity() == null) ? 0 : getCompanySocialSecurity().hashCode());
        result = prime * result + ((getPersonalAccumulationFund() == null) ? 0 : getPersonalAccumulationFund().hashCode());
        result = prime * result + ((getCompanyAccumulationFund() == null) ? 0 : getCompanyAccumulationFund().hashCode());
        result = prime * result + ((getSchemeId() == null) ? 0 : getSchemeId().hashCode());
        result = prime * result + ((getIsEffective() == null) ? 0 : getIsEffective().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", creatDate=").append(creatDate);
        sb.append(", insuredMonth=").append(insuredMonth);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", name=").append(name);
        sb.append(", department=").append(department);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", cityId=").append(cityId);
        sb.append(", cityName=").append(cityName);
        sb.append(", personalSocialSecurity=").append(personalSocialSecurity);
        sb.append(", companySocialSecurity=").append(companySocialSecurity);
        sb.append(", personalAccumulationFund=").append(personalAccumulationFund);
        sb.append(", companyAccumulationFund=").append(companyAccumulationFund);
        sb.append(", schemeId=").append(schemeId);
        sb.append(", isEffective=").append(isEffective);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}