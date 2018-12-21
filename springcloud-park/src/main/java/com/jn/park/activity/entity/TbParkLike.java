package com.jn.park.activity.entity;

import java.io.Serializable;
import java.util.Date;

public class TbParkLike implements Serializable {
    private String id;

    private String likeParentId;

    private String likeAccount;

    private Date likeTime;

    private String status;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLikeParentId() {
        return likeParentId;
    }

    public void setLikeParentId(String likeParentId) {
        this.likeParentId = likeParentId == null ? null : likeParentId.trim();
    }

    public String getLikeAccount() {
        return likeAccount;
    }

    public void setLikeAccount(String likeAccount) {
        this.likeAccount = likeAccount == null ? null : likeAccount.trim();
    }

    public Date getLikeTime() {
        return likeTime;
    }

    public void setLikeTime(Date likeTime) {
        this.likeTime = likeTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        TbParkLike other = (TbParkLike) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLikeParentId() == null ? other.getLikeParentId() == null : this.getLikeParentId().equals(other.getLikeParentId()))
            && (this.getLikeAccount() == null ? other.getLikeAccount() == null : this.getLikeAccount().equals(other.getLikeAccount()))
            && (this.getLikeTime() == null ? other.getLikeTime() == null : this.getLikeTime().equals(other.getLikeTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLikeParentId() == null) ? 0 : getLikeParentId().hashCode());
        result = prime * result + ((getLikeAccount() == null) ? 0 : getLikeAccount().hashCode());
        result = prime * result + ((getLikeTime() == null) ? 0 : getLikeTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", likeParentId=").append(likeParentId);
        sb.append(", likeAccount=").append(likeAccount);
        sb.append(", likeTime=").append(likeTime);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}