package com.jn.hr.archives.entity;

import java.io.Serializable;

public class TbManpowerEmployeeFileClass implements Serializable {
    private String classId;

    private String parentId;

    private String nodeName;

    private String level;

    private static final long serialVersionUID = 1L;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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
        TbManpowerEmployeeFileClass other = (TbManpowerEmployeeFileClass) that;
        return (this.getClassId() == null ? other.getClassId() == null : this.getClassId().equals(other.getClassId()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getNodeName() == null ? other.getNodeName() == null : this.getNodeName().equals(other.getNodeName()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassId() == null) ? 0 : getClassId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getNodeName() == null) ? 0 : getNodeName().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", classId=").append(classId);
        sb.append(", parentId=").append(parentId);
        sb.append(", nodeName=").append(nodeName);
        sb.append(", level=").append(level);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}