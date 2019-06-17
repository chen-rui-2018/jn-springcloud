package com.jn.hr.employee.entity;

import java.io.Serializable;
import java.util.Date;

public class TbManpowerEducationExperience implements Serializable {
    private String id;

    private String school;

    private String major;

    private Date admissionTime;

    private Date completionTime;

    private String educationCode;

    private String educationName;

    private Byte isAcademicDegree;

    private String certificateEducaUrlOne;

    private String certificateEducaUrlTwo;

    private String jobNumber;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Date getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(Date admissionTime) {
        this.admissionTime = admissionTime;
    }

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public String getEducationCode() {
        return educationCode;
    }

    public void setEducationCode(String educationCode) {
        this.educationCode = educationCode == null ? null : educationCode.trim();
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName == null ? null : educationName.trim();
    }

    public Byte getIsAcademicDegree() {
        return isAcademicDegree;
    }

    public void setIsAcademicDegree(Byte isAcademicDegree) {
        this.isAcademicDegree = isAcademicDegree;
    }

    public String getCertificateEducaUrlOne() {
        return certificateEducaUrlOne;
    }

    public void setCertificateEducaUrlOne(String certificateEducaUrlOne) {
        this.certificateEducaUrlOne = certificateEducaUrlOne == null ? null : certificateEducaUrlOne.trim();
    }

    public String getCertificateEducaUrlTwo() {
        return certificateEducaUrlTwo;
    }

    public void setCertificateEducaUrlTwo(String certificateEducaUrlTwo) {
        this.certificateEducaUrlTwo = certificateEducaUrlTwo == null ? null : certificateEducaUrlTwo.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
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
        TbManpowerEducationExperience other = (TbManpowerEducationExperience) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSchool() == null ? other.getSchool() == null : this.getSchool().equals(other.getSchool()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getAdmissionTime() == null ? other.getAdmissionTime() == null : this.getAdmissionTime().equals(other.getAdmissionTime()))
            && (this.getCompletionTime() == null ? other.getCompletionTime() == null : this.getCompletionTime().equals(other.getCompletionTime()))
            && (this.getEducationCode() == null ? other.getEducationCode() == null : this.getEducationCode().equals(other.getEducationCode()))
            && (this.getEducationName() == null ? other.getEducationName() == null : this.getEducationName().equals(other.getEducationName()))
            && (this.getIsAcademicDegree() == null ? other.getIsAcademicDegree() == null : this.getIsAcademicDegree().equals(other.getIsAcademicDegree()))
            && (this.getCertificateEducaUrlOne() == null ? other.getCertificateEducaUrlOne() == null : this.getCertificateEducaUrlOne().equals(other.getCertificateEducaUrlOne()))
            && (this.getCertificateEducaUrlTwo() == null ? other.getCertificateEducaUrlTwo() == null : this.getCertificateEducaUrlTwo().equals(other.getCertificateEducaUrlTwo()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSchool() == null) ? 0 : getSchool().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getAdmissionTime() == null) ? 0 : getAdmissionTime().hashCode());
        result = prime * result + ((getCompletionTime() == null) ? 0 : getCompletionTime().hashCode());
        result = prime * result + ((getEducationCode() == null) ? 0 : getEducationCode().hashCode());
        result = prime * result + ((getEducationName() == null) ? 0 : getEducationName().hashCode());
        result = prime * result + ((getIsAcademicDegree() == null) ? 0 : getIsAcademicDegree().hashCode());
        result = prime * result + ((getCertificateEducaUrlOne() == null) ? 0 : getCertificateEducaUrlOne().hashCode());
        result = prime * result + ((getCertificateEducaUrlTwo() == null) ? 0 : getCertificateEducaUrlTwo().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", school=").append(school);
        sb.append(", major=").append(major);
        sb.append(", admissionTime=").append(admissionTime);
        sb.append(", completionTime=").append(completionTime);
        sb.append(", educationCode=").append(educationCode);
        sb.append(", educationName=").append(educationName);
        sb.append(", isAcademicDegree=").append(isAcademicDegree);
        sb.append(", certificateEducaUrlOne=").append(certificateEducaUrlOne);
        sb.append(", certificateEducaUrlTwo=").append(certificateEducaUrlTwo);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}