package com.jn.park.notice.entity;

import java.io.Serializable;
import java.util.Arrays;

public class TbNoticeDetails implements Serializable {
    private String noticeId;

    private byte[] noticeDetails;

    private static final long serialVersionUID = 1L;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId == null ? null : noticeId.trim();
    }

    public byte[] getNoticeDetails() {
        return noticeDetails;
    }

    public void setNoticeDetails(byte[] noticeDetails) {
        this.noticeDetails = noticeDetails;
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
        TbNoticeDetails other = (TbNoticeDetails) that;
        return (this.getNoticeId() == null ? other.getNoticeId() == null : this.getNoticeId().equals(other.getNoticeId()))
            && (Arrays.equals(this.getNoticeDetails(), other.getNoticeDetails()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoticeId() == null) ? 0 : getNoticeId().hashCode());
        result = prime * result + (Arrays.hashCode(getNoticeDetails()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noticeId=").append(noticeId);
        sb.append(", noticeDetails=").append(noticeDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}