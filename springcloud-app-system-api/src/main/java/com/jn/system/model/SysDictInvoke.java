package com.jn.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 数据字典调用实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 16:46
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDictInvoke", description = "数据字典调用实体")
public class SysDictInvoke implements Serializable {

    private static final long serialVersionUID = 2790640844508245663L;
    @ApiModelProperty(value = "模块编码")
    private String moduleCode;
    @ApiModelProperty(value = "父分组编码")
    private String parentGroupCode;
    @ApiModelProperty(value = "分组编码")
    private String groupCode;

    @ApiModelProperty(value = "数据字典键")
    private String key;

    public SysDictInvoke() {
    }

    public SysDictInvoke(String moduleCode, String parentGroupCode, String groupCode, String key) {
        this.moduleCode = moduleCode;
        this.parentGroupCode = parentGroupCode;
        this.groupCode = groupCode;
        this.key = key;
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

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "SysDictInvoke{" +
                "moduleCode='" + moduleCode + '\'' +
                ", parentGroupCode='" + parentGroupCode + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
