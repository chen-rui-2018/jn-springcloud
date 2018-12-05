package com.jn.portals.activity.entity;

import java.io.Serializable;

public class TbActivityDetail implements Serializable {
    private String activityId;

    private String actiDetail;

    private static final long serialVersionUID = 1L;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActiDetail() {
        return actiDetail;
    }

    public void setActiDetail(String actiDetail) {
        this.actiDetail = actiDetail == null ? null : actiDetail.trim();
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
        TbActivityDetail other = (TbActivityDetail) that;
        return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getActiDetail() == null ? other.getActiDetail() == null : this.getActiDetail().equals(other.getActiDetail()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getActiDetail() == null) ? 0 : getActiDetail().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", actiDetail=").append(actiDetail);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}