package com.jn.system.dict.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据字典实体
 *
 * @author： shaobao
 * @date： Created on 2019/1/25 14:04
 * @version： v1.0
 * @modified By:
 **/
@ApiModel(value = "SysDict", description = "数据字典实体")
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1420445425859080312L;
    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "模块编码")
    private String moduleCode;
    @ApiModelProperty(value = "模块名称")
    private String moduleValue;
    @ApiModelProperty(value = "父分组编码")
    private String parentGroupCode;
    @ApiModelProperty(value = "分组编码")
    private String groupCode;
    @ApiModelProperty(value = "数据字典键")
    private String dictKey;
    @ApiModelProperty(value = "数据字典值")
    private String dictValue;
    @ApiModelProperty(value = "描述")
    private String dictDescribe;
    @ApiModelProperty(value = "排序")
    private Integer sort;
    @ApiModelProperty(value = "创建时间")
    private String createdTime;

    public SysDict() {
    }

    public SysDict(String id, String moduleCode, String moduleValue, String parentGroupCode, String groupCode,
                   String dictKey, String dictValue, String dictDescribe, Integer sort, String createdTime) {
        this.id = id;
        this.moduleCode = moduleCode;
        this.moduleValue = moduleValue;
        this.parentGroupCode = parentGroupCode;
        this.groupCode = groupCode;
        this.dictKey = dictKey;
        this.dictValue = dictValue;
        this.dictDescribe = dictDescribe;
        this.sort = sort;
        this.createdTime = createdTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleValue() {
        return moduleValue;
    }

    public void setModuleValue(String moduleValue) {
        this.moduleValue = moduleValue;
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

    public String getDictKey() {
        return dictKey;
    }

    public void setDictKey(String dictKey) {
        this.dictKey = dictKey;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictDescribe() {
        return dictDescribe;
    }

    public void setDictDescribe(String dictDescribe) {
        this.dictDescribe = dictDescribe;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "SysDict{" +
                "id='" + id + '\'' +
                ", moduleCode='" + moduleCode + '\'' +
                ", moduleValue='" + moduleValue + '\'' +
                ", parentGroupCode='" + parentGroupCode + '\'' +
                ", groupCode='" + groupCode + '\'' +
                ", dictKey='" + dictKey + '\'' +
                ", dictValue='" + dictValue + '\'' +
                ", dictDescribe='" + dictDescribe + '\'' +
                ", sort=" + sort +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
