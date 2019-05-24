package com.jn.hr.employee.entity;

import java.io.Serializable;

public class TbManpowerHonorWall implements Serializable {
    private String id;

    private String jobNumber;

    private String honoraryPictures;

    private String honoraryFile;

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

    public String getHonoraryPictures() {
        return honoraryPictures;
    }

    public void setHonoraryPictures(String honoraryPictures) {
        this.honoraryPictures = honoraryPictures == null ? null : honoraryPictures.trim();
    }

    public String getHonoraryFile() {
        return honoraryFile;
    }

    public void setHonoraryFile(String honoraryFile) {
        this.honoraryFile = honoraryFile == null ? null : honoraryFile.trim();
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
        TbManpowerHonorWall other = (TbManpowerHonorWall) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getJobNumber() == null ? other.getJobNumber() == null : this.getJobNumber().equals(other.getJobNumber()))
            && (this.getHonoraryPictures() == null ? other.getHonoraryPictures() == null : this.getHonoraryPictures().equals(other.getHonoraryPictures()))
            && (this.getHonoraryFile() == null ? other.getHonoraryFile() == null : this.getHonoraryFile().equals(other.getHonoraryFile()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getJobNumber() == null) ? 0 : getJobNumber().hashCode());
        result = prime * result + ((getHonoraryPictures() == null) ? 0 : getHonoraryPictures().hashCode());
        result = prime * result + ((getHonoraryFile() == null) ? 0 : getHonoraryFile().hashCode());
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
        sb.append(", honoraryPictures=").append(honoraryPictures);
        sb.append(", honoraryFile=").append(honoraryFile);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}