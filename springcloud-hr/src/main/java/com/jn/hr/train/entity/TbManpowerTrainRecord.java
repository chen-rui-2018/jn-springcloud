package com.jn.hr.train.entity;

import java.io.Serializable;

public class TbManpowerTrainRecord implements Serializable {
    private String id;

    private String managementId;

    private String trainerDepartment;

    private String trainerJobNumber;

    private String trainerName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getManagementId() {
        return managementId;
    }

    public void setManagementId(String managementId) {
        this.managementId = managementId == null ? null : managementId.trim();
    }

    public String getTrainerDepartment() {
        return trainerDepartment;
    }

    public void setTrainerDepartment(String trainerDepartment) {
        this.trainerDepartment = trainerDepartment == null ? null : trainerDepartment.trim();
    }

    public String getTrainerJobNumber() {
        return trainerJobNumber;
    }

    public void setTrainerJobNumber(String trainerJobNumber) {
        this.trainerJobNumber = trainerJobNumber == null ? null : trainerJobNumber.trim();
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName == null ? null : trainerName.trim();
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
        TbManpowerTrainRecord other = (TbManpowerTrainRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getManagementId() == null ? other.getManagementId() == null : this.getManagementId().equals(other.getManagementId()))
            && (this.getTrainerDepartment() == null ? other.getTrainerDepartment() == null : this.getTrainerDepartment().equals(other.getTrainerDepartment()))
            && (this.getTrainerJobNumber() == null ? other.getTrainerJobNumber() == null : this.getTrainerJobNumber().equals(other.getTrainerJobNumber()))
            && (this.getTrainerName() == null ? other.getTrainerName() == null : this.getTrainerName().equals(other.getTrainerName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getManagementId() == null) ? 0 : getManagementId().hashCode());
        result = prime * result + ((getTrainerDepartment() == null) ? 0 : getTrainerDepartment().hashCode());
        result = prime * result + ((getTrainerJobNumber() == null) ? 0 : getTrainerJobNumber().hashCode());
        result = prime * result + ((getTrainerName() == null) ? 0 : getTrainerName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", managementId=").append(managementId);
        sb.append(", trainerDepartment=").append(trainerDepartment);
        sb.append(", trainerJobNumber=").append(trainerJobNumber);
        sb.append(", trainerName=").append(trainerName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}