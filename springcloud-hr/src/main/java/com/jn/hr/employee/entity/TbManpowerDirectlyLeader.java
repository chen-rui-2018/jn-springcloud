package com.jn.hr.employee.entity;

import java.io.Serializable;

public class TbManpowerDirectlyLeader implements Serializable {
    private String id;

    private String jobNumber;

    private String directLeaderLevel;

    private String directLeadership;

    private String directLeaderName;

    private String directLeaderLevelName;

    private String directLeadershipName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    public String getDirectLeaderLevel() {
        return directLeaderLevel;
    }

    public void setDirectLeaderLevel(String directLeaderLevel) {
        this.directLeaderLevel = directLeaderLevel == null ? null : directLeaderLevel.trim();
    }

    public String getDirectLeadership() {
        return directLeadership;
    }

    public void setDirectLeadership(String directLeadership) {
        this.directLeadership = directLeadership == null ? null : directLeadership.trim();
    }

    public String getDirectLeaderName() {
        return directLeaderName;
    }

    public void setDirectLeaderName(String directLeaderName) {
        this.directLeaderName = directLeaderName == null ? null : directLeaderName.trim();
    }

    public String getDirectLeaderLevelName() {
        return directLeaderLevelName;
    }

    public void setDirectLeaderLevelName(String directLeaderLevelName) {
        this.directLeaderLevelName = directLeaderLevelName == null ? null : directLeaderLevelName.trim();
    }

    public String getDirectLeadershipName() {
        return directLeadershipName;
    }

    public void setDirectLeadershipName(String directLeadershipName) {
        this.directLeadershipName = directLeadershipName == null ? null : directLeadershipName.trim();
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
        TbManpowerDirectlyLeader other = (TbManpowerDirectlyLeader) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getDirectLeaderLevel() == null ? other.getDirectLeaderLevel() == null : this.getDirectLeaderLevel().equals(other.getDirectLeaderLevel()))
            && (this.getDirectLeadership() == null ? other.getDirectLeadership() == null : this.getDirectLeadership().equals(other.getDirectLeadership()))
            && (this.getDirectLeaderName() == null ? other.getDirectLeaderName() == null : this.getDirectLeaderName().equals(other.getDirectLeaderName()))
            && (this.getDirectLeaderLevelName() == null ? other.getDirectLeaderLevelName() == null : this.getDirectLeaderLevelName().equals(other.getDirectLeaderLevelName()))
            && (this.getDirectLeadershipName() == null ? other.getDirectLeadershipName() == null : this.getDirectLeadershipName().equals(other.getDirectLeadershipName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getDirectLeaderLevel() == null) ? 0 : getDirectLeaderLevel().hashCode());
        result = prime * result + ((getDirectLeadership() == null) ? 0 : getDirectLeadership().hashCode());
        result = prime * result + ((getDirectLeaderName() == null) ? 0 : getDirectLeaderName().hashCode());
        result = prime * result + ((getDirectLeaderLevelName() == null) ? 0 : getDirectLeaderLevelName().hashCode());
        result = prime * result + ((getDirectLeadershipName() == null) ? 0 : getDirectLeadershipName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", jobNumber=").append(jobNumber);
        sb.append(", directLeaderLevel=").append(directLeaderLevel);
        sb.append(", directLeadership=").append(directLeadership);
        sb.append(", directLeaderName=").append(directLeaderName);
        sb.append(", directLeaderLevelName=").append(directLeaderLevelName);
        sb.append(", directLeadershipName=").append(directLeadershipName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}