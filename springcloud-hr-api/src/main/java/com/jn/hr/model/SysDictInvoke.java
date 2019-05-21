package com.jn.hr.model;

/**
 * @author dt
 * @create 2019-04-16 下午 1:00
 */
public class SysDictInvoke {
    private String groupCode;
    private String moduleCode;
    private String parentGroupCode;

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getParentGroupCode() {
        return parentGroupCode;
    }

    public void setParentGroupCode(String parentGroupCode) {
        this.parentGroupCode = parentGroupCode;
    }

    @Override
    public String toString() {
        return "sysDictInvoke{" +
                "groupCode='" + groupCode + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", parentGroupCode='" + parentGroupCode + '\'' +
                '}';
    }
}
