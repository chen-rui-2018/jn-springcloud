package com.jn.park.comment.entity;

import java.io.Serializable;
import java.util.Date;

public class TbComment implements Serializable {
    private String id;

    private String rootId;

    private String pId;

    private String parentAccount;

    private String comAccount;

    private Date comTime;

    private Integer likeNum;

    private String status;

    private String comType;

    private String comContent;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRootId() {
        return rootId;
    }

    public void setRootId(String rootId) {
        this.rootId = rootId == null ? null : rootId.trim();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }

    public String getParentAccount() {
        return parentAccount;
    }

    public void setParentAccount(String parentAccount) {
        this.parentAccount = parentAccount == null ? null : parentAccount.trim();
    }

    public String getComAccount() {
        return comAccount;
    }

    public void setComAccount(String comAccount) {
        this.comAccount = comAccount == null ? null : comAccount.trim();
    }

    public Date getComTime() {
        return comTime;
    }

    public void setComTime(Date comTime) {
        this.comTime = comTime;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType == null ? null : comType.trim();
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent == null ? null : comContent.trim();
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
        TbComment other = (TbComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRootId() == null ? other.getRootId() == null : this.getRootId().equals(other.getRootId()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getParentAccount() == null ? other.getParentAccount() == null : this.getParentAccount().equals(other.getParentAccount()))
            && (this.getComAccount() == null ? other.getComAccount() == null : this.getComAccount().equals(other.getComAccount()))
            && (this.getComTime() == null ? other.getComTime() == null : this.getComTime().equals(other.getComTime()))
            && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getComType() == null ? other.getComType() == null : this.getComType().equals(other.getComType()))
            && (this.getComContent() == null ? other.getComContent() == null : this.getComContent().equals(other.getComContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRootId() == null) ? 0 : getRootId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getParentAccount() == null) ? 0 : getParentAccount().hashCode());
        result = prime * result + ((getComAccount() == null) ? 0 : getComAccount().hashCode());
        result = prime * result + ((getComTime() == null) ? 0 : getComTime().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getComType() == null) ? 0 : getComType().hashCode());
        result = prime * result + ((getComContent() == null) ? 0 : getComContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", rootId=").append(rootId);
        sb.append(", pId=").append(pId);
        sb.append(", parentAccount=").append(parentAccount);
        sb.append(", comAccount=").append(comAccount);
        sb.append(", comTime=").append(comTime);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", status=").append(status);
        sb.append(", comType=").append(comType);
        sb.append(", comContent=").append(comContent);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}