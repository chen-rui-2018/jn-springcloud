package com.jn.oa.attendance.entity;

import java.io.Serializable;
import java.util.Date;

public class TbOaAttendance implements Serializable {
    private String id;

    private Date modifiedTime;

    private Date signInAttendanceTime;

    private String signInAttendancePlatform;

    private String signInLongitude;

    private String signInLatitude;

    private String signInAttendanceIp;

    private Date signOutAttendanceTime;

    private String signOutAttendancePlatform;

    private String signOutLongitude;

    private String signOutLatitude;

    private String signOutAttendanceIp;

    private String creatorAccount;

    private Date createdTime;

    private String modifierAccount;

    private String attendanceUser;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Date getSignInAttendanceTime() {
        return signInAttendanceTime;
    }

    public void setSignInAttendanceTime(Date signInAttendanceTime) {
        this.signInAttendanceTime = signInAttendanceTime;
    }

    public String getSignInAttendancePlatform() {
        return signInAttendancePlatform;
    }

    public void setSignInAttendancePlatform(String signInAttendancePlatform) {
        this.signInAttendancePlatform = signInAttendancePlatform == null ? null : signInAttendancePlatform.trim();
    }

    public String getSignInLongitude() {
        return signInLongitude;
    }

    public void setSignInLongitude(String signInLongitude) {
        this.signInLongitude = signInLongitude == null ? null : signInLongitude.trim();
    }

    public String getSignInLatitude() {
        return signInLatitude;
    }

    public void setSignInLatitude(String signInLatitude) {
        this.signInLatitude = signInLatitude == null ? null : signInLatitude.trim();
    }

    public String getSignInAttendanceIp() {
        return signInAttendanceIp;
    }

    public void setSignInAttendanceIp(String signInAttendanceIp) {
        this.signInAttendanceIp = signInAttendanceIp == null ? null : signInAttendanceIp.trim();
    }

    public Date getSignOutAttendanceTime() {
        return signOutAttendanceTime;
    }

    public void setSignOutAttendanceTime(Date signOutAttendanceTime) {
        this.signOutAttendanceTime = signOutAttendanceTime;
    }

    public String getSignOutAttendancePlatform() {
        return signOutAttendancePlatform;
    }

    public void setSignOutAttendancePlatform(String signOutAttendancePlatform) {
        this.signOutAttendancePlatform = signOutAttendancePlatform == null ? null : signOutAttendancePlatform.trim();
    }

    public String getSignOutLongitude() {
        return signOutLongitude;
    }

    public void setSignOutLongitude(String signOutLongitude) {
        this.signOutLongitude = signOutLongitude == null ? null : signOutLongitude.trim();
    }

    public String getSignOutLatitude() {
        return signOutLatitude;
    }

    public void setSignOutLatitude(String signOutLatitude) {
        this.signOutLatitude = signOutLatitude == null ? null : signOutLatitude.trim();
    }

    public String getSignOutAttendanceIp() {
        return signOutAttendanceIp;
    }

    public void setSignOutAttendanceIp(String signOutAttendanceIp) {
        this.signOutAttendanceIp = signOutAttendanceIp == null ? null : signOutAttendanceIp.trim();
    }

    public String getCreatorAccount() {
        return creatorAccount;
    }

    public void setCreatorAccount(String creatorAccount) {
        this.creatorAccount = creatorAccount == null ? null : creatorAccount.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifierAccount() {
        return modifierAccount;
    }

    public void setModifierAccount(String modifierAccount) {
        this.modifierAccount = modifierAccount == null ? null : modifierAccount.trim();
    }

    public String getAttendanceUser() {
        return attendanceUser;
    }

    public void setAttendanceUser(String attendanceUser) {
        this.attendanceUser = attendanceUser == null ? null : attendanceUser.trim();
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
        TbOaAttendance other = (TbOaAttendance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()))
            && (this.getSignInAttendanceTime() == null ? other.getSignInAttendanceTime() == null : this.getSignInAttendanceTime().equals(other.getSignInAttendanceTime()))
            && (this.getSignInAttendancePlatform() == null ? other.getSignInAttendancePlatform() == null : this.getSignInAttendancePlatform().equals(other.getSignInAttendancePlatform()))
            && (this.getSignInLongitude() == null ? other.getSignInLongitude() == null : this.getSignInLongitude().equals(other.getSignInLongitude()))
            && (this.getSignInLatitude() == null ? other.getSignInLatitude() == null : this.getSignInLatitude().equals(other.getSignInLatitude()))
            && (this.getSignInAttendanceIp() == null ? other.getSignInAttendanceIp() == null : this.getSignInAttendanceIp().equals(other.getSignInAttendanceIp()))
            && (this.getSignOutAttendanceTime() == null ? other.getSignOutAttendanceTime() == null : this.getSignOutAttendanceTime().equals(other.getSignOutAttendanceTime()))
            && (this.getSignOutAttendancePlatform() == null ? other.getSignOutAttendancePlatform() == null : this.getSignOutAttendancePlatform().equals(other.getSignOutAttendancePlatform()))
            && (this.getSignOutLongitude() == null ? other.getSignOutLongitude() == null : this.getSignOutLongitude().equals(other.getSignOutLongitude()))
            && (this.getSignOutLatitude() == null ? other.getSignOutLatitude() == null : this.getSignOutLatitude().equals(other.getSignOutLatitude()))
            && (this.getSignOutAttendanceIp() == null ? other.getSignOutAttendanceIp() == null : this.getSignOutAttendanceIp().equals(other.getSignOutAttendanceIp()))
            && (this.getCreatorAccount() == null ? other.getCreatorAccount() == null : this.getCreatorAccount().equals(other.getCreatorAccount()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifierAccount() == null ? other.getModifierAccount() == null : this.getModifierAccount().equals(other.getModifierAccount()))
            && (this.getAttendanceUser() == null ? other.getAttendanceUser() == null : this.getAttendanceUser().equals(other.getAttendanceUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        result = prime * result + ((getSignInAttendanceTime() == null) ? 0 : getSignInAttendanceTime().hashCode());
        result = prime * result + ((getSignInAttendancePlatform() == null) ? 0 : getSignInAttendancePlatform().hashCode());
        result = prime * result + ((getSignInLongitude() == null) ? 0 : getSignInLongitude().hashCode());
        result = prime * result + ((getSignInLatitude() == null) ? 0 : getSignInLatitude().hashCode());
        result = prime * result + ((getSignInAttendanceIp() == null) ? 0 : getSignInAttendanceIp().hashCode());
        result = prime * result + ((getSignOutAttendanceTime() == null) ? 0 : getSignOutAttendanceTime().hashCode());
        result = prime * result + ((getSignOutAttendancePlatform() == null) ? 0 : getSignOutAttendancePlatform().hashCode());
        result = prime * result + ((getSignOutLongitude() == null) ? 0 : getSignOutLongitude().hashCode());
        result = prime * result + ((getSignOutLatitude() == null) ? 0 : getSignOutLatitude().hashCode());
        result = prime * result + ((getSignOutAttendanceIp() == null) ? 0 : getSignOutAttendanceIp().hashCode());
        result = prime * result + ((getCreatorAccount() == null) ? 0 : getCreatorAccount().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifierAccount() == null) ? 0 : getModifierAccount().hashCode());
        result = prime * result + ((getAttendanceUser() == null) ? 0 : getAttendanceUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", signInAttendanceTime=").append(signInAttendanceTime);
        sb.append(", signInAttendancePlatform=").append(signInAttendancePlatform);
        sb.append(", signInLongitude=").append(signInLongitude);
        sb.append(", signInLatitude=").append(signInLatitude);
        sb.append(", signInAttendanceIp=").append(signInAttendanceIp);
        sb.append(", signOutAttendanceTime=").append(signOutAttendanceTime);
        sb.append(", signOutAttendancePlatform=").append(signOutAttendancePlatform);
        sb.append(", signOutLongitude=").append(signOutLongitude);
        sb.append(", signOutLatitude=").append(signOutLatitude);
        sb.append(", signOutAttendanceIp=").append(signOutAttendanceIp);
        sb.append(", creatorAccount=").append(creatorAccount);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifierAccount=").append(modifierAccount);
        sb.append(", attendanceUser=").append(attendanceUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}