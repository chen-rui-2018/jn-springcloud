package com.jn.park.video.entity;

import java.io.Serializable;
import java.util.Date;

public class TbPmVideoItem implements Serializable {
    private String id;

    private String videoId;

    private String videoTitle;

    private String operation;

    private String videoPlayUrl;

    private Date videoStartTime;

    private Date videoEndTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId == null ? null : videoId.trim();
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle == null ? null : videoTitle.trim();
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation == null ? null : operation.trim();
    }

    public String getVideoPlayUrl() {
        return videoPlayUrl;
    }

    public void setVideoPlayUrl(String videoPlayUrl) {
        this.videoPlayUrl = videoPlayUrl == null ? null : videoPlayUrl.trim();
    }

    public Date getVideoStartTime() {
        return videoStartTime;
    }

    public void setVideoStartTime(Date videoStartTime) {
        this.videoStartTime = videoStartTime;
    }

    public Date getVideoEndTime() {
        return videoEndTime;
    }

    public void setVideoEndTime(Date videoEndTime) {
        this.videoEndTime = videoEndTime;
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
        TbPmVideoItem other = (TbPmVideoItem) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getVideoId() == null ? other.getVideoId() == null : this.getVideoId().equals(other.getVideoId()))
            && (this.getVideoTitle() == null ? other.getVideoTitle() == null : this.getVideoTitle().equals(other.getVideoTitle()))
            && (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()))
            && (this.getVideoPlayUrl() == null ? other.getVideoPlayUrl() == null : this.getVideoPlayUrl().equals(other.getVideoPlayUrl()))
            && (this.getVideoStartTime() == null ? other.getVideoStartTime() == null : this.getVideoStartTime().equals(other.getVideoStartTime()))
            && (this.getVideoEndTime() == null ? other.getVideoEndTime() == null : this.getVideoEndTime().equals(other.getVideoEndTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getVideoId() == null) ? 0 : getVideoId().hashCode());
        result = prime * result + ((getVideoTitle() == null) ? 0 : getVideoTitle().hashCode());
        result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
        result = prime * result + ((getVideoPlayUrl() == null) ? 0 : getVideoPlayUrl().hashCode());
        result = prime * result + ((getVideoStartTime() == null) ? 0 : getVideoStartTime().hashCode());
        result = prime * result + ((getVideoEndTime() == null) ? 0 : getVideoEndTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", videoId=").append(videoId);
        sb.append(", videoTitle=").append(videoTitle);
        sb.append(", operation=").append(operation);
        sb.append(", videoPlayUrl=").append(videoPlayUrl);
        sb.append(", videoStartTime=").append(videoStartTime);
        sb.append(", videoEndTime=").append(videoEndTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}