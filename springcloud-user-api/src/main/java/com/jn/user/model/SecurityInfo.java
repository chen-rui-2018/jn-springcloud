package com.jn.user.model;

import java.io.Serializable;

/**
 * 密码规则
 * @Author: huxw
 * @Date: 2019-7-1 11:30:06
 * @Version v1.0
 * @modified By:
 */
public class SecurityInfo implements Serializable {

    private String id;
    private String pk;
    private String isUseComp;
    private String complexity;
    private int minLength;
    private int maxLength;
    private String updTlimit;
    private String timeLimit;
    private String isDefault;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    public String getIsUseComp() {
        return isUseComp;
    }

    public void setIsUseComp(String isUseComp) {
        this.isUseComp = isUseComp;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public String getUpdTlimit() {
        return updTlimit;
    }

    public void setUpdTlimit(String updTlimit) {
        this.updTlimit = updTlimit;
    }

    public String getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(String timeLimit) {
        this.timeLimit = timeLimit;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public String toString() {
        return "SecurityInfo{" +
                "id='" + id + '\'' +
                ", pk='" + pk + '\'' +
                ", isUseComp='" + isUseComp + '\'' +
                ", complexity='" + complexity + '\'' +
                ", minLength=" + minLength +
                ", maxLength=" + maxLength +
                ", updTlimit='" + updTlimit + '\'' +
                ", timeLimit='" + timeLimit + '\'' +
                ", isDefault='" + isDefault + '\'' +
                '}';
    }
}
